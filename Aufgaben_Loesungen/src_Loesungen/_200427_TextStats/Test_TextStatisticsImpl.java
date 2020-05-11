package _200427_TextStats;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test_TextStatisticsImpl {

	/*
	 * soll die Gesamtanzahl der Zeichen liefern
	 */
	@Test
	void test_getCountChars() {
		TextStatisticsImpl text = new TextStatisticsImpl("Das müssten 28 Zeichen sein!");
		assertEquals(28, text.getCountChars());
		
		text = new TextStatisticsImpl("abc ABC 123");
		assertEquals(11, text.getCountChars());
	}
	
	/* 
	 * Solldie Anzahl der Sonderzeichen (Zeichen die weder Ziffern noch Buchstaben sind) zurück liefern
	 */
	@Test
	void test_getCountSpecialChars() {
		String test = "abcdefghijklmnopqrstuvw !";
		TextStatisticsImpl text = new TextStatisticsImpl(test);
		assertEquals(2, text.getCountSpecialChars());
		
		test = "ABCDEFGHIJKLMNOPQRSTUVWXYZ !";
		text = new TextStatisticsImpl(test);
		assertEquals(2, text.getCountSpecialChars());
		
		test = "0123456789 !";
		text = new TextStatisticsImpl(test);
		assertEquals(2, text.getCountSpecialChars());
		
		test = "!§$%&/()=?`:;@€abdcefABC123";
		text = new TextStatisticsImpl(test);
		assertEquals(15, text.getCountSpecialChars());
	}

	/* 
	 * Soll die Anzahl der Buchstaben liefern
	 */
	@Test
	void test_getCountLetters() {
		TextStatisticsImpl text = new TextStatisticsImpl("Dieser Satz hat 23 Buchstaben.");
		assertEquals(23, text.getCountLetters());
		
		text = new TextStatisticsImpl("abcdefghijklmnopqrstuvwxyz !%&/()");
		assertEquals(26, text.getCountLetters());
		text = new TextStatisticsImpl("___A§$BCDEFGH/()IJKLM)(NOPQRSTUVWXYZ !");
		assertEquals(26, text.getCountLetters());
	}
	
	/* 
	 * Soll die Anzahl der Wörter zurück liefern. Wörter können aus beliebigen Zeichen 
	 * (auch Sonderzeichen) bestehen und werden von Leerzeichen von einander getrennt.
	 */
	@Test
	void test_getCountWords() {
		TextStatisticsImpl text = new TextStatisticsImpl("Dieser Satz hat 5 Wörter.");
		assertEquals(5, text.getCountWords());
		
		text = new TextStatisticsImpl("Aber jetzt ein paar mehr, und zwar 9 Wörter.");
		assertEquals(9, text.getCountWords());
	}

	/*
	 * Soll das längste Wort in einem Optional zurück liefern. 
	 * Für leere zu untersuchenden Texte liefert Empty Optional
	 */
	@Test
	void test_getLongestWord() {
		TextStatisticsImpl text = new TextStatisticsImpl("Ein Sat miz einem langen Wort.");
		assertEquals("langen", text.getLongestWord().get());
		
		text = new TextStatisticsImpl("Titikakasee ist auch ein langes Wort.");
		assertEquals("Titikakasee", text.getLongestWord().get());
		
		text = new TextStatisticsImpl("");
		assertTrue(text.getLongestWord().isEmpty());
	}
}