package com.example.crypto;

final public class Sha256 {
    final private static int[] h = {0x6a09e667, 0xbb67ae85, 0x3c6ef372, 0xa54ff53a,
                                    0x510e527f, 0x9b05688c, 0x1f83d9ab, 0x5be0cd19};

    final private static int[] k = {0x428A2F98, 0x71374491, 0xB5C0FBCF, 0xE9B5DBA5,
                                    0x3956C25B, 0x59F111F1, 0x923F82A4, 0xAB1C5ED5,
                                    0xD807AA98, 0x12835B01, 0x243185BE, 0x550C7DC3,
                                    0x72BE5D74, 0x80DEB1FE, 0x9BDC06A7, 0xC19BF174,
                                    0xE49B69C1, 0xEFBE4786, 0x0FC19DC6, 0x240CA1CC,
                                    0x2DE92C6F, 0x4A7484AA, 0x5CB0A9DC, 0x76F988DA,
                                    0x983E5152, 0xA831C66D, 0xB00327C8, 0xBF597FC7,
                                    0xC6E00BF3, 0xD5A79147, 0x06CA6351, 0x14292967,
                                    0x27B70A85, 0x2E1B2138, 0x4D2C6DFC, 0x53380D13,
                                    0x650A7354, 0x766A0ABB, 0x81C2C92E, 0x92722C85,
                                    0xA2BFE8A1, 0xA81A664B, 0xC24B8B70, 0xC76C51A3,
                                    0xD192E819, 0xD6990624, 0xF40E3585, 0x106AA070,
                                    0x19A4C116, 0x1E376C08, 0x2748774C, 0x34B0BCB5,
                                    0x391C0CB3, 0x4ED8AA4A, 0x5B9CCA4F, 0x682E6FF3,
                                    0x748F82EE, 0x78A5636F, 0x84C87814, 0x8CC70208,
                                    0x90BEFFFA, 0xA4506CEB, 0xBEF9A3F7, 0xC67178F2};

    protected static int getZeroCount(int srcLen) {
        return (((srcLen + 9)*8) >= 512 ? ((srcLen + 9)*8) % 512 : 512 - ((srcLen + 9)*8)) / 8;
    }

    protected static byte[] getLengthArray(long srcLen) {
        byte[] res = new byte[8];
        for(int i=7; i>=0; i--) {
            res[i] = (byte) (srcLen >> (7-i) * 8);
        }
        return res;
    }

    protected static byte[] padding(byte[] src) {
        int zeroCount = getZeroCount(src.length);
        byte[] data = new byte[src.length + 9 + zeroCount];
        byte[] len = getLengthArray((long) src.length * 8);

        System.arraycopy(src, 0, data, 0, src.length);
        data[src.length] = (byte)0x80;
        for(int i=0; i<zeroCount; i++) {
            data[src.length + 1 + i] = (byte) 0x00;
        }
        System.arraycopy(len, 0, data, src.length+1+zeroCount, len.length);

        return data;
    }

    public static String hash(String msg) {
        // Pre-handled
        byte[] data = padding(msg.getBytes());

        return "";
    }
}
