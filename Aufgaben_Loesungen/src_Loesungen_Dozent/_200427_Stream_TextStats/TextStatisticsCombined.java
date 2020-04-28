package _200427_Stream_TextStats;

import java.util.Optional;


public class TextStatisticsCombined implements TextStatistics {
	private TextStatistics statsA, statsB;

	public TextStatisticsCombined(TextStatistics statsA, TextStatistics statsB) {
		this.statsA = statsA;
		this.statsB = statsB;
	}

	@Override
	public int getCountChars() {
		return statsA.getCountChars() + statsB.getCountChars();
	}

	@Override
	public int getCountSpecialChars() {
		return statsA.getCountSpecialChars() + statsB.getCountSpecialChars();
	}

	@Override
	public int getCountLetters() {
		return statsA.getCountLetters() + statsB.getCountLetters();
	}

	@Override
	public int getCountWords() {
		return statsA.getCountWords() + statsB.getCountWords();
	}

	@Override
	public Optional<String> getLongestWord() {

		Optional<String> maybeWordA = statsA.getLongestWord();
		Optional<String> maybeWordB = statsB.getLongestWord();
		
		if(maybeWordA.isPresent()) {
			if(maybeWordB.isEmpty()) {
				return maybeWordA;
			} else {
				String wordA = maybeWordA.get();
				String wordB = maybeWordB.get();
				
				if(wordA.length() > wordB.length()) {
					return maybeWordA;
				} else {
					return maybeWordB;
				}
			}
		}
		
		return maybeWordB;
	}
	
}
