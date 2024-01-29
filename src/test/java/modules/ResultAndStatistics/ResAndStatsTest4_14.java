package modules.ResultAndStatistics;

import pages.Statistics;
import utilities.handlers.AssertHandler;
import utilities.handlers.DataTypeHandler;
import utilities.handlers.GetHandler;
import utilities.handlers.ResultHandler;
import utilities.interfaces.ResAndStatsCase;
import utilities.objects.TestResult;
import utilities.settings.Constants;

import java.util.Arrays;

public class ResAndStatsTest4_14 extends ResAndStats implements ResAndStatsCase {

    public static final int testCase = 4, division = 14;
    private int[] oldColdNumberList = new int[5], oldColdCounterList = new int[5], coldNumberList = new int[5], coldCounterList = new int[5];

    public int getTestCase() { return testCase; }

    public int getDivision() { return division; }

    public void setStatistics() {
        if (!DataTypeHandler.findInArray(testCase, testCaseList)) return;
        if (!DataTypeHandler.findInArray(division, divisionList)) return;

        oldColdNumberList = Arrays.copyOf(coldNumberList, coldNumberList.length);
        oldColdCounterList = Arrays.copyOf(coldCounterList, coldCounterList.length);
        coldNumberList = GetHandler.getIntArray(Statistics.Label.ColdNumbers);
        coldCounterList = GetHandler.getIntArray(Statistics.Label.ColdCounters);
    }

    public void saveTestCase(int[] roundResult) {
        if (!DataTypeHandler.findInArray(testCase, testCaseList)) return;
        if (!DataTypeHandler.findInArray(division, divisionList)) return;
        if (!DataTypeHandler.findInArray(DataTypeHandler.sum(roundResult), oldColdNumberList)) return;

        String currentRoundResult = DataTypeHandler.toString(roundResult);
        String oldResult = getResultFromArray(oldColdNumberList, oldColdCounterList);
        String expectedResult = "Number Round Result Must Be Removed From Cold Numbers";
        String actualResult = getResultFromArray(coldNumberList, coldCounterList);

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

        String message = "Actual Result: " + result.getOtherInfo() + " --> " + result.getActualResult();
        int[][] actualResult = Arrays.copyOf(getArrayFromResult(result.getActualResult()), getArrayFromResult(result.getActualResult()).length);
        int[] actualNumberResultList = actualResult[0];
        String[] resultArray = result.getRoundResult().split(" ");
        int[] resultIntArray = new int[resultArray.length];
        for (int i = 0; i < resultArray.length; i++) { resultIntArray[i] = Integer.parseInt(resultArray[i]); }
        int numberResult = DataTypeHandler.sum(resultIntArray);

        AssertHandler.assertFalse(DataTypeHandler.findInArray(numberResult, actualNumberResultList), message, message);

        System.out.println();
    }

}