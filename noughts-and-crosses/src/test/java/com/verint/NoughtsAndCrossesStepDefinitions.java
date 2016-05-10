package com.verint;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import cucumber.api.DataTable;
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
		assertThat(game, notNullValue());
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

	@Then("^player \"([^\"]*)\" wins$")
	public void playerWins(String player) {
		assertThat(game.getWinner(), is(player));
	}

	@Then("^Game is over$")
	public void gameIsOver() {
		assertThat(game.hasEnded(), is(true));
	}

	@Given("^the board shows$")
	public void the_board_shows(DataTable gameboard) throws Throwable {
		List<List<String>> data = gameboard.raw();

		String whostarted = game.getNextTurn();
		
		int counter = 0;
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				String cellValue = data.get(row).get(col);
				if (cellValue.equals("X") || cellValue.equals("O")) {
					counter++;
				}
				String cellNumber = String.valueOf((row*3) + (col+1));
				System.out.println("cellvalue : " + cellValue + " - cellNumber: " +  cellNumber);
				game.placeMarkerInCellLocation(cellValue, cellNumber);
			}
		}


		if (counter % 2 == 0) {
			game.setPlayerTurn(whostarted);
		} else {
			if (whostarted.equals("two")) {
				game.setPlayerTurn("one");
			} else {
				game.setPlayerTurn("two");
			}
		}

	}
	
	@Then("^Game is in progress$")
	public void gameIsInProgress() throws Throwable {
	    assertThat(game.hasEnded(), is(false));
	}

}
