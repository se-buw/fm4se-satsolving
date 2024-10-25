package de.buw.fm4se.satsolving.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import java.io.IOException;

import de.buw.fm4se.satsolving.exec.LimbooleExecutor;
import de.buw.fm4se.satsolving.task.Tasks;
import de.buw.fm4se.satsolving.utils.FmPlay;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class T2SemanticEquivalenceTest {

  /*
   * Test if the valid formula is not empty
   */
  @Test
  @Order(1)
  void testCheckEquivalentFormulaCheck1NotEmpty() throws IOException, InterruptedException {
    String formula = FmPlay.getcode(Tasks.task2_a_c1);
    assertNotNull(formula, "Formula is null");
    assertNotEquals("", formula, "Formula is empty");
  }

  @Test
  @Order(2)
  void testCheckEquivalentFormulaCheck2NotEmpty() throws IOException, InterruptedException {
    String formula = FmPlay.getcode(Tasks.task2_a_c2);
    assertNotNull(formula, "Formula is null");
    assertNotEquals("", formula, "Formula is empty");
  }

  /*
   * Test if the formula is equivalent to the given formula
   */
  @Test
  @Order(3)
  void testCheckEquivalentFormula() throws IOException, InterruptedException {
    String formula_c1 = FmPlay.getcode(Tasks.task2_a_c1);
    String formula_c2 = FmPlay.getcode(Tasks.task2_a_c2);

    assertTrue(formula_c1.contains("->") || formula_c1.contains("<-"), "There is no implication in the formula");
    assertTrue(formula_c2.contains("->") || formula_c2.contains("<-"), "There is no implication in the formula");

    String result_c1 = LimbooleExecutor.runLimboole(formula_c1, false);
    assertTrue(result_c1.contains("% VALID"));
    String result_c2 = LimbooleExecutor.runLimboole(formula_c2, false);
    assertTrue(result_c2.contains("% VALID"), "Formula is not equivalent to the given formula");
  }

  /*
   * Test if the valid formula is not empty
   */
  @Test
  @Order(4)
  void testCheckNonEquivalentFormulaCheck1NotEmpty() throws IOException, InterruptedException {
    String formula = FmPlay.getcode(Tasks.task2_b_c1);
    assertNotNull(formula, "Formula is null");
    assertNotEquals("", formula, "Formula is empty");
  }

  @Test
  @Order(5)
  void testCheckNonEquivalentFormulaCheck2NotEmpty() throws IOException, InterruptedException {
    String formula = FmPlay.getcode(Tasks.task2_b_c2);
    assertNotNull(formula, "Formula is null");
    assertNotEquals("", formula, "Formula is empty");
  }

  /*
   * Test if the formula is equivalent to the given formula
   */
  @Test
  @Order(6)
  void testCheckNonEquivalentFormula() throws IOException, InterruptedException {
    String formula_c1 = FmPlay.getcode(Tasks.task2_b_c1);
    String formula_c2 = FmPlay.getcode(Tasks.task2_b_c2);

    assertTrue(formula_c1.contains("->") || formula_c1.contains("<-"), "There is no implication in the formula");
    assertTrue(formula_c2.contains("->") || formula_c2.contains("<-"), "There is no implication in the formula");

    String result_c1 = LimbooleExecutor.runLimboole(formula_c1, false);
    String result_c2 = LimbooleExecutor.runLimboole(formula_c2, false);

    assertTrue(
        (result_c1.contains("% INVALID") && result_c2.contains("% VALID")) ||
            (result_c1.contains("% VALID") && result_c2.contains("% INVALID")) ||
            (result_c1.contains("% INVALID") && result_c2.contains("% INVALID")),
        "Formula is EQUIVALENT to the given formula");
  }

}
