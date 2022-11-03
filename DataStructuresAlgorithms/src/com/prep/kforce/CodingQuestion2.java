package com.prep.kforce;

import java.util.HashMap;

/**
 * A string is said to be beautiful if each letter in the string appears at most as many times as the previous letter
 * in the alphabet within the string; ie: b occurs no more times than a; c occurs no more times than b; etc.
 * Note that letter a has no previous letter.
 *
 * Given a string, check whether it is beautiful.
 *
 * Example
 *
 * For inputString = "bbbaacdafe", the output should be solution(inputString) = true.
 * This string contains 3 as, 3 bs, 1 c, 1 d, 1 e, and 1 f (and 0 of every other letter), so since there aren't any
 * letters that appear more frequently than the previous letter, this string qualifies as beautiful.
 *
 * For inputString = "aabbb", the output should be solution(inputString) = false.
 * Since there are more bs than as, this string is not beautiful.
 *
 * For inputString = "bbc", the output should be solution(inputString) = false.
 * Although there are more bs than cs, this string is not beautiful because there are no as,
 * so therefore there are more bs than as.
 * */

public class CodingQuestion2 {

    public static void main(String... args){
        CodingQuestion2 question = new CodingQuestion2();
        question.solution("bbbaacdafe");
        question.solution("aabbb");
        question.solution("bbc");
    }

    boolean solution(String inputString){

        // a) first we need to count the number of letters that occur in the given string
        HashMap<Character, Integer> counting = new HashMap<>();
        int length = inputString.length();

        // here we just review and count the chars
        for (int i = 0; i < length; i++){
            char c = inputString.charAt(i);
            if (counting.containsKey(c)){
                counting.put(c,counting.get(c)+1);
            }
            else
            {
                counting.put(c,1);
            }
        }

        // b) iterate from a to z and do the validation required
        int firstAlp = (int)'a';
        int lastAlp = (int)'z';
        int previous = Integer.MAX_VALUE;
        for ( int letter = firstAlp; letter <=lastAlp; letter++){
            int count;
            if (counting.containsKey((char)letter))
            {
                count = counting.get((char)letter);
            }
            else
            {
                count = 0;
            }

            if (count>previous){
                System.out.println("For " + inputString + " returning false" );
                return false;
            }
            previous = count;
        }

        System.out.println("For " + inputString + " returning true" );
        return true;
    }

}
