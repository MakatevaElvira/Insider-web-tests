package com.useinsider.web.config;

import okhttp3.HttpUrl;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigCache;

import static org.aeonbits.owner.Config.LoadType.MERGE;

public class UseinsiderFrontendUrlFactory {

    public static UseinsiderEnvironmentConfig env() {
        return ConfigCache.getOrCreate(UseinsiderEnvironmentConfig.class, System.getProperties(), System.getenv());
    }

    @Config.LoadPolicy(MERGE)
    @Config.Sources({"classpath:environment.properties.local", "classpath:environment.properties"})
    public interface UseinsiderEnvironmentConfig extends Config {
        @Config.ConverterClass(OkkHttpUrlConverter.class)
        @Config.Key("useinsider.frontend.url")
        @Config.DefaultValue("https://useinsider.com/")
        HttpUrl useinsiderFrontendUrl();
    }

    public static HttpUrl.Builder baseUrl() {
        return env().useinsiderFrontendUrl().newBuilder();
    }

    public static HttpUrl.Builder loginUrl() {
        return baseUrl().addPathSegment("login");
    }

    public static HttpUrl.Builder careersUrl() {
        return baseUrl().addPathSegment("careers");
    }

    public static HttpUrl.Builder openPositionsUrl() {
        return careersUrl().addPathSegment("open-positions");
    }

    public static HttpUrl.Builder openQaPositionsUrl() {
        return openPositionsUrl().fragment("?department=qualityassurance");
    }

    public static HttpUrl.Builder qualityAssuranceUrl() {
        return baseUrl().addPathSegment("quality-assurance");
    }

    public static HttpUrl.Builder resourcesUrl() {
        return baseUrl().addPathSegment("resources");
    }

}
