# TrueCaller Content Analyzer

**TrueCaller Content Analyzer** is an Android application designed to fetch and analyze the content of a specified website. Upon loading the content, the app performs three distinct tasks in parallel and displays their results in real-time:

1. **Retrieve the 15th Character**: Extracts the 15th character from the text.
2. **Retrieve Every 15th Character**: Extracts every 15th character (i.e., 15th, 30th, 45th, etc.) from the text.
3. **Word Count Analysis**: Splits the text by whitespace, counts the occurrence of each unique word (case-insensitive), and displays the results.

## Table of Contents

- [Features](#features)
- [Libraries Used](#libraries-used)
  - [Orbit](#orbit)
  - [Sandwich](#sandwich)
  - [Koin](#koin)
  - [Internal Design Kit Module](#internal-design-kit-module)
- [Design Principles](#design-principles)
  - [Unidirectional Data Flow (UDF) Principle](#unidirectional-data-flow-udf-principle)
- [Assumptions & Shortcuts](#assumptions-shortcuts)
- [Future Enhancements](#future-enhancements)
-

## Features

- **Load Website Content**: Fetches plain text content from a specified URL.
- **15th Character Retrieval**: Identifies and displays the 15th character in the text.
- **Every 15th Character Retrieval**: Extracts and displays every 15th character from the text.
- **Word Count Analysis**: Splits the text by whitespace, counts the occurrence of each unique word (case-insensitive), and displays the results.
- **Parallel Processing**: Executes all three tasks simultaneously to optimize performance.
- **Real-time Results Display**: Shows the results of each task on the screen immediately after completion.

## Libraries Used

### Orbit

- **Description**: Orbit MVI is a Kotlin-based Model-View-Intent framework that facilitates state management and unidirectional data flow within Android applications.

- **Usage in Project**: Utilized for managing the app's UI state and handling events in a reactive and organized manner. Orbit ensures a clear separation of concerns, enhancing maintainability and scalability by enforcing a structured approach to state management and event handling.

### Sandwich

- **Description**: Sandwich is a Kotlin networking library that provides a clean and straightforward way to handle API responses, simplifying error handling and response parsing.

- **Usage in Project**: Employed for making network requests to fetch the content of the specified website. Sandwich streamlines the process of handling different network response scenarios, enabling robust and efficient data retrieval while minimizing boilerplate code.

### Koin

- **Description**: Koin is a lightweight dependency injection framework for Kotlin developers. It provides a pragmatic and easy-to-use approach to dependency injection without the need for code generation or reflection.

- **Usage in Project**: Integrated to manage dependencies across the application. Koin simplifies the provisioning and lifecycle management of components like use cases and network services, promoting modularity and testability.

### Internal Design Kit Module

- **Description**: The Internal Design Kit module contains reusable components, utilities, and extensions that enhance the development process and maintain consistency across projects. Only The button component is used in this project.
- **Usage in Project**: Utilized the button component to create a custom button style that aligns with the project's design guidelines. This module promotes code reusability and ensures a consistent user interface experience.

## Design Principles

### Unidirectional Data Flow (UDF) Principle

- **Definition**: The Unidirectional Data Flow (UDF) principle ensures that data flows in a single, predictable direction throughout the application. This approach enhances the application's reliability, maintainability, and testability by simplifying state management and reducing potential side effects.

- **Implementation in Project**:

  - **State Management with Orbit**: Leveraged Orbit MVI to enforce a unidirectional flow of data. User interactions and events are processed through intents, leading to state updates that the UI observes and reacts to. This ensures that the data flow remains predictable and manageable.

  - **Separation of Concerns**: By adhering to UDF, the project maintains a clear separation between data handling, business logic, and UI rendering. This modularity allows for easier maintenance and scalability as the application grows.

  - **Immutable State**: Utilized immutable state representations to prevent unintended modifications, ensuring that each state change is deliberate and traceable.

  - **Single Source of Truth**: Established a centralized state repository that serves as the single source of truth for the application's UI state, eliminating inconsistencies and simplifying state synchronization across different components.

- **Benefits**:

  - **Predictability**: With data flowing in one direction, the application's behavior becomes more predictable, making it easier to understand and reason about.

  - **Maintainability**: Clear data flow and separation of concerns facilitate easier code maintenance and updates, as changes in one part of the system have minimal impact on others.

  - **Testability**: Simplified state management and predictable data flow enhance the ability to write effective unit and integration tests, ensuring higher code quality and reliability.

  - **Scalability**: The structured approach to data flow and state management supports the application's growth, allowing it to handle increased complexity without significant architectural overhauls.

  - **Debugging Efficiency**: Tracing data flow and state changes becomes more straightforward, aiding in faster identification and resolution of issues.

---

*This section outlines the key libraries integrated into the TrueCaller Content Analyzer project and explains how the implementation adheres to the Unidirectional Data Flow (UDF) principle, ensuring a robust and maintainable application architecture.*
## Assumptions & Shortcuts

- **Content as Plain Text**: The application treats the website content as plain text without parsing HTML tags or handling embedded media.

- **Punctuation & Symbols Handling**:
  - For `GetWordCountUseCase`, punctuation and symbols are **retained** as part of words. This means words like `"hello,"`, `"Truecaller"`, and `"</p>"` are treated as distinct entries.
  - Numbers and symbols within words (e.g., `"@test"`, `"#test"`) are included in the word counts.

- **Character Indexing**: The 15th character is retrieved using 0-based indexing (`content[14]`).

- **Error Handling**: Basic checks are in place (e.g., returning `null` if the input is too short), but extensive error handling (such as network failures) is not covered in the current scope.

- **Concurrency**: Tasks are executed in parallel using Kotlin coroutines to optimize performance, assuming that the underlying architecture supports coroutine scopes and dispatchers appropriately.

## Future Enhancements

- **HTML Content Parsing**: Implement HTML parsing to accurately extract and analyze meaningful text content from the website.

- **Enhanced Punctuation Handling**: Introduce preprocessing steps to remove or handle punctuation and symbols in `GetWordCountUseCase` based on user requirements.

- **User Interface Improvements**: Enhance the UI to provide a more intuitive and visually appealing display of results, possibly using RecyclerViews or custom views.

- **Error Handling & Notifications**: Incorporate comprehensive error handling mechanisms and user notifications for network issues or unexpected failures.

- **Additional Analytics**: Expand the app's capabilities to include more complex text analytics, such as sentiment analysis or keyword extraction.

- **Performance Optimization**: Optimize coroutine usage and memory management for handling larger texts efficiently.