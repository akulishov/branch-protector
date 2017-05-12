package com.censhare.utils;

/**
 * Created by oku-ext on 5/12/17.
 */
public enum BuildStatus {
    SUCCESS, DANGER;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
