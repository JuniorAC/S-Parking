package control;

import javafx.beans.property.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class SaidaControl {

    private static final String URL="jdbc:mariadb://localhost:3306/sparking";
    private static final String USER="root";
    private static final String PASSWORD="";

    private IntegerProperty codigo = new SimpleIntegerProperty();
    private ObjectProperty<LocalDate> dataSaida= new SimpleObjectProperty<>(LocalDate.now());
    private ObjectProperty<LocalTime> horaSaida = new SimpleObjectProperty<>(LocalTime.now());
    private StringProperty placa = new SimpleStringProperty();

    public void gravarSaida(){
        try (Connection con = DriverManager.getConnection(URL,USER,PASSWORD)){
            String sql = String.format("INSERT INTO SAIDA (CODIGO, PLACAVEIC, DATASAIDA, HORASAIDA) VALUES (?, ?, ?, ?);");
            System.out.println("Sql ==> " + sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,codigo.get());
            stmt.setString(2,placa.get());
            stmt.setDate(3, Date.valueOf(((dataSaida.get()))));
            stmt.setTime(4, Time.valueOf(horaSaida.get()));
            int i = stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public int getCodigo() {
        return codigo.get();
    }

    public IntegerProperty codigoProperty() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo.set(codigo);
    }

    public LocalDate getDataSaida() {
        return dataSaida.get();
    }

    public ObjectProperty<LocalDate> dataSaidaProperty() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida.set(dataSaida);
    }

    public LocalTime getHoraSaida() {
        return horaSaida.get();
    }

    public ObjectProperty<LocalTime> horaSaidaProperty() {
        return horaSaida;
    }

    public void setHoraSaida(LocalTime horaSaida) {
        this.horaSaida.set(horaSaida);
    }

    public String getPlaca() {
        return placa.get();
    }

    public StringProperty placaProperty() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa.set(placa);
    }
}
