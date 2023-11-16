package christmas.exception;

import christmas.view.OutputView;
import java.util.function.Supplier;

public class RetryExceptionHandler implements ExceptionHandler{

    @Override
    public <T> T getResult(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                printException(e);
            } finally {
                afterHandlingException();
            }
        }
    }

    private void printException(IllegalArgumentException e) {
        OutputView.printErrorMessage(e);
    }

    private void afterHandlingException() {
        OutputView.printEmptyLine();
    }
}
