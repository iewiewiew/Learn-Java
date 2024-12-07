package utils;

import cn.binarywang.tools.generator.*;
import org.slf4j.*;


public class GeneratorInfo {

    public static void main(String[] args) {

        final Logger log = LoggerFactory.getLogger(GeneratorInfo.class);

        String generatedName = ChineseNameGenerator.getInstance().generate();
        System.out.println("姓名：" + generatedName);
        log.info("姓名：" + generatedName);

        String generatedName2 = ChineseNameGenerator.getInstance().generateOdd();
        System.out.println("姓名2：" + generatedName2);
        log.info("姓名2：" + generatedName2);

        String idCard=ChineseIDCardNumberGenerator.getInstance().generate();
        System.out.println("身份证：" + idCard);
        log.info("身份证：" + idCard);

        String generatedMobileNum= ChineseMobileNumberGenerator.getInstance().generate();
        System.out.println("手机号：" + generatedMobileNum);
        log.info("手机号：" + generatedMobileNum);

        String generatedEmail= EmailAddressGenerator.getInstance().generate();
        System.out.println("邮箱：" + generatedEmail);
        log.info("邮箱：" + generatedEmail);

        String bankCardNo= BankCardNumberGenerator.getInstance().generate();
        System.out.println("银行卡号：" + bankCardNo);
        log.info("银行卡号" + bankCardNo);

        String generatedAddress= ChineseAddressGenerator.getInstance().generate();
        System.out.println("地址：" + generatedAddress);
        log.info("地址：" + generatedAddress);

        String issueOrg=ChineseIDCardNumberGenerator.generateIssueOrg();
        System.out.println("机关：" + issueOrg);
        log.info("机关：" + issueOrg);
    }
}
