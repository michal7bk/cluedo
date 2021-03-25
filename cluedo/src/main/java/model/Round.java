package model;

import model.cards.Character;
import model.cards.Place;
import model.cards.Weapon;

import java.util.concurrent.atomic.AtomicLong;

import static java.lang.Long.MAX_VALUE;
import static model.Round.idGenerator.nextId;

public class Round implements Comparable<Round> {

    private Long id;
    private final Weapon weapon;
    private final Character character;
    private final Place place;

    public Round(Weapon weapon, Character character, Place place) {
        this.id = nextId();
        this.weapon = weapon;
        this.character = character;
        this.place = place;
    }

    @Override
    public String toString() {
        return "Round{" +
                "id=" + id +
                ", weapon=" + weapon +
                ", character=" + character +
                ", place=" + place +
                '}';
    }

    @Override
    public int compareTo(Round o) {
        if (id == null || o.id == null) {
            return 0;
        }
        return id.compareTo(o.id);
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
