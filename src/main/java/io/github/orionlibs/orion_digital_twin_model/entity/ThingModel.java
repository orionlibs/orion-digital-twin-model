package io.github.orionlibs.orion_digital_twin_model.entity;

import io.github.orionlibs.core.abstraction.OrionInvalidatable;
import io.github.orionlibs.core.calendar.CalendarService;
import io.github.orionlibs.core.calendar.SQLTimestamp;
import io.github.orionlibs.core.data.validation.annotation.WithRegEx;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
@Getter
@Setter
public class ThingModel implements OrionInvalidatable
{
    ThingModel(String thingID, String definition, String name, String description, String comment, Object attributes)
    {
        this.thingID = thingID;
        this.definition = definition;
        this.name = name;
        this.description = description;
        this.comment = comment;
        this.attributes = attributes;
        this.revision = 0;
        this.creationDateTime = CalendarService.getCurrentDatetimeAsSQLTimestamp();
    }


    //Unique identifier representing the thing
    @WithRegEx("(?<ns>|(?:(?:[a-zA-Z]\\w*+)(?:[.-][a-zA-Z]\\w*+)*+)):(?<name>[^\\x00-\\x1F\\x7F-\\xFF/]++)")
    private String thingID;
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
    private String comment;
    private String description;
    private String name;
    private Integer revision;
    private SQLTimestamp creationDateTime;
    private SQLTimestamp lastRevisionDateTime;
    @Setter(AccessLevel.PRIVATE)
    private String _namespace;
    @Setter(AccessLevel.PRIVATE)
    private String _metadata;


    public String get_namespace()
    {
        if(this._namespace == null)
        {
            this._namespace = thingID.substring(0, thingID.indexOf(":"));
        }
        return this._namespace;
    }
}
