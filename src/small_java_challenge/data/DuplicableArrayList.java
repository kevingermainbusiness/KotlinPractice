package small_java_challenge.data;


import java.util.ArrayList;
import java.util.HashSet;

/**
 * This custom ArrayList should be able to allow duplicates or not allow duplicates
 * <p>
 * If you set [allowDuplicates] to true, you can only get data by colling for HashSet.contains(element)
 * If not you can use the common get(int index) from ArrayList
 *
 * @author Kevin Germain
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
        if (!allowDuplicates && !mHashSet.add(e)) {
            return false;
        } else if (!allowDuplicates && mHashSet.add(e)) {
            return mHashSet.add(e);
        } else return super.add(e);
    }
}
