package christmas.validator;

import christmas.constant.Menu;
import christmas.constant.MenuType;
import christmas.exception.ErrorCode;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InputValidator {

    private static int START_DATE = 1;
    private static int END_DATE = 31;
    private static String COMMA = ",";
    private static String HYPHEN = "-";
    private static int MENU_FORMAT_LENGTH = 2;
    private static int MINIMUM_ORDER_COUNT = 1;
    private static int MAXIMUN_ORDER_COUNT = 20;

    public static void validateVisitDate(String input){
        validateInteger(input);
        validateNumberInRange(Integer.parseInt(input));
    }

    public static Map<Menu, Integer> validateMenuOrder(String input, Map<Menu, Integer> orderMenu){
        String[] orders = input.split(COMMA);
        Set<Menu> uniqueMenu = new HashSet<>();

        for (String order : orders) {
            validate(order, orderMenu, uniqueMenu);
        }

        validateOnlyBeverage(orderMenu);
        validateMaxOrder(orderMenu);

        return orderMenu;
    }

    private static void validate(String order, Map<Menu, Integer> orderMenu, Set<Menu> uniqueMenu){
        String[] parts = validateMenuOrderFormat(order.trim());

        String menuName = parts[0];
        String quantity = parts[1];

        Menu menu = getMenuByName(menuName);

        validateMenuFound(menu);
        validateMinimumOrder(quantity);
        validateDuplicateMenu(menu, uniqueMenu);

        orderMenu.put(menu, Integer.parseInt(quantity));
    }

    private static void validateInteger(String input){
        if(!input.chars().allMatch(Character::isDigit)){
            throw new IllegalArgumentException(ErrorCode.NOT_INTEGER.getMessage());
        }
    }

    private static void validateNumberInRange(int input){
        if(input > END_DATE || input < START_DATE)
            throw new IllegalArgumentException(ErrorCode.INVALID_DATE.getMessage());
    }

    private static String[] validateMenuOrderFormat(String orders){
        String[] parts = orders.split(HYPHEN);
        if (parts.length != MENU_FORMAT_LENGTH)
            throw new IllegalArgumentException(ErrorCode.INVALID_MENU.getMessage());

        return parts;
    }

    private static void validateMenuFound(Menu menu){
        if(menu == null)
            throw new IllegalArgumentException(ErrorCode.INVALID_MENU.getMessage());
    }

    private static void validateMinimumOrder(String quantity){
        if(!quantity.chars().allMatch(Character::isDigit))
            throw new IllegalArgumentException(ErrorCode.INVALID_MENU.getMessage());

        if(Integer.parseInt(quantity) < MINIMUM_ORDER_COUNT)
            throw new IllegalArgumentException(ErrorCode.INVALID_MENU.getMessage());
    }

    private static void validateMaxOrder(Map<Menu, Integer> orderMenu){
        int orderCount = 0;
        for(Menu menu: orderMenu.keySet()) {
            orderCount += orderMenu.get(menu);
        }

        if(orderCount > MAXIMUN_ORDER_COUNT)
            throw new IllegalArgumentException(ErrorCode.INVALID_MENU.getMessage());
    }

    private static void validateDuplicateMenu(Menu menu, Set<Menu> uniqueMenu){
        if(!uniqueMenu.add(menu))
            throw new IllegalArgumentException(ErrorCode.INVALID_MENU.getMessage());
    }


    private static void validateOnlyBeverage(Map<Menu, Integer> orderMenu){
        boolean allBeverages = orderMenu.keySet().stream()
                .allMatch(menu -> menu.getMenuType() == MenuType.BEVERAGE);

        if (allBeverages) {
            throw new IllegalArgumentException(ErrorCode.INVALID_MENU.getMessage());
        }
    }

    private static Menu getMenuByName(String name) {
        for (Menu menu : Menu.values()) {
            if (menu.getName().equalsIgnoreCase(name)) {
                return menu;
            }
        }
        return null;
    }
}
