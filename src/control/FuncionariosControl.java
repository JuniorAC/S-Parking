package control;


import entity.Funcionario;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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

    public String getNome() {
        return nome.get();
    }

    public StringProperty nomeProperty() {
        return nome;
    }

    public int getCpf() {
        return cpf.get();
    }

    public IntegerProperty cpfProperty() {
        return cpf;
    }

    public int getTelefone() {
        return telefone.get();
    }

    public IntegerProperty telefoneProperty() {
        return telefone;
    }

    public String getEndereco() {
        return endereco.get();
    }

    public StringProperty enderecoProperty() {
        return endereco;
    }

    public String getUsuario() {
        return usuario.get();
    }

    public StringProperty usuarioProperty() {
        return usuario;
    }

    public String getSenha() {
        return senha.get();
    }

    public StringProperty senhaProperty() {
        return senha;
    }

    public String getCargo() {
        return cargo.get();
    }

    public StringProperty cargoProperty() {
        return cargo;
    }


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
        listFuncionarios.add(f);
    }

    public void loginFuncionario() {

        for (Funcionario f : listFuncionarios) {
                if (f.getUsuario().equals(usuario.get()) && f.getSenha().equals(senha.get())) {
                    System.out.println("ok login realizado com sucesso");
                    //this.setEntity(f);
                } else {
                    System.out.println("senha errada");
                }
            }
        }
    }
