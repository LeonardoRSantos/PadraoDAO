package org.wyden.pdao.dao;



public interface IDaoMysql<T> {

    public abstract void delete(int id);
    public abstract void insert (T ob);
    public abstract void update (T ob);
    public abstract T get(int id);
}
