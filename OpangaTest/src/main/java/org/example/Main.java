package org.example;

import org.example.service.ConfigFileParser;

import java.io.InputStream;

public class Main {

    public static void main(String[] args) {
//        String file =
//                "runtime {\n" +
//                "  key1 value1\n" +
//                "  key2 value2\n" +
//                "  flag1\n" +
//                "  system1 {\n" +
//                "     prop1 value1\n" +
//                "     prop2 value2\n" +
//                "     ports  1234 5678 9102 \n" +
//                "     subsystem1 {\n" +
//                "         prop3 value1 value2 value3\n" +
//                "         flag2\n" +
//                "      }\n" +
//                "  }\n" +
//                "}\n";

        String file =
                "runtime {\n" +
                        "  key1 value1\n" +
                        "  key2 value2\n" +
                        "  flag1\n" +
                        "  system1 {\n" +
                        "     prop1 value1\n" +
                        "     prop2 value2\n" +
                        "     ports  1234 5678 9102 \n" +
                        "     subsystem1 {\n" +
                        "         prop3 value1 value2 value3\n" +
                        "         flag2\n" +
                        "      }\n" +
                        "  }\n" +
                        "  system2 {\n" +
                        "     prop1 value1\n" +
                        "     prop2 value2\n" +
                        "     ports  1234 5678 9102 \n" +
                        "     subsystem2 {\n" +
                        "         prop3 value1 value2 value3\n" +
                        "         flag2\n" +
                        "      }\n" +
                        "  }\n" +
                        "}\n";

        ConfigFileParser configFileParser = new ConfigFileParser();
        configFileParser.getSections(file);
        
    }
}