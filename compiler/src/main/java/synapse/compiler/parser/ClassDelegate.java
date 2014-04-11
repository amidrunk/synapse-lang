package synapse.compiler.parser;

public interface ClassDelegate extends FieldDelegate {

    void complete();

    ReceptorDelegate beginReceptor(String receptorName);
}
