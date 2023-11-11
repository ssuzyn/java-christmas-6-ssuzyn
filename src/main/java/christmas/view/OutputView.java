package christmas.view;

import christmas.constant.Menu;
import christmas.constant.OutputMessage;
import java.util.Map;

public class OutputView {

    public static void printErrorMessage(IllegalArgumentException e){
        System.out.println(e.getMessage());
    }

    public static void printEmptyLine(){
        System.out.println();
    }

    public static void printOrderedMenu(int date, Map<Menu, Integer> orderMenu){
        printDate(date);
        printEmptyLine();
        System.out.println(OutputMessage.ORDER_MENU_PREFIX.getMessage());
        for(Menu menu : orderMenu.keySet()){
            System.out.println(String.format(OutputMessage.ORDER_MENU.getMessage(), menu.getName(), orderMenu.get(menu)));
        }
    }

    private static void printDate(int date){
        System.out.println(String.format(OutputMessage.RESERVATION_DATE.getMessage(), date));
    }

}
