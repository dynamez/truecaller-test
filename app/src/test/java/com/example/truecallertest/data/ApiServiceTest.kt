// Import statements
import com.example.truecallertest.data.remote.retrofit.ApiService
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.retrofit.adapters.ApiResponseCallAdapterFactory
import kotlinx.coroutines.test.runTest
import java.net.InetAddress
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ApiServiceTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var apiService: ApiService

    @BeforeAll
    fun setup() {
        mockWebServer = MockWebServer()
        // Start the MockWebServer on IPv4 loopback address
        mockWebServer.start(InetAddress.getByName("127.0.0.1"), 0)

        // Get the base URL and replace localhost with 127.0.0.1
        val mockWebServerUrl = mockWebServer.url("/").toString().replace("localhost", "127.0.0.1")
        println("MockWebServer URL: $mockWebServerUrl")

        // Set up OkHttpClient with logging for diagnostics
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        // Create Retrofit instance
        apiService = Retrofit.Builder()
            .baseUrl(mockWebServerUrl)
            .client(client)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @AfterAll
    fun teardown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `fetchContent should return ApiResponse Success`() = runTest {
        // Arrange
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody("Mocked Content")
        mockWebServer.enqueue(mockResponse)

        // Act
        val response = apiService.fetchContent()

        // Diagnostics
        println("Response: $response")

        // Retrieve the request from MockWebServer
        val request = mockWebServer.takeRequest()
        println("Request Path: ${request.path}")

        // Assert
        assertTrue(response is ApiResponse.Success)
    }
}