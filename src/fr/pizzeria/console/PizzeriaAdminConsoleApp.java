package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.MemDao.PizzaMemDao;
import fr.pizzeria.exception.AjouterPizzaException;
import fr.pizzeria.exception.ListerPizzaException;
import fr.pizzeria.exception.ModifierPizzaException;
import service.*;

public class PizzeriaAdminConsoleApp {



	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PizzaMemDao pizzaMemDao = new PizzaMemDao();
		int choix;

		ListerPizzaService listerPizza = new ListerPizzaService();
		AjouterPizzaService ajouterPizza = new AjouterPizzaService();
		ModifierPizzaService modifierPizza = new ModifierPizzaService();
		SupprimerPizzaService supprimerPizza = new SupprimerPizzaService();


		do{
			Affichage.affichageMenu();
			String choixString = sc.nextLine();
			choix = Integer.parseInt(choixString);  // bug Scanner

			switch (choix) {
			case 1:
				try {
					listerPizza.executeUC(sc, pizzaMemDao);
				} catch (ListerPizzaException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 2:
				try {
					ajouterPizza.executeUC(sc, pizzaMemDao);
				} catch (AjouterPizzaException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try {
					modifierPizza.executeUC(sc, pizzaMemDao);
				} catch (ModifierPizzaException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				supprimerPizza.executeUC(sc, pizzaMemDao);
				break;
			case 99:
				System.out.println("***** Au revoir *****");
				break;
			}
		} while (choix != 99);
		sc.close();
	}

}
