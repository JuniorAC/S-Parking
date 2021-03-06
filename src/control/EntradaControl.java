package control;

import javafx.beans.property.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class EntradaControl {
    private static final String URL="jdbc:mariadb://localhost:3306/sparking";
    private static final String USER="root";
    private static final String PASSWORD="";


    private IntegerProperty codigo = new SimpleIntegerProperty();
    private ObjectProperty<LocalDate> dataEntrada = new SimpleObjectProperty<>(LocalDate.now());
    private ObjectProperty<LocalTime> horaEntrada = new SimpleObjectProperty<>(LocalTime.now());
    private StringProperty placa = new SimpleStringProperty();


    public StringProperty placaProperty() {
        return placa;
    }


    public void gravar(){
        try (Connection con = DriverManager.getConnection(URL,USER,PASSWORD)){
            String sql = String.format("INSERT INTO ENTRADA (CODIGO, PLACAVEIC, DATAENTRADA, HORAENTRADA) VALUES (?, ?, ?, ?);");
            System.out.println("Sql ==> " + sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,codigo.get());
            stmt.setString(2,placa.get());
            stmt.setDate(3, Date.valueOf(((dataEntrada.get()))));
            stmt.setTime(4, Time.valueOf(horaEntrada.get()));
            stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }


        System.out.println("Entrada Adicionada");

    }


    public IntegerProperty codigoProperty() {
        return codigo;
    }
    public ObjectProperty<LocalDate> dataEntradaProperty() {
        return dataEntrada;
    }
    public ObjectProperty<LocalTime> horaEntradaProperty() {
        return horaEntrada;
    }

}
