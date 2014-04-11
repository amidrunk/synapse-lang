package synapse.compiler.parser.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import synapse.compiler.parser.ClassDelegate;
import synapse.compiler.parser.ParserDelegate;
import synapse.compiler.parser.PatternBuilder;
import synapse.compiler.parser.ReceptorDelegate;

import java.io.ByteArrayInputStream;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class JavaCCParserAdapterTest {

    private final ParserDelegate parserDelegate = mock(ParserDelegate.class);

    private final ClassDelegate classDelegate = mock(ClassDelegate.class);

    private final ReceptorDelegate receptorDelegate = mock(ReceptorDelegate.class);

    private final PatternBuilder patternDelegate = mock(PatternBuilder.class);

    @Before
    public void setup() {
        when(parserDelegate.beginClass(anyString())).thenReturn(classDelegate);
        when(classDelegate.beginReceptor(anyString())).thenReturn(receptorDelegate);
        when(receptorDelegate.beginMessageFieldPattern()).thenReturn(patternDelegate);
    }

    @Test
    public void emptyClassWithCanBeParsed() {
        parse("class MyClass() {}");

        final InOrder inOrder = Mockito.inOrder(parserDelegate, classDelegate);

        inOrder.verify(parserDelegate).beginClass(eq("MyClass"));
        inOrder.verify(classDelegate).complete();
    }

    @Test
    public void classWithSingleField() {
        parse("class MyClass(myField:String) {}");

        final InOrder inOrder = Mockito.inOrder(parserDelegate, classDelegate);

        inOrder.verify(parserDelegate).beginClass(eq("MyClass"));
        inOrder.verify(classDelegate).addField(eq("myField"), eq("String"));
        inOrder.verify(classDelegate).complete();
    }

    @Test
    public void classWithSingleDataLessReceptor() {
        parse("class MyClass() { test { => } }");

        final InOrder inOrder = Mockito.inOrder(parserDelegate, classDelegate, receptorDelegate);

        inOrder.verify(parserDelegate).beginClass(eq("MyClass"));
        inOrder.verify(classDelegate).beginReceptor(eq("test"));
        inOrder.verify(receptorDelegate).complete();
        inOrder.verify(classDelegate).complete();
    }

    @Test
    public void classWithSingleReceptorWithTypedMessageFieldBoundToVariable() {
        parse("class MyClass() { test { foo:int =>} }");

        final InOrder inOrder = Mockito.inOrder(parserDelegate, classDelegate, receptorDelegate, patternDelegate);

        inOrder.verify(parserDelegate).beginClass(eq("MyClass"));
        inOrder.verify(classDelegate).beginReceptor(eq("test"));
        inOrder.verify(receptorDelegate).beginMessageFieldPattern();
        inOrder.verify(patternDelegate).typedVariable(eq("foo"), eq("int"));
        inOrder.verify(receptorDelegate).complete();
        inOrder.verify(classDelegate).complete();
    }

    @SuppressWarnings("unchecked")
    protected void parse(String code) {
        try {
            new JavaCCParserAdapter().parse(parserDelegate, new ByteArrayInputStream(code.getBytes()), "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}