package christmas.controller;

import christmas.constant.Menu;
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
        displayOrderMenu(date, menu);
    }

    private int getDate(){
        return handler.getResult(InputView::readVisitDate);
    }

    private Map<Menu, Integer> getMenu(){
        return handler.getResult(InputView::readMenu);
    }

    private void displayOrderMenu(int date, Map<Menu, Integer> menu){
        OutputView.printOrderedMenu(date, menu);
    }
}
