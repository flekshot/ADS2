# Data Structures Lab Project

Hey! This is my project for the Data Structures course. I had to build some custom data structures in Java, like lists, stacks, queues, and heaps, without using `java.util.*` (except for `Iterator`). It was a fun challenge! Below is everything you need to know about my project.

## What’s in This Project
I created a few classes to implement different data structures:
- **`MyList<T>`**: An interface that defines methods like `add`, `get`, `remove`, `sort`, etc. It extends `Iterable<T>` so I can use `for-each` loops.
- **`MyArrayList<T>`**: My version of `ArrayList`, using an `Object[]` array to store items. It grows by adding 5 more spots when full (not the best way, but it works!).
- **`MyLinkedList<T>`**: My version of a doubly linked list, with nodes that have `next` and `prev` pointers. It’s got a `head` and `tail` to make things easier.
- **`MyStack<T>`**: A stack (LIFO) that uses `MyArrayList` to store items. I add and remove from the end.
- **`MyQueue<T>`**: A queue (FIFO) that uses `MyLinkedList`. I add to the end and remove from the start.
- **`MyMinHeap<T>`**: A min-heap (smallest item on top) that uses `MyArrayList`. It’s good for heaps because arrays make parent/child math easy.

## Why I Chose These Structures
I had to pick between `MyArrayList` and `MyLinkedList` for `MyStack`, `MyQueue`, and `MyMinHeap`. Here’s why I chose what I did:
- **Stack with `MyArrayList`**: A stack adds and removes from the top (end). `MyArrayList` is fast for adding/removing at the end, so it felt like a good fit.
- **Queue with `MyLinkedList`**: A queue adds at the end but removes from the start. `MyLinkedList` is fast for both (because of `head` and `tail`), while `MyArrayList` would be slow for removing at the start (shifting everything).
- **MinHeap with `MyArrayList`**: Heaps are usually stored in arrays because you can easily find parents and children using math (like `parent = (index-1)/2`). `MyLinkedList` would be messy for this.

## How to Run My Code
1. **Clone the Repo**: Grab my project from GitHub:
