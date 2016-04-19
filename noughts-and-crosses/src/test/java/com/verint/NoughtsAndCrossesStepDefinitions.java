package com.verint;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.webdriven.commands.IsEditable;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class NoughtsAndCrossesStepDefinitions {
	private final static int WAIT_TIMEOUT = 2;
	private NoughtsAndCrosses game;

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

	@Then("^a \"([^\"]*)\" will appear in cell \"([^\"]*)\"$")
	public void placeMarkerInCell(String marker, String cellNumber) {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("^they click on cell \"([^\"]*)\"$")
	public void clickCell(String cellNumber) {
		// Write code here that turns the phrase above into concrete actions
	}

	@Given("^the board shows$")
	public void the_board_shows(DataTable gameboard) throws Throwable {
	   List<List<String>> data = gameboard.raw();
	   
	   String a1 = data.get(0).get(0);
	   String a2 = data.get(0).get(1);
	   String a3 = data.get(0).get(2);
	   String b1 = data.get(1).get(0);
	   String b2 = data.get(1).get(1);
	   String b3 = data.get(1).get(2);
	   String c1 = data.get(2).get(0);
	   String c2 = data.get(2).get(1);
	   String c3 = data.get(2).get(2);
	   
	   System.out.println(a1 + a2 + a3);
	   System.out.println(b1 + b2 + b3);
	   System.out.println(c1 + c2 + c3);
	}


	@When("^that player \"([^\"]*)\" has three markers in a line$")
	public void checkPlayerHasThreeMarkersInLine(String playerNumber) {
		// Write code here that turns the phrase above into concrete actions
	}
	
	@Then("^a notification saying \"([^\"]*)\" should appear$")
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
	
	
	
	
	
	@When("^a New Game is started$")
	public void aNewGameIsStarted() throws Throwable {
	    game = new NoughtsAndCrosses();
	}

	@Then("^the game board is empty$")
	public void theGameBoardIsEmpty() throws Throwable {
	    String[] gameBoard = game.getGameBoard();
	    assertThat(gameBoard.length, is(9));
	    for(int i=0; i<gameBoard.length; i++){
	    	assertThat(gameBoard[i], is(""));
	    }
	}


}
