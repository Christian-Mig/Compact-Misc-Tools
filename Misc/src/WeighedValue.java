import java.util.Scanner;
import java.util.ArrayList;

/**
 * Class WeighedValue
 * 
 * @author chris
 * @version 1.2 Course: ITEC 2150, Fall 2020
 * 
 *          This program calculated weighed averages of grades
 *          the user enters. best used with decimal precentages with
 *          a total equal to 1 
 *
 */
public class WeighedValue {
	private double precent;
	private double grade;
	static ArrayList<WeighedValue> list = new ArrayList<WeighedValue>();
	static Scanner input = new Scanner(System.in);

	public WeighedValue() {
		this.precent = setPrecent();
		this.grade = gradeAvg();
	}

	/**
	 * Method: gradeAvg
	 * gets the average of the grades entered by user, goes until user stops
	 * @return the precent
	 */
	public double gradeAvg() {
		double score = 0;
		int total = 0;
		boolean loop = false;
		try {
			while (!loop) {
				System.out.println("enter your grade, type a letter to end loop");
				String stupid = input.nextLine();
				score += Math.abs(Double.parseDouble(stupid));
				total += 1;
			}
		} catch (Exception ex) {
			if (total < 1) {
				return 0; //in case the first value entered is nothing
			}
			System.out.println("ending loop, catagory completed successfully");
			loop = true;
		}
		return score / total;
	}
	/**
	 * Method: objectAverage
	 * gets the value of the precent and grade multiplied together
	 * @return the precent
	 */
	public double objectAverage() {
		return precent * grade;
	}

	/**
	 * Method: setPrecent
	 * gets the precent from user, with some failsafes
	 * @return the precent
	 */
	public double setPrecent() {
		try {
			System.out.println("Enter precentage in decimal form");
			String stupid = input.nextLine();
			double check = Math.abs(Double.parseDouble(stupid));
			if (check >1) {
				System.out.println("You can't have a precent greater than 1, defaulting to 0")
;				return 0;
			}else {
				return check;
			}
		} catch (Exception ex) {
			System.out.println("Error: using default value of 0");
			return 0;
		}
	}

	/**
	 * Method mainLoop
	 * calls the constructor which itselfs calls the setPrecent and gradeAverage methods. will construct an object of 
	 * entered data. will continue until stopped by user. will than add all the values together to get the final average
	 * @return the precent
	 */
	public static void mainLoop() {
		double finalAverage = 0;
		boolean masterLoop = false;
		while (!masterLoop) {
			System.out.println("would you like to enter a catagory (homework, exams ect...)? y/n");
			String answer = input.nextLine();

			if (answer.equalsIgnoreCase("y")) {
				WeighedValue a = new WeighedValue();
				list.add(a);
			} else {
				masterLoop = true;
			}
		}
		for (int i = 0; i < list.size(); i++) {
			finalAverage += list.get(i).objectAverage();
		}
		System.out.println(finalAverage);
		input.close();
	}
	//main
	public static void main(String[] arg) {
		System.out.println("Instructions:\nEnter the precentage in decimal form and make sure they add up to a total of 1 (or 100%)");
		WeighedValue.mainLoop();
	}
}
