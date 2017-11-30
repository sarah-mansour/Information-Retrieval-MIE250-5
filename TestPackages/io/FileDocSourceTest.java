/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

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
public class FileDocSourceTest {
    
    public FileDocSourceTest() {
    }

    /**
     * Test of getNumDocs method, of class FileDocSource.
     */
    @Test
    public void testGetNumDocs() {
        System.out.println("getNumDocs");
        
        FileDocSource tester = new FileDocSource("NSF_Abstracts/Part1/awards_1992/awd_1992_00");
        soln.io.FileDocSource tester2 = new soln.io.FileDocSource("NSF_Abstracts/Part1/awards_1992/awd_1992_00");
        
        int expResult = tester2.getNumDocs();
        int result = tester.getNumDocs();
        assertEquals(expResult, result);
    }

    
}
