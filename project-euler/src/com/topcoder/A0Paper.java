package com.topcoder;


/*
 * Problem Statement "Letter", "Legal", and "Tabloid" are examples of paper
 * sizes. Both Letter and Legal are 8 and half inches wide, but while Legal has
 * length 14 inches, Letter is 11 inches long. This means that 14 letters have
 * the same total length as 11 legals. Unless, of course, by "Letter" we mean
 * "Government Letter" or instead of "Legal" we want "Junior Legal". In the days
 * of manual paper making, the length of 11 inches was quite practical, as it is
 * reportedly about a quarter of
 * "the average maximum stretch of an experienced vatman's arms". Luckily for
 * you, this problem is about a much more systematic way of cutting paper: the A
 * series.
 * 
 * The papers in the A series are numbered A0, A1, A2, and so on until infinity.
 * A0 is the largest of these papers. The area of an A0 paper is exactly 1
 * square meter.
 * 
 * All paper sizes in the A series have the same aspect ratio. More precisely,
 * the ratio between the longer side and the shorter side of any paper in the A
 * series is exactly equal to the square root of 2.
 * 
 * For each i, the longer side of the A(i+1) paper is equal to the shorter side
 * of the A(i) paper.
 * 
 * From the previous two definitions it follows that the A series has the
 * following useful property: Whenever you take an A(i) paper and you cut it in
 * half (using a cut that passes through the centers of its longer sides), you
 * will get two pieces of an A(i+1) paper. In other words, A1 is one half of A0,
 * A2 is one half of A1, and so on.
 * 
 * You are given a A. A[i] represents the number of papers of size A(i) you have
 * in stock. For example, A[4] is the number of A4 papers you currently have.
 * 
 * You are not allowed to cut paper in any way. You can only connect papers
 * (seamlessly and without any waste) by taping them together. The papers you
 * connect this way must not overlap. Can you take some of the papers you have
 * and assemble a paper of size A0? Return "Possible" if it can be done and
 * "Impossible" otherwise.
 * 
 * Definition Class: A0Paper Method: canBuild Parameters: int[] Returns: String
 * Method signature: String canBuild(int[] A) (be sure your method is public)
 * Limits Time limit (s): 2.000 Memory limit (MB): 256 Notes - The return value
 * is case-sensitive. Make sure you return the string exactly as shown in the
 * problem statement. Constraints - A will contain between 1 and 21 elements,
 * inclusive. - Each element of A will be between 0 and 220, inclusive. Examples
 * 0) {0,3} Returns: "Possible" We have 0 pieces of A0 paper and 3 pieces of A1
 * paper. We can combine the two of the three A1 papers to get an A0. 1) {0,1,2}
 * Returns: "Possible" This time, we can combine two A2 papers to get a second
 * A1. Afterwards, the two of A1s (the original one and the one we made from the
 * two A2s) can be combined to obtain an A0. 2) {0,0,0,0,15} Returns:
 * "Impossible" An A0 paper can be assembled from 16 A4 papers, but here we only
 * have 15. 3) {2,0,0,0,0,0,0,3,2,0,0,5,0,3,0,0,1,0,0,0,5} Returns: "Possible"
 * We already have two pieces of A0 paper, so we can just take one of them and
 * we are done. This problem statement is the exclusive and proprietary property
 * of TopCoder, Inc. Any unauthorized use or reproduction of this information
 * without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */

public class A0Paper {

	public static String canBuild(int[] paperSizeArray) {
		String response = "Impossible";
		double previousValue = 0;
		double value = 0;

		if (paperSizeArray[0] >= 1) {
			response = "Possible";
		} else {

			for (int i = 0; i <= paperSizeArray.length - 1; i++) {

				if (i != 0)
					value = valueofPaperize((double) paperSizeArray[i], i);
				previousValue += value;
				value = 0;
				if (previousValue >= 1) {
					response = "Possible";
				}
			}
		}
		return response;
	}

	private static double valueofPaperize(double a, int b) {
		if(b == 0)
			return a;
			   a = a / 2;
			return valueofPaperize(a, b-1);
	}
	
	public static void main(String[] args) {
		int[] arr = {0,0,4};
		System.out.println(canBuild(arr));
	}
}
