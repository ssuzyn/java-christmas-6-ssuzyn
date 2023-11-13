package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constant.Menu;
import christmas.constant.MenuType;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    private Map<Menu, Integer> orderMenu = new HashMap<>();;
    private Customer customer;

    @Test
    @DisplayName("메인 메뉴 갯수 카운트 테스트")
    void MainMenuCount(){
        orderMenu.put(Menu.T_BONE_STEAK, 2);
        orderMenu.put(Menu.ZERO_COLA, 2);
        orderMenu.put(Menu.ICE_CREAM, 1);

        customer = new Customer(25, orderMenu);
        int count = customer.countMenuType(MenuType.MAIN);

        assertThat(count).isEqualTo(2);
    }
}
