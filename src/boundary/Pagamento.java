package boundary;

import control.PagamentoControl;
import javafx.beans.binding.Bindings;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.StringConverter;
import javafx.util.converter.DateStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.TimeStringConverter;

public class Pagamento implements TelaStrategy{

    private ExecutarAcoes executarAcoes;

    PagamentoControl pagamentoControl = new PagamentoControl();

    public Pagamento(ExecutarAcoes executarAcoes) {

        this.executarAcoes = executarAcoes;
    }


    @Override
    public Pane gerarTela() {

        BorderPane painel = new BorderPane();
        GridPane painelMid = new GridPane();
        GridPane painelBot = new GridPane();
        GridPane painelTop = new GridPane();

        Label entrada = new Label("ENTRADA");
        Label codigoEntrada = new Label("Código:");
        Label dataEntrada = new Label("Data da Entrada:");
        Label horaEntrada = new Label("Hora da Entrada:");

        Label saida = new Label("SAIDA   ");
        Label codigoSaida = new Label("Código:");
        Label dataSaida = new Label("Data da Saida:");
        Label horaSaida = new Label("Hora da Saida:");

        Label placa = new Label("Placa:");
        Label dono = new Label("Dono:");
        Label modelo = new Label("Modelo:");
        Label cor = new Label("Cor:");
        Label total = new Label("Total");

        TextField txtCodigoEntrada = new TextField();
        TextField txtHoraEntrada = new TextField();
        TextField txtDataEntrada = new TextField();
        TextField txtCodigoSaida = new TextField();
        TextField txtDataSaida = new TextField();
        TextField txtHoraSaida = new TextField();
        TextField txtPlaca = new TextField();
        TextField txtDono = new TextField();
        TextField txtModelo = new TextField();
        TextField txtCor = new TextField();
        TextField txtTotal = new TextField();




        Button btnPesquisar = new Button("Pesquisar");
        Button btnPagar = new Button("Pagar");

        painelTop.add(new Label("PAGAMENTO"),0,0);
        painelTop.add(placa,1,2);
        painelTop.add(txtPlaca,2,2);
        painelTop.add(btnPesquisar,3,2);
        painelTop.add(dono,1,3);
        painelTop.add(txtDono,1,4);
        painelTop.add(modelo,2,3);
        painelTop.add(txtModelo,2,4);
        painelTop.add(cor,3,3);
        painelTop.add(txtCor,3,4);

        painelTop.setHgap(5);
        painel.setTop(painelTop);


        painelMid.add(entrada,0,0);
        painelMid.add(codigoEntrada,1,1);
        painelMid.add(txtCodigoEntrada,1,2);
        painelMid.add(dataEntrada,2,1);
        painelMid.add(txtDataEntrada,2,2);
        painelMid.add(horaEntrada,3,1);
        painelMid.add(txtHoraEntrada,3,2);

        painelMid.add(saida,0,3);
        painelMid.add(codigoSaida,1,4);
        painelMid.add(txtCodigoSaida,1,5);
        painelMid.add(dataSaida,2,4);
        painelMid.add(txtDataSaida,2,5);
        painelMid.add(horaSaida,3,4);
        painelMid.add(txtHoraSaida,3,5);

        painelMid.setHgap(5);
        painel.setCenter(painelMid);




        painelBot.add(btnPagar, 6, 1);
        painelBot.add(total,1,1);
        painelBot.add(txtTotal,2,1);

        painelBot.setHgap(5);
        painel.setBottom(painelBot);


        //adcionar as bindings

        StringConverter integerToStringConverter = new IntegerStringConverter();
        StringConverter DateToStringConverter = new DateStringConverter();
        StringConverter TimeToStringConverter = new TimeStringConverter();


        Bindings.bindBidirectional(txtDono.textProperty(), pagamentoControl.donoProperty(),  integerToStringConverter);
        Bindings.bindBidirectional(txtModelo.textProperty(), pagamentoControl.modeloProperty());
        Bindings.bindBidirectional(txtCor.textProperty(), pagamentoControl.corProperty());
        Bindings.bindBidirectional(txtPlaca.textProperty(), pagamentoControl.placaDigitadaProperty());

        Bindings.bindBidirectional(txtCodigoEntrada.textProperty(), pagamentoControl.codigoEntradaProperty(),  integerToStringConverter);
        Bindings.bindBidirectional(txtDataEntrada.textProperty(), pagamentoControl.dataEntradaProperty(),DateToStringConverter);
        Bindings.bindBidirectional(txtHoraEntrada.textProperty(), pagamentoControl.horaEntradaProperty(),TimeToStringConverter);
        Bindings.bindBidirectional(txtPlaca.textProperty(), pagamentoControl.placaEntradaProperty());

        Bindings.bindBidirectional(txtCodigoSaida.textProperty(), pagamentoControl.codigoSaidaProperty(),integerToStringConverter);
        Bindings.bindBidirectional(txtPlaca.textProperty(), pagamentoControl.placaSaidaProperty());
        Bindings.bindBidirectional(txtDataSaida.textProperty(), pagamentoControl.dataSaidaProperty(), DateToStringConverter);
        Bindings.bindBidirectional(txtHoraSaida.textProperty(), pagamentoControl.horaSaidaProperty(), TimeToStringConverter);

        btnPesquisar.setOnAction((e)->{
            pagamentoControl.lerVeiculo();
            pagamentoControl.lerEntrada();
            pagamentoControl.lerSaida();
            pagamentoControl.CalcularTotal();
        });

        btnPagar.setOnAction((e)->{
            System.out.println("Pagamento realizado");
            executarAcoes.executarAcao("Login");
        });

        return painel;
    }
}
