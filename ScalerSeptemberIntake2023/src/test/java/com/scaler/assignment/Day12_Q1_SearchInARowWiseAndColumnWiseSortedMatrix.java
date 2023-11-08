package com.scaler.assignment;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * Example Explanation
Expanation 1:-
A[1][2] = 2
1 * 1009 + 2 = 1011
Explanation 2:-
A[2][1] = 3
2 * 1009 + 1 = 2019
A[2][2] = 3
2 * 1009 + 2 = 2020
The minimum value is 2019
 */
/**
 * @author vigneshwaran
 */
public class Day12_Q1_SearchInARowWiseAndColumnWiseSortedMatrix {
	@Test
	public void test01() {
		int[][] A = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int B = 2;
		int actual = solve(A, B);
		Assert.assertEquals(actual, 1011);
	}

	@Test
	public void test02() {
		int[][] A = new int[][] { { 1, 3, 5, 7 }, { 2, 4, 6, 8 } };
		int B = 10;
		int actual = solve(A, B);
		Assert.assertEquals(actual, -1);
	}

	@Test
	public void test03() {
		int[][] A = new int[][] { { 2, 8, 8, 8 }, { 2, 8, 8, 8 }, { 2, 8, 8, 8 } };
		int B = 8;
		int actual = solve(A, B);
		Assert.assertEquals(actual, 1011);
	}

	// Brute Force:
	// TC : O(N*M)
	// SC : O(1)
//	public int solve(int[][] A, int B) {
//		for(int i=0;i<A.length;i++) {
//			for(int j=0;j<A[i].length;j++) {
//				if(A[i][j]==B) {
//					i = i+1;
//					j= j+1;
//					System.out.println(((i*1009)+j));
//					return ((i*1009)+j);
//				}
//			}
//		}
//		return -1;
//	}
	// Optimized Approach
	// TC : O(N+M)
	// SC : O(1)
	public int solve(int[][] A, int B) {
		int i = 0, j = A[0].length - 1, M = A.length, sum = 0, ans = Integer.MAX_VALUE, m = 1, n = 1;
		boolean flag = false;
		while (i < M && j >= 0) {
			if (A[i][j] == B) {
				m = i + 1;
				n = j + 1;
				sum = ((m * 1009) + n);
				ans = Math.min(ans, sum);
				flag = true;
			}
			// This below else if condition will leads to time limit exceeded error due to
			// this test data
			// {{2,3,6,7},{2,3,4,5}} (i.e., for the 2th element, it comes twice, so that the
			// below logic will not work)
			// else if (A[i][j] < B) {
			// i++;
			// } else {
			// j--;
			// }
			if (A[i][j] >= B) {
				j -= 1;
			} else {
				i += 1;
			}
		}
		if (flag) {
			return ans;
		}
		return -1;
	}
}
