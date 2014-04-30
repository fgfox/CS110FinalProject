//Griffen Fox
//CS110
//Final Project
//War Game Class

import java.util.ArrayList;
import java.util.Random;

public class WarGame {
   
   // Constants
   private static final int COMPUTER_WIN = 0;   //number indicates computer has won
   private static final int USER_WIN = 1;       //number indicates user has won
   private static final int WAR = -1;	         //number indicates tie between user and computer --> equals a war
   
   //Declare variables
   private ArrayList<Card> userCards;	         //user's card pile
   private ArrayList<Card> compCards;	         //computer's card pile
   private ArrayList<Card> warCards;	         //card pile awarded to winner
   private Deck cardDeck;	                     //card deck of 52 cards
   private Card userCard, compCard;	            //individual cards flipped from user & computer piles to be compared
   private int winNum;	                        //holds value of who has won game/round
   private int wagerCount;                      //holds number of cards won each time;
   private boolean gameOver;	                  //determines whether the game is over or not

   //Default Constructor
   public WarGame()
   {
      userCards = new ArrayList<Card>();
      compCards = new ArrayList<Card>();
      warCards = new ArrayList<Card>();
      cardDeck = new Deck();
      gameOver = false;
      
      splitDeck();
   }
   
   //Splits the deck in half between computer and player
   
   public void splitDeck()
   {

      while(cardDeck.cardsLeft() != 0)
      {
         userCards.add(cardDeck.dealCard());
         compCards.add(cardDeck.dealCard());
      }
   }

   // removes card from each list and assigns to card object, makes sure each pile isn't empty
   
   public void flipCard()
   {
      //flip a card from each pile if not empty
      if (!userCards.isEmpty() && !compCards.isEmpty())
      {
         userCard = userCards.remove((userCards.size())-1);
         compCard = compCards.remove((compCards.size())-1);
      }
      
      //computer win condition
      else if (userCards.isEmpty() && !compCards.isEmpty())
      {
         winNum = COMPUTER_WIN;
         gameOver = true;
      }
      
      //user win condition
      else if(!userCards.isEmpty() && compCards.isEmpty())
      {
         winNum = USER_WIN;
         gameOver = true;
      }
      
      //Exception thrown if both piles empty
      else if(userCards.isEmpty() && compCards.isEmpty())
      {
         throw new ListIndexOutOfBoundsException ("the arraylist is empty");
      }

   }
   
   /**
      Compares the cards to see if computer or users is higher
      if cards equal then they go to a war
   */
   public void compareCards()
   {
      warCards.add(userCard);
      warCards.add(compCard);
      
      //WAR
      if (userCard.equals(compCard))
      {
         winNum = WAR;
         war();
      }
      else if (userCard.greaterThan(compCard)==true)
      {
         winNum = USER_WIN;
         wagerCount = warCards.size();
         for(Card c: warCards)            
         {	
            //adds bottom of winners pile
            userCards.add(0,c);
         }

         warCards.clear();
         shuffle();
     }

      //else if the computer's card is greater than the user add all cards to computers pile
      else
      {
         winNum = COMPUTER_WIN;
         wagerCount = warCards.size();
         for(Card c: warCards)
         {
            compCards.add(0,c);
         }
            warCards.clear();
         shuffle();
      }
   }


   //War method
   public void war()
   {	
      warCards.add(userCards.remove((userCards.size())-1));
      warCards.add(compCards.remove((compCards.size())-1));	
   }
   
   //Shuffle method
   public void shuffle()
   {
      //Declare variables
      Random gen = new Random();
      int randNum;
   
      //shuffles cards in user deck
      for (int i = 0; i <= userCards.size()-1; i++)
      {
         randNum = gen.nextInt(userCards.size());
         Card temp = userCards.get(i);
         userCards.set(i, userCards.get(randNum));
         userCards.set(randNum, temp);
   
      }

      //shuffle cards in computers deck
      for (int i = 0; i <= compCards.size()-1; i++)
      {
         randNum = gen.nextInt(compCards.size());
         Card temp = compCards.get(i);
         compCards.set(i, compCards.get(randNum));
         compCards.set(randNum, temp);
   
       }
    }



   /*
      returns card object from users pile
      @return userCard object
   */
   public Card getUserCard()
   {
      return userCard;
   }


   /*
      returns card object from computers pile
      @return compCard object
   */
   public Card getCompCard()
   {
      return compCard;
   }


   /*
      returns number of cards in users pile
      @return Int number of cards left in users pile
   */
   public int getUserNumCards()
   {
      return userCards.size();
   }
   

   /*
      returns number of cards in computer's pile
      @return Int number of cards left in computers pile
   */
   public int getCompNumCards()
   {
      return compCards.size();
   }


   /*
      returns the size of the number of cards that are won
      @return Int size of warCards array for how many cards are not flipped in war
   */
   public int getWagerSize()
   {
      return wagerCount;
   }


   /*
      determines who won each round
      @return boolean of who won round
   */
   public int getRoundWinner()
   {
      return winNum;
   }


   /*
      determines whether or not the game is over
      @return boolean true if there is a winner and false if game is still going
   */
   public boolean gameOver()
   {
      return gameOver;
   }


}