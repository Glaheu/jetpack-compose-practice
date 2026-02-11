## [2026-01-29] Day 1: Kotlin Syntax Foundations

**Resources:** [Typealias: Variables](https://typealias.com/start/kotlin-variables-expressions-types/), [Functions](https://typealias.com/start/kotlin-functions/), [Conditionals](https://typealias.com/start/kotlin-conditionals/)

### 🛠️ Technical Implementation
* **Variable Declarations:** Learnt the distinction between `val` (read-only/immutable) and `var` (mutable), focusing on when to use each for memory safety.
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
* **Goal Alignment:** Learning data manipulation.

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
* **Goal Alignment:** Deepening knowledge of states.

---

## [2026-02-03] Day 6: Data Modeling & Reactive State Management

**Pathway:** Android Basics in Compose - Unit 2, Pathway 3 (Extended)
**Resources:** [Kotlin Data Classes](https://kotlinlang.org/docs/data-classes.html), [Compose State & Hoisting](https://developer.android.com/codelabs/basic-android-kotlin-compose-using-state)

### 🛠️ Technical Implementation
* **Immutable Data Modeling:** Learnt the use of `data class` and the `.copy()` function. Practiced updating state by creating new instances rather than mutating existing ones.
* **Functional Collection Pipelines:** Chained operators like `.filter`, `.map`, and `.forEach`. Solved a "Type Trap" bug where I attempted to access properties after a type transformation in the pipeline.
* **Advanced Compose Components:** Integrated `TextField` for user input and `Switch` for toggling logic, linking them to reactive state.
* **State Hoisting & Architecture:** Refactored composables to be "stateless" by extracting state to a parent level. Implemented the "State Down, Events Up" pattern.

### 🧠 Key Takeaways
* **The Lead Mindset (Immutability):** Using `.copy()` is a safety requirement; it prevents race conditions and ensures the UI and Logic are never out of sync.
* **Unidirectional Data Flow (UDF):** Understood that UDF makes the code more predictable. By keeping composables stateless, they become 100% reusable and significantly easier to unit test.
* **Pipeline Awareness:** Realized the importance of tracking object types throughout a transformation stream to avoid runtime crashes.

### 🛠 Challenges / Bug Squash
* **Recomposition Loops:** Initially misplaced `mutableStateOf`, causing unnecessary redraws. 
* *Fix:* Hoisted the state to the caller, ensuring a single source of truth and stabilized recomposition.

### 📈 Progress Tracking
* **Time Invested:** 2 hours
* **Phase:** 1 (Architecture Foundations)
* **Goal Alignment:** Building testable patterns

---

## [2026-02-04] Day 7: Building Scrollable Grids & Kotlin Deep Dive

**Pathway:** Android Basics in Compose - Unit 3, Pathway 2
**Codelab:** [Practice: Build a Grid](https://developer.android.com/codelabs/basic-android-kotlin-compose-practice-grid)
**Kotlin Resource:** [Abstract and Open Classes](https://typealias.com/start/kotlin-abstract-and-open-classes/)

### 🛠️ Technical Implementation
* **Lazy Layouts:** Learnt both `LazyColumn` (for the Affirmations app) and `LazyVerticalGrid` (for the Courses app).
* **Data Class Construction:** Defined a `Topic` data class to handle multi-type data (String Resource ID, Int for course count, and Drawable Resource ID).
* **LazyVerticalGrid:** Implemented a responsive grid using `GridCells.Fixed(2)` to display content in a dual-column format.
* **Composable Composition:** Combined `Card`, `Row`, and `Column` to align the topic image with its metadata.
* **Abstract & Open Classes:**
    * Used `abstract` for base classes that shouldn't be instantiated.
    * Used `open` to allow inheritance and overriding (since Kotlin classes are `final` by default).
    * Applied `protected` visibility to allow subclasses to modify internal state (e.g., `batteryLevel`) while keeping it encapsulated.

### 🧠 Key Takeaways
* **UI Specs:** Learned to translate specific design requirements (DP spacing, typography styles) into Compose Modifiers.
* **Iteration:** Practiced the workflow of building a single item component first, then populating it into a lazy layout.
* **Inheritance Logic:** Understood that abstract classes can hold state (`var`/`val`), which distinguishes them from Interfaces in Kotlin.

### 📈 Progress Tracking
* **Time Invested:** 5 hours
* **Phase:** 1 (Kotlin Fundamentals & Android Basics)
* **Goal Alignment:** Strengthening UI layout fundamentals.

---

## [2026-02-05] Day 8: Material Theming & Data Structures

**Pathway:** Android Basics in Compose - Unit 3, Pathway 3
**Codelab:** [Material Theming with Jetpack Compose](https://developer.android.com/codelabs/basic-android-kotlin-compose-material-theming)
**Kotlin Resource:** [Data Classes and Destructuring](https://typealias.com/start/kotlin-data-classes-and-destructuring/)

### 🛠️ Technical Implementation
* **Material Design 3 (M3):** Integrated a comprehensive design system using `MaterialTheme`, focusing on the three pillars: `colorScheme`, `typography`, and `shapes`.
* **Dynamic Color & Theming:** Implemented dark theme support and customized the `Color.kt` and `Theme.kt` files to ensure UI consistency across different device settings.
* **Data Classes:** Leveraged `data class` for model layers to benefit from auto-generated `equals()`, `hashCode()`, and `copy()` functions.
* **Destructuring:** Practiced destructuring declarations to unpack data class properties into separate variables efficiently (e.g., `val (name, age) = dog`).
* **OOP Inheritance Reinforcement:** * Reinforced that `abstract` classes serve as incomplete blueprints that *must* be extended.
    * Used `open` to explicitly opt-out of Kotlin's default `final` class behavior, allowing for controlled inheritance and method overriding.

### 🧠 Key Takeaways
* **Design Consistency:** Understood how to use `MaterialTheme.colorScheme.primary` instead of hardcoded hex values to maintain a professional, adaptable UI.
* **Boilerplate Reduction:** Recognized how `data classes` simplify data handling in Kotlin, making the codebase cleaner and more maintainable for large-scale projects.
* **Visual Hierarchy:** Used `clip()` and `MaterialTheme.shapes` to transform standard images into rounded UI elements consistent with modern Android standards.

### 📈 Progress Tracking
* **Time Invested:** 6 hours
* **Phase:** 1 (Kotlin Fundamentals & Android Basics)
* **Goal Alignment:** Learaning Material 3 and clean data modeling.

---

## [2026-02-06] Day 9: State Management & Collection Manipulation

**Pathway:** Android Basics in Compose - Unit 3 (Custom Projects)
**Projects:** Lion City Wallet & Makan Splitter
**Kotlin Resource:** [List Transformations and Copying](https://kotlinlang.org/docs/data-classes.html#copying)

### 🛠️ Technical Implementation
* **State Hoisting & Callbacks:** Implemented state hoisting in "Makan Splitter" by moving `orderList` to the top-level Composable and passing lambda functions (`onIncrement`, `onDecrement`) down to child components.
* **Immutable State Updates:** Learnt the pattern of updating lists in Compose using `.map { ... }` combined with the `.copy()` function to create new object instances, ensuring the UI recomposes correctly.
* **Filtering Logic:** Built a dynamic filtering system for "Lion City Wallet" where selecting a card type updates the `LazyColumn` to show only relevant transactions or returns to a full list view.
* **Destructuring in Loops:** Utilized destructuring declarations within `items` blocks (e.g., `val (merchant, amount, category, card) = transaction`) to keep Composable code clean and readable.
* **Material 3 Navigation & Layouts:**
    * Implemented `CenterAlignedTopAppBar` with custom typography.
    * Used `Scaffold` to manage inner padding and layout structure.
    * Leveraged `LazyRow` for a horizontal card selector and `LazyColumn` for vertical lists.

### 🧠 Key Takeaways
* **Unidirectional Data Flow:** Reinforced the concept that state flows down (to cards) and events flow up (to the main app state), a critical architecture requirement for high-level software engineering roles.
* **Recomposition Triggers:** Learned that Compose tracks state by object identity; updating a property inside a list item requires a new list reference for the UI to "see" the change.
* **UI Flexibility:** Practiced using `Arrangement.SpaceBetween` and `fillMaxWidth()` to create professional-looking, responsive list items that mimic real-world financial apps.

### 📈 Progress Tracking
* **Time Invested:** 4 hours
* **Phase:** 1 (Kotlin Fundamentals & Android Basics)
* **Goal Alignment:** Practicing mini projects (Wallet/Splitter) to sharpen my jetpack compose skills.

---

## [2026-02-07] Day 10: Lifecycle, Sealed Classes & Feature Completion

**Pathway:** Android Basics in Compose - Unit 3 (Custom Projects)
**Projects:** Makan Splitter (Feature Complete)
**Kotlin Resource:** [Sealed Types - Typealias](https://typealias.com/start/kotlin-sealed-types/)

### 🛠️ Technical Implementation
* **State Management:** Finalized `orderList` logic in "Makan Splitter". Implemented `incrementQuantity` and `decrementQuantity` using `.map { ... .copy() }` to trigger UI recomposition through object identity changes.
* **Derived State & Logic:** Built a `BottomSummary` component that dynamically calculates subtotal, GST (9%), and total price using functional transformations (`filter` and `sumOf`).
* **Extension Functions:** Created a local `roundUp()` extension function for `Double` to handle currency formatting within the summary view.
* **Layout Orchestration:** Used `Scaffold` with a `weight(1f)` modifier on the `LazyColumn` to ensure the summary box stays pinned to the bottom while the list remains scrollable.

### 🧠 Key Takeaways
* **Sealed Classes/Interfaces:** Learned that sealed types represent restricted class hierarchies. Unlike Enums, subclasses can hold unique state, making them perfect for representing UI states like `Success(data)` or `Error(message)`.
* **Activity Lifecycle:** Studied the sequence of `onCreate`, `onStart`, `onResume`, `onPause`, `onStop`, and `onDestroy`. Essential for understanding how the OS handles process death and configuration changes.
* **UI Flexibility:** Learnt the use of `Shape` and `Background` modifiers to create a "Bottom Sheet" feel for the summary section, aligning with modern Fintech UI patterns.

### 📈 Progress Tracking
* **Time Invested:** 4 hours
* **Phase:** 1 (Kotlin Fundamentals & Android Basics)
* **Goal Alignment:** Completed "Makan Splitter" logic; solidified UDF within the screen

---

## [2026-02-08] Day 11: ViewModels, StateFlow & Unit Testing

**Pathway:** Android Basics in Compose - Unit 4 (Architecture & Testing)
**Kotlin Resource:** [JUnit 4 Documentation](https://junit.org/junit4/) / [Android ViewModel Guide](https://developer.android.com/topic/libraries/architecture/viewmodel)

### 🛠️ Technical Implementation
* **ViewModel Implementation:** Explored the ViewModel as the "brain" of the app. Shifted logic away from the UI layer to handle business rules (e.g., score calculation and word validation).
* **UiState Observation:** Leveraged `StateFlow` to expose a single source of truth. The UI now acts as a passive observer of the state snapshot.
* **Unit Testing (JUnit 4):** Wrote a test suite for `GameViewModel`. 
    * Used `assertFalse` to verify error flag resets and `assertEquals` to validate scoring logic.
* **State Verification:** Focused on testing the "Happy Path"—ensuring that a correct user guess properly updates the score and transitions the state correctly.

### 🧠 Key Takeaways
* **Source of Truth:** The ViewModel survives configuration changes (like rotation) and holds the app logic, while the `UiState` describes exactly what the user sees at any given moment.
* **Testable Architecture:** Separation of concerns (Logic vs. UI) is what makes Unit Testing possible. Testing the "brain" without the "face" (UI) makes for faster, more reliable builds.
* **Naming Conventions:** Adopted the `unit_condition_expectedResult` naming pattern for test functions to ensure clarity in test reports.

### 📈 Progress Tracking
* **Time Invested:** 3 hours
* **Phase:** 1 (Kotlin Fundamentals & Android Basics)
* **Goal Alignment:** Grasping the concept of ViewModels; Starting to practice how ViewModels work.

### 🎯 Objective for Tomorrow
* Focus on how ViewModels work and implement them in 2 practice apps to solidify the implementation pattern.

---

## [2026-02-09] Day 12: Advanced State Logic & Logic-Driven ViewModels

**Pathway:** Android Basics in Compose - Unit 4 (Architecture & Testing)
**Kotlin Resource:** [State in Jetpack Compose](https://developer.android.com/develop/ui/compose/state) / [ViewModel & StateFlow](https://developer.android.com/topic/libraries/architecture/viewmodel)

### 🛠️ Technical Implementation
* **Derived State Optimization:** Learnt the use of `get()` properties in `UiState` for automatic calculations (`subtotal`, `tax`, `currentPowerUsage`, `totalProfitLoss`). This ensures the UI never performs manual math and relies on a "Single Source of Truth."
* **Immutable List Manipulation:** * Implemented item updates using `.map { if (match) copy() else it }` to ensure thread-safe state transitions and trigger Recomposition.
    * Utilized `.filter { }` for dynamic item removal while maintaining state immutability.
* **Architectural Hardening:**
    * **Conditional Guarding:** Implemented logic gates to block actions (e.g., Power Budgeting in Smart Home) before state updates occur.
    * **Qualified Returns:** Utilized `return@update` for early-exit logic to handle null safety and invalid user actions gracefully.
    * **Bulk & Multi-Property Updates:** Developed functions to update multiple objects or multiple properties within an object (e.g., `splitStock` logic halving price while doubling shares) without losing data integrity.

### 🧠 Key Takeaways
* **The "Copy" Rule:** Solidified the understanding that modifying an object's property directly (mutation) will not trigger a UI refresh. Replacing the entire state object via `copy()` is mandatory for Compose.
* **Functional Programming:** Shifted from manual iteration to functional operators like `.any`, `.sumOf`, `.count`, and `.find` for cleaner, self-documenting code.
* **Logic vs. Side Effects:** Learned to handle state changes by calculating the *next* possible state rather than modifying the current one, a core principle for high-reliability apps.

### 📈 Progress Tracking
* **Time Invested:** 8 hours
* **Phase:** 1 (Kotlin Fundamentals & Android Basics)
* **Goal Alignment:** Completed **7 distinct ViewModel implementations**:
    1. *Dessert Clicker* (State Migration/Refactoring)
    2. *Laundry Timer* (Simple Counters)
    3. *Gym Leveler* (Threshold & Rank Logic)
    4. *Library Portal* (Conditional Guards)
    5. *Coffee Shop POS* (Complex List Manipulation)
    6. *Smart Home Manager* (Bulk Updates & Power Budgeting)
    7. *Stock Portfolio Tracker* (Multi-Property Updates & Financial Logic)

    ---
    
## [2026-02-10] Day 13: Type-Safe Navigation & Shared ViewModel Scoping

**Pathway:** Android Basics in Compose - Unit 4 (Navigation) / Modern Android Development (MAD)
**Kotlin Resource:** [Navigation with Compose](https://developer.android.com/develop/ui/compose/navigation) / [Type-Safe Navigation Guide](https://developer.android.com/guide/navigation/design/type-safety)

### 🛠️ Technical Implementation
* **Type-Safe Route Architecture:** * Pivoted from legacy String-based routing to **Kotlin Serialization**.
    * Defined routes using `@Serializable` objects for static screens (`PassList`) and `data class` for parameterized destinations (`PassDetails`).
* **Navigation Backstack Management:**
    * Learnt the use of `backStackEntry.toRoute<T>()` to unpack complex arguments without manual key-string mapping.
    * Implemented standard back-navigation using `navController.popBackStack()` to maintain a clean history.
* **Shared ViewModel Pattern:**
    * Scoped a single `PassViewModel` instance to the `NavHost` level, allowing seamless state sharing between the Wallet List and the Detail View.
    * Ensured that data modifications (e.g., "Top Up" actions) on a detail screen are immediately reflected in the parent list without result-passing boilerplate.
* **UI Resilience & Debugging:**
    * **Namespace Collision Handling:** Resolved conflicts between Route classes and Composable functions by adopting the `...Screen` suffix convention.
    * **Null-Safety Guarding:** Implemented early-exit checks for `.find` operations to handle edge cases where a navigation ID might not match the current state.
    * **Modifier Scoping:** Fixed layout "jank" caused by incorrect modifier inheritance (chaining `fillMaxSize` in nested children).

### 🧠 Key Takeaways
* **Compile-Time Safety:** Realized that Type-Safe navigation catches errors (like missing parameters) at build time, preventing the runtime crashes common in older "String-template" navigation styles.
* **Identity Separation:** Learned that the Navigation "Ticket" (the Route class) is separate from the "Destination" (the Screen Composable).
* **State Synchronization:** Solidified the understanding of a **Single Source of Truth**; when screens share a ViewModel, navigation becomes a simple lens into the same underlying data.

### 📈 Progress Tracking
* **Time Invested:** 5 hours
* **Phase:** 2 (Android Basics with Compose & Architecture)
* **Goal Alignment:** * Completed **Campus Pass Manager**
    * Successfully migrated from the official "Cupcake" tutorial logic to the 2026 industry-standard Type-Safe approach.

---

## [2026-02-11] Day 14: Advanced State Management & Scaffold Architecture

**Pathway:** Android Basics in Compose - Unit 4 (Pathway 2)
**Codelab:** [Practice: Navigation in Jetpack Compose](https://developer.android.com/codelabs/basic-android-kotlin-compose-practice-navigation)

### 🛠️ Technical Implementation
* **Composite UI Layout:**
    * Built a **Dashboard Screen** that integrates a horizontal category filter (`LazyRow`) and a vertical transaction history (`LazyColumn`).
    * Optimized performance by nesting the `LazyRow` inside a `LazyColumn` item block, preventing the common "Infinite Height" crash associated with nested scrollable components.
* **Scaffold & Inset Mastery:**
    * Resolved issues with missing `TopAppBar` and `FloatingActionButton` by correctly hoisting the `innerPadding` from the `Scaffold` to the `NavigationHost`.
* **Robust Input Validation:**
    * Engineered a "String-First" state pattern for the **Add Transaction Screen** to solve the "decimal backspace" bug and cursor jumping.
    * Implemented numeric validation using `toDoubleOrNull()` and character filtering to prevent `NumberFormatException` crashes during text entry.
* **Component-Level Design:**
    * Utilized `FilterChip` components to manage a dynamic `Set<Category>` within the `UiState`.
    * Refactored `TransactionCard` to use `Modifier.weight()` for text wrapping, ensuring long transaction names do not push prices off-screen.

### 🧠 Key Takeaways
* **String-to-Double Paradox:** Discovered that UI state for numeric inputs should remain as `Strings` to preserve "incomplete" states (like trailing decimal points), converting to numeric types only for business logic.
* **Scaffold Padding Chain:** Learned that the `innerPadding` provided by the `Scaffold` is a "contract" that must be passed all the way down to the screen-level Composables to maintain UI visibility.
* **Arrangement vs. Alignment:** Clarified the use of `Arrangement.spacedBy()` for consistent gaps and `Alignment.CenterVertically` for group positioning within containers.

### 📈 Progress Tracking
* **Time Invested:** 5 hours
* **Phase:** 2 (Android Basics with Compose & Architecture)
* **Goal Alignment:** * Successfully developed the core UI and navigation for the **Expense Tracker** practise project.