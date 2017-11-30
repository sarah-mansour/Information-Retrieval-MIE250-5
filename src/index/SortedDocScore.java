/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package index;

/**
 *
 * @author zhan3312
 */
public class SortedDocScore extends DocScore implements Comparable {

    public SortedDocScore(double score, int doc_id, String content) {
        super(score, doc_id, content);
    }

    /** override comparable so that the the document results are sorted in
     * a ranked order when used in a sorted set, from highest to lowest score
     * 
     * @param o
     * @return 
     */
    @Override
    public int compareTo(Object o) {
        if(o instanceof SortedDocScore){
            SortedDocScore doc = (SortedDocScore) o;
            if(this.getScore() < doc.getScore()) //when this score is smaller, place later
                return 1;
            else if(this.getScore() == doc.getScore()){ // score same, compare content
                //place this before if compare returns neg (this content is alphabetically earlier)
                //place this after if compare returns pos 
                //documents are same if the compare returns 0
                return this.getContent().compareTo(doc.getContent()); 
            }
            else // this score is greater, should be placed earlier
                return -1;
            
        }
        else
            return -1;
    }
    
}
