package boundary;

import control.LoginControl;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Login extends Application {

    private LoginControl controlLogin = new LoginControl();

    Button btnEntrar = new Button("Entrar");
    Button btnCadastrar = new Button("Cadastrar");

    TextField txtUsuario = new TextField();
    TextField txtSenha = new TextField();

    @Override
    public void start(Stage stage) throws Exception {

        Pane painel = new Pane();
        Scene scn = new Scene(painel, 250, 300);

        Label lblUsusario = new Label("Usuário");
        lblUsusario.relocate(60,40);
        Label lblSenha = new Label("Senha");
        lblSenha.relocate(60, 90);

        txtUsuario.relocate(50,60);
        txtSenha.relocate(50,110);

        btnEntrar.relocate(90,160);
        btnCadastrar.relocate(80,200);

        painel.getChildren().addAll(lblUsusario, lblSenha, txtUsuario, txtSenha, btnEntrar, btnCadastrar);

        Bindings.bindBidirectional(txtUsuario.textProperty(), controlLogin.usuarioProperty());
        Bindings.bindBidirectional(txtSenha.textProperty(), controlLogin.senhaProperty());

        btnEntrar.setOnAction((e)->{controlLogin.loginFuncionario(); });

        btnCadastrar.setOnAction((e)-> {
            //Necessario chamar tela de cadastro funcionario
        });


       stage.setScene(scn);
       stage.setTitle("S-Parking");
       stage.show();
    }

        public static void main(String[] args) {Application.launch(args);}

    }

