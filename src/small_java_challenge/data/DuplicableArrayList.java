package small_java_challenge.data;


import java.util.ArrayList;
import java.util.HashSet;

/**
 * This custom ArrayList should be able to allow duplicates or not allow duplicates
 * Created by Kevin Germain
 */
public class DuplicableArrayList<E> extends ArrayList<E> {

    // used to track whether a user wants duplicates or not
    public boolean allowDuplicates;

    // Used to verify presence of a duplicate
    public HashSet<Object> mHashSet = new HashSet<>();

    public DuplicableArrayList(boolean allowDuplicates) {
        this.allowDuplicates = allowDuplicates;
    }

    @Override
    public boolean add(E e) {
        // if the user don't allow duplicates & trying to add e to the hashSet returns false
        // else if duplicates are allowed then even if there is a duplicate, add it anyways
        if (!allowDuplicates && !mHashSet.add(e)) {
            throw new IllegalArgumentException("No duplicates are allowed to be added");
        } else if (allowDuplicates && !mHashSet.add(e)) {
            return super.add(e);
        } else return super.add(e);
    }
}
