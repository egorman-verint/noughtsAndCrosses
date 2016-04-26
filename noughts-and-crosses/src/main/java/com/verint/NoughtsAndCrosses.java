package com.verint;

public class NoughtsAndCrosses {
	
	private String currentTurn = "one";
	private String[] gameBoard;

	public NoughtsAndCrosses(String player) {
		currentTurn = player;
		gameBoard = new String[] {"","","","","","","","",""};
	}

	public String[] getGameBoard() {
 		return gameBoard;
	}

	public String getNextTurn() {
		return currentTurn;
	}

	public void makePlayerTurn(String player) {
		if(player.equals("one")){
			currentTurn = "two";
		} else {
			currentTurn = "one";
		}
	}

	public void placeMarkerInCellLocation(String marker, String cell) {
		gameBoard[Integer.valueOf(cell) - 1] = marker;
	}


}
