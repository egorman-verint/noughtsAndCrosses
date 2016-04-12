Feature: Noughts and Crosses Game

  Scenario: Start New Game
    Given "New Game" button exists
    When the "New Game" button is clicked
    Then I will see an empty board
    And the scoreboard will show "Player One 0 Player Two 0 Draws 0"

	
  Scenario Outline: Player makes a move
    Given a new game is started 
    And it is player <Player>s turn
    When I click on cell "1"
    Then an <Marker> will appear in cell "1"

    Examples: 
      | Player | Marker |
      | "One"  | "X"    |
      | "Two"  | "O"    |

  Scenario Outline: Player has won
    Given player <Player>s move has been completed
    When that player <Player> has three markers in a line
    Then show notification saying <Message>
    And the scoreboard will show <ScoreboardMessage>

    Examples: 
      | Player | Message               | ScoreboardMessage                   |
      | "One"  | "Player One has won!" | "Player One 1 Player Two 0 Draws 0" |
      | "Two"  | "Player Two has won!" | "Player One 0 Player Two 1 Draws 0" |

  Scenario Outline: Game is a draw
    Given player <Player>s move has been completed
    When that player <Player> has not got three markers in a line
    And there is no empty cell
    Then show notification saying "Game is a draw"
    And the scoreboard will show "Player One 0 Player Two 0 Draws 1"

    Examples: 
      | Player |
      | "One"  |
      | "Two"  |

  Scenario: Player tries to place marker on populated cell
    When a player selects a cell that is already populated
    Then show notification saying "Invalid Move"

  Scenario Outline: Player forfeits game
    Given there is a game in progress
    And it is player <Player>s turn
    When the "Restart Game" button is clicked
    Then show notification saying <NotificationMessage>
    And the scoreboard will show <ScoreboardMessage>

    Examples: 
      | Player | ScoreboardMessage                   | NotificationMessage             |
      | "One"  | "Player One 0 Player Two 1 Draws 0" | "Player One has ended the game" |
      | "Two"  | "Player One 1 Player Two 0 Draws 0" | "Player Two has ended the game" |
      
   @development
   Scenario: abcde
   given i write a test
