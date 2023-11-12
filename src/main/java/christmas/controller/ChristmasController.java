package christmas.controller;

import christmas.constant.Menu;
import christmas.domain.Customer;
import christmas.domain.EventPlanner;
import christmas.exception.ExceptionHandler;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class ChristmasController {

    final private ExceptionHandler handler;

    public ChristmasController(ExceptionHandler handler){
        this.handler = handler;
    }

    public void order(){
        int date = getDate();
        Map<Menu, Integer> menu = getMenu();
        Customer customer = new Customer(date, menu);
        displayOrderMenu(date, menu);

        searchPromotion(customer);
    }

    private int getDate(){
        return handler.getResult(InputView::readVisitDate);
    }

    private Map<Menu, Integer> getMenu(){
        return handler.getResult(InputView::readMenu);
    }

    private void searchPromotion(Customer customer){
        EventPlanner eventPlanner = new EventPlanner();
        eventPlanner.findPromotion(customer);

        displayTotalAmount(eventPlanner.getTotalOrderAmount());
    }

    private void displayOrderMenu(int date, Map<Menu, Integer> menu){
        OutputView.printOrderedMenu(date, menu);
    }

    private void displayTotalAmount(long total){
        OutputView.printTotalAmount(total);
    }

}
