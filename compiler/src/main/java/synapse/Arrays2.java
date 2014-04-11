package synapse;

public final class Arrays2 {

    public static boolean containsNullElements(Object[] array) {
        assert array != null : "Array can't be null";

        for (Object element : array) {
            if (element == null) {
                return true;
            }
        }

        return false;
    }

}
