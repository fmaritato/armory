package com.maritatf.wow.value;
/**
 * @author fmaritato
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import java.io.IOException;

public class PopulationEnumDeserializer extends JsonDeserializer<PopulationEnum> {

    private static transient Log log = LogFactory.getLog(PopulationEnumDeserializer.class);

    @Override
    public PopulationEnum deserialize(JsonParser jsonParser,
                                      DeserializationContext deserializationContext)
        throws IOException, JsonProcessingException {

        return PopulationEnum.getValue(jsonParser.getText());
    }
}
