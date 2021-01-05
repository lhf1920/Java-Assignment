public class TestBakerySystemStudent2
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

	        breadType[3] = new Cake("Blueberry CheeseCake", 230.0);
	        ((Cake)breadType[3]).sellingBread(330, 2);

	        TestBakerySystem bs = new TestBakerySystem(breadType);
	        bs.start();
        }
        catch (Exception e) {
        	System.out.println(e.getMessage());
        }
    }
}