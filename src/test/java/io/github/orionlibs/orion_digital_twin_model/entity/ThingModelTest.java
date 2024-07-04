package io.github.orionlibs.orion_digital_twin_model.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    void test_thingID_invalid()
    {
        try
        {
            ThingService.buildThing("invalidID", "test:test:test", null, null, null, null);
        }
        catch(InvalidODTMException e)
        {
            InvalidFields validationResult = (InvalidFields)e.getExceptionData();
            assertEquals(1, validationResult.getFields().size());
            assertEquals(Set.of("thingID"), validationResult.getFields());
        }
    }


    @Test
    void test_thingID_valid() throws InvalidODTMException
    {
        ThingModel model = ThingService.buildThing("org.eclipse.ditto:smart-coffee-1", "test:test:test", null, null, null, null);
        assertNotNull(model);
        assertEquals("org.eclipse.ditto:smart-coffee-1", model.getThingID());
    }


    @Test
    void test_definition_invalid() throws Exception
    {
        try
        {
            ThingService.buildThing("org.eclipse.ditto:smart-coffee-1", "invalidID", null, null, null, null);
        }
        catch(InvalidODTMException e)
        {
            InvalidFields validationResult = (InvalidFields)e.getExceptionData();
            assertEquals(1, validationResult.getFields().size());
            assertEquals(Set.of("definition"), validationResult.getFields());
        }
    }


    @Test
    void test_definition_valid() throws Exception
    {
        ThingModel model = ThingService.buildThing("org.eclipse.ditto:smart-coffee-1", "test:test:test", null, null, null, null);
        assertEquals("test:test:test", model.getDefinition());
    }


    @Test
    void test_namespace() throws InvalidODTMException
    {
        ThingModel model = ThingService.buildThing("org.eclipse.ditto:smart-coffee-1", "test:test:test", null, null, null, null);
        assertNotNull(model);
        assertEquals("org.eclipse.ditto", model.get_namespace());
    }
}
