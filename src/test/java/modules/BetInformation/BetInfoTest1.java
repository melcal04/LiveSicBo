package modules.BetInformation;

import globals.BettingOption;
import globals.RoundCondition;
import org.openqa.selenium.WebElement;
import pages.BetDetails;
import utilities.handlers.*;

import java.util.List;

public class BetInfoTest1 extends BetInformation {

    static String betOption = BettingOption.EVEN;

    public static void placeBetUntilWin() {
        do {
            placeBet(betOption);
            waitRoundResult();
        } while (!RoundCondition.isEvenWin(roundResult));
    }

    public static void verify() {
        System.out.println();
        System.out.println("Module: BET INFORMATION");
        System.out.println("Test Case: 1");
        System.out.println("Other Information: " + tableName + " #" + roundId + " " + DataTypeHandler.toString(roundResult));
        System.out.println("Actual Results: ");

        WaitHandler.waitVisibility(BetDetails.Label.BetDetails, 150);
        verifyDisplay(BetDetails.Button.Back);

        double expectedStake = totalBet;
        double actualStake = getCurrentStake();
        AssertHandler.assertEquals(expectedStake, actualStake,
                "** Stake is Correct: " + expectedStake + " == " + actualStake,
                "** Stake is Incorrect: " + expectedStake + " != " + actualStake);

        double expectedWinLoss = totalBet;
        double actualWinLoss = GetHandler.getDouble(BetDetails.Label.WinLoss);
        AssertHandler.assertEquals(expectedWinLoss, actualWinLoss,
                "** Win/Loss is Correct: " + expectedWinLoss + " == " + actualWinLoss,
                "** Win/Loss is Incorrect: " + expectedWinLoss + " != " + actualWinLoss);

        verifyDisplay(BetDetails.Container.BettingOptions);
        verifyDisplay(BetDetails.BettingChip.getMainBet(betOption));

        List<WebElement> winBettingOptions = GetHandler.getElements(BetDetails.Container.WinBettingOptions);
        AssertHandler.assertFalse(ConditionHandler.isEmpty(BetDetails.Container.WinBettingOptions),
                "** Win Betting Options is Correct: " + winBettingOptions.size(),
                "** Win Betting Options is Incorrect: " + 0);

        AssertHandler.assertTrue(isWins(winBettingOptions, betOption),
                "** " + BetDetails.BettingOption.getMainBet(betOption).getName() + " Wins",
                "** " + BetDetails.BettingOption.getMainBet(betOption).getName() + " Loses");

        System.out.println();
    }

}
