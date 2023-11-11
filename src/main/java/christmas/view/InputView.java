package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.constant.InputMessage;
import christmas.util.Parser;
import christmas.validator.InputValidator;

public class InputView {

    public static int readVisitDate(){
        System.out.println(InputMessage.WELCOME_STATEMENT.getMessage());
        System.out.println(InputMessage.VISIT_DATE.getMessage());

        String input = Console.readLine();
        InputValidator.validateVisitDate(input);

        return Parser.stringToInteger(input);
    }
}
