package christmas.validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class InputValidatorTest extends NsTest {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String NO_BENEFITS_DETAIL = "<혜택 내역>" + LINE_SEPARATOR + "없음";
    private static final String NO_BENEFITS_AMOUNT = "<총혜택 금액>" + LINE_SEPARATOR + "0원";

    @Test
    @DisplayName("증정 메뉴 없음 출력 테스트")
    void doNotHaveGift() {
        assertSimpleTest(() -> {
            run("25", "티본스테이크-1,아이스크림-1");
            assertThat(output()).contains("<증정 메뉴>" + LINE_SEPARATOR + "없음");
        });
    }

    @Test
    @DisplayName("음료만 주문한 경우 예외 테스트")
    void onlyBeverageOrder() {
        assertSimpleTest(() -> {
            runException("25", "제로콜라-3");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @ParameterizedTest
    @DisplayName("적용된 이벤트가 하나도 없는 경우 출력 테스트")
    @MethodSource("noPromotionAppliedTestCases")
    void noPromotionApplied(String expectedOutput) {
        assertSimpleTest(() -> {
            run("25", "양송이수프-1, 제로콜라-1");
            assertThat(output()).contains(expectedOutput);
        });
    }

    private static Stream<String> noPromotionAppliedTestCases() {
        return Stream.of(NO_BENEFITS_AMOUNT, NO_BENEFITS_DETAIL);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
