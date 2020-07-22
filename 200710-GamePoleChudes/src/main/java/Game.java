public class Game {

        private Word word;
        private int balance;
        private int attempts;
        private int delta = 5;
        private int winKoef = 10;
        private int looseKoef = 5;
        private int totalAttemptsAllowed = 5;

        public int getBalance() {
            return balance;
        }

        public int getAttempts() {
            return attempts;
        }

        public void startGame(String w, String d) {
            word = new Word(w, d);
        }

        public void openLetter(char letter) {

            if (!isLost()) {
                int match = word.openLetter(letter);
                if (match == 0) balance -= delta;
                else
                    balance += match * delta;
                attempts++;
            }
        }

        public boolean isLost(){
            if (attempts < totalAttemptsAllowed){
                return false;
            }
            System.out.println("Too many attempts. Game over!");
            return true;
        }

        public boolean isWin() {
            return word.isWin();
        }

        public void openWord(String w) throws WrongWordLengthException {
            if (!isLost()){
                if (word.openWord(w) == true) balance += delta * winKoef;
                else balance -= delta * looseKoef;
                attempts++;
            }
        }
}

// Home work
// parameterized test + rewrite all tests to JUnit 5 + attempts limitation logic
