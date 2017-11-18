# kalah
Kalah game 

https://en.wikipedia.org/wiki/Kalah

For SpringBoot branch: 

# Post - game/init-board
Sets the size of board;

Request: BoardRequest </br>
Integer boardSize;

Response: BoardResponse </br>
Board firstPlayerBoard; </br>
Board secondPlayerBoard;

# Get - game/init
Initialize game

Response:
GameStatus.PLAYING

# Post - game/select-pit
Player movement. 

Request : SelectPitRequest </br>
Players players = Enum, FIRST_PLAYER or SECOND_PLAYER </br>
Integer pit = Selection of pit </br>
Board player = Home player board </br>
Board opponent = Opponent player board </br>


Response : SelectPitResponse </br>
Board player = Home player board after movement </br>
Board opponent = Opponent board after movement </br>
boolean lastStone = if the last stone remains on an emtpy pit, then return true so that player can take the opposite      stones. false if not, turn swaps to other player

# Post - game/status-check
Status check of game

Request: GameStatusCheckRequest </br>
Board firstPlayerBoard;
Board secondPlayerBoard;

Response: GameStatusCheckResponse </br>
GameStatus: PLAYING, DRAW, FIRST_PLAYER_WIN, SECOND_PLAYER_WIN
