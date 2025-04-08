package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.Connect;

public class Stat extends BaseObject {
    String libele;
    public Stat() {
    }

    double montant;
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
         String req = "SELECT previsions.libele AS libele , SUM(previsions.montant) AS montant , SUM(previsions.montant) - SUM(depenses.montant) AS previsions_restant FROM previsions LEFT JOIN depenses ON previsions.id = depenses.id_prevision GROUP by  previsions.libele";
        Statement St = null;
        ResultSet RS = null;
        ArrayList<BaseObject> Temp = new ArrayList<>();

        try {
            St = con.createStatement();
            RS = St.executeQuery(req);

            while (RS.next()) { // Avancer le curseur sur chaque ligne
                String libele = RS.getString("libele");
                String montant = RS.getString("montant");

                String previsions_restant = RS.getString("previsions_restant");
                if(previsions_restant == null || montant.isEmpty()){
                    previsions_restant = montant;
                }
                Stat stat = new Stat(libele , Double.valueOf(previsions_restant));

                Temp.add(stat);

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

    public Stat(String libele, double montant) {
        this.libele = libele;
        this.montant = montant;
    }

    @Override
    public void save() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void save(Connection con) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
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
