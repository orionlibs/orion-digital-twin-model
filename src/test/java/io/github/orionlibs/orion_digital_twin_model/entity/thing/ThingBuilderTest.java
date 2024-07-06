package io.github.orionlibs.orion_digital_twin_model.entity.thing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.orionlibs.core.data.validation.InvalidFields;
import io.github.orionlibs.core.document.json.JSONService;
import io.github.orionlibs.orion_digital_twin_model.ATest;
import io.github.orionlibs.orion_digital_twin_model.entity.InvalidODTMException;
import java.util.Arrays;
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
        String sample = loadJSONTestResource("/ODTMSamples/invalid-fields.json");
        ThingModel model = (ThingModel)JSONService.convertJSONToObject(sample, ThingModel.class);
        ThingBuilder thingBuilder = new ThingBuilder(model);
        try
        {
            model = thingBuilder.buildThing();
        }
        catch(InvalidODTMException e)
        {
            InvalidFields validationResult = (InvalidFields)e.getExceptionData();
            assertEquals(2, validationResult.getFields().size());
            assertEquals(Set.of(ThingID.serialisedJSONName, ThingType.serialisedJSONName), validationResult.getFields());
        }
    }


    @Test
    void test_validator_throws_error_for_fields()
    {
        String sample = loadJSONTestResource("/ODTMSamples/invalid-fields.json");
        ThingModel model = (ThingModel)JSONService.convertJSONToObject(sample, ThingModel.class);
        ThingBuilder thingBuilder = new ThingBuilder(model);
        try
        {
            model = thingBuilder.buildThing();
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
        ThingModel model = (ThingModel)JSONService.convertJSONToObject(sample, ThingModel.class);
        ThingBuilder thingBuilder = new ThingBuilder(model);
        model = thingBuilder.buildThing();
        assertEquals("company1:system1:Thermostat", model.getThingID());
        assertEquals(Arrays.asList("thermostat", "lamp"), model.getType());
    }
}
