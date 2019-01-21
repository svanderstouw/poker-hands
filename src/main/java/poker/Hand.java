package poker;

import java.util.ArrayList;
import java.util.Collections;

public class Hand {

	private ArrayList<Card> hand;
	private String playerName;
	private double ranking;
	private String description;

	public Hand(String string) {

		String[] splitString = string.split(":\\s");
		this.playerName = splitString[0];

		this.hand = new ArrayList<Card>();

		String[] splitCards = splitString[1].split("\\s+");
		for (String cardLetters : splitCards) {
			String stringValue = cardLetters.substring(0, 1);
			String suitLetter = cardLetters.substring(1, 2);
			hand.add(new Card(stringValue, suitLetter));
		}

		Collections.sort(hand);

		this.ranking = ranking();

	}

	public ArrayList<Card> getCards() {
		return hand;
	}

	public String getPlayerName() {
		return playerName;
	}

	public double getRanking() {
		return ranking;
	}

	public String getDescription() {
		return description;
	}

	private double ranking() {
		double ranking = 0;
		
		if (isStraightFlush() > 8.0) {
			ranking = isStraightFlush();
		} else if (isFour() > 7.0) {
			ranking = isFour();
		} else if (isFullHouse() > 6.0) {
			ranking = isFullHouse();
		} else if (isFlush() > 5.0) {
			ranking = isFlush();
		} else if (isStraight() > 4.0) {
			ranking = isStraight();
		} else if (isThree() > 3.0) {
			ranking = isThree();
		} else if (hasPairs() > 1.0) {
			ranking = hasPairs();
		} else {
			ranking = highCard();
		}

		return ranking;
	}

	private double highCard() {
		double ranking = 0.0;
		
		for (int i = 0; i < hand.size(); i++) {
			ranking += hand.get(i).getIntValue() * Math.pow(0.01, (i + 1));
		}
		this.description = "with high card: " + hand.get(0).getValue();
		
		return ranking;
	}
	
	private double hasPairs() {
		double ranking = 0.0;
		int numPairs = 0;
		int highPair = 0;
		String highPairName = "";
		int lowPair = 0;
		String lowPairName = "";

		for (int i = 0; i < hand.size() - 1; i++) {
			if ((hand.get(i).getIntValue() == hand.get(i + 1).getIntValue()) && (highPair > 0.0)) {
				lowPair = hand.get(i).getIntValue();
				lowPairName = hand.get(i).getValue();
				numPairs++;
			} else if (hand.get(i).getIntValue() == hand.get(i + 1).getIntValue()) {
				highPair = hand.get(i).getIntValue();
				highPairName = hand.get(i).getValue();
				numPairs++;
			}
		}

		if (numPairs == 2) {
			ranking = 2.0 + (highPair * 0.01) + (lowPair * 0.0001);
			for (int i = 0; i < hand.size(); i++) {
				if ((hand.get(i).getIntValue() != highPair) && (hand.get(i).getIntValue() != lowPair)) {
					ranking += hand.get(i).getIntValue() * 0.000001;
				}
			}
			this.description = "with two pairs: " + highPairName + " over " + lowPairName;
		}

		if (numPairs == 1) {
			ranking = 1.0 + (highPair * 0.01);
			int counter = 2;
			for (int i = 0; i < hand.size(); i++) {
				if (hand.get(i).getIntValue() != highPair) {
					ranking += hand.get(i).getIntValue() * Math.pow(0.01, counter);
					counter++;
				}
			}
			this.description = "with one pair: " + highPairName;
		}

		return ranking;
	}

	private double isThree() {
		double ranking = 0.0;
		int threeValue = 0;

		for (int i = 0; i < hand.size() - 2; i++) {
			if (hand.get(i).getIntValue() == hand.get(i + 2).getIntValue()) {
				ranking = 3.0 + (hand.get(i).getIntValue() * 0.01);
				threeValue = hand.get(i).getIntValue();
				int counter = 2;
				for (int x = 0; x < hand.size(); x++) {
					if (hand.get(x).getIntValue() != threeValue) {
						ranking += hand.get(x).getIntValue() * Math.pow(0.01, counter);
						counter++;
					}
				}
				this.description = "with three-of-a-kind: " + hand.get(i).getValue();
			}
		}

		return ranking;
	}

