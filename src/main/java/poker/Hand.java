package poker;

import java.util.ArrayList;
import java.util.Arrays;

public class Hand {
	
	private ArrayList<Card> hand;
	private int[] values;
	private String[] suits;
	private double ranking;
	
	public Hand(String string) {
		
		hand = new ArrayList<Card>();
		
		String[] splitString = string.split("\\s+");
		for(String cardLetters : splitString) {
			String stringValue = cardLetters.substring(0,1);
			String suitLetter = cardLetters.substring(1,2);
			hand.add(new Card(stringValue, suitLetter));
		}
		
		values = values();
		Arrays.sort(values);
		reverse(values);
		
		suits = suits();
		Arrays.sort(suits);
		
		ranking = ranking();
		
	}

	public ArrayList<Card> getCards() {
		return hand;
	}
	
	public int[] getValues() {
		return values;
	}
	
	public String[] getSuits() {
		return suits;
	}
	
	public double getRanking() {
		return ranking;
	}

	private int[] values() {
		int[] cardValues = new int[5];
		
		for(int i=0; i<hand.size(); i++) {
			cardValues[i] = hand.get(i).getIntValue();
		}
		
		return cardValues;
	}
	
	private String[] suits() {
		String[] suitStrings = new String[5];
		
		for(int i=0; i<hand.size(); i++) {
			suitStrings[i] = hand.get(i).getSuit();
		}
		
		return suitStrings;
	}
	
	private void reverse(int[] array) {

        int maxIndex = array.length -1;
        int halfLength = array.length / 2;
        for(int i=0; i<halfLength; i++) {
            int temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;
        }
    }

	private double ranking() {
		return 1.0;
	}





	

}
