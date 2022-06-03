package org.wyden.pdao.dao.impl;

import org.wyden.pdao.connection.MySQLConnector;
import org.wyden.pdao.dao.IDaoMysql;
import org.wyden.pdao.model.Pessoa;
import org.wyden.pdao.model.Telefone;

import java.sql.*;

public class PessoaMysqlDao implements IDaoMysql<Pessoa> {

    private static MySQLConnector mySQLConnector;
    private PreparedStatement ps = null;
    private Connection connection;

    public PessoaMysqlDao() {
        connection = MySQLConnector.getConnection();
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void insert(Pessoa ob) {
        try {
            ps = mySQLConnector.getConnection().prepareStatement("INSERT INTO pessoas VALUES(?,?,?,?,?,?)");
            ps.setString(1, ob.getId());
            ps.setString(2, ob.getPrimeiroNome());
            ps.setString(3, ob.getUltimoNome());
            ps.setInt(4, ob.getIdade());
            ps.setString(5, ob.getTelefone().getTelefone());
            ps.setString(6, ob.getTelefone().getCelular());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(Pessoa ob) {

    }

    @Override
    public Pessoa get(int id) {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Pessoa pessoa = null;
            Telefone telefone2 = null;
            try{
                ps = mySQLConnector.getConnection().prepareStatement("SELECT * FROM pessoas WHERE Id=?");
                ps.setInt(1, id);
                rs = ps.executeQuery();
                //rs = ps.executeQuery("SELECT * FROM pessoas where Id = ? ;");
                if (rs.next()){


                    String idP = rs.getString("id");
                    String primeironome = rs.getString("primeiroNome");
                    String ultimonome = rs.getString("ultimoNome");
                    int idade = rs.getInt("idade");
                    String telefone = rs.getString("telefone");
                    String celular = rs.getString("celular");

                    pessoa = new Pessoa();
                    telefone2 = new Telefone();
                    pessoa.setId(idP);
                    pessoa.setPrimeiroNome(primeironome);
                    pessoa.setUltimoNome(ultimonome);
                    pessoa.setIdade(idade);
                    telefone2.setTelefone(telefone);
                    telefone2.setCelular(celular);
                    pessoa.setTelefone(telefone2);



                }

            }catch (SQLException e){
                e.printStackTrace();
            }
            return pessoa;
        }

    }

