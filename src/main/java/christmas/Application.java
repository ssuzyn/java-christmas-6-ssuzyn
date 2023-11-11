package christmas;

import christmas.controller.OrderController;
import christmas.exception.ExceptionHandler;
import christmas.exception.RetryExceptionHandler;

public class Application {
    public static void main(String[] args) {
        ExceptionHandler handler = new RetryExceptionHandler();

        OrderController orderController = new OrderController(handler);
        orderController.getOrder();
    }
}
