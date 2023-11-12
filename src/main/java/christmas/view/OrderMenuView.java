package christmas.view;

import christmas.constant.Menu;
import christmas.constant.OutputMessage;
import java.util.Map;

public class OrderMenuView {

    public static String orderMenuOutputStatement(Map<Menu, Integer> orderMenu){
        StringBuilder sb = new StringBuilder();
        for(Menu menu : orderMenu.keySet()){
            sb.append(String.format(OutputMessage.ORDER_MENU.getMessage(), menu.getName(), orderMenu.get(menu)));
        }
        return sb.toString();
    }
}
