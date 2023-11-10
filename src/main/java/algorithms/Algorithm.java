package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Algorithm {

  public static void main(String[] args) throws IOException {

    System.out.println("=========[ Exercise 1 ]=========");

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("Enter first text: ");
    String firstText = reader.readLine();

    System.out.println("Enter second text: ");
    String secondText = reader.readLine();

    if (areTextsAnagrams(firstText, secondText)) {
      System.out.println("The texts are anagrams of each other!");
    } else {
      System.out.println("The texts are not anagrams of each other");
    }

    System.out.println("=========[ Exercise 2 ]=========");

    int[] a = {4, 8, 6, 1, 5, 9, 4, -2, -1};

    System.out.println(Arrays.toString(a));

    int index = getIndexForClosestNeighboringNumbers(a);
    System.out.println("Index: " + index);
  }

  static int getIndexForClosestNeighboringNumbers(int[] a) {
    int min_distance = Integer.MAX_VALUE;
    int index = -1;

    for (int i = 0; i < a.length - 1; i++) {
      int distance = Math.abs(a[i] - a[i + 1]);
      if (distance < min_distance) {
        min_distance = distance;
        index = i;
      }
    }

    return index;
  }

  static boolean areTextsAnagrams(String firstText, String secondText) {
    char[] first = firstText.toLowerCase().replace(" ", "").toCharArray();
    char[] second = secondText.toLowerCase().replace(" ", "").toCharArray();

    if (first.length == second.length) {
      Arrays.sort(first);
      Arrays.sort(second);
      for (int i = 0; i < first.length; i++) {
        if (first[i] != second[i]) {
          return false;
        }
      }
      return true;
    } else {
      return false;
    }
  }
}
