# Low-Level Design Problems

This folder contains **Low-Level Design (LLD)** problem solutions.

## Problems

### 1. Parking Lot System
**Folder**: `ParkingLot/`

**Problem**: Design a parking lot system that manages vehicle parking with different vehicle types and parking spot types.

**Features**:
- Multiple vehicle types (Car, Bike, Truck)
- Spot allocation based on vehicle type
- Ticket generation on entry
- Fee calculation on exit
- Spot reuse after vehicle exit

**Key Files**:
- `ParkingLotDriver.java` - Main driver class to test the system
- `models/` - Entity classes (Vehicle, ParkingSpot, Ticket)
- `service/` - Business logic (ParkingLotService, EntryGateService, ExitGateService, FeeCalculator)
- `enums/` - VehicleType enum

**How to Run**:
```bash
cd ParkingLot/src
javac ParkingLot/enums/*.java ParkingLot/models/*.java ParkingLot/service/*.java ParkingLot/*.java
java -cp . ParkingLot.ParkingLotDriver
```

**Output**:
```
Parked V1 with ticket 1 at spot 1
Parked V2 with ticket 2 at spot 2
Unparked V1, fee: $0.00281...
Parked V3 with ticket 3 at spot 1
```

---

## 📖 LLD Template

Refer to `lld-template.md` for a comprehensive template to solve any LLD problem.

## 🎯 Next Problems to Add
- [ ] E-commerce System
- [ ] ATM System  
- [ ] Elevator System
- [ ] Library Management
- [ ] Hotel Booking System

---

Happy coding! 🚀

