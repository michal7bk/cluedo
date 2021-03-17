package model;

import model.cards.Card;
import model.cards.Round;

import java.util.ArrayList;
import java.util.List;


public class Player {

    private String name;

    private int cardOnHand;
    List<Card> checkedCards;
    // Cards that player checked
    List<Round> asked;
    List<Round> answered;

    public Player(String name, int cardOnHand) {
        this.asked = new ArrayList<>();
        this.answered = new ArrayList<>();
        this.name = name;
        this.cardOnHand = cardOnHand;
        checkedCards = new ArrayList<>(cardOnHand);
    }

    boolean playersCardsAreKnown() {
        return checkedCards.size() == cardOnHand;
    }

    public void askAboutCard(Round round) {
        asked.add(round);
    }

    public void answer(Round round) {
        answered.add(round);
    }

}
