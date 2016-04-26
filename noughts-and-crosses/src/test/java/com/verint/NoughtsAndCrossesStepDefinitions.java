package com.verint;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NoughtsAndCrossesStepDefinitions {

	private NoughtsAndCrosses game;
	
	@Given("^a New Game is started by player \"([^\"]*)\"$")
	public void startNewGame(String player) {
		game = new NoughtsAndCrosses(player);
		
	}

	@Then("^the game board is empty$")
	public void isGameBoardEmpty() {
		String[] gameBoard = game.getGameBoard();
		assertThat(gameBoard.length, is(9));
		for (int i = 0; i < gameBoard.length; i++) {
			assertThat(gameBoard[i], is(""));
		}
	}
	
	@Given("^a game is in progress$")
	public void isGameInProgress() {
	    // Write code here that turns the phrase above into concrete actions
		assertThat(game,notNullValue());
	}
	
	@Given("^Player \"([^\"]*)\" makes a move$")
	public void playerMakesAMove(String player) {
	    game.makePlayerTurn(player);
	}
	
	@Then("^it is player \"([^\"]*)\"s turn$")
	public void isPlayersTurn(String player) {
		assertThat(game.getNextTurn(), is(player));
	}

	@When("^they place \"([^\"]*)\" in cell \"([^\"]*)\"$")
	public void placeMarkerInCell(String marker, String cell) {
	    game.placeMarkerInCellLocation(marker, cell);
	}
	
	@Then("^cell \"([^\"]*)\" will contain the marker \"([^\"]*)\"$")
	public void doesCellContainMarker(String cell, String marker) {
	    String[] gameboard = game.getGameBoard();
	    assertThat(gameboard[Integer.valueOf(cell) - 1], is(marker));
	}



}
