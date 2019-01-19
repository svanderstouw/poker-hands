package poker;

public class Card {

	private int intValue;
	private String suit;

	public Card(String stringValue, String suitLetter) {

		if (stringValue.equals("2") || stringValue.equals("3") || stringValue.equals("4") || stringValue.equals("5")
				|| stringValue.equals("6") || stringValue.equals("7") || stringValue.equals("8")
				|| stringValue.equals("9")) {
			intValue = Integer.parseInt(stringValue);
		} else if (stringValue.toUpperCase().equals("T")) {
			intValue = 10;
		} else if (stringValue.toUpperCase().equals("J")) {
			intValue = 11;
		} else if (stringValue.toUpperCase().equals("Q")) {
			intValue = 12;
		} else if (stringValue.toUpperCase().equals("K")) {
			intValue = 13;
		} else if (stringValue.toUpperCase().equals("A")) {
			intValue = 14;
		}

		if (suitLetter.toUpperCase().equals("C")) {
			suit = "clubs";
		} else if (suitLetter.toUpperCase().equals("D")) {
			suit = "diamonds";
		} else if (suitLetter.toUpperCase().equals("H")) {
			suit = "hearts";
		} else if (suitLetter.toUpperCase().equals("S")) {
			suit = "spades";
		}

	}

	public String getValue() {

		String returnValue = "";

		if (intValue >= 2 && intValue <= 10) {
			returnValue = String.valueOf(intValue);
		} else if (intValue == 11) {
			returnValue = "Jack";
		} else if (intValue == 12) {
			returnValue = "Queen";
		} else if (intValue == 13) {
			returnValue = "King";
		} else if (intValue == 14) {
			returnValue = "Ace";
		}

		return returnValue;
	}

	public String getSuit() {
		return suit;
	}

	public int getIntValue() {
		return intValue;
	}
	
	@Override
	public String toString() {
		return getValue() + " of " + getSuit();
	}
	

}
