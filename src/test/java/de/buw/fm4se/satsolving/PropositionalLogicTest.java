package de.buw.fm4se.satsolving;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import de.buw.fm4se.satsolving.exec.LimbooleExecutor;


public class PropositionalLogicTest {
 
  @Test
  void testCheckValidFormula() throws IOException, InterruptedException{
    String formula = Files.readString(Paths.get("Tasks/Task_1/valid.txt"));
    String result = LimbooleExecutor.runLimboole(formula, false);
    assertTrue(result.contains("VALID"));
  }

  @Test
  void testCheckInvalidFormula() throws IOException, InterruptedException{
    String formula = Files.readString(Paths.get("Tasks/Task_1/invalid.txt"));
    String result = LimbooleExecutor.runLimboole(formula, false);
    assertTrue(result.contains("INVALID"));
  }

}
