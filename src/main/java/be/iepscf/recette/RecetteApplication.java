package be.iepscf.recette;

import be.iepscf.recette.dal.BurgerDAO;
import be.iepscf.recette.dal.BurgerIngredientDAO;
import be.iepscf.recette.dal.IngredientDAO;
import be.iepscf.recette.entities.Burger;
import be.iepscf.recette.entities.BurgerIngredient;
import be.iepscf.recette.entities.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class RecetteApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecetteApplication.class, args);
    }

    @Autowired
    private BurgerDAO burgerDAO;
    @Autowired
    private IngredientDAO ingredientDAO;
    @Autowired
    private BurgerIngredientDAO burgerIngredientDAO;

    @EventListener(ApplicationReadyEvent.class)
    public void doAtStart(){
        adds();
    }

    private void adds(){
        // BURGERS
        Burger hamburger = new Burger();
        hamburger.setNom("hamburger");
        hamburger.setDescription("simple hamburger avec viande chimique et sauce ketchup");
        hamburger.setPrix(2.5);
        hamburger.setRecette("du pain, de la sauce ketchup et une viande");
        hamburger.setImage("https://gourmandiz.dhnet.be/app/uploads/2019/02/royaldeluxe.jpg");

        Burger giant = new Burger();
        giant.setNom("giant");
        giant.setDescription("hamburger avec une délicieuse viande pure boeuf ainsi que des rondelles de tomates, de la salade et une sauce giant faite maison");
        giant.setPrix(3.5);
        giant.setRecette("du pain, une viande pure boeuf, de la tomate, de la salade et de la sauce giant");
        giant.setImage("https://img.plusdebonsplans.com/2013/05/quick-giant-junior.jpg");

        Burger doubleGiant = new Burger();
        doubleGiant.setNom("double giant");
        doubleGiant.setDescription("hamburger avec deux délicieuses viandes pure boeuf ainsi que des rondelles de tomates, de la salade et une sauce giant faite maison");
        doubleGiant.setPrix(4.8);
        doubleGiant.setRecette("du pain, deux viandes pure boeuf, de la tomate, de la salade et de la sauce giant");
        doubleGiant.setImage("https://cdn.eat-list.fr/blog/article/le-giant-burger-culte-de-quick_833.jpg");

        // INGREDIENTS
        Ingredient pain = new Ingredient();
        pain.setCalories(20);
        pain.setDescription("pain avec graines de sésame");
        pain.setNom("pain");
        pain.setPrix(0.2);
        pain.setQuantiteMinimum(50);
        pain.setQuantiteStock(300);

        Ingredient viande = new Ingredient();
        viande.setCalories(85);
        viande.setDescription("viande chimique");
        viande.setNom("viande");
        viande.setPrix(1.2);
        viande.setQuantiteMinimum(50);
        viande.setQuantiteStock(200);

        Ingredient viandePureBoeuf = new Ingredient();
        viandePureBoeuf.setCalories(70);
        viandePureBoeuf.setDescription("viande 100% pure boeuf");
        viandePureBoeuf.setNom("viande pure boeuf");
        viandePureBoeuf.setPrix(1.5);
        viandePureBoeuf.setQuantiteMinimum(30);
        viandePureBoeuf.setQuantiteStock(100);

        Ingredient tomate = new Ingredient();
        tomate.setCalories(5);
        tomate.setDescription("tomate fraiche");
        tomate.setNom("tomate");
        tomate.setPrix(0.3);
        tomate.setQuantiteMinimum(15);
        tomate.setQuantiteStock(25);

        Ingredient salade = new Ingredient();
        salade.setCalories(5);
        salade.setDescription("salade fraiche");
        salade.setNom("salade");
        salade.setPrix(0.3);
        salade.setQuantiteMinimum(15);
        salade.setQuantiteStock(25);

        Ingredient sauceKetchup = new Ingredient();
        sauceKetchup.setCalories(15);
        sauceKetchup.setDescription("sauce ketchup Heinz");
        sauceKetchup.setNom("sauce ketchup");
        sauceKetchup.setPrix(0.5);
        sauceKetchup.setQuantiteMinimum(25);
        sauceKetchup.setQuantiteStock(60);

        Ingredient sauceGiant = new Ingredient();
        sauceGiant.setCalories(20);
        sauceGiant.setDescription("sauce giant faite maison");
        sauceGiant.setNom("sauce giant");
        sauceGiant.setPrix(0.5);
        sauceGiant.setQuantiteMinimum(25);
        sauceGiant.setQuantiteStock(60);

        // BURGER_INGREDIENT 1
        // composition hamburger
        BurgerIngredient compoHamburger1 = new BurgerIngredient();
        compoHamburger1.setIngredient(pain);
        compoHamburger1.setQuantite(1);
        hamburger.getBurgerIngredients().add(compoHamburger1);

        BurgerIngredient compoHamburger2 = new BurgerIngredient();
        compoHamburger2.setIngredient(viande);
        compoHamburger2.setQuantite(1);
        hamburger.getBurgerIngredients().add(compoHamburger2);

        BurgerIngredient compoHamburger3 = new BurgerIngredient();
        compoHamburger3.setIngredient(sauceKetchup);
        compoHamburger3.setQuantite(1);
        hamburger.getBurgerIngredients().add(compoHamburger3);

        // composition giant
        BurgerIngredient compoGiant1 = new BurgerIngredient();
        compoGiant1.setIngredient(pain);
        compoGiant1.setQuantite(1);
        giant.getBurgerIngredients().add(compoGiant1);

        BurgerIngredient compoGiant2 = new BurgerIngredient();
        compoGiant2.setIngredient(viandePureBoeuf);
        compoGiant2.setQuantite(1);
        giant.getBurgerIngredients().add(compoGiant2);

        BurgerIngredient compoGiant3 = new BurgerIngredient();
        compoGiant3.setIngredient(sauceGiant);
        compoGiant3.setQuantite(1);
        giant.getBurgerIngredients().add(compoGiant3);

        BurgerIngredient compoGiant4 = new BurgerIngredient();
        compoGiant4.setIngredient(tomate);
        compoGiant4.setQuantite(1);
        giant.getBurgerIngredients().add(compoGiant4);

        BurgerIngredient compoGiant5 = new BurgerIngredient();
        compoGiant5.setIngredient(salade);
        compoGiant5.setQuantite(1);
        giant.getBurgerIngredients().add(compoGiant5);

        // composition doubleGiant
        BurgerIngredient compoDoubleGiant1 = new BurgerIngredient();
        compoDoubleGiant1.setIngredient(pain);
        compoDoubleGiant1.setQuantite(1);
        doubleGiant.getBurgerIngredients().add(compoDoubleGiant1);

        BurgerIngredient compoDoubleGiant2 = new BurgerIngredient();
        compoDoubleGiant2.setIngredient(viandePureBoeuf);
        compoDoubleGiant2.setQuantite(2);
        doubleGiant.getBurgerIngredients().add(compoDoubleGiant2);

        BurgerIngredient compoDoubleGiant3 = new BurgerIngredient();
        compoDoubleGiant3.setIngredient(sauceGiant);
        compoDoubleGiant3.setQuantite(1);
        doubleGiant.getBurgerIngredients().add(compoDoubleGiant3);

        BurgerIngredient compoDoubleGiant4 = new BurgerIngredient();
        compoDoubleGiant4.setIngredient(tomate);
        compoDoubleGiant4.setQuantite(1);
        doubleGiant.getBurgerIngredients().add(compoDoubleGiant4);

        BurgerIngredient compoDoubleGiant5 = new BurgerIngredient();
        compoDoubleGiant5.setIngredient(salade);
        compoDoubleGiant5.setQuantite(1);
        doubleGiant.getBurgerIngredients().add(compoDoubleGiant5);

        // INSERT
        ingredientDAO.save(pain);
        ingredientDAO.save(viande);
        ingredientDAO.save(viandePureBoeuf);
        ingredientDAO.save(tomate);
        ingredientDAO.save(salade);
        ingredientDAO.save(sauceKetchup);
        ingredientDAO.save(sauceGiant);

        burgerDAO.save(hamburger);
        burgerDAO.save(giant);
        burgerDAO.save(doubleGiant);

    }
}
