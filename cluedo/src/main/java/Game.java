import model.Player;
import model.cards.Character;
import model.cards.Place;
import model.cards.Round;
import model.cards.Weapon;

import java.util.*;

import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Stream.of;

//Test case
public class Game {


    List<Player> players;

    private int allCards = 6;
    private Set<Weapon> weapons = new HashSet<>(6);
    private Set<Character> characters = new HashSet<>(6);
    private Set<Place> places = new HashSet<>(9);


    // 9 pomiesczen, 6 postaci, 6 broni
    void startGame() {
        prepareCluedVersion();
        Map<Integer, Player> playerOnTable = seatPlayers();
        System.out.println(playerOnTable);

//        Round firstRound = new Round();


//        final Player playerRound = players.get(1);
//        playerRound.askAboutCard(firstRound);
//
//         teraz gdy gracz drugi nie odpowiedział, znaczy ze nie ma zadnej karty
//        final Player playerAnswered = players.get(3);
//        playerAnswered.answer(firstRound);

    }


    private Map<Integer, Player> seatPlayers() {
        Map<Integer, Player> playerOnTable = new TreeMap<>(reverseOrder());

        players = preparePlayers();
        players.forEach(player -> playerOnTable.put(this.players.indexOf(player), player));
        return playerOnTable;
    }

    private List<Player> preparePlayers() {
        return Arrays.asList(
                new Player("gracz 1", 5),
                new Player("gracz 2", 5),
                new Player("gracz 3", 5),
                new Player("gracz 4", 6)
        );
    }

    private void prepareCluedVersion() {
        weapons = prepareWeapons();
        characters = prepareCharacters();
        places = preparePlaces();

    }

    private Set<Place> preparePlaces() {
        return of(new Place("Hall"),
                new Place("Lounge"),
                new Place("Dining Room"),
                new Place("Kitchen"),
                new Place("Ball Room"),
                new Place("Conservatory"),
                new Place("Billard Room"),
                new Place("Library"),
                new Place("Study")
        ).collect(toSet());
    }

    private Set<Character> prepareCharacters() {
        return of(new Character("Col. Mustard"),
                new Character("Prof Plum"),
                new Character("Mr. Green"),
                new Character("Mrs. Peacock"),
                new Character("Miss Scarlet"),
                new Character("Mrs. White")
        )
                .collect(toSet());
    }

    private Set<Weapon> prepareWeapons() {
        return of(new Weapon("Knife"),
                new Weapon("Candlestick"),
                new Weapon("Pistol"),
                new Weapon("Rope"),
                new Weapon("Lead pipe"),
                new Weapon("Wrench")
        )
                .collect(toSet());
    }

}
