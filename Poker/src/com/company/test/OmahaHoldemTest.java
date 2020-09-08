package com.company.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.company.IncorrectInputStringException;
import com.company.pokerTables.HoldemPokerTable;
import com.company.pokerTables.OmahaHoldemPokerTable;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class OmahaHoldemTest {
    @Test
    public void pokerHandShouldBeEvaluatedAndSortedCorrectly() {
        Map<String, String> testsInputOutput = new HashMap<>();
        testsInputOutput.put("5c2c4c6dTh Ah3h3s7s 3d7dTdTc",  "3d7dTdTc=Ah3h3s7s");
        testsInputOutput.put("4cKs4h8s7s Ad4sAc4d As9sKhKd",  "As9sKhKd Ad4sAc4d");
        testsInputOutput.put("Ah5d3sKhQc AcAsTc9h KsQh2s4h",  "AcAsTc9h KsQh2s4h");
        testsInputOutput.put("Ah5d3sKhQc AcAsTcJh KsQh2s4h",  "KsQh2s4h AcAsTcJh");
        testsInputOutput.put("AcAsKsQsQh AdAhTsJs KhQdJhTh",  "KhQdJhTh AdAhTsJs");
        testsInputOutput.put("AcKc3c5hTh TdTs2c4c 2d4d2s4s AdKdQcJh Ah2h9cTc",  "2d4d2s4s AdKdQcJh Ah2h9cTc=TdTs2c4c");
        testsInputOutput.put("3h7dJs7h5c 8c8hKcKh KsQhAhTd",  "KsQhAhTd 8c8hKcKh");
        testsInputOutput.put("TcQcJcAcKc AsAd2d3d 4d5d2h3h QhJh9c8c",  "4d5d2h3h AsAd2d3d QhJh9c8c");
        testsInputOutput.put("5c2c4c6dTh Ac3cAh3h 3s7s3d7d TdTsKc7c QcJcKhKd 9dJsJh8h",  "9dJsJh8h 3s7s3d7d QcJcKhKd TdTsKc7c Ac3cAh3h");
        testsInputOutput.put("AsKs9h3h5d AdKdAhKh QhJhQdJd", "QhJhQdJd AdKdAhKh");
        testsInputOutput.put("AsKsKc3h5d AdKdAhKh QhJhQdJd", "QhJhQdJd AdKdAhKh");
        testsInputOutput.put("AsKsKc3hAd 4dKdAh4h QhJhQdJd", "QhJhQdJd 4dKdAh4h");


        for(Map.Entry<String, String> inputOutput : testsInputOutput.entrySet()){
            assertEquals(inputOutput.getValue(), evaluateString(inputOutput.getKey()));
        }
    }

    @Test
    public void pokerHandExceptionsShouldBeCaught() {
        Map<String, String> testsInputOutput = new HashMap<>();
        testsInputOutput.put("AcKc3c5hTh5s TcTs2c4c 2d4d2s4s AdKdQcJh Ah2h9cTc",  "Wrong input string: Board (AcKc3c5hTh5s) card amount is not equals to 5");
        testsInputOutput.put("AcKc3c5hTh TcTs6h2c4c 2d4d2s4s AdKdQcJh Ah2h9cTc",  "Wrong input string: Hand (TcTs6h2c4c) card amount is not equals to 4");
        testsInputOutput.put("AcKc3c5hTh TcTs6c4c 2d4d2s4s AdKdQcJh Ah2h9c6",  "Wrong input string: Card 6 is not a correct input");
        testsInputOutput.put("AcKc3c5hTh TcTs2c2c",  "Wrong input string: Table contains duplicate cards (2c)");
        testsInputOutput.put("AcKc3c5hTh TcTs2c3x",  "Wrong input string: Suit x does not exist");
        testsInputOutput.put("AcKc3c5hFh TcTs2c3h",  "Wrong input string: Rank F does not exist");

        for(Map.Entry<String, String> inputOutput : testsInputOutput.entrySet()){
            assertEquals(inputOutput.getValue(), evaluateString(inputOutput.getKey()));
        }
    }

    public String evaluateString(String input) {
        try {
            HoldemPokerTable pokerTable = new OmahaHoldemPokerTable(input);
            pokerTable.evaluateTable();
            return pokerTable.toString();
        } catch (IncorrectInputStringException incorrectInputStringException) {
            return incorrectInputStringException.getMessage();
        }
    }
}
