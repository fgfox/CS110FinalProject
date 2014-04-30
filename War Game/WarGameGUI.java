//Griffen Fox
//CS110
//Final Project
//War Game Gui Class

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class WarGameGUI extends JFrame
{
   //Declare Variables
   private JPanel gameContainer, leftTop, rightTop, leftBottom,
   rightBottom, buttonBar, cardBar, winnerBar;

   //JButtons
   private JButton flipButton, restartButton, exitButton;
      
   
   //Image Icons
   private ImageIcon userFront, userBack, compFront, compBack;	
      
   
   //JLabels images
   private JLabel userPicBack, userPicFront, compPicBack, compPicFront, warBack1, warBack2;
   
   //JLabels for text
   private JLabel userCards, compCards, userNum, compNum, winnerLabel;
      
   //WarGame object
   private WarGame war;

   public WarGameGUI()
   {
      //JFrame title
      super("Game of War");
      
      //Create a new WarGame
      war = new WarGame();
   
      //layout of default container
      setLayout(new BorderLayout());
            
      createPanels();
      createPanelLabels();
      createButtons();
      createImageIcons();
      addPanelsToFrames();
      addToMainFrame();	

   }


   
   //creates panels and panel containers
   private void createPanels()
   {
      //creates grid container
      gameContainer = new JPanel(new GridLayout(2,2));
      gameContainer.setMaximumSize(new Dimension(450,550));

      //creates 4 top and bottom panels
      leftTop = new JPanel(new FlowLayout());
      leftTop.setMaximumSize(new Dimension(200, 225));
   
      rightTop = new JPanel(new FlowLayout());
      rightTop.setMaximumSize(new Dimension(250, 225));
   
      leftBottom = new JPanel(new FlowLayout());
      leftBottom.setMaximumSize(new Dimension(200, 225));
   
      rightBottom = new JPanel(new FlowLayout());
      rightBottom.setMaximumSize(new Dimension(250, 225));

      //create winner panel
      winnerBar = new JPanel(new FlowLayout());
      winnerBar.setMinimumSize(new Dimension(300,200));
         
      //create card panel
      cardBar = new JPanel(new GridLayout(4,1));
      cardBar.setBackground(new Color(250,250,250));
      cardBar.setAlignmentX(Component.CENTER_ALIGNMENT);
      cardBar.setAlignmentY(Component.CENTER_ALIGNMENT);
      cardBar.setSize(200,300);
         
      //create button panel
      buttonBar = new JPanel(new FlowLayout());
      buttonBar.setMinimumSize(new Dimension(900,200));
   
      //Borders
      winnerBar.setBorder(BorderFactory.createLoweredBevelBorder());
      cardBar.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 2, Color.black));
      leftTop.setBorder(BorderFactory.createLoweredBevelBorder());
      rightTop.setBorder(BorderFactory.createLoweredBevelBorder());
      leftBottom.setBorder(BorderFactory.createLoweredBevelBorder());
      rightBottom.setBorder(BorderFactory.createLoweredBevelBorder());
   
      //Align Text
      winnerBar.setAlignmentX(50);
   }
   
 
   //creates labels for winnerBar and cardBar panel  
   private void createPanelLabels()
   {
      //label to display who round winner
      winnerLabel = new JLabel();
      winnerLabel.setFont(new Font("Times",Font.BOLD,36));
      winnerLabel.setText("Welcome to War");
      winnerBar.add(winnerLabel);

      //card pile labels
      userCards = new JLabel();
      userCards.setText("User Cards ");
      userCards.setFont(new Font("Times", Font.BOLD, 18));
      userCards.setHorizontalAlignment(SwingConstants.CENTER);
      cardBar.add(userCards);
      
      userNum = new JLabel();
      userNum.setText(""+war.getUserNumCards());
      userNum.setFont(new Font("Times", Font.BOLD, 40));
      userNum.setForeground(new Color(0,186,161));
      userNum.setHorizontalAlignment(SwingConstants.CENTER);
      userNum.setVerticalAlignment(SwingConstants.TOP);
      cardBar.add(userNum);
            

      compCards = new JLabel();
      compCards.setText("Computer Cards ");
      compCards.setFont(new Font("Times", Font.BOLD, 18));
      compCards.setHorizontalAlignment(SwingConstants.CENTER);
      cardBar.add(compCards);
      
      compNum = new JLabel();
      compNum.setText(""+war.getCompNumCards());
      compNum.setFont(new Font("Times", Font.BOLD, 40));
      compNum.setForeground(new Color(216,88,118));
      compNum.setHorizontalAlignment(SwingConstants.CENTER);
      compNum.setVerticalAlignment(SwingConstants.TOP);
      cardBar.add(compNum);
      

   }
   
 
   //creates and activates JButtons for buttonBar panel  
   private void createButtons()
   {
      //flip button
      flipButton = new JButton("Flip Card");
      flipButton.setForeground(new Color(42,125,220));
      flipButton.setFont(new Font("Times",Font.BOLD,18));
      flipButton.addActionListener(new ButtonListener());
      buttonBar.add(flipButton);
   
      //restart button
      restartButton = new JButton("Restart");
      restartButton.setFont(new Font("Times",Font.BOLD,18));
      restartButton.setForeground(new Color(17,176,59));
      restartButton.addActionListener(new ResetListener());
      buttonBar.add(restartButton);
      
      //exit button
      exitButton = new JButton("Exit");
      exitButton.setForeground(new Color(220,60,42));
      exitButton.setFont(new Font("Times",Font.BOLD,18));
      exitButton.addActionListener(new ExitListener());
      buttonBar.add(exitButton);
      
   }
   
   
   //creates all images and labels for images and adds JLabels to frames
   private void createImageIcons()
   {
      //image icons
      userFront = null;
      userBack = new ImageIcon("images/back.jpg");
      compFront = null;
      compBack = new ImageIcon ("images/back.jpg");
            
      //labels for image icons
      userPicFront = new JLabel();
      compPicFront = new JLabel();
   
      userPicBack = new JLabel(userBack);
      compPicBack = new JLabel(compBack);
   
      warBack1 = new JLabel();
      warBack2 = new JLabel();
            
      //adds pictures to panels
      leftTop.add(userPicBack);
      leftBottom.add(compPicBack);
   
      rightTop.add(warBack1);
      rightBottom.add(warBack2);
   
      rightTop.add(userPicFront);
      rightBottom.add(compPicFront);
   
   }
   
   private void addPanelsToFrames()
   {
      //add all panels to correct frames
      gameContainer.add(leftTop);
      gameContainer.add(rightTop);
      gameContainer.add(leftBottom);
      gameContainer.add(rightBottom);
   }
   
   //adds all panels to the main frame
   private void addToMainFrame()
   {
      //add main container panels to large jFrame
      add(gameContainer, BorderLayout.CENTER);
      add(cardBar, BorderLayout.WEST);
      add(buttonBar, BorderLayout.SOUTH);
      add(winnerBar, BorderLayout.NORTH);
   }
   
   
   
   //implements methods for each card flip

   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (war.gameOver()==false)
         {
            //set the text of each card pile number based on winner
            userNum.setText(""+war.getUserNumCards());
            compNum.setText(""+war.getCompNumCards());
         
            //determine whether or not war cards must be laid out
            if (war.getRoundWinner() == -1)
            {
               warBack1.setIcon(userBack);
               warBack2.setIcon(compBack);
            }
            else
            {
               warBack1.setIcon(null);
               warBack2.setIcon(null);
            }
                  
            //flip the next card in each pile
            war.flipCard();
           
            //change the card icons
            userFront = war.getUserCard().getIcon();
            compFront = war.getCompCard().getIcon();
         
            userPicFront.setIcon(userFront);
            compPicFront.setIcon(compFront);
                  
            //compare cards to determine winner
            war.compareCards();
                           
            if (war.getRoundWinner() == 1)
            {
               winnerLabel.setForeground(new Color(0,186,161));
               winnerLabel.setText("User wins "+war.getWagerSize()+" cards.");
                     
            }
            else if(war.getRoundWinner() == 0)
            {
               winnerLabel.setForeground(new Color(216,88,118));
               winnerLabel.setText("Computer wins "+war.getWagerSize()+" cards.");
                     
            }
            else if (war.getRoundWinner() == -1)
            {
               winnerLabel.setForeground(Color.black);
               winnerLabel.setText("It's a War!");
                     
            }
        }
        else if(war.gameOver() == true)
        {
            if (war.getRoundWinner() == 1)
            {
               winnerLabel.setForeground(new Color(0,186,161));
               winnerLabel.setText("Game over. User Wins!");
               winnerLabel.setFont(new Font("Times",Font.BOLD, 50));
               disableFlip();
            }
            else if(war.getRoundWinner() == 0)
            {
               winnerLabel.setForeground(new Color(216,88,118));
               winnerLabel.setText("Game over. Computer Wins.");
               winnerLabel.setFont(new Font("Times",Font.BOLD, 50));
               disableFlip();
            }
        }
   }
      
   //Signals end of game and disables flip button
   public void disableFlip()
   {
      flipButton.setEnabled(false);
   }
}
   
   
//closes program

private class ExitListener implements ActionListener
{
   public void actionPerformed(ActionEvent e)
   {
      System.exit(0);
   }
}

//starts a new game of war when clicked.
private class ResetListener implements ActionListener
{
   public void actionPerformed(ActionEvent e)
   {
      //create new war game
      war = new WarGame();
   
      //reset all labels and pictures
      winnerLabel.setForeground(Color.black);
      winnerLabel.setText("New Game");

      userCards.setText("User Cards ");

      userNum.setText(""+war.getUserNumCards());
   
      compCards.setText("Computer Cards ");
   
      compNum.setText(""+war.getCompNumCards());
   
      //reset Image Icons
      userFront = null;
      compFront = null;
      
      userPicFront.setIcon(userFront);
      compPicFront.setIcon(compFront);
   
      }
   }
}