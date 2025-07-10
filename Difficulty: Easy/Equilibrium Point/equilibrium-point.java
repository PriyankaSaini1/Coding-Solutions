class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        
// to rember : T-L-A = R
// Think of the problem as a balance scale:
// LeftSum  +  arr[i] (Actual element) +  RightSum  = Total
//              ↑
//          current index
// So,
// RightSum = TotalSum - LeftSum - arr[i]

// To find the equilibrium point:
// LeftSum == RightSum


        // code here
            int n=arr.length;
       int totSum=0; 
        for(int e: arr){
            totSum+=e;
        }
        
        int lsum=0;
        int rsum=0;
        for(int i=0; i<n; i++){
            
            
            
            rsum= totSum -lsum-arr[i] ;
            
            
            
            if(lsum==rsum){
                return i;
            }
            lsum= lsum+arr[i];
            
        }
        
        
        
        
       return -1; 
    }
}
