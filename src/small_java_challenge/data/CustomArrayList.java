package small_java_challenge.data;

/**
 * TODO Implement this class as an ArrayList
 *
 * @author Kevin Germain
 */
public class CustomArrayList<T> {

    private Element<T>[] elementsList;

    private int LIST_SIZE = 1;

    public CustomArrayList() {
        elementsList = new Element[LIST_SIZE];
    }

    public boolean add(T t) {
        return false;
    }

    public boolean edit(int position, T value) {
        return false;
    }

    public boolean remove(int position) {
        return false;
    }

    private void verifyElementsListSize() {

    }

    private static class Element<T> {
        private int position;
        private T data;

        public Element(int position, T data) {
            this.position = position;
            this.data = data;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}
