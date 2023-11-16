package christmas.dto;

import christmas.constant.Badge;
import christmas.domain.promotion.ChristmasPromotion;
import java.util.HashMap;

public record BenefitResult(

        long beforeDiscountAmount,
        boolean giftMenu,
        HashMap<ChristmasPromotion, Long> promotionResult,
        long totalBenefitAmount,
        long afterDiscountAmount,
        Badge badge)
{

}
