package io.github.orionlibs.orion_digital_twin_model.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.github.orionlibs.core.data.validation.InvalidFields;
import io.github.orionlibs.orion_digital_twin_model.ATest;
import io.github.orionlibs.orion_digital_twin_model.entity.ThingModel.Feature;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
//@Execution(ExecutionMode.CONCURRENT)
public class ThingModelTest extends ATest
{
    @Test
    void test_thingID_invalid()
    {
        try
        {
            ThingService.buildThing("invalidID", "org.eclipse.ditto:smart-coffee-1", "test:test:test", null, null, null, null, null);
        }
        catch(InvalidODTMException e)
        {
            InvalidFields validationResult = (InvalidFields)e.getExceptionData();
            assertEquals(1, validationResult.getFields().size());
            assertEquals(Set.of("thingID"), validationResult.getFields());
        }
    }


    @Test
    void test_features_invalid()
    {
        Feature feature = new Feature("org.eclipse.ditto:smart-coffee-1", Arrays.asList("invalidDefinition"), null, null, null, null, null);
        List<Feature> features = Arrays.asList(feature);
        try
        {
            ThingService.buildThing("org.eclipse.ditto:smart-coffee-1", "org.eclipse.ditto:smart-coffee-1", "test:test:test", null, null, null, null, features);
        }
        catch(InvalidODTMException e)
        {
            InvalidFields validationResult = (InvalidFields)e.getExceptionData();
            assertEquals(1, validationResult.getFields().size());
            assertEquals(Set.of("features.definition"), validationResult.getFields());
        }
    }


    @Test
    void test_thingID_valid() throws InvalidODTMException
    {
        Feature feature = new Feature("org.eclipse.ditto:smart-coffee-1", Arrays.asList("org.eclipse.ditto:def:1"), null, null, null, null, null);
        List<Feature> features = Arrays.asList(feature);
        ThingModel model = ThingService.buildThing("org.eclipse.ditto:smart-coffee-1", "org.eclipse.ditto:smart-coffee-1", "test:test:test", null, null, null, null, features);
        assertNotNull(model);
        assertEquals("org.eclipse.ditto", model.get_namespace());
        /*model = ThingModel.builder()
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
        assertEquals(0, invalidFields.getFields().size());*/
    }


    /*@Test
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
    }*/
}
