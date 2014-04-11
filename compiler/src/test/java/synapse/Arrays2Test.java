package synapse;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Arrays2Test {

    @Test(expected = AssertionError.class)
    public void containsNullElementsShouldNotAcceptNullArray() {
        Arrays2.containsNullElements(null);
    }

    @Test
    public void containsNullElementsShouldReturnFalseForEmptyArray() {
        assertFalse(Arrays2.containsNullElements(new Object[]{}));
    }

    @Test
    public void containsNullElementShouldReturnFalseIfArrayContainsNoNullElements() {
        assertFalse(Arrays2.containsNullElements(new Object[]{"foo"}));
        assertFalse(Arrays2.containsNullElements(new Object[]{"foo", "bar"}));
        assertFalse(Arrays2.containsNullElements(new Object[]{"foo", "bar", "baz"}));
    }

    @Test
    public void containsNullElementsShouldReturnTrueIfArrayContainsNullElements() {
        assertTrue(Arrays2.containsNullElements(new Object[]{"foo", null}));
        assertTrue(Arrays2.containsNullElements(new Object[]{null, "foo"}));
        assertTrue(Arrays2.containsNullElements(new Object[]{null, "foo", "bar"}));
        assertTrue(Arrays2.containsNullElements(new Object[]{"foo", "bar", null}));
    }

}
