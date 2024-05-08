package de.buw.fm4se.satsolving.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import de.buw.fm4se.satsolving.exec.LimbooleExecutor;
import de.buw.fm4se.satsolving.task.Tasks;
import de.buw.fm4se.satsolving.utils.CountVariablesAndOperators;
import de.buw.fm4se.satsolving.utils.FmPlay;

public class T1CheckingValidityTest {

  /*
   * Test if the valid formula is not empty
   */
  @Test
  void testCheckValidFormulaNotEmpty() throws IOException, InterruptedException {
    String formula = FmPlay.getcode(Tasks.task1_a);
    assertNotEquals("", formula, "Formula is empty");
  }

  /*
   * Test if the formula is valid
   */
  @Test
  void testCheckValidFormula() throws IOException, InterruptedException {
    String formula = FmPlay.getcode(Tasks.task1_a);
    String result = LimbooleExecutor.runLimboole(formula, false);
    assertTrue(result.contains("% VALID"), "Formula does not hold. But it must hold");
  }

  /*
   * Test if the formula has at least 3 variables and 2 operators
   */
  @Test
  void testValidFormulaCount() throws IOException, InterruptedException {
    String formula = FmPlay.getcode(Tasks.task1_a);
    int variables = CountVariablesAndOperators.countUniqueVariables(formula);
    int operators = CountVariablesAndOperators.countUniqueOperators(formula);
    assertTrue(variables >= 3, "Formula has less than 3 variables");
    assertTrue(operators >= 2, "Formula has less than 2 operators");
  }

  // Invalid formula: Task 1 b
  /*
   * Test if the invalid formula is not empty
   */
  @Test
  void testCheckInvalidFormulaNotEmpty() throws IOException, InterruptedException {
    String formula = FmPlay.getcode(Tasks.task1_b);
    assertNotNull(formula);
    assertNotEquals("", formula, "Formula is empty");
  }

  /*
   * Test if the formula is invalid
   */
  @Test
  void testCheckInvalidFormula() throws IOException, InterruptedException {
    String formula = FmPlay.getcode(Tasks.task1_b);
    String result = LimbooleExecutor.runLimboole(formula, false);
    assertTrue(result.contains("% INVALID"), "Formula holds. But it must not hold");
  }

  /*
   * Test if the formula has at least 3 variables and 2 operators
   */
  @Test
  void testCheckInvalidFormulaCount() throws IOException, InterruptedException {
    String formula = FmPlay.getcode(Tasks.task1_b);
    int variables = CountVariablesAndOperators.countUniqueVariables(formula);
    int operators = CountVariablesAndOperators.countUniqueOperators(formula);
    assertTrue(variables >= 3, "Formula has less than 3 variables");
    assertTrue(operators >= 2, "Formula has less than 2 operators");
  }

}
