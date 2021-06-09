package control;



import entity.Vaga;
import javafx.beans.property.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class VagasControl {

    private static final String URL="jdbc:mariadb://localhost:3306/sparking";
    private static final String USER="root";
    private static final String PASSWORD="";

    private List<Vaga> listVagas = new ArrayList<>();

    private IntegerProperty numero = new SimpleIntegerProperty();
    private IntegerProperty piso = new SimpleIntegerProperty();
    private StringProperty tipoVaga = new SimpleStringProperty();
    private IntegerProperty disponibilidade = new SimpleIntegerProperty(0);


    public void setEntity(Vaga v) {
        if (v != null) {
           numero.set(v.getNumero());
           piso.set(v.getPiso());
           tipoVaga.set(v.getTipoVaga());
           disponibilidade.set(v.getDisponibilidade());
          ;
        }
    }

    public Vaga getEntity() {
        Vaga v = new Vaga();
        v.setNumero(numero.get());
        v.setPiso(piso.get());
        v.setTipoVaga(tipoVaga.get());
        v.setDisponibilidade(disponibilidade.get());
        return v;
    }

    public void adicionarvaga(){

        try (Connection con = DriverManager.getConnection(URL,USER,PASSWORD)){
            String sql = String.format("INSERT INTO VAGA (NUMERO, PISO, TIPOVAGA, DISPONIBILIDADE) VALUES (?, ?, ?, ?);");
            System.out.println("Sql ==> " + sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,numero.get());
            stmt.setInt(2, piso.get());
            stmt.setString(3,tipoVaga.get());
            stmt.setInt(4,disponibilidade.get());
            int i = stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }

        this.setEntity(new Vaga());
        System.out.println("Vaga Adicionada");
    }

    public void pesquisarVaga(){

        try (Connection con = DriverManager.getConnection(URL,USER,PASSWORD)){
            String sql = "SELECT * FROM VAGA WHERE numero = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,numero.get());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Vaga v = new Vaga();
                v.setNumero(rs.getInt("numero"));
                v.setPiso(rs.getInt("piso"));
                v.setTipoVaga(rs.getString("tipovaga"));
                v.setDisponibilidade(rs.getInt("disponibilidade"));
                this.setEntity(v);
            }
            int i = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterarVaga(){
        try (Connection con = DriverManager.getConnection(URL,USER,PASSWORD)){
            String sql = String.format("UPDATE VAGA SET PISO= ?, TIPOVAGA=?, DISPONIBILIDADE=? WHERE numero = ?;");
            System.out.println("Sql ==> " + sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(4,numero.get());
            stmt.setInt(1, piso.get());
            stmt.setString(2,tipoVaga.get());
            stmt.setInt(3,disponibilidade.get());
            int i = stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }

        this.setEntity(new Vaga());
        System.out.println("Realizado alteração na vaga");
    }




    public void deletarVaga(){

        try (Connection con = DriverManager.getConnection(URL,USER,PASSWORD)){
            String sql = String.format("DELETE FROM VAGA WHERE numero = ?;");
            System.out.println("Sql ==> " + sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,numero.get());
            int i = stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("Vaga deletada");
    }





    public int getNumero() {
        return numero.get();
    }
    public IntegerProperty numeroProperty() {
        return numero;
    }
    public int getPiso() {
        return piso.get();
    }
    public IntegerProperty pisoProperty() {
        return piso;
    }
    public String getTipovaga() {
        return tipoVaga.get();
    }
    public StringProperty tipovagaProperty() {
        return tipoVaga;
    }

    public int getDisponibilidade() {
        return disponibilidade.get();
    }

    public IntegerProperty disponibilidadeProperty() {
        return disponibilidade;
    }

    public void setDisponibilidade(int disponibilidade) {
        this.disponibilidade.set(disponibilidade);
    }
}
