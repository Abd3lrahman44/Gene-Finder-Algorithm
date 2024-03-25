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
    
    
    public String findGene(String dna){
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
    
    
    public void printAllGenes(String dna) {
        int startIndex = 0;
        
        while(true){
            String currentGene = findGene(dna.substring(startIndex));
            
            if(currentGene.isEmpty()){
                break;
            }
            
            System.out.println(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
    }
    
    
    public int countGenes(String dna){
        int geneCount = 0;
        int startIndex = 0;
        
        while(true){
            String currentGene = findGene(dna.substring(startIndex));
            
            if(currentGene.isEmpty()){
                break;
            }
            
            geneCount++;
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        return geneCount;
    }
    
    
    public void testCountGenes(){
        String A = "ATGTAG"; // 1 Gene
        System.out.println("DNA: " + A);
        System.out.println("Number of genes: " + countGenes(A));
        
        String B = "ATGTAGATGTAA"; // 2 Genes
        System.out.println("DNA: " + B);
        System.out.println("Number of genes: " + countGenes(B));
        
        String C = "ATGTAGATGTAAATGTGA"; // 3 Genes
        System.out.println("DNA: " + C);
        System.out.println("Number of genes: " + countGenes(C));
        
        String D = "ATGTAGATGTAAATGTGAATGTAA"; // 4 Genes
        System.out.println("DNA: " + D);
        System.out.println("Number of genes: " + countGenes(D));
        
        String E = "ATGTAGATGTAAATGTGAATGTAAATGTAG"; // 5 Genes
        System.out.println("DNA: " + E);
        System.out.println("Number of genes: " + countGenes(E));

    }
}

