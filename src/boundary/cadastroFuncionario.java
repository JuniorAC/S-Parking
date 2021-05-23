package boundary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class cadastroFuncionario extends Application {
    TextField txtNome = new TextField("Nome");
    TextField txtCPF = new TextField("CPF");
    TextField txtTelefone = new TextField("Telefone");
    TextField txtEndereco = new TextField("endereço");
    TextField txtUsuario = new TextField("Senha");
    TextField txtSenha = new TextField("Usuario");
    TextField txtCargo = new TextField("Cargo");

    Button btnSalvar = new Button("Salvar");



    @Override
    public void start(Stage stage) throws Exception {
        GridPane painel = new GridPane();
        Scene scn = new Scene(painel,230,230);

        Parent tela1 = FXMLLoader.load(getClass().getResource("Login"));


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
        painel.add(lblCargo,0,6);

        painel.add(txtNome, 1,1);
        painel.add(txtCPF,1,2);
        painel.add(txtTelefone,1,3);
        painel.add(txtEndereco,1,4);
        painel.add(txtUsuario,1,5);
        painel.add(txtSenha,1,6);
        painel.add(txtCargo,1,7);

        painel.add(btnSalvar,1,8);


        stage.setScene(scn);
        stage.setTitle("Cadastro funcionario");
        stage.show();


    }
    public static void main(String[] args) {Application.launch(args);}

}

