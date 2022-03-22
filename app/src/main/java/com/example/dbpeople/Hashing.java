package com.example.dbpeople;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashing {

    private static final String hashingAlgorithm = "SHA-256";

    /**
     * Method to calculate the hash of the input String
     * @param input The string to hash
     * @return The digest of the input as an array of byte
     * or an empty array of byte if the algorithm hasn't been found
     */
    public static byte[] getSHA(String input)  {

        try {
            // Static getInstance method is called with hashing SHA
            final MessageDigest messageDigest = MessageDigest.getInstance(hashingAlgorithm);

            // digest() method called to calculate message digest of an input and return array of byte
            return messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            return new byte[0];
        }
    }

    /**
     * Method to parse the message digest as an array of byte to a readable String
     * @param hash The message digest as an array of byte
     * @return The input hash as a String
     */
    public static String toHexString(byte[] hash) {

        // Convert byte array into sign um representation
        final BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        final StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }

}