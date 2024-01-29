package pages;

import utilities.objects.Component;

public class Help {

    /***************************************************************************************************************
     * These are the container components on the Help Page.
     ***************************************************************************************************************/

    public static class Container {
        public static Component Basics = new Component(
                "Basics",
                "Container",
                "Help Page",
                "//details[contains(@data-gtm, 'Basics')]"
        );
        public static Component BetOptions = new Component(
                "Bet Options",
                "Container",
                "Help Page",
                "//details[contains(@data-gtm, 'BetOption')]"
        );
        public static Component GameControls = new Component(
                "Game Controls",
                "Container",
                "Help Page",
                "//details[contains(@data-gtm, 'GameControl')]"
        );
        public static Component Likelihood = new Component(
                "Likelihood",
                "Container",
                "Help Page",
                "//details[contains(@data-gtm, 'Likelihood')]"
        );
    }

    /***************************************************************************************************************
     * These are the button components on the Help Page.
     ***************************************************************************************************************/

    public static class Button {
        public static Component Back = new Component(
                "Back",
                "Button",
                "Help Page",
                "//div[@class='nav_bar']//button[@class='back_btn']"
        );
        public static Component Basics = new Component(
                "The Basics",
                "Button",
                "Help Page",
                "//summary[normalize-space()='The Basics']"
        );
        public static Component BetOptions = new Component(
                "Bet Options and How to Win",
                "Button",
                "Help Page",
                "//summary[normalize-space()='Bet Options and How to Win']"
        );
        public static Component GameControls = new Component(
                "What are the Game Controls",
                "Button",
                "Help Page",
                "//summary[normalize-space()='What are the Game Controls']"
        );
        public static Component Likelihood = new Component(
                "What is My Likelihood of Winning",
                "Button",
                "Help Page",
                "//summary[normalize-space()='What is My Likelihood of Winning']"
        );
    }

}
