/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import static io.FileFinder.GetAllFiles;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zhan3312
 */
public class FileDocSource extends DocSource{
    
    public ArrayList<File> _documents;
    
    /** load all files from a directory name provided in the constructor as a
     * String, stores an array of all filenames
     * 
     * @param src string
     */
    public FileDocSource(String src) {
        _documents = new ArrayList<File>();
        for(File f : GetAllFiles(src)){
            _documents.add(f);
        }    
    }
    
    /** get the number of documents
     * 
     * @return _documents.size()
     */
    @Override
    public int getNumDocs(){
        return _documents.size();
    }
    
    /** get the String file located at a specific index
     * 
     * @param id
     * @return docString
     */
    @Override
    public String getDoc(int id){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            //read a stream of character input
            br = new BufferedReader(new FileReader((_documents.get(id))));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileDocSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        //read file from buffered reader, create stream of lines and convert to array
        Object[] array = br.lines().toArray();
        //build a string from the array
        StringBuilder sb = new StringBuilder();
        for(Object s: array){
            sb.append(s);
        }
        String docString = sb.toString();
        return docString;
    }
}
