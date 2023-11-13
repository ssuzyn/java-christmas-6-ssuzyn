package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constant.Menu;
import christmas.domain.promotion.ChristmasPromotion;
import christmas.domain.promotion.DdayPromotion;
import christmas.domain.promotion.GiftPromotion;
import christmas.domain.promotion.SpecialPromotion;
import christmas.domain.promotion.WeekDayPromotion;
import christmas.domain.promotion.WeekendPromotion;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class EventPlannerTest {

    private static Map<ChristmasPromotion, Long> promotionResult;

    @ParameterizedTest
    @DisplayName("크리스마스 디데이 할인이 적용되는 경우 테스트")
    @MethodSource("provideDdayDates")
    void findDdayPromotion(int input){
        EventPlanner eventPlanner = new EventPlanner();
        Customer customer = new Customer(input, Map.of(Menu.T_BONE_STEAK, 2, Menu.CHRISTMAS_PASTA, 1));

        eventPlanner.findPromotion(customer);
        promotionResult = eventPlanner.getPromotionResult();

        assertThat(promotionResult.entrySet().stream()
                .filter(entry -> entry.getKey() instanceof DdayPromotion)
                .mapToLong(Map.Entry::getValue)
                .sum())
                .isGreaterThan(0);
    }

    private static Stream<Integer> provideDdayDates() {
        return IntStream.rangeClosed(1, 25).boxed();
    }

    @ParameterizedTest
    @DisplayName("증정 이벤트가 적용되는 경우 테스트")
    @MethodSource("provideGiftDates")
    void findGiftPromotion(int input){
        EventPlanner eventPlanner = new EventPlanner();
        Customer customer = new Customer(input, Map.of(Menu.T_BONE_STEAK, 2, Menu.CHRISTMAS_PASTA, 1));

        eventPlanner.findPromotion(customer);
        promotionResult = eventPlanner.getPromotionResult();

        assertThat(promotionResult.entrySet().stream()
                .filter(entry -> entry.getKey() instanceof GiftPromotion)
                .mapToLong(Map.Entry::getValue)
                .sum())
                .isGreaterThan(0);
    }

    private static Stream<Integer> provideGiftDates() {
        return IntStream.rangeClosed(1, 31).boxed();
    }

    @ParameterizedTest
    @DisplayName("특별 할인 적용되는 경우 테스트")
    @ValueSource(ints = {3,10,17,24,25,31})
    void findSpecialPromotion(int input){
        EventPlanner eventPlanner = new EventPlanner();
        Customer customer = new Customer(input, Map.of(Menu.T_BONE_STEAK, 2, Menu.CHRISTMAS_PASTA, 1));

        eventPlanner.findPromotion(customer);
        promotionResult = eventPlanner.getPromotionResult();

        assertThat(promotionResult.entrySet().stream()
                .filter(entry -> entry.getKey() instanceof SpecialPromotion)
                .mapToLong(Map.Entry::getValue)
                .sum())
                .isGreaterThan(0);
    }

    @ParameterizedTest
    @DisplayName("평일 할인이 적용되는 경우 테스트")
    @ValueSource(ints = {4,5,6,7,11,12,13,14,18,19,20,21,25,26,27,28})
    void findWeekDayPromotion(int input){
        EventPlanner eventPlanner = new EventPlanner();
        Customer customer = new Customer(input, Map.of(Menu.T_BONE_STEAK, 2, Menu.CHOCO_CAKE, 1));

        eventPlanner.findPromotion(customer);
        promotionResult = eventPlanner.getPromotionResult();

        assertThat(promotionResult.entrySet().stream()
                .filter(entry -> entry.getKey() instanceof WeekDayPromotion)
                .mapToLong(Map.Entry::getValue)
                .sum())
                .isGreaterThan(0);
    }

    @ParameterizedTest
    @DisplayName("주말 할인이 적용되는 경우 테스트")
    @ValueSource(ints = {1,2,8,9,15,16,22,23,29,30})
    void findWeekendPromotion(int input){
        EventPlanner eventPlanner = new EventPlanner();
        Customer customer = new Customer(input, Map.of(Menu.T_BONE_STEAK, 2, Menu.CHRISTMAS_PASTA, 1));

        eventPlanner.findPromotion(customer);
        promotionResult = eventPlanner.getPromotionResult();

        assertThat(promotionResult.entrySet().stream()
                .filter(entry -> entry.getKey() instanceof WeekendPromotion)
                .mapToLong(Map.Entry::getValue)
                .sum())
                .isGreaterThan(0);
    }
}
