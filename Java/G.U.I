// Starter Template 
// import(s) at top of program b4 class line

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class starterGUI extends JFrame{ 
  //Variable and GUIObject Declaration area 
  
  JPanel Panel1= new JPanel() ;
  JLabel label1 = new JLabel("Lol Cats") ;
  JTextField text1 = new JTextField("",20) ;
  
  
  
  public static void main(String[ ] args) 
  {
    new starterGUI();
  }  
  
  public starterGUI (){
    //Create object and your code goes here 
    Panel1.add(label1) ;
    Panel1.add(text1) ;
    
    this.add(Panel1) ;
    this.setSize(300,300) ;
    this.setVisible(true) ;
    
  }
}




