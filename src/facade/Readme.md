# 3D Printing System (Facade Pattern)

## Project Structure
- `src/facade/subsystem/FileValidator.java`
- `src/facade/subsystem/PrintNotifier.java`
- `src/facade/SmartPrinterFacade.java`
- `src/facade/Main.java`

---

## Project Description
This project demonstrates the **Facade** structural design pattern applied to a 3D printing management ecosystem. It unifies and simplifies complex subsystem operations—combining model validation, material equipment allocation from Abstract Factory, and execution workflows from Bridge—into a high-level automated entry point.

1. **Complex Subsystem:** Encompasses geometric file checking, hardware component setup (`INozzle`, `IPrintProfile`), runtime filament execution (`IFilament`), and notification dispatching.
2. **Facade (`SmartPrinterFacade`):** Exposes a streamlined API (`startPrintWorkflow`) that encapsulates the step-by-step orchestration of lower-level subsystems without revealing internal coordination complexities.
3. **Client (`Main`):** Interacts exclusively through the facade interface, decoupled from individual subsystem class instantiations.

---

## Technical Requirements Coverage

### Complex Subsystem
- **`FileValidator`:** Subsystem class validating 3D model geometry (manifold checks) prior to slicing and printing.
- **`IPrintEquipmentFactory` & Hardware Products:** Existing Abstract Factory subsystem managing compatible nozzles and material execution profiles.
- **`PrintJob` & `IFilament`:** Existing Bridge subsystem coordinating high-level job abstractions with low-level filament parameter execution.
- **`PrintNotifier`:** Subsystem class managing status alerts and operational logs.

### Facade
- **`SmartPrinterFacade`:** A single unified interface that coordinates subsystem validation, hardware allocation, job construction, and status notification in a strictly controlled sequence.

### Client
- **`Main`:** Serves as the client entry point, invoking the complex multi-stage printing pipeline using concise, single-line facade method calls.

---

## 5 Clean Code Principles Applied

### 1. Single Responsibility Principle (SRP)
Each subsystem class remains focused on its domain logic. `FileValidator` handles file safety, `PrintNotifier` handles messaging, and `SmartPrinterFacade` solely handles subsystem coordination without reimplementing low-level algorithms.

```java
// BEFORE (client orchestrates everything manually)
FileValidator validator = new FileValidator();
if (validator.validate(path)) {
    IPrintEquipmentFactory factory = new AbsEquipmentFactory();
    INozzle nozzle = factory.createNozzle();
    // ...
}

// AFTER (responsibility delegated cleanly to Facade)
SmartPrinterFacade facade = new SmartPrinterFacade();
facade.startPrintWorkflow("gear.stl", "ABS", "Functional");
```

### 2. Encapsulation & No Detail Leaking
The facade API hides subsystem complexity by accepting standard primitive parameters (`String modelPath`, `String materialType`, `String jobType`). Internal object instantiations and dependency bindings remain entirely hidden from the caller.

```java
// BEFORE
public void startPrint(INozzle nozzle, IPrintProfile profile, PrintJob job) { ... }

// AFTER
public void startPrintWorkflow(String modelPath, String materialType, String jobType) { ... }
```

### 3. Meaningful and Self-Explanatory Naming
Public methods in the facade explicitly express business intentions (`startPrintWorkflow`, `validate`, `notifyStart`), rendering inline documentation redundant.

```java
// BEFORE
public void run(String p, String m, String t) { ... }

// AFTER
public void startPrintWorkflow(String modelPath, String materialType, String jobType) { ... }
```

### 4. Dependency Inversion Principle (DIP)
The facade interacts with lower-level subsystems via abstract interfaces (`IPrintEquipmentFactory`, `INozzle`, `IPrintProfile`, `IFilament`, `PrintJob`), ensuring low coupling across design pattern boundaries.

