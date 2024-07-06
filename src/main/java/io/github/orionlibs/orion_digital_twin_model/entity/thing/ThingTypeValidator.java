package io.github.orionlibs.orion_digital_twin_model.entity.thing;

class ThingTypeValidator
{
    static boolean isValid(ThingType thingType)
    {
        if(thingType.getType() == null || thingType.getType().isEmpty())
        {
            return false;
        }
        else
        {
            for(String type : thingType.getType())
            {
                if(type == null || type.isEmpty())
                {
                    return false;
                }
            }
        }
        return true;
    }


    static boolean isInvalid(ThingType thingType)
    {
        return !isValid(thingType);
    }
}
