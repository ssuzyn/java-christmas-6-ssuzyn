package christmas.controller;

import christmas.constant.Menu;
import christmas.dto.BenefitsStorage;
import christmas.domain.Customer;
import christmas.domain.EventPlanner;
import christmas.dto.OrderMenu;
import christmas.exception.ExceptionHandler;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class ChristmasController {

    private final ExceptionHandler handler;
    private Customer customer;
    private EventPlanner eventPlanner;


    public ChristmasController(ExceptionHandler handler){
        this.handler = handler;
    }

    public void service(){
        order();
        searchPromotion(customer);
    }
    public void order(){
        int date = getDate();
        Map<Menu, Integer> menu = getMenu();
        customer = new Customer(date, menu);

        displayOrder(date, menu);
    }

    private int getDate(){
        return handler.getResult(InputView::readVisitDate);
    }

    private Map<Menu, Integer> getMenu(){
        return handler.getResult(InputView::readMenu);
    }

    private void searchPromotion(Customer customer){
        eventPlanner = new EventPlanner();
        eventPlanner.findPromotion(customer);

    }

    private BenefitsStorage storeBenefits(){
        if(eventPlanner.hasGiftMenu()){
            return new BenefitsStorage(customer.getTotalOrderAmount(), true, eventPlanner.getPromotionResult());
        }
        return new BenefitsStorage(customer.getTotalOrderAmount(), false, eventPlanner.getPromotionResult());
    }

    private void displayOrder(int date, Map<Menu, Integer> menu){
        OrderMenu orderMenu = new OrderMenu(date, menu);
        OutputView.printOrder(orderMenu);
    }


}
