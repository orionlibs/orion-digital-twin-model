package io.github.orionlibs.orion_digital_twin_model.entity.thing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.orionlibs.core.data.validation.InvalidFields;
import io.github.orionlibs.core.document.json.JSONService;
import io.github.orionlibs.orion_digital_twin_model.ATest;
import io.github.orionlibs.orion_digital_twin_model.entity.InvalidODTMException;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
//@Execution(ExecutionMode.CONCURRENT)
public class ThingBuilderTest extends ATest
{
    @Test
    void test_validator_throws_error()
    {
        String sample = loadJSONTestResource("/ODTMSamples/missing-id.json");
        ThingModel model = (ThingModel)JSONService.convertJSONToObject(sample, ThingModel.class);
        ThingBuilder thingBuilder = new ThingBuilder(model);
        try
        {
            model = thingBuilder.buildThing();
        }
        catch(InvalidODTMException e)
        {
            InvalidFields validationResult = (InvalidFields)e.getExceptionData();
            assertEquals(1, validationResult.getFields().size());
            assertEquals(Set.of(ThingID.serialisedJSONName), validationResult.getFields());
        }
    }


    @Test
    void test_validator_succeeds() throws InvalidODTMException
    {
        String sample = loadJSONTestResource("/ODTMSamples/valid-id.json");
        ThingModel model = (ThingModel)JSONService.convertJSONToObject(sample, ThingModel.class);
        ThingBuilder thingBuilder = new ThingBuilder(model);
        model = thingBuilder.buildThing();
        assertEquals("company1:system1:Thermostat", model.getThingID());
    }
}
