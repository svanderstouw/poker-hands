package poker;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class HandTest {
	
	Hand hand1;
	
	@Before
	public void setup() {
		hand1 = new Hand("TH 3D 5S 9C KD");
	}
	
	@Test
	public void handShouldHaveFiveCards() {
		Card card1= hand1.getCards().get(0);
		Card card2= hand1.getCards().get(1);
		Card card3= hand1.getCards().get(2);
		Card card4= hand1.getCards().get(3);
		Card card5= hand1.getCards().get(4);
		assertEquals(card1.getValue(), "10");
		assertEquals(card2.getValue(), "3");
		assertEquals(card3.getValue(), "5");
		assertEquals(card4.getValue(), "9");
		assertEquals(card5.getValue(), "King");
		assertEquals(card1.getSuit(), "hearts");
		assertEquals(card2.getSuit(), "diamonds");
		assertEquals(card3.getSuit(), "spades");
		assertEquals(card4.getSuit(), "clubs");
		assertEquals(card5.getSuit(), "diamonds");
	}
	
	@Test
	public void handShouldHaveSortedValues() {
		int[] values = hand1.getValues();
		assertEquals(values[0], 13);
		assertEquals(values[1], 10);
		assertEquals(values[2], 9);
		assertEquals(values[3], 5);
		assertEquals(values[4], 3);
	}
	
	@Test
	public void handShouldHaveSortedSuits() {
		String[] suits = hand1.getSuits();
		assertEquals(suits[0], "clubs");
		assertEquals(suits[1], "diamonds");
		assertEquals(suits[2], "diamonds");
		assertEquals(suits[3], "hearts");
		assertEquals(suits[4], "spades");
	}
	
	@Test
	public void handShouldHaveRanking() {
		double ranking = hand1.getRanking();
		assertEquals(ranking, 0.1310090503, 0);
	}

}
