package org.wikipedia.drivers;

import org.aeonbits.owner.ConfigFactory;
import org.wikipedia.config.AuthConfig;
import org.wikipedia.config.BrowserstackConfig;


public class ConfigDriver {

    private static final AuthConfig authConfig =
            ConfigFactory.create(
                    AuthConfig.class,
                    System.getProperties()
            );
    private static final BrowserstackConfig browserstackConfig =
            ConfigFactory.create(
                    BrowserstackConfig.class,
                    System.getProperties()
            );

    public static AuthConfig getAuthConfig() {

        return authConfig;

    }

    public static BrowserstackConfig getBrowserstackConfig() {

        return browserstackConfig;

    }

}
