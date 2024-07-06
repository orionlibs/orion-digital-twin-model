package io.github.orionlibs.orion_digital_twin_model.entity.thing;

import lombok.AllArgsConstructor;
import lombok.Getter;

//@NoArgsConstructor
@AllArgsConstructor
//@Builder
@Getter
//@Setter
final class ThingID
{
    public static final String serialisedJSONName = "@id";
    private String thingID;
}
