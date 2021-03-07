package model.cards;

import java.util.concurrent.atomic.AtomicLong;

import static java.lang.Long.MAX_VALUE;
import static model.cards.Round.idGenerator.nextId;

public class Round {

    private Long id;
    private final Weapon weapon;
    private final Character character;
    private final Room room;

    public Round(Weapon weapon, Character character, Room room) {
        this.id = nextId();
        this.weapon = weapon;
        this.character = character;
        this.room = room;
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
