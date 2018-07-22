package service;

import java.util.Scanner;

import fr.pizzeria.MemDao.IPizzaDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService{

	@Override
	public void executeUC(Scanner sc, IPizzaDao pizzaDao) {
		
		System.out.println("***** Mise � jour d'une pizza *****\n");
		System.out.println("Veuillez choisir le code de la pizza � modifier :");
		String codeAModifier = sc.next();
		System.out.println("Veuillez saisir le nouveau code :");
		String codeModifie = sc.next();
		System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
		String libelleModifie = sc.next();
		System.out.println("Veuillez saisir le nouveau prix :");
		String prixModifieString = sc.next();
		double prixModifie = Double.parseDouble(prixModifieString);  // bug Scanner
		System.out.println("Veuillez saisir la nouvelle cat�gorie :");
		CategoriePizza categorieModifie = CategoriePizza.valueOf(sc.next());;
		Pizza updatePizza = new Pizza(codeModifie, libelleModifie, prixModifie, categorieModifie);
		pizzaDao.updatePizza(codeAModifier, updatePizza);		
	}



}