```java
// BEFORE
PlaEquipmentFactory factory = new PlaEquipmentFactory();
BrassNozzle nozzle = new BrassNozzle();

// AFTER
IPrintEquipmentFactory equipmentFactory = new PlaEquipmentFactory();
INozzle nozzle = equipmentFactory.createNozzle();
```

### 5. Proper Error Handling & Flow Control
The facade implements early exit guards during coordination failures. If file validation fails, further subsystem initializations are safely aborted and reported through the notification subsystem.

```java
// BEFORE
validator.validate(modelPath);
job.printModel(modelPath); // runs even if validation failed

// AFTER
if (!validator.validate(modelPath)) {
    notifier.notifyError("Модель содержит ошибки геометрии!");
    return;
}
```

---

## Implementation Code

### `src/facade/subsystem/FileValidator.java`
```java
package facade.subsystem;

public class FileValidator {
    public boolean validate(String modelPath) {
        System.out.println("[FileValidator] Проверка целостности 3D-сетки файла: " + modelPath);
        return true;
    }
}
```

### `src/facade/subsystem/PrintNotifier.java`
```java
package facade.subsystem;

public class PrintNotifier {
    public void notifyStart(String modelName) {
        System.out.println("[PrintNotifier] Отправка уведомления: Печать '" + modelName + "' успешно запущена.");
    }

    public void notifyError(String reason) {
        System.out.println("[PrintNotifier] Ошибка: " + reason);
    }
}
```

### `src/facade/SmartPrinterFacade.java`
```java
package facade;

import bridge.IFilament;
import bridge.PLAFilament;
import bridge.ABSFilament;
import bridge.PrintJob;
import bridge.PrototypePrintJob;
import bridge.FunctionalPrintJob;
import factory.abstract_factory.factory.IPrintEquipmentFactory;
import factory.abstract_factory.factory.PlaEquipmentFactory;
import factory.abstract_factory.factory.AbsEquipmentFactory;
import factory.abstract_factory.product.INozzle;
import factory.product.IPrintProfile;
import facade.subsystem.FileValidator;
import facade.subsystem.PrintNotifier;

public class SmartPrinterFacade {
    private final FileValidator validator;
    private final PrintNotifier notifier;

    public SmartPrinterFacade() {
        this.validator = new FileValidator();
        this.notifier = new PrintNotifier();
    }

    public void startPrintWorkflow(String modelPath, String materialType, String jobType) {
        System.out.println("=== ЗАПУСК АВТОМАТИЗИРОВАННОГО ПРОЦЕССА ПЕЧАТИ ===");

        if (!validator.validate(modelPath)) {
            notifier.notifyError("Модель содержит ошибки геометрии!");
            return;
        }

        IPrintEquipmentFactory equipmentFactory;
        IFilament filament;

        if ("ABS".equalsIgnoreCase(materialType)) {
            equipmentFactory = new AbsEquipmentFactory();
            filament = new ABSFilament();
        } else {
            equipmentFactory = new PlaEquipmentFactory();
            filament = new PLAFilament();
        }

        INozzle nozzle = equipmentFactory.createNozzle();
        IPrintProfile profile = equipmentFactory.createPrintProfile();

        System.out.println("[Hardware Setup] Установлено сопло: " + nozzle.getMaterial());
        System.out.println("[Profile Config] Загружен профиль: " + profile.getNozzleTemperature());

        PrintJob job;
        if ("Functional".equalsIgnoreCase(jobType)) {
            job = new FunctionalPrintJob(filament);
        } else {
            job = new PrototypePrintJob(filament);
        }

        job.printModel(modelPath);
        notifier.notifyStart(modelPath);
        System.out.println("=================================================");
    }
}
```

### `src/facade/Main.java`
```java
package facade;

public class Main {
    public static void main(String[] args) {
        SmartPrinterFacade printerFacade = new SmartPrinterFacade();

        printerFacade.startPrintWorkflow("gear_component.stl", "ABS", "Functional");
        System.out.println();
        printerFacade.startPrintWorkflow("cat_figurine.stl", "PLA", "Prototype");
    }
}
```