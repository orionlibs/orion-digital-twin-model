package io.github.orionlibs.orion_digital_twin_model.entity;

import io.github.orionlibs.core.data.validation.InvalidFields;
import io.github.orionlibs.core.data.validation.ValidationService;

public class ThingModelValidator
{
    public static InvalidFields validate(ThingModel thing)
    {
        return ValidationService.validateObjectAndGetInvalidInstanceVariables(thing);
    }
}
