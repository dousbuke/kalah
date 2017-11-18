# kalah
Kalah game 

https://en.wikipedia.org/wiki/Kalah

For SpringBoot branch: 

# -- Post - game/init-board
Sets the size of board;

Request: BoardRequest 
Integer boardSize;

Response: BoardResponse
Board firstPlayerBoard;
Board secondPlayerBoard;

# -- Get - game/init
Initialize game

Response:
GameStatus.PLAYING

# -- Post - game/select-pit
Player movement. 

Request : SelectPitRequest </br>
Players players = Enum, FIRST_PLAYER or SECOND_PLAYER
Integer pit = Selection of pit
Board player = Home player board
Board opponent = Opponent player board


Response : SelectPitResponse
Board player = Home player board after movement
Board opponent = Opponent board after movement
boolean lastStone = if the last stone remains on an emtpy pit, then return true so that player can take the opposite      stones. false if not, turn swaps to other player

# -- Post - game/status-check
Status check of game

Request: GameStatusCheckRequest
Board firstPlayerBoard;
Board secondPlayerBoard;

Response: GameStatusCheckResponse
GameStatus: PLAYING, DRAW, FIRST_PLAYER_WIN, SECOND_PLAYER_WIN
