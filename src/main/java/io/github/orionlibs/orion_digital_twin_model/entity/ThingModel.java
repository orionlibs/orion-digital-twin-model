package io.github.orionlibs.orion_digital_twin_model.entity;

import io.github.orionlibs.core.data.validation.annotation.WithRegEx;
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
    @WithRegEx("(?<ns>|(?:(?:[a-zA-Z]\\w*+)(?:[.-][a-zA-Z]\\w*+)*+)):(?<name>[^\\x00-\\x1F\\x7F-\\xFF/]++)")
    private String id;
}
