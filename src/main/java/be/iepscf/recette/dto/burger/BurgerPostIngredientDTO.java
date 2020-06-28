package be.iepscf.recette.dto.burger;

import javax.validation.constraints.Min;

public class BurgerPostIngredientDTO {
    private int id;
    private int quantite;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
