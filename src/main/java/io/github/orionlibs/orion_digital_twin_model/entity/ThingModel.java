package io.github.orionlibs.orion_digital_twin_model.entity;

import io.github.orionlibs.core.abstraction.OrionInvalidatable;
import io.github.orionlibs.core.data.validation.annotation.NotBlank;
import io.github.orionlibs.core.data.validation.annotation.WithRegEx;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
@Getter
@Setter
public class ThingModel
{
    ThingModel(String thingID, String policyID, String definition, String name, String description,
                    String comment, Object attributes, List<Feature> features)
    {
        this.thingID = thingID;
        this.policyID = policyID;
        this.definition = definition;
        this.name = name;
        this.description = description;
        this.comment = comment;
        this.attributes = attributes;
        this.features = features;
    }


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
    private String comment;
    private String description;
    private String name;
    @Setter(AccessLevel.PRIVATE)
    private String _namespace;


    public String get_namespace()
    {
        if(this._namespace == null)
        {
            this._namespace = thingID.substring(0, thingID.indexOf(":"));
        }
        return this._namespace;
    }


    //@NoArgsConstructor
    //@AllArgsConstructor
    //@Builder
    @Getter
    @Setter
    public static class Feature implements OrionInvalidatable
    {
        Feature(String featureID, List<String> definition, String name, String description,
                        String comment, Object properties, Object desiredProperties)
        {
            this.featureID = featureID;
            this.definition = definition;
            this.name = name;
            this.description = description;
            this.comment = comment;
            this.properties = properties;
            this.desiredProperties = desiredProperties;
        }


        @NotBlank
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
        private String comment;
        private String description;
        private String name;
    }
}
