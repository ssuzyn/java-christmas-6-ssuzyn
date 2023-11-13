package christmas.domain.promotion;

import christmas.constant.PromotionItem;
import christmas.constant.PromotionType;
import java.util.Arrays;

public class DdayPromotion extends ChristmasPromotion{

    private static final int START_DATE = 1;
    private static final int END_DATE = 25;
    private static final int INIT_DISCOUNT_AMOUNT = 1000;
    private static final int MIN_ORDER_AMOUNT = 10000;


    public DdayPromotion(){
        this.period = Arrays.asList(START_DATE, END_DATE);
        this.targetItems = PromotionItem.TOTAL_ORDER_AMOUNT;
        this.discountAmount = INIT_DISCOUNT_AMOUNT;
        this.promotionType = PromotionType.DDAY;
    }

    @Override
    public long applyPromotion(int data, long orderAmount){
        if(isApplicable(data) && isEligibleForPromotion(orderAmount)){
            return getDiscountAmount(data);
        }
        return 0L;
    }

    @Override
    protected boolean isApplicable(int date) {
        return date >= period.get(0) && date <= period.get(1);
    }

    @Override
    protected boolean isEligibleForPromotion(long orderAmount){
        return orderAmount >= MIN_ORDER_AMOUNT;
    }

    public long getDiscountAmount(int date) {
        return discountAmount + 100L * (date - 1);
    }
}
