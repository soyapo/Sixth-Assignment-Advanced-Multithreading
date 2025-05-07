# Sixth Assignment: Advanced Multithreading

## Table of contents
- [Important Note](#important-note)
- [Introduction](#introduction)
- [Objectives 🎯](#objectives-)
- [Theoretical Questions 📝](#theoretical-questions-)
- [Practical Questions 💻](#practical-questions-)
- [Bonus Tasks 🌟](#bonus-tasks-)
- [Evaluation ⚖️](#evaluation-)
- [Submission ⌛](#submission-)
- [Additional Resources 📚](#additional-resources-)


## Important Note:
This project is configured to use a **local Gradle installation**. If you're opening this project on your own system, please make sure to:

1. Go to **Settings/Preferences** > **Build, Execution, Deployment** > **Build Tools** > **Gradle**.

2. Under **Gradle settings**, change the **Gradle distribution** to:

- **Use local Gradle distribution**, and

- Set the **Gradle home** path to your own local Gradle installation directory.

If you don’t have Gradle installed locally, you can either:

- Install Gradle manually and configure the path, or

- Change the setting to **Use Gradle wrapper** instead.



## Introduction
Welcome to your Sixth Advanced Programming (AP) Assignment. This project is divided into two main sections:

1. **Theoretical Questions**: This section is designed to deepen your understanding of advanced multithreading concepts in Java. You'll have to analyze one code block and answer questions about them.

2. **Practical Questions**: In this section, you'll get hands-on experience with multithreading in Java. Your code will be manually checked to ensure you've implemented the tasks using multithreading.


## Objectives 🎯

By completing this assignment, you will:

- Deepen your understanding of **multithreading** in Java and apply the concepts effectively.
- ...

...

## Theoretical Questions 📝
**Note: Please answer these questions in a Markdown file (Report.md) and place it in the root directory of your fork. Include code or screenshots where you see fit.**

### 1. `Atomic Variables`

```java  
import java.util.concurrent.atomic.AtomicInteger;
public class AtomicDemo {
  private static AtomicInteger atomicCounter = new AtomicInteger(0);
  private static int normalCounter = 0;
  public static void main(String[] args) throws InterruptedException {
    Runnable task = () -> {
      for (int i = 0; i < 1_000_000; i++) {
        atomicCounter.incrementAndGet();
        normalCounter++;
      }
    };

    Thread t1 = new Thread(task);
    Thread t2 = new Thread(task);
    t1.start();
    t2.start();
    t1.join();
    t2.join();

    System.out.println("Atomic Counter: " + atomicCounter);
    System.out.println("Normal Counter: " + normalCounter);
  }
}
  
```  

**Questions:**

- What output do you get from the program? Why?

- What is the purpose of AtomicInteger in this code?

- What thread-safety guarantees does atomicCounter.incrementAndGet() provide?

- In which situations would using a lock be a better choice than an atomic variable?

- Besides AtomicInteger, what other data types are available in the java.util.concurrent.atomic package?

---  


## Practical Questions 💻

### Pi (π) Estimation - Monte Carlo Algorithm


![](./Images/MonteCarlo.jpg)

#### Task Description
The Monte Carlo algorithm for estimating π (pi) is a classic example of using
random sampling to approximate a mathematical constant.

This project simulates random points $(x,y)$ in a 2D plane, within a square of side length
$2r$, centered at the origin $(0,0)$. Inside this square, a circle of radius $r$ is perfectly inscribed.

The simulation calculates the ratio of points that fall inside the circle to the total number of generated points.
This ratio approximates the area ratio between the circle and the square, and can be used to estimate the value of $\pi$.

* Area of Square: $(2r)^2 = 4r^2$
* Area of Circle: $\pi r^2$
* The ratio of these two:

$$
\frac{\text{circle's area}}{\text{square's area}} = \frac{\pi r^2}{4r^2} = \frac{\pi}{4}
$$

We generate random $(x,y)$ pairs within the square domain and determine whether each point lies inside the inscribed circle using the condition:

$$
x^2 + y^2 \leq r^2
$$

If the condition is satisfied, the point is considered **inside the circle**, and we increment the corresponding counter.


#### 🛠 What  You  Need to Do

1. Complete the Code:
   Implement the Monte Carlo simulation to estimate the value of π. The implementation should include both:
- A single-threaded version.

- A multi-threaded version that uses all available CPU cores.

2. Print a Brief Report:

- Include a comparison of performance (benchmark results) between the multi-threaded and single-threaded versions.

---

### 🏦 Banking System

#### 📝 Task Description

You are building a simple multi-threaded banking system. The system manages **four bank accounts**, and processes a series of transactions (withdrawals, deposits, and transfers) by reading instructions from **four input files**. Each file contains a list of operations and is handled by a **separate thread**.

Your goal is to implement safe and correct logic for the `deposit`, `withdraw`, and `transfer` methods in the `BankAccount` class.

**The Setup**
The infrastructure for the following actions is **already written**:

- initializing accounts, 
- reading input files,
- parsing the data, and
- creating/running threads

---

#### 🛠 What You Need to Do
 
1. **Your Task**
   You only need to implement the following methods inside the `BankAccount` class:

    * `deposit(int amount)`
    * `withdraw(int amount)`
    * `transfer(BankAccount target, int amount)`

2. **Concurrency Requirements**

    * All methods must be **thread-safe**. Multiple threads may access and modify the same accounts concurrently.
    * You **must prevent race conditions** using synchronization mechanisms such as `ReentrantLock`.
    * For `transfer`, you **must acquire locks on both source and target accounts simultaneously**.
      🔒 **Important:** Without proper locking,deadlocks may occur. Identify the problem and prevent it from happening. 

3. **Note:**
   
   For the sake of simplicity in this assignment, you do not need to check whether the balance is sufficient before performing a withdrawal or a transfer.
   This means accounts are allowed to have negative balances, and there is no need to throw exceptions or block operations due to insufficient funds.
---  



## Bonus Tasks 🌟

### Monte Carlo
  
1. **Graphical Visualization (UI)**  
  - Use a UI framework like **JavaFX** to visualize the simulation:
    - Show the square and inscribed circle.
    - Plot random points in real time:
      - **Green** dots for points inside the circle.
      - **Red** dots for points outside the circle.
    - Update the estimated value of π dynamically as points are plotted.

2. **Benchmark **  
  - Create a report comparing runtime vs. number of points for both single-threaded and multi-threaded runs.
  - Export results as a CSV or JSON file.

### Banking System
    - ...
        - ...


## Evaluation ⚖️

Your work on this assignment will be evaluated based on:

- **Understanding of Multithreading Concepts**: Your ability to accurately answer the theoretical questions, and demonstrating a deep understanding of multithreading in Java. Remember that the answers to the theoretical questions should be provided separately in a markdown file.

- **Code Quality**: Your code should be well-structured, readable, and efficient. Proper use of Java conventions, including variable naming, class structure, and comments, will also be considered.

- You **must not** use advanced multithreading tools (such as ExecutorService, CompletableFuture, or others)

- Total: 100 points
    - 🧠 Theoretical Questions – 30 points
    - 💻 Practical Task 1 (Monte Carlo) – 35 points
    - 📊 Practical Task 2 (Banking System) – 35 points
    - 🌟 Bonus Tasks – Up to 10 extra points

## Submission ⌛

1. Add your mentor as a contributor to the project.
2. Create a `develop` branch for implementing features.
3. Use Git for regular code commits.
4. Push your code and the answers file to the remote repository.
5. Submit a pull request to merge the `develop` branch with `main`.

The deadline for submitting your code is **Wednesday, May 14** (24th of Ordibehesht)

## Additional Resources 📚

For assistance with this assignment, you may refer to the following resources:

- [Race Conditions and Critical Sections](https://jenkov.com/tutorials/java-concurrency/race-conditions-and-critical-sections.html)
- [Java Synchronized Blocks](https://jenkov.com/tutorials/java-concurrency/synchronized.html)
- [Deadlock](https://jenkov.com/tutorials/java-concurrency/deadlock.html)
- [Deadlock Prevention](https://jenkov.com/tutorials/java-concurrency/deadlock-prevention.html)
- [Java ExecutorService](https://jenkov.com/tutorials/java-util-concurrent/executorservice.html)
- [Semaphore](https://jenkov.com/tutorials/java-util-concurrent/semaphore.html)
- [Java Lock](https://jenkov.com/tutorials/java-util-concurrent/lock.html)

Also, you can find a wealth of knowledge from various YouTube courses. They can be a great source of learning. Alongside, joining discussions on forums and reading helpful documents can also be beneficial.
