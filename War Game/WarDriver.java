//Griffen Fox
//CS110
//Final Project
//War Driver

import javax.swing.JFrame;
import java.awt.*;

public class WarDriver 
{

   public static void main(String[] args)
   {
      
      JFrame frame = new WarGameGUI();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setMinimumSize(new Dimension(900,850));
      frame.validate();
      frame.setVisible(true);

   }

}

