package countriesList;
import java.util.Scanner;
public class CountriesListApp {
	public static void main(String[] args) {
		try (Scanner userInput = new Scanner(System.in)){
			CountriesList countriesList = new CountriesList();
			countriesList.displayWelcomeMessage();
			countriesList.displayMenu();
			main: while (true) {
				countriesList.getMenuOption(userInput);
				switch(countriesList.menuOption) {
				case LIST:
					countriesList.listCountries();
					break;
				case ADD:
					countriesList.addCountry(userInput);
					break;
				case END:
					break main;
				}
			}
			System.out.println("Goodbye!");
		}
	}
}