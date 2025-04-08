package model;
import java.sql.Connection;
import java.util.ArrayList;

public abstract class BaseObject {
    protected int id;
    public BaseObject(){

    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    
    protected abstract ArrayList<BaseObject> findAll() throws Exception ;
    protected abstract ArrayList<BaseObject> findAll(Connection con) throws Exception ;

    protected abstract void save()  throws Exception;
    protected abstract void save(Connection con)  throws Exception;
    
    protected abstract BaseObject getById(String num) throws Exception;
    protected abstract BaseObject getById(String num,Connection con ) throws Exception;
    
    protected abstract void delete(int id) throws Exception;
    protected abstract void delete(int id , Connection con) throws Exception;

    protected abstract void update() throws Exception;
    protected abstract void update(Connection con) throws Exception;
}
