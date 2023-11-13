package christmas.domain.promotion;

import christmas.constant.PromotionItem;
import christmas.constant.PromotionType;
import java.util.Arrays;

public class SpecialPromotion extends ChristmasPromotion{

    private static final int INIT_DISCOUNT_AMOUNT = 1000;
    private static final int MIN_ORDER_AMOUNT = 10000;

    public SpecialPromotion(){
        this.period = Arrays.asList(3, 10, 17, 24, 25, 31);
        this.targetItems = PromotionItem.TOTAL_ORDER_AMOUNT;
        this.discountAmount = INIT_DISCOUNT_AMOUNT;
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
        return orderAmount >= MIN_ORDER_AMOUNT;
    }


}
