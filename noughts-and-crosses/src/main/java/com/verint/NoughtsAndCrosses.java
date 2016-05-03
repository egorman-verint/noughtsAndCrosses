package com.verint;

public class NoughtsAndCrosses {

	private String currentTurn = "one";
	private String[] gameBoard;

	public NoughtsAndCrosses(String player) {
		currentTurn = player;
		gameBoard = new String[] { "", "", "", "", "", "", "", "", "" };
	}

	public String[] getGameBoard() {
		return gameBoard;
	}

	public String getNextTurn() {
		return currentTurn;
	}

	private void makePlayerTurn(String marker) {
		if (marker.equals("X")) {
			currentTurn = "two";
		} else {
			currentTurn = "one";
		}
	}

	public void placeMarkerInCellLocation(String marker, String cell) {
		int markerValue = Integer.valueOf(cell) - 1;
		if (gameBoard[markerValue].equals("")) {
			gameBoard[markerValue] = marker;
			makePlayerTurn(marker);
		}
	}

	public String getWinner() {
		if (currentTurn.equals("two")) {
			return "one";
		}
		return "two";

	}

	public Boolean hasEnded() {
		return true;
	}

	public void setPlayerTurn(String playerName) {
		currentTurn = playerName;
	}

}
