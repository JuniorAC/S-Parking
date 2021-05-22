package boundary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class Login extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Pane painel = new Pane();
        Scene scn = new Scene(painel, 250, 300);

        Label lblUsusario = new Label("Usuário");
        lblUsusario.relocate(60,40);
        Label lblSenha = new Label("Senha");
        lblSenha.relocate(60, 90);

        TextField txtUsuario = new TextField();
        txtUsuario.relocate(50,60);
        TextField txtSenha = new TextField();
        txtSenha.relocate(50,110);

        Button btnEntrar = new Button("Entrar");
        btnEntrar.relocate(90,150);
        Button btnCadastrar = new Button("Cadastrar");
        btnCadastrar.relocate(80,190);
        painel.getChildren().addAll(lblUsusario, lblSenha, txtUsuario, txtSenha, btnEntrar, btnCadastrar);

        stage.setScene(scn);
        stage.setTitle("S-Parking");
        stage.show();
    }
        public static void main(String[] args) {Application.launch(args);}

    }

