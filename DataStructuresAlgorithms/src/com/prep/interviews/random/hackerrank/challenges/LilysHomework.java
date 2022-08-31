package com.prep.interviews.random.hackerrank.challenges;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * https://www.hackerrank.com/challenges/lilys-homework/problem
     *
     * Complete the 'lilysHomework' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int lilysHomework(List<Integer> arr) {
        // we need to know what's the final state of the array "sorted".
        // my idea is to have the array in a solved state so we know what's the solved order.

        // since we are looking at the minimum number of swaps,
        // we need two data stuctures where we can manipulate the elements
        TreeMap <Integer, Integer> forwards = new TreeMap<>();
        TreeMap <Integer, Integer> backwards = new TreeMap<>();
        int[] backwardsArr = new int[arr.size()];

        // initialize them
        for (int i=0; i<arr.size(); i++)
        {
            forwards.put(arr.get(i), i);
            backwards.put(arr.get(i), i);
            backwardsArr[i] = arr.get(i);
        }

        int index = 0, numOfSwapsAsc = 0, numOfSwapsDesc = 0; // here are the swap counters
        while (index < arr.size())
        {
            int smallest = forwards.firstKey();
            // check if we have to swap
            if (arr.get(index) != smallest)
            {
                int desiredIndex = forwards.get(smallest);
                int temp = arr.get(index); // grab the current element
                arr.set(index, smallest);
                arr.set(desiredIndex, temp);

                forwards.put(arr.get(desiredIndex), desiredIndex);
                numOfSwapsAsc++;
            }
            index++;
            forwards.remove(smallest);
        }

        // now retrieve the number of swaps for the descending order array.
        index = backwardsArr.length - 1;
        while (index >= 0)
        {
            int smallest = backwards.firstKey();
            // check if we have to swap
            if (backwardsArr[index] != smallest)
            {
                int desiredIndex = backwards.get(smallest);
                int temp = backwardsArr[index]; // grab the current element
                backwardsArr[index] = smallest;
                backwardsArr[desiredIndex] = temp;

                backwards.put(backwardsArr[desiredIndex], desiredIndex);
                numOfSwapsDesc++;
            }
            index--;
            backwards.remove(smallest);

        }

        return Math.min(numOfSwapsAsc, numOfSwapsDesc);
    }

}

public class LilysHomework {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
