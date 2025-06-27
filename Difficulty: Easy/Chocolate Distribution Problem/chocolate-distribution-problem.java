// User function Template for Java

class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        // your code here
        Collections.sort(arr);
        int n=arr.size();
        // int result=0;
        int result= Integer.MAX_VALUE;
        // window =(total umber of elemts - m +1)
        
        for(int i=0; i< n-m+1 ;i++){
            
            int minElement=arr.get(i);  //min value of the window
            int maxElement=arr.get(i+m-1); //max value of the window
            
            result= Math.min(result, maxElement-minElement);
            
        }
        return result;
    }
}