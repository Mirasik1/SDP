# Filament for 3D Printing Project

## Project Structure
* `src/model/Filament.java`
* `src/model/FilamentBuilder.java`
* `src/director/FilamentDirector.java`
* `src/Main.java`

---

## Project Description
This project is designed to manage 3D printer configurations and printing material properties. As the first step toward implementing a larger 3D printing automation system, a dedicated subsystem for plastic type configuration was developed.

The **Builder** pattern is ideal for this domain because different filaments possess unique physical and thermal properties. At the same time, many base plastic types share common specifications and differ only by a few parameters. Using a builder provides flexible object configuration and allows seamless creation of standard presets.

---

## Technical Requirements Coverage
* **Product (`Filament`):** Stores and maintains all physical and thermal specifications of the material.
* **Builder (`FilamentBuilder`):** Implements step-by-step object construction using a Fluent API.
* **Director (`FilamentDirector`):** Handles fast generation of common plastic presets (PLA, ABS, TPU).
* **Client (`Main`):** Tests custom configuration assembly, director preset creation, and exception handling.

---

## 5 Clean Code Principles Applied

### 1. Single Responsibility Principle (SRP)
Each class and method is focused strictly on a single task[cite: 1, 2]. `Filament` represents data, `FilamentBuilder` handles construction and validation, and `FilamentDirector` manages presets.

### 2. Meaningful and Consistent Naming
Every function and variable uses concise and explicit naming. Method names strictly follow naming conventions: action prefix (`get` / `set`) followed by the property name (e.g., `setName`, `getName`).

```java
// BEFORE
public String n() { return name; }
public void change(String val) { name = val; }

// AFTER
public String getName() {
    return name;
}

public FilamentBuilder setName(String name) {
    this.name = name;
    return this;
}
```
### 3. Validated Construction
The build() method guarantees that an object cannot be instantiated in an invalid state[cite: 1, 2]. Explicit IllegalStateException and IllegalArgumentException are thrown upon invalid state detection.
```java
// BEFORE
public Filament build() {
    return new Filament(this); // Instantiates object without checks
}

// AFTER
public Filament build() {
    if (name == null || name.trim().isEmpty()) {
        throw new IllegalStateException("Filament name cannot be empty");
    }
    if (nozzleTemperature < 150 || nozzleTemperature > 450) {
        throw new IllegalArgumentException("Invalid nozzle temperature: " + nozzleTemperature);
    }
    if (manufacturerName == null || manufacturerName.trim().isEmpty()) {
        throw new IllegalStateException("Filament Manufacturer name cannot be empty");
    }
    if (bedTemperature < 20 || bedTemperature > 150) {
        throw new IllegalArgumentException("Invalid bed temperature: " + bedTemperature);
    }
    return new Filament(this);
}
```

## 4. Domain-Driven Limits (No Magic Numbers)
Validation boundary values are not arbitrary magic numbers. Temperature ranges (150°C–450°C for the nozzle, 20°C–150°C for the bed) were determined from hardware specifications and operating parameters of commercial 3D printers on the market.
```java
// BEFORE
if (temp < 0 || temp > 1000) { ... }

// AFTER
// Operating hotend temperature limits based on market hardware specs
        if (nozzleTemperature < 150 || nozzleTemperature > 450) {
        throw new IllegalArgumentException("Invalid nozzle temperature: " + nozzleTemperature);
}
```
## 5. Encapsulation & Immutable State
All fields in the Filament class are declared as private. Data access is restricted strictly to getters, protecting object state from unwanted mutations during execution.
```java
// BEFORE
public String name;
public float nozzleTemperature;

// AFTER
private String name;
private float nozzleTemperature;

public String getName() {
    return name;
}

public float getNozzleTemperature() {
    return nozzleTemperature;
}
```