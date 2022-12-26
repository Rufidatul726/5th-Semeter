package workshop;

/* Changes:
    * 1. Deleted Method createRockQuestion and directly added the question in the array
    * 2. Substitute TriviaGame, CurrentCategory to avoid Duplicate Code
    * 3. No need howManyPlayers method as it is a size of a list
    * The whole could be refractored into multiple classes such as: Player, Question, Game, Answer
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TriviaGame {
    ArrayList players = new ArrayList();
    List<String>QuesType= List.of("Pop","Science","Sports","Rock");
    List<LinkedList>Questions= List.of(new LinkedList(),new LinkedList(),new LinkedList(),new LinkedList());
    int[] places = new int[6];
    int[] purses = new int[6];
    boolean[] inPenaltyBox = new boolean[6];

    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();
    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public TriviaGame() {
        Questions = List.of(popQuestions,scienceQuestions,sportsQuestions,rockQuestions);
        for (int i = 0; i < 50; i++) {
            Questions.get(i).addLast(QuesType + " Question " + i);
        }
    }
    public boolean isPlayable() {
        return (players.size() >= 2);
    }

    public boolean add(String playerName) {
        players.add(playerName);
        int size= players.size();
        places[size] = 0;
        purses[size] = 0;
        inPenaltyBox[size] = false;

        announce(playerName + " was added");
        announce("They are player number " + size);
        return true;
    }
    public void roll(int roll) {
        announce(players.get(currentPlayer) + " is the current player");
        announce("They have rolled a " + roll);

        if (inPenaltyBox[currentPlayer] && roll%2==0) {
            announce(players.get(currentPlayer) + " is not getting out of the penalty box");
            isGettingOutOfPenaltyBox = false;
        }
        else{
            if(inPenaltyBox[currentPlayer] && roll%2!=0){
                isGettingOutOfPenaltyBox = true;
                announce(players.get(currentPlayer) + " is getting out of the penalty box");
            }
            setPlaceAfterRoll(roll);
            announceAfterRoll();
            askQuestion();
        }
    }

    private void setPlaceAfterRoll(int roll){
        places[currentPlayer] = places[currentPlayer] + roll;
        if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;
    }

    private void askQuestion() {
        for(int i=0;i<Questions.size();i++){
            if(QuesType.get(i).equals(currentCategory())){
                announce(Questions.get(i).removeFirst());
            }
        }
    }
    private String currentCategory() {
        return QuesType.get(places[currentPlayer] % 4);
    }
    public boolean wasCorrectlyAnswered() {
        if(inPenaltyBox[currentPlayer] && !isGettingOutOfPenaltyBox){
            nextPlayer();
            return true;
        }
        else{
            purses[currentPlayer]++;
            announceAfterWin();
            boolean winner = didPlayerWin();
            nextPlayer();
            return winner;
        }
    }

    public void nextPlayer(){
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
    }
    public boolean wrongAnswer() {
        announce("Question was incorrectly answered");
        announce(players.get(currentPlayer) + " was sent to the penalty box");
        inPenaltyBox[currentPlayer] = true;

        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
        return true;
    }
    private boolean didPlayerWin() {
        return !(purses[currentPlayer] == 6);
    }
    protected void announce(Object message) {
        System.out.println(message);
    }

    protected void announceAfterRoll() {
        announce(players.get(currentPlayer) + "'s new location is " + places[currentPlayer]);
        announce("The category is " + currentCategory());
    }

    protected void announceAfterWin(){
        announce("Answer was correct!!!!");
        announce(players.get(currentPlayer) + " now has " + purses[currentPlayer] + " Gold Coins.");
    }
}