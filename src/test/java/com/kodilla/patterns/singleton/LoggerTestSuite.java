package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {
    @Test
    public void testGetLastLog() {
        //Given
        Logger.getInstance().log("web.log.20131115.txt");

        //When
        String lastLog = Logger.getInstance().getLastLog();

        //Then
        Assert.assertEquals("web.log.20131115.txt", lastLog);
    }
}
