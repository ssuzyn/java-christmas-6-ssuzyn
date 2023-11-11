package christmas.controller;

import christmas.exception.ExceptionHandler;
import christmas.view.InputView;

public class OrderController {

    final private ExceptionHandler handler;

    public OrderController(ExceptionHandler handler){
        this.handler = handler;

    }

    public Integer getOrder(){
        return handler.getResult(InputView::readVisitDate);
    }
}
