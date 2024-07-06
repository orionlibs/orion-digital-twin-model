package io.github.orionlibs.orion_digital_twin_model.entity.thing;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

//@NoArgsConstructor
@AllArgsConstructor
//@Builder
@Getter
//@Setter
final class ThingType
{
    public static final String serialisedJSONName = "@type";
    private List<String> type;
}
