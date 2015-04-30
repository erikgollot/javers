package org.javers.core.examples;

import static org.fest.assertions.api.Assertions.assertThat;

import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.Diff;
import org.javers.core.metamodel.clazz.EntityDefinition;
import org.javers.core.model.ShouldUseRegisterAndNotIdObject;
import org.javers.core.model.ShouldUseRegisterAndNotIdObjectChild;
import org.junit.Test;

public class ShouldUseRegisterAndNotIdObjectTest {
	@Test
	public void shouldUseRegisterAndNotIdObject() {
		ShouldUseRegisterAndNotIdObjectChild o1 = new ShouldUseRegisterAndNotIdObjectChild(
				"Erik");
		o1.setId(1L);
		o1.setBusinessReference("ref1");

		ShouldUseRegisterAndNotIdObjectChild o2 = new ShouldUseRegisterAndNotIdObjectChild(
				"Alex");
		o2.setId(2L);
		o2.setBusinessReference("ref1");

		// Two objects have the same identity ref1 but one difference, the name.
		// They both have the same id but should not be taken into consideration
		JaversBuilder builder = JaversBuilder.javers();

		EntityDefinition def = new EntityDefinition(
				ShouldUseRegisterAndNotIdObject.class, "businessReference");

		Javers javers = builder.registerEntity(def).build();

		Diff diff = javers.compare(o1, o2);
		assertThat(diff.getChanges()).hasSize(1);
	}
}
