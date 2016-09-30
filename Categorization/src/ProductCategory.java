import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Created by R00715649 on 28-Sep-16.
 */
public class ProductCategory {
    public static void main(String[] args) {

        CategorySetter categorySetter = new CategorySetter();

        //open connection to database
        MongoClient mongoClient = new MongoClient("10.192.69.41",27017);
        MongoDatabase db = mongoClient.getDatabase("supplyChain");
        MongoCollection competidores = db.getCollection("Competidores");

        //query all
        FindIterable<Document> cursor = competidores.find();

        //for each document in cursor
        for (Document d:cursor){

            String itemDescription = d.getString("DESCRIPCION DEL DESPACHO");
            String hsCode = d.getString("POSICION ARANCELARIA");
            String combinedDescription = hsCode + " " + itemDescription;

            //read hs code + description an place category
            String categoria = categorySetter.findCategory(combinedDescription);

            System.out.println(categoria);

            //update record
            competidores.updateOne(d,new Document("$set", new Document("PRODUCT_CATEGORY", categoria)));

        }


    }

}
