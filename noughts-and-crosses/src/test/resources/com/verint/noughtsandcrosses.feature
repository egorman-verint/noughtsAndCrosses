Feature: Noughts and Crosses Game
  @development
  Scenario: Start New Game
  When a New Game is started by player "one"
  Then the game board is empty
  And it is player "one"s turn
  
  @development
  Scenario: Player One makes a move
  Given a New Game is started by player "one"
  And Player "one" makes a move
  Then it is player "two"s turn
  
  @development
  Scenario: Player Two makes a move
  Given a New Game is started by player "two"
  And Player "two" makes a move
  Then it is player "one"s turn
  
  @development 
  Scenario Outline: Player makes a move in cell 1
  Given a New Game is started by player <Player>
  And it is player <Player>s turn
  When they place <Marker> in cell "1"
  Then cell "1" will contain the marker <Marker>

    Examples: 
      | Player | Marker |
      | "one"  | "X"    |
      | "two"  | "O"    |
      
  @development
  Scenario: Player Two puts marker in populated cell
  Given a New Game is started by player "one"
  And it is player "one"s turn
  And they place "X" in cell "1"
  And Player "one" makes a move
  And it is player "two"s turn
  And they place "O" in cell "1"
  Then cell "1" will contain the marker "X"
  