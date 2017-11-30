/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenizer;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author zhan3312
 */
public class IndexingTokenizer implements Tokenizer{
    
    /** document tokenized into individual terms, lowercasing all tokens, and 
     * preserving hyphenated words as single words
     * 
     * @param s
     * @return ret ArrayList of strings
     */
    @Override
    public ArrayList<String> tokenize(String s){
        
            ArrayList<String> ret = new ArrayList<String>();
            
            //seperate the words but preserve ones with whitespaces
            Pattern p = Pattern.compile("[\\w-']+");
            Matcher m = p.matcher(s);
            //find the words and lowercase all the chars
            while (m.find()) {
                ret.add(m.group().toLowerCase());
            }
            return ret;
    }
    
}
