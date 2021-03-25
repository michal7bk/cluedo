package model;

import lombok.Getter;
import model.cards.Card;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Player implements Comparable<Player> {

    private Integer id;

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

    public Player(int id, String name, int cardOnHand) {
        this.id = id;
        this.asked = new ArrayList<>();
        this.answered = new ArrayList<>();
        this.name = name;
        this.cardOnHand = cardOnHand;
        checkedCards = new ArrayList<>(cardOnHand);
    }

    @Override
    public String toString() {
        return "Player:" + name;
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

    @Override
    public int compareTo(Player o) {
        if (id == null || o.id == null) {
            return 0;
        }
        return id.compareTo(o.id);

    }
}
