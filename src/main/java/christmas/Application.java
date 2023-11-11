package christmas;

import christmas.controller.ChristmasController;
import christmas.exception.ExceptionHandler;
import christmas.exception.RetryExceptionHandler;

public class Application {
    public static void main(String[] args) {
        ExceptionHandler handler = new RetryExceptionHandler();

        ChristmasController controller = new ChristmasController(handler);
        controller.order();
    }
}
