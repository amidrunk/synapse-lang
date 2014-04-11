package synapse.compiler.parser.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class SynapseFieldImplTest {

    private final SynapseFieldImpl exampleField = new SynapseFieldImpl("foo", "I");

    @Test
    public void constructorShouldNotAcceptNullOrEmptyName() {
        boolean failed;

        try {
            new SynapseFieldImpl(null, "I");
            failed = false;
        } catch (AssertionError e) {
            failed = true;
        }

        assertTrue(failed);

        try {
            new SynapseFieldImpl("", "I");
            failed = false;
        } catch (AssertionError e) {
            failed = true;
        }

        assertTrue(failed);
    }

    @Test
    public void constructorShouldNotAcceptNullOrEmptySignature() {
        boolean failed;

        try {
            new SynapseFieldImpl("foo", null);
            failed = false;
        } catch (AssertionError e) {
            failed = true;
        }

        assertTrue(failed);

        try {
            new SynapseFieldImpl("foo", "");
            failed = false;
        } catch (AssertionError e) {
            failed = true;
        }

        assertTrue(failed);
    }

    @Test
    public void constructorShouldRetainParameters() {
        assertEquals("foo", exampleField.getName());
        assertEquals("I", exampleField.getSignature());
    }

    @Test
    public void instanceShouldBeEqualToItSelf() {
        assertEquals(exampleField, exampleField);
    }

    @Test
    public void instanceShouldNotBeEqualToNullOrDifferentType() {
        assertNotEquals(exampleField, null);
        assertNotEquals(exampleField, "foo");
    }

    @Test
    public void instancesWithEqualPropertiesShouldBeEqual() {
        final SynapseFieldImpl other = new SynapseFieldImpl("foo", "I");

        assertEquals(exampleField, other);
        assertEquals(exampleField.hashCode(), other.hashCode());
    }

    @Test
    public void toStringValueShouldContainNameAndSignature() {
        assertThat(exampleField.toString(), containsString("foo"));
        assertThat(exampleField.toString(), containsString("I"));
    }

}
