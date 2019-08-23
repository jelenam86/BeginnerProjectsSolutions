package mihajlovic.jelena;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GreenEggsAndHam {

	/*
	 * Some of you may remember the Dr. Sues story "Green Eggs and Ham". For those
	 * of you that don't remember it or have never heard of it, here is the story
	 * (https://pastebin.com/XMY48CnN). However, there is a problem with the story I
	 * gave you - every time the word I is used, it is lowercase. Because of this
	 * problem, your job is to do the following:
	 * 
	 * Copy the story I gave you into a regular text file. Create a program that
	 * reads through the story and makes the letter i uppercase any time it should
	 * be. (Make sure to change it when it's used in sam-I-am's name too.) Have your
	 * program make a new file, and have it write out the story correctly. Print out
	 * how many errors were corrected. When you're finished, you should have
	 * corrected this (70, but I counted 84) many errors.
	 */

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("(^|[-\\s])i([-\\s]|$)");
		Matcher matcher;
		int count = 0;
		try {
			BufferedWriter writer = new BufferedWriter(
					new FileWriter("resources/green_eggs_and_ham_text_without_errors.txt", false));
			List<String> allLines = Files.readAllLines(Paths.get("resources/green_eggs_and_ham_text_with_errors.txt"));
			for (String line : allLines) {
				matcher = pattern.matcher(line);
				while (matcher.find())
					count++;
				String newLine = line.replaceAll("(^|[-\\s])i([-\\s]|$)", "$1I$2");
				if (allLines.indexOf(line) != allLines.size() - 1)
					newLine += System.getProperty("line.separator");
				writer.append(newLine);
			}
			writer.close();
			System.out.println(count);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
