package dev.demo.restaurant.order;

import dev.demo.restaurant.menu.Menu;
import jakarta.validation.constraints.NotNull;

public class Order {
    @NotNull
    Integer orderId;
    @NotNull
    String Status;
    @NotNull
    Menu choiceMenu;


    public Order(Menu choiceMenu, String status, Integer orderId) {
        this.choiceMenu = choiceMenu;
        Status = status;
        this.orderId = orderId;
    }


    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Menu getChoiceMenu() {
        return choiceMenu;
    }

    public void setChoiceMenu(Menu choiceMenu) {
        this.choiceMenu = choiceMenu;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
