package org.wyden.pdao.dao.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.wyden.pdao.connection.MongoConnection;
import org.wyden.pdao.dao.IDao;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/*

    Implementei a interface IDao na classe generica EntityDao, com isso eu criei dentro do construtor
    um objeto persistentClass para acessar o objeto getSimpleName para recuperar o nome da classe persistente
    e assim criar uma coleção com este nome. (Collection é um grupo de documentos, e documentos
    é um conjunto de pares de valores-chave.).
    Todos os metodos dessa classe trabalha com objeto do mongodb, é através deles que a API transforma os parametros map
    em um documento JSON
    O objetivo dessa classe é persistir os objetos do banco de dados do mongodb.
 */

public class EntityDao<T> implements IDao, Serializable {

    private static final long serialVersionUID = 1L;

    private Class<T> persistentClass;
    private DBCollection dbCollection;

    public EntityDao(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
        this.dbCollection =
                MongoConnection.getInstance().getDB("pessoaDB").getCollection(persistentClass.getSimpleName());

    }

    protected DBCollection getDbCollection() {
        return dbCollection;
    }

    public void save(Map<String, Object> mapEntity) {
        BasicDBObject document = new BasicDBObject(mapEntity);

        dbCollection.save(document);


        System.out.println("Save :> " + document);

        System.out.println("Collection :> " + dbCollection.getName());
    }

    public void save(Map<String, Object> mapEntity, String indexKey, boolean unique) {
        BasicDBObject document = new BasicDBObject(mapEntity);

        dbCollection.createIndex(new BasicDBObject(indexKey, 1), null, unique);

        dbCollection.save(document);

        System.out.println("Save :> " + document);
    }

    public void update(Map<String, Object> mapQuery,
                       Map<String, Object> mapEntity) {
        BasicDBObject query = new BasicDBObject(mapQuery);

        BasicDBObject entity = new BasicDBObject(mapEntity);

        dbCollection.update(query, entity);
    }

    public void delete(Map<String, Object> mapEntity) {
        BasicDBObject entity = new BasicDBObject(mapEntity);

        dbCollection.remove(entity);
    }

    public DBObject findOne(Map<String, Object> mapEntity) {
        BasicDBObject query = new BasicDBObject(mapEntity);

        return dbCollection.findOne(query);
    }

    public List<DBObject> findAll() {
        List<DBObject> list = new ArrayList<DBObject>();

        DBCursor cursor = dbCollection.find();

        while (cursor.hasNext()) {
            list.add(cursor.next());
        }

        return list;
    }

    public List<DBObject> findKeyValue(Map<String, Object> keyValue) {
        List<DBObject> list = new ArrayList<DBObject>();

        DBCursor cursor = dbCollection.find(new BasicDBObject(keyValue));

        while (cursor.hasNext()) {
            list.add(cursor.next());
        }

        return list;


    }
}
