// Starter Template 


public class dice2{ 
  //Variable Declaration area 
  
  
  
  public static void main(String[ ] args) 
  {
    new dice2();
  }  
  
  public dice2 (){
//---MiscInts---//
    
    int die1 = 0 ;
    int die2 = 0 ;
    int tot = 0 ;
    int number = 0 ;
    
//---ScoreInts---//
    
    int two = 0 ;
    int three = 0 ;
    int four = 0 ;
    int five = 0 ;
    int six = 0 ;
    int seven = 0 ;
    int eight = 0 ;
    int nine = 0 ;
    int ten = 0 ;
    int eleven = 0 ;
    int twelve = 0 ;
    
//---ScoreCal---//
    
    System.out.println("") ;
    int usrv = TextIO.getInt() ;
    
    while ( usrv != number)
    {
      System.out.println("The first die was a "+ die1) ;
      
      System.out.println("The second die was a "+ die2) ;
      System.out.println("The total is  "+ tot) ;
      die1 = (int) (Math.random()*6) + 1 ;
      die2 = (int) (Math.random()*6) + 1 ;
      tot = die1 + die2 ;
      number = number + 1 ;
      
      if (tot==2)
      {
        two = two + 1 ;
      }
      else if (tot==3)
      {
        three = three + 1 ;
      }
      else if (tot==4)
      {
        four = four + 1 ;
      }
      else if (tot==5)
      {
        five = five + 1 ;
      }
      else if (tot==6)
      {
        six = six + 1 ;
      }
      else if (tot==7)
      {
        seven = seven + 1 ;
      }
      else if (tot==8)
      {
        eight = eight + 1 ;
      }
      else if (tot==9)
      {
        nine = nine + 1 ;
      }
      else if (tot==10)
      {
        ten = ten + 1 ;
      }
      else if (tot==11)
      {
        eleven = eleven + 1 ;
      }
      else if (tot==12)
      {
        twelve = twelve + 1 ;
      }
      
    }
    
    System.out.println("The first die was a "+ die1) ;
    System.out.println("The second die was a "+ die2) ;
    System.out.println("The total is  "+ tot) ;
    System.out.println("You rolled " + number + " times") ;
    
//---Print_Score---//
    
    System.out.println("Twos:"+two+" Threes:"+three+" Fours:"+four+" Five:"+five+" Sixs:"+six) ;
    System.out.println("Seven:"+seven+" Eight:"+eight+" Nine:"+nine+" Ten:"+ten+" Eleven:"+eleven+" Twelve:"+twelve) ;  
  } 
}




