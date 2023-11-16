package christmas.domain.promotion;

import christmas.constant.PromotionItem;
import christmas.constant.PromotionType;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;

public class WeekendPromotion extends ChristmasPromotion{

    private static final int START_DATE = 1;
    private static final int END_DATE = 31;
    private static final int INIT_DISCOUNT_AMOUNT = 2023;
    private static final int MIN_ORDER_AMOUNT = 10000;

    public WeekendPromotion(){
        this.period = Arrays.asList(START_DATE, END_DATE);
        this.targetItems = PromotionItem.MAIN_MENU;
        this.discountAmount = INIT_DISCOUNT_AMOUNT;
        this.promotionType = PromotionType.WEEKEND;
    }

    @Override
    public long applyPromotion(int data, long orderAmount){
        if(isApplicable(data) && isEligibleForPromotion(orderAmount)){
            return getDiscountAmount();
        }
        return 0L;
    }

    @Override
    public boolean isApplicable(int date) {
        LocalDate orderDate = LocalDate.of(2023, 12, date);

        return isWeekend(orderDate);
    }

    @Override
    protected boolean isEligibleForPromotion(long orderAmount){
        return orderAmount >= MIN_ORDER_AMOUNT;
    }

    private boolean isWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }
}
