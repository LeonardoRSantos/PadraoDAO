package org.wyden.pdao.connection;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/*
    Demonstrar varias implmentações de bancos dados diferentes
    sem alterar o a lógica de negócio.
    Usei o padrão de projeto singleton para esse banco de dados;

 */


public class MongoConnection {

    private static MongoClient instance;


    private static String url = "mongodb://localhost:27017";
    private String dataBaseName = "pessoaDB";
    private String collectionName = "pessoas";


    public static synchronized MongoClient getInstance(){
        if(instance == null){
            instance = new MongoClient(new MongoClientURI(url));
        }
        return instance;
    }



    private MongoDatabase getDB() {
        return getInstance().getDatabase(dataBaseName);
    }

    private MongoCollection<Document> getAuthorsCollection() {
        return getDB().getCollection(collectionName);
    }
}
