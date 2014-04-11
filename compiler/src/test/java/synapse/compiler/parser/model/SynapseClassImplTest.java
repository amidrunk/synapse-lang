package synapse.compiler.parser.model;

import org.junit.Test;
import org.mockito.Mockito;
import synapse.lang.model.Field;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class SynapseClassImplTest {

    @Test(expected = AssertionError.class)
    public void constructorShouldNotAcceptNullClassName() {
        new SynapseClassImpl(null, new Field[0]);
    }

    @Test(expected = AssertionError.class)
    public void constructorShouldNotAcceptEmptyClassName() {
        new SynapseClassImpl("", new Field[0]);
    }

    @Test(expected = AssertionError.class)
    public void constructorShouldNotAcceptNullFields() {
        new SynapseClassImpl("foo", null);
    }

    @Test(expected = AssertionError.class)
    public void constructorShouldNotAcceptAnyNullFields() {
        new SynapseClassImpl("foo", new Field[]{null});
    }

    @Test
    public void constructorShouldRetainNameAndFields() {
        final Field field = mock(Field.class);
        final SynapseClassImpl clazz = new SynapseClassImpl("foo", new Field[]{field});

        assertEquals("foo", clazz.getName());
        assertArrayEquals(new Field[] { field }, clazz.getFields().toArray());
    }

}
