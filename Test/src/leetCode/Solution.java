package leetCode;
/**
 * problem:Given two sorted arrays A and B ,merge  B into A as one sorted array 
 * @author  lason
 *This is my solution 
 *other solution :
   
   public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        while(m>0 && n>0)
            A[m+n-1] = A[m-1] > B[n-1] ? A[--m] : B[--n];
        while(n>0)
            A[n-1] = B[--n];
    }
}
This way is very nice.  test for github for eclipse
 */
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int  C []=new int[m];
        for(int i=0;i<m;i++)
        	C[i]=A[i];
        int i=0,j=0,k=0;
       
        while(i<m && j<n){
        	if(C[i]<B[j]){
        		A[k]=C[i];
        		i++;
        	}
        	else{
        		A[k]=B[j];
        		j++;
        		}
        	k++;
        }
       
       while(i<m){
    	   A[k]=C[i];
    	   i++;
    	   k++;
       }
      
      while(j<n){
    		 A[k]=B[j];
    		 j++;
    		 k++;
    	 }
    }

    public static void main(String[] args) {
    	Solution test=new Solution();
		int A[]={1,4,5,8,11,0,0,0,0,0,0,0,0,0,0,0,0};
		int B[]={2,4,5,6,8,9,54,65};
		test.merge(A,5,B,B.length);
		for(int i=0;i<5+B.length;i++)
			System.out.println(A[i]);
	}
}