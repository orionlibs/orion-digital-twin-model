package io.github.orionlibs.orion_digital_twin_model.entity.thing;

import io.github.orionlibs.core.data.validation.InvalidFields;
import io.github.orionlibs.orion_digital_twin_model.entity.InvalidODTMException;

public class ThingService
{
    public static ThingModel buildThing(String thingID, String definition, String name, String description,
                    String comment, Object attributes) throws InvalidODTMException
    {
        ThingModel model = new ThingModel(thingID, definition, name, description, comment, attributes);
        InvalidFields validationResult = ThingModelValidator.validate(model);
        if(validationResult.isEmpty())
        {
            return model;
        }
        else
        {
            throw new InvalidODTMException(validationResult);
        }
    }
}
