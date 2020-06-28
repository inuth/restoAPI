package be.iepscf.recette.restControllers;

import be.iepscf.recette.dal.BurgerDAO;
import be.iepscf.recette.dto.burger.BurgerPostDTO;
import be.iepscf.recette.entities.Burger;
import be.iepscf.recette.mappers.BurgerMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/burger")
@CrossOrigin("*")
public class BurgerController {
    private final BurgerDAO burgerDAO;
    private final BurgerMapper burgerMapper;

    public BurgerController(BurgerDAO burgerDAO, BurgerMapper burgerMapper){
        this.burgerDAO = burgerDAO;
        this.burgerMapper = burgerMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<Burger>> get(){
        return ResponseEntity.ok(burgerDAO.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Burger> get(@PathVariable("id") Integer id){
        return ResponseEntity.ok(burgerDAO.findById(id).orElse(null));
    }

    @PostMapping("")
    public ResponseEntity<Burger> postAndUpdate(@Valid @RequestBody BurgerPostDTO burger){
        return ResponseEntity.ok(burgerDAO.save(burgerMapper.toEntity(burger)));
    }
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        burgerDAO.deleteById(id);
    }
}
