package org.wikipedia.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.*;

@LoadPolicy(Config.LoadType.MERGE)
@Sources({
        "classpath:${device_name}.properties",
        "classpath:samsung.properties",
        "classpath:pixel.properties"
})
public interface BrowserstackConfig extends Config {

    @Key("app")
    String getApp();

    @Key("device")
    String getDevice();

    @Key("version")
    String getVersion();

    @Key("project")
    String getProject();

    @Key("build")
    String getBuild();

    @Key("name")
    String getName();

    @Key("remoteUrl")
    String getRemoteUrl();

}
