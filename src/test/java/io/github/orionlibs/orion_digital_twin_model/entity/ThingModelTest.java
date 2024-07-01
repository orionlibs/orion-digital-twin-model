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
                        .thingID("invalidID")
                        .policyID("org.eclipse.ditto:smart-coffee-1")
                        .definition("test:test:test")
                        .build();
        InvalidFields invalidFields = ThingModelValidator.validate(model);
        assertEquals(1, invalidFields.getFields().size());
        assertEquals(Set.of("thingID"), invalidFields.getFields());
    }


    @Test
    void test_id_valid() throws Exception
    {
        ThingModel model = ThingModel.builder()
                        .thingID("org.eclipse.ditto:smart-coffee-1")
                        .policyID("org.eclipse.ditto:smart-coffee-1")
                        .definition("test:test:test")
                        .build();
        InvalidFields invalidFields = ThingModelValidator.validate(model);
        assertEquals(0, invalidFields.getFields().size());
        model = ThingModel.builder()
                        .thingID("foo:bar")
                        .policyID("org.eclipse.ditto:smart-coffee-1")
                        .definition("test:test:test")
                        .build();
        invalidFields = ThingModelValidator.validate(model);
        assertEquals(0, invalidFields.getFields().size());
        model = ThingModel.builder()
                        .thingID("org.eclipse.ditto_42:smart-coffeee")
                        .policyID("org.eclipse.ditto:smart-coffee-1")
                        .definition("test:test:test")
                        .build();
        invalidFields = ThingModelValidator.validate(model);
        assertEquals(0, invalidFields.getFields().size());
        model = ThingModel.builder()
                        .thingID("com.some-domain.ditto-rocks:foobar")
                        .policyID("org.eclipse.ditto:smart-coffee-1")
                        .definition("test:test:test")
                        .build();
        invalidFields = ThingModelValidator.validate(model);
        assertEquals(0, invalidFields.getFields().size());
        model = ThingModel.builder()
                        .thingID("org.eclipse:admin-policy")
                        .policyID("org.eclipse.ditto:smart-coffee-1")
                        .definition("test:test:test")
                        .build();
        invalidFields = ThingModelValidator.validate(model);
        assertEquals(0, invalidFields.getFields().size());
        model = ThingModel.builder()
                        .thingID("org.eclipse:admin policy")
                        .policyID("org.eclipse.ditto:smart-coffee-1")
                        .definition("test:test:test")
                        .build();
        invalidFields = ThingModelValidator.validate(model);
        assertEquals(0, invalidFields.getFields().size());
    }


    @Test
    void test_policyID_invalid() throws Exception
    {
        ThingModel model = ThingModel.builder()
                        .thingID("org.eclipse.ditto:smart-coffee-1")
                        .policyID("invalidID")
                        .definition("test:test:test")
                        .build();
        InvalidFields invalidFields = ThingModelValidator.validate(model);
        assertEquals(1, invalidFields.getFields().size());
        assertEquals(Set.of("policyID"), invalidFields.getFields());
    }


    @Test
    void test_policyID_valid() throws Exception
    {
        ThingModel model = ThingModel.builder()
                        .thingID("org.eclipse.ditto:smart-coffee-1")
                        .policyID("org.eclipse.ditto:smart-coffee-1")
                        .definition("test:test:test")
                        .build();
        InvalidFields invalidFields = ThingModelValidator.validate(model);
        assertEquals(0, invalidFields.getFields().size());
        model = ThingModel.builder()
                        .thingID("foo:bar")
                        .policyID("foo:bar")
                        .definition("test:test:test")
                        .build();
        invalidFields = ThingModelValidator.validate(model);
        assertEquals(0, invalidFields.getFields().size());
        model = ThingModel.builder()
                        .thingID("org.eclipse.ditto_42:smart-coffeee")
                        .policyID("org.eclipse.ditto_42:smart-coffeee")
                        .definition("test:test:test")
                        .build();
        invalidFields = ThingModelValidator.validate(model);
        assertEquals(0, invalidFields.getFields().size());
        model = ThingModel.builder()
                        .thingID("com.some-domain.ditto-rocks:foobar")
                        .policyID("com.some-domain.ditto-rocks:foobar")
                        .definition("test:test:test")
                        .build();
        invalidFields = ThingModelValidator.validate(model);
        assertEquals(0, invalidFields.getFields().size());
        model = ThingModel.builder()
                        .thingID("org.eclipse:admin-policy")
                        .policyID("org.eclipse:admin-policy")
                        .definition("test:test:test")
                        .build();
        invalidFields = ThingModelValidator.validate(model);
        assertEquals(0, invalidFields.getFields().size());
        model = ThingModel.builder()
                        .thingID("org.eclipse:admin policy")
                        .policyID("org.eclipse:admin policy")
                        .definition("test:test:test")
                        .build();
        invalidFields = ThingModelValidator.validate(model);
        assertEquals(0, invalidFields.getFields().size());
    }


    @Test
    void test_definition_invalid() throws Exception
    {
        ThingModel model = ThingModel.builder()
                        .thingID("org.eclipse.ditto:smart-coffee-1")
                        .policyID("org.eclipse.ditto:smart-coffee-1")
                        .definition("invalidID")
                        .build();
        InvalidFields invalidFields = ThingModelValidator.validate(model);
        assertEquals(1, invalidFields.getFields().size());
        assertEquals(Set.of("definition"), invalidFields.getFields());
    }


    @Test
    void test_definition_valid() throws Exception
    {
        ThingModel model = ThingModel.builder()
                        .thingID("org.eclipse.ditto:smart-coffee-1")
                        .policyID("org.eclipse.ditto:smart-coffee-1")
                        .definition("test:test:test")
                        .build();
        InvalidFields invalidFields = ThingModelValidator.validate(model);
        assertEquals(0, invalidFields.getFields().size());
        model = ThingModel.builder()
                        .thingID("org.eclipse.ditto:smart-coffee-1")
                        .policyID("org.eclipse.ditto:smart-coffee-1")
                        .definition("https://example.com/definition")
                        .build();
        invalidFields = ThingModelValidator.validate(model);
        assertEquals(0, invalidFields.getFields().size());
    }
}
