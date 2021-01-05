import java.util.Scanner;
import java.lang.*;
class displaySelling{
 Scanner sc = new Scanner(System.in);
 BreadType[] breadType;
 int choice=0;
 public displaySelling(int rate,BreadType[] breadType){
      this.breadType = breadType;
	  String Showformat = "%1$-5s %2$-18s | %3$-8s |      %4$-9s | %5$-9s | %6$-5s | %7$-6s | %8$-2s %n";

      System.out.println("Bread Sales:");
      System.out.printf(Showformat,
          "No.","Bread Name", "Category","Cost","Suggested","Sold","Sold","Sales");
      System.out.printf(Showformat,
          "", "" ,"","","Price","Qty","Pounds","");
      //List Selling
	  for(int i=0;i<rate;i++){
          if((breadType[i])!=null){
           System.out.printf("%s",i+1);
           breadType[i].showDetails();
          }
      }
      //choice
      menu(rate);//call menu
  }

//menu method
  public void menu(int rate){
	   boolean isValidChoice = false;
	  		do {//choice menu
	  			System.out.println("Please Input the Bread Type of Your Current Sales (1 - " + rate + ", 0 to previous menu):");
                try {
	  				choice = sc.nextInt();
	  			     if(choice < 0 || choice > rate) {
	  			       throw new Exception();
	  			     }
	  			   	isValidChoice = true;
	  				} catch (Exception e) {
	  					System.out.println("Invalid Choice.");
	  					sc.nextLine();
	  					isValidChoice = false;
	  				}
	  		   } while(!isValidChoice);//end choice

	        choice--;//Corrected value
	        if (choice > -1){
              System.out.println("The Suggested Price of " + breadType[choice].getName() + " is "
                  + String.format("%.1f",breadType[choice].suggestedPrice())
                  + "(Per Pound for Cake or Per Piece for Loaf)");

            //Set Price
            double cost =0;
            isValidChoice = false;
            do {
              try{

			     System.out.println("Please Input the Price You Want to Sell:");
                 cost = sc.nextDouble();
                   if(cost < 0 )
				  	 throw new Exception();
						isValidChoice = true;
	  		 } catch (Exception e) {
			        System.out.println("The Value of Price Must be Greater Than 0.");
			 }
            } while(!isValidChoice);//End Set price

            //  Set Quantity :inputs an invalid value for a cake || Set Loaf
            isValidChoice = false;
             double Quantity=0;
			do {
              try{

				if (breadType[choice] instanceof Loaf)//Loaf
                   System.out.println("Please Input the Quantity of " + breadType[choice].getName() + " You Want to Sell:");
                else
                   System.out.println("Please Input the Weight in Pound (lb) of " + breadType[choice].getName() + " You Want to Sell:");

                 Quantity= sc.nextDouble();
                 if (breadType[choice] instanceof Cake){//Cake
                    ((Cake)breadType[choice]).sellingBread(cost, Quantity);
                    if((Quantity <= 0.5)||(Quantity  > 5))
                       throw new Exception();

                       isValidChoice = true;
                       System.out.println("The Current Sales for Bread Type "+breadType[choice].getName()+" is "+(cost *Quantity));
                       new displaySelling(rate,breadType);
                 }else{   //Loaf
					 if(Quantity<0){
				    	 System.out.println("The Value of Quantity Must be Greater Than 0.");
                     }else{
				     	 isValidChoice = true;
                        ((Loaf)breadType[choice]).sellingBread(cost, Quantity);
                        System.out.println("The Current Sales for Bread Type "+breadType[choice].getName()+" is "+ (cost *Quantity) );
                         new displaySelling(rate,breadType);
                     }
			     }

	         }catch (Exception e) {
				if (Quantity <= 0.5)
			       System.out.println("The Value of Weight Must be Greater Than or Equals to 0.5 Pounds");
			    else
			       System.out.println("The Value of Weight Must be Smaller Than 5.0 Pounds");
		     }
		   }while(!isValidChoice);//End Set Quantity
		   System.out.println("The Current Sales for Bread Type " + breadType[choice].getName() + "is" +  breadType[choice].getTotalSales() );

         }
  }  // end menu method

}