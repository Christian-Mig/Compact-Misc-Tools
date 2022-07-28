import java.util.Scanner;
import java.util.regex.*;
public class Regex_Phone_scanner {

	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		Pattern p = Pattern.compile( "\\d\\d\\d[-.]\\d\\d\\d[-.]\\d\\d\\d\\d"); //wants 3 digits than a . or - than 3 digits than . or - than 4 digits
		boolean loop = true;
		//String regex = "\\d"; //you need 2 \\ since it is inside a string  \\d{3}
		while (loop) {
			System.out.println("Enter phone number");
			String text = inp.nextLine();
			Matcher m = p.matcher(text);
			if(m.find()) loop = false; 
			System.out.println((loop==false)?text + " is valid" : text +" is invalid");
		}
		inp.close();
	}
}
