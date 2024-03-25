public class Part2 {
    public int howMany(String a, String b){
        int count = 0;
        int startIndex = b.indexOf(a);
        
        if(startIndex == -1) {
            return 0;   
        }
        while(true){
            if(startIndex != -1){ 
                count = count + 1;
                startIndex = b.indexOf(a, startIndex + a.length());
            }
            else{
                break;
            }
        }
        return count;
    }
    
    public void testHowMany(){
        String test1 = "A";
        String test2 = "AABADFAABABAA";
        System.out.println("String A: "+ test1);
        System.out.println("String B: "+ test2);
        System.out.println("String A is included " + howMany(test1, test2) + " times in String B. ");
        // Correct Eval is 8.
        System.out.println();
        
        String test3 = "ABC";
        String test4 = "ABCABCDABCS";
        System.out.println("String A: "+ test3);
        System.out.println("String B: "+ test4);
        System.out.println("String A is included " + howMany(test3, test4) + " times in String B. ");
        // Correct Eval is 3.
        System.out.println();
        
        String test5 = "A";
        String test6 = "FREDRICK JHONSON";
        System.out.println("String A: "+ test5);
        System.out.println("String B: "+ test6);
        System.out.println("String A is included " + howMany(test5, test6) + " times in String B. ");
        // Correct Eval is 0.
        System.out.println();
    }
}
