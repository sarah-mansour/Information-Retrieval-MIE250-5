/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package score;

import index.Index;

/**
 *
 * @author zhan3312
 */
public class TFIDFScoringFun implements TermScoringFun {
    
    Index _ind;
    
    /**documents indexed at index address from parameter, this initializes the index
     * here so the scoring function knows where to call index
     * 
     * @param s 
     */
    @Override
    public void init(Index s) {
        _ind = s;
    }
    
    /**scoring function using TFIDF = log10(1+TF)*log10(n/DF)
     * where TF is the frequency of the term in the document, DF is the document 
     * frequency for the term, n is the number of documents
     * 
     * @param term
     * @param freq
     * @return score
     */
    @Override
    public double scoreToken(String term, int freq) {
        double n = (double) _ind.getDocSource().getNumDocs();
        double DF = (double) _ind.getDocumentFreq(term);
        
        return Math.log10(1 + freq) * Math.log10(n/DF);
    }
    
}
