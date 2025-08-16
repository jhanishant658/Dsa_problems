class Solution {
    public int maximum69Number (int num) {
        String val = String.valueOf(num);
        StringBuilder sb = new StringBuilder(val);
        for(int i=0 ;i<val.length();i++){
            if(val.charAt(i)=='6'){ 
               sb.setCharAt(i ,'9') ;
                   break ; 
                    }

        }
        return Integer.parseInt(sb.toString());

    }
}