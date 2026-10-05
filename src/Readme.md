# 3D Printing System (Factory Method & Abstract Factory)

## Project Structure
* `src/factory/product/PrintProfile.java`
* `src/factory/product/PlaPrintProfile.java`
* `src/factory/product/AbsPrintProfile.java`
* `src/factory/creator/PrintProfileFactory.java`
* `src/factory/creator/PlaProfileFactory.java`
* `src/factory/creator/AbsProfileFactory.java`
* `src/factory/abstract_factory/product/Nozzle.java`
* `src/factory/abstract_factory/product/BrassNozzle.java`
* `src/factory/abstract_factory/product/HardenedSteelNozzle.java`
* `src/factory/abstract_factory/factory/PrintEquipmentFactory.java`
* `src/factory/abstract_factory/factory/PlaEquipmentFactory.java`
* `src/factory/abstract_factory/factory/AbsEquipmentFactory.java`
* `src/Main.java`

---

## Project Description
This project manages 3D printer execution profiles, material configurations, and hardware equipment setups.

1. **Factory Method (Part A):** Implemented to dynamically create individual print execution profiles (`PrintProfile`). It encapsulates creation logic into specific creators (`PlaProfileFactory`, `AbsProfileFactory`), avoiding hardcoded conditions.
2. **Abstract Factory (Part B):** Extended to build consistent families of related products (`PrintProfile` + `Nozzle`). Each concrete factory (`PlaEquipmentFactory`, `AbsEquipmentFactory`) produces a fully compatible setup for a specific material ecosystem, ensuring hardware parameters match polymer requirements.

---

## Technical Requirements Coverage

### Part A: Factory Method
* **Product (`PrintProfile`):** Interface declaring print execution contracts.
* **Concrete Products (`PlaPrintProfile`, `AbsPrintProfile`):** Material-specific profile behavior.
* **Creator (`PrintProfileFactory`):** Abstract class declaring the factory method `createProfile()`
* **Concrete Creators (`PlaProfileFactory`, `AbsProfileFactory`):** Overrides factory method to instantiate individual products.

### Part B: Abstract Factory
* **Abstract Products (`PrintProfile`, `Nozzle`):** Interfaces defining family product behaviors.
* **Concrete Products (`BrassNozzle`, `HardenedSteelNozzle`):** Hardware implementations corresponding to material demands.
* **Abstract Factory (`PrintEquipmentFactory`):** Interface declaring creation methods for all products in the family.
* **Concrete Factories (`PlaEquipmentFactory`, `AbsEquipmentFactory`):** Instantiates fully compatible product families.
* **Client (`Main`):** Interacts strictly through abstract factory and product interfaces without direct class coupling.

---

## 5 Clean Code Principles Applied

### 1. Single Responsibility Principle (SRP)
Each class performs one isolated job. Product classes encapsulate domain behavior, while factory classes handle object creation and setup consistency.

### 2. Meaningful and Consistent Naming
Variable and method names explicitly convey their intent using standard Java action prefixes (`create`, `get`, `start`), eliminating the need for comments.

```java
// BEFORE
public PrintProfile make() { return new PlaPrintProfile(); }

// AFTER
public PrintProfile createPrintProfile() {
    return new PlaPrintProfile();
}
```
### 3. Dependency Inversion Principle (DIP)
   High-level execution logic relies exclusively on abstract interfaces (PrintEquipmentFactory, PrintProfile, Nozzle) rather than concrete classes.
```java
// BEFORE
PlaPrintProfile profile = new PlaPrintProfile();
BrassNozzle nozzle = new BrassNozzle();

// AFTER
PrintEquipmentFactory factory = new PlaEquipmentFactory();
PrintProfile profile = factory.createPrintProfile();
Nozzle nozzle = factory.createNozzle();
```
### 4. Open/Closed Principle (OCP)
   New polymer ecosystems (e.g., TPU with a flexible-compatible nozzle) can be added by creating new product and factory classes without modifying existing system code.
```java
// BEFORE
if (type.equals("PLA")) { ... } else if (type.equals("ABS")) { ... }

// AFTER
public class TpuEquipmentFactory implements PrintEquipmentFactory {
    @Override
    public PrintProfile createPrintProfile() { return new TpuPrintProfile(); }
    @Override
    public Nozzle createNozzle() { return new StainlessSteelNozzle(); }
}
```
### 5. Encapsulation & Polymorphism
   Product states and manufacturing choices are encapsulated within concrete implementations, allowing clients to invoke polymorphic execution through shared abstractions.
```java
// BEFORE
public String nozzleMat = "Brass";

// AFTER
@Override
public String getMaterial() {
    return "Brass (Латунь)";
}
```