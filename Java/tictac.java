// Starter Template 


public class tictac{ 
  //Variable Declaration area 
  
  String sq1 = "-" ;
  String sq2 = "-" ;
  String sq3 = "-" ;
  String sq4 = "-" ;
  String sq5 = "-" ;
  String sq6 = "-" ;
  String sq7 = "-" ;
  String sq8 = "-" ;
  String sq9 = "-" ;
  
  
  public static void main(String[ ] args) 
  {
    new tictac();
  } 
  
  public void draw (){
    //---GridPrint---//
    
    System.out.println(sq1+sq2+sq3) ;
    System.out.println(sq4+sq5+sq6) ;
    System.out.println(sq7+sq8+sq9) ;
    
  } 
  
  public tictac (){
    
//---MiscVar---//
    
    int win = 0 ;
    int p1 = 0 ;
    int p2 = 0 ;
    int pt = 0 ;
    int lc = 0 ;
    int gc = 0 ;
    int tie = 0 ;
    
//---TitleScreen---//
    
    System.out.println(" _____ _        _____           _____        ") ;
    System.out.println("|_   _|_|___   |_   _|__ ___   |_   _|__ ___ ") ;
    System.out.println("  | | | |  _|    | || .'|  _|    | || . | -_|") ;
    System.out.println("  |_| |_|___|    |_||__,|___|    |_||___|___|") ;
    System.out.println("") ;
    draw() ;

//---GameCalc---//
    
    while (win != 1 && tie != 1 && gc < 5)
    {
      
      
//---HugeIfStatementBlockP1---//
      
      while (lc !=1 && lc !=2 && win != 1 && gc < 5)
      {
        lc = 0 ;
        pt = 1 ;
        System.out.println("Player one please pick a valid square to put a X in.") ;
        p1 = TextIO.getInt() ;
        
        if (p1 == 1 && sq1.equals("-"))
        {
          sq1 = "X" ;
          lc = 1 ;
        }
        else if (p1 == 2 && sq2.equals("-"))
        {
          sq2 = "X" ;
          lc = 1 ;
        }
        else if (p1 == 3 && sq3.equals("-"))
        {
          sq3 = "X" ;
          lc = 1 ;
        }
        else if (p1 == 4 && sq4.equals("-"))
        {
          sq4 = "X" ;
          lc = 1 ;
        }
        else if (p1 == 5 && sq5.equals("-"))
        {
          sq5 = "X" ;
          lc = 1 ;
        }
        else if (p1 == 6 && sq6.equals("-"))
        {
          sq6 = "X" ;
          lc = 1 ;
        }
        else if (p1 == 7 && sq7.equals("-"))
        {
          sq7 = "X" ;
          lc = 1 ;
        }
        else if (p1 == 8 && sq8.equals("-"))
        {
          sq8 = "X" ;
          lc = 1 ;
        }
        else if (p1 == 9 && sq9.equals("-"))
        {
          sq9 = "X" ;
          lc = 1 ;
        }
        lc = 2 ;
      }
      
//---P1WinCheck---//
      if (sq1.equals(sq2) && sq1.equals(sq3) && !sq1.equals("-") && !sq2.equals("-") && !sq3.equals("-"))
      {
        win = 1 ;
      }
      else if (sq4.equals(sq5) && sq5.equals(sq6) && !sq4.equals("-") && !sq5.equals("-") && !sq6.equals("-"))
      {
        win = 1 ;
      }
      else if (sq7.equals(sq8) && sq7.equals(sq9) && !sq7.equals("-") && !sq8.equals("-") && !sq9.equals("-"))
      {
        win = 1 ;
      }
      else if (sq1.equals(sq4) && sq1.equals(sq7) && !sq1.equals("-") && !sq4.equals("-") && !sq7.equals("-"))
      {
        win = 1 ;
      }
      else if (sq2.equals(sq5) && sq2.equals(sq8) && !sq2.equals("-") && !sq5.equals("-") && !sq8.equals("-"))
      {
        win = 1 ;
      }
      else if (sq3.equals(sq6) && sq3.equals(sq9) && !sq3.equals("-") && !sq6.equals("-") && !sq9.equals("-"))
      {
        win = 1 ;
      }
      else if (sq1.equals(sq5) && sq1.equals(sq9) && !sq1.equals("-") && !sq5.equals("-") && !sq9.equals("-"))
      {
        win = 1 ;
      }
      else if (sq3.equals(sq5) && sq3.equals(sq7) && !sq3.equals("-") && !sq5.equals("-") && !sq7.equals("-"))
      {
        win = 1 ;
      }
      
      

      gc = gc + 1 ;
      draw() ;
      
//---HugeIfStatementBlockP2---//
      
      while (lc ==2 && win !=1 && gc <5)
      {
        lc = 0 ;
        pt = 2 ;
        System.out.println("Player two please pick a valid square to put a O in.") ;
        p1 = TextIO.getInt() ;
        
        if (p1 == 1 && sq1.equals("-"))
        {
          sq1 = "O" ;
          lc = 1 ;
        }
        else if (p1 == 2 && sq2.equals("-"))
        {
          sq2 = "O" ;
          lc = 1 ;
        }
        else if (p1 == 3 && sq3.equals("-"))
        {
          sq3 = "O" ;
          lc = 1 ;
        }
        else if (p1 == 4 && sq4.equals("-"))
        {
          sq4 = "O" ;
          lc = 1 ;
        }
        else if (p1 == 5 && sq5.equals("-"))
        {
          sq5 = "O" ;
          lc = 1 ;
        }
        else if (p1 == 6 && sq6.equals("-"))
        {
          sq6 = "O" ;
          lc = 1 ;
        }
        else if (p1 == 7 && sq7.equals("-"))
        {
          sq7 = "O" ;
          lc = 1 ;
        }
        else if (p1 == 8 && sq8.equals("-"))
        {
          sq8 = "O" ;
          lc = 1 ;
        }
        else if (p1 == 9 && sq9.equals("-"))
        {
          sq9 = "O" ;
          lc = 0 ;
        }
      }
      
//---P2WinCheck---//
      if (sq1.equals(sq2) && sq1.equals(sq3) && !sq1.equals("-") && !sq2.equals("-") && !sq3.equals("-"))
      {
        win = 1 ;
      }
      else if (sq4.equals(sq5) && sq4.equals(sq6) && !sq4.equals("-") && !sq5.equals("-") && !sq6.equals("-"))
      {
        win = 1 ;
      }
      else if (sq7.equals(sq8) && sq7.equals(sq9) && !sq7.equals("-") && !sq8.equals("-") && !sq9.equals("-"))
      {
        win = 1 ;
      }
      else if (sq1.equals(sq4) && sq1.equals(sq7) && !sq1.equals("-") && !sq4.equals("-") && !sq7.equals("-"))
      {
        win = 1 ;
      }
      else if (sq2.equals(sq5) && sq2.equals(sq8) && !sq2.equals("-") && !sq5.equals("-") && !sq8.equals("-"))
      {
        win = 1 ;
      }
      else if (sq3.equals(sq6) && sq3.equals(sq9) && !sq3.equals("-") && !sq6.equals("-") && !sq9.equals("-"))
      {
        win = 1 ;
      }
      else if (sq1.equals(sq5) && sq1.equals(sq9) && !sq1.equals("-") && !sq5.equals("-") && !sq9.equals("-"))
      {
        win = 1 ;
      }
      else if (sq3.equals(sq5) && sq3.equals(sq7) && !sq3.equals("-") && !sq5.equals("-") && !sq7.equals("-"))
      {
        win = 1 ;
      }
      
      if (gc < 5)
      {
        draw() ;
      }

      lc = 0 ;
      
//---TieCheck---//
      
    }
     
    if (win != 1)
    {
      tie = 1 ;
    }
      
    System.out.println("") ;
    
    if (win == 1 )
    {
      System.out.println("Player " + pt + " wins!") ;  
      System.out.println("There were " + gc + " sets of turns.") ;
    }
    else if (tie == 1)
    {
      System.out.println("Tie game.") ;
    }
  }
}
