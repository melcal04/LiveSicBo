package modules.ResultAndStatistics;

import globals.RoundCondition;
import pages.Statistics;
import utilities.handlers.AssertHandler;
import utilities.handlers.DataTypeHandler;
import utilities.handlers.ResultHandler;
import utilities.interfaces.ResAndStatsCase;
import utilities.objects.TestResult;
import utilities.settings.Constants;

public class ResAndStatsTest4_2 extends ResAndStats implements ResAndStatsCase {

    public static final int testCase = 4, division = 2;
    private double oldTripleSBPercentage = 0.0, tripleSBPercentage = 0.0;
    private double oldTripleOEPercentage = 0.0, tripleOEPercentage = 0.0;

    public int getTestCase() { return testCase; }

    public int getDivision() { return division; }

    public void setStatistics() {
        if (!DataTypeHandler.findInArray(testCase, testCaseList)) return;
        if (!DataTypeHandler.findInArray(division, divisionList)) return;

        oldTripleSBPercentage = tripleSBPercentage;
        tripleSBPercentage = getPercentage(Statistics.Label.TripleSBPercentage);
        oldTripleOEPercentage = tripleOEPercentage;
        tripleOEPercentage = getPercentage(Statistics.Label.TripleOEPercentage);
    }

    public void saveTestCase(int[] roundResult) {
        if (!DataTypeHandler.findInArray(testCase, testCaseList)) return;
        if (!DataTypeHandler.findInArray(division, divisionList)) return;
        if (!RoundCondition.isAnyTripleWin(roundResult)) return;
        if (oldTripleSBPercentage == tripleSBPercentage) return;
        if (oldTripleOEPercentage == tripleOEPercentage) return;

        String currentRoundResult = DataTypeHandler.toString(roundResult);
        String oldResult = oldTripleSBPercentage + "-" + oldTripleOEPercentage;
        String expectedResult = "Any Triple Percentage Must Increase";
        String actualResult = tripleSBPercentage + "-" + tripleOEPercentage;

        System.out.println("    - " + expectedResult + ": " + oldResult + " --> " + actualResult);
        ResultHandler.setTestResult(testCase, division, currentRoundResult, expectedResult, actualResult, tableInfo, oldResult);
        divisionList = DataTypeHandler.removeFromArray(division, divisionList);
        if (divisionList.length != 0) return;
        testCaseList = DataTypeHandler.removeFromArray(testCase, testCaseList);
    }

    public static void verify() {
        TestResult result = ResultHandler.getTestResult(testCase, division, Constants.Directory.RESULT_AND_STATS_PATH);

        System.out.println();
        System.out.println("Module: RESULT AND STATISTICS");
        System.out.println("Division: " + result.getDivision());
        System.out.println("Test Case: " + result.getTestCase());
        System.out.println("Table Information: " + result.getTableInfo());
        System.out.println("Round Result: " + result.getRoundResult());
        System.out.println("Expected Result: " + result.getExpectedResult());

        for (int i = 0; i < 2; i++) {
            String oldPercentageText = result.getOtherInfo().split("-")[i];
            String actualPercentageText = result.getActualResult().split("-")[i];
            String message = "Actual Result: " + oldPercentageText + " --> " + actualPercentageText;
            double actualPercentage = Double.parseDouble(actualPercentageText);
            double oldPercentage = Double.parseDouble(oldPercentageText);
            AssertHandler.assertTrue(actualPercentage > oldPercentage, message, message);
        }

        System.out.println();
    }

}
