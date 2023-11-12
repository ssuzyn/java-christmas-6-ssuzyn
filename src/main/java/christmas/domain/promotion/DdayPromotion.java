package christmas.domain.promotion;

import christmas.constant.PromotionItem;
import christmas.constant.PromotionType;
import java.util.Arrays;

public class DdayPromotion extends ChristmasPromotion{

    public DdayPromotion(){
        this.period = Arrays.asList(1, 25);
        this.targetItems = PromotionItem.TOTAL_ORDER_AMOUNT;
        this.discountAmount = 1000;
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
        return orderAmount >= 10000;
    }

    public long getDiscountAmount(int date) {
        return discountAmount + 100L * (date - 1);
    }
}
