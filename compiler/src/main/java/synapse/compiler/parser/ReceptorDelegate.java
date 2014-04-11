package synapse.compiler.parser;

public interface ReceptorDelegate {

    void complete();

    PatternBuilder beginMessageFieldPattern();
}
