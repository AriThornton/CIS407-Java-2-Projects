package courseProject;
public class DataEntry {
	public static boolean validateString(String entry) {
		return (!(entry.isBlank()));
	}
	public static boolean validateStringLength(String entry, int length) {
		return (!(entry.isBlank()) && (entry.length() <= length));
	}
	public static boolean validateStringExactLength(String entry, int length) {
		return (entry.length() == length);
	}
	public static boolean validateStringNumeric(String entry) {
		return entry.matches("\\d+");
	}
	public static boolean validateIntRange(int entry, int min, int max) {
		return (min <= entry && entry <= max);
	}
	public static boolean validateDecimalRange(float entry, float min, float max) {
		return (min <= entry && entry <= max);
	}
	public static boolean validateDate(String entry) {
		return (entry.matches("\\d{1,2}[/]\\d{1,2}[/]\\d{4}"));
	}
}