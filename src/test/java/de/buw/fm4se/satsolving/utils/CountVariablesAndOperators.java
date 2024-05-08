package de.buw.fm4se.satsolving.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountVariablesAndOperators {
  // public static void main(String[] args) {
  //   try {
  //     testCheckValidFormulaNotEmpty();
  //   } catch (IOException | InterruptedException e) {
  //     e.printStackTrace();
  //   }
  // }

  public static int countUniqueVariables(String inputString) {
    String[] separators = { "->", "<-", "<->", "\\|", "&", "!" };

    // Combine separators into a single regular expression pattern
    String regexPattern = String.join("|", separators);
    Pattern pattern = Pattern.compile(regexPattern);

    // Split the string based on the pattern
    String[] parts = pattern.split(inputString);

    // Remove empty strings from the parts
    Set<String> distinctSubstrings = new HashSet<>();
    for (String part : parts) {
      if (!part.isEmpty()) {
        distinctSubstrings.add(part.trim());
      }
    }

    return distinctSubstrings.size();
  }

  public static int countUniqueOperators(String inputString) {
    String regexPattern = "->|<-|<->|\\||&|!";

    Pattern pattern = Pattern.compile(regexPattern);
    Matcher matcher = pattern.matcher(inputString);

    Set<String> uniqueOperators = new HashSet<>();

    while (matcher.find()) {
      uniqueOperators.add(matcher.group());
    }

    return uniqueOperators.size();
  }

  public static void testCheckValidFormulaNotEmpty() throws IOException, InterruptedException {
    String formula = Files.readString(Paths.get("Tasks/Task_2/equivalent.txt"));
    String givenFormula = "(p -> (q | r))";
    formula = "(" + formula + ") <-> " + givenFormula;
    System.out.println(formula);

  }

}
