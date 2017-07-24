package org.umasankar.jpmsample.utils;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Umasankar on 7/23/17.
 */
public class FakeMessageBuilder {

    private static final String SalesTemplate =
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\" ?>\n" +
                    "<Sales>\n" +
                    "    <product>{product}</product>\n" +
                    "    <quantity>{quantity}</quantity>\n" +
                    "    <price>{price}</price>\n" +
                    "</Sales>";

    private static final String AdjTemplate =
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\" ?>\n" +
                    "<Adjustment>\n" +
                    "    <product>{product}</product>\n" +
                    "    <amount>{amount}</amount>\n" +
                    "    <operation>{operation}</operation>\n" +
                    "</Adjustment>";

    private static String[] Products = { "APPLE", "ORANGE", "GRAPE", "BANANA" };
    private static int[] Prices = { 100, 80, 120, 60 };
    private static String[] AdjOps = {"add", "sub", "mul"};

    private static final Random RANDOM = new Random();

    public static String buildMessage() {
        if (RANDOM.nextBoolean()) {
            //Sales Message
            int prodIndex = RANDOM.nextInt(4);
            return SalesTemplate
                    .replace("{product}", Products[prodIndex])
                    .replace("{quantity}", ""+RANDOM.nextInt(20))
                    .replace("{price}", ""+(RANDOM.nextDouble() * 5 + Prices[prodIndex]));
        } else {
            //Adj Message
            int prodIndex = RANDOM.nextInt(4);
            return AdjTemplate
                    .replace("{product}", Products[prodIndex])
                    .replace("{amount}", ""+(RANDOM.nextDouble() * 5))
                    .replace("{operation}", AdjOps[RANDOM.nextInt(3)]);
        }
    }

	private static String getTemplate(String classpathResource) {
        return new Scanner(FakeMessageBuilder.class.getResourceAsStream(classpathResource)).next();
    }

}
