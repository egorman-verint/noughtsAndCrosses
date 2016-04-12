package com.verint;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NoughtsAndCrossesStepDefinitions {
	private final static int WAIT_TIMEOUT = 2;

	@When("^the \"([^\"]*)\" button is clicked$")
	public void clickButton(String buttonName) {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost");

		// Write code here that turns the phrase above into concrete actions
		WebElement element = (new WebDriverWait(driver, WAIT_TIMEOUT))
				.until(ExpectedConditions.elementToBeClickable(By.id(buttonName)));
		element.click();
	}
	
	@Then("^I will see an empty board$")
	public void checkBoardEmpty() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Given("^\"([^\"]*)\" button exists$")
	public void checkButtonExists(String buttonName) {
		// Write code here that turns the phrase above into concrete actions
	}
	
	@Then("^the scoreboard will show \"([^\"]*)\"$")
	public void checkScoreboardDisplay(String scoreBoardText) {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Given("^it is player \"([^\"]*)\"s turn$")
	public void isPlayersTurn(String playerNumber) {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("^an \"([^\"]*)\" will appear in cell \"([^\"]*)\"$")
	public void placeMarkerInCell(String marker, String cellNumber) {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("^I click on cell \"([^\"]*)\"$")
	public void clickCell(String cellNumber) {
		// Write code here that turns the phrase above into concrete actions
	}

	@Given("^player \"([^\"]*)\"s move has been completed$")
	public void checkPlayerHasCompletedMove(String playerNumber) {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("^that player \"([^\"]*)\" has three markers in a line$")
	public void checkPlayerHasThreeMarkersInLine(String playerNumber) {
		// Write code here that turns the phrase above into concrete actions
	}
	
	@Then("^show notification saying \"([^\"]*)\"$")
	public void showNotification(String notificationMessage) {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("^that player \"([^\"]*)\" has not got three markers in a line$")
	public void checkPlayerDoesNotHaveThreeMarkersInLine(String playerNumber) {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("^there is no empty cell$")
	public void checkBoardFull() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("^a player selects a cell that is already populated$")
	public void selectPopulatedCell() {
		// Write code here that turns the phrase above into concrete actions
	}
	
	@Given("^a new game is started$")
	public void checkGameIsStarted() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Given("^there is a game in progress$")
	public void checkGameInProgress() {
	    // Write code here that turns the phrase above into concrete actions
	}


}
