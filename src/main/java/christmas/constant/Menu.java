package christmas.constant;

public enum Menu {
    YANGSONGSOUP("양송이수프", 6000, MenuType.APPETIZER),
    TAPAS("타파스", 5500, MenuType.APPETIZER),
    CAESAR_SALAD("시저샐러드", 8000, MenuType.APPETIZER),

    T_BONE_STEAK("티본스테이크", 55000, MenuType.MAIN),
    BBQ_RIB("바비큐립", 54000, MenuType.MAIN),
    SEAFOOD_PASTA("해산물파스타", 35000, MenuType.MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, MenuType.MAIN),

    CHOCO_CAKE("초코케이크", 15000, MenuType.DESSERT),
    ICE_CREAM("아이스크림", 5000, MenuType.DESSERT),

    ZERO_COLA("제로콜라", 3000, MenuType.BEVERAGE),
    RED_WINE("레드와인", 60000, MenuType.BEVERAGE),
    CHAMPAGNE("샴페인", 25000, MenuType.BEVERAGE);

    private final String name;
    private final int price;
    private final MenuType menuType;

    Menu(String name, int price, MenuType menuType) {
        this.name = name;
        this.price = price;
        this.menuType = menuType;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public MenuType getMenuType() {
        return menuType;
    }
}
