package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.example.service.ConfigFileParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConfigFileParserTest {

    ConfigFileParser configFileParser;
    String okFile;
    String koFile;

    @BeforeEach
    void setUp() {
        configFileParser = new ConfigFileParser();
        okFile = "runtime {\n" +
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
        koFile =     	okFile = "runtime {\n" +
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
                "  }\n";
    }

    @Test
    public void validateFileTest() {
        assertThrows(Exception.class, ()->{
            configFileParser.validateFile(okFile);
        });
    }

    @Test
    public void getSEctionsTest() {
        assertNotNull(configFileParser.getSections(okFile));
    }

    @Test
    public void getKeysTest() {
        assertNotNull(configFileParser.getKeys(okFile));
    }

    @Test
    public void getFlagsTest() {
        assertNotNull(configFileParser.getFlags(okFile));
    }


}