/*******************************************************************************
 * Companion code for the book "Introduction to Software Design with Java",
 * 3rd edition by Martin P. Robillard.
 *
 * Copyright (C) 2025 by Martin P. Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * 
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 * 
 *******************************************************************************/
package e3.chapter1;

import java.util.ResourceBundle;
/**
 * Outputs the text of the poem "The Twelve Days of Christmas"
 * to the console. The code leverages the natural recursion in 
 * the structure of the poem.
 */
public class TwelveDays {
	
	private static ResourceBundle resources =
			ResourceBundle.getBundle("e3.chapter1.TwelveDays");

	public static void main(String[] args) {
		System.out.println(poem());
	}
	
	/*
     * Returns the first line in the verse for a given day.
	 */
	static String firstLine(int day) {
		return "On the " + resources.getString("day." + (day + 1))
				+ " day of Christmas my true love sent to me:\n";
	}
	
	/*
     * Returns a string that lists all the gifts received on a given
     * day.
	 */
	static String allGifts(int day) {
		if (day == 0) {
			return resources.getString("and") + " "
					+ resources.getString("gift.1");
		}
		else {
			return resources.getString("gift." + (day + 1))
					+ "\n" + allGifts(day - 1);
		}
	}
	
	/*
	 * Returns the text of the entire poem. 
	 */
	static String poem() {
		String poem = firstLine(0)
				+ resources.getString("gift.1") + "\n\n";

		for (int day = 1; day < 12; day++) {
			poem += firstLine(day)
					+ allGifts(day) + "\n\n";
		}

		return poem;
	}
}