# 3D Printing System (Visitor Pattern)

## Project Structure
- `src/visitor/IFilamentVisitor.java`
- `src/visitor/IFilament.java`
- `src/visitor/PlaFilament.java`
- `src/visitor/PetgFilament.java`
- `src/visitor/TpuFilament.java`
- `src/visitor/SlicerConfigVisitor.java`
- `src/visitor/PostProcessingVisitor.java`
- `src/visitor/Main.java`
- `src/visitor/README.md`

---

## Project Description
This project manages 3D printer material operations and post-processing analytics dynamically using the **Visitor** behavioral design pattern.

1. **Visitor Pattern:** Implemented to separate algorithms from the elements on which they operate. It adds new operations (such as slicer parameter configuration and post-processing guidance) to an existing filament object structure without modifying the element classes (`PlaFilament`, `PetgFilament`, `TpuFilament`). Double dispatch guarantees execution of the correct operation variant for each specific polymer type at runtime.

---

## Technical Requirements Coverage

- **Visitor Interface (`IFilamentVisitor`):** Declares distinct `visit()` methods for every concrete element type (`PlaFilament`, `PetgFilament`, `TpuFilament`).
- **Element Interface (`IFilament`):** Declares the `accept(IFilamentVisitor visitor)` method, serving as the entry point for double dispatch.
- **Concrete Elements (`PlaFilament`, `PetgFilament`, `TpuFilament`):** Represent different 3D printing materials carrying specific physical properties (e.g., Shore hardness, PEI bed preference, temperature profile). Each element implements `accept()` by calling `visitor.visit(this)`.
- **Concrete Visitors (`SlicerConfigVisitor`, `PostProcessingVisitor`):** Encapsulate distinct operations across all element types. `SlicerConfigVisitor` computes print settings, while `PostProcessingVisitor` outputs material-specific finishing steps.
- **Object Structure & Client (`Main`):** Iterates over a collection of `IFilament` objects and executes operations via `filament.accept(visitor)` without type checking or casting.

---

## 5 Clean Code Principles Applied

### 1. Single Responsibility Principle (SRP)
Element classes strictly store material properties and model real-world filament characteristics. Algorithm logic (slicing configuration, post-processing methods) is entirely extracted into dedicated Concrete Visitor classes (`SlicerConfigVisitor`, `PostProcessingVisitor`).

### 2. Meaningful and Consistent Naming
Classes and interfaces strictly reflect domain entities and design patterns. Interfaces use the `I` prefix (`IFilament`, `IFilamentVisitor`), while implementations clearly indicate whether they are concrete elements or concrete visitors.

```java
// BEFORE
public class Process {
    public void execute(Object o) { ... }
}

// AFTER
public class SlicerConfigVisitor implements IFilamentVisitor {
    @Override
    public void visit(PlaFilament pla) { ... }
}
```

### 3. Total Elimination of `instanceof` & Type-Checking Chains
The Double Dispatch mechanism replaces conditional branching (`if`/`switch` or `instanceof` checks). Method resolution occurs polymorphicly on both the visitor and the element type.

```java
// BEFORE
for (Object filament : inventory) {
    if (filament instanceof PlaFilament) {
        // PLA processing logic
    } else if (filament instanceof PetgFilament) {
        // PETG processing logic
    }
}

// AFTER
for (IFilament filament : inventory) {
    filament.accept(slicerVisitor);
}
```

### 4. Open/Closed Principle (OCP)
Adding a new operation (e.g., `CostCalculationVisitor` or `DryingTimeVisitor`) requires zero modifications to existing element classes (`PlaFilament`, `PetgFilament`, etc.). You simply introduce a new class implementing `IFilamentVisitor`.

```java
// BEFORE
// Adding a new feature required modifying every filament class directly
public class PlaFilament {
    public void printConfig() { ... }
    public void postProcess() { ... }
    public void calculateCost() { ... } // Class modified!
}

// AFTER
public class CostCalculatorVisitor implements IFilamentVisitor {
    @Override
    public void visit(PlaFilament pla) { /* Calculate PLA cost */ }
    @Override
    public void visit(PetgFilament petg) { /* Calculate PETG cost */ }
    @Override
    public void visit(TpuFilament tpu) { /* Calculate TPU cost */ }
}
```

### 5. Encapsulation & Minimal Interface Exposure
Concrete visitors access element attributes strictly through public getters (`getColor()`, `getShoreHardness()`). Elements expose only necessary data, preventing direct state modification and keeping encapsulation trade-offs minimal and well-justified.

```java
// BEFORE
public class TpuFilament {
    public int shoreHardness; // Exposed mutable field
}

// AFTER
public class TpuFilament implements IFilament {
    private final int shoreHardness;

    public int getShoreHardness() {
        return shoreHardness;
    }

    @Override
    public void accept(IFilamentVisitor visitor) {
        visitor.visit(this);
    }
}
```