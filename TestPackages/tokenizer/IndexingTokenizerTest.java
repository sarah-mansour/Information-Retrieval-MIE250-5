/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenizer;

import java.util.ArrayList;
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
public class IndexingTokenizerTest {
    
    public IndexingTokenizerTest() {
    }

    /**
     * Test of tokenize method, of class IndexingTokenizer.
     */
    @Test
    public void testTokenize() {
        System.out.println("tokenize term");
        String s = "tree";
        
        IndexingTokenizer myTest = new IndexingTokenizer();
        soln.tokenizer.IndexingTokenizer solTest = new soln.tokenizer.IndexingTokenizer();
        
        ArrayList<String> expResult = solTest.tokenize(s);
        ArrayList<String> result = myTest.tokenize(s);
        assertEquals(expResult, result);

    }
    
    /**
     * Test of tokenize method of multiple words (some uppercase) with numbers, 
     * of class IndexingTokenizer.
     */
    @Test
    public void testTokenizeMultiple() {
        System.out.println("tokenize multiple terms");
        String s = "tREe 23";
        
        IndexingTokenizer myTest = new IndexingTokenizer();
        soln.tokenizer.IndexingTokenizer solTest = new soln.tokenizer.IndexingTokenizer();
        
        ArrayList<String> expResult = solTest.tokenize(s);
        ArrayList<String> result = myTest.tokenize(s);
        assertEquals(expResult, result);

    }
    
    /**
     * Test of tokenize method with hyphenated term
     * of class IndexingTokenizer.
     */
    @Test
    public void testTokenizeHyphens() {
        System.out.println("tokenize hyphenated word");
        String s = "long-term";
        
        IndexingTokenizer myTest = new IndexingTokenizer();
        soln.tokenizer.IndexingTokenizer solTest = new soln.tokenizer.IndexingTokenizer();
        
        ArrayList<String> expResult = solTest.tokenize(s);
        ArrayList<String> result = myTest.tokenize(s);
        assertEquals(expResult, result);

    }
}
