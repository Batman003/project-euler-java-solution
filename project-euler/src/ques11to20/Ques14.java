package ques11to20;

public class Ques14 {
	
	private static long startTime = System.currentTimeMillis();
	
	public static String getLongestCollartzNumber(int range) {

		Integer response = 0;
		Integer result = 0;

		for (int i = range - 1; i >= 2; i--) {
			double temp = i;
			boolean flag = true;
			int count = 0;
			while (flag) {
				if (temp == 1) {
					if (count > response) {
						response = count;
						result = i;
					}
					flag = false;
				}

				if (temp % 2 == 0) {
					count++;
					temp = temp / 2;
				} else {
					count++;
					temp = (3 * temp) + 1;
				}

			}

		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		String result = getLongestCollartzNumber(1000000);
		System.out.println("RESULT:: "+result);
		long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) + " milliseconds");
	}
}
