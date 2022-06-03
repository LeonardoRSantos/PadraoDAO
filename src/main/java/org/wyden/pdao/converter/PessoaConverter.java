package org.wyden.pdao.converter;

import com.mongodb.DBObject;
import org.wyden.pdao.model.Pessoa;

import java.util.HashMap;
import java.util.Map;


public class PessoaConverter {

    public Map<String, Object> converterToMap(Pessoa pessoa) {
        Map<String, Object> mapPessoa = new HashMap<String, Object>();
        mapPessoa.put("primeiroNome", pessoa.getPrimeiroNome());
        mapPessoa.put("ultimoNome", pessoa.getUltimoNome());
        mapPessoa.put("idade", pessoa.getIdade());
        mapPessoa.put("telefone",
                new TelefoneConverter().converterToMap(pessoa.getTelefone())
        );

        return mapPessoa;
    }

    public Pessoa converterToPerson(DBObject dbo) {
        Pessoa person = new Pessoa();
        person.setId(dbo.get("_id").toString());
        person.setPrimeiroNome((String) dbo.get("primeiroNome"));
        person.setUltimoNome((String) dbo.get("ultimoNome"));
        person.setIdade((Integer) dbo.get("idade"));
        person.setTelefone(new TelefoneConverter().converterToPhone(
                (HashMap<String, Object>) dbo.get("telefone"))
        );

        return person;
    }
}
