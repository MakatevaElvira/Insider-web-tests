package com.useinsider.web.utils;

import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class URLConverter implements Converter<URL> {
    @Override
    public URL convert(Method method, String input) {
        try {
            return new URL(input);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
