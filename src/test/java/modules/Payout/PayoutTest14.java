package modules.Payout;

import globals.RoundCondition;
import pages.DealerTable;
import utilities.handlers.DataTypeHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.ResultHandler;
import utilities.interfaces.PayoutCase;

public class PayoutTest14 extends Payout implements PayoutCase {

    private double bet = 0, payout;
    private final int testCase = 14, payoutOdds = 1, betOption = 6;
    private final double[] chipValueList = new double[6];

    public int getTestCase() { return testCase; }

    public void setBetOption() {
        if (!DataTypeHandler.findInArray(testCase, testCaseList)) return;

        for (int i = 0; i < betOption; i++)
            EventHandler.click(DealerTable.BettingOption.getSingleDice(i + 1));
    }

    public void getBetOption() {
        if (!DataTypeHandler.findInArray(testCase, testCaseList)) return;

        for (int i = 0; i < betOption; i++)
            chipValueList[i] = getChipValue(DealerTable.BettingChip.getSingleDice(i + 1));
    }

    public void computeTestCase(int[] roundResult) {
        if (!DataTypeHandler.findInArray(testCase, testCaseList) &&
                !DataTypeHandler.findInArray(15, testCaseList) &&
                !DataTypeHandler.findInArray(16, testCaseList)) return;
        if (RoundCondition.isAnyDoubleWin(roundResult)) return;

        for (int i = 0; i < betOption; i++) {
            if (RoundCondition.isSingleDiceWin(roundResult, (i + 1))) {
                double winBet = chipValueList[i];
                bet += winBet;
                payout += winBet + (winBet * payoutOdds);
                addWin(winBet, payoutOdds);
            }
        }
    }

    public void saveTestCase(int[] roundResult) {
        if (!DataTypeHandler.findInArray(testCase, testCaseList)) return;
        if (RoundCondition.isAnyDoubleWin(roundResult)) return;

        String currentRoundResult = DataTypeHandler.toString(roundResult);
        String expectedResult = getExpectedResult();
        String actualResult = getActualResult();
        String otherInfo = getOtherInfo(bet, payoutOdds, payout);
        ResultHandler.setTestResult(testCase, 0, currentRoundResult, expectedResult, actualResult, tableInfo, otherInfo);
        testCaseList = DataTypeHandler.removeFromArray(testCase, testCaseList);
    }

}
