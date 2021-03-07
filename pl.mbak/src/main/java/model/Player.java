package model;

import model.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;

    private int cardOnHand;

    List<Card> checkedCards;

    public Player(String name, int cardOnHand) {
        this.name = name;
        this.cardOnHand = cardOnHand;
        checkedCards = new ArrayList<Card>(cardOnHand);
    }

    boolean playersCardsAreKnown(){
        return checkedCards.size() == cardOnHand;
    }


}
