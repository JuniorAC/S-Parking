package boundary;

import control.FuncionariosControl;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

public class CadastroFuncionario extends Application {
    TextField txtNome = new TextField();
    TextField txtCPF = new TextField();
    TextField txtTelefone = new TextField();
    TextField txtEndereco = new TextField();
    TextField txtUsuario = new TextField();
    TextField txtSenha = new TextField();
    TextField txtCargo = new TextField();

    Button btnSalvar = new Button("Salvar");

    private FuncionariosControl controlFuncionarios = new FuncionariosControl();



    @Override
    public void start(Stage stage) throws Exception {

        GridPane painel = new GridPane();
        Scene scn = new Scene(painel,230,230);

        Label lblNome = new Label(" Nome");
        Label lblCPF = new Label(" CPF");
        Label lblTelefone = new Label(" Telefone");
        Label lblEndereco = new Label(" Endereço");
        Label lblUsuario = new Label(" Usuario");
        Label lblSenha = new Label(" Senha");
        Label lblCargo = new Label(" Cargo");

        painel.add(lblNome , 0,1);
        painel.add(lblCPF,0,2);
        painel.add(lblTelefone, 0, 3);
        painel.add(lblEndereco,0,4);
        painel.add(lblUsuario,0,5);
        painel.add(lblSenha,0,6);
        painel.add(lblCargo,0,7);

        painel.add(txtNome, 1,1);
        painel.add(txtCPF,1,2);
        painel.add(txtTelefone,1,3);
        painel.add(txtEndereco,1,4);
        painel.add(txtUsuario,1,5);
        painel.add(txtSenha,1,6);
        painel.add(txtCargo,1,7);

        painel.add(btnSalvar,1,8);

        StringConverter integerToStringConverter = new IntegerStringConverter();

        Bindings.bindBidirectional(txtNome.textProperty(), controlFuncionarios.nomeProperty());
        Bindings.bindBidirectional(txtCPF.textProperty(), controlFuncionarios.cpfProperty(), integerToStringConverter);
        Bindings.bindBidirectional(txtTelefone.textProperty(), controlFuncionarios.telefoneProperty(), integerToStringConverter);
        Bindings.bindBidirectional(txtEndereco.textProperty(), controlFuncionarios.enderecoProperty());
        Bindings.bindBidirectional(txtUsuario.textProperty(), controlFuncionarios.usuarioProperty());
        Bindings.bindBidirectional(txtSenha.textProperty(), controlFuncionarios.senhaProperty());
        Bindings.bindBidirectional(txtCargo.textProperty(), controlFuncionarios.cargoProperty());



        btnSalvar.setOnAction((e)-> {
        controlFuncionarios.salvar();

        });



        stage.setScene(scn);
        stage.setTitle("Cadastro funcionario");
        stage.show();


    }

    public static void main(String[] args) {Application.launch(args);}

}

