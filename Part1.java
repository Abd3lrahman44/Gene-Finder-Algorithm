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

        while (true) {
            startIndex = findStartCodon(dna, startIndex);

            if (startIndex == -1) { // No start codon found
                break;
            }

            int endIndex = findStopCodon(dna, startIndex + 3, "TAA");

            if (endIndex != dna.length()) { // A valid gene is found
                System.out.println(dna.substring(startIndex, endIndex + 3));
                startIndex = endIndex + 3; // Move past this gene
            } else {
                // No valid stop codon found after this start codon, move to the next possible start codon
                startIndex += 3;
            }
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
        System.out.println("GENE: " + findGene(dna_strand1));
        
        //DNA with start codon and end codons (TAA)
        //                       |||      |||
        String dna_strand2 = "CGAATGAGAGTTTAATCGA";
        System.out.println("DNA STRAND: " + dna_strand2);
        System.out.println("GENE: " + findGene(dna_strand2));
        
        //DNA with start codon and end codons (TAA, TAG)
        //                       ||||||   |||
        String dna_strand3 = "CGAATGTAAGTGTAG";
        System.out.println("DNA STRAND: " + dna_strand3);
        System.out.println("GENE: " + findGene(dna_strand3));
        
        //DNA with start codon and no end codons
        //                       |||
        String dna_strand4 = "CGAATGAGAGTGATT";
        System.out.println("DNA STRAND: " + dna_strand4);
        System.out.println("GENE: " + findGene(dna_strand4));
    
        //DNA with start codon and no valid end codons
        //                       |||    ||| *NOT VALID
        String dna_strand5 = "CGAATGAGAGTGATT";
        System.out.println("DNA STRAND: " + dna_strand5);
        System.out.println("GENE: " + findGene(dna_strand5));
        
        //System.out.println("THIS IS THE PRINT ALL GENES METHOD---");
        //printAllGenes("ATGTAAAGTGTAATG");
    }
}
