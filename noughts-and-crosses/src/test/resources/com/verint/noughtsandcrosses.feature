Feature: Noughts and Crosses Game

  Scenario: Start New Game
    Given "New Game" button exists
    When the "New Game" button is clicked
    Then I will see an empty board
    And the scoreboard will show "Player One 0 Player Two 0 Draws 0"

  Scenario Outline: Player makes a move
    Given a new game is started
    And it is player <Player>s turn
    When they click on cell "1"
    Then a <Marker> will appear in cell "1"

    Examples: 
      | Player | Marker |
      | "One"  | "X"    |
      | "Two"  | "O"    |

  Scenario Outline: Player has won
    Given the board shows
      | X | X | * |
      | O | O | * |
      | X | O | * |
    And it is player <Player>s turn
    When they click on cell <Position>
    Then a <Marker> will appear in cell <Position>
    And a notification saying <Message> should appear
    And the scoreboard will show <ScoreboardMessage>

    Examples: 
      | Player | Marker | Position | Message               | ScoreboardMessage                   |
      | "One"  | "X"    | "3"      | "Player One has won!" | "Player One 1 Player Two 0 Draws 0" |
      | "Two"  | "O"    | "6"      | "Player Two has won!" | "Player One 0 Player Two 1 Draws 0" |

  @development
  Scenario Outline: Game is a draw
    Given the board shows
      | X | X | O |
      | O | O | X |
      | X | * | O |
    And it is player "One"s turn
    When they click on cell "8"
    Then a "X" will appear in cell "8"
    And there is no empty cell
    And a notification saying "Game is a draw" should appear
    And the scoreboard will show "Player One 0 Player Two 0 Draws 1"

  Scenario Outline: Player tries to place marker on populated cell
    Given the board shows
      | X | * | * |
      | * | * | * |
      | * | * | * |
    And it is player "One"s turn
    When they click on cell "1"
    Then a notification saying "Invalid move" should appear

  Scenario Outline: Player forfeits game
    Given a new game is started
    And it is player <Player>s turn
    When the "Restart Game" button is clicked
    Then a notification saying <NotificationMessage> should appear
    And the scoreboard will show <ScoreboardMessage>

    Examples: 
      | Player | ScoreboardMessage                   | NotificationMessage             |
      | "One"  | "Player One 0 Player Two 1 Draws 0" | "Player One has ended the game" |
      | "Two"  | "Player One 1 Player Two 0 Draws 0" | "Player Two has ended the game" |
