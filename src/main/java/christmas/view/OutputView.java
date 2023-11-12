package christmas.view;

import christmas.constant.Badge;
import christmas.constant.Menu;
import christmas.constant.OutputMessage;
import christmas.domain.promotion.ChristmasPromotion;
import christmas.dto.BenefitsStorage;
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

    private static void printOrderedMenu(Map<Menu, Integer> orderMenu){

        System.out.println(String.format(OutputMessage.ORDER_MENU_PREFIX.getMessage(),
                OrderMenuView.orderMenuOutputStatement(orderMenu)));
    }

    private static void printDate(int date){
        System.out.println(String.format(OutputMessage.RESERVATION_DATE.getMessage(), date));
    }

}
