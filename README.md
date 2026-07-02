# Wildfire Evacuation Route Planning Using Dijkstra's Algorithm

A Java implementation of **Dijkstra's Shortest Path Algorithm** for planning wildfire evacuation routes in a fictional rural village named **Cedar Hollow**. The system recommends the shortest safe evacuation route from a residential zone to the nearest reachable shelter while avoiding roads blocked by wildfire.

This project was developed as part of the **CSC4202 – Design and Analysis of Algorithms** course at Universiti Putra Malaysia.

---

## 📖 Project Overview

During a wildfire emergency, selecting the fastest evacuation route can significantly reduce evacuation time and improve public safety. This project models the village road network as a **weighted undirected graph**, where:

- **Vertices** represent residential areas, road junctions, public facilities, and shelters.
- **Edges** represent roads between locations.
- **Edge weights** represent travelling distances.
- **Blocked roads** caused by wildfire are removed from the graph before route computation.

The application uses **Dijkstra's Algorithm** to determine the shortest path from a selected residential zone to the nearest available shelter.

---

## ✨ Features

- Implements Dijkstra's Shortest Path Algorithm using a Priority Queue
- Finds the nearest reachable evacuation shelter
- Avoids roads blocked by wildfire
- Displays:
  - Shortest distance
  - Recommended shelter
  - Complete evacuation path
  - Distance from the source to every location
- Measures algorithm execution time

---

## 🗺️ Scenario

The project simulates a wildfire affecting **Cedar Hollow**, where several roads become inaccessible due to fire.

### Residential Zones

- A – Zone A
- B – Zone B
- C – Zone C

### Other Locations

| Node | Location |
|------|----------|
| D | Village Centre |
| E | School |
| F | Forest Edge Road *(Blocked)* |
| G | Bridge |
| H | Shelter 1 |
| I | Market Road |
| J | Community Hall |
| K | Old Bridge |
| L | Shelter 2 |

Blocked roads are intentionally excluded from the graph so that only safe routes are considered.

---

## 🧠 Algorithm

The project uses **Dijkstra's Algorithm**, a greedy shortest-path algorithm suitable for weighted graphs with non-negative edge weights.

### Why Dijkstra?

- Guarantees the shortest path
- Efficient for single-source shortest path problems
- Works well with positive road distances
- Simple to implement and suitable for disaster evacuation planning

---

## 📂 Project Structure

```
.
├── Dijkstra_Algorithm.java    # Main Java implementation
├── CSC4202_Group1.pdf         # Project report
└── README.md
```

---

## ⚙️ Requirements

- Java JDK 8 or later

---

## 🚀 How to Run

### 1. Compile

```bash
javac Dijkstra_Algorithm.java
```

### 2. Run

```bash
java Dijkstra_Algorithm
```

### 3. Enter a Starting Zone

```
A = 0
B = 1
C = 2
```

Example:

```
Enter the Starting zone number(A = 0, B = 1, C = 2):
0
```

---

## 📋 Example Output

```
Enter the Starting zone number(A = 0, B = 1, C = 2):
0

Closest destination: H
Distance: 10.0 km

Path:
A -> D -> G -> H

Time taken: xxxx ns
```

---

## 🏗️ Graph Representation

The road network is implemented as an **adjacency list**.

Each edge stores:

- Destination node
- Travel distance

Example:

```java
adj.get(0).add(new Node(3, 35));
adj.get(3).add(new Node(0, 35));
```

This represents:

```
A ↔ D (3.5 km)
```

Distances are multiplied by **10** in the implementation to avoid floating-point calculations.

Example:

| Actual Distance | Stored Value |
|-----------------|--------------|
| 3.5 km | 35 |
| 4.5 km | 45 |
| 6.5 km | 65 |

---

## ⏱️ Complexity Analysis

### Time Complexity

Using a priority queue with an adjacency list implementation:

- **Worst Case:** `O((V + E) log V)`

where:

- `V` = number of vertices
- `E` = number of edges

### Space Complexity

```
O(V + E)
```

---

## 📚 Technologies Used

- Java
- Priority Queue
- Adjacency List
- Dijkstra's Shortest Path Algorithm

---

## 👥 Authors

Group 1

- Sujenizswaran A/L Rajah
- Nufail Azri Bin Azmi
- Dzaky Keenan Ibrahim
- Muhammad Azib Bin Azmi

Faculty of Computer Science and Information Technology  
Universiti Putra Malaysia

---

## 📄 Report

The complete project report is available in:

```
CSC4202_Group1.pdf
```

The report includes:

- Problem definition
- Graph modelling
- Algorithm design
- Correctness proof
- Time complexity analysis
- Sample outputs
- References

---

## 🔮 Future Improvements

Possible enhancements include:

- Dynamic road closures during execution
- Real-time traffic information
- GIS or map integration
- Interactive graphical user interface (GUI)
- Support for larger road networks
- Multiple evacuation priorities and emergency vehicles

---

## 📜 License

This project was developed for academic purposes as part of the CSC4202 Design and Analysis of Algorithms course.

Feel free to use, modify, and learn from the code for educational purposes.