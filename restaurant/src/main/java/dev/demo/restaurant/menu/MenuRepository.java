package dev.demo.restaurant.menu;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MenuRepository {

    private static final List<Menu> menus = new ArrayList<>();

    @PostConstruct
    public void init(){

        menus.add(new Menu(10,1,"Pasta"));
        menus.add(new Menu(20,2,"Milanesas c/ Pure"));
        menus.add(new Menu(30,3,"Ravioles"));


    }


    public List<Menu> listMenus(){
        return menus;
    }
    
    public Optional<Menu> findMenuById(Integer id){
        return menus
             .stream()
             .filter(menu -> menu.getMenuId().equals(id))
             .findFirst();
    }

    public Optional<Menu> findMenuByName(String name){
        return menus
                .stream()
                .filter(menu -> menu.getName().equals(name))
                .findFirst();
    }

    public void deleteMenuById(Integer id){
        if(findMenuById(id).isPresent()) {
            menus.removeIf(menu -> menu.getMenuId().equals(id));
        }
    }

    public void addMenu(Menu m){
        if(findMenuById(m.getMenuId()).isEmpty() && findMenuByName(m.getName()).isEmpty()) {
            menus.add(m);
        } else {
            throw new RuntimeException("Ya existe un menu con ese ID o Nombre");
        }

    }

}
