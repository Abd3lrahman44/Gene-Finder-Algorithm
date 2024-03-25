
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {

    public boolean twoOccurrences(String stringa, String stringb){
        int count = 0; // number of occurences in stringb
        int lastIndex = 0; // stopping condition + index to start looking from
        boolean found = false;
        
        while(lastIndex != -1){
            lastIndex = stringb.indexOf(stringa, lastIndex);
            
            if(lastIndex == -1){ // stringa not in stringb
                break;
            }
            else{ // stringa is in string b
                count = count + 1; // counting number of occurences
            }
            if(count >= 2){ // number of occurences is 2 or more
                found = true;
                break;
            }
        }
        return found;
}

    public String lastPart(String sub, String string){
        int lengthOfSub = sub.length(); 
        int start = string.indexOf(sub); // beginning index of substring in string
        String result = "";
        if(start == -1){ // does not exist in string
            result = string;
        }
        else{ // exists
            result = string.substring(start + lengthOfSub);
            // new substring of remaining letters without first "sub"
        }
        return result;
    }

    public void testing(){
        String A = "a";
        String B = "abdulrahman";
        System.out.println("String A: " + A);    
        System.out.println("String B: " + B); 
        System.out.println(twoOccurrences(A,B));
        System.out.println("The part of string after '"+ A + "' in '" + B + "' is '" + lastPart(A,B) + "'");
        System.out.println();
        
        String C = "by";
        String D = "a book by abby";
        System.out.println("String A: " + C);    
        System.out.println("String B: " + D); 
        System.out.println(twoOccurrences(C,D));
        System.out.println("The part of string after '"+ C + "' in '" + D + "' is '" + lastPart(C,D) + "'");
        System.out.println();
        
        String E = "not";
        String F = "my fault";
        System.out.println("String A: " + E);    
        System.out.println("String B: " + F); 
        System.out.println(twoOccurrences(E,F));
        System.out.println("The part of string after '"+ E + "' in '" + F + "' is '" + lastPart(E,F) + "'");
        System.out.println();
    }
}