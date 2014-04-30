//Griffen Fox
//CS 110
//Final Project: Card Class

/** Class that creates card objects of a 52 playing card deck
    methods return card suit and/or rank and allow for card object comparison */

import javax.swing.*;

public class Card extends JFrame
{
   //Declare Constants
   public final static int CLUBS = 0;
   public final static int DIAMONDS = 1;
   public final static int HEARTS = 2;
   public final static int SPADES = 3;
   public final static int JOKER = 4;
      
   public final static int ACE = 1;
   public final static int KING = 13;
   public final static int QUEEN = 12;
   public final static int JACK = 11;

   //Declare Variables
   private final int suit; //holds value of suit and does not change
   private final int rank; //holds numerical value of card and does not change
   private final ImageIcon image;
   
   
   //Constructor: default to joker if no parameters set
   
   public Card()
   {
      suit = JOKER;
      rank = 0;
      image = new ImageIcon("images/joker.jpg");
   }
   
   /**
   Constructor
   @param int value of suit
   @param int value of rank
   */
   
   public Card (int theSuit, int theRank)
   {
      suit = theSuit;
      rank = theRank;
      image = cardImage();
      
   }
   
   /**
   getSuit method
   @returns int value of suit
   */
   public int getSuit()
   {
      return suit;
   }
   
   /**
   getRank method
   @returns int value of rank
   */
   public int getRank()
   {
      return rank;
   }
   
   /**
   * getImage method
   * @return ImageIcon of card image associated
   */
   public ImageIcon getIcon()
   {
      return image;
   }
   /**
   suitToString method
   @return string value of suit selected
   */
   private String suitToString()
   {
      switch(suit)
      {
         case CLUBS:
         {
            return "Clubs";
            
         }
         case DIAMONDS:
         {
            return "Diamonds";
            
         }
         case HEARTS:
         {
            return "Hearts";
            
         }
         case SPADES:
         {
            return "Spades";
            
         }
         default:
         {
            return "Joker";
            
         }
      }
   }
   
