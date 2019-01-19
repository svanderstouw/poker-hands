package poker;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CardTest {
	
	Card card1;
	Card card2;
	
	@Before
	public void setup() {
		card1 = new Card("J", "H");
		card2 = new Card("9", "D");
	}
	
	@Test
	public void cardShouldHaveValue() {
		String value = card1.getValue();
		String value2 = card2.getValue();
		assertEquals(value, "Jack");
		assertEquals(value2, "9");
	}
	
	@Test
	public void cardShouldHaveSuit() {
		String suit = card1.getSuit();
		String suit2 = card2.getSuit();
		assertEquals(suit, "hearts");
		assertEquals(suit2, "diamonds");
	}
	
	@Test
	public void cardShouldHaveIntValue() {	
		int value = card1.getIntValue();
		int value2 = card2.getIntValue();
		assertEquals(value, 11);
		assertEquals(value2, 9);
	}
	
	@Test
	public void cardShouldHaveString() {
		String string1 = card1.toString();
		String string2 = card2.toString();
		assertEquals(string1, "Jack of hearts");
		assertEquals(string2, "9 of diamonds");
	}

}
