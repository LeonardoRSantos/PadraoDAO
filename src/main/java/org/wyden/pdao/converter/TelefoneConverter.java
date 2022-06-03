package org.wyden.pdao.converter;


import org.wyden.pdao.model.Telefone;

import java.util.HashMap;
import java.util.Map;

/*
    Aqui na classe telefone converte, primeiro temos que converter o tipo de telefone em map
 e depois convertemos a telefone em hash map, assim garantindo que ela persista no banco de dados
 mongodb em formato JSON.
 */
public class TelefoneConverter {

    public Map<String, Object> converterToMap(Telefone telefone) {
        Map<String, Object> mapTelefone = new HashMap<String, Object>();
        mapTelefone.put("telefone", telefone.getTelefone());
        mapTelefone.put("celular", telefone.getCelular());

        return mapTelefone;
    }

    public Telefone converterToPhone(HashMap<String, Object> hashMap) {
        Telefone telefone = new Telefone();
        telefone.setTelefone((String) hashMap.get("telefone"));
        telefone.setCelular((String) hashMap.get("celular"));
        return telefone;
    }
}
