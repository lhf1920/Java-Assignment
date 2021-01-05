import java.util.Scanner;
import java.lang.*;
import java.io.*;
public class TestBakerySystem{
	public static final int MAX_BREAD_TYPE_ITEM = 8;
	private BreadType[] breadType;
    int rate=0; //run BREAD_TYPE_ITEM
    String name;//input name
	// Normally it is not required, but students can add your own class variables here

	public TestBakerySystem(BreadType[] breadType) {
		this.breadType = breadType;

		// Normally it is not required, but students can add your own statements here
	}

	public void start() throws IOException{
            //Check input rate;
            for(int i=0;i<MAX_BREAD_TYPE_ITEM;i++)
            if((breadType[i])!=null){
            rate++;}
            //
        while (true) {
        	System.out.println("Welcome to Bakery Sales System.");
            System.out.println("1. : Create New Bread Type");
            System.out.println("2. : Display or Selling Breads");
            System.out.println("3. : Show Bakery Shop Statistics");
            System.out.println("4. : Exit");

            int choice = 4;
            boolean isValidChoice = false;

			Scanner sc = new Scanner(System.in);
            do {
				System.out.println("Please input your choice. (1 - 4):");
                try {
					choice = sc.nextInt();
                	if(choice < 1 || choice > 4)
                    	throw new Exception();
                    isValidChoice = true;
				} catch (Exception e) {
					System.out.println("Invalid Choice.");
					sc.nextLine();
					isValidChoice = false;
				}
            } while(!isValidChoice);

            if (choice == 1) { //Create New Bread Type
                 if (rate <MAX_BREAD_TYPE_ITEM){//limit MAX_BREAD_TYPE_ITEM
                   CreateType();//Method
                   rate++;//BREAD_TYPE_ITEM
                 }else{// rate>MAX_BREAD_TYPE_ITEM
			       System.out.println("Your Bakery Shop Already Selling the Maximum Number of Bread Types. \n" +
			       "You Can't Create Additional Bread Types Anymore. \n");
			     }
            }
            else if (choice == 2) { //Display or Update Bread Sales
            	if(rate == 0){
            	   System.out.println("There are No Breads Selling in this System. \n" +
                   "Please Create New Bread Type First! \n");
			    }else{
			  	 new displaySelling(rate,breadType);//call displaySelling input BREAD_TYPE_ITEM & all BREAD_TYPE
			    }
           }
            else if (choice == 3) { //Show Bakery Show Statistics
               new showBakery(rate,breadType); //call showBakery input BREAD_TYPE_ITEM & all BREAD_TYPE
            }
            else { //if (choice == 4) //Exit
            	System.exit(0);
            }
        }
	}

    public static void main(String args[])throws IOException
    {
    	// Normally students do not need to modify this method
        new TestBakerySystem(new BreadType[MAX_BREAD_TYPE_ITEM]).start();
    }

    //Method
      //CreateType
    	public void CreateType(){
			 double cost=0;
			 int choice =0;
			 Scanner sc = new Scanner(System.in);
	         Scanner input = new Scanner(System.in);

			        	System.out.println("Please Indicate the Type of Bread You Want to Create:");
			            boolean isValidChoice = false;
			            do {//choice 1or2
							System.out.println("1 - Cake");
							System.out.println("2 - Loaf");
			                try {
								choice = sc.nextInt();
			                	if(choice < 1 || choice > 2)
			                    	throw new Exception();
			                   	isValidChoice = true;
							} catch (Exception e) {
								System.out.println("Invalid Choice.");
								sc.nextLine();
								isValidChoice = false;
							}
			            } while(!isValidChoice);//end choice

	           boolean status = false;
	           do{ //start input Name
	           System.out.println("Enter the Bread Name for the New Bread Type:");
	           name = input.nextLine();
	               if (name.length() == 0 ){//Check String name if not any input.
	               System.out.println("The Name for the New Bread Type Cannot be Empty.");

	               }else{//Check reply name

				   		   for (int i=0; i<rate; i++){
				   		 	if ((name.equals(breadType[i].getName())) ){
						  			System.out.println("The Name for the New Bread Type Already Exist.");
						  			status = false;
							   		break;
						    }else{status = true;}
				     	   }
				     	   if(rate == 0)
						   status = true;
	               }//end check name

		       }while(status == false );//end name

         //call class input infor** & save
	           if (choice == 1) {
	              cost =  inputCost(choice);
			      breadType[rate] = new Cake(name,cost);
			      System.out.println("The New Bread Type " + name +" with Cost $"+ cost+" Per Pound Created.");
		       }else{
		          cost =  inputCost(choice);
		          breadType[rate] = new Loaf(name,cost);
                  System.out.println("The New Bread Type " + name +" with Cost $"+ cost+" Per Piece Created.");
		       }//end if


		}//end CreateType

        //inputCost
		public double inputCost(int choice){
			 Scanner input = new Scanner(System.in);
			 boolean done = false;
			 double cost=0;
		     do {
				try {
					if(choice==1)
		     	        System.out.println("Enter the Cost Per Pound (lb) for the New Bread Type, Cake:");
				    else
				        System.out.println("Enter the Cost Per Piece for the New Bread Type, Loaf:");
                    	cost =Double.parseDouble(input.nextLine());
					if (cost < 0 )//check error
				    throw new Exception();
	                done = true;
				  } catch (Exception e) {
					System.out.println("The Cost for the New Bread Type is Invalid.");
				  }
	          } while (! done);
	            return cost;//output cost
	   }//End inputCost
     //End Method

}



