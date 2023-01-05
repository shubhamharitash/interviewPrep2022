package ch12;

import java.util.Properties;

public class SystemDirs {
    public static void main(String[] args) {
        // Get current working directory
        System.out.println(System.getProperty("user.dir"));

        // Get temp directory
        System.out.println(System.getProperty("java.io.tmpdir"));

        // Get all system properties with dir
        Properties systemProperties = System.getProperties();
        for (String item : systemProperties.stringPropertyNames()) {
            if (item.contains("dir")) {
                System.out.println(item + ":" + System.getProperty(item));
            }
        }
    }
}