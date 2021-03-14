package small_java_challenge;

import small_java_challenge.data.CustomHashMap2;
import java.util.Arrays;
import java.util.HashMap;

public class TestRun {

    public static void main(String[] args) {
        CustomHashMap2<String, Integer> customHashMap2 = new CustomHashMap2<>();
        customHashMap2.put("A", 21);
        customHashMap2.put("B", 41);
        customHashMap2.put("C", 51);
        customHashMap2.put("D", 61);
        customHashMap2.put("E", 71);

        String originalMapEntries = Arrays.toString(customHashMap2.getEntriesTable());

        System.out.println("The original entries: " + originalMapEntries);
        System.out.println("Let's get the KEY A's value: " + customHashMap2.get("A"));
        System.out.println("Removed: " + customHashMap2.remove("A"));

        String mapEntriesAfterRemoval = Arrays.toString(customHashMap2.getEntriesTable());

        System.out.println("Entries after removal of key D: " + mapEntriesAfterRemoval);
        System.out.println(customHashMap2.getMapSize());

    }
}
