package com.mycode;

public class NumberWords {

	public String toWords( int number ) {
		String result = "" ;
		int i = 0;
	    /* Base cases */
		String num = String.valueOf(number);
		int len = num.length();
		if(number<0) {
			result = "Number out of range";
			return result;
		}
	    if (len > 4) { 
	        result = "Length more than 4 is not supported"; 
	        return result; 
	    } 
	  
	    /* The first string is not used, it is to make array indexing simple */
	    String single_digits[] = { "" , "one", "two", "three", "four", 
	                              "five", "six", "seven", "eight", "nine"}; 
	  
	    /* The first string is not used, it is to make array indexing simple */
	    String two_digits[] = {"", "ten", "eleven", "twelve", "thirteen", "fourteen", 
	                     "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"}; 
	  
	    /* The first two string are not used, they are to make array indexing simple*/
	    String tens_multiple[] = {"", "", "twenty", "thirty", "forty", "fifty", 
	                             "sixty", "seventy", "eighty", "ninety"}; 
	  
	    String tens_power[] = {"hundred", "thousand"}; 
	  
	    /* For single digit number */
	    if (len == 1) { 
	    	if(num.charAt(i)-'0' == 0) {
	    		result = "End of Program";
	    		return result;
	    	}
	    	else {
	    		result = single_digits[num.charAt(i) - '0']; 
		        return result; 
	    	}  
	    } 
	  
	     /* Iterate while num is not '\0' */
	     while (i!=num.length()) { 
	  
	        /* Code path for first 2 digits */
	        if (len >= 3) { 
	            if (num.charAt(i) -'0' != 0) { 
	                result = result.concat(single_digits[num.charAt(i) - '0']+" "); 
	                result = result.concat(tens_power[len-3]+" "); // here len can be 3 or 4 
	            } 
	            --len; 
	        } 
	  
	        /* Code path for last 2 digits */
	        else { 
	            /* Need to explicitly handle 10-19. Sum of the two digits is 
	               used as index of "two_digits" array of strings */
	            if (num.charAt(i) == '1') { 
	                int sum = num.charAt(i) - '0' + num.charAt(i+1) - '0'; 
	                result = result.concat(two_digits[sum]); 
	                return result; 
	            } 
	  
	            /* Need to explicitely handle 20 */
	            else if (num.charAt(i) == '2' && num.charAt(i) == '0') { 
	                result = result.concat("twenty" +" ");
	                return result; 
	            } 
	  
	            /* Rest of the two digit numbers i.e., 21 to 99 */
	            else { 
	                int j = num.charAt(i) - '0'; 
	                result =  j>0 ? result.concat(tens_multiple[j] +" "): result.concat(""); 
	                i++; 
	                if (num.charAt(i) != '0') 
	                    result = result.concat(single_digits[num.charAt(i) - '0'] + " "); 
	            } 
	        } 
	        i++;
	    } 
		return result.trim() ;
	}

}
