import java.util.Scanner;
import java.util.regex.*;

public class Regex_Email_scanner {

	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		Pattern p = Pattern.compile("[a-zA-Z0-9.]+@[a-zA-z-]+[.][a-zA-Z]{3}");
		// it first checks for an characters a-z any caps, 0-9 plus . than checks for an @,than checks for any a-z any caps.
		//checks for a . than checks for any a-z any caps with a max of 3
		boolean loop = true;

		// cmigliore@gmail.edu
		while (loop) {
			System.out.println("Enter email");
			String text = inp.nextLine();
			Matcher m = p.matcher(text);
			if(m.find()) loop = false; //only use m.find once
			System.out.println((loop==false)?text + " is valid" : text +" is invalid");
		}
		inp.close();
	}

}
