package com.company.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.company.IncorrectInputStringException;
import com.company.pokerTables.HoldemPokerTable;
import com.company.pokerTables.TexasHoldemPokerTable;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TexasHoldemTest {
    @Test
    public void pokerHandShouldBeEvaluatedAndSortedCorrectly() {
        Map<String, String> testsInputOutput = new HashMap<>();
//        testsInputOutput.put("5c2c4c6dTh Ah3h 3s7s 3d7d",  "Ah3h 3d7d=3s7s");
//        testsInputOutput.put("2h3h4h5d8d KdKs 6h7h",  "KdKs 6h7h");
//        testsInputOutput.put("4cKs4h8s7s Ad4s Ac4d As9s KhKd 5d6d",  "Ac4d=Ad4s 5d6d As9s KhKd");
//        testsInputOutput.put("2h3h4h5d8d KdKs 9hJh",  "KdKs 9hJh");
//        testsInputOutput.put("Ah5d3sKhQc AcAs Tc9h KsQh 2s4h 2h4s",  "Tc9h KsQh AcAs 2h4s=2s4h");
//        testsInputOutput.put("Ah5d3sKhQc AcAs TcJh KsQh 2s4h 2h4s",  "KsQh AcAs 2h4s=2s4h TcJh");
//        testsInputOutput.put("AcAsKsQsQh AdAh TsJs KhQd JhTh KcKd",  "JhTh KhQd KcKd AdAh TsJs");
//        testsInputOutput.put("AcKc3c5hTh TdTs 2c4c 2d4d 2s4s AdKd QcJh Ah2h 9cTc 5d7d",  "5d7d Ah2h AdKd TdTs 2d4d=2s4s QcJh 2c4c=9cTc");
//        testsInputOutput.put("3h7dJs7h5c 8c8h KcKh KsQh AhTd",  "KsQh AhTd 8c8h KcKh");
//        testsInputOutput.put("TcQcJcAcKc AsAd 2d3d 4d5d 2h3h QhJh 9c8c Ts8s",  "2d3d=2h3h=4d5d=9c8c=AsAd=QhJh=Ts8s");
//        testsInputOutput.put("5c2c4c6dTh Ac3c Ah3h 3s7s 3d7d TdTs Kc7c QcJc KhKd 9dJs Jh8h AsAd",  "Jh8h 9dJs KhKd AsAd TdTs Ah3h 3d7d=3s7s QcJc Kc7c Ac3c");
//        testsInputOutput.put("AsKs9h3h5d AdKd AhKh QhJh QdJd", "QdJd=QhJh AdKd=AhKh");
//        testsInputOutput.put("AsKsKc3h5d AdKd AhKh QhJh QdJd", "QdJd=QhJh AdKd=AhKh");
//        testsInputOutput.put("AsKsKc3hAd 4dKd Ah4h QhJh QdJd", "QdJd=QhJh 4dKd Ah4h");
//        testsInputOutput.put("AsKs2cAd3h AcQs AhJh", "AhJh AcQs");
//        testsInputOutput.put("4c4h4s6c6h 3dJc 2c5c 7h6s TsQc", "2c5c=3dJc=TsQc 7h6s");
//        testsInputOutput.put("AcAhQsQcKh Kd7c KcTc JhJs TsQh", "JhJs KcTc=Kd7c TsQh");
//        testsInputOutput.put("3s7sAhQhTd 8h4s 9c4h Kd9s 3hTs 9h6c TcKh 6sKs 8cAs 2c6h", "2c6h 8h4s 9c4h=9h6c 6sKs Kd9s TcKh 8cAs 3hTs");
        testsInputOutput.put("3c7cAdKcQc Jc6h 7hAs 5h2c 4s8s QhTd Qs6d 4dQd 3d6c", "4s8s 4dQd=Qs6d QhTd 7hAs 5h2c 3d6c Jc6h");

        for(Map.Entry<String, String> inputOutput : testsInputOutput.entrySet()){
            assertEquals(inputOutput.getValue(), evaluateString(inputOutput.getKey()));
        }
    }

    @Test
    public void pokerHandExceptionsShouldBeCaught() {
        Map<String, String> testsInputOutput = new HashMap<>();
        testsInputOutput.put("AcKc3c5hTh5s TcTs 2c4c 2d4d 2s4s AdKd QcJh Ah2h 9cTc 4d7d",  "Wrong input string: Board (AcKc3c5hTh5s) card amount is not equals to 5");
        testsInputOutput.put("AcKc3c5hTh TcTs6h 2c4c 2d4d 2s4s AdKd QcJh Ah2h 9cTc 4d7d",  "Wrong input string: Hand (TcTs6h) card amount is not equals to 2");
        testsInputOutput.put("AcKc3c5hTh TcTs6 2c4c 2d4d 2s4s AdKd QcJh Ah2h 9cTc 4d7d",  "Wrong input string: Card 6 is not a correct input");
        testsInputOutput.put("AcKc3c5hTh TcTs 2c2c",  "Wrong input string: Table contains duplicate cards (2c)");
        testsInputOutput.put("AcKc3c5hTh TcTs 2c3x",  "Wrong input string: Suit x does not exist");
        testsInputOutput.put("AcKc3c5hFh TcTs 2c3h",  "Wrong input string: Rank F does not exist");

        for(Map.Entry<String, String> inputOutput : testsInputOutput.entrySet()){
            assertEquals(inputOutput.getValue(), evaluateString(inputOutput.getKey()));
        }
    }

    public String evaluateString(String input) {
        try {
            HoldemPokerTable pokerTable = new TexasHoldemPokerTable(input);
            pokerTable.evaluateTable();
            return pokerTable.toString();
        } catch (IncorrectInputStringException incorrectInputStringException) {
            return incorrectInputStringException.getMessage();
        }
    }
}
