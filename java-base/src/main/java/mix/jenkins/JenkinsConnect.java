package mix.jenkins;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.client.JenkinsHttpClient;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author      weimenghua
 * @time        2022-08-11 10:17
 * @description Jenkins 连接
 */

public class JenkinsConnect {

    private JenkinsConnect() {
    }

    // 连接 Jenkins 需要设置的信息
    static final String JENKINS_URL = "http://127.0.0.1:8888/";
    static final String JENKINS_USERNAME = "admin";
    static final String JENKINS_PASSWORD = "admin";

    /**
     * Http 客户端工具
     */
    public static JenkinsHttpClient getClient() {
        JenkinsHttpClient jenkinsHttpClient = null;
        try {
            jenkinsHttpClient = new JenkinsHttpClient(new URI(JENKINS_URL), JENKINS_USERNAME, JENKINS_PASSWORD);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return jenkinsHttpClient;
    }

    /**
     * 连接 Jenkins
     */
    public static JenkinsServer connection() {
        JenkinsServer jenkinsServer = null;
        try {
            jenkinsServer = new JenkinsServer(new URI(JENKINS_URL), JENKINS_USERNAME, JENKINS_PASSWORD);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return jenkinsServer;
    }
}
