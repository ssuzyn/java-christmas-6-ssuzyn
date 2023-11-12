package christmas.dto;

import christmas.constant.Badge;
import christmas.constant.Menu;
import christmas.domain.promotion.ChristmasPromotion;
import java.util.Arrays;
import java.util.HashMap;

public record BenefitsStorage(

        long beforeDiscountAmount,
        boolean giftMenu,
        HashMap<ChristmasPromotion, Long> promotionResult)
{

    public long totalBenefitAmount() {
        return promotionResult.values().stream().mapToLong(Long::longValue).sum();
    }

    public long afterDiscountAmount() {
        long totalBenefit = totalBenefitAmount();

        if (giftMenu()) {
            totalBenefit -= Menu.CHAMPAGNE.getPrice();
        }

        return beforeDiscountAmount - totalBenefit;
    }

    public Badge determineBadge() {
        long totalBenefit = totalBenefitAmount();

        return Arrays.stream(Badge.values())
                .filter(badge -> totalBenefit >= badge.getPrize())
                .reduce((first, second) -> second)
                .orElse(Badge.NONE);
    }

}
