import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:Rain
 * @date 2019/11/1 16:13
 * @desc
 */
public class test {
    /**
     * <dependency>
     *             <groupId>org.mongodb</groupId>
     *             <artifactId>mongodb-driver</artifactId>
     *             <version>3.6.3</version>
     *         </dependency>
     *         <dependency>
     *             <groupId>junit</groupId>
     *             <artifactId>junit</artifactId>
     *             <version>4.12</version>
     *  </dependency>
     */
//    @Test
    public void test1(){
        // 创建客户端
        MongoClient client = new MongoClient("localhost");
        // 获得要查询的数据库
        MongoDatabase userdb = client.getDatabase("userdb");
        // 得到要查询的集合
        MongoCollection<Document> spitcollection = userdb.getCollection("spit");
        // 查询数据
        FindIterable<Document> documents = spitcollection.find();

        for (Document document: documents) {
            // 获得该字段的值
            System.out.println("id + " + document.get("_id"));
            // 获得该字段指定数据类型的值
            System.out.println("content : " + document.getString("content"));
            // 获得userid
            System.out.println("userid :　" + document.getString("userid"));
            // 获得nickname
            System.out.println("nickname : " + document.get("nickname",String.class));
             // 获得integer  id
            System.out.println("visits : " + document.get("visits",Integer.class));
        }
    }

    /**
     * 根据条件查
     */
//    @Test
    public  void test2(){
        // 创建客户端
        MongoClient client = new MongoClient("localhost");
        // 获得要查询的数据库
        MongoDatabase userdb = client.getDatabase("userdb");
        // 得到要查询的集合
        MongoCollection<Document> spitcollection = userdb.getCollection("spit");

        Map map = new HashMap();
        map.put("$gt",1100);
        BasicDBObject bson = new BasicDBObject(map);
        Map map1 = new HashMap();
        map1.put("visits",bson);
        BasicDBObject bson1 = new BasicDBObject(map1);

        // 查询数据
        FindIterable<Document> documents = spitcollection.find(bson1);

        for (Document document: documents) {
            // 获得该字段的值
            System.out.println("id + " + document.get("_id"));
            // 获得该字段指定数据类型的值
            System.out.println("content : " + document.getString("content"));
            // 获得userid
            System.out.println("userid :　" + document.getString("userid"));
            // 获得nickname
            System.out.println("nickname : " + document.get("nickname",String.class));
            // 获得integer  id
            System.out.println("visits : " + document.get("visits",Integer.class));
        }

    }
}
