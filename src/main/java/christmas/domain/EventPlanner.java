package christmas.domain;

import christmas.constant.MenuType;
import christmas.constant.PromotionType;
import christmas.domain.promotion.ChristmasPromotion;
import christmas.domain.promotion.DdayPromotion;
import christmas.domain.promotion.GiftPromotion;
import christmas.domain.promotion.SpecialPromotion;
import christmas.domain.promotion.WeekDayPromotion;
import christmas.domain.promotion.WeekendPromotion;
import java.util.HashMap;
import java.util.Map;

public class EventPlanner {
    private HashMap<ChristmasPromotion, Long> promotionResult;

    public EventPlanner(){
        promotionResult = new HashMap<>();
        promotionResult.put(new DdayPromotion(), 0L);
        promotionResult.put(new GiftPromotion(), 0L);
        promotionResult.put(new SpecialPromotion(), 0L);
        promotionResult.put(new WeekDayPromotion(), 0L);
        promotionResult.put(new WeekendPromotion(), 0L);
    }

    public void findPromotion(Customer customer){
        for(ChristmasPromotion promotion : promotionResult.keySet()){
            checkPromotionConditions(promotion, customer);
        }
    }

    public boolean hasGiftMenu(){
        return promotionResult.entrySet()
                .stream()
                .filter(entry -> entry.getKey() instanceof GiftPromotion)
                .mapToLong(Map.Entry::getValue)
                .sum() > 0;
    }

    public HashMap<ChristmasPromotion, Long> getPromotionResult(){
        return promotionResult;
    }

    private void checkPromotionConditions(ChristmasPromotion promotion, Customer customer){
        long discount = customer.applicablePromotion(promotion);

        if (isContainWeekOrWeekend(promotion)) {
            discount *= checkMenuCount(customer, promotion.getPromotionType());
        }
        promotionResult.put(promotion, promotionResult.get(promotion) + discount);
    }

    private int checkMenuCount(Customer customer, PromotionType promotionType) {
        Map<PromotionType, MenuType> promotionTypeMenuTypeMap = Map.of(
                PromotionType.WEEKDAY, MenuType.DESSERT,
                PromotionType.WEEKEND, MenuType.MAIN
        );

        MenuType menuType = promotionTypeMenuTypeMap.getOrDefault(promotionType, MenuType.NONE);
        return customer.countMenuType(menuType);
    }

    private boolean isContainWeekOrWeekend(ChristmasPromotion promotion){
        if(promotion.getPromotionType() == PromotionType.WEEKDAY
                || promotion.getPromotionType() == PromotionType.WEEKEND)
            return true;

        return false;
    }

}
