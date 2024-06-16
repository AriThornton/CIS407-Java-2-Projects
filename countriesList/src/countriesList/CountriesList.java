package countriesList;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
public class CountriesList {
	ArrayList<String> countries = new ArrayList<>();
	public MENU_OPTION menuOption;
	enum MENU_OPTION {
		LIST,
		ADD,
		END
	}
	public void displayWelcomeMessage() {
		System.out.println("Country List Manager");
		System.out.println();
	}
	public void displayMenu() {
		System.out.println("COMMAND MENU");
		System.out.println("1 - List countries");
		System.out.println("2 - Add a country");
		System.out.println("3 - Exit");
		System.out.println();
	}
	public void getMenuOption(Scanner userInput) {
		outer: while (true) {
			System.out.print("Enter menu number: ");
			int nextCommand = Integer.valueOf(userInput.nextLine());
			switch (nextCommand) {
			case 1:
				this.menuOption = MENU_OPTION.LIST;
				break outer;
			case 2:
				this.menuOption = MENU_OPTION.ADD;
				break outer;
			case 3:
				this.menuOption = MENU_OPTION.END;
				break outer;
			default:
				System.out.println("Please provide a valid menu option.");
			};
		}
	}
	public boolean checkForCountry(String name) {
		return this.countries.contains(name);
	}
	public void addCountry(Scanner userInput) {
		System.out.print("Enter country: ");
		String name = userInput.nextLine();
		if (checkForCountry(name)) {
			System.out.println("Country " + name + " already exists in list.");
			return;
		}
		this.countries.add(name);
		System.out.println("Country " + name + " has been added to the list.");
	}
	public void listCountries() {
		if (countries.size() == 0) {
			System.out.println("No countries in the list.");
			System.out.println();
			return;
		}
		countries.sort(Comparator.naturalOrder());
		for (int i = 0; i < countries.size(); i++) {
			System.out.println(countries.get(i));
		}
		System.out.println();
	}
}