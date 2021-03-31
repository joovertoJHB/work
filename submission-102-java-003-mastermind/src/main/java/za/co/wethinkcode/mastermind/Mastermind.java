package za.co.wethinkcode.mastermind;

public class Mastermind {
    private final String code;
    private final Player player;

    public Mastermind(CodeGenerator generator, Player player){
        this.code = generator.generateCode();
        this.player = player;
    }
    public Mastermind(){
        this(new CodeGenerator(), new Player());
    }

    public void runGame(){
        System.out.printf("4-digit Code has been set. Digits in range 1 to 8. You have 12 turns to break it.\n");

        while ((player.getChances() >= 0)) {
            String guess = player.getGuess();
            int turns = player.getChances();
            player.setZero();    

            if (player.wantsToQuit()) {
                break;
            }

            String[] guessArray = guess.split("");

            for (int x = 0; x < 4; x++) {
                if (guess.charAt(x) == code.charAt(x)) {
                    player.increaseCorrectPlace();
                } else if (code.contains(guessArray[x])) {
                    player.increaseInCode();
                }
            }

            System.out.printf("Number of correct digits in correct place: "+player.setCorrectPlace()+"\n");
            System.out.printf("Number of correct digits not in correct place: "+player.setInCode()+"\n");

            if (player.setCorrectPlace()== 4) {
                System.out.printf("Congratulations! You are a codebreaker!\n");
                System.out.printf("The code was: "+code);
                break;
            } else {
                player.lostChance();
                if (turns == 0) {
                    System.out.printf("No more turns left.\n");
                    System.out.printf("The code was: "+code);
                    break;
                } else {
                    System.out.printf("Turns left: "+turns+"\n");
                }
            }

        }
    }

    public static void main(String[] args){
        Mastermind game = new Mastermind();
        game.runGame();
    }
}
