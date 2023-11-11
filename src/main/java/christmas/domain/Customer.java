package christmas.domain;


import christmas.constant.Menu;
import java.util.Map;

public class Customer {

    private final int visitDate;
    private final Map<Menu, Integer> orderMenu;
    private final long totalOrderAmount;

    public Customer(int visitDate, Map<Menu, Integer> orderMenu){
        this.visitDate = visitDate;
        this.orderMenu = orderMenu;
        this.totalOrderAmount = calculatePrice(orderMenu);
    }

    private long calculatePrice(Map<Menu, Integer> orderMenu){
        long total = 0;

        for(Menu menu: orderMenu.keySet()){
            total += (long) menu.getPrice() * orderMenu.get(menu);
        }
        return total;
    }

    public long getTotalOrderAmount() {
        return totalOrderAmount;
    }
}
