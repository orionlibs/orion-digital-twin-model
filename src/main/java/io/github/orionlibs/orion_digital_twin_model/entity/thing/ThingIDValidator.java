package io.github.orionlibs.orion_digital_twin_model.entity.thing;

import io.github.orionlibs.orion_digital_twin_model.config.ConfigurationService;
import java.util.regex.Pattern;

class ThingIDValidator
{
    private static final String regexPattern = ConfigurationService.getProp("thing.id.regex");


    static boolean isValid(ThingID thingID)
    {
        if(thingID.getThingID() == null)
        {
            return false;
        }
        else
        {
            Pattern matcher = Pattern.compile(regexPattern);
            if(matcher.matcher(thingID.getThingID()).matches())
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }


    static boolean isInvalid(ThingID thingID)
    {
        return !isValid(thingID);
    }
}
