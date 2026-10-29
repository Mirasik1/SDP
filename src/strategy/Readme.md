# 3D Printing System (Strategy Pattern)

## Project Structure
- `src/strategy/IPrintStrategy.java`
- `src/strategy/PlaPrintStrategy.java`
- `src/strategy/PetGPrintStrategy.java`
- `src/strategy/TpuPrintStrategy.java`
- `src/strategy/PrintConfig.java`
- `src/strategy/SlicerContext.java`
- `src/strategy/main.java`
- `src/strategy/Readme.md`

---

## Project Description
This project manages 3D printer slicing configurations and material printing parameters dynamically at runtime using the Strategy behavioral pattern.

1. **Strategy Pattern:** Implemented to encapsulate material-specific extrusion temperatures, bed temperatures, print speeds, and retraction rules (`IPrintStrategy`). It delegates parameter calculation from the context (`SlicerContext`) to specific strategy implementations (`PlaPrintStrategy`, `PetGPrintStrategy`, `TpuPrintStrategy`), eliminating branching logic and enabling seamless runtime switching of filaments.

---

## Technical Requirements Coverage

- **Strategy Interface (`IPrintStrategy`):** Common contract declaring `calculatePrintConfig(double modelVolumeCm3)` and `getFilamentTypeName()` for all concrete strategies.
- **Concrete Strategies (`PlaPrintStrategy`, `PetGPrintStrategy`, `TpuPrintStrategy`):** Material-specific printing parameter calculations (nozzle/bed temperatures, print speed, retraction distance, estimated print time).
- **Context (`SlicerContext`):** Holds a reference to `IPrintStrategy` and delegates parameter calculations to it, supporting runtime strategy changes via `setPrintStrategy()`.
- **DTO/Model (`PrintConfig`):** Data holder encapsulating output printing settings (nozzle temp, bed temp, speed, retraction, print time).
- **Client (`main`):** Configures and switches strategies dynamically without any `if`/`switch` branching statements inside the context.

---

## 5 Clean Code Principles Applied

### 1. Single Responsibility Principle (SRP)
Each class has one well-defined responsibility. Concrete strategies strictly calculate material parameters, `PrintConfig` holds data, and `SlicerContext` manages the current active strategy and delegates slicing execution.

### 2. Meaningful and Consistent Naming
Class, interface, and method names explicitly convey their intent within the 3D printing domain without needing explanatory comments.

```java
// BEFORE
public class Strategy {
    public void execute() { ... }
}

// AFTER
public class SlicerContext {
    public PrintConfig prepareSlicingProfile(double modelVolumeCm3) {
        return printStrategy.calculatePrintConfig(modelVolumeCm3);
    }
}
```

### 3. Dependency Inversion Principle (DIP)
`SlicerContext` relies entirely on the high-level `IPrintStrategy` interface rather than concrete strategy classes, preventing tight coupling.

```java
// BEFORE
PlaPrintStrategy pla = new PlaPrintStrategy();
PrintConfig config = pla.calculatePrintConfig(45.0);

// AFTER
IPrintStrategy strategy = new PlaPrintStrategy();
SlicerContext slicer = new SlicerContext(strategy);
PrintConfig config = slicer.prepareSlicingProfile(45.0);
```

### 4. Open/Closed Principle (OCP)
New polymers (e.g., ABS, Nylon) can be added simply by creating new classes implementing `IPrintStrategy` without modifying existing context or client code.

```java
// BEFORE
if (material.equals("PLA")) { ... } else if (material.equals("PETG")) { ... }

// AFTER
public class AbsPrintStrategy implements IPrintStrategy {
    @Override
    public PrintConfig calculatePrintConfig(double modelVolumeCm3) {
        return new PrintConfig(245, 100, 50, 2.0, modelVolumeCm3 * 3.0);
    }
    @Override
    public String getFilamentTypeName() { return "ABS"; }
}
```

### 5. Elimination of Conditional/Branching Logic
Branching logic (`if`/`switch`) is completely removed from the context by leveraging polymorphism to execute the appropriate printing strategy at runtime.

```java
// BEFORE
if (type == MaterialType.PLA) {
    nozzleTemp = 205;
} else if (type == MaterialType.PETG) {
    nozzleTemp = 240;
}

// AFTER
slicer.setPrintStrategy(new PetGPrintStrategy());
PrintConfig config = slicer.prepareSlicingProfile(modelVolume);
```