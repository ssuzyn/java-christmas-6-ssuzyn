package christmas.domain.promotion;

import christmas.constant.PromotionItem;
import christmas.constant.PromotionType;
import java.util.Arrays;

public class GiftPromotion extends ChristmasPromotion{
    private final long priceThreshold = 120000;

    public GiftPromotion(){
        this.period = Arrays.asList(1, 31);
        this.targetItems = PromotionItem.GIFT_CHAMPAGNE;
        this.discountAmount = 25000;
        this.promotionType = PromotionType.GIFT;
    }

    @Override
    public long applyPromotion(int data, long orderAmount){
        if(isApplicable(data) && isEligibleForPromotion(orderAmount)){
            return getDiscountAmount();
        }
        return 0L;
    }

    @Override
    protected boolean isApplicable(int date) {
        return date >= period.get(0) && date <= period.get(1);
    }

    @Override
    protected boolean isEligibleForPromotion(long orderAmount){
        return orderAmount >= priceThreshold;
    }

}
