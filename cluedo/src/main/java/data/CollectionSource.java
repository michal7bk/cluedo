package data;

import lombok.Getter;
import lombok.experimental.UtilityClass;
import model.cards.Character;
import model.cards.Place;
import model.cards.Weapon;

import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static java.util.stream.Stream.of;

@UtilityClass
public class CollectionSource {

    @Getter
    static Set<Weapon> weapons;
    @Getter
    static Set<Character> characters;
    @Getter
    static Set<Place> places;

    static {
        weapons = of(new Weapon("Knife"),
                new Weapon("Candlestick"),
                new Weapon("Pistol"),
                new Weapon("Rope"),
                new Weapon("Lead pipe"),
                new Weapon("Wrench")
        ).collect(toSet());

        characters = of(new Character("Col. Mustard"),
                new Character("Prof Plum"),
                new Character("Mr. Green"),
                new Character("Mrs. Peacock"),
                new Character("Miss Scarlet"),
                new Character("Mrs. White")
        ).collect(toSet());

        places = of(new Place("Hall"),
                new Place("Lounge"),
                new Place("Dining Room"),
                new Place("Kitchen"),
                new Place("Ball Room"),
                new Place("Conservatory"),
                new Place("Billiard Room"),
                new Place("Library"),
                new Place("Study")
        ).collect(toSet());
    }

}
