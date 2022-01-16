package org.example.com.functions;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

/**
 * @author weimenghua
 * @time 2023-07-31 17:40
 * @description
 */
public class JMeterTest extends AbstractJavaSamplerClient {
    @Override
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        SampleResult sampleResult=new  SampleResult();
        String num1=javaSamplerContext.getParameter("num1");
        String num2=javaSamplerContext.getParameter("num2");
        String types=javaSamplerContext.getParameter("type");
        String result="";
        Cale cale=new Cale();
        if (types.equals("add")){
            result= String.valueOf(cale.add(Integer.valueOf(num1),Integer.valueOf(num2)));
        }else {
            result= String.valueOf(cale.mins(Integer.valueOf(num1),Integer.valueOf(num2)));

        }
        sampleResult.setResponseData(result,SampleResult.TEXT);
        sampleResult.setSuccessful(true);
        return sampleResult;
    }

    @Override
    public Arguments getDefaultParameters() {
        Arguments parems = new Arguments();
        parems.addArgument("type","");
        parems.addArgument("num1","数字1");
        parems.addArgument("num2","数字2");
        return parems;
    }
}
