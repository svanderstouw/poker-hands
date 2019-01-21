package poker;

public class PokerHandsApp {

	public static void main(String[] args) {
		
		compareHands("Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH");
		compareHands("Black: 2H 4S 4C 2D 4H  White: 2S 8S AS QS 3S");
		compareHands("Black: 2H 3D 5S 9C KD  White: 2D 3H 5C 9S KH");
		compareHands("Black: TH AH 2H 4H JH  White: QS 2H QD QH QC");
		compareHands("Black: 2D KD 3D QD TD  White: QD 9H JS TD 8C");
		compareHands("Black: 2S 7S 7C QH 2D  White: 4H 2D 5C AH 3S");
		
	}
	
	public static void compareHands(String initialString) {
		
		String[] hands= initialString.split("\\s\\s");
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
