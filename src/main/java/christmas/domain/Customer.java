package christmas.domain;


import christmas.constant.Menu;
import christmas.constant.MenuType;
import christmas.domain.promotion.ChristmasPromotion;
import java.util.Map;

public class Customer {

    private final int visitDate;
    private final Map<Menu, Integer> orderMenu;


    public Customer(int visitDate, Map<Menu, Integer> orderMenu){
        this.visitDate = visitDate;
        this.orderMenu = orderMenu;
    }

    public long calculatePrice(){
        long total = 0;

        for(Menu menu: orderMenu.keySet()){
            total += (long) menu.getPrice() * orderMenu.get(menu);
        }
        return total;
    }


    public boolean applicableDate(ChristmasPromotion promotion){
        return promotion.isApplicable(visitDate);
    }



    private int countMenuType(MenuType menuType) {
        int count = 0;

        for (Menu menu : orderMenu.keySet()) {
            if (menu.getMenuType() == menuType) {
                count++;
            }
        }
        return count;
    }

}
