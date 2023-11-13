package christmas.dto;

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

public class BenefitsStorageTest {

    private static HashMap<ChristmasPromotion, Long> promotionResult;

    @Test
    @DisplayName("총 혜택 금액 계산하는 기능 테스트")
    void testTotalBenefitAmount() {
        initPromotionResult();
        BenefitsStorage benefitsStorage = new BenefitsStorage(20000, false, promotionResult);

        long totalBenefitAmount = benefitsStorage.totalBenefitAmount();

        assertThat(totalBenefitAmount).isEqualTo(7446L);
    }

    @Test
    @DisplayName("증정 메뉴 없는 경우 할인 후 결제금액 계산하는 기능 테스트")
    void testAfterDiscountAmountWithoutGiftMenu() {
        initPromotionResult();
        BenefitsStorage benefitsStorage = new BenefitsStorage(20000, false, promotionResult);

        long afterDiscountAmount = benefitsStorage.afterDiscountAmount();

        assertThat(afterDiscountAmount).isEqualTo(20000 - 7446);
    }

    @Test
    @DisplayName("증정 메뉴 있는 경우 할인 후 결제금액 계산하는 기능 테스트")
    void testAfterDiscountAmountWithGiftMenu() {
        initPromotionResult();
        promotionResult.put(new GiftPromotion(), 25000L);
        BenefitsStorage benefitsStorage = new BenefitsStorage(300000, true, promotionResult);

        long afterDiscountAmount = benefitsStorage.afterDiscountAmount();

        assertThat(afterDiscountAmount).isEqualTo(300000 - 7446);
    }

    void initPromotionResult(){
        promotionResult = new HashMap<>();
        promotionResult.put(new DdayPromotion(), 2400L);
        promotionResult.put(new SpecialPromotion(), 1000L);
        promotionResult.put(new WeekendPromotion(), 4046L);
    }
}
