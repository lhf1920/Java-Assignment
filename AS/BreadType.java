
public abstract class BreadType {
    private String name;
    private double cost;
    String showformat = "%1$s %2$-23s  %3$-8s  %4$15s  %5$11s  %6$6s  %7$7s  %8$6s %n";
    private double totalSales=0;
	private int soldQuantity=0;
    private int totalBreadTypes;

    public BreadType(String name,double cost){
     	this.name = name;
     	this.cost = cost;
    }

    public double updateCurrentSales(double price,int quantity ){
		double currentSale = price * quantity;
		this.totalSales += currentSale;
		this.soldQuantity += quantity;
        return currentSale;
	}



    //Setter and getter
	public void setCost(double cost){this.cost = cost;}
    public void setName(String name){this.name = name;}
    public String getShowFormat(){return showformat;}
    public double getTotalSales(){return totalSales;}
    public int getSoldQuantity(){return soldQuantity;}
    public double getCost(){return cost;}
    public String getName(){return name;}
    public int getTotalBreadTypes(){return totalBreadTypes;}
    public void setTotalBreadTypes(int totalBreadTypes){this.totalBreadTypes=totalBreadTypes;}


    //


    abstract double suggestedPrice();
    abstract double totalProfit();
    abstract void showDetails();


}



 class Cake extends BreadType{
	private double PROFIT_MARGIN=0.4;
	private double MIN_SUGGESTED_PRICE=100;
	private double MIN_WEIGHT=0.5;
	private double MAX_WEIGHT=5;
	private double soldWeight;

    public Cake(String name,double cost){
        super(name,cost);

    }

    public double sellingBread(double price,double weight){
        this.soldWeight += weight;
        return updateCurrentSales(price * weight, 1);
    }

    public double suggestedPrice(){
        if(getCost() * (1 + PROFIT_MARGIN)>MIN_SUGGESTED_PRICE)
           return getCost()*(1 + PROFIT_MARGIN);
        else
	       return MIN_SUGGESTED_PRICE;
    }

    public double totalProfit(){
        return getTotalSales()-(getCost() * this.soldWeight);
    }


    public double getSoldWeight(){
		return soldWeight;
    }


    public void showDetails(){
        System.out.printf(getShowFormat(),"",getName(),"Cake", String.format("%.1f",getCost())+" Per Pound"
        ,String.format("%.1f",suggestedPrice()),getSoldQuantity(),String.format("%.1f",soldWeight),String.format("%.1f",getTotalSales()));
    }

}


class Loaf extends BreadType{
	double PROFIT_MARGIN=0.2;

    public Loaf(String name,double cost){
        super(name,cost);
    }

    public double sellingBread(double price,double quantity){
        return updateCurrentSales(price , (int)(quantity));
    }

    public double suggestedPrice(){
        return getCost()*(1 + PROFIT_MARGIN);
    }

    public double totalProfit(){
        return getTotalSales()-(getCost() * getSoldQuantity());
    }


    public void showDetails(){
       System.out.printf(getShowFormat(),"",getName(),"Loaf", String.format("%.1f",getCost()) +" Per Piece"
       ,String.format("%.1f",suggestedPrice()),getSoldQuantity(),"N.A.",String.format("%.1f",getTotalSales()));
    }

}

