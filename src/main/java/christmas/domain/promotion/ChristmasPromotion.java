package christmas.domain.promotion;

import christmas.constant.PromotionItem;
import christmas.constant.PromotionType;
import java.util.List;

public abstract class ChristmasPromotion {

    protected List<Integer> period;
    protected PromotionItem targetItems;
    protected long discountAmount;
    protected PromotionType promotionType;

    public long getDiscountAmount() {
        return discountAmount;
    }

    public PromotionType getPromotionType(){
        return promotionType;
    }

    public abstract long applyPromotion(int data, long orderAmount);
    protected abstract boolean isApplicable(int date);
    protected abstract boolean isEligibleForPromotion(long orderAmount);

}
