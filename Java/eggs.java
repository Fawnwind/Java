	int eggs = 0 ;
    int gross = 0 ; 
    int dozen = 0 ;
    int reaminder = 0 ;
    
    System.out.println("How many eggs do you have?") ;
    eggs = TextIO.getlnInt() ;

    gross = eggs / 144 ;
    reaminder = eggs % 144 ;

    dozen = reaminder / 12 ;
    reaminder =  reaminder % 12 ;

    System.out.println("You have " + gross + "gross eggs") ;
    System.out.println("You have " + dozen + "dozen eggs") ;
    System.out.println("You have " + reaminder + "egg left") ;