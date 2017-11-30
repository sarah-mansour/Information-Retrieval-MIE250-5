/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package index;

import io.DocSource;
import io.FileDocSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
import score.TermScoringFun;
import tokenizer.Tokenizer;

/**
 *
 * @author zhan3312
 */
public class InvertedIndex extends Index{
    
    private HashMap<String, HashMap<Integer, Integer>> _index;
    private HashMap<String, Integer> _docFreq;

    public InvertedIndex(DocSource doc_source, Tokenizer tokenizer, TermScoringFun scoring) {
        super(doc_source, tokenizer, scoring);
        _index = new HashMap<>();
        _docFreq = new HashMap<>();
    }
    
    /** add terms to the index HashMap and the number of times yeah term appears in 
     * each document
     * 
     */
    @Override
    public void buildIndex() {
        for(int i = 0; i < _docSource.getNumDocs(); i++){
            ArrayList<String> terms = _tokenizer.tokenize(_docSource.getDoc(i));
            for(String term: terms){
                if(_index.containsKey(term)){ //check if index contains term 
                    if (_index.get(term).containsKey(i)){ //increment current term frequency by one
                        _index.get(term).put(i, 1 + _index.get(term).get(i));
                    }
                    else{
                        _index.get(term).put(i, 1); //first term appearance in document
                    }
                }
                else{
                    _index.put(term, new HashMap< Integer, Integer>());//add the term to index
                    _index.get(term).put(i, 1); //first instance, document freq is 0
                    _docFreq.put(term, 0); // new term, add to docFreq terms
                }
            }
        }
        for(String t: _docFreq.keySet()){
            _docFreq.put(t, _index.get(t).size());// size of the term -> HM is the number of 
                                                  // docIDs that contain the term
        }
    }
    
    /** determine number of documents the term appears in
     * 
     * @param term
     * @return docFreq
     */
    @Override
    public int getDocumentFreq(String term) {
        return _docFreq.get(term);
    }
    
    /**create a list of documents with matching terms as query, ordered from
     * greatest to least score defined by scoring function
     * 
     * @param query
     * @return sortedDocsAL
     */
    @Override
    public ArrayList<DocScore> getSortedSearchResults(String query) {
        ArrayList<String> queryTerms = _tokenizer.tokenize(query);
        //mapping document ID to its current score, from _scoring member
        HashMap<Integer, Double> docScores = new HashMap<Integer, Double>(); 
        //sorted set of all matching documents and their non-zero scores
        TreeSet<SortedDocScore> sortedDocs = new TreeSet<SortedDocScore>();
        
        for(String term: queryTerms){
            if(_index.containsKey(term)){ //check if term is found in index
                for(int id : _index.get(term).keySet()){ //iterate through every document containing term
                    //calculate score awarded to this document id for term
                    double plusScore = _scoring.scoreToken(term, _index.get(term).get(id));
                    
                    if(docScores.containsKey(id)) // add to existing score if id found 
                        docScores.put(id, docScores.get(id) + plusScore);
                    else //if id is new, initialize score to id
                        docScores.put(id, plusScore);
                }  
            }   
        }
        
        //create sortedDocs set of DocScores (containing doc score, id, content) 
        //of all documents in docScores
        for(int id: docScores.keySet()){
            sortedDocs.add(new SortedDocScore(docScores.get(id), id, _docSource.getDoc(id)));
        }
        
        //convert sortedDocs back to ArrayList and return
        ArrayList<DocScore> sortedDocsAL = new ArrayList<DocScore> (sortedDocs);
        return sortedDocsAL;
    }
    
}
