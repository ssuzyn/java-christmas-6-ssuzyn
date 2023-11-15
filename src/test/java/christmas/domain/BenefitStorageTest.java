package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constant.Badge;
import christmas.domain.promotion.ChristmasPromotion;
import christmas.domain.promotion.DdayPromotion;
import christmas.domain.promotion.GiftPromotion;
import christmas.domain.promotion.SpecialPromotion;
import christmas.domain.promotion.WeekendPromotion;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BenefitStorageTest {

    private static HashMap<ChristmasPromotion, Long> promotionResult;

    @Test
    @DisplayName("총 혜택 금액 계산하는 기능 테스트")
    void testTotalBenefitAmount() {
        initPromotionResult();
        BenefitStorage benefitStorage = new BenefitStorage(20000, false, promotionResult);

        long totalBenefitAmount = benefitStorage.totalBenefitAmount();

        assertThat(totalBenefitAmount).isEqualTo(7446L);
    }

    @Test
    @DisplayName("증정 메뉴 없는 경우 할인 후 결제금액 계산하는 기능 테스트")
    void testAfterDiscountAmountWithoutGiftMenu() {
        initPromotionResult();
        BenefitStorage benefitStorage = new BenefitStorage(20000, false, promotionResult);

        long afterDiscountAmount = benefitStorage.afterDiscountAmount();

        assertThat(afterDiscountAmount).isEqualTo(20000 - 7446);
    }

    @Test
    @DisplayName("증정 메뉴 있는 경우 할인 후 결제금액 계산하는 기능 테스트")
    void testAfterDiscountAmountWithGiftMenu() {
        initPromotionResult();
        promotionResult.put(new GiftPromotion(), 25000L);
        BenefitStorage benefitStorage = new BenefitStorage(300000, true, promotionResult);

        long afterDiscountAmount = benefitStorage.afterDiscountAmount();

        assertThat(afterDiscountAmount).isEqualTo(300000 - 7446);
    }

    @Test
    @DisplayName("별 배지 결정 기능 테스트")
    void testDetermineBadgeWithStar() {
        initPromotionResult(6_000);
        BenefitStorage benefitStorage = new BenefitStorage(20_000, false, promotionResult);

        Badge badge = benefitStorage.determineBadge();

        assertThat(badge).isEqualTo(Badge.STAR);
    }

    @Test
    @DisplayName("트리 배지 결정 기능 테스트")
    void testDetermineBadgeWithTree() {
        initPromotionResult(12_000);
        BenefitStorage benefitStorage = new BenefitStorage(20_000, false, promotionResult);

        Badge badge = benefitStorage.determineBadge();

        assertThat(badge).isEqualTo(Badge.TREE);
    }

    @Test
    @DisplayName("산타 배지 결정 기능 테스트")
    void testDetermineBadgeWithSanta() {
        initPromotionResult(21_000);
        BenefitStorage benefitStorage = new BenefitStorage(20_000, false, promotionResult);

        Badge badge = benefitStorage.determineBadge();

        assertThat(badge).isEqualTo(Badge.SANTA);
    }

    @Test
    @DisplayName("해당하는 배지가 없는 경우 테스트")
    void testDetermineBadgeWithNoBadge() {
        initPromotionResult(4_000);
        BenefitStorage benefitStorage = new BenefitStorage(4_000, false, promotionResult);

        Badge badge = benefitStorage.determineBadge();

        assertThat(badge).isEqualTo(Badge.NONE);
    }

    void initPromotionResult(long totalBenefit) {
        promotionResult = new HashMap<>();
        promotionResult.put(new DdayPromotion(), totalBenefit / 3);
        promotionResult.put(new SpecialPromotion(), totalBenefit / 3);
        promotionResult.put(new WeekendPromotion(), totalBenefit / 3);
    }

    void initPromotionResult(){
        promotionResult = new HashMap<>();
        promotionResult.put(new DdayPromotion(), 2400L);
        promotionResult.put(new SpecialPromotion(), 1000L);
        promotionResult.put(new WeekendPromotion(), 4046L);
    }
}
