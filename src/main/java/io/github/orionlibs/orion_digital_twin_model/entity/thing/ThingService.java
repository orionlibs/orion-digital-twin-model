package io.github.orionlibs.orion_digital_twin_model.entity.thing;

import io.github.orionlibs.core.document.json.JSONService;
import io.github.orionlibs.orion_digital_twin_model.entity.InvalidODTMException;

public class ThingService
{
    public static ThingModel buildThing(String jsonLD) throws InvalidODTMException
    {
        ThingModel model = (ThingModel)JSONService.convertJSONToObject(jsonLD, ThingModel.class);
        ThingBuilder thingBuilder = new ThingBuilder(model);
        return thingBuilder.buildThing();
    }
}
