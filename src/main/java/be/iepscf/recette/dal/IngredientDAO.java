package be.iepscf.recette.dal;

import be.iepscf.recette.entities.Burger;
import be.iepscf.recette.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientDAO extends JpaRepository<Ingredient, Integer> {
    Optional<Ingredient> findByNom(String nom);
}
