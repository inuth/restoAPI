package be.iepscf.recette.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(unique = true)
    private String nom;
    private String description;
    @Column(columnDefinition="Decimal(10,2) check(prix>0)")
    private Double prix;
    @Min(0)
    private Integer calories;
    @Min(0)
    private Integer quantiteStock;
    @Min(0)
    private Integer quantiteMinimum;
//    @OneToMany(mappedBy = "ingredient")
//    private Set<BurgerIngredient> burgerIngredients = new HashSet<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(Integer quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    public Integer getQuantiteMinimum() {
        return quantiteMinimum;
    }

    public void setQuantiteMinimum(Integer quantiteMinimum) {
        this.quantiteMinimum = quantiteMinimum;
    }
}
