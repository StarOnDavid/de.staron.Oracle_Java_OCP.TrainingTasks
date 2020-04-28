package _200427_textstats;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class TextStatisticsImpl implements TextStatistics {
	
	private static final String WORD_DELIMETER = " ";
	
	private String text;
	
	public TextStatisticsImpl(String text) {
		this.text = text;
	}

	@Override
	public int getCountChars() {
		return text.length();
	}

	@Override
	public int getCountWords() {
		if(text.isEmpty()) {
			return 0;
		}
		
		String[] items = text.split(WORD_DELIMETER);
		return items.length;
	}
	
	@Override
	public int getCountSpecialChars() {
		return (int) text.chars()
				.filter( codePoint -> !Character.isLetter(codePoint) && !Character.isDigit(codePoint) )
				.count();
	}
	
	
	@Override
	public int getCountLetters() {
		int count = 0;
		
		for(int i=0; i<text.length(); i++) {
			char ch = text.charAt(i);
			
			if( Character.isLetter(ch) ) {
				count++;
			}
		}
		
		return count;
	}
	
	@Override
	public Optional<String> getLongestWord() {
		String[] items = text.split(WORD_DELIMETER);
		
		return Arrays.stream(items)
						.filter( s -> !s.isEmpty() )
						.max(Comparator.comparingInt(String::length));
	}

}
