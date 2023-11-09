public class SimpleBattleShipGame {

    public static void main(String[] args) {
        int numOfGuesses = 0;
        SimpleBattleShip ship = new SimpleBattleShip();
        GameHelper helper = new GameHelper();
        int randomShipPosition = (int) (Math.random() * 5);
        ship.setPosition(new int[]{randomShipPosition, randomShipPosition+1, randomShipPosition+2});
        boolean isAlive = true;
        while (isAlive) {
            int userGuess = helper.getInput("Enter a number");
            String result = ship.updateStatus(userGuess);
            numOfGuesses++;
            if (result.equals("kill")) {
                isAlive = false;
                System.out.println("You took " + numOfGuesses + " guesses");
            }
        }
    }
    
}