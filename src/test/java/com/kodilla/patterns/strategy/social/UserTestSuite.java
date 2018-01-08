package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User natanaele = new ZGeneration("Natanaele Consolata");
        User cornelis = new YGeneration("Cornelis Shariah");
        User victoire = new Millenials("Victoire Crescencia");

        //When
        String natanaeleShare = natanaele.sharePost();
        String cornelisShare = cornelis.sharePost();
        String victoireShare = victoire.sharePost();

        //Then
        Assert.assertEquals("Facebook", natanaeleShare);
        Assert.assertEquals("Twitter", cornelisShare);
        Assert.assertEquals("Snapchat", victoireShare);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User natanaele = new ZGeneration("Natanaele Consolata");

        //When
        String natanaeleShare = natanaele.sharePost();
        natanaele.setSocialPublisher(new TwitterPublisher());
        String natanaeleNewShare = natanaele.sharePost();

        //Then
        Assert.assertTrue(natanaeleShare != natanaeleNewShare);
        Assert.assertFalse(natanaeleShare == natanaeleNewShare);
        Assert.assertEquals("Facebook", natanaeleShare);
        Assert.assertEquals("Twitter", natanaeleNewShare);
    }
}
