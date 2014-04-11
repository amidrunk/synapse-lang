package synapse.compiler.parser.model;

import synapse.lang.model.Field;

public final class SynapseFieldImpl implements Field {

    private final String name;

    private final String signature;

    public SynapseFieldImpl(String name, String signature) {
        assert name != null && !name.isEmpty() : "Field name can't be null or empty";
        assert signature != null && !signature.isEmpty() : "Field signature can't be null or empty";

        this.name = name;
        this.signature = signature;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSignature() {
        return signature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final SynapseFieldImpl that = (SynapseFieldImpl) o;

        if (!name.equals(that.name)) return false;
        if (!signature.equals(that.signature)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + signature.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "SynapseFieldImpl{" +
                "name='" + name + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}
