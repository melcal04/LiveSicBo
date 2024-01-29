package pages;

import utilities.objects.Component;

public class Statistics {

    /***************************************************************************************************************
     * These are the container components on the Statistics Page.
     ***************************************************************************************************************/
    public static class Container {
        public static Component Statistics = new Component(
                "Statistics",
                "Container",
                "Statistics Page",
                "//div[@class='statistics']"
        );
    }

    /***************************************************************************************************************
     * These are the button components on the Statistics Page.
     ***************************************************************************************************************/
    public static class Button {
        public static Component CloseStatistics = new Component(
                "Close Statistics",
                "Button",
                "Statistics Page",
                "//button[@class='statistics_header_close_btn']"
        );
    }

    /***************************************************************************************************************
     * These are the label components on the Statistics Page.
     ***************************************************************************************************************/

    public static class Label {
        public static Component ShowTimer = new Component(
                "Show Timer",
                "Label",
                "Statistics Page",
                "//p[@id='showTimer']"
        );
        public static Component ShowDealing = new Component(
                "Show Dealing Wording",
                "Label",
                "Statistics Page",
                "//p[@id='showDealingWording']"
        );
        public static Component Dice1Percentage = new Component(
                "Dice 1 Percentage",
                "Label",
                "Statistics Page",
                "//div[@class='dice_info']//div[@class='dice dice_1']/following-sibling::span"
        );
        public static Component Dice2Percentage = new Component(
                "Dice 2 Percentage",
                "Label",
                "Statistics Page",
                "//div[@class='dice_info']//div[@class='dice dice_2']/following-sibling::span"
        );
        public static Component Dice3Percentage = new Component(
                "Dice 3 Percentage",
                "Label",
                "Statistics Page",
                "//div[@class='dice_info']//div[@class='dice dice_3']/following-sibling::span"
        );
        public static Component Dice4Percentage = new Component(
                "Dice 4 Percentage",
                "Label",
                "Statistics Page",
                "//div[@class='dice_info']//div[@class='dice dice_4']/following-sibling::span"
        );
        public static Component Dice5Percentage = new Component(
                "Dice 5 Percentage",
                "Label",
                "Statistics Page",
                "//div[@class='dice_info']//div[@class='dice dice_5']/following-sibling::span"
        );
        public static Component Dice6Percentage = new Component(
                "Dice 6 Percentage",
                "Label",
                "Statistics Page",
                "//div[@class='dice_info']//div[@class='dice dice_6']/following-sibling::span"
        );
        public static Component SmallPercentage = new Component(
                "Small Percentage",
                "Label",
                "Statistics Page",
                "//div[@class='bar_info big_small_tripple']//div[@class='text_container']//div[1]"
        );
        public static Component BigPercentage = new Component(
                "Big Percentage",
                "Label",
                "Statistics Page",
                "//div[@class='bar_info big_small_tripple']//div[@class='text_container']//div[3]"
        );
        public static Component TripleSBPercentage = new Component(
                "Triple SB Percentage",
                "Label",
                "Statistics Page",
                "//div[@class='bar_info big_small_tripple']//div[@class='text_container']//div[2]"
        );
        public static Component OddPercentage = new Component(
                "Odd Percentage",
                "Label",
                "Statistics Page",
                "//div[@class='bar_info odd_even']//div[@class='text_container']//div[1]"
        );
        public static Component EvenPercentage = new Component(
                "Even Percentage",
                "Label",
                "Statistics Page",
                "//div[@class='bar_info odd_even']//div[@class='text_container']//div[3]"
        );
        public static Component TripleOEPercentage = new Component(
                "Triple OE Percentage",
                "Label",
                "Statistics Page",
                "//div[@class='bar_info odd_even']//div[@class='text_container']//div[2]"
        );
        public static Component HotNumbers = new Component(
                "List of Hot Numbers",
                "Label",
                "Statistics Page",
                "//div[@class='hot_number_info']//div[@class='bar']//span"
        );
        public static Component HotCounters = new Component(
                "List of Hot Counters",
                "Label",
                "Statistics Page",
                "//div[@class='hot_number_info']//span[@class='bar_frequency']"
        );
        public static Component ColdNumbers = new Component(
                "List of Cold Numbers",
                "Label",
                "Statistics Page",
                "//div[@class='cold_number_info']//div[@class='bar']//span"
        );
        public static Component ColdCounters = new Component(
                "List of Cold Counters",
                "Label",
                "Statistics Page",
                "//div[@class='cold_number_info']//span[@class='bar_frequency']"
        );
        public static Component NumbersInResultHistory = new Component(
                "List of Numbers In Result History",
                "Label",
                "Statistics Page",
                "(//div[contains(@class, 'sicbo_line_results')]//li)" +
                        "[position() > last() - 10]//div[contains(@class, 'text text')][1]"
        );
        public static Component LatestRoundResult = new Component(
                "List of Latest Round Result",
                "Label",
                "Statistics Page",
                "//div[@class='sicbo_line_result big active']//div"
        );
    }

}
