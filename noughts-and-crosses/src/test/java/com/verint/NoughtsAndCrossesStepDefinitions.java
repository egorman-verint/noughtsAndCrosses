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

		int counter = 0;
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (data.get(row).get(col).equals("X") || data.get(row).get(col).equals("O")) {
					counter++;
				}
			}
		}

		String a1 = data.get(0).get(0);
		String a2 = data.get(0).get(1);
		String a3 = data.get(0).get(2);
		String b1 = data.get(1).get(0);
		String b2 = data.get(1).get(1);
		String b3 = data.get(1).get(2);
		String c1 = data.get(2).get(0);
		String c2 = data.get(2).get(1);
		String c3 = data.get(2).get(2);

		/*System.out.println(a1 + a2 + a3);
		System.out.println(b1 + b2 + b3);
		System.out.println(c1 + c2 + c3);*/

		String whostarted = game.getNextTurn();

		game.placeMarkerInCellLocation(a1, "1");
		game.placeMarkerInCellLocation(a2, "2");
		game.placeMarkerInCellLocation(a3, "3");
		game.placeMarkerInCellLocation(b1, "4");
		game.placeMarkerInCellLocation(b2, "5");
		game.placeMarkerInCellLocation(b3, "6");
		game.placeMarkerInCellLocation(c1, "7");
		game.placeMarkerInCellLocation(c2, "8");
		game.placeMarkerInCellLocation(c3, "9");

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
