class Solution {
    public int maximumGain(String s, int x, int y) {
        StringBuilder sb = new StringBuilder(); 
        int total = 0 ; 
           if(x>y){
            for(int i = 0 ; i<s.length() ;i++){
                sb.append(s.charAt(i)) ;
             if (sb.length() >= 2 && sb.charAt(sb.length() - 2) == 'a' && sb.charAt(sb.length() - 1) == 'b') {
    // Remove last 2 characters ("ab")
    sb.delete(sb.length() - 2, sb.length());
    total+=x ; 
}
           }
           String a = sb.toString();
           sb.setLength(0);
           for(int i = 0 ;i<a.length();i++ ){
            sb.append(a.charAt(i)) ; 
            if (sb.length() >= 2 && sb.charAt(sb.length() - 2) == 'b' && sb.charAt(sb.length() - 1) == 'a') {
    // Remove last 2 characters ("ba")
    sb.delete(sb.length() - 2, sb.length());
    total+=y ; 
}
           }
        }
        else{
            for(int i = 0 ;i<s.length();i++ ){
            sb.append(s.charAt(i)) ; 
            if (sb.length() >= 2 && sb.charAt(sb.length() - 2) == 'b' && sb.charAt(sb.length() - 1) == 'a') {
    // Remove last 2 characters ("ba")
    sb.delete(sb.length() - 2, sb.length());
    total+=y ; 
}
           }
            String a = sb.toString();
           sb.setLength(0);
           for(int i = 0 ;i<a.length();i++ ){
            sb.append(a.charAt(i)) ; 
            if (sb.length() >= 2 && sb.charAt(sb.length() - 2) == 'a' && sb.charAt(sb.length() - 1) == 'b') {
    // Remove last 2 characters ("ba")
    sb.delete(sb.length() - 2, sb.length());
    total+=x ; 
}

        }
        }
        return total ;
    }
}