package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.constant.InputMessage;
import christmas.constant.Menu;
import christmas.util.Parser;
import christmas.validator.InputValidator;
import java.util.HashMap;
import java.util.Map;

public class InputView {

    public static int readVisitDate(){
        System.out.println(InputMessage.WELCOME_STATEMENT.getMessage());
        System.out.println(InputMessage.VISIT_DATE.getMessage());

        String input = Console.readLine();
        InputValidator.validateVisitDate(input);

        return Parser.stringToInteger(input);
    }

    public static Map<Menu, Integer> readMenu(){
        System.out.println(InputMessage.ORDER_MENU.getMessage());
        Map<Menu, Integer> orderMenu = new HashMap<>();

        String input = Console.readLine();
        InputValidator.validateMenuOrder(input, orderMenu);

        return orderMenu;
    }
}
