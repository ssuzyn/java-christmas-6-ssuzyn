package christmas.view;

import christmas.constant.Badge;
import christmas.constant.Menu;
import christmas.constant.OutputMessage;
import christmas.domain.promotion.ChristmasPromotion;
import christmas.dto.BenefitResult;
import christmas.dto.OrderMenu;
import java.util.HashMap;
import java.util.Map;

public class OutputView {

    public static void printErrorMessage(IllegalArgumentException e){
        System.out.println(e.getMessage());
    }

    public static void printEmptyLine(){
        System.out.println();
    }

    public static void printOrder(OrderMenu orderMenu){
        printDate(orderMenu.date());
        printEmptyLine();
        printOrderedMenu(orderMenu.menu());
    }

    public static void printPreview(BenefitResult benefits){
        printBeforeDiscountAmount(benefits.beforeDiscountAmount());
        printHasGift(benefits.giftMenu());
        printBenefitsDetail(benefits.beforeDiscountAmount(), benefits.promotionResult());
        printTotalBenefits(benefits.totalBenefitAmount());
        printAfterDiscountAmount(benefits.afterDiscountAmount());
        printBadge(benefits.badge());
    }

    private static void printOrderedMenu(Map<Menu, Integer> orderMenu){
        System.out.println(String.format(OutputMessage.ORDER_MENU_PREFIX.getMessage(),
                OrderMenuView.orderMenuOutputStatement(orderMenu)));
    }

    private static void printDate(int date){
        System.out.println(String.format(OutputMessage.RESERVATION_DATE.getMessage(), date));
    }

    private static void printBeforeDiscountAmount(long total){
        System.out.println(String.format(OutputMessage.BEFORE_DISCOUNT_AMOUNT.getMessage(), total));
    }

    private static void printHasGift(boolean hasGift){
        System.out.println(String.format(OutputMessage.GIVEAWAY_MENU.getMessage(),
                BenefitsView.giftMenuOutputStatement(hasGift)));

    }

    private static void printBenefitsDetail(long price, HashMap<ChristmasPromotion, Long> result){
        System.out.println(String.format(OutputMessage.BENEFIT_DETAILS_PREFIX.getMessage(),
                BenefitsView.promotionResultOutputStatement(price, result)));
    }

    private static void printTotalBenefits(long price){
        System.out.println(String.format(OutputMessage.TOTAL_BENEFIT_AMOUNT.getMessage(), -price));
    }

    private static void printAfterDiscountAmount(long price){
        System.out.println(String.format(OutputMessage.AFTER_DISCOUNT_AMOUNT.getMessage(), price));
    }

    private static void printBadge(Badge badge){
        System.out.println(String.format(OutputMessage.PROMOTION_BADGE.getMessage(),
                BenefitsView.badgeOutputStatement(badge)));
    }

}
