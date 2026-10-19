package facade;

public class FileValidator {
    public boolean validate(String modelPath) {
        if (modelPath == null || modelPath.trim().isEmpty()) {
            System.out.println("[FileValidator] Ошибка: Путь к файлу не может быть пустым.");
            return false;
        }

        String lowerPath = modelPath.toLowerCase();
        if (lowerPath.endsWith(".stl") || lowerPath.endsWith(".obj")) {
            System.out.println("[FileValidator] Проверка целостности 3D-сетки и формата файла: " + modelPath);
            return true;
        }

        System.out.println("[FileValidator] Ошибка: Неподдерживаемый формат файла '" + modelPath + "'. Допустимы только .stl и .obj");
        return false;
    }
}