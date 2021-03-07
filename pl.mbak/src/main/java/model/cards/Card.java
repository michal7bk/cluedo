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
