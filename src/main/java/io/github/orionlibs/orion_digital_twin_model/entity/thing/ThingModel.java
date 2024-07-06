package io.github.orionlibs.orion_digital_twin_model.entity.thing;

import com.google.gson.annotations.SerializedName;
import io.github.orionlibs.core.abstraction.OrionInvalidatable;
import io.github.orionlibs.core.data.validation.annotation.WithRegEx;
import lombok.Getter;

//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
@Getter
//@Setter
public class ThingModel implements OrionInvalidatable
{
    @WithRegEx("(?<ns>|(?:(?:[a-zA-Z]\\w*+)(?:[.-][a-zA-Z]\\w*+)*+)):(?<name>[^\\x00-\\x1F\\x7F-\\xFF/]++)")
    @SerializedName("@id")
    private String thingID;
}
