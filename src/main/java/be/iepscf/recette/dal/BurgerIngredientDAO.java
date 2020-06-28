package be.iepscf.recette.dal;

import be.iepscf.recette.entities.BurgerIngredient;
import org.springframework.data.repository.CrudRepository;

public interface BurgerIngredientDAO extends CrudRepository<BurgerIngredient, Integer> {
}
