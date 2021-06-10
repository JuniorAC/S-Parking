package control;


import entity.Veiculo;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VeiculoControl {

    private static final String URL="jdbc:mariadb://localhost:3306/sparking";
    private static final String USER="root";
    private static final String PASSWORD="";


    private IntegerProperty dono = new SimpleIntegerProperty();
    private StringProperty modelo = new SimpleStringProperty();
    private StringProperty cor = new SimpleStringProperty();
    private StringProperty placa = new SimpleStringProperty();
    private IntegerProperty avarias = new SimpleIntegerProperty(0);



        public void setEntity(Veiculo v) {
        if (v != null) {
            dono.set(v.getDono());
            modelo.set(v.getModelo());
            cor.set(v.getCor());
            placa.set(v.getPlaca());
            avarias.set(v.getAvarias());

        }
    }

    public Veiculo getEntity() {
        Veiculo v = new Veiculo();
        v.setDono(dono.get());
        v.setModelo(modelo.get());
        v.setCor(cor.get());
        v.setPlaca(placa.get());
        v.setAvarias(avarias.get());
        return v;
    }


    public void gravar(){
        try (Connection con = DriverManager.getConnection(URL,USER,PASSWORD)){
            String sql = ("INSERT INTO VEICULO (PLACA, CPFDONO, COR, MODELO) VALUES (?, ?, ?, ?);");
            System.out.println("Sql ==> " + sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(2,dono.get());
            stmt.setString(4, modelo.get());
            stmt.setString(3,cor.get());
            stmt.setString(1,placa.get());
            stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }


        System.out.println("Veiculo Adicionada");
    }


    public IntegerProperty donoProperty() {
        return dono;
    }

    public StringProperty modeloProperty() {
        return modelo;
    }

    public StringProperty corProperty() {
        return cor;
    }

    public StringProperty placaProperty() {
        return placa;
    }

}
