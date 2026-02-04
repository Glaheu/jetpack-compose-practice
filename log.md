## [2026-01-29] Day 1: Kotlin Syntax Foundations

**Resources:** [Typealias: Variables](https://typealias.com/start/kotlin-variables-expressions-types/), [Functions](https://typealias.com/start/kotlin-functions/), [Conditionals](https://typealias.com/start/kotlin-conditionals/)

### 🛠️ Technical Implementation
* **Variable Declarations:** Mastered the distinction between `val` (read-only/immutable) and `var` (mutable), focusing on when to use each for memory safety.
* **Expression-Oriented Programming:** Explored how Kotlin treats `if` and `when` as expressions that return values, reducing boilerplate compared to Java.
* **Function Signatures:** Practiced declaring functions with parameters, return types, and default arguments to write reusable code blocks.
* **Control Flow:** Implemented complex logic using `when` blocks as a more powerful, readable alternative to `switch` statements.

### 🧠 Key Takeaways
* **Type Inference:** Learned how the Kotlin compiler infers types, allowing for cleaner code without sacrificing type safety.
* **Logic Efficiency:** Understood that "everything is an expression" allows for more concise and functional-style code.

### 📈 Progress Tracking
* **Time Invested:** 3 hours
* **Phase:** 1 (Kotlin Fundamentals)
* **Goal Alignment:** Establishing the core syntax required for high-performance Android development.

---

## [2026-01-30] Day 2: OOP & Declarative UI Basics

**Pathway:** Android Basics in Compose - Unit 1, Pathway 3
**Resources:** [Typealias: Classes](https://typealias.com/start/kotlin-classes-and-objects/), [Enums](https://typealias.com/start/kotlin-enum-classes/), [Codelab: Text](https://developer.android.com/codelabs/basic-android-kotlin-compose-text-composables), [Codelab: Images](https://developer.android.com/codelabs/basic-android-kotlin-compose-add-images)

### 🛠️ Technical Implementation
* **Object-Oriented Kotlin:** Defined classes, properties, and constructors. Utilized `enum` classes to represent a fixed set of constants.
* **Composable Functions:** Built basic UI components using `@Composable` annotations, focusing on the "Happy Birthday" app.
* **Layout Basics:** Experimented with standard layout components: `Row`, `Column`, and `Box` to position text elements.
* **Resource Handling:** Integrated local images using the `Image` composable and handled `Painter` resources and `ContentDescription` for accessibility.

### 🧠 Key Takeaways
* **Declarative vs. Imperative:** Realized how Compose describes *what* the UI should look like rather than *how* to change it.
* **Modularity:** Understood how small, reusable composables are the building blocks of modern Android architecture.

### 📈 Progress Tracking
* **Time Invested:** 6 hours
* **Phase:** 1 (OOP & Compose Intro)
* **Goal Alignment:** Transitioning from pure logic to visual implementation on the Android platform.

---

## [2026-01-31] Day 3: Advanced Data & Functional Kotlin

**Resources:** [Typealias: Nulls](https://typealias.com/start/kotlin-nulls/), [Lambdas](https://typealias.com/start/kotlin-lambdas/), [Collections](https://typealias.com/start/kotlin-collections/), [Maps](https://typealias.com/start/kotlin-maps/), [Kotlin Docs: Scope Functions](https://kotlinlang.org/docs/scope-functions.html#takeif-and-takeunless)

### 🛠️ Technical Implementation
* **Null Safety:** Implemented defensive programming using safe calls (`?.`), the Elvis operator (`?:`), and the not-null assertion operator (`!!`).
* **Higher-Order Functions:** Wrote and utilized Lambdas, exploring trailing lambda syntax—a staple in Jetpack Compose development.
* **Data Structures:** Deep dive into Kotlin Collections API: `List`, `Set`, and `Map`, focusing on immutability by default.
* **Scope Utility:** Applied `takeIf` and `takeUnless` to create more fluent, readable conditional chains.

### 🧠 Key Takeaways
* **Crash Prevention:** Understood how Kotlin’s type system eliminates the "Billion Dollar Mistake" (NullPointerExceptions).
* **Functional Thinking:** Learned how passing functions as arguments (lambdas) enables the powerful "Slot API" pattern used in Compose.

### 📈 Progress Tracking
* **Time Invested:** 6 hours
* **Phase:** 1 (Kotlin Advanced)
* **Goal Alignment:** Mastering data manipulation, crucial for the "Google Wallet" scale of data handling.

---

## [2026-02-01] Day 4: Extensions & User Interaction

**Pathway:** Android Basics in Compose - Unit 2, Pathway 2
**Resources:** [Typealias: Extensions](https://typealias.com/start/kotlin-receivers-and-extensions/), [Codelab: Dice Roller](https://developer.android.com/codelabs/basic-android-kotlin-compose-build-a-dice-roller-app), [Revision: Lambdas](https://typealias.com/start/kotlin-lambdas/)

### 🛠️ Technical Implementation
* **Extension Functions:** Learned to add functionality to existing classes without inheritance using `fun Receiver.name()` syntax.
* **Interactive UI:** Built a "Dice Roller" app that updates the UI based on user interaction (Button clicks).
* **Logic Integration:** Used `MutableState` and `random()` to link business logic (rolling a die) to the UI layer.
* **Lambda Refinement:** Conducted a deep-dive revision of Lambdas to understand how `onClick` handlers capture and process data.

### 🧠 Key Takeaways
* **Clean Code:** Extension functions allow for a more "Architect-level" code organization by keeping core classes slim.
* **State Awareness:** First encounter with how Compose "recomposes" or redraws the screen when data changes.

### 📈 Progress Tracking
* **Time Invested:** 5 hours
* **Phase:** 1 (Kotlin & Interactive Basics)
* **Goal Alignment:** Building logic-heavy components that react to user inputs in real-time.

---

## [2026-02-02] Day 5: Reactive State & Interface Contracts

**Pathway:** Android Basics in Compose - Unit 2, Pathway 3
**Resources:** [Codelab: Using State](https://developer.android.com/codelabs/basic-android-kotlin-compose-using-state), [Typealias: Scopes](https://typealias.com/start/kotlin-scopes-and-scope-functions/#statement-scope), [Interfaces](https://typealias.com/start/kotlin-interfaces/)

### 🛠️ Technical Implementation
* **State Management:** Implemented the Tip Calculator app using `remember` and `mutableStateOf` to persist values across recompositions.
* **State Hoisting:** Applied "State Hoisting" patterns to move state from a composable to its caller, making components more testable and stateless.
* **Abstraction with Interfaces:** Defined `interface` contracts to decouple implementation details from the rest of the application.
* **Scope Mastery:** Analyzed statement vs. declaration scope to better understand variable visibility and memory lifecycle.

### 🧠 Key Takeaways
* **Single Source of Truth:** Learned that state should live at the highest common parent to maintain UI consistency.
* **Polymorphism:** Interfaces are the foundation of "Architect Lead" level design patterns (like Repository or Factory patterns).

### 📈 Progress Tracking
* **Time Invested:** 6 hours
* **Phase:** 1 (Architecture Foundations)
* **Goal Alignment:** Deepening knowledge of state—the most critical part of complex apps like Google Wallet.

## [2026-02-03] Day 6: Data Modeling & Reactive State Management

**Pathway:** Android Basics in Compose - Unit 2, Pathway 3 (Extended)
**Resources:** [Kotlin Data Classes](https://kotlinlang.org/docs/data-classes.html), [Compose State & Hoisting](https://developer.android.com/codelabs/basic-android-kotlin-compose-using-state)

### 🛠️ Technical Implementation
* **Immutable Data Modeling:** Mastered the use of `data class` and the `.copy()` function. Practiced updating state by creating new instances rather than mutating existing ones.
* **Functional Collection Pipelines:** Chained operators like `.filter`, `.map`, and `.forEach`. Solved a "Type Trap" bug where I attempted to access properties after a type transformation in the pipeline.
* **Advanced Compose Components:** Integrated `TextField` for user input and `Switch` for toggling logic, linking them to reactive state.
* **State Hoisting & Architecture:** Refactored composables to be "stateless" by extracting state to a parent level. Implemented the "State Down, Events Up" pattern.

### 🧠 Key Takeaways
* **The Lead Mindset (Immutability):** Using `.copy()` is a safety requirement for financial apps like Google Wallet; it prevents race conditions and ensures the UI and Logic are never out of sync.
* **Unidirectional Data Flow (UDF):** Understood that UDF makes the code more predictable. By keeping composables stateless, they become 100% reusable and significantly easier to unit test.
* **Pipeline Awareness:** Realized the importance of tracking object types throughout a transformation stream to avoid runtime crashes.

### 🛠 Challenges / Bug Squash
* **Recomposition Loops:** Initially misplaced `mutableStateOf`, causing unnecessary redraws. 
* *Fix:* Hoisted the state to the caller, ensuring a single source of truth and stabilized recomposition.

### 📈 Progress Tracking
* **Time Invested:** 2 hours
* **Phase:** 1 (Architecture Foundations)
* **Goal Alignment:** Building scalable, testable UI patterns used in Singapore’s top-tier engineering teams.


## [2026-02-04] Day 7: Building Scrollable Grids

**Pathway:** Android Basics in Compose - Unit 3, Pathway 2
**Codelab:** [Practice: Build a Grid](https://developer.android.com/codelabs/basic-android-kotlin-compose-practice-grid)

### 🛠️ Technical Implementation
* **Lazy Layouts:** Mastered both `LazyColumn` (for the Affirmations app) and `LazyVerticalGrid` (for the Courses app).
* **Data Class Construction:** Defined a `Topic` data class to handle multi-type data (String Resource ID, Int for course count, and Drawable Resource ID).
* **LazyVerticalGrid:** Implemented a responsive grid using `GridCells.Fixed(2)` to display content in a dual-column format.
* **Composable Composition:** * Used `Card` as a container for elevation and shaping.
    * Combined `Row` and `Column` to align the topic image with its metadata.
* **Resource Management:** Integrated string and drawable resources via `painterResource` and `stringResource`.

### 🧠 Key Takeaways
* **UI Specs:** Learned to translate specific design requirements (DP spacing, typography styles) into Compose Modifiers.
* **Iteration:** Practiced the workflow of building a single item component first, then populating it into a lazy layout.

### 📈 Progress Tracking
* **Time Invested:** 4 hours
* **Phase:** 1 (Kotlin Fundamentals & Android Basics)
* **Goal Alignment:** Strengthening UI layout fundamentals required for Junior/Intern roles in Singapore.
