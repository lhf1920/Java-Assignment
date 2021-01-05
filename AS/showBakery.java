
import java.util.Scanner;
import java.io.*;
class showBakery{
   public showBakery(int rate,BreadType[] breadType)throws IOException  {
	   int sold = 0;
	   double sales = 0;
	   double profit = 0;
       double cost = 0;
	   for(int i = 0;i<rate;i++){
		  sold += breadType[i].getSoldQuantity();
		  sales += breadType[i].getTotalSales();
          profit += breadType[i].totalProfit();
          if (breadType[i] instanceof Loaf)
            cost += breadType[i].getCost()*breadType[i].getSoldQuantity();
          else
            cost += breadType[i].getCost()*((Cake)breadType[i]).getSoldWeight();
	   }


	   String strFormat = "%1$-30s : %2$-7s%n";
	   System.out.println("Statistics of Bakery Shop");
	   System.out.printf(strFormat,"Total Types of Bread",(rate));
	   System.out.printf(strFormat,"Total Pieces of Bread Sold",sold);
	   System.out.printf(strFormat,"Total Sales",sales);
	   System.out.printf(strFormat,"Total Cost",String.format("%.1f",cost));
	   System.out.printf(strFormat,"Total Profit",String.format("%.1f",profit));
	   System.out.println();
       System.out.println("1.  :Save Bakery Shop Statistics(log.txt)");
	   System.out.println("0.  :previous menu");


	   int choice = 1;
	   boolean isValidChoice = false;
       Scanner sc = new Scanner(System.in);
	    do {
	   		System.out.println("Please input your choice. (0 - 1):");
	          try {
	   			choice = sc.nextInt();
	               	if(choice < 0 || choice > 1)
	                  throw new Exception();
	                  isValidChoice = true;
	   				} catch (Exception e) {
	   					System.out.println("Invalid Choice.");
	   					sc.nextLine();
	   					isValidChoice = false;
	   				}
            } while(!isValidChoice);


            if (choice==1){
				String str = "Total Types of Bread " + rate +"\n" +
         			"Total Pieces of Bread Sold "+sold+"\n" +
					"Total Sales "  + sales +"\n" +
		  			"Total Cost "+cost+"\n" +
					"Total Profit "+profit+"\n";
					savelog(str);
            }

   }
     public void savelog (String str)throws IOException {
	         String fileName = "log.txt" ;
			FileWriter OutFile = new FileWriter( fileName );
			OutFile.write(str);
		    OutFile.close();

	}




}