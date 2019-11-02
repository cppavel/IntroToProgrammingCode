public class TwelveDaysOfChristmas 
{

	
	public static final String COMMON_START_PART  = "On the <verseNumber> day of Christmas\r\n" + 
			"My true love gave to me\r\n";
	public static final String COMMON_END_PART = "<begin> partridge in a pear tree\n";
	public static final String SECOND_VERSE = "Two turtle doves\n";
	public static final String THIRD_VERSE = "Three French hens\n";
	public static final String FOURTH_VERSE = "Four calling birds\n";
	public static final String FIFTH_VERSE = "Five gold rings\n";
	public static final String SIXTH_VERSE = "Six geese a laying\n";
	public static final String SEVENTH_VERSE = "Seven swans a swimming\n";
	public static final String EIGTH_VERSE = "Eight maids a milking\n";
	public static final String NINETH_VERSE = "Nine ladies dancing\n";
	public static final String TENTH_VERSE = "Ten lords a leaping\n";
	public static final String ELEVENTH_VERSE = "Eleven pipers piping\n";
	public static final String TWELVETH_VERSE = "Twelve drummers drumming\n";
	
	public static String GenerateVerse(int verseNumber)
	{
		
		String startPart  = COMMON_START_PART; 
		String verses = "";
		String endPart = COMMON_END_PART;
		if(verseNumber==1)
		{
			endPart = endPart.replace("<begin>", "A");
		}
		else
		{
			endPart = endPart.replace("<begin>", "And a");
		}
		startPart = startPart.replace("<verseNumber>", GetVerseNumberInEnglish(verseNumber));
		switch(verseNumber)
		{
		case 12: verses = verses + TWELVETH_VERSE;
		case 11: verses = verses + ELEVENTH_VERSE ;
		case 10: verses = verses + TENTH_VERSE;
		case 9: verses = verses + NINETH_VERSE;
		case 8: verses = verses + EIGTH_VERSE;
		case 7: verses = verses + SEVENTH_VERSE;
		case 6: verses = verses + SIXTH_VERSE;
		case 5: verses = verses + FIFTH_VERSE;
		case 4: verses = verses + FOURTH_VERSE;
		case 3: verses = verses + THIRD_VERSE;
		case 2: verses = verses + SECOND_VERSE; break;
		default: break;
		}
		return startPart+verses+endPart;
		
	}		
	
	public static String GetVerseNumberInEnglish(int verseNumber)
	{
		switch(verseNumber)
		{
		case 1: return "first";
		case 2: return "second";
		case 3: return "third";
		case 4: return "fourth";
		case 5: return "fifth";
		case 6: return "sixth";
		case 7: return "seventh";
		case 8: return "eighth";
		case 9: return "ninth";
		case 10: return "tenth";
		case 11: return "eleventh";
		case 12: return "twelfth";
		default: return "";
		}
	}
	
	public static void main(String[] args)
	{		
		for(int numberOfVerse = 1;numberOfVerse<=12;numberOfVerse++)
		{
			System.out.println(GenerateVerse(numberOfVerse));
		}
	}

}
