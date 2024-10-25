package de.buw.fm4se.satsolving.tests;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import de.buw.fm4se.satsolving.exec.LimbooleExecutor;
import de.buw.fm4se.satsolving.task.Tasks;
import de.buw.fm4se.satsolving.utils.FmPlay;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class T4RbacTest {

  @Test
  @Order(1)
  void testRule1FormulaNotEmpty() {
    String formula = FmPlay.getcode(Tasks.task4_a_r1);
    assertNotNull(formula, "Formula is null");
    assertNotEquals("", formula, "Formula is empty");
  }

  @Test
  @Order(2)
  void testRule2FormulaNotEmpty() {
    String formula = FmPlay.getcode(Tasks.task4_a_r2);
    assertNotNull(formula, "Formula is null");
    assertNotEquals("", formula, "Formula is empty");
  }

  @Test
  @Order(3)
  void testRule3FormulaNotEmpty() {
    String formula = FmPlay.getcode(Tasks.task4_a_r3);
    assertNotNull(formula, "Formula is null");
    assertNotEquals("", formula, "Formula is empty");
  }

  @Test
  @Order(4)
  void testConstraint1FormulaNotEmpty() {
    String formula = FmPlay.getcode(Tasks.task4_b_c1);
    assertNotNull(formula, "Formula is null");
    assertNotEquals("", formula, "Formula is empty");
  }

  @Test
  @Order(5)
  void testConstraint2FormulaNotEmpty() {
    String formula = FmPlay.getcode(Tasks.task4_b_c2);
    assertNotNull(formula, "Formula is null");
    assertNotEquals("", formula, "Formula is empty");
  }

  @Test
  @Order(6)
  void testRules() {
    String r1 = "accessCourse<->(isStudent|isTeacher|isAdmin)";
    String r2 = "accessAssignment<->(isStudent|isTeacher)";
    String r3 = "accessServer<->(isAdmin)";

    String formula_r1 = FmPlay.getcode(Tasks.task4_a_r1);
    formula_r1 = FmPlay.removeComments(formula_r1);
    String formula_r2 = FmPlay.getcode(Tasks.task4_a_r2);
    formula_r2 = FmPlay.removeComments(formula_r2);
    String formula_r3 = FmPlay.getcode(Tasks.task4_a_r3);
    formula_r3 = FmPlay.removeComments(formula_r3);

    String formula_r1_without_whitespace = formula_r1.replaceAll("\\s", "");
    String formula_r2_without_whitespace = formula_r2.replaceAll("\\s", "");
    String formula_r3_without_whitespace = formula_r3.replaceAll("\\s", "");

    assertTrue(formula_r1_without_whitespace.contains(r1) || formula_r2_without_whitespace.contains(r1)
        || formula_r3_without_whitespace.contains(r1), "Rule 1 is wrong or does not using the right atoms.");
    assertTrue(formula_r1_without_whitespace.contains(r2) || formula_r2_without_whitespace.contains(r2)
        || formula_r3_without_whitespace.contains(r2), "Rule 2 is wrong or does not using the right atoms.");
    assertTrue(formula_r1_without_whitespace.contains(r3) || formula_r2_without_whitespace.contains(r3)
        || formula_r3_without_whitespace.contains(r3), "Rule 3 is wrong or does not using the right atoms.");
  }

  @Test
  @Order(7)
  void testRulesFormulaValid() throws IOException, InterruptedException {
    String formula_r1 = FmPlay.getcode(Tasks.task4_a_r1);
    String formula_r2 = FmPlay.getcode(Tasks.task4_a_r2);
    String formula_r3 = FmPlay.getcode(Tasks.task4_a_r3);

    String result = LimbooleExecutor.runLimboole(formula_r1, true);
    assertTrue(result.contains("% SATISFIABLE"), "Rule 1 is not satisfiable");

    result = LimbooleExecutor.runLimboole(formula_r2, true);
    assertTrue(result.contains("% SATISFIABLE"), "Rule 2 is not satisfiable");

    result = LimbooleExecutor.runLimboole(formula_r3, true);
    assertTrue(result.contains("% SATISFIABLE"), "Rule 3 is not satisfiable");
  }

  // SATISFIABLE
  @Test
  @Order(8)
  void testConstraint1FormulaSatisfiable() throws IOException, InterruptedException {
    String formula = FmPlay.getcode(Tasks.task4_b_c1);
    String result = LimbooleExecutor.runLimboole(formula, true);
    assertTrue(result.contains("% SATISFIABLE"), "Constraint 1 is not satisfiable");
  }

  @Test
  @Order(9)
  void testConstraint2FormulaSatisfiable() throws IOException, InterruptedException {
    String formula = FmPlay.getcode(Tasks.task4_b_c2);
    String result = LimbooleExecutor.runLimboole(formula, true);
    assertTrue(result.contains("% SATISFIABLE"), "Constraint 2 is not satisfiable");
  }

  // VALIDITY
  @Test
  @Order(10)
  void testConclusionFormulaValidity() throws IOException, InterruptedException {
    String formula = FmPlay.getcode(Tasks.task4_c);
    String result = LimbooleExecutor.runLimboole(formula, false);
    assertTrue(result.contains("VALID"), "Formula is not valid");
  }
}
