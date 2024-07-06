package io.github.orionlibs.orion_digital_twin_model.entity.thing;

import com.google.gson.annotations.SerializedName;
import io.github.orionlibs.core.abstraction.OrionInvalidatable;
import lombok.Getter;

//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
@Getter
//@Setter
public final class ThingModel implements OrionInvalidatable
{
    @SerializedName(ThingID.serialisedJSONName)
    private String thingID;
}
