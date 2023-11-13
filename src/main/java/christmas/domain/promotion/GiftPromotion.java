package christmas.domain.promotion;

import christmas.constant.PromotionItem;
import christmas.constant.PromotionType;
import java.util.Arrays;

public class GiftPromotion extends ChristmasPromotion{

    private static final long PRICETHRESHOLD = 120000;
    private static final int START_DATE = 1;
    private static final int END_DATE = 31;
    private static final int INIT_DISCOUNT_AMOUNT = 25000;

    public GiftPromotion(){
        this.period = Arrays.asList(START_DATE, END_DATE);
        this.targetItems = PromotionItem.GIFT_CHAMPAGNE;
        this.discountAmount = INIT_DISCOUNT_AMOUNT;
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
        return orderAmount >= PRICETHRESHOLD;
    }

}
