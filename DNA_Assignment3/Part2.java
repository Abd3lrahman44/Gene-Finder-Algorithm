public class Part2 {
    public double cgRatio(String dna){
        int cgCount = 0;
        int length = dna.length();
        
        for(int i=0; i < length; i++){
            char currentChar = dna.charAt(i);
            if(currentChar == 'C' || currentChar == 'G'){
                cgCount++;
            }
        }
        
        return (double) cgCount / length;
    }
    
    public void testCgRatio(){
        String DNA = "AGCCGGATG";
        String DNA2 = "AGAC";
        String DNA3 = "AGGA";
        String DNA4 = "GAAG";
        String DAN5 = "TAAT";
        System.out.println(cgRatio(DNA));
    }
    
    public int ctgCount(String dna){
        int count = 0;
        int startIndex = 0;
        
        while(true){
            
            if(dna.indexOf("CTG",startIndex) == -1){
                break;
            }
            count++;
            startIndex = dna.indexOf("CTG",startIndex) + 3;
        }
        
        return count;
    }
    
    public void test(){
        String dna = "ATGCTGCTGAGT"; //2
        String dna1 = "CTGCTGCTGCTGCTG"; //5
        String dna2 = "ATGTAATGATGAATG"; //0
        System.out.println(ctgCount(dna2));
    }
}
