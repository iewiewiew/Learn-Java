package utils;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author weimenghua
 * @date 2021-10-01 22:51
 */
public class ElasticsearchDemo {
    private final Logger logger = LoggerFactory.getLogger(ElasticsearchDemo.class);

    public final static String HOST = "127.0.0.1";
    public final static int PORT = 9200; //http请求的端口是9200，客户端是9300

    public static void main(String[] args) throws Exception {
        ElasticsearchDemo es = new ElasticsearchDemo();
        es.ESClientConn();
        es.CreateIndex();
        //es.clone();
    }

    /**
     * 连接ES
     * @return
     * @throws Exception
     */
    @Before
    public RestHighLevelClient ESClientConn() throws Exception{
        RestHighLevelClient esclient = new RestHighLevelClient(RestClient.builder(new HttpHost(HOST, PORT, "http")));
        logger.info("ES客户端：" + esclient);
        return esclient;
    }

    /**
     * 关闭索引
     * @param esclient
     * @throws Exception
     */
    @After
    public void ESClose(RestHighLevelClient esclient) throws Exception{
        if (esclient != null){
            esclient.close();
            logger.info("关闭ES");
        }
    }


    /**
     * 创建索引
     * @throws Exception
     */
//    @Test
    public void CreateIndex() throws Exception{
        RestHighLevelClient esclient = new ElasticsearchDemo().ESClientConn();
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("zyx4");
        CreateIndexResponse createIndexResponse = esclient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        boolean acknowledged = createIndexResponse.isAcknowledged();
        System.out.println("索引操作：" + acknowledged);
        esclient.close();
    }



    /**
     * 查询索引
     * @throws Exception
     */
    @Test
    public void GetIndex() throws Exception{
        RestHighLevelClient esclient = new ElasticsearchDemo().ESClientConn();
        GetIndexRequest getIndexRequest = new GetIndexRequest("zyx");
        GetIndexResponse getIndexResponse = esclient.indices().get(getIndexRequest, RequestOptions.DEFAULT);
        System.out.println(getIndexResponse.getAliases());
        System.out.println(getIndexResponse.getMappings());
        System.out.println(getIndexResponse.getSettings());
        esclient.close();
    }

    /**
     * 删除索引
     * @throws Exception
     */
    public void DeleteIndex() throws Exception{
        RestHighLevelClient esclient = new ElasticsearchDemo().ESClientConn();
        //todo
        esclient.close();
    }
}
