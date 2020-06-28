package be.iepscf.recette.restControllers;

import be.iepscf.recette.dal.BurgerDAO;
import be.iepscf.recette.dal.IngredientDAO;
import be.iepscf.recette.entities.Burger;
import be.iepscf.recette.entities.Ingredient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredient")
@CrossOrigin("*")
public class IngredientController {
    private final IngredientDAO ingredientDAO;

    public IngredientController(IngredientDAO ingredientDAO){
        this.ingredientDAO = ingredientDAO;
    }

    @GetMapping("")
    public ResponseEntity<List<Ingredient>> get(){
        return ResponseEntity.ok(ingredientDAO.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> get(@PathVariable("id") Integer id){
        return ResponseEntity.ok(ingredientDAO.findById(id).orElse(null));
    }

    // insertion et update
    @PostMapping("")
    public ResponseEntity<Ingredient> postAndUpdate(@RequestBody Ingredient ingredient){
        return ResponseEntity.ok(ingredientDAO.save(ingredient));
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        ingredientDAO.deleteById(id);
    }

}
