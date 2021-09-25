package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Commands {
    private Map<String,Integer> words;

    public Commands(Map<String, Integer> words, int command) {
        this.words = words;
        if(command>0&&command<14) findCommand(command);
        else System.out.println("Wrong Command");
    }

    private void findCommand(int command){
        switch (command){
            case 1: doFirstCommand(); break;
            case 2: doSecondCommand(); break;
            case 3: doThirdCommand(); break;
            case 4: doFourthCommand(); break;
            case 5: doFifthCommand(); break;
            case 6: doSixthCommand(); break;
            case 7: doSeventhCommand(); break;
            case 8: doEightsCommand(); break;
            case 9: doNinthCommand(); break;
            case 10: doTenthCommand(); break;
            case 11: doEleventhCommand(); break;
            case 12: doTwelfthCommand(); break;
        }
    }

    private void doFirstCommand(){
        for(var i:words.keySet()) if(i.length()==30) System.out.println(i);
    }

    private void doSecondCommand(){
        for(var i:words.entrySet()) System.out.println(i.getKey() + " " + i.getValue());
    }

    private void  doThirdCommand(){ //97 101 105 111 117 121
        for(var i:words.keySet()){
            boolean letters = true;
            for(var j:i.toCharArray()){
                if(!(j==97||j==101||j==105||j==111||j==117||j==121)) {
                    letters=false;
                    break;
                }
            }
            if(letters) System.out.println(i);
        }
    }

    private void doFourthCommand(){
        for(var i:words.keySet()){
            boolean letters = true;
            for(var j:i.toCharArray()){
                int count = 0;
                for(var q:i.toCharArray()){
                    if(q==j) count++;
                    if(count>1){
                        letters=false;
                        break;
                    }
                }
                if(!letters) break;;
            }
            if(letters) System.out.println(i);
        }
    }

    private void doFifthCommand(){
        for(var i:words.keySet()){
            int counnt = 0;
            for(var j:i.toCharArray()){
                if(j!=97&&j!=101&&j!=105&&j!=111&&j!=117&&j!=121) counnt++;
                else counnt=0;
                if(counnt>1){
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    private void doSixthCommand(){
        int max=0;
        List<String> result = new ArrayList<>();
        for(var i: words.keySet()){
            int count = 0;
            for(var j:i.toCharArray()){
                if(j!=97&&j!=101&&j!=105&&j!=111&&j!=117&&j!=121) count++;
                else{
                    if(count>max) {
                        result.clear();
                        result.add(i);
                        max = count;
                    }
                    else if(count==max) result.add(i);
                    count=0;
                }
            }
        }
        for(var i:result) System.out.println(i);
    }

    private void doSeventhCommand(){
        int max = 0;
        for(var i: words.values()) if(i>max) max = i;
        for(var i: words.entrySet()) if(i.getValue()==max) System.out.println(i.getKey() + " " + i.getValue());

    }

    private void doEightsCommand(){
        for(var i: words.keySet()){
            int count_1 = 0;
            int count_2 = 0;
            for(var j:i.toCharArray()){
                if(j!=97&&j!=101&&j!=105&&j!=111&&j!=117&&j!=121) count_2++;
                else count_1++;
            }
            if(count_1>count_2) System.out.println(i);
        }
    }

    private void doNinthCommand(){
        int max = 0;
        List<String> result = new ArrayList<>();
        for(var i : words.keySet()){
            int res = i.length();
            for(var j:i.toCharArray()){
                int count = 0;
                for(var q:i.toCharArray()){
                    if(j==q) count++;
                    if(count==2){
                        res--;
                        break;
                    }
                }
            }
            if(res==max) result.add(i);
            else if(res>max){
                max=res;
                result.clear();
                result.add(i);
            }
        }
        for(var i:result) System.out.println(i);
    }

    private void doTenthCommand(){
       // words.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(String::length))).forEach(System.out::println);
        words.keySet().stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() > s2.length()) {
                    return -1;
                } else if (s1.length() < s2.length()) {
                    return 1;
                } else {
                    return s1.compareTo(s2);
                }
            }
        }).forEach(System.out::println);
    }

    private void doEleventhCommand(){
        words.keySet().stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (countPercent(s1) > countPercent(s2)) {
                    return -1;
                } else if (countPercent(s1) < countPercent(s2)) {
                    return 1;
                } else {
                    return s1.compareTo(s2);
                }
            }
        }).forEach(System.out::println);
    }

    private void doTwelfthCommand(){
        words.keySet().stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (1 - countPercent(s1) > 1 - countPercent(s2)) {
                    return -1;
                } else if (1 - countPercent(s1) < 1 - countPercent(s2)) {
                    return 1;
                } else {
                    return s1.compareTo(s2);
                }
            }
        }).forEach(System.out::println);
    }

    private int countPercent(String word){
        int count_1 = 0;
        int count_2 = 0;
        for(var j:word.toCharArray()){
            if(j!=97&&j!=101&&j!=105&&j!=111&&j!=117&&j!=121) count_2++;
            else count_1++;
        }
        return 100 * count_1/word.length();
    }


}
