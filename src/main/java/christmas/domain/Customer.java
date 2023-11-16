package christmas.domain;


import christmas.constant.Menu;
import christmas.constant.MenuType;
import christmas.domain.promotion.ChristmasPromotion;
import java.util.Map;

public class Customer {

    private final int visitDate;
    private final Map<Menu, Integer> orderMenu;
    private final long totalOrderAmount;


    public Customer(int visitDate, Map<Menu, Integer> orderMenu){
        this.visitDate = visitDate;
        this.orderMenu = orderMenu;
        this.totalOrderAmount = calculatePrice();
    }

    public long calculatePrice(){
        long total = 0;

        for(Menu menu: orderMenu.keySet()){
            total += (long) menu.getPrice() * orderMenu.get(menu);
        }
        return total;
    }

    public long applicablePromotion(ChristmasPromotion promotion){

        return promotion.applyPromotion(visitDate, totalOrderAmount);
    }

    public long getTotalOrderAmount() {
        return totalOrderAmount;
    }

   public int countMenuType(MenuType menuType) {
        int count = 0;

        for (Menu menu : orderMenu.keySet()) {
            if (menu.getMenuType() == menuType) {
                count += orderMenu.get(menu);
            }
        }

        return count;
    }

}
