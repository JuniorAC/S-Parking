package boundary;

import control.LoginControl;
import javafx.beans.binding.Bindings;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


public class Login implements TelaStrategy {

    private ExecutarAcoes executor;

    public Login(ExecutarAcoes executor){

        this.executor = executor;
    }

    private LoginControl controlLogin = new LoginControl();

    @Override
    public Pane gerarTela() {

        Button btnEntrar = new Button("Entrar");
        Button btnCadastrar = new Button("Cadastrar");

        TextField txtUsuario = new TextField();
        TextField txtSenha = new TextField();

        Pane painel = new Pane();

        Label lblUsusario = new Label("Usuário");
        lblUsusario.relocate(300, 40);
        Label lblSenha = new Label("Senha");
        lblSenha.relocate(300, 90);

        txtUsuario.relocate(300, 60);
        txtSenha.relocate(300, 110);

        btnEntrar.relocate(350, 160);
        btnCadastrar.relocate(340, 200);

        painel.getChildren().addAll(lblUsusario, lblSenha, txtUsuario, txtSenha, btnEntrar, btnCadastrar);


        Bindings.bindBidirectional(txtUsuario.textProperty(), controlLogin.usuarioProperty());
        Bindings.bindBidirectional(txtSenha.textProperty(), controlLogin.senhaProperty());

        btnEntrar.setOnAction((e) -> {
            String acao = controlLogin.loginFuncionario();
            executor.executarAcao(acao);
        });

        btnCadastrar.setOnAction((e) -> {
            executor.executarAcao("CadastroFuncionario");
        });

        return painel;
    }
}

