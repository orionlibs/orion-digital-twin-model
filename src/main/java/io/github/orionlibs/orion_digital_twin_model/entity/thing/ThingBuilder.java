package io.github.orionlibs.orion_digital_twin_model.entity.thing;

import io.github.orionlibs.core.data.validation.InvalidFields;
import io.github.orionlibs.orion_digital_twin_model.entity.InvalidODTMException;

class ThingBuilder
{
    private InvalidFields invalidFields;
    private ThingModel model;


    public ThingBuilder(ThingModel model)
    {
        this.invalidFields = InvalidFields.of();
        this.model = model;
    }


    public ThingModel buildThing() throws InvalidODTMException
    {
        validateThingID();
        if(invalidFields.isEmpty())
        {
            return model;
        }
        else
        {
            throw new InvalidODTMException(invalidFields);
        }
    }


    private void validateThingID()
    {
        ThingID thingID = new ThingID(model.getThingID());
        if(ThingIDValidator.isInvalid(thingID))
        {
            invalidFields.addField(ThingID.serialisedJSONName);
        }
    }
}