	private double isStraight() {
		double ranking = 0.0;
			
		if ((hand.get(0).getIntValue() == hand.get(1).getIntValue()+1)
				&& (hand.get(1).getIntValue() == hand.get(2).getIntValue()+1)
				&& (hand.get(2).getIntValue() == hand.get(3).getIntValue()+1) 
				&& (hand.get(3).getIntValue() == hand.get(4).getIntValue()+1)) {
			ranking = 4.0 + (hand.get(0).getIntValue() * 0.01);
			this.description = "with straight: " + hand.get(0).getValue() + " high";
		}
		
		if ((hand.get(0).getIntValue() == 14)
				&& (hand.get(1).getIntValue() == 5)
				&& (hand.get(2).getIntValue() == 4)
				&& (hand.get(3).getIntValue() == 3) 
				&& (hand.get(4).getIntValue() == 2)) {
			ranking = 4.05;
			this.description = "with straight: 5 high";
		}		
		
		return ranking;
	}
	
	private double isFlush() {
		double ranking = 0.0;
		boolean isFlush = true;
		
		String firstSuit = hand.get(0).getSuit();
		for (int i = 1; i < hand.size(); i++) {
			if (hand.get(i).getSuit() != firstSuit) {
				isFlush = false;
			}
		}
		
		if (isFlush) {
			ranking = 5.0;
			for (int i = 0; i < hand.size(); i++) {
				ranking += hand.get(i).getIntValue() * Math.pow(0.01, (i + 1));
			}
			this.description = "with flush: " + hand.get(0).getValue() + " high";
		}
		
		return ranking;
	}
	
	private double isFullHouse() {
		double ranking = 0.0;
		
		if ((hand.get(0).getIntValue() == hand.get(2).getIntValue())
				&& (hand.get(3).getIntValue() == hand.get(4).getIntValue())) {
			ranking += 6.0 + (hand.get(0).getIntValue() * 0.01) + (hand.get(3).getIntValue() * 0.0001);
			this.description = "with full house: " + hand.get(0).getValue() + " over " + hand.get(3).getValue();
		}
		
		if ((hand.get(0).getIntValue() == hand.get(1).getIntValue()) 
				&& (hand.get(2).getIntValue() == hand.get(4).getIntValue())) {
			ranking += 6.0 + (hand.get(2).getIntValue() * 0.01) + (hand.get(0).getIntValue() * 0.0001);
			this.description = "with full house: " + hand.get(2).getValue() + " over " + hand.get(0).getValue();
		}
		
		return ranking;
	}
	
	private double isFour() {
		double ranking = 0.0;
		
		if (hand.get(0).getIntValue() == hand.get(3).getIntValue()) {
			ranking = 7.0 + (hand.get(0).getIntValue() * 0.01) + (hand.get(4).getIntValue() * 0.0001);
			this.description = "with four-of-a-kind: " + hand.get(0).getValue();
		}
		
		if (hand.get(1).getIntValue() == hand.get(4).getIntValue()) {
			ranking = 7.0 + (hand.get(1).getIntValue() * 0.01) + (hand.get(0).getIntValue() * 0.0001);
			this.description = "with four-of-a-kind: " + hand.get(1).getValue();
		}
		
		return ranking;
	}
	
	private double isStraightFlush() {
		double ranking = 0.0;
		
		if(isFlush() > 5.0) {
			if ((hand.get(0).getIntValue() == hand.get(1).getIntValue()+1)
					&& (hand.get(1).getIntValue() == hand.get(2).getIntValue()+1)
					&& (hand.get(2).getIntValue() == hand.get(3).getIntValue()+1) 
					&& (hand.get(3).getIntValue() == hand.get(4).getIntValue()+1)) {
				ranking = 8.0 + (hand.get(0).getIntValue() * 0.01);
				this.description = "with straight flush: " + hand.get(0).getValue() + " high";
			}
			
			if ((hand.get(0).getIntValue() == 14)
					&& (hand.get(1).getIntValue() == 5)
					&& (hand.get(2).getIntValue() == 4)
					&& (hand.get(3).getIntValue() == 3) 
					&& (hand.get(4).getIntValue() == 2)) {
				ranking = 8.05;
				this.description = "with straight flush: 5 high";
			}
		}
		
		return ranking;
	}

}
