package model.cards;

import java.util.concurrent.atomic.AtomicLong;

import static java.lang.Long.MAX_VALUE;
import static model.cards.Card.idGenerator.nextId;

public abstract class Card {

    String name;
    Long id;

    public Card(String name) {
        this.name = name;
        this.id = nextId();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (name != null ? !name.equals(card.name) : card.name != null) return false;
        return id != null ? id.equals(card.id) : card.id == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    static class idGenerator {

        private static final AtomicLong nextId = new AtomicLong();

        public static long nextId() {
            long next = nextId.incrementAndGet();
            if (next == MAX_VALUE) {
                nextId.set(0);
            }
            return next;
        }
    }


}
