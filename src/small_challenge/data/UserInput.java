package small_challenge.data;

/**
 * Created to track each input by a user through a Scanner object
 *
 * @author Kevin Germain
 */
public class UserInput {
    private final int userInput;

    public UserInput(int userInput) {
        this.userInput = userInput;
    }

    public int getUserInput() {
        return userInput;
    }

    @Override
    public String toString() {
        return "UserInput{" +
                "userInput=" + userInput +
                '}';
    }
}
