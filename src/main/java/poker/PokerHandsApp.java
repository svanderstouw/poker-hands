package poker;

public class PokerHandsApp {

	public static void main(String[] args) {
		
		compareHands("Black: 2H 3D 5S 9C KD,  White: 2C 3H 4S 8C AH");

	}
	
	public static void compareHands(String initialString) {
		
		String[] hands= initialString.split(",\\s");
		Hand hand1 = new Hand(hands[0]);
		Hand hand2 = new Hand(hands[1]);
		
		if (hand1.getRanking() > hand2.getRanking()) {
			System.out.println(hand1.getPlayerName() + " wins. - " + hand1.getDescription());
		} else if (hand1.getRanking() < hand2.getRanking()) {
			System.out.println(hand2.getPlayerName() + " wins. - " + hand2.getDescription());
		} else {
			System.out.println("Tie");
		}
		
	}

}
