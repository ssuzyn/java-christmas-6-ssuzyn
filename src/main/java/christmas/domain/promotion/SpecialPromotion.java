package christmas.domain.promotion;

import christmas.constant.PromotionItem;
import christmas.constant.PromotionType;
import java.util.Arrays;

public class SpecialPromotion extends ChristmasPromotion{

    public SpecialPromotion(){
        this.period = Arrays.asList(3, 10, 17, 24, 25, 31);
        this.targetItems = PromotionItem.TOTAL_ORDER_AMOUNT;
        this.discountAmount = 1000;
        this.promotionType = PromotionType.SPECIAL;
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
        return period.contains(date);
    }

    @Override
    protected boolean isEligibleForPromotion(long orderAmount){
        return orderAmount >= 10000;
    }


}
