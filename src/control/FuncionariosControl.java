package control;


import entity.Funcionario;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionariosControl {
    private List<Funcionario> listFuncionarios = new ArrayList<>();

    private StringProperty nome = new SimpleStringProperty();
    private IntegerProperty cpf = new SimpleIntegerProperty();
    private IntegerProperty telefone = new SimpleIntegerProperty();
    private StringProperty endereco = new SimpleStringProperty();
    private StringProperty usuario = new SimpleStringProperty();
    private StringProperty senha = new SimpleStringProperty();
    private StringProperty cargo = new SimpleStringProperty();

    private static final String URL="jdbc:mariadb://localhost:3306/sparking";
    private static final String USER="root";
    private static final String PASSWORD="";


    public void setEntity(Funcionario f) {

        if (f != null) {
            nome.set(f.getNome());
            cpf.set(f.getCpf());
            telefone.set(f.getTelefone());
            endereco.set(f.getEndereco());
            usuario.set(f.getUsuario());
            senha.set(f.getSenha());
            cargo.set(f.getCargo());
        }
    }

    public Funcionario getEntity() {
        Funcionario f = new Funcionario();

        f.setNome(nome.get());
        f.setCpf(cpf.get());
        f.setTelefone(telefone.get());
        f.setEndereco(endereco.get());
        f.setUsuario(usuario.get());
        f.setSenha(senha.get());
        f.setCargo(cargo.get());

        return f;
    }


    public void salvar() {
        Funcionario f = getEntity();

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)){
            String sql = "INSERT INTO funcionario " +
                    "(CPF, NOME, TELEFONE, ENDERECO, USUARIO, SENHA, CARGO) VALUES"+
                    "(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,f.getCpf());
            stmt.setString(2,f.getNome());
            stmt.setInt(3,f.getTelefone());
            stmt.setString(4,f.getEndereco());
            stmt.setString(5,f.getUsuario());
            stmt.setString(6,f.getSenha());
            stmt.setString(7,f.getCargo());
            int i = stmt.executeUpdate();

            System.out.println("Linhas afetadas: "+i + "\nFuncionário Salvo");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public StringProperty nomeProperty() {
        return nome;
    }

    public IntegerProperty cpfProperty() {
        return cpf;
    }

    public IntegerProperty telefoneProperty() {
        return telefone;
    }

    public StringProperty enderecoProperty() {
        return endereco;
    }

    public StringProperty usuarioProperty() {
        return usuario;
    }

    public StringProperty senhaProperty() {
        return senha;
    }

    public StringProperty cargoProperty() {
        return cargo;
    }
}
