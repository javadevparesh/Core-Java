package SingletonClassObject;

public class BillPugh_Solution {

}

class BillPughSolution_DBConn{
	
	// Constructor
	private BillPughSolution_DBConn() {
	}
	
	// Static nested class (This class will not initialize until 'getInstance()' is called)
	private static class DBCononectionHelper{
		private static final BillPughSolution_DBConn INSTANCE_OBJECT = new BillPughSolution_DBConn();
	}
	
	// Method
	public static BillPughSolution_DBConn getInstance() {
		return DBCononectionHelper.INSTANCE_OBJECT;
	}
}
