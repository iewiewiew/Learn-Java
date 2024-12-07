package basedemo;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;

/**
 * @author weimenghua
 * @time 2022-12-10 20:27
 * @description 生成签名
 */

public class SignatureDemo {
    public static void main(String[] args) throws Exception {
        System.out.println(genSign(123456));
    }

    /**
     * 生成签名
     */
    private static String genSign(long timestamp) throws Exception {
        String secret = "123456";
        if (StringUtils.isBlank(secret)) {
            return "";
        }
//        long timestamp = System.currentTimeMillis();
        String stringToSign = timestamp + "\n" + secret;
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
        byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
        return URLEncoder.encode(new String(Base64.encodeBase64(signData)), "UTF-8");
    }

}
