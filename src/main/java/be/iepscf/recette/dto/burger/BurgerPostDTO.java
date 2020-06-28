package be.iepscf.recette.dto.burger;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class BurgerPostDTO {
    @NotNull
    private String nom;
    @Min(1)
    private double prix;
    private String description;
    private String recette;
    private String image;
    private List<BurgerPostIngredientDTO> ingredients = new ArrayList<>();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRecette() {
        return recette;
    }

    public void setRecette(String recette) {
        this.recette = recette;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<BurgerPostIngredientDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<BurgerPostIngredientDTO> ingredients) {
        this.ingredients = ingredients;
    }
}
