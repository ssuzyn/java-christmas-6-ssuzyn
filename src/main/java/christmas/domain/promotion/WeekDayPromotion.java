package christmas.domain.promotion;

import christmas.constant.PromotionItem;
import christmas.constant.PromotionType;
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.util.Arrays;

public class WeekDayPromotion extends ChristmasPromotion{

    public WeekDayPromotion(){
        this.period = Arrays.asList(1, 31);
        this.targetItems = PromotionItem.DESSERT_MENU;
        this.discountAmount = 2023;
        this.promotionType = PromotionType.WEEKDAY;
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
        LocalDate orderDate = LocalDate.of(2023, 12, date);

        return isWeekday(orderDate);
    }

    @Override
    protected boolean isEligibleForPromotion(long orderAmount){
        return orderAmount >= 10000;
    }

    private boolean isWeekday(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek != DayOfWeek.FRIDAY && dayOfWeek != DayOfWeek.SATURDAY;
    }
}
