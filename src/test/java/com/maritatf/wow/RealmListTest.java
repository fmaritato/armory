package com.maritatf.wow;
/**
 * @author fmaritato
 */

import com.maritatf.wow.value.PopulationEnum;
import com.maritatf.wow.value.PopulationEnumDeserializer;
import com.maritatf.wow.value.RealmList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RealmListTest {
    private static transient Log log = LogFactory.getLog(RealmListTest.class);

    @Test
    public void testRealmList() throws IOException {
        String input = "{\n" +
                       "  \"realms\":[\n" +
                       "    {\n" +
                       "      \"type\":\"pve\",\n" +
                       "      \"population\":\"medium\",\n" +
                       "      \"queue\":false,\n" +
                       "      \"status\":true,\n" +
                       "      \"name\":\"Azjol-Nerub\",\n" +
                       "      \"slug\":\"azjolnerub\"\n" +
                       "    }\n" +
                       "  ]\n" +
                       "}";

        ObjectMapper objectMapper = new ObjectMapper();

        SimpleModule testModule = new SimpleModule("PopulationEnumModule",
                                                   new Version(1, 0, 0, null))
            .addDeserializer(PopulationEnum.class, new PopulationEnumDeserializer());
        objectMapper.registerModule(testModule);

        RealmList realms = objectMapper.readValue(input, RealmList.class);
        assertNotNull(realms);
        assertEquals(1, realms.getRealms().size());
    }

    @Test
    public void testNaPopulation() throws IOException {
        String input = "{\n" +
                       "  \"realms\":[\n" +
                       "    {\n" +
                       "      \"type\":\"pve\",\n" +
                       "      \"population\":\"n/a\",\n" +
                       "      \"queue\":false,\n" +
                       "      \"status\":true,\n" +
                       "      \"name\":\"Azjol-Nerub\",\n" +
                       "      \"slug\":\"azjolnerub\"\n" +
                       "    }\n" +
                       "  ]\n" +
                       "}";

        ObjectMapper objectMapper = new ObjectMapper();

        SimpleModule testModule = new SimpleModule("PopulationEnumModule",
                                                   new Version(1, 0, 0, null))
            .addDeserializer(PopulationEnum.class, new PopulationEnumDeserializer());
        objectMapper.registerModule(testModule);

        RealmList realms = objectMapper.readValue(input, RealmList.class);
        assertNotNull(realms);
        assertEquals(1, realms.getRealms().size());
    }
}
