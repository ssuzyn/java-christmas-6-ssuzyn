package christmas.dto;

import christmas.constant.Menu;
import java.util.Map;

public record OrderMenu(
        int date,
        Map<Menu, Integer> menu)
{

}
