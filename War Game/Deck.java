import java.util.Random;
import java.util.ArrayList;

public class Deck
{

//Declare variables
//private Card [] deck;
private ArrayList<Card> deck;	//holds all the card objects needed to make a standard deck (with or without Jokers)
private int usedCards;	//keeps track of the cards used/dealt in a deck
private int cardCount;	//keeps track of total number of cards in deck
/**
* Default Constructor.
* Automatically excludes jokers from deck
*/
public Deck()
{
this(false);
}

/**
* Main Constructor
* determines number of cards in deck and adds cards to array
* @param hasJokers
*/
public Deck(boolean hasJokers)
{
deck = new ArrayList<Card>();

//add cards to deck
cardCount = 0;
for (int suit = 0; suit <= 3; suit++)
{
for(int rank = 1; rank <= 13; rank++)
{
deck.add(new Card(suit, rank));
cardCount++;
}
}

if (hasJokers)
{
deck.add(new Card(Card.JOKER,0));
cardCount++;
deck.add(new Card(Card.JOKER,0));
cardCount++;
}

//set used cards in deck to zero
usedCards = 0;
//shuffle deck;
shuffle();

}

/**
* Shuffle method randomizes order of cards in deck
* serially goes through array list and replaces each card
* with a randomly chosen card from elsewhere in the deck
*/
public void shuffle()
{
//Declare variables
Random gen = new Random();
int cardShuffle, randNum;

//determine how many random cards are in deck to shuffle
if (deck.size() == 54)
{
cardShuffle = 54;
}
else
{
cardShuffle = 52;
}
//loop to shuffle cards in deck
for (int i = 0; i <= deck.size()-1; i++)
{
randNum = gen.nextInt(cardShuffle);
Card temp = deck.get(i);
deck.set(i, deck.get(randNum));
deck.set(randNum, temp);

}

}


/**
* dealCard method returns a card and increased the number of cards used by 1
* @return Card object
*/
public Card dealCard()
{
if (usedCards == deck.size())
{
throw new ListIndexOutOfBoundsException("The deck is empty");
}
else
{
usedCards++;
return deck.get(usedCards-1);
}
}


/**
* size method give the number of cards in the deck
* @return Int of size of ArrayList of deck
*/
public int size()
{
return cardCount;
}


/**
* getCard method
* @param index value to get specific card from
* @return Card object from index position in array
*/
public Card getCard(int index)
{
return deck.get(index);
}

/**
* getIndex method()
* @param c holds card object being searched for
* @return int value at which specific card is located
* if no card returns -1
*/
public int getIndex(Card c)
{
//declare variables
boolean equals, found = false;
int position;
int count = 0;

while(found == false)
{
equals = c.equals(deck.get(count));
if (equals == true)
{
found = equals;
}
else
{
found = equals;
count++;
}

}
if (found == true)
{
position = count;
}
else
{
position = -1;
}
return position;
}

/**
* cardsLeft Method
* @return Int value of unused cards left in deck
*/
public int cardsLeft()
{
return (deck.size() - usedCards);
}


/**
* hasJokers method
* @return Boolean of whether or not deck has jokers
*/
public boolean hasJokers()
{
if (deck.size() == 54)
{
return true;
}
else
{
return false;
}
}

}