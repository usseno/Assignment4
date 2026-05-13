# Graph Traversal and Representation System

## Project Overview

This project implements BFS and DFS using adjacency lists in Java.

The project measures traversal performance on graphs of different sizes.

---

## Graph Structure

- Vertex = node
- Edge = connection between nodes

Example:
0 -> 1,2
1 -> 3
2 -> 4---

## BFS

BFS explores vertices level by level using a queue.

Example traversal:
0 1 2 3 4Time Complexity:
O(V + E)---

## DFS

DFS explores deeply before backtracking using recursion.

Example traversal:
0 1 3 2 4Time Complexity:
O(V + E)---

## Experimental Results

| Graph Size | BFS Time | DFS Time |
|---|---|---|
| 10 | 641292 ns | 146209 ns |
| 30 | 188083 ns | 202708 ns |
| 100 | 628958 ns | 1103958 ns |

---

## Observations

- Execution time increased with graph size.
- BFS and DFS showed similar performance.
- Both algorithms matched expected complexity O(V + E).

---



## Reflection

Through this project, I learned how BFS and DFS work and how adjacency lists represent graphs efficiently.

I also learned how graph size affects traversal performance.

---

## Repository Structure
src/
 ├── Vertex.java
 ├── Edge.java
 ├── Graph.java
 ├── Experiment.java
 └── Main.java
