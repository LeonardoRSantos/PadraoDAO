package org.wyden.pdao.dao;

import com.mongodb.DBObject;

import java.util.List;
import java.util.Map;



/*
    Utilizei nos metodos da interface dao, a interface map. Pois busquei garantir que os objetos
    não se repitam, utilizando chave e valor.
 */
public interface IDao {
    void save(Map<String, Object> mapEntity);

    void save(Map<String, Object> mapEntity, String indexKey, boolean unique);

    void update(Map<String, Object> mapQuery, Map<String, Object> mapEntity);

    void delete(Map<String, Object> mapEntity);

    DBObject findOne(Map<String, Object> mapEntity);

    List<DBObject> findAll();

    List<DBObject> findKeyValue(Map<String, Object> keyValue);
}
