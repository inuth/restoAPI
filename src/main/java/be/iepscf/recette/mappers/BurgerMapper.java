package be.iepscf.recette.mappers;

import be.iepscf.recette.dal.IngredientDAO;
import be.iepscf.recette.dto.burger.BurgerPostDTO;
import be.iepscf.recette.entities.Burger;
import be.iepscf.recette.entities.BurgerIngredient;
import be.iepscf.recette.entities.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
@Service
public class BurgerMapper {

    private final IngredientDAO ingredientDAO;

    public BurgerMapper(IngredientDAO ingredientDAO){
        this.ingredientDAO = ingredientDAO;
    }

    public Burger toEntity(BurgerPostDTO burgerDTO){
        if (burgerDTO == null)
            return null;
        Burger burger = new Burger();
        burger.setRecette(burgerDTO.getRecette());
        burger.setPrix(burgerDTO.getPrix());
        burger.setNom(burgerDTO.getNom());
        burger.setDescription(burgerDTO.getDescription());

        Set<BurgerIngredient> burgerIngredients = burgerDTO.getIngredients()
                .stream()
                .map(b -> {
                    BurgerIngredient burgerIngredient = new BurgerIngredient();
                    burgerIngredient.setQuantite(b.getQuantite());
                    burgerIngredient.setIngredient(ingredientDAO.findById(b.getId()).orElse(null));
                    return burgerIngredient;
                })
                .collect(Collectors.toSet());

        burger.setBurgerIngredients(burgerIngredients);
        return burger;
    }
}
