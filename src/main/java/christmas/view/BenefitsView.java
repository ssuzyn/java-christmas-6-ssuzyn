package christmas.view;

import christmas.constant.Badge;
import christmas.constant.OutputMessage;
import christmas.domain.promotion.ChristmasPromotion;
import java.util.HashMap;

public class BenefitsView {

    public static String giftMenuOutputStatement(boolean giftMenu){
        if(giftMenu)
            return OutputMessage.CHAMPAGNE.getMessage();

        return OutputMessage.DOES_NOT_EXIST.getMessage();
    }

    public static String promotionResultOutputStatement(long totalBenefitAmount, HashMap<ChristmasPromotion, Long> promotionResult){
        if(totalBenefitAmount == 0)
            return OutputMessage.DOES_NOT_EXIST.getMessage();

        return findPromotionDetail(promotionResult).toString();
    }

    public static String badgeOutputStatement(Badge badge){
        if(badge == Badge.NONE)
            return OutputMessage.DOES_NOT_EXIST.getMessage();
        return badge.getBadgeName();
    }

    private static StringBuilder findPromotionDetail(HashMap<ChristmasPromotion, Long> promotionResult){
        StringBuilder sb = new StringBuilder();
        for(ChristmasPromotion promotion: promotionResult.keySet()){
            long discount = promotionResult.get(promotion);
            if(discount == 0) continue;

            String promotionMessage = promotion.getPromotionType().getMessage();
            sb.append(String.format(OutputMessage.BENEFIT_DETAILS.getMessage(), promotionMessage, discount));
        }
        return sb;
    }
}