   /**
   rankToString method
   @return string of rank numerical value
   */
   private String rankToString()
   {
      if (suit == JOKER)
      {
         return "0";
      }
      else
      {
         switch(rank)
         {
            case 1:
            {
               return "Ace";
            }
             case 2:
            {
               return "2";
            }
             case 3:
            {
               return "3";
            }
             case 4:
            {
               return "4";
            }
             case 5:
            {
               return "5";
            }
             case 6:
            {
               return "6";
            }
             case 7:
            {
               return "7";
            }
             case 8:
            {
               return "8";
            }
             case 9:
            {
               return "9";
            }
             case 10:
            {
               return "10";
            }
             case 11:
            {
               return "Jack";
            }
             case 12:
            {
               return "Queen";
            }
             case 13:
            {
               return "King";
            }
            default:
            {
               return "King";
            }
         }
      }
   }
   /**
   * cardImage assigns image to each card from the given filepath
   * @return ImageIcon of image assigned to given card value
   */
   private ImageIcon cardImage()
   {
      switch(suit)
      {
      case CLUBS:
      {
         switch(rank)
         {
            case 1:
            {
               return new ImageIcon("images/acec.jpg");
            }
            case 2:
            {
               return new ImageIcon("images/2c.jpg");
            }
            case 3:
            {
               return new ImageIcon("images/3c.jpg");
            }
            case 4:
            {
               return new ImageIcon("images/4c.jpg");
            }
            case 5:
            {
               return new ImageIcon("images/5c.jpg");
            }
            case 6:
            {
               return new ImageIcon("images/6c.jpg");
            }
            case 7:
            {
               return new ImageIcon("images/7c.jpg");
            }
            case 8:
            {
               return new ImageIcon("images/8c.jpg");
            }
            case 9:
            {
               return new ImageIcon("images/9c.jpg");
            }
            case 10:
            {
               return new ImageIcon("images/10c.jpg");
            }
            case 11:
            {
               return new ImageIcon("images/jackc.jpg");
            }
            case 12:
            {
               return new ImageIcon("images/queenc.jpg");
            }
            case 13:
            {
               return new ImageIcon("images/kingc.jpg");
            }
         }
      }
      case DIAMONDS:
      {
         switch(rank)
         {
            case 1:
            {
               return new ImageIcon("images/aced.jpg");
            }
            case 2:
            {
               return new ImageIcon("images/2d.jpg");
            }
            case 3:
            {
               return new ImageIcon("images/3d.jpg");
            }
            case 4:
            {
               return new ImageIcon("images/4d.jpg");
            }
            case 5:
            {
               return new ImageIcon("images/5d.jpg");
            }
            case 6:
            {
               return new ImageIcon("images/6d.jpg");
            }
            case 7:
            {
               return new ImageIcon("images/7d.jpg");
            }
            case 8:
            {
               return new ImageIcon("images/8d.jpg");
            }
            case 9:
            {
               return new ImageIcon("images/9d.jpg");
            }
            case 10:
            {
               return new ImageIcon("images/10d.jpg");
            }
            case 11:
            {
               return new ImageIcon("images/jackd.jpg");
            }  
            case 12:
            {
               return new ImageIcon("images/queend.jpg");
            }
            case 13:
            {
               return new ImageIcon("images/kingd.jpg");
            }
         }  

      }
      case HEARTS:
      {
         switch(rank)
         {
            case 1:
            {
               return new ImageIcon("images/aceh.jpg");
            }
            case 2:
            {
               return new ImageIcon("images/2h.jpg");
            }
            case 3:
            {
               return new ImageIcon("images/3h.jpg");
            }
            case 4:
            {
               return new ImageIcon("images/4h.jpg");
            }
            case 5:
            {
               return new ImageIcon("images/5h.jpg");
            }
            case 6:
            {
               return new ImageIcon("images/6h.jpg");
            }
            case 7:
            {
               return new ImageIcon("images/7h.jpg");
            }
            case 8:
            {
               return new ImageIcon("images/8h.jpg");
            }
            case 9:
            {
               return new ImageIcon("images/9h.jpg");
            }
            case 10:
            {
               return new ImageIcon("images/10h.jpg");
            }
            case 11:
            {
               return new ImageIcon("images/jackh.jpg");
            }
            case 12:
            {
               return new ImageIcon("images/queenh.jpg");
            }
            case 13:
            {
               return new ImageIcon("images/kingh.jpg");
            }
         }
   
      }
      case SPADES:
      {
         switch(rank)
         {
            case 1:
            {
               return new ImageIcon("images/aces.jpg");
            }
            case 2:
            {
               return new ImageIcon("images/2s.jpg");
            }
            case 3:
            {
               return new ImageIcon("images/3s.jpg");
            }
            case 4:
            {
               return new ImageIcon("images/4s.jpg");
            }
            case 5:
            {
               return new ImageIcon("images/5s.jpg");
            }
            case 6:
            {
               return new ImageIcon("images/6s.jpg");
            }
            case 7:
            {
               return new ImageIcon("images/7s.jpg");
            }
            case 8:
            {
               return new ImageIcon("images/8s.jpg");
            }
            case 9:
            {
               return new ImageIcon("images/9s.jpg");
            }
            case 10:
            {
               return new ImageIcon("images/10s.jpg");
            }
            case 11:
            {
               return new ImageIcon("images/jacks.jpg");
            }
            case 12:
            {
               return new ImageIcon("images/queens.jpg");
            }
            case 13:
            {
               return new ImageIcon("images/kings.jpg");
            }
         }
   
      }
      default:
      {
         return new ImageIcon("images/joker.jpg");
   
      }
   }
}
   
   /**
toString method
@return string of suit and rank
*/
   
   public String toString()
   {
      return rankToString()+ " of " +suitToString();
   }
  
   /**
equalsRank method
@return boolean of whether or not cards' ranks are equal
*/
   public boolean equalsRank(Card otherCard)
   {
      //Declare variables
      boolean status;
      
      if (rank == otherCard.rank)
      {
         status = true;
      }
      else
      {
         status = false;
      }
      
      return status;

   }
   
   /**
greaterThan method
@return boolean of whether or not card rank is greater than otherCard
*/
   public boolean greaterThan(Card otherCard)
   {
      //Declare variables
      boolean status;
      
      if (rank > otherCard.rank)
      {
         status = true;
      }
      else
      {
         status = false;
      }
      
      return status;

   }

   public boolean equals(Card otherCard)
   {
boolean status;
if (this.rank == otherCard.rank)
{
status = true;
}
else
{
status = false;
}
return status;
   }
   
  
}