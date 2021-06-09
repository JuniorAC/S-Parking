package boundary;

import control.VagasControl;
import javafx.beans.binding.Bindings;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;


public class GestaoVagas implements TelaStrategy{

    private ExecutarAcoes executarAcoes;

    public GestaoVagas(ExecutarAcoes executarAcoes) {
        this.executarAcoes = executarAcoes;
    }

    @Override
    public Pane gerarTela() {

        VagasControl vagaC = new VagasControl();

        TextField txtNumero = new TextField();
        TextField txtPiso = new TextField();
        TextField txtTipoVaga = new TextField();

        Button btnAdicionar = new Button("Adicionar Vaga");
        Button btnPesquisar = new Button("Pesqusar Vaga");
        Button btnAlterar = new Button("Alterar Vaga");
        Button btnDeletar = new Button("Deletar Vaga");
        Button btnSair = new Button("Sair");

        Pane painel = new Pane();

        Label lblNumero = new Label("Numero:");
        Label lblPiso = new Label("Piso:");
        Label lblTipoVaga = new Label("Tipo de Vaga:");

        Label lblUsuario = new Label("Bem vindo: Usuario ");
        Label lblGestãodeVagas = new Label("Gestão de Vagas ");


        lblUsuario.setFont(new Font("Arial", 18));
        lblGestãodeVagas.setFont(new Font("Arial", 15));

        txtNumero.setMaxSize(80,1);
        txtPiso.setMaxSize(80,1);
        txtTipoVaga.setMaxSize(80,1);

        btnAdicionar.setMinSize(100,1);
        btnPesquisar.setMinSize(100,1);
        btnAlterar.setMinSize(100,1);
        btnDeletar.setMinSize(100,1);
        btnSair.setMinSize(100,1);


        lblUsuario.relocate(150,10);
        lblGestãodeVagas.relocate(10,40);

        lblNumero.relocate(15,60);
        lblPiso.relocate(120,60);
        lblTipoVaga.relocate(225,60);

        txtNumero.relocate(15,80);
        txtPiso.relocate(120,80);
        txtTipoVaga.relocate(225,80);

        btnAdicionar.relocate(15,115);
        btnPesquisar.relocate(120,115);
        btnAlterar.relocate(225,115);
        btnDeletar.relocate(330,115);
        btnSair.relocate(360,150);

        painel.getChildren().addAll(lblNumero,lblPiso,lblTipoVaga,lblUsuario,lblGestãodeVagas,txtNumero,txtPiso,txtTipoVaga,btnAdicionar,btnAlterar,btnSair,btnDeletar,btnPesquisar);

        StringConverter integerToStringConverter = new IntegerStringConverter();
        Bindings.bindBidirectional(txtNumero.textProperty(), vagaC.numeroProperty(), integerToStringConverter);
        Bindings.bindBidirectional(txtPiso.textProperty(), vagaC.pisoProperty(), integerToStringConverter);
        Bindings.bindBidirectional(txtTipoVaga.textProperty(), vagaC.tipovagaProperty());


        btnAdicionar.setOnAction((e)->{vagaC.adicionarvaga(); });
        btnPesquisar.setOnAction((e)->{vagaC.pesquisarVaga(); });
        btnAlterar.setOnAction((e)->{vagaC.alterarVaga(); });
        btnDeletar.setOnAction((e)->{vagaC.deletarVaga(); });
        btnSair.setOnAction((e)->{
            executarAcoes.executarAcao("Login"); });

        return painel;
    }
}
