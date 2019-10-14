package com.epam.codekata;

import org.junit.Assert;
import org.junit.Test;

public class JsonParserTest {
    @Test
    public void testKek(){
        JsonParser jsonParser = new JsonParser();
        for (int i = 0; i < 100; i++) {
            jsonParser.kek();

        }
        Assert.assertEquals(true, true);
        Assert.assertNotEquals(true, false);
    }
}
