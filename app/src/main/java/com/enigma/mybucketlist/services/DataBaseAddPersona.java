package com.enigma.mybucketlist.services;

/**
 * Created by houcem on 27/11/16.
 */
public class DataBaseAddPersona {
    private static DataBaseAddPersona ourInstance = new DataBaseAddPersona();

    public static DataBaseAddPersona getInstance() {
        return ourInstance;
    }

    private DataBaseAddPersona() {
    }
}
