package boundary;

import control.Funcionarios;
import entity.Funcionario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class Login extends Application {
    private Funcionarios controlFuncionarios = new Funcionarios();
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

        btnEntrar.relocate(90,150);
        btnCadastrar.relocate(80,190);

        painel.getChildren().addAll(lblUsusario, lblSenha, txtUsuario, txtSenha, btnEntrar, btnCadastrar);

        btnEntrar.setOnAction((e)->{
                controlFuncionarios.loginFuncionario(txtUsuario.getText(),txtSenha.getText());
        });

        btnCadastrar.setOnAction((e)-> {

            controlFuncionarios.cadastrar(boudaryToEntity());
        });

       stage.setScene(scn);
       stage.setTitle("S-Parking");
       stage.show();
    }

    //Isso é so para testar a primeira tela, sera necessario criar uma tela de cadastro de funcionarios
        public Funcionario boudaryToEntity()    {
                    Funcionario f = new Funcionario();
                    f.setUsuario(txtUsuario.getText());
                    f.setSenha(txtSenha.getText());//Busca de usuario e senha ja funcionando.
                    return f;
        }//descobrir como utilizar a segunda tela(cadastroFuncionario)

        public void entityToBoundary(Funcionario f){  //ainda nao tem utilidade para essa tela.
            if (f !=null){
            }
        }

        public static void main(String[] args) {Application.launch(args);}

    }

