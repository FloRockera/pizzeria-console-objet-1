package service;

import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.pizzeria.MemDao.IPizzaDao;
import fr.pizzeria.MemDao.PizzaMemDao;
import fr.pizzeria.exception.ModifierPizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService{

	@Override
	public void executeUC(Scanner sc, IPizzaDao pizzaDao) throws ModifierPizzaException {
		
		double prixModifie;
		
		System.out.println("***** Mise � jour d'une pizza *****\n");
		System.out.println("Veuillez choisir le code de la pizza � modifier :");
		String codeAModifier = sc.nextLine();
		for (String val : pizzaDao.findAllPizzas())
		System.out.println("Veuillez saisir le nouveau code :");
		String codeModifie = sc.nextLine();
		System.out.println("Veuillez saisir le nouveau nom :");
		String libelleModifie = sc.nextLine();
		System.out.println("Veuillez saisir le nouveau prix :");
		String prixModifieString = sc.nextLine();
		
		if (!(NumberUtils.isCreatable(prixModifieString))){
			throw new ModifierPizzaException("Le prix n'est pas valide");
		}
		prixModifie = Double.parseDouble(prixModifieString);  // bug Scanner

		
		int categorieModifie;

		do {
			System.out.println("\nVeuillez choisir la cat�gorie :\n");
			System.out.println("1. Viande");
			System.out.println("2. Poisson");
			System.out.println("3. Sans viande");
			
			String categorieModifieString = sc.nextLine();
			categorieModifie = Integer.parseInt(categorieModifieString);  // bug Scanner
			
			
			if (categorieModifie < 1 || categorieModifie > CategoriePizza.values().length){
				throw new ModifierPizzaException("Cat�gorie non valide");
			}
			else {
				Pizza updatePizza = new Pizza(codeModifie, libelleModifie, prixModifie, CategoriePizza.valueOf(categorieModifie));
				pizzaDao.updatePizza(codeAModifier, updatePizza);
			}
			
			} while (categorieModifie < 1 || categorieModifie > CategoriePizza.values().length);
	}



}
