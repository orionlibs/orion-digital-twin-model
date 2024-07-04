package io.github.orionlibs.orion_digital_twin_model.entity.thing;

import io.github.orionlibs.core.data.validation.InvalidFields;
import io.github.orionlibs.core.data.validation.ValidationService;

public class ThingModelValidator
{
    static InvalidFields validate(ThingModel thing)
    {
        return ValidationService.validateObjectAndGetInvalidInstanceVariables(thing);
    }


    static boolean isValid(ThingModel thing)
    {
        return ValidationService.isObjectValid(thing);
    }
}
