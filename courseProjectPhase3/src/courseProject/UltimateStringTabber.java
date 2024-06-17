package courseProject;
import java.util.List;
public class UltimateStringTabber {
	public static List<String> ultimateStringTabber(List<String> stringList, boolean makeBars) {
		if (makeBars) {
			for (int i = 0; i < stringList.size(); i++) {
				stringList.set(i, "| " + stringList.get(i));
			}
		}
		int tabSize = 8;
		int maxSize = 0;
		for (String string : stringList) {
			if (string.length() > maxSize) {
				maxSize = string.length();
			}
		}
		int tabLength = maxSize / tabSize;
		for (int i = 0; i < stringList.size(); i++) {
			String currString = stringList.get(i);
			int tabDiff = tabLength - (currString.length() / tabSize);
			for (int x = 0; x < Math.max(0, tabDiff); x++) {
				currString += "\t";
			}
			currString += "\t";
			stringList.set(i, currString);
		}
		return stringList;
	}
}