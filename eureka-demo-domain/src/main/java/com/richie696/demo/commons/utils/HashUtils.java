package com.richie696.demo.commons.utils;


import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

@SuppressWarnings("UnstableApiUsage")
public class HashUtils {

    public static String calcHashCode(String msg, int seed) {
        HashFunction murmur3 = Hashing.murmur3_32();
        HashCode murmur3HashCode = murmur3.hashString(
                msg + "@" + seed, StandardCharsets.UTF_8);
        return murmur3HashCode.toString();
    }

    public static String generateMD5(String message) {
        HashFunction function = Hashing.murmur3_128();
        HashCode hashCode = function.hashString(message, Charset.defaultCharset());
        return hashCode.toString();
    }
}
