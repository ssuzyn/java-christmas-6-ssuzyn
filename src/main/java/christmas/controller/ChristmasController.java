package christmas.controller;

import christmas.constant.Menu;
import christmas.exception.ExceptionHandler;
import christmas.view.InputView;
import java.util.Map;

public class ChristmasController {

    final private ExceptionHandler handler;

    public ChristmasController(ExceptionHandler handler){
        this.handler = handler;
    }

    public void order(){
        int date = getDate();
        Map<Menu, Integer> menu = getMenu();
    }

    public int getDate(){
        return handler.getResult(InputView::readVisitDate);
    }

    public Map<Menu, Integer> getMenu(){
        return handler.getResult(InputView::readMenu);
    }
}
