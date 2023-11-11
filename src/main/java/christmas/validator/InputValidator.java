package christmas.validator;

import christmas.constant.ErrorCode;

public class InputValidator {

    private static int START_DATE = 1;
    private static int END_DATE = 31;

    public static void validateVisitDate(String input){
        validateInteger(input);
        validateNumberInRange(Integer.parseInt(input));
    }

    private static void validateInteger(String input){
        if(!input.chars().allMatch(Character::isDigit)){
            throw new IllegalArgumentException(ErrorCode.NOT_INTEGER.getMessage());
        }
    }

    private static void validateNumberInRange(int input){
        if(input > END_DATE || input < START_DATE)
            throw new IllegalArgumentException((ErrorCode.DATE_IS_NOT_IN_DECENBER.getMessage()));
    }
}
