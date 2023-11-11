package christmas.view;

public class OutputView {

    public static void printErrorMessage(IllegalArgumentException e){
        System.out.println(e.getMessage());
    }

    public static void printEmptyLine(){
        System.out.println();
    }

}
