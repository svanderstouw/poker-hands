package poker;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class HandTest {
	
	Hand hand1;
	Hand onePair;
	Hand twoPair;
	Hand three;
	Hand straight;
	Hand aceStraight;
	Hand flush;
	Hand fullHouse;
	Hand four;
	Hand straightFlush;
	
	@Before
	public void setup() {
		hand1 = new Hand("Black: TH 3D 5S 9C KD");
		onePair = new Hand("White: 6C JH AS 6D 4H");
		twoPair = new Hand("Green: 2S 7S 7C QH 2D");
		three = new Hand("Blue: KH JH 2S JD JS");
		straight = new Hand("Violet: QD 9H JS TD 8C");
		aceStraight = new Hand("Purple: 4H 2D 5C AH 3S");
		flush = new Hand("Yellow: TH AH 2H 4H JH");
		fullHouse = new Hand("Aqua: 8H 8C 9H 9C 8S");
		four = new Hand("Red: QS 2H QD QH QC");
		straightFlush = new Hand("Pink: QD 9D JD TD KD");
	}
	
	@Test
	public void handShouldHavePlayerName() {
		String name = hand1.getPlayerName();
		assertEquals(name, "Black");
	}
	
	@Test
	public void handShouldHaveSortedCards() {
		Card card1= hand1.getCards().get(0);
		Card card2= hand1.getCards().get(1);
		Card card3= hand1.getCards().get(2);
		Card card4= hand1.getCards().get(3);
		Card card5= hand1.getCards().get(4);
		assertEquals(card1.getValue(), "King");
		assertEquals(card2.getValue(), "10");
		assertEquals(card3.getValue(), "9");
		assertEquals(card4.getValue(), "5");
		assertEquals(card5.getValue(), "3");
	}
	
	@Test
	public void highCardHandShouldHaveRanking() {
		double ranking = hand1.getRanking();
		assertEquals(ranking, 0.1310090503, 0.0000000001);
	}
	
	@Test
	public void highCardHandShouldHaveDescription() {
		String description = hand1.getDescription();
		assertEquals(description, "with high card: King");
	}
	
	@Test
	public void onePairShouldHaveRanking() {
		double ranking = onePair.getRanking();
		assertEquals(ranking, 1.06141104, 0.00000001);
	}
	
	@Test
	public void onePairHandShouldHaveDescription() {
		String description = onePair.getDescription();
		assertEquals(description, "with one pair: 6");
	}
	
	@Test
	public void twoPairShouldHaveRanking() {
		double ranking = twoPair.getRanking();
		assertEquals(ranking, 2.070212, 0.000001);
	}
	
	@Test
	public void twoPairHandShouldHaveDescription() {
		String description = twoPair.getDescription();
		assertEquals(description, "with two pairs: 7 over 2");
	}
	
	@Test
	public void threeShouldHaveRanking() {
		double ranking = three.getRanking();
		assertEquals(ranking, 3.111302, 0.000001);
	}
	
	@Test
	public void threeShouldHaveDescription() {
		String description = three.getDescription();
		assertEquals(description, "with three-of-a-kind: Jack");
	}
	
	@Test
	public void straightShouldHaveRanking() {
		double ranking = straight.getRanking();
		assertEquals(ranking, 4.12, 0.01);
	}
	
	@Test
	public void straightShouldHaveDescription() {
		String description = straight.getDescription();
		assertEquals(description, "with straight: Queen high");
	}
	
	@Test
	public void aceStraightShouldHaveRanking() {
		double ranking = aceStraight.getRanking();
		assertEquals(ranking, 4.05, 0.01);
	}
	
	@Test
	public void aceStraightShouldHaveDescription() {
		String description = aceStraight.getDescription();
		assertEquals(description, "with straight: 5 high");
	}
	
	@Test
	public void flushShouldHaveRanking() {
		double ranking = flush.getRanking();
		assertEquals(ranking, 5.1411100402, 0.0000000001);
	}
	
	@Test
	public void flushShouldHaveDescription() {
		String description = flush.getDescription();
		assertEquals(description, "with flush: Ace high");
	}
	
	@Test
	public void fullHouseShouldHaveRanking() {
		double ranking = fullHouse.getRanking();
		assertEquals(ranking, 6.0809, 0.0001);
	}
	
	@Test
	public void fullHouseShouldHaveDescription() {
		String description = fullHouse.getDescription();
		assertEquals(description, "with full house: 8 over 9");
	}
	
	@Test
	public void fourShouldHaveRanking() {
		double ranking = four.getRanking();
		assertEquals(ranking, 7.1202, 0.0001);
	}
	
	@Test
	public void fourShouldHaveDescription() {
		String description = four.getDescription();
		assertEquals(description, "with four-of-a-kind: Queen");
	}
	
	@Test
	public void straightFlushShouldHaveRanking() {
		double ranking = straightFlush.getRanking();
		assertEquals(ranking, 8.13, 0.01);
	}
	
	@Test
	public void straightFlushShouldHaveDescription() {
		String description = straightFlush.getDescription();
		assertEquals(description, "with straight flush: King high");
	}

}
