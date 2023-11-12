package christmas.domain;

import christmas.domain.promotion.ChristmasPromotion;
import christmas.domain.promotion.DdayPromotion;
import christmas.domain.promotion.GiftPromotion;
import christmas.domain.promotion.SpecialPromotion;
import christmas.domain.promotion.WeekDayPromotion;
import christmas.domain.promotion.WeekendPromotion;
import java.util.HashMap;

public class EventPlanner {
    private HashMap<ChristmasPromotion, Boolean> promotions;
    private long totalOrderAmount;
    private String badge;

    public EventPlanner(){
        promotions = new HashMap<>();
        promotions.put(new DdayPromotion(), false);
        promotions.put(new GiftPromotion(), false);
        promotions.put(new SpecialPromotion(), false);
        promotions.put(new WeekDayPromotion(), false);
        promotions.put(new WeekendPromotion(), false);
    }

    public void findPromotion(Customer customer){
        calculatePrice(customer);
        checkTotalAmount();

    }

    public boolean checkTotalAmount(){
        return totalOrderAmount >= 10000;
    }

    private void calculatePrice(Customer customer){
        this.totalOrderAmount = customer.calculatePrice();
    }

    public long getTotalOrderAmount() {
        return totalOrderAmount;
    }


}
