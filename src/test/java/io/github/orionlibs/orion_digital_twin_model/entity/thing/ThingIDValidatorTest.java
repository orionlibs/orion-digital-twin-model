package io.github.orionlibs.orion_digital_twin_model.entity.thing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.orionlibs.orion_digital_twin_model.ATest;
import io.github.orionlibs.orion_digital_twin_model.entity.InvalidODTMException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
//@Execution(ExecutionMode.CONCURRENT)
public class ThingIDValidatorTest extends ATest
{
    @Test
    void test_thingID_invalid()
    {
        ThingID thingID = new ThingID("invalidThingID");
        assertFalse(ThingIDValidator.isValid(thingID));
    }


    @Test
    void test_thingID_valid() throws InvalidODTMException
    {
        ThingID thingID = new ThingID("company1:system1:Thermostat");
        assertTrue(ThingIDValidator.isValid(thingID));
    }
}
