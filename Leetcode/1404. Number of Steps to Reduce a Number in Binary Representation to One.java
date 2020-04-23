class Solution {
    public int numSteps(String s) {
        int res = 0;
        // Maximum length of s is 500 so we can not use binary to long or long to binary
        
        while (!s.equals("1")) {
            // If last char of string is 0, this string is even
            if (s.charAt(s.length() - 1) == '0') {
                s = s.substring(0, s.length() - 1);
                // System.out.println("Even: " + s);
            } else {
                s = addByOne(s);
                // System.out.println("Odd: " + s);
            }
            
            res++;
        }
        
        return res;
    }
    
    private static String addByOne(String s) {          
        StringBuilder sb = new StringBuilder();         
        int carry = 1;                                  

        for (int i = s.length() - 1; i >= 0; i--) {     
            int curr = carry;                           
            curr += s.charAt(i) - '0';                  
            sb.append("" + curr % 2);                   
            carry = (curr / 2) > 0 ? 1 : 0;             
        }                                               

        if (carry == 1) {                               
            sb.append(carry);                           
        }                                               
                                                    
        return sb.reverse().toString();                 
    }                                                   
}
