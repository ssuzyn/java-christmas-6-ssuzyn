package christmas.exception;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RetryExceptionHandlerTest {

    ExceptionHandler handler = new RetryExceptionHandler();

    @Test
    @DisplayName("예외 발생시 해당하는 예외 출력 후 다시 실행한다.")
    public void retryExceptionTest() {
        List<String> money = new ArrayList<>(List.of("christmas", "1000"));

        int a = handler.getResult(() -> {
            String str = money.remove(0);
            return Integer.parseInt(str);
        });

        Assertions.assertThat(a).isEqualTo(1000);
    }
}
