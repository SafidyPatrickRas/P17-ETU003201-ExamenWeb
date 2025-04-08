package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.Connect;

public class Prevision extends BaseObject {
    private String libele;
    private double montant;

    public ArrayList<BaseObject> findAllGrouped() throws Exception {
        // TODO Auto-generated method stub
        // TODO Auto-generated method stub
        String req = "SELECT * FROM previsions GROUP BY libele";
        Statement St = null;
        ResultSet RS = null;
        Connection con = null ;
        ArrayList<BaseObject> Temp = new ArrayList<>();

        try {
            con = Connect.getConnection();
            St = con.createStatement();
            RS = St.executeQuery(req);

            while (RS.next()) { // Avancer le curseur sur chaque ligne
                int id = RS.getInt("id");
                String libele = RS.getString("libele");
                double montant = RS.getDouble("montant");
                Prevision p = new Prevision(id, libele, montant);

                Temp.add(p);

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


    public static double sumMontantById(String libele, Connection con) throws Exception{
        String req = "SELECT SUM(montant) AS montant FROM previsions WHERE libele = '" + libele + "'";
        Statement St = null;
        ResultSet RS = null;
        double montant = 0;

        try {
            St = con.createStatement();
            RS = St.executeQuery(req);

            while (RS.next()) { // Avancer le curseur sur chaque ligne
                montant = RS.getDouble("montant");
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
        return montant;
    }

    @Override
    public ArrayList<BaseObject> findAll() throws Exception {
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub
        String req = "SELECT * FROM previsions";
        Statement St = null;
        ResultSet RS = null;
        ArrayList<BaseObject> Temp = new ArrayList<>();

        try {
            St = con.createStatement();
            RS = St.executeQuery(req);

            while (RS.next()) { // Avancer le curseur sur chaque ligne
                int id = RS.getInt("id");
                String libele = RS.getString("libele");
                double montant = RS.getDouble("montant");
                Prevision p = new Prevision(id, libele, montant);

                Temp.add(p);

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
        // TODO Auto-generated method stub
        Statement St = null;
        try {
            St = con.createStatement();
            String sql = String.format("INSERT INTO previsions (libele , montant) VALUES ('%s' , %f)", this.getLibele(),
                    this.getMontant());
            System.out.println(sql);
            St.execute(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            St.close();
        }
    }

    @Override
    public BaseObject getById(String id) throws Exception {
        // TODO Auto-generated method stub
        Connection con = null;
        BaseObject result = null;
        try {
            con = Connect.getConnection();
            result = getById(id, con);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null)
                con.close();
        }
        return result;
    }

    @Override
    public BaseObject getById(String idFind, Connection con) throws Exception {
        // TODO Auto-generated method stub
        // TODO Auto-generated method stub
        String req = "SELECT * FROM previsions WHERE id = " + idFind + "";
        Statement St = null;
        ResultSet RS = null;
        BaseObject result = null;

        try {
            St = con.createStatement();
            RS = St.executeQuery(req);

            while (RS.next()) { // Avancer le curseur sur chaque ligne
                int id = RS.getInt("id");
                String libele = RS.getString("libele");
                double montant = RS.getDouble("montant");

                result = new  Prevision(id, libele, montant);
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
        return result;
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

    public Prevision() {

    }

    public Prevision(int id, String libele, double montant) {
        setId(id);
        setLibele(libele);
        setMontant(montant);
    }

    public Prevision(String libele, double montant) {
        this.libele = libele;
        this.montant = montant;
    }

    public String getLibele() {
        return libele;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

}
