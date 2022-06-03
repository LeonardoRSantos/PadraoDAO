package org.wyden.pdao;

import org.bson.types.ObjectId;
import org.wyden.pdao.dao.impl.PessoaMysqlDao;
import org.wyden.pdao.model.Pessoa;
import org.wyden.pdao.model.Telefone;
import org.wyden.pdao.dao.impl.PessoaDao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) throws SQLException {
        save();
        addMysql();
    }

    private static void save() throws SQLException  {
        Telefone ph1 = new Telefone("021-3424.6494", "021-9144.9446");
        Pessoa p1 = new Pessoa("João Otávio", "de Souza", 22, ph1);
        new PessoaDao().save(p1);

        Telefone ph2 = new Telefone("011-3332.4490", "011-9440.9044");
        Pessoa p2 = new Pessoa("João Mauricio", "Pereira", 29, ph2);
        new PessoaDao().save(p2);


        Telefone ph3 = new Telefone("055-3222.2599", "055-9995.9494");
        Pessoa p3 = new Pessoa("Patricia", "Fagundes de Almeida", 33, ph3);
        new PessoaDao().save(p3);


        List<Pessoa> persons = new PessoaDao().findPersons();
        for (Pessoa person : persons) {
            System.out.println(person.toString());
        }

        List<Pessoa> pessoasMy = new PessoaDao().findPersons();

        for (Pessoa pessoaMy : persons) {
            System.out.println(pessoaMy.toString());
        }

    }

    private static void addMysql() throws SQLException {
        Telefone tel = new Telefone("98989898", "9898989898");
        Pessoa pessoa = new Pessoa("1","Leonardo Rodrigues","Santos",26, tel );

        PessoaMysqlDao pessoaMysqlDao = new PessoaMysqlDao();

        pessoaMysqlDao.insert(pessoa);
        Pessoa p = pessoaMysqlDao.get(1);
        System.out.println(
                "id: "
                        + p.getId() + " \n"
                        + "Primeiro Nome = "
                        + p.getPrimeiroNome() + " \n"
                        + "Ultimo Nome = "
                        + p.getUltimoNome() + " \n"
                        + "Idade = "
                        + p.getIdade() + " \n"
                        + "Telefone = "
                        + p.getTelefone().getTelefone() + " \n"
                        + "Celular =  "
                        + p.getTelefone().getCelular() + " "
        );

    }


















    private static void saveIndex() {
        Telefone ph1 = new Telefone("021-3112.6191", "021-9111.9911");
        Pessoa p1 = new Pessoa("Marcus Luiz", "de Cabral", 26, ph1);
        new PessoaDao().saveWithIndex(p1);


        Telefone ph2 = new Telefone("011-3502.0555", "011-9155.9056");
        Pessoa p2 = new Pessoa("Pedro Luiz", "de Oliveira", 33, ph2);
        new PessoaDao().saveWithIndex(p2);

        Telefone ph3 = new Telefone("055-3525.2552", "055-9525.4454");
        Pessoa p3 = new Pessoa("Pedro Luiz", "Pires de Almeida", 38, ph3);
        new PessoaDao().saveWithIndex(p3);

        List<Pessoa> persons = new PessoaDao().findPersons();
        for (Pessoa person : persons) {
            System.out.println(person.toString());
        }
    }
    private static void update() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("primeiroNome", "Anita");
        Pessoa query = new PessoaDao().findPerson(map);

        Telefone telefone = new Telefone("048-3222.2522", "048-9225.4464");
        Pessoa person = new Pessoa("Anita", "Pires de Almeida", 30, telefone);
        new PessoaDao().update(query, person);

        Pessoa newPerson = new PessoaDao().findPerson(map);
        System.out.println("Old:> " + query + "\nNew:> " + newPerson.toString());
    }

    private static void delete() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("firstName", new ObjectId("João Luiz"));
        List<Pessoa> query = new PessoaDao().findPersons(map);

        for (Pessoa person : query) {
            new PessoaDao().delete(person);
        }

        List<Pessoa> persons = new PessoaDao().findPersons();
        for (Pessoa person : persons) {
            System.out.println(person.toString());
        }
    }


//
//    private static void findMysql() throws SQLException{
//
//        MysqlDaoImpl mysqlDao = new MysqlDaoImpl();
//
//        List<Pessoa> ps = mysqlDao.getPessoa();
//        for (Pessoa allPessoas : ps) {
//            System.out.println(allPessoas);
//        }
//
//    }
//
//    private static void updateMysql() throws SQLException{
//
//        MysqlDaoImpl mysqlDao = new MysqlDaoImpl();
//        Pessoa pessoa = mysqlDao.getPessoa(1);
//        pessoa.setPrimeiroNome("");
//        pessoa.setUltimoNome("");
//        pessoa.setIdade(0);
//        pessoa.getTelefone().setTelefone("");
//        pessoa.getTelefone().setCelular("");
//        mysqlDao.update(pessoa);
//    }
//
//    private static void deleteMysql() throws SQLException{
//        MysqlDaoImpl mysqlDao = new MysqlDaoImpl();
//
//        mysqlDao.delete(1);
//
//    }


}
