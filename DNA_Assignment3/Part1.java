import edu.duke.StorageResource;

public class Part1 {
    
    public int findStartCodon(String dna, int startIndex) {
        return dna.indexOf("ATG", startIndex);
    }
    
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
    
    
    public void printAllGenes(String dna) { // returns a list of genes found in DNA strand.
        int startIndex = 0;
        
        while (true) {
            String currentGene = findGene(dna, startIndex);
            
            if (currentGene.isEmpty()) { // No valid gene found
                break;
            } 
            System.out.println("Gene: " + currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) // update startIndex
                        + currentGene.length();
        } 
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
    
    
    public void testgetAllGenes(){
        //            ATGTAA      ATGTAG    =  2 genes
        String DNA = "ATGTAATAGGTAATGTAG";
        StorageResource genes = getAllGenes(DNA);
        for(String gene : genes.data()){
            System.out.println("Gene: " + gene);            
        }
    }
    
    
    public void testFindStopCodon(){
        //            01234567890123456789012345
        String DNA = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
        int dex = findStopCodon(DNA,0,"TAA");
        if (dex != 9) System.out.println("error on 9");
        dex = findStopCodon(DNA,9,"TAA");
        if (dex != 21) System.out.println("error on 21");
        dex = findStopCodon(DNA,1,"TAA");
        if (dex != 26) System.out.println("error on 26");
        dex = findStopCodon(DNA,0,"TAG");
        if (dex != 26) System.out.println("error on 26 TAG");
        System.out.println("tests finished");
    }
    
    
    public void testFindGene(){
        //DNA with no start or end codon
        String dna_strand1 = "CGAGTGAGAGTGAAT";
        System.out.println("DNA STRAND: " + dna_strand1);
        System.out.println("GENE: " + findGene(dna_strand1,0));
        
        //DNA with start codon and end codons (TAA)
        //                       |||      |||
        String dna_strand2 = "CGAATGAGAGTTTAATCGA";
        System.out.println("DNA STRAND: " + dna_strand2);
        System.out.println("GENE: " + findGene(dna_strand2,0));
        
        //DNA with start codon and end codons (TAA, TAG)
        //                       ||||||   |||
        String dna_strand3 = "CGAATGTAAGTGTAG";
        System.out.println("DNA STRAND: " + dna_strand3);
        System.out.println("GENE: " + findGene(dna_strand3,0));
        
        //DNA with start codon and no end codons
        //                       |||
        String dna_strand4 = "CGAATGAGAGTGATT";
        System.out.println("DNA STRAND: " + dna_strand4);
        System.out.println("GENE: " + findGene(dna_strand4,0));
    
        //DNA with start codon and no valid end codons
        //                       |||    ||| *NOT VALID
        String dna_strand5 = "CGAATGAGAGTGATT";
        System.out.println("DNA STRAND: " + dna_strand5);
        System.out.println("GENE: " + findGene(dna_strand5,0));
        
        //System.out.println("THIS IS THE PRINT ALL GENES METHOD---");
        //printAllGenes("ATGTAAAGTGTAATG");
    }
}
