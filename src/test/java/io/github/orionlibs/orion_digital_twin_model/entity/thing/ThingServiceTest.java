package io.github.orionlibs.orion_digital_twin_model.entity.thing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.orionlibs.core.data.validation.InvalidFields;
import io.github.orionlibs.orion_digital_twin_model.ATest;
import io.github.orionlibs.orion_digital_twin_model.entity.InvalidODTMException;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
//@Execution(ExecutionMode.CONCURRENT)
public class ThingServiceTest extends ATest
{
    @Test
    void test_validator_throws_error()
    {
        String sample = loadJSONTestResource("/ODTMSamples/missing-id.json");
        try
        {
            ThingModel actual = ThingService.buildThing(sample);
        }
        catch(InvalidODTMException e)
        {
            InvalidFields validationResult = (InvalidFields)e.getExceptionData();
            assertEquals(2, validationResult.getFields().size());
            assertEquals(Set.of(ThingID.serialisedJSONName, ThingType.serialisedJSONName), validationResult.getFields());
        }
    }


    @Test
    void test_validator_succeeds() throws InvalidODTMException
    {
        String sample = loadJSONTestResource("/ODTMSamples/valid-fields.json");
        ThingModel actual = ThingService.buildThing(sample);
        assertEquals("company1:system1:Thermostat", actual.getThingID());
    }
}
