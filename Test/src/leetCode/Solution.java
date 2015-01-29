package leetcode;

/**
 * problem:Given two sorted arrays A and B ,merge B into A as one sorted array
 * 
 * @author lason This is my solution other solution :
 * 
 *         public class Solution { public void merge(int A[], int m, int B[],
 *         int n) { while(m>0 && n>0) A[m+n-1] = A[m-1] > B[n-1] ? A[--m] :
 *         B[--n]; while(n>0) A[n-1] = B[--n]; } } This way is very nice. test
 *         for github for eclipse
 */
public class Solution {
	public void merge(int A[], int m, int B[], int n) {
		int C[] = new int[m];
		for (int i = 0; i < m; i++)
			C[i] = A[i];
		int i = 0, j = 0, k = 0;

		while (i < m && j < n) {
			if (C[i] < B[j]) {
				A[k] = C[i];
				i++;
			} else {
				A[k] = B[j];
				j++;
			}
			k++;
		}

		while (i < m) {
			A[k] = C[i];
			i++;
			k++;
		}

		while (j < n) {
			A[k] = B[j];
			j++;
			k++;
		}
	}

	
	public boolean isMatch(String a, String b) {
		char tempA, tempB;
		int lena, lenb, insteadOfNumber, bLoc = 0;
		lena = a.length();
		lenb = b.length();
		insteadOfNumber = lena - lenb;
		if (a.equals(b))
			return true;
		for (int i = 0; i < lena; i++) {
			tempA = a.charAt(i);
			tempB = b.charAt(bLoc);

			if (tempB != '*' && tempB != '?') {
				if (tempA == tempB) {
					bLoc++;
					continue;
				} else
					return false;
			} else {
				if (tempB == '?') {
					bLoc++;
				}
				if (tempB == '*') 
				{
					i = i + insteadOfNumber;
					bLoc++;
				}
			}

		}
		return true;
	}

	boolean compare(String str, String pattern) {
		int s = 0, p = 0, match = 0, starIdx = -1;
		while (s < str.length()) {
			// advancing both pointers
			if (p < pattern.length()
					&& (pattern.charAt(p) == '?' || str.charAt(s) == pattern
							.charAt(p))) {
				s++;
				p++;
			}
			// * found, only advancing pattern pointer
			else if (p < pattern.length() && pattern.charAt(p) == '*') {
				starIdx = p;
				match = s;
				p++;
			}
			// last pattern pointer was *, advancing string pointer
			
			else if (starIdx != -1) {
				p = starIdx + 1;
				match++;
				s = match;
			}
			// current pattern pointer is not star, last patter pointer was not
			// *
			// characters do not match
			else
				return false;
		}
		// check for remaining characters in pattern 
		// 
		while (p < pattern.length() && pattern.charAt(p) == '*')
			p++;

		return p == pattern.length();
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		int[] A = { 1, 4, 5, 8, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int[] B = { 2, 4, 5, 6, 8, 9, 54, 65 };
		test.merge(A, 5, B, B.length);
		for (int i = 0; i < 5 + B.length; i++)
			System.out.println(A[i]);
		String a = "abcdedfgh";
		String b = "abc*de*h";
		System.out.println(test.isMatch(a, b));
		System.out.println(test.compare(a, b));
		// System.out.println(test.compare(a, b));
	}
}