package basedemo;

import basedemo.dto.UserInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;

import java.util.*;

/**
 * @author weimenghua
 * @time 2022-03-09 16:38
 * @description json和对象相互转换
 * fastjson序列化乱序问题
 * 1、初始化为有序json对象：JSONObject jsonOrdered= new JSONObject(true);
 * 2、将String对象转换过程中，不要调整顺序：JSONObject jsonOrdered = JSONObject.parseObject(jsonString, Feature.OrderedField);
 */
public class JsonObjectDemo {
    public static String jsonuser = "{\"age\":18,\"id\":1,\"name\":\"zyx\"}";
    public static String jsonlist = "[{\"age\":18,\"id\":1,\"name\":\"zyx\"},{\"age\":30,\"id\":2,\"name\":\"张艺兴\"}]\n";
    public static String jsonmap = "{\"001\":{\"age\":18,\"id\":1,\"name\":\"zyx\"},\"002\":[{\"$ref\":\"$.001\"},{\"age\":30,\"id\":2,\"name\":\"张艺兴\"}]}\n";

    public static void main(String[] args) {

    }


    @Test
    public void test1() {
        UserInfo user = new UserInfo();
        user.setId(1);
        user.setName("zyx");
        user.setAge(18);
        List<UserInfo> list = new ArrayList<UserInfo>();
        list.add(user);
        list.add(new UserInfo(2, "张艺兴", 30));
        Map map = new HashMap();
        map.put("001", user);
        map.put("002", list);

        System.out.printf("1、JSONObject.toJSONString - java对象转换为json字符串" + "\n");
        System.out.println(JSONObject.toJSONString(user));
        System.out.println(JSONObject.toJSONString(list));
        // 问题：json数据出现{“$ref:”$[0]},无法得到所有数据 解决：SerializerFeature.DisableCircularReferenceDetect关闭循环引用
        System.out.println(JSONObject.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect));
        System.out.printf("\n");


        System.out.printf("2、JSONObject.parseObject - json字符串转换为java对象" + "\n");
        System.out.println(JSONObject.parseObject(jsonuser, UserInfo.class));
        List list1 = JSONObject.parseObject(jsonlist, List.class);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(JSONObject.parseObject(JSONObject.toJSONString(list1.get(i)), UserInfo.class));
        }
        Map map1 = JSONObject.parseObject(jsonmap, Map.class);
        Iterator iterator = map1.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println("key:" + entry.getKey() + "  value:" + entry.getValue());
        }
        System.out.printf("\n");


        System.out.printf("3、JSON.toJSONString - java对象转换为json字符串" + "\n");
        System.out.println(JSON.toJSONString(jsonuser));
        System.out.println(JSON.toJSONString(list));
        System.out.println(JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect));
        System.out.printf("\n");


        System.out.printf("4、JSON.parseObject - json字符串转换为java对象" + "\n");
        System.out.println(JSON.parseObject(jsonuser, UserInfo.class));
        List list2 = JSON.parseObject(jsonlist, List.class);
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(JSON.parseObject(JSON.toJSONString(list1.get(i)), UserInfo.class));
        }
        Map map2 = JSON.parseObject(jsonmap, Map.class);
        Iterator iterator2 = map1.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator2.next();
            System.out.println("key:" + entry.getKey() + "  value:" + entry.getValue());
        }
    }


    @Test
    public void test2() {
        String jsonDemo = "{\n" +
                "    \"name\":\"zyx\",\n" +
                "    \"age\":18,\n" +
                "    \"city\": {\n" +
                "        \"city1\":\"深圳\",\n" +
                "        \"city2\":\"长沙\",\n" +
                "        \"city3\":\"北京\"\n" +
                "    }\n" +
                "}";

        JSONObject jsonobj = JSON.parseObject(jsonDemo); //将json字符串转换成jsonObject对象
        System.out.printf("标准json：" + String.valueOf(jsonobj) + "\n");
        System.out.println(jsonobj.get("name")); //取出name对应的value值，得到的是一个object
        System.out.println(jsonobj.getString("name")); //取出name对应的value值，得到的是一个String
        System.out.println(jsonobj.getIntValue("age")); //取出name对应的value值，得到的是一个int
        System.out.println(jsonobj.get("city")); //取出citys对应的value值，得到的是一个object
        System.out.println(jsonobj.getString("city"));
        System.out.println(jsonobj.getJSONObject("city")); //取出citys对应的value值，得到一个JSONObject子对象
        System.out.println(jsonobj.getJSONObject("city").getString("city2")); //取出嵌套的JSONObject子对象中city2对应的value值，必须用getJSONObject()先获取JSONObject
    }


    @Test
    public void test3() {
        /**
         * 以下是一个json对象中包含数组，数组中又包含json子对象和子数组
         */
        String jsonDemo = "{\n" +
                "    \"name\":\"张艺兴\",\n" +
                "    \"age\":18,\n" +
                "    \"citys\": [\n" +
                "        { \"name\":\"长沙\", \"info\":[ \"a1\", \"a2\", \"a3\" ] },\n" +
                "        { \"name\":\"深圳\", \"info\":[ \"b1\", \"b2\", \"b3\" ] },\n" +
                "        { \"name\":\"北京\", \"info\":[ \"c1\", \"c2\" ] }\n" +
                "    ]\n" +
                "}";
        JSONObject jsonobj2 = JSON.parseObject(jsonDemo); //将json字符串转换成jsonObject对象
        System.out.println(jsonobj2.get("citys"));
        System.out.println(jsonobj2.getString("citys"));
        //取出citys对应的value值，得到一个JSONOArray对象
        System.out.println(jsonobj2.getJSONArray("citys"));
        //System.out.println(jsonobj2.getJSONObject("citys")); 不能用该方法，因为citys是一个JSONOArray对象
        //取出json对象中citys对应数组中第一个json子对象的值
        System.out.println(jsonobj2.getJSONArray("citys").getJSONObject(0));
        System.out.println(jsonobj2.getJSONArray("citys").get(0));
        System.out.println(jsonobj2.getJSONArray("citys").getString(0));
        //取出json对象中citys对应数组中第一个json子对象下面info对应的嵌套子数组值
        System.out.println(jsonobj2.getJSONArray("citys").getJSONObject(0).getJSONArray("info"));
        //取出json对象中citys对应数组中第一个json子对象下面info对应的嵌套子数组中第二个值
        System.out.println(jsonobj2.getJSONArray("citys").getJSONObject(0).getJSONArray("info").getString(1));
        //依次取出json对象中citys对应数组中的值
        JSONArray array = jsonobj2.getJSONArray("citys");
        getJsonArrayItem(array);
        //依次取出json对象中citys对应数组中第二个json子对象下面info对应的嵌套子数组值
        JSONArray arr = jsonobj2.getJSONArray("citys").getJSONObject(1).getJSONArray("info");
        getJsonArrayItem(arr);
    }


    /**
     * 依次取出JSONArray中的值
     */
    private static void getJsonArrayItem(JSONArray array) {
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
    }
}
