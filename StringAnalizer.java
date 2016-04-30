
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringAnalizer{


    private static final String REGEX = "(.)\\1{1,}";
    private static final String INPUT = "ddaniel";
    static int count = 0;

    public static void main( String args[] ){
    	vowel(INPUT);
    }

    private static void vowel (String input){
    	int vowels = 0;
    	System.out.println(input.length());
    	char [] stringy = input.toCharArray();


    	for (int i : stringy){
    		System.out.println(stringy[i]);
    		if ( stringy [i] == 'a' || stringy[i]=='e' || stringy[i] =='i' || stringy[i]=='o' || stringy[i]=='u' ){
    			count ++;
    			System.out.println("I am a vowel at " + i);
    		}
    	}

    }

	private void repetition (String input){
		Pattern p = Pattern.compile(REGEX);
		Matcher m = p.matcher(input); // get a matcher object
		int count = 0;

		while(m.find()) {
			count++;
			//System.out.println("Match number "+count);
			//System.out.println("group " + m.group());
			//System.out.println("start(): "+m.start());
			//System.out.println("end(): "+m.end());
		}
	}

	
}