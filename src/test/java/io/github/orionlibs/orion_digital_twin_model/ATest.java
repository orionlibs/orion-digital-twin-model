package io.github.orionlibs.orion_digital_twin_model;

import java.util.TimeZone;

public class ATest
{
    static
    {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        System.setProperty("active.execution.profile", OrionDomain.testing);
    }
}
