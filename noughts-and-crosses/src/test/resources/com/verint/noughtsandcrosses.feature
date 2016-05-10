Feature: Noughts and Crosses Game

  @development
  Scenario: Start New Game
    When a New Game is started by player "one"
    Then the game board is empty
    And it is player "one"s turn

  @development
  Scenario: Player One makes a move
    Given a New Game is started by player "one"
    And they place "X" in cell "1"
    Then it is player "two"s turn

  @development
  Scenario: Player Two makes a move
    Given a New Game is started by player "two"
    And they place "O" in cell "1"
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
    And it is player "two"s turn
    And they place "O" in cell "1"
    Then cell "1" will contain the marker "X"
    And it is player "two"s turn

  @development
  Scenario: Player one wins by 2nd column
    Given a New Game is started by player "one"
    And it is player "one"s turn
    And the board shows
      | O | X |  |
      | O | X |  |
      |   |   |  |
    And it is player "one"s turn
    And they place "X" in cell "8"
    Then player "one" wins
    And Game is over

  @development
  Scenario: Player two wins by 1st column
    Given a New Game is started by player "two"
    And it is player "two"s turn
    And the board shows
      | O | X |  |
      | O | X |  |
      |   |   |  |
    And it is player "two"s turn
    And they place "O" in cell "7"
    Then player "two" wins
    And Game is over

  @development
  Scenario: Game is in play
    Given a New Game is started by player "two"
    And it is player "two"s turn
    And the board shows
      | O | X |  |
      | O | X |  |
      |   |   |  |
    And it is player "two"s turn
    And they place "O" in cell "8"
    Then it is player "one"s turn
    And Game is in progress

  @development
  Scenario: Player one wins by 3rd column
    Given a New Game is started by player "one"
    And it is player "one"s turn
    And the board shows
      | O |  | X |
      | O |  | X |
      |   |  |   |
    And it is player "one"s turn
    And they place "X" in cell "9"
    Then player "one" wins
    And Game is over

  @development
  Scenario: Player one wins by 2nd row
    Given a New Game is started by player "one"
    And it is player "one"s turn
    And the board shows
      | O | X |   |
      |   | X | X |
      | O | O |   |
    And it is player "one"s turn
    And they place "X" in cell "4"
    Then player "one" wins
    And Game is over

  @development
  Scenario: Player one wins by 1st row
    Given a New Game is started by player "one"
    And it is player "one"s turn
    And the board shows
      |   | X | X |
      |   |   |   |
      | O | O |   |
    And it is player "one"s turn
    And they place "X" in cell "1"
    Then player "one" wins
    And Game is over

    @development
  Scenario: Player two wins by 3rd row
    Given a New Game is started by player "two"
    And it is player "two"s turn
    And the board shows
      |   | X | X |
      |   |   |   |
      | O | O |   |
    And it is player "two"s turn
    And they place "O" in cell "9"
    Then player "two" wins
    And Game is over