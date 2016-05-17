package com.verint;

public class NoughtsAndCrosses {

	private String currentTurn = "one";
	private String[] gameBoard;
	private Boolean gameWon;
	private Boolean gameDrawn;
	private String gameWinner;

	public NoughtsAndCrosses(String player) {
		currentTurn = player;
		gameBoard = new String[] { "", "", "", "", "", "", "", "", "" };
		gameWon = false;
		gameWinner = "";
		gameDrawn = false;
	}

	public String[] getGameBoard() {
		return gameBoard;
	}

	public String getCurrentTurn() {
		return currentTurn;
	}

	private void updateCurrentTurn(String marker) {
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
			determineGameState(marker);
			updateCurrentTurn(marker);
		}
	}

	private void determineGameState(String marker) {
		if (!marker.equals("")) {
			checkIsGameWon(marker);
		}
		if (!gameWon) {
			checkIsGameDraw();
		}

		if (gameWon) {
			gameWinner = currentTurn;
		}

	}

	private void checkIsGameWon(String marker) {
		checkColumns(marker);
		checkRows(marker);
		checkDiagonals(marker);
	}

	private void checkIsGameDraw() {
		gameDrawn = true;
		for (int i = 0; i < 9; i++) {
			if (gameBoard[i].equals("")) {
				gameDrawn = false;
				break;
			}
		}

		if (gameDrawn) {
			gameWinner = "draw";
		}
	}

	private void checkColumns(String marker) {
		for (int i = 0; i < 3; i++) {
			if (marker.equals(gameBoard[i]) && marker.equals(gameBoard[i + 3]) && marker.equals(gameBoard[i + 6])) {
				gameWon = true;
			}
		}
	}

	private void checkRows(String marker) {
		for (int i = 0; i < 3; i++) {
			int index = i * 3;
			if (marker.equals(gameBoard[index]) && marker.equals(gameBoard[index + 1])
					&& marker.equals(gameBoard[index + 2])) {
				gameWon = true;
			}
		}
	}

	private void checkDiagonals(String marker) {
		if (marker.equals(gameBoard[2]) && marker.equals(gameBoard[4]) && marker.equals(gameBoard[6])) {
			gameWon = true;
		} else if (marker.equals(gameBoard[0]) && marker.equals(gameBoard[4])
				&& marker.equals(gameBoard[8])) {
			gameWon = true;
		}

	}

	public String getWinner() {
		return gameWinner;

	}

	public Boolean hasEnded() {
		return gameWon || gameDrawn;
	}

	public void setPlayerTurn(String playerName) {
		currentTurn = playerName;
	}

}
