/*
--- Part Two ---

Realizing the error of his ways, Santa has switched to a better model of determining whether a string is naughty or nice. None of the old rules apply, as they are all clearly ridiculous.

Now, a nice string is one with all of the following properties:

It contains a pair of any two letters that appears at least twice in the string without overlapping, like xyxy (xy) or aabcdefgaa (aa), but not like aaa (aa, but it overlaps).
It contains at least one letter which repeats with exactly one letter between them, like xyx, abcdefeghi (efe), or even aaa.
For example:

qjhvhtzxzqqjkmpb is nice because is has a pair that appears twice (qj) and a letter that repeats with exactly one letter between them (zxz).
xxyxx is nice because it has a pair that appears twice and a letter that repeats with one between, even though the letters used by each rule overlap.
uurcxstgmygtbstg is naughty because it has a pair (tg) but no repeat with a single letter between them.
ieodomkazucvgmuy is naughty because it has a repeating letter with one between (odo), but no pair that appears twice.
How many strings are nice under these new rules?

*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import java.util.*;

public class StringAnalizerPt2{
	static String patternA = "(..).*\\1+"; //regex for pair of two letters that repeat atleast twice
	static String patternB = "(.).\\1"; //contains at least one letter which repeats with exactly one letter between them
	static int count=0;

	static void repeatB (String stringy){
		Pattern p = Pattern.compile(patternB);
		Matcher m = p.matcher(stringy);

		if (m.find()){
			count ++;
		}
	}

	static boolean repeatA (String stringy){
		Pattern p = Pattern.compile(patternA);
		Matcher m = p.matcher(stringy);

		if (m.find()){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		String stringy;
		File file;
		Scanner reader;

		try{
			file = new File ("input.txt");
			reader = new Scanner (file);
			while (reader.hasNext()){
				stringy = reader.next();
				if (repeatA(stringy)){
					repeatB(stringy);
				}
			}

		} catch (Exception e){
			System.out.println("File not found");
		}


		System.out.println("Final count is: " + count);

	}
}