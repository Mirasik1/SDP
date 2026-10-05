# 3D Printing System (Bridge Pattern)

## Project Structure
* `src/bridge/Filament.java`
* `src/bridge/PLAFilament.java`
* `src/bridge/ABSFilament.java`
* `src/bridge/PETGFilament.java`
* `src/bridge/PrintJob.java`
* `src/bridge/PrototypePrintJob.java`
* `src/bridge/FunctionalPartPrintJob.java`
* `src/bridge/Main.java`

---

## Project Description
This project demonstrates the **Bridge** structural design pattern applied to a 3D printing system by decoupling print job abstractions from low-level polymer filament implementations.

1. **Implementor Hierarchy (`Filament`):** Encapsulates material-specific properties such as extruder temperature, bed temperature, print speed, and layer cooling mechanics (`PLAFilament`, `ABSFilament`, `PETGFilament`).
2. **Abstraction Hierarchy (`PrintJob`):** Manages high-level printing workflow logic (`PrototypePrintJob`, `FunctionalPartPrintJob`). It references a `Filament` instance via composition, enabling runtime switching of print materials without modifying print job abstractions.

---

## Technical Requirements Coverage

### Implementor & Concrete Implementors
* **Implementor (`Filament`):** Interface declaring low-level physical operations and material properties.
* **Concrete Implementors (`PLAFilament`, `ABSFilament`, `PETGFilament`):** Specific implementations providing temperature, speed, and cooling configurations tailored to each material.

### Abstraction & Refined Abstractions
* **Abstraction (`PrintJob`):** Abstract class holding a reference to a `Filament` instance and defining the contract for executing print jobs.
* **Refined Abstractions (`PrototypePrintJob`, `FunctionalPartPrintJob`):** Specific task abstractions that adapt execution velocity and infill precision based on model purpose.

### Client
* **Client (`Main`):** Composes a `PrintJob` with a `Filament` implementation at runtime and demonstrates switching filament implementations on the fly via setter injection.

---

## 5 Clean Code Principles Applied

### 1. Single Responsibility Principle (SRP)
Each class has a single, well-defined reason to change. `PrintJob` handles high-level printing workflows, while `Filament` implementations isolate material-specific hardware parameters.

### 2. Open/Closed Principle (OCP)
The system is open for extension but closed for modification. New filament types (e.g., `NylonFilament`) or new print job abstractions (e.g., `HighPrecisionPrintJob`) can be introduced without altering existing code.

```java
// BEFORE (adding new material required editing execution logic)
if (material.equals("PLA")) { ... } else if (material.equals("ABS")) { ... }

// AFTER (adding a new material requires only a new class implementing Filament)
public class NylonFilament implements Filament {
    @Override
    public String getType() { return "Nylon"; }
    // ...
}
```
### 3. Dependency Inversion Principle (DIP)
High-level print job abstractions depend strictly on the abstract Filament interface rather than concrete material classes, decoupling business logic from low-level implementation details.
```java
// BEFORE
private PLAFilament filament = new PLAFilament();

// AFTER
protected Filament filament;

public PrintJob(Filament filament) {
    this.filament = filament;
}
```
### 4. Meaningful and Consistent Naming
Class and method names explicitly convey their architectural roles within the Bridge pattern using standard domain vocabulary (PrintJob, Filament, coolLayer, getExtruderTemperature), avoiding vague terms.

```java
// BEFORE
public void run() { ... }

// AFTER
public void printModel(String modelName) { ... }
```

### 5. Encapsulation & Composition Over Inheritance
Low-level behavior is delegated through composition rather than deep class inheritance, permitting dynamic switching of material implementations at runtime via setter injection.
```java
// BEFORE
public class PrototypePLAPrintJob extends PrintJob { ... }

// AFTER
PrintJob job = new PrototypePrintJob(pla);
job.setFilament(petg); // dynamic swap without re-instantiating the job
```