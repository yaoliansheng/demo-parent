package com.xiaoyao.mysq.linterceptor.demo.utils;

import com.xiaoyao.mysq.linterceptor.demo.annotation.SensitiveField;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Objects;

@Slf4j
public class AESUtil {
    
    /**
     * 加密
     *
     * @param declaredFields paramsObject所声明的字段
     * @param paramsObject   mapper中paramsType的实例
     * @return T
     * @throws IllegalAccessException 字段不可访问异常
     */
    public static <T> T encrypt(Field[] declaredFields, T paramsObject) throws IllegalAccessException {
        for (Field field : declaredFields) {
            //取出所有被EncryptDecryptField注解的字段
            SensitiveField sensitiveField = field.getAnnotation(SensitiveField.class);
            if (!Objects.isNull(sensitiveField)) {
                field.setAccessible(true);
                Object object = field.get(paramsObject);
                //暂时只实现String类型的加密
                if (object instanceof String) {
                    String value = (String) object;
                    //加密  这里我使用自定义的AES加密工具
                    field.set(paramsObject, aesEncrypt(value));
                }
            }
        }
        return paramsObject;
    }

  /**
   * 解密
   *
   * @param result resultType的实例
   * @return T
   * @throws IllegalAccessException 字段不可访问异常
   */
  public static <T> T decrypt(T result) throws IllegalAccessException {
    //取出resultType的类
    Class<?> resultClass = result.getClass();
    Field[] declaredFields = resultClass.getDeclaredFields();
    for (Field field : declaredFields) {
      //取出所有被EncryptDecryptField注解的字段
      SensitiveField sensitiveField = field.getAnnotation(SensitiveField.class);
      if (!Objects.isNull(sensitiveField)) {
        field.setAccessible(true);
        Object object = field.get(result);
        //只支持String的解密
        if (object instanceof String) {
          String value = (String) object;
          //对注解的字段进行逐一解密
          field.set(result, aesDecrypt(value));
        }
      }
    }
    return result;
  }


  //密钥 (需要前端和后端保持一致) HDKJ的md5值取前16位
  private static final String KEY = "3287e4579864b528";
  //算法
  private static final String ALGORITHMSTR = "AES/ECB/PKCS5Padding";

  private static final char hexDigits[] = {
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
  };

  /**
   * aes解密
   * @param encrypt   内容
   * @return
   * @throws Exception
   */
  public static String aesDecrypt(String encrypt) {
    try {
      return aesDecrypt(encrypt, KEY);
    } catch (Exception e) {
      log.error("aesDecrypt"+e.getMessage(),e);
      return "";
    }
  }

  /**
   * aes加密
   * @param content
   * @return
   * @throws Exception
   */
  public static String aesEncrypt(String content) {
    try {
      return aesEncrypt(content, KEY);
    } catch (Exception e) {
      log.error("aesEncrypt"+e.getMessage(),e);
      return "";
    }
  }

  /**
   * 将byte[]转为各种进制的字符串
   * @param bytes byte[]
   * @param radix 可以转换进制的范围，从Character.MIN_RADIX到Character.MAX_RADIX，超出范围后变为10进制
   * @return 转换后的字符串
   */
  public static String binary(byte[] bytes, int radix){
    return new BigInteger(1, bytes).toString(radix);// 这里的1代表正数
  }

  /**
   * base 64 encode
   * @param bytes 待编码的byte[]
   * @return 编码后的base 64 code
   */
  public static String base64Encode(byte[] bytes){
    return Base64.encodeBase64String(bytes);
  }

  /**
   * base 64 decode
   * @param base64Code 待解码的base 64 code
   * @return 解码后的byte[]
   * @throws Exception
   */
  public static byte[] base64Decode(String base64Code) throws Exception{
    return StringUtils.isEmpty(base64Code) ? null : new BASE64Decoder().decodeBuffer(base64Code);
  }


  /**
   * AES加密
   * @param content 待加密的内容
   * @param encryptKey 加密密钥
   * @return 加密后的byte[]
   * @throws Exception
   */
  public static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
    KeyGenerator kgen = KeyGenerator.getInstance("AES");
    kgen.init(128);
    Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
    cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), "AES"));

    return cipher.doFinal(content.getBytes("utf-8"));
  }


  /**
   * AES加密为base 64 code
   * @param content 待加密的内容
   * @param encryptKey 加密密钥
   * @return 加密后的base 64 code
   * @throws Exception
   */
  public static String aesEncrypt(String content, String encryptKey) throws Exception {
    return base64Encode(aesEncryptToBytes(content, encryptKey));
  }

  /**
   * AES解密
   * @param encryptBytes 待解密的byte[]
   * @param decryptKey 解密密钥
   * @return 解密后的String
   * @throws Exception
   */
  public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {
    KeyGenerator kgen = KeyGenerator.getInstance("AES");
    kgen.init(128);

    Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
    cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), "AES"));
    byte[] decryptBytes = cipher.doFinal(encryptBytes);
    return new String(decryptBytes);
  }


  /**
   * 将base 64 code AES解密
   * @param encryptStr 待解密的base 64 code
   * @param decryptKey 解密密钥
   * @return 解密后的string
   * @throws Exception
   */
  public static String aesDecrypt(String encryptStr, String decryptKey) throws Exception {
    return StringUtils.isEmpty(encryptStr) ? null : aesDecryptByBytes(base64Decode(encryptStr), decryptKey);
  }

  public static String getMd5(String key){
    try {
      byte[] btInput = key.getBytes();
      // 获得MD5摘要算法的 MessageDigest 对象
      MessageDigest mdInst = MessageDigest.getInstance("MD5");
      // 使用指定的字节更新摘要
      mdInst.update(btInput);
      // 获得密文
      byte[] md = mdInst.digest();
      // 把密文转换成十六进制的字符串形式
      int j = md.length;
      char str[] = new char[j * 2];
      int k = 0;
      for (int i = 0; i < j; i++) {
        byte byte0 = md[i];
        str[k++] = hexDigits[byte0 >>> 4 & 0xf];
        str[k++] = hexDigits[byte0 & 0xf];
      }
      return new String(str).toLowerCase();
    } catch (Exception e) {
      return null;
    }
  }
}