public class TestBakerySystemStudent3
{
    public static void main(String args[])
    {
        BreadType[] breadType = new BreadType[TestBakerySystem.MAX_BREAD_TYPE_ITEM];
        try {
	        breadType[0] = new Loaf("French Toast", 30.0);
	        ((Loaf)breadType[0]).sellingBread(50, 6);

	        breadType[1] = new Loaf("Cheese Loaf", 70.0);

	        breadType[2] = new Cake("Black Forest Cake", 180.0);
	        ((Cake)breadType[2]).sellingBread(260, 5);

	        breadType[3] = new Cake(" CheeseCake", 230.0);
	        ((Cake)breadType[3]).sellingBread(30, 2);
	        breadType[4] = new Cake("eseCake", 20.0);
	        ((Cake)breadType[4]).sellingBread(30, 2);
	        breadType[5] = new Cake("Cake", 20.0);
	        ((Cake)breadType[5]).sellingBread(30, 2);
	        breadType[6] = new Cake("Blue", 23.0);
	        ((Cake)breadType[6]).sellingBread(33, 2);
	        breadType[7] = new Cake("berry", 23.0);
	        ((Cake)breadType[7]).sellingBread(30, 2);

	        TestBakerySystem bs = new TestBakerySystem(breadType);
	        bs.start();
        }
        catch (Exception e) {
        	System.out.println(e.getMessage());
        }
    }
}