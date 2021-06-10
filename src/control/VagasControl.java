package control;



import entity.Vaga;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;


public class VagasControl {

    private static final String URL="jdbc:mariadb://localhost:3306/sparking";
    private static final String USER="root";
    private static final String PASSWORD="";

    private ObservableList<Vaga> listVagas = FXCollections.observableArrayList();
    private TableView<Vaga> table = new TableView<>();

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
            String sql =("INSERT INTO VAGA (NUMERO, PISO, TIPOVAGA, DISPONIBILIDADE) VALUES (?, ?, ?, ?);");
            System.out.println("Sql ==> " + sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,numero.get());
            stmt.setInt(2, piso.get());
            stmt.setString(3,tipoVaga.get());
            stmt.setInt(4,disponibilidade.get());
            stmt.executeUpdate();
            organizaTable();
            System.out.println("Vaga Adicionada");
        } catch (SQLException e){
            //e.printStackTrace();
            System.out.println("Dados informados conflitantes");
        }

        this.setEntity(new Vaga());

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
                organizaTable();
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterarVaga(){
        try (Connection con = DriverManager.getConnection(URL,USER,PASSWORD)){
            String sql = ("UPDATE VAGA SET PISO= ?, TIPOVAGA=?, DISPONIBILIDADE=? WHERE numero = ?;");
            System.out.println("Sql ==> " + sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(4,numero.get());
            stmt.setInt(1, piso.get());
            stmt.setString(2,tipoVaga.get());
            stmt.setInt(3,disponibilidade.get());
            stmt.executeUpdate();
            organizaTable();
            System.out.println("Realizado alteração na vaga");
        } catch (SQLException e){
            e.printStackTrace();

        }

        this.setEntity(new Vaga());

    }




    public void deletarVaga(){

        try (Connection con = DriverManager.getConnection(URL,USER,PASSWORD)){
            String sql = ("DELETE FROM VAGA WHERE numero = ?;");
            System.out.println("Sql ==> " + sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,numero.get());
            stmt.executeUpdate();
            organizaTable();
            System.out.println("Vaga deletada");
        } catch (SQLException e){
            e.printStackTrace();

        }


    }

    public TableView<Vaga> getTable() {
        return table;
    }

    public void generatedTable(){
        organizaTable();
    TableColumn<Vaga, Integer> colNumero = new TableColumn<>("Numero");
    colNumero.setCellValueFactory(new PropertyValueFactory<>("Numero"));

    TableColumn<Vaga, Integer> colPiso = new TableColumn<>("Piso");
    colPiso.setCellValueFactory(new PropertyValueFactory<>("Piso"));
    TableColumn<Vaga, String> coltipovaga = new TableColumn<>("Tipo de Vaga");
    coltipovaga.setCellValueFactory(new PropertyValueFactory<>("TipoVaga"));
    TableColumn<Vaga, Integer> colDisponibilidade = new TableColumn<>("Disponibilidade");
    colDisponibilidade.setCellValueFactory(new PropertyValueFactory<>("disponibilidade"));

    table.getColumns().addAll(colNumero,colPiso,coltipovaga,colDisponibilidade);

    table.setItems(listVagas);
}

    public void  organizaTable() {
        listVagas.clear();
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM VAGA";
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Vaga v = new Vaga();
                v.setNumero(rs.getInt("numero"));
                v.setPiso(rs.getInt("piso"));
                v.setTipoVaga(rs.getString("tipovaga"));
                v.setDisponibilidade(rs.getInt("disponibilidade"));
                listVagas.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public IntegerProperty numeroProperty() {
        return numero;
    }

    public IntegerProperty pisoProperty() {
        return piso;
    }

    public StringProperty tipovagaProperty() {
        return tipoVaga;
    }

}
