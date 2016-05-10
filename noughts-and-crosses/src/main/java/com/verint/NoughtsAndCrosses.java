package com.verint;

import java.util.ArrayList;

public class NoughtsAndCrosses {

	private String currentTurn = "one";
	private String[] gameBoard;
	private Boolean gameEnded;

	public NoughtsAndCrosses(String player) {
		currentTurn = player;
		gameBoard = new String[] { "", "", "", "", "", "", "", "", "" };
		gameEnded = false;
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
			determineGameState(marker);
		}
	}

	private void determineGameState(String marker) {
		if(!marker.equals("")){			
			checkColumns(marker);
			checkRows(marker);
		}
	}
	
	private void checkColumns(String marker) {
		for(int i=0; i< 3; i++) {
			if(marker.equals(gameBoard[i]) && marker.equals(gameBoard[i+3]) && marker.equals(gameBoard[i+6])){
				gameEnded = true;
			}
		}
	} 
	
	private void checkRows(String marker) {
		for (int i=0; i < 3; i++) {
			int index = i*3;
			if(marker.equals(gameBoard[index]) && marker.equals(gameBoard[index+1]) && marker.equals(gameBoard[index+2])){
				gameEnded = true;
			} 
		}
	}
	
	public String getWinner() {
		if (currentTurn.equals("two")) {
			return "one";
		}
		return "two";

	}

	public Boolean hasEnded() {
		return gameEnded;
	}

	public void setPlayerTurn(String playerName) {
		currentTurn = playerName;
	}

}
