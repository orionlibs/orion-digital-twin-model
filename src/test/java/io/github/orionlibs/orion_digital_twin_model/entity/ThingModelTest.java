package io.github.orionlibs.orion_digital_twin_model.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.orionlibs.core.data.validation.InvalidFields;
import io.github.orionlibs.orion_digital_twin_model.ATest;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
//@Execution(ExecutionMode.CONCURRENT)
public class ThingModelTest extends ATest
{
    @Test
    void test_id_invalid() throws Exception
    {
        ThingModel model = ThingModel.builder()
                        .id("invalidID")
                        .build();
        InvalidFields invalidFields = ThingModelValidator.validate(model);
        assertEquals(1, invalidFields.getFields().size());
        assertEquals(Set.of("id"), invalidFields.getFields());
    }


    @Test
    void test_id_valid() throws Exception
    {
        ThingModel model = ThingModel.builder()
                        .id("org.eclipse.ditto:smart-coffee-1")
                        .build();
        InvalidFields invalidFields = ThingModelValidator.validate(model);
        assertEquals(0, invalidFields.getFields().size());
        model = ThingModel.builder()
                        .id("foo:bar")
                        .build();
        invalidFields = ThingModelValidator.validate(model);
        assertEquals(0, invalidFields.getFields().size());
        model = ThingModel.builder()
                        .id("org.eclipse.ditto_42:smart-coffeee")
                        .build();
        invalidFields = ThingModelValidator.validate(model);
        assertEquals(0, invalidFields.getFields().size());
        model = ThingModel.builder()
                        .id("com.some-domain.ditto-rocks:foobar")
                        .build();
        invalidFields = ThingModelValidator.validate(model);
        assertEquals(0, invalidFields.getFields().size());
        model = ThingModel.builder()
                        .id("org.eclipse:admin-policy")
                        .build();
        invalidFields = ThingModelValidator.validate(model);
        assertEquals(0, invalidFields.getFields().size());
        model = ThingModel.builder()
                        .id("org.eclipse:admin policy")
                        .build();
        invalidFields = ThingModelValidator.validate(model);
        assertEquals(0, invalidFields.getFields().size());
    }
}
