package christmas.domain;

import christmas.constant.Badge;
import christmas.constant.Menu;
import christmas.domain.promotion.ChristmasPromotion;
import java.util.Arrays;
import java.util.HashMap;

public class BenefitStorage {

    private final long beforeDiscountAmount;
    private final boolean giftMenu;
    private final HashMap<ChristmasPromotion, Long> promotionResult;

    public BenefitStorage(long beforeDiscountAmount, boolean giftMenu, HashMap<ChristmasPromotion, Long> promotionResult){
        this.beforeDiscountAmount = beforeDiscountAmount;
        this.giftMenu = giftMenu;
        this.promotionResult = promotionResult;
    }

    public long totalBenefitAmount() {
        return promotionResult.values().stream().mapToLong(Long::longValue).sum();
    }

    public long afterDiscountAmount() {
        long totalBenefit = totalBenefitAmount();

        if (giftMenu) {
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

    public long getBeforeDiscountAmount() {
        return beforeDiscountAmount;
    }

    public boolean isGiftMenu() {
        return giftMenu;
    }

    public HashMap<ChristmasPromotion, Long> getPromotionResult() {
        return promotionResult;
    }
}
