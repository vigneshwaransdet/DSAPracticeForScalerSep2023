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

public class Day12_Q1_SearchInARowWiseAndColumnWiseSortedMatrix {
	
	@Test
	public void test01() {
		int[][] A = new int[][] {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
		int B = 2;
		int actual = solve(A, B);
		Assert.assertEquals(actual, 1011);
	}
	
	public int solve(int[][] A, int B) {
		for(int i=0;i<A.length;i++) {
			for(int j=0;j<A[i].length;j++) {
				if(A[i][j]==B) {
					i = i+1;
					j= j+1;
					System.out.println(((i*1009)+j));
					return ((i*1009)+j);
				}
			}
		}
		return -1;
	}
}
