package dev.demo.restaurant.menu;

import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class Menu {

    @NotNull
    String name;

    @NotNull
    Integer menuId;

    @NotNull @Positive
    Integer price;

    public Menu(Integer price, Integer menuId, String name) {
        this.price = price;
        this.menuId = menuId;
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
