
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    
    
    public String findSimpleGene(String DNA, String startCodon, String endCodon){
        String result = "";
        if(DNA.toUpperCase() == DNA) { // DNA string is uppercase
            
            if(DNA.indexOf(startCodon) == -1){ // ATG is not present in string
                return "No Gene Found";
            }
        
            if(DNA.indexOf(endCodon) == -1){ // TAA is not present in string
                return "No Gene Found";
            }
        
            int start = DNA.indexOf(startCodon); 
        
            int end = DNA.indexOf(endCodon);
        
            result = DNA.substring(start, end + 3); // Gets gene from string
        
            if (result.length() % 3 == 0){ // Check gene codon number
        
                return result.toUpperCase(); 
            
            }
            else{
                
                return "No Gene Found";   
            
            }    
        }
        else if(DNA.toLowerCase() == DNA){
            
            if(DNA.indexOf(startCodon) == -1){ // ATG is not present in string
                return "No Gene Found";
            }
        
            if(DNA.indexOf(endCodon) == -1){ // TAA is not present in string
                return "No Gene Found";
            }
        
            int start = DNA.indexOf(startCodon); 
        
            int end = DNA.indexOf(endCodon);
        
            result = DNA.substring(start, end + 3); // Gets gene from string
        
            if (result.length() % 3 == 0){ // Check gene codon number
        
                return result.toLowerCase(); 
            
            }
            else{
                
                return "No Gene Found";   
            
            } 
        }
        else{
            System.out.println("Please make sure all charcters are either capital or small letters not both");
        }
        return result;
    }
    
    
    public void testSimpleGene(){
        String DNA_strand1 = "AAATGCCCTAACTAGATTAAGAAACC"; // DNA test with ATG and TAA is divis by 3
        System.out.println("DNA: " + DNA_strand1);
        System.out.println("Gene: " + findSimpleGene(DNA_strand1, "ATG", "TAA"));
        System.out.println();
        
        String DNA_strand2 = "gatgctataat"; // DNA test with ATG and no TAA
        System.out.println("DNA: " + DNA_strand2);
        System.out.println("Gene: " + findSimpleGene(DNA_strand2, "atg", "taa"));
        System.out.println();
        
        String DNA_strand3 = "CGTTGCTAA"; // DNA test with no ATG
        System.out.println("DNA: " + DNA_strand3);
        System.out.println("Gene: " + findSimpleGene(DNA_strand3, "ATG", "TAA"));
        System.out.println();
        
        String DNA_strand4 = "CGTAGTCAAGGCGTA"; // DNA test with no ATG no TAA
        System.out.println("DNA: " + DNA_strand4);
        System.out.println("Gene: " + findSimpleGene(DNA_strand4, "ATG", "TAA"));
        System.out.println();
        
        String DNA_strand5 = "ATGgTTGATAA"; // DNA test with ATG and TAA not divis by 3
        System.out.println("DNA: " + DNA_strand5);
        System.out.println("Gene: " + findSimpleGene(DNA_strand5, "ATG", "TAA"));
        System.out.println();
    }
    
    
}
