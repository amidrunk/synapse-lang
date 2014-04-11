package synapse.lang.model;

import java.util.Collection;

public interface Class extends Element {

    String getName();

    Collection<Field> getFields();

}
