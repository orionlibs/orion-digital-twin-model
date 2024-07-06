package io.github.orionlibs.orion_digital_twin_model.entity.thing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.orionlibs.orion_digital_twin_model.ATest;
import io.github.orionlibs.orion_digital_twin_model.entity.InvalidODTMException;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
//@Execution(ExecutionMode.CONCURRENT)
public class ThingTypeValidatorTest extends ATest
{
    @Test
    void test_type_invalid()
    {
        ThingType thingType = new ThingType(null);
        assertFalse(ThingTypeValidator.isValid(thingType));
        thingType = new ThingType(Arrays.asList(""));
        assertFalse(ThingTypeValidator.isValid(thingType));
    }


    @Test
    void test_type_valid() throws InvalidODTMException
    {
        ThingType thingType = new ThingType(Arrays.asList("thermostat"));
        assertTrue(ThingTypeValidator.isValid(thingType));
        thingType = new ThingType(Arrays.asList("thermostat", "lamp"));
        assertTrue(ThingTypeValidator.isValid(thingType));
    }
}
