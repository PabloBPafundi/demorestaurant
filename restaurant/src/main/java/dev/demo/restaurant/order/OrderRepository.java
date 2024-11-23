package dev.demo.restaurant.order;

import dev.demo.restaurant.menu.Menu;
import dev.demo.restaurant.menu.MenuRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {

    private final List<Order> orders = new ArrayList<>();
    private final MenuRepository menuRepository;

    public OrderRepository(MenuRepository menuRepository){
        this.menuRepository = menuRepository;
    }

    @PostConstruct
    public void init(){

        Optional<Menu> menuOptional = menuRepository.findMenuById(1);

        menuOptional.ifPresent(menu -> {
            Order newOrder = new Order(menu, "Pendiente", 1);
            orders.add(newOrder);
        });


        Optional<Menu> menuOptional2 = menuRepository.findMenuById(2);

        menuOptional.ifPresent(menu -> {
            Order newOrder = new Order(menu, "Pendiente", 2);
            orders.add(newOrder);
        });

    }

    List<Order> listOrders(){
        return orders;
    }


    Optional<Order> findOrderById(Integer id){
        return orders
                .stream()
                .filter(order -> order.getOrderId().equals(id))
                .findFirst();

    }


    public void addOrder(Order order){


        if (findOrderById(order.getOrderId()).isEmpty() && menuRepository.findMenuById(order.getChoiceMenu().getMenuId()).isPresent()) {
            orders.add(order);
        } else {
            throw new RuntimeException("El menu ingresado no existe o ya existe una orden con ese ID");
        }
    }

    public void changeStatus(Integer id, String status) {

        List<String> validStatuses = List.of("Pendiente", "En preparacion", "Listo");

        if (!validStatuses.contains(status)) {
            Optional<Order> orderOpt = findOrderById(id);

            orderOpt.ifPresent(order -> {
                order.setStatus(status);
            });
        }
    }



}
