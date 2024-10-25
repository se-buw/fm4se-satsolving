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
public class T3ConclusionsTest {

  @Test
  @Order(1)
  void testSentence1FormulaNotEmpty() {
    String formula = FmPlay.getcode(Tasks.task3_sentence_1);
    assertNotNull(formula, "Formula is null");
    assertNotEquals("", formula, "Formula is empty");
  }

  @Test
  @Order(2)
  void testSentence2FormulaNotEmpty() {
    String formula = FmPlay.getcode(Tasks.task3_sentence_2);
    assertNotNull(formula, "Formula is null");
    assertNotEquals("", formula, "Formula is empty");
  }

  @Test
  @Order(3)
  void testSentence3FormulaNotEmpty() {
    String formula = FmPlay.getcode(Tasks.task3_sentence_3);
    assertNotNull(formula, "Formula is null");
    assertNotEquals("", formula, "Formula is empty");
  }

  @Test
  @Order(4)
  void testSentence4FormulaNotEmpty() {
    String formula = FmPlay.getcode(Tasks.task3_sentence_4);
    assertNotNull(formula, "Formula is null");
    assertNotEquals("", formula, "Formula is empty");
  }

  // SATISFIABLE
  @Test
  @Order(5)
  void testSentence1FormulaSatisfiable() throws IOException, InterruptedException {
    String formula = FmPlay.getcode(Tasks.task3_sentence_1);
    String result = LimbooleExecutor.runLimboole(formula, true);
    assertTrue(result.contains("% SATISFIABLE"), "Formula is not satisfiable");
  }

  @Test
  @Order(6)
  void testSentence2FormulaSatisfiable() throws IOException, InterruptedException {
    String formula = FmPlay.getcode(Tasks.task3_sentence_2);
    String result = LimbooleExecutor.runLimboole(formula, true);
    assertTrue(result.contains("% SATISFIABLE"), "Formula is not satisfiable");
  }

  @Test
  @Order(7)
  void testSentence3FormulaSatisfiable() throws IOException, InterruptedException {
    String formula = FmPlay.getcode(Tasks.task3_sentence_3);
    String result = LimbooleExecutor.runLimboole(formula, true);
    assertTrue(result.contains("% SATISFIABLE"), "Formula is not satisfiable");
  }

  @Test
  @Order(8)
  void testSentence4FormulaSatisfiable() throws IOException, InterruptedException {
    String formula = FmPlay.getcode(Tasks.task3_sentence_4);
    String result = LimbooleExecutor.runLimboole(formula, true);
    assertTrue(result.contains("% SATISFIABLE"), "Formula is not satisfiable");
  }

  // VALIDITY
  @Test
  @Order(9)
  void testConclusionFormulaValidity() throws IOException, InterruptedException {
    String formula = FmPlay.getcode(Tasks.task3_b);
    String result = LimbooleExecutor.runLimboole(formula, false);
    assertTrue(result.contains("% INVALID"), "Wrong Conclusion");
  }

}
