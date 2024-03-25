import edu.duke.StorageResource;
import edu.duke.FileResource;
import edu.duke.URLResource;
public class Part3 {
    
    
    public int findStopCodon(String dna, int startIndex, String stopCodon){
            int currIndex = dna.indexOf(stopCodon, startIndex +3);
            while(currIndex != -1){
                int diff = currIndex - startIndex;
                if (diff % 3 == 0){
                    return currIndex;
                }
                else{
                    currIndex = dna.indexOf(stopCodon, currIndex +1);
                }
            }
        return dna.length();
    }
    
    
    public String findGene(String dna, int start){
        int startIndex = dna.indexOf("ATG", start);
        if (startIndex == -1) return ""; //Dna has no ATG
        
        // Finding the nearest stop index TAA, TAG, TGA
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int minIndex = Math.min(taaIndex,Math.min(tagIndex, tgaIndex));
        
        // none were fonud
        if (minIndex == dna.length()) return "";
        
        //returns Gene + 3 to include the stopCodon
        return dna.substring(startIndex, minIndex +3); 
    }
    
    public String findGene2(String dna){
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) return ""; //Dna has no ATG
        
        // Finding the nearest stop index TAA, TAG, TGA
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int minIndex = Math.min(taaIndex,Math.min(tagIndex, tgaIndex));
        
        // none were fonud
        if (minIndex == dna.length()) return "";
        
        //returns Gene + 3 to include the stopCodon
        return dna.substring(startIndex, minIndex +3); 
    }
    
    
    public StorageResource getAllGenes(String dna) { // returns a list of genes found in DNA strand.
        int startIndex = 0;
        StorageResource geneList = new StorageResource();
        
        while (true) {
            String currentGene = findGene(dna, startIndex);
            
            if (currentGene.isEmpty()) { // No valid gene found
                break;
            } 
            geneList.add(currentGene);// add to list of genes
            startIndex = dna.indexOf(currentGene, startIndex) // update startIndex
                        + currentGene.length();
        }
        
        return geneList; 
    }
    
    
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
    
     public int countGenes(String dna){
        int geneCount = 0;
        int startIndex = 0;
        
        while(true){
            String currentGene = findGene2(dna.substring(startIndex));
            
            if(currentGene.isEmpty()){
                break;
            }
            
            geneCount++;
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        return geneCount;
    }
    
    public void processGenes(StorageResource sr){
        int Count = 0;
        int Count2 = 0;
        int max = 0;
        int startIndex = 0;
        
        for(String s: sr.data()){
            double cgRatio = cgRatio(s);
            
            if(s.length() > max){
                max = s.length();
            }
            
            if(s.length() > 60){
                System.out.println("String: " +s);
                Count ++;
            }
            
            if(cgRatio > 0.35){
                System.out.println("cgRatio > 35% : "+s);
                Count2 ++;
            }
            
        }
        System.out.println("Number of strings with more than 60 chars are " + Count);
        System.out.println("Number of strings with more than 35% cgRatio are " + Count2);
        System.out.println("The longest gene length is " + max);
    }
    
    public void testProcessGenes(){
        FileResource fr = new FileResource("abc.txt");
        String dna = fr.asString().toUpperCase();
        StorageResource sr = getAllGenes(dna);
        
        processGenes(sr);
        System.out.println("CTG count: " + ctgCount(dna));
        System.out.println("Gene count: " + countGenes(dna));
    }
}
