package utilities;

public class Text
{
    public static String capitalize(String text)
	{
		if (text.length() == 0)		return text;
		return text.substring(0, 1).toUpperCase()+text.substring(1);
    }
	
	public static String[] capitalize(String[] text_array)
	{
		String[] text_array_capitalized = new String[text_array.length];
		for (int i = 0; i < text_array.length; i++)		text_array_capitalized[i] = capitalize(text_array[i]);
		return text_array_capitalized;
	}
	
	public static String[][] capitalize(String[][] text_array_array)
	{
		String[][] text_array_array_capitalized = new String[text_array_array.length][];
		for (int i = 0; i < text_array_array.length; i++)		text_array_array_capitalized[i] = capitalize(text_array_array[i]);
		return text_array_array_capitalized;
	}
	
	
	public static String upper(String text)
	{
		if (text.length() == 0)		return text;
		return text.toUpperCase();
    }
	
	public static String[] upper(String[] text_array)
	{
		String[] text_array_uppered = new String[text_array.length];
		for (int i = 0; i < text_array.length; i++)		text_array_uppered[i] = upper(text_array[i]);
		return text_array_uppered;
	}
	
	public static String[][] upper(String[][] text_array_array)
	{
		String[][] text_array_array_uppered = new String[text_array_array.length][];
		for (int i = 0; i < text_array_array.length; i++)		text_array_array_uppered[i] = upper(text_array_array[i]);
		return text_array_array_uppered;
	}
	
	
	public static String lower(String text)
	{
		if (text.length() == 0)		return text;
		return text.toLowerCase();
    }
	
	public static String[] lower(String[] text_array)
	{
		String[] text_array_lowered = new String[text_array.length];
		for (int i = 0; i < text_array.length; i++)		text_array_lowered[i] = lower(text_array[i]);
		return text_array_lowered;
	}
	
	public static String[][] lower(String[][] text_array_array)
	{
		String[][] text_array_array_lowered = new String[text_array_array.length][];
		for (int i = 0; i < text_array_array.length; i++)		text_array_array_lowered[i] = lower(text_array_array[i]);
		return text_array_array_lowered;
	}
	
	
	
	public static String unpunctuate(String text_feed)
	{
		char[] text_feed_character_array = text_feed.toCharArray();
		char[] text_output_character_array = new char[text_feed.length()];
		for (int i = 0; i < text_feed_character_array.length; i++)
		{
			if (Character.isLetterOrDigit(text_feed_character_array[i]) || Character.isWhitespace(text_feed_character_array[i])) 
			{
				text_output_character_array[i] = text_feed_character_array[i];
			}        
		}
		return new String(text_output_character_array);
	}
	
	
	
	public static String remove(String removal, String text)
	{
		while (text.contains(removal))
			text = text.substring(0, text.indexOf(removal))+text.substring(text.indexOf(removal) + removal.length());
		return text;
	}
	public static String remove(String[] removals, String text)
	{
		for (String removal : removals)		text = remove(removal, text);
		return text;
	}
	
	public static String[] remove(String removal, String[] text_array)
	{
		String[] text_array_removed = new String[text_array.length];
		for (int i = 0; i < text_array_removed.length; i++)		text_array_removed[i] = text_array[i];
		for (int i = 0; i < text_array_removed.length; i++)		text_array_removed[i] = remove(removal, text_array_removed[i]);
		return text_array_removed;
	}
	public static String[] remove(String[] removals, String[] text_array)
	{
		String[] text_array_removed = new String[text_array.length];
		for (int i = 0; i < text_array_removed.length; i++)		text_array_removed[i] = text_array[i];
		for (int i = 0; i < text_array_removed.length; i++)		text_array_removed[i] = remove(removals, text_array_removed[i]);
		return text_array_removed;
	}
	
	
	
	public static boolean vowel(String text)
	{
		text = capitalize(text.substring(0, 1));
		if (text.equals("A") || text.equals("E") || text.equals("I") || text.equals("O") || text.equals("U"))		return true;
		return false;
	}
	
	
	
	/*public static String[] separate_words(String text)
	{
		if (!text.contains(" "))		return new String[] {text};
		String separation = text.substring(0, text.indexOf(" "));
		return new String[] {separation, separate_words(text.substring(separation.length() - 1))};
	}*/
}