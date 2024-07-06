package io.github.orionlibs.orion_digital_twin_model.entity.thing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.orionlibs.orion_digital_twin_model.ATest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
//@Execution(ExecutionMode.CONCURRENT)
public class ThingIDTest extends ATest
{
    @Test
    void test_thingID()
    {
        ThingID thingID = new ThingID("someThingID");
        assertEquals("someThingID", thingID.getThingID());
    }
}
