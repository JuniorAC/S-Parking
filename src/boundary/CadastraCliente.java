package boundary;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class CadastraCliente extends Application {

    //Criação dos TextField
    TextField txtNome = new TextField();
    TextField txtTelefone = new TextField();
    TextField txtCPF = new TextField();
    TextField txtEndereco = new TextField();
    TextField txtCodigoCliente = new TextField();
    TextField txtDataVencimento = new TextField();
    TextField txtTipoMensalidade = new TextField();


    //Criação dos Buttons
    Button btnSair = new Button("Sair");
    Button btnConsultar = new Button("Consultar");
    Button btnGravar = new Button("Gravar");


    @Override
    public void start(Stage stage) throws Exception {

        Pane painel = new Pane();
        Scene scn = new Scene(painel, 600, 280);

       //Criação Label
        Label lblCliente = new Label("CLIENTE:");
        Label lblNome = new Label("Nome:");
        Label lblTelefone = new Label("Telefone:");
        Label lblCPF = new Label("CPF");
        Label lblEndereco = new Label("Endereço");
        Label lblMensalista = new Label("Mensalista");
        Label lblCodigoCliente = new Label("Código Cliente:");

        Label lblTMensalista = new Label("Mensalista:");
        Label lblDataVencimento = new Label("Data Vencimento:");
        Label lblTipoMensalista = new Label("Tipo Mensalista:");

        //Fonte, estilo tamanho maximo
        lblCliente.setFont(new Font("Arial", 15));
        lblTMensalista.setFont(new Font("Arial", 15));

        txtNome.setMaxSize(150, 1);
        txtTelefone.setMaxSize(150, 1);
        txtCPF.setMaxSize(150, 1);
        txtEndereco.setMaxSize(150, 1);
        txtCodigoCliente.setMaxSize(80, 1);
        txtDataVencimento.setMaxSize(120, 1);
        txtTipoMensalidade.setMaxSize(120, 1);

        btnSair.setMinSize(80, 1);
        btnConsultar.setMinSize(80, 1);
        btnGravar.setMinSize(80, 1);




        //Set local de exibição
        lblCliente.relocate(10, 10);
        lblTMensalista.relocate(10, 140);

        lblNome.relocate(35,35);
        lblTelefone.relocate(250, 35);
        lblCPF.relocate(35, 75);
        lblEndereco.relocate(250, 75);
        lblCodigoCliente.relocate(490, 40);
        lblMensalista.relocate(515,95);

        txtNome.relocate(80,35);
        txtTelefone.relocate(305,35);
        txtCPF.relocate(80, 75);
        txtEndereco.relocate(305, 75);
        txtCodigoCliente.relocate(490, 60);


        lblDataVencimento.relocate(20,165);
        lblTipoMensalista.relocate(250,165);

        txtDataVencimento.relocate(120,165);
        txtTipoMensalidade.relocate(340,165);

        btnSair.relocate(15, 230);
        btnConsultar.relocate(400, 230);
        btnGravar.relocate(500, 230);

        painel.getChildren().addAll(lblCliente,lblTMensalista,lblNome,lblTelefone,lblCPF,lblEndereco,lblCodigoCliente,txtNome,txtTelefone,txtCPF,txtEndereco,txtCodigoCliente,lblMensalista,lblDataVencimento,lblTipoMensalista,txtDataVencimento,txtTipoMensalidade,btnSair,btnGravar,btnConsultar);


        stage.setScene(scn);
        stage.setTitle("Gerente - Manter Vagas");
        stage.show();

    }
}