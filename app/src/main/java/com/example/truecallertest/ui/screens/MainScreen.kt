package com.example.truecallertest.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.designkit.ui.molecule.button.Button
import com.example.truecallertest.R
import com.example.truecallertest.presentation.MainViewModel
import com.example.truecallertest.presentation.model.MainSideEffect
import com.example.truecallertest.presentation.model.Status
import com.example.truecallertest.ui.components.TaskSection
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainViewModel = koinViewModel()) {
    val state by viewModel.container.stateFlow.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.container.sideEffectFlow.collect { sideEffect ->
            when (sideEffect) {
                is MainSideEffect.ShowError -> {
                    Toast.makeText(context, sideEffect.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    val isContentFetched = state.fetchStatus == Status.Success

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Truecaller Test App") })
        },
        content = { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                item {
                    Button(
                        onClick = { viewModel.onFetchContentClicked() },
                        modifier = Modifier.fillMaxWidth(),
                        enabled = state.fetchStatus != Status.Loading,
                        text = stringResource(R.string.fetch_content)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    when (state.fetchStatus) {
                        Status.Loading -> Text(stringResource(R.string.fetching_content))
                        Status.Error -> Text(
                            stringResource(
                                R.string.error_fetching_content,
                                state.errorMessage ?: stringResource(R.string.unknown_error)
                            )
                        )

                        else -> Unit
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                }

                // Task 1
                item {
                    TaskSection(
                        title = stringResource(R.string.task_1_title),
                        status = state.task1Status,
                        enabled = isContentFetched,
                        content = {
                            Text(
                                text = stringResource(
                                    R.string.task_1_content,
                                    state.character15?.toString()
                                        ?: stringResource(R.string.unknown)
                                )
                            )
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                }

                // Task 2
                item {
                    TaskSection(
                        title = stringResource(R.string.task_2_title),
                        status = state.task2Status,
                        enabled = isContentFetched,
                        content = {

                            val itemsPerPage = 15
                            var currentPage = state.task2Page
                            val totalPages =
                                (state.every15thCharacter.size + itemsPerPage - 1) / itemsPerPage

                            val currentItems = state.every15thCharacter
                                .drop(currentPage * itemsPerPage)
                                .take(itemsPerPage)

                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .heightIn(max = 300.dp)
                            ) {
                                LazyColumn {
                                    itemsIndexed(currentItems) { index, character ->
                                        Text(
                                            stringResource(
                                                R.string.index_character,
                                                currentPage * itemsPerPage + index + 1,
                                                character
                                            )
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(8.dp))

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Button(
                                        onClick = { viewModel.onTask2PreviousPageClicked() },
                                        enabled = currentPage > 0,
                                        text = stringResource(R.string.previous)
                                    )

                                    Text(
                                        stringResource(
                                            R.string.page_indicator,
                                            currentPage + 1,
                                            totalPages
                                        )
                                    )

                                    Button(
                                        onClick = { viewModel.onTask2NextPageClicked() },
                                        enabled = currentPage < totalPages - 1,
                                        text = stringResource(R.string.next)
                                    )
                                }
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                }

                // Task 3
                item {
                    TaskSection(
                        title = stringResource(R.string.task_3_title),
                        status = state.task3Status,
                        enabled = isContentFetched,
                        content = {

                            val itemsPerPage = 15
                            var currentPage = state.task3Page
                            val totalPages =
                                (state.wordCount.size + itemsPerPage - 1) / itemsPerPage

                            val currentItems = state.wordCount
                                .drop(currentPage * itemsPerPage)
                                .take(itemsPerPage)

                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .heightIn(max = 300.dp)
                            ) {
                                LazyColumn {
                                    items(currentItems) { (word, count) ->
                                        Text("$word: $count")
                                    }
                                }

                                Spacer(modifier = Modifier.height(8.dp))

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Button(
                                        onClick = { viewModel.onTask3PreviousPageClicked() },
                                        enabled = currentPage > 0,
                                        text = stringResource(R.string.previous)
                                    )

                                    Text(
                                        stringResource(
                                            R.string.page_indicator,
                                            currentPage + 1,
                                            totalPages
                                        )
                                    )

                                    Button(
                                        onClick = { viewModel.onTask3NextPageClicked() },
                                        enabled = currentPage < totalPages - 1,
                                        text = stringResource(R.string.next)
                                    )
                                }
                            }
                        }
                    )
                }
            }
        }
    )
}
