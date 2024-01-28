package org.example;

import org.apache.commons.codec.binary.Base64;

import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Arrays;

public class MainClient {
    public static void main(String[] args) {
        try{
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            System.out.println(kpg.getAlgorithm());
            kpg.initialize(2048);
            KeyPair kp = kpg.generateKeyPair();

            System.out.println(kp.getPublic());

//            String publicKey = Base64.encodeBase64String(kp.getPublic().getEncoded());
//            String privateKey = Base64.encodeBase64String(kp.getPrivate().getEncoded());
            String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA6gMbzaTkpPIwQjteV/KHEvOpqsJAWScekofIVdhDoB4h3ZmIvdZO3s26BqNjwD1RIBD3t6kDRMHm7U8pYQpcQXozYRHBY+SFn817YKntUAgzK0FurOCKPifztlcisX3+7w3H8NkqgdXP+QpAajJx9ph5KagpZMNI285ibHNthJYISblUkfHoFAlLpYNtAVoUq8SSzlWWUS3XGngsqc3pQI+qabFwMx0mIQ/Ry5cHJ4hNoOZfvvQhaRQWqtdIQXfOH29eX2E/B6NZDW1bqR2u0lO9LcChrIOaYsiRSMuAfF3fzZ3oIOnYbKQCurUyDVtXgTUScQKqV0XY0EbgdYA87QIDAQAB";
            String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDqAxvNpOSk8jBCO15X8ocS86mqwkBZJx6Sh8hV2EOgHiHdmYi91k7ezboGo2PAPVEgEPe3qQNEwebtTylhClxBejNhEcFj5IWfzXtgqe1QCDMrQW6s4Io+J/O2VyKxff7vDcfw2SqB1c/5CkBqMnH2mHkpqClkw0jbzmJsc22ElghJuVSR8egUCUulg20BWhSrxJLOVZZRLdcaeCypzelAj6ppsXAzHSYhD9HLlwcniE2g5l++9CFpFBaq10hBd84fb15fYT8Ho1kNbVupHa7SU70twKGsg5piyJFIy4B8Xd/Nnegg6dhspAK6tTINW1eBNRJxAqpXRdjQRuB1gDztAgMBAAECggEADDloWOg9t24dXkBar85wBunqmYx3LxEPlEj6ip12/uTEER7lmUEaMqJdjt43JkItvDaWsiXmkU9twETL3RFc+2CmUXJLf2vfHRdvU//ccTtUbPSIkwhRwGh23zYTDmGOES/Pm4HEqi6gpBpIfiOvd1nErovlyak345+W3aJz/KJ+LRVmwUpwc7uolWfUlU4J+FV88k3Lm0b7WiiR57KKS6N4xad1FyGE63K4gFdkX5O2CBhPPvcobM/ucnWtvxzLzaSo+A0fjv7BDbdMEJk6JN+wU8NwDPIw5mlH6g9A2+5DfeNfcYCw0VLL02mmQOHoTa/2UQggnN7lgUWbdVVjYwKBgQDu7SjdkhUvweQF5DvMQS0jpuM6ahyxa17lxND5NbCPH8y4E9PGsOGAAzn8motsb5MkrwSL5YHXYW3rWGnivSxHrnldi3TK8/peOJfrl+zi+IuxG3Jwjk5PwsYFiTatPRKBGLqi2y55C3q1fH2pS2ZoZMZScgcGsftYaLh6Cem7WwKBgQD6vAyR3hXxn/Ftm0MRPjQZe6rGN6yeYJYHDADarEbHefNossv/Fa+DMrAJYaiVTK7vmu2UV8oys5w0Vz216v+YWt30NklH/Jr0lvd6Uca+dUGB/7QW/fYKm6jJ8AZEtT8TK5HGpXllIuaW2Hv6+kCFG3DOWo1LaJvLNOLhlTaDVwKBgQDRZ1xcra8R906Bd2KNh0YnrBoVVXEmcqNuoAxDjzHajxVe9Em1J8vL5YgKA+1UsYl2KkrCzfj5qzOqhAfxqLlJbfqC6ToIssLpl5JW8wW0e//6zsKDMcYjE+N4cKVSOmega+sP1ygpAM2giKaeHS55KnHDSpsr3AwdlVKx60RGZwKBgQDEUc09wThJUkSE35apv5ynf079mMYN0+5kYh+hGFbrBS9zANv9RIuCHIP9NHv9OmeWsCXpiruE62EZEl39PJ0YO72h44eJV940OKhZHAKTSdga442smvi04aBNTSR7U7apWenwMcxVRfhqj+KzZpJyJkQzLm+HZcbmWuhyXJSsTQKBgCL206qZaPJ6rg9po2o+vNDgSZBMR5zWOlJBMvO1mRgutNa/EC9vd7UQROQRHV+wsjWYl2o6p2xai+I16UHsqhyWB0WqDtt32EbOMLyPxde3UEFcBAlV+8s5fwXAkT2DOqHSstwaM0AHJhf14FszCDJQgu2/u/NZz/8U55jme7gY";
            JwtUtils jwtUtils = new JwtUtils();
            System.out.println(publicKey);
            System.out.println(privateKey);
            String jwtToken = jwtUtils.generateAccessToken("aaa",privateKey);
            System.out.println(jwtToken);
            System.out.println(jwtUtils.validateJwtToken(jwtToken,publicKey));
            System.out.println();

            String[] chunks = jwtToken.split("\\.");

            String header =  Arrays.toString(Base64.decodeBase64(chunks[0]));
            String payload= Arrays.toString(Base64.decodeBase64(chunks[1]));
            String signature = Arrays.toString(Base64.decodeBase64(chunks[2]));

            byte[] decoded = java.util.Base64.getDecoder().decode(chunks[1]);
            String decodedStr = new String(decoded, StandardCharsets.UTF_8);
            System.out.println(decodedStr);
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}