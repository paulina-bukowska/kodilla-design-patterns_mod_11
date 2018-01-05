package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {
    @Test
    public void testGetLastLogWhenOneLog() {
        //Given
        Logger.getInstance().log("web.log.20131115.txt");

        //When
        String lastLog = Logger.getInstance().getLastLog();

        //Then
        Assert.assertEquals("web.log.20131115.txt", lastLog);
    }

    @Test
    public void testGetLastLogWhenTwoLogs() {
        //Given
        Logger.getInstance().log("web.log.20131115.txt");
        Logger.getInstance().log("web.log.20131117.txt");

        //When
        String lastLog = Logger.getInstance().getLastLog();

        //Then
        Assert.assertEquals("web.log.20131117.txt", lastLog);
    }
}
