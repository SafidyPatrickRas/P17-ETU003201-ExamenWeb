package model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Depense extends BaseObject {
    private int id_prevision;
    private double montant;

    @Override
    public ArrayList<BaseObject> findAll() throws Exception {
        Connection con = null;
        ArrayList<BaseObject> Temp = new ArrayList<>();
        try {
            con = Connect.getConnection();
            Temp = this.findAll(con);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null)
                con.close();
        }
        return Temp;
    }

    @Override
    public ArrayList<BaseObject> findAll(Connection con) throws Exception {
        // TODO Auto-generated method stub
        String req = "SELECT * FROM depenses";
        Statement St = null;
        ResultSet RS = null;
        ArrayList<BaseObject> Temp = new ArrayList<>();

        try {
            St = con.createStatement();
            RS = St.executeQuery(req);

            while (RS.next()) { // Avancer le curseur sur chaque ligne
                int id = RS.getInt("");
                double montant = RS.getDouble("");
                Depense d = new Depense(id, id_prevision , montant);

                Temp.add(d);

                // Ajouter l'objet à la liste (si nécessaire)
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (RS != null)
                RS.close(); // Toujours fermer le ResultSet
            if (St != null)
                St.close(); // Toujours fermer le Statement
        }
        return Temp;
    }

    @Override
    public void save() throws Exception {
        Connection con = null;
        try {
            con = Connect.getConnection();
            this.save(con);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null)
                con.close();
        }
    }

    @Override
    public void save(Connection con) throws Exception {
        // TODO Auto-generated method stub
        Statement St = null;
        try {
            St = con.createStatement();
            String sql = String.format("INSERT INTO depenses (id_prevision , montant) VALUES ( %s , %f )" ,this.getId_prevision() ,this.getMontant());
            System.out.println(sql);
            St.execute(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            St.close();
        }
    }

    @Override
    public BaseObject getById(String num) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public BaseObject getById(String num, Connection con) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public void delete(int id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void delete(int id, Connection con) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void update() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void update(Connection con) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }


    public void setMontant(double montant) {
        this.montant = montant;
    }
    public void setId_prevision(int id_prevision) {
        this.id_prevision = id_prevision;
    }

    public int getId_prevision() {
        return id_prevision;
    }


    public double getMontant() {
        return montant;
    }

    public Depense(int id , int id_prevision, double montant) {
        setId(id);
        setId_prevision(id_prevision);
        setMontant(montant);
    }
    public Depense(int id_prevision, double montant) {
        setId_prevision(id_prevision);
        setMontant(montant);
    }
    public Depense() {

    }

}
