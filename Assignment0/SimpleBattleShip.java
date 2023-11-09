public class SimpleBattleShip {

    int[] shipCoordinates;
    int numOfHits = 0;

    public void setPosition(int[] coords) {
        this.shipCoordinates = coords;
    }

    public String updateStatus(int guess) {
        String result = "miss";

        for (int i = 0; i < this.shipCoordinates.length; i++) {
            if (guess == shipCoordinates[i]) {
                result = "hit";
                shipCoordinates[i] = -1;
                this.numOfHits++;
                break;
            }
        }

        if (this.numOfHits == this.shipCoordinates.length) {
            result = "kill";
        }

        System.out.println(result);
        return result;
    }
    
}
