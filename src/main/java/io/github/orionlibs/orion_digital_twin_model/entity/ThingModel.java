package io.github.orionlibs.orion_digital_twin_model.entity;

import io.github.orionlibs.core.data.validation.annotation.WithRegEx;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ThingModel
{
    //Unique identifier representing the thing
    @WithRegEx("(?<ns>|(?:(?:[a-zA-Z]\\w*+)(?:[.-][a-zA-Z]\\w*+)*+)):(?<name>[^\\x00-\\x1F\\x7F-\\xFF/]++)")
    private String thingID;
    //Links to the ID of an existing Policy which contains the authorization information applied for this thing
    @WithRegEx("(?<ns>|(?:(?:[a-zA-Z]\\w*+)(?:[.-][a-zA-Z]\\w*+)*+)):(?<name>[^\\x00-\\x1F\\x7F-\\xFF/]++)")
    private String policyID;
    //The definition of this thing declaring its model in the form '::' or a valid HTTP(S) URL
    @WithRegEx(value = {"([_a-zA-Z0-9\\-.]+):([_a-zA-Z0-9\\-.]+):([_a-zA-Z0-9\\-.]+)",
                    "^((http|https)?:\\/\\/)"
                                    + "((([a-zA-Z\\d]([a-zA-Z\\d-]*[a-zA-Z\\d])*)\\.)+[a-zA-Z]{2,}|"
                                    + "((\\d{1,3}\\.){3}\\d{1,3}))"
                                    + "(\\:\\d+)?(\\/[-a-zA-Z\\d%_.~+]*)*"
                                    + "(\\?[;&a-zA-Z\\d%_.~+=-]*)?"
                                    + "(\\#[-a-zA-Z\\d_]*)?$"})
    private String definition;
    //The Attributes that describe this thing in more detail. Can be an arbitrary JSON object. Attributes are typically used to model rather static properties at the thing level. Static means that the values do not change as frequently as property values of Features
    private Object attributes;
    //The Features belonging to this thing. A thing can handle any number of Features. The key of this object represents the featureId
    private List<Feature> features;


    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    public static class Feature
    {
        private String featureID;
        //The definition of the Feature declaring its model, a list of Identifiers containing at least 1 Identifier in the form '::' or a valid HTTP(s) URL
        @WithRegEx(value = {"([_a-zA-Z0-9\\-.]+):([_a-zA-Z0-9\\-.]+):([_a-zA-Z0-9\\-.]+)",
                        "^((http|https)?:\\/\\/)"
                                        + "((([a-zA-Z\\d]([a-zA-Z\\d-]*[a-zA-Z\\d])*)\\.)+[a-zA-Z]{2,}|"
                                        + "((\\d{1,3}\\.){3}\\d{1,3}))"
                                        + "(\\:\\d+)?(\\/[-a-zA-Z\\d%_.~+]*)*"
                                        + "(\\?[;&a-zA-Z\\d%_.~+=-]*)?"
                                        + "(\\#[-a-zA-Z\\d_]*)?$"})
        private List<String> definition;
        //The data related to a Feature is managed in form of a list of properties. Each property itself can be either a simple/scalar value or a complex object. Allowed is any JSON object
        private Object properties;
        //The desired data related to a Feature is managed in form of a list of desired properties. Each desired property itself can be either a simple/scalar value or a complex object. Allowed is any JSON object
        private Object desiredProperties;
    }
}
