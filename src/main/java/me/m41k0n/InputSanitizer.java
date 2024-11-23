package me.m41k0n;

import java.util.Locale;

public class InputSanitizer {
    public static String sanitize(String vehicleType) {
        return vehicleType.toLowerCase(Locale.ROOT).replaceAll("\\s+", "");
    }
}