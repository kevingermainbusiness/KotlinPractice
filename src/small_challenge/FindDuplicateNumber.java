package small_challenge;

import small_challenge.data.UserInput;

import java.util.*;

/**
 * I thank God I did a lotta research and trying before finding this solution myself
 *
 * @author Kevin Germain
 */
public class FindDuplicateNumber {

    public static void main(String[] args) {
        findDuplicateThroughScanner();
//        simpleDuplicateFindingAlgorithm();
    }

    private static void findDuplicateThroughScanner() {
        Scanner scanner = new Scanner(System.in);
        int countUserInput = 0;
        List<UserInput> mInputElements = new ArrayList<>();
        List<Integer> foundDuplicate = new ArrayList<>();
        System.out.print("Enter 5 numbers: ");
        while (countUserInput < 5) {
            int userInput = scanner.nextInt();
            mInputElements.add(new UserInput(userInput));
            countUserInput++;
        }

        for (int i = 0; i < mInputElements.size(); i++) {
            for (int j = i + 1; j < mInputElements.size(); j++) {
                if (mInputElements.get(i).getUserInput() == mInputElements.get(j).getUserInput()) {
                    foundDuplicate.add(mInputElements.get(i).getUserInput());
                }
            }
        }
        System.out.println("The duplicated numbers are: " + foundDuplicate);
    }

    private static void simpleDuplicateFindingAlgorithm() {
        int[] duplicatedList = new int[]{1, 2, 3, 3, 4, 4, 5, 5, 6};
        ArrayList<Integer> foundDuplicate = new ArrayList<>();
        for (int i = 0; i < duplicatedList.length; i++) {
            for (int j = i + 1; j < duplicatedList.length; j++) {
                if (duplicatedList[i] == duplicatedList[j]) {
                    foundDuplicate.add(i);
                }
            }
        }
        System.out.println(foundDuplicate);
    }
}
