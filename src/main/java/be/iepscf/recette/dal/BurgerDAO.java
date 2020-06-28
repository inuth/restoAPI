package be.iepscf.recette.dal;

import be.iepscf.recette.entities.Burger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BurgerDAO extends JpaRepository<Burger, Integer> {
    Optional<Burger> findByNom(String nom);
}
