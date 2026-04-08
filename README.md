# 📚 LLD Learning Repository

A comprehensive repository containing **Low-Level Design (LLD)**, **DSA**, and **Multithreading** problems with solutions and explanations.

## 📁 Repository Structure

```
LLDrepo/
├── LLD/                          # Low-Level Design Problems
│   ├── ParkingLot/              # Parking Lot LLD
│   │   └── src/
│   │       ├── ParkingLot/
│   │       │   ├── models/      # Entity classes
│   │       │   ├── service/     # Service layer
│   │       │   ├── enums/       # Enums
│   │       │   └── ParkingLotDriver.java
│   │       └── Main.java
│   └── lld-template.md          # LLD Template for solving problems
│
├── DSA/                          # Data Structures & Algorithms
│   ├── Arrays/
│   ├── LinkedLists/
│   ├── Trees/
│   ├── Graphs/
│   └── Sorting/
│
└── Multithreading/              # Multithreading & Concurrency
    ├── BasicThreads/
    ├── Synchronization/
    ├── ThreadPools/
    └── ProducerConsumer/
```

## 🚀 Problems Included

### LLD (Low-Level Design)
- **Parking Lot System**
  - Entry/Exit gates
  - Vehicle spot assignment
  - Fee calculation
  - Multiple vehicle types support

### DSA (Coming Soon)
- Array problems
- Linked list operations
- Tree traversals
- Graph algorithms

### Multithreading (Coming Soon)
- Thread creation and management
- Synchronization mechanisms
- Thread pools
- Producer-Consumer patterns

## 💻 How to Use

### LLD Problems
Navigate to `LLD/ParkingLot/`:
```bash
cd LLD/ParkingLot/src
javac ParkingLot/enums/*.java ParkingLot/models/*.java ParkingLot/service/*.java ParkingLot/*.java
java -cp . ParkingLot.ParkingLotDriver
```

### DSA Problems
Navigate to `DSA/<Topic>/` and follow individual problem instructions.

### Multithreading Problems
Navigate to `Multithreading/<Topic>/` and follow individual problem instructions.

## 📝 Workflow

For adding new problems:
1. Create a folder under the respective category (LLD/DSA/Multithreading)
2. Add source code with clear package structure
3. Include a README with problem description
4. Commit with meaningful message
5. Push to repository

## 🔗 GitHub Repositories

- **Main Repo**: https://github.com/DineshSaiKumarD/LLDLearningRepo
- **Separate Repos** (optional for each category):
  - DSA Repo: `https://github.com/DineshSaiKumarD/DSALearningRepo`
  - Multithreading Repo: `https://github.com/DineshSaiKumarD/MultithreadingLearningRepo`

## 📖 Problem Solving Template

Use `LLD/lld-template.md` as a reference template for solving any LLD problem systematically.

## ✅ Best Practices

- Use meaningful package names and class names
- Add comments explaining complex logic
- Follow SOLID principles
- Test edge cases
- Maintain clean code structure
- Update README for each new problem

## 👤 Author
**DineshSaiKumar**

---

Happy Learning! 🎓

