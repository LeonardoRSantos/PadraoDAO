package org.wyden.pdao.dao.impl;


import com.mongodb.DBObject;
import org.wyden.pdao.converter.PessoaConverter;
import org.wyden.pdao.model.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
    Após a criar a classe EntityDao e Converter, extendo EntityDao em PessoaDao
    afim de persistir no banco mongodb. Essa é a Dao responsável por salvar os dados
    que vai receber na main.

 */

public class PessoaDao extends EntityDao<Pessoa> {

    public PessoaDao() {
        super(Pessoa.class);
    }

    public void save(Pessoa pessoa) {
        Map<String, Object> mapPessoa =
                new PessoaConverter().converterToMap(pessoa);

        save(mapPessoa);
    }

    public void saveWithIndex(Pessoa pessoa) {
        Map<String, Object> mapPessoa =
                new PessoaConverter().converterToMap(pessoa);

        save(mapPessoa, "primeiroNome", true);
    }

    public void update(Pessoa pessoaAntiga, Pessoa pessoaNova) {
        Map<String, Object> query =
                new PessoaConverter().converterToMap(pessoaAntiga);

        Map<String, Object> map =
                new PessoaConverter().converterToMap(pessoaNova);

        update(query, map);
    }

    public void delete(Pessoa pessoa) {
        Map<String, Object> map =
                new PessoaConverter().converterToMap(pessoa);

        delete(map);
    }

    public Pessoa findPerson(Map<String, Object> mapKeyValue) {
        DBObject dbObject = findOne(mapKeyValue);

        Pessoa pessoa =
                new PessoaConverter().converterToPerson(dbObject);

        return pessoa;
    }

    public List<Pessoa> findPersons() {
        List<DBObject> dbObject = findAll();

        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        for (DBObject dbo : dbObject) {
            Pessoa pessoa = new PessoaConverter().converterToPerson(dbo);

            pessoas.add(pessoa);
        }

        return pessoas;
    }

    public List<Pessoa> findPersons(Map<String, Object> mapKeyValue) {
        List<DBObject> dbObject = findKeyValue(mapKeyValue);

        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        for (DBObject dbo : dbObject) {
            Pessoa pessoa = new PessoaConverter().converterToPerson(dbo);

            pessoas.add(pessoa);
        }

        return pessoas;
    }
}
