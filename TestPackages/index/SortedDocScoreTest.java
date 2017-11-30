/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package index;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zhan3312
 */
public class SortedDocScoreTest {
    
    public SortedDocScoreTest() {
    }

    /**
     * Test of compareTo method, of class SortedDocScore.
     */
    @Test
    public void testCompareToScoreDiff() {
        System.out.println("compareTo by score");
        
        SortedDocScore myTest = new SortedDocScore(34, 10, "computer");

        SortedDocScore compareTest = new SortedDocScore(31, 3, "cat");
        
        //sorted doc scores are different, rank by score
        int expResult = -1;
        int result = myTest.compareTo(compareTest);
        assertEquals(expResult, result); 
    }
    
    /**
     * Test of compareTo method, of class SortedDocScore.
     */
    @Test
    public void testCompareToScoreSame() {
        System.out.println("compareTo by alphabet");
        
        SortedDocScore myTest = new SortedDocScore(34, 10, "computer"); 
        SortedDocScore compareTest = new SortedDocScore(34, 3, "cat");
        
        //sorted doc scores are different, rank content alphabetically
        boolean goesAfter = (myTest.compareTo(compareTest) > 0) ? true : false;

        assertTrue(goesAfter); 
    }
}
