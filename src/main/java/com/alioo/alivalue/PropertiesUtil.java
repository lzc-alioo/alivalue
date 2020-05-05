package com.alioo.alivalue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.MissingResourceException;

/**
 * Parsing The Configuration File
 *
 * @author ShenHuaJie
 * @version 2016年7月30日 下午11:41:53
 */
@Component
public class PropertiesUtil {

    @Autowired
    private Environment env;
    /**
     * Get a value based on key , if key does not exist , null is returned
     *
     * @param key
     * @return
     */
    public String getString(String key) {
        try {
            return env.getProperty(key);
        } catch (MissingResourceException e) {
            return null;
        }
    }
}