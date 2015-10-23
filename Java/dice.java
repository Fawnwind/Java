// Starter Template 


public class program3{ 
  //Variable Declaration area 
  
  
  
  public static void main(String[ ] args) 
  {
    new program3();
  }  
  
  public program (){
  //Create object and your code goes here

int die1 = (int) (Math.random()*6) + 1 ;
int die2 = (int) (Math.random()*6) + 1 ;
int total = die1 + die2 ;
int totalr = 1 ;
int usrv = TextIO.getInt() ;



while ( total != usrv)
{
  System.out.println("The first die was a "+ die1) ;
  System.out.println("The second die was a "+ die2) ;
  System.out.println("The total is  "+ total) ;
  die1 = (int) (Math.random()*6) + 1 ;
  die2 = (int) (Math.random()*6) + 1 ;
  total = die1 + die2 ;
  totalr ++ ;
}

System.out.println("The first die was a "+ die1) ;
System.out.println("The second die was a "+ die2) ;
System.out.println("The total is  "+ total) ;
System.out.println("You rolled " + totalr + " times") ;

  } 
}