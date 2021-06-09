package control;

import entity.Funcionario;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginControl {

    private static final String URL="jdbc:mariadb://localhost:3306/sparking";
    private static final String USER="root";
    private static final String PASSWORD="";

    private StringProperty usuario = new SimpleStringProperty();
    private StringProperty senha = new SimpleStringProperty();


    public List<Funcionario> consultarFuncionario() {
        List<Funcionario> lista = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL,USER,PASSWORD)){
            String sql = "SELECT * FROM funcionario WHERE usuario = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.get());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Funcionario f = new Funcionario();
                f.setUsuario(rs.getString("usuario"));
                f.setSenha(rs.getString("senha"));
                f.setCargo(rs.getString("cargo"));
                lista.add(f);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }

    public String loginFuncionario() {

        String acao="erro";

        if(usuario.get()==null){
            System.out.println("Digite o Usuário");
        }else{
            List<Funcionario> listaFuncionarios = consultarFuncionario();
            if(listaFuncionarios.isEmpty()){
                System.out.println("Usuário não localizado");
            }else{
                for (Funcionario f : listaFuncionarios) {
                    if (f.getUsuario().equals(usuario.get()) && f.getSenha().equals(senha.get())) {
                        System.out.println("ok login realizado com sucesso");

                        if(f.getCargo().equals("GERENTE")){
                            acao = "MenuGerente";
                        } else{
                            acao = "GestaoEntrada";
                        }

                    } else {
                        System.out.println("senha ou usuário incorreto");
                    }
                }
            }
        }

        return acao;
    }

    public StringProperty usuarioProperty() {
        return usuario;
    }

    public StringProperty senhaProperty() {
        return senha;
    }

}
