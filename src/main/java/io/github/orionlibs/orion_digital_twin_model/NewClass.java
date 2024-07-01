package io.github.orionlibs.orion_digital_twin_model;

import io.github.orionlibs.orion_digital_twin_model.config.ConfigurationService;
import io.github.orionlibs.orion_digital_twin_model.config.OrionConfiguration;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Handler;
import java.util.logging.Logger;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NewClass
{
    private final static Logger log;
    private OrionConfiguration featureConfiguration;

    static
    {
        log = Logger.getLogger(NewClass.class.getName());
    }

    public NewClass(final Properties customConfig) throws IOException
    {
        this.featureConfiguration = OrionConfiguration.loadFeatureConfiguration(customConfig);
        ConfigurationService.registerConfiguration(featureConfiguration);
    }


    static void addLogHandler(Handler handler)
    {
        log.addHandler(handler);
    }


    static void removeLogHandler(Handler handler)
    {
        log.removeHandler(handler);
    }


    public static void test()
    {
        log.info("hello world");
    }
}
