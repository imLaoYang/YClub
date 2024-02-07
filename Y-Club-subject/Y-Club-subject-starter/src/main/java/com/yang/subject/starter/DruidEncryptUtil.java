// package com.yang.subject.starter;
//
// import com.alibaba.druid.filter.config.ConfigTools;
//
// import java.security.NoSuchAlgorithmException;
// import java.security.NoSuchProviderException;
//
// public class DruidEncryptUtil {
//
//   private static String pub;
//   private static String sec;
//
//
//   static{
//
//     try {
//       String[] keyPair = ConfigTools.genKeyPair(512);
//       pub = keyPair[1];
//       System.out.println("pub = " + pub);
//       sec = keyPair[0];
//
//     } catch (NoSuchAlgorithmException e) {
//       throw new RuntimeException(e);
//     } catch (NoSuchProviderException e) {
//       throw new RuntimeException(e);
//     }
//
//   }
//
//
//   public static void main(String[] args) throws Exception {
//     String encrypt = ConfigTools.encrypt(sec, "root");
//     System.out.println(encrypt);
//   }
//
//
// }
