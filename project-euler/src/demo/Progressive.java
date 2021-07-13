package demo;

public class Progressive {
	
//	11 meter limit 
//	3 meter up
//	2 meter down
	
//	public static int getResult(int distance, int progress, int loss) {
//		int totalDays = 0;
//		int day = progress - loss;
//		
//		totalDays = ((distance - loss) / (progress - loss)) * day;
//		return totalDays;
//	}
	
	public static int getResult(int distance, int progress, int loss) {
		int a = progress;
		int d = progress - loss;
		int tn = distance;
		
		int n = (tn + d - a) / d;
		
		return n;
	}
	
	
	public static void main(String[] args) {
		System.out.println(getResult(11, 3, 2));
	}
}
