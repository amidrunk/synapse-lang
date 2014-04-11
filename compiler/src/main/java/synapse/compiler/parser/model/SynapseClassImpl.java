package synapse.compiler.parser.model;

import synapse.Arrays2;
import synapse.lang.model.Class;
import synapse.lang.model.Field;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public final class SynapseClassImpl implements Class {

    private final String name;

    private final List<Field> fields;

    public SynapseClassImpl(String name, Field[] fields) {
        assert name != null && !name.isEmpty() : "Class name can't be null or empty";
        assert fields != null && !Arrays2.containsNullElements(fields);

        this.name = name;
        this.fields = Arrays.asList(fields);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Collection<Field> getFields() {
        return fields;
    }
}
