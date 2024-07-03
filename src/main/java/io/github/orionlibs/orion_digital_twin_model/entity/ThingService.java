package io.github.orionlibs.orion_digital_twin_model.entity;

import io.github.orionlibs.core.data.validation.InvalidFields;
import io.github.orionlibs.orion_digital_twin_model.entity.ThingModel.Feature;
import java.util.List;

public class ThingService
{
    public static ThingModel buildThing(String thingID, String policyID, String definition, String name, String description,
                    String comment, Object attributes, List<Feature> features) throws InvalidODTMException
    {
        ThingModel model = new ThingModel(thingID, policyID, definition, name, description, comment, attributes, features);
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
