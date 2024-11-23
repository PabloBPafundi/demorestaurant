package dev.demo.restaurant.menu;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apis/menus")
public class MenuController {

    private final MenuRepository menuRepository;

    public MenuController (MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    //GET
    @GetMapping("")
    List<Menu> listMenus(){
        return menuRepository.listMenus();
    }

    //GET
    @GetMapping("/{id}")
    Optional<Menu> findMenuById(@PathVariable Integer id){
        return menuRepository.findMenuById(id);
    }

    //DELETE
    @DeleteMapping("/{id}")
    void deleteMenuById(@PathVariable Integer id){
        menuRepository.deleteMenuById(id);
    }

    //POST
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void addMenu(@Valid @RequestBody Menu m){
        menuRepository.addMenu(m);
    }


}
