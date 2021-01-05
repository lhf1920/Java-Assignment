public class TestBakerySystemStudent
{
    public static void main(String args[])
    {
        BreadType[] breadType = new BreadType[TestBakerySystem.MAX_BREAD_TYPE_ITEM];
        
        try {
	        breadType[0] = new Loaf("French Toast", 30.0);
	        breadType[1] = new Loaf("Cheese Loaf", 70.0);
	        breadType[2] = new Cake("Black Forest Cake", 180.0);
	        breadType[3] = new Cake("Blueberry CheeseCake", 230.0);
	        
	        TestBakerySystem bs = new TestBakerySystem(breadType);
	        bs.start();
        }
        catch (Exception e) {
        	System.out.println(e.getMessage());
        }
    }
}