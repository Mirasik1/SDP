package facade.subsystem;

public class PrintNotifier {
    public void notifyStart(String modelName) {
        System.out.println("[PrintNotifier] Отправка уведомления: Печать '" + modelName + "' успешно запущена.");
    }

    public void notifyError(String reason) {
        System.out.println("[PrintNotifier] Ошибка: " + reason);
    }
}