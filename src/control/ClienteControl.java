package control;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.*;

public class ClienteControl {

    private static final String URL="jdbc:mariadb://localhost:3306/sparking";
    private static final String USER="root";
    private static final String PASSWORD="";

    private StringProperty nome = new SimpleStringProperty();
    private IntegerProperty cpf = new SimpleIntegerProperty();
    private IntegerProperty telefone = new SimpleIntegerProperty();
    private StringProperty endereco = new SimpleStringProperty();
    private IntegerProperty codigoCliente = new SimpleIntegerProperty();


    public void pesquisar(){

        try (Connection con = DriverManager.getConnection(URL,USER,PASSWORD)){
            String sql = "SELECT * FROM cliente WHERE codcliente = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,codigoCliente.get());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                this.setNome(rs.getString("nome"));
                this.setCpf(rs.getInt("cpf"));
                this.setTelefone(rs.getInt("telefone"));
                this.setEndereco(rs.getString("endereco"));
                this.setCodigoCliente(rs.getInt("codcliente"));
            } else{
                System.out.println("Cliente não localizado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void gravar(){

        try (Connection con = DriverManager.getConnection(URL,USER,PASSWORD)){
            String sql = String.format("INSERT INTO CLIENTE (NOME, CPF, TELEFONE, ENDERECO, CODCLIENTE) VALUES (?, ?, ?, ?, ?);");
            System.out.println("Sql ==> " + sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome.get());
            stmt.setInt(2, cpf.get());
            stmt.setInt(3,telefone.get());
            stmt.setString(4,endereco.get());
            stmt.setInt(5,codigoCliente.get());
            int i = stmt.executeUpdate();
            System.out.println("Cliente Gravado com Sucesso");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    public StringProperty nomeProperty() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public IntegerProperty cpfProperty() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf.set(cpf);
    }

    public IntegerProperty telefoneProperty() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone.set(telefone);
    }

    public StringProperty enderecoProperty() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco.set(endereco);
    }

    public IntegerProperty codigoClienteProperty() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente.set(codigoCliente);
    }
}
