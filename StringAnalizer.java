
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import java.util.*;

public class StringAnalizer{

    private static final String REGEX = "(.)\\1{1,}";
    static int count = 0;

    public static void main( String args[] ){
    	String stringy;
    	File input;
    	Scanner reader;

    	try{
    		input = new File ("input.txt");
    		reader = new Scanner (input);
    		while (reader.hasNext()){

    			stringy = reader.next();
    			System.out.println("\nPreliminary count is " + count);
    			System.out.println("CHECKING: " + stringy);
    			if (preReq(stringy) == true){
		    		if (vowel(stringy) == true){
		    			repetition(stringy);
		   
		    		}

		    	}
    		}
		    System.out.println("\nFinal count is " + count);

    	} catch (Exception e){
    		System.out.println("Input not available");
    	}
    }

    //Checks it does not contain the strings ab, cd, pq, or xy, even if they are part of one of the other requirements.
    //true if it does not cointain
    private static boolean preReq (String input){
    	Pattern p = Pattern.compile("ab|cd|pq|xy");
    	Matcher m = p.matcher(input);

    	if (m.find()){
    		System.out.println("Pre-req - False, contains ab,cd, pq, xy.");

    		return false;
    	}
    	System.out.println("Pre-req - true, does not contain");
    	return true;
    }


    // Checks if it contains at least three vowels (aeiou only)
    // true if it does not contain
    private static boolean vowel (String input){
    	int vowels = 0;
    	//System.out.println(input.length());
    	char [] stringy = input.toCharArray();  	

    	boolean a = false;
    	boolean e = false;
    	boolean o = false;
    	boolean i = false;
    	boolean u = false;
    	

    	for (int j =0 ; j< stringy.length ; j++){
    		if ( stringy [j] == 'a'){//} && a == false){
    			a = true;
    			vowels ++;
    		} else if ( stringy [j] == 'e'){// && e == false){
				e = true;
    			vowels ++;
    		} else if ( stringy [j] == 'i'){// && i == false){
				i = true;
    			vowels ++;
    		} else if ( stringy [j] == 'o'){//&& o == false){
				o = true;
    			vowels ++;
    		} else if ( stringy [j] == 'u'){// && u == false){
				u = true;
    			vowels ++;
    		}else{}
    	}

    	if (vowels >= 3){
    		System.out.println("Vowels: " + vowels);
    		return true;
    	} else{
    	 System.out.println("Vowel - less than 3");
    	    return false;

    	}
    }

    // Checks if string contains at least one letter that appears twice in a row
    // true if repeats
	private static void repetition (String input){
		Pattern p = Pattern.compile(REGEX);
		Matcher m = p.matcher(input); // get a matcher object
		int reps = 0;

		while(m.find()) {
			reps++;
			//System.out.println("Match number "+count);
			//System.out.println("group " + m.group());
			//System.out.println("start(): "+m.start());
			//System.out.println("end(): "+m.end());
		}
		if (reps >= 1){
			count ++;
			System.out.println("Reps - It has repeated letters");
		} else {
			System.out.println("Reps - does not has repeated letters");

		}
	}

	
}