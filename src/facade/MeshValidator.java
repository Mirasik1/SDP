package facade;

public class MeshValidator {
    public boolean validate(String modelPath) {
        System.out.println("[MeshValidator] Проверка целостности 3D-сетки файла: " + modelPath);
        return true;
    }
}