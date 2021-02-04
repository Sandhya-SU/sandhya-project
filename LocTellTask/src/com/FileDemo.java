package com;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FileDemo {
	static int numberOfLines = 0;

	boolean search(String filename, String word, String pattern) throws FileNotFoundException, IOException {
		boolean flag = false;

		try (LineNumberReader r = new LineNumberReader(new FileReader(filename))) {
			String line;
			while ((line = r.readLine()) != null) {
				if (pattern == null) {
					numberOfLines++;
					if (line.equalsIgnoreCase(word)) {
						flag = true;
						break;
					}
				} else {
					if (Pattern.matches(pattern, line.toLowerCase())) {
						System.out.println(word + " not found, We found " + line);
						break;
					} else {
						if (numberOfLines == 1) {
							System.out.println(word + " not found, No alternatives found too");
							break;
						} else {
							numberOfLines--;
						}
					}
				}
			}
			r.close();

			return flag;
		}

	}

	public static void main(String[] args) throws FileNotFoundException, IOException {

		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the full file path including file name: ");
		String filename = scan.nextLine();
		System.out.println("Please enter a word which you would like to search : ");
		String word = scan.nextLine();
		scan.close();

		FileDemo fileDemo = new FileDemo();
		boolean flag;
		flag = fileDemo.search(filename, word, null);
		if (flag == true) {
			System.out.println(word + " found.");
		} else {
			String patternMatch = "." + (word.substring(1, word.length())).toLowerCase();
			fileDemo.search(filename, word, patternMatch);
		}
	}
}
