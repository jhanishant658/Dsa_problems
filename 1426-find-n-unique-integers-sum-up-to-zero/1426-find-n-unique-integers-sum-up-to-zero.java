class Solution {
    public int[] sumZero(int n) {
        int [] arr = new int[n] ; 
            int i=0 ;
            int a=n/2; 
        if(n%2==0){
          
            while(i<n){
                arr[i]=a;
                i++;
                arr[i]= -1*a ;
                i++;
                a--;
            }
           
        }
        else{
           while(i<n){
            if(a==0){
                arr[i]=a ;
                break ; 
            }
            arr[i]=a;
            i++;
            arr[i]=-1*a;
            i++;
            a--;
           } 
        }
         return arr ; 
    }
}