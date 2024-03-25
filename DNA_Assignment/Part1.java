
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene(String DNA) {
        String result = "";
        int startIndex = DNA.indexOf("ATG");
        if (startIndex == -1){
            return "No Gene Found";
        }
        int endIndex = DNA.indexOf("TAA", startIndex);
        if(endIndex == -1){
            return "No Gene Found";
        }
        result = DNA.substring(startIndex, endIndex + 3);
        if (result.length() % 3 == 0){
            return result;
        }
        else{
         return "No Gene Found";   
        }
    }
    
    public void testSimpleGene(){
        String DNA_strand1 = "ACATGCGGATACACTTATAACGFGAAT"; // DNA test with ATG and TAA is divis by 3
        System.out.println("DNA: " + DNA_strand1);
        System.out.println("Gene: " + findSimpleGene(DNA_strand1));
        System.out.println();
        
        String DNA_strand2 = "ATGCGGATT"; // DNA test with ATG and no TAA
        System.out.println("DNA: " + DNA_strand2);
        System.out.println("Gene: " + findSimpleGene(DNA_strand2));
        System.out.println();
        
        String DNA_strand3 = "CGTTGCTAA"; // DNA test with no ATG
        System.out.println("DNA: " + DNA_strand3);
        System.out.println("Gene: " + findSimpleGene(DNA_strand3));
        System.out.println();
        
        String DNA_strand4 = "CGTAGTCAAGGCGTA"; // DNA test with no ATG no TAA
        System.out.println("DNA: " + DNA_strand4);
        System.out.println("Gene: " + findSimpleGene(DNA_strand4));
        System.out.println();
        
        String DNA_strand5 = "ATGGTTGATAA"; // DNA test with ATG and TAA not divis by 3
        System.out.println("DNA: " + DNA_strand5);
        System.out.println("Gene: " + findSimpleGene(DNA_strand5));
        System.out.println();
    }
}
