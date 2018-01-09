package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .rollWithSezam(false)
                .ingredient("grilled pineapple")
                .ingredient("crispy bacon")
                .burgers(2)
                .sauce("dijonnaise")
                .ingredient("whole leaf lettuce")
                .ingredient("jalapeños")
                .build();
        System.out.println(bigmac);

        //When
        int howManyIngredients = bigmac.getIngredients().size();
        String sauce = bigmac.getSauce();
        int howManyBurgers = bigmac.getBurgers();

        //Then
        Assert.assertEquals(4, howManyIngredients);
        Assert.assertTrue(bigmac.getIngredients().contains("grilled pineapple"));
        Assert.assertTrue(bigmac.getIngredients().contains("crispy bacon"));
        Assert.assertTrue(bigmac.getIngredients().contains("whole leaf lettuce"));
        Assert.assertEquals("dijonnaise", sauce);
        Assert.assertEquals(2, howManyBurgers);
        Assert.assertFalse(bigmac.isRollWithSezam());

    }
}
