package io.github.orionlibs.orion_digital_twin_model.entity.thing.thing_model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.orionlibs.core.data.validation.InvalidFields;
import io.github.orionlibs.orion_digital_twin_model.ATest;
import io.github.orionlibs.orion_digital_twin_model.entity.InvalidODTMException;
import io.github.orionlibs.orion_digital_twin_model.entity.thing.ThingModel;
import io.github.orionlibs.orion_digital_twin_model.entity.thing.ThingService;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
//@Execution(ExecutionMode.CONCURRENT)
public class ThingModelTest extends ATest
{
    @Test
    void test_thingID_missing()
    {
        String sample = loadJSONTestResource("/ODTMSamples/missing-id.json");
        try
        {
            ThingModel actual = ThingService.buildThing(sample);
        }
        catch(InvalidODTMException e)
        {
            InvalidFields validationResult = (InvalidFields)e.getExceptionData();
            assertEquals(1, validationResult.getFields().size());
            assertEquals(Set.of("thingID"), validationResult.getFields());
        }
    }


    @Test
    void test_thingID_invalid()
    {
        String sample = loadJSONTestResource("/ODTMSamples/invalid-id.json");
        try
        {
            ThingModel actual = ThingService.buildThing(sample);
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
        String sample = loadJSONTestResource("/ODTMSamples/valid-id.json");
        ThingModel actual = ThingService.buildThing(sample);
        assertEquals("company1:system1:Thermostat", actual.getThingID());
    }
}
