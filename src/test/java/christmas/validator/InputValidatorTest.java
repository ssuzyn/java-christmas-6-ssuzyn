package christmas.validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest extends NsTest {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    @DisplayName("증정 메뉴 없음 출력 테스트")
    void doNotHaveGift() {
        assertSimpleTest(() -> {
            run("25", "티본스테이크-1,아이스크림-1");
            assertThat(output()).contains("<증정 메뉴>" + LINE_SEPARATOR + "없음");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
