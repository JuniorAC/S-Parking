package boundary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Entrada extends Application {

    //Criação dos TextField
    TextField txtCodigo = new TextField();
    TextField txtDataEntrada = new TextField();
    TextField txtHoraEntrada = new TextField();
    TextField txtPlaca = new TextField();
    TextField txtDono = new TextField();
    TextField txtModelo = new TextField();
    TextField txtCor = new TextField();


    //Criação dos Buttons
    Button btnSair = new Button("Sair");
    Button btnGravar = new Button("Consultar");



    @Override
    public void start(Stage stage) throws Exception {

        Pane painel = new Pane();
        Scene scn = new Scene(painel, 600, 280);

        //Criação Label
        Label lblCodigo = new Label("Código:");
        Label lblDataEntrada = new Label("Data Entrada:");
        Label lblHoraEntrada = new Label("Hora Entrada:");
        Label lblPlaca = new Label("Placa:");
        Label lblDono = new Label("Dono:");
        Label lblModelo = new Label("Modelo:");
        Label lblCor = new Label("Cor:");
        Label lblAvarias = new Label("Avarias");

        Label lblEntrada = new Label("Entrada");
        Label lblDadosDoVeiculo = new Label("Dados do Veiculo");

        //Fonte, estilo tamanho maximo
        lblEntrada.setFont(new Font("Arial", 15));
        lblDadosDoVeiculo.setFont(new Font("Arial", 15));

        txtCodigo.setMaxSize(120, 1);
        txtDataEntrada.setMaxSize(120, 1);
        txtHoraEntrada.setMaxSize(120, 1);
        txtPlaca.setMaxSize(120, 1);
        txtDono.setMaxSize(120, 1);
        txtModelo.setMaxSize(120, 1);
        txtCor.setMaxSize(120, 1);

        btnSair.setMinSize(80, 1);
        btnGravar.setMinSize(80, 1);




        //Set local de exibição
        lblEntrada.relocate(10, 10);
        lblDadosDoVeiculo.relocate(10, 120);

        lblCodigo.relocate(40,40);
        lblDataEntrada.relocate(170, 40);
        lblHoraEntrada.relocate(300, 40);
        txtCodigo.relocate(40, 60);
        txtDataEntrada.relocate(170, 60);
        txtHoraEntrada.relocate(300,60);

        lblPlaca.relocate(25,150);
        lblDono.relocate(25,190);
        lblModelo.relocate(165, 190);
        lblCor.relocate(300, 190);
        lblAvarias.relocate(490, 210);
        txtPlaca.relocate(60,150);
        txtDono.relocate(25,210);
        txtModelo.relocate(165,210);
        txtCor.relocate(300,210);

        btnSair.relocate(15, 230);
        btnGravar.relocate(500, 230);

        painel.getChildren().addAll(lblEntrada,lblCodigo,lblDataEntrada,lblHoraEntrada,txtCodigo,txtDataEntrada,txtHoraEntrada,lblDadosDoVeiculo,lblPlaca,lblDono,lblModelo,lblCor,lblAvarias,txtPlaca,txtDono,txtModelo,txtCor);


        stage.setScene(scn);
        stage.setTitle("Gerente - Manter Vagas");
        stage.show();

    }
}
