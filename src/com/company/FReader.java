package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//97-122
public class FReader {
    private Map<String,Integer> words;
    private Scanner scanner;

    public Map<String, Integer> getWords() {
        return words;
    }

    public FReader(String txt) throws FileNotFoundException {
        scanner = new Scanner(new FileReader(txt));
        words = new HashMap<>();
        readWords();
    }

    private void readWords(){
        boolean isWord = false;
        String word = "";
        while(scanner.hasNextLine()){
            char[] line = scanner.nextLine().toCharArray();
            for(char i:line){
                if(i>=97&&i<=122) {
                    isWord=true;
                    word+=i;
                    continue;
                }
                if(isWord){
                    addWord(word);
                    word="";
                    isWord=false;
                }
            }
        }
    }

    private void addWord(String word){
        if(word.length()>30) word=word.substring(0,30);
        if(words.containsKey(word)) words.put(word, words.get(word)+1);
        else words.put(word,1);
    }
}
