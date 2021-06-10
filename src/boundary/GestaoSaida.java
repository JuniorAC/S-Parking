package boundary;

import control.SaidaControl;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LocalDateStringConverter;
import javafx.util.converter.LocalTimeStringConverter;

public class GestaoSaida implements TelaStrategy {

    private ExecutarAcoes executarAcoes;

    SaidaControl saidaControl = new SaidaControl();

    public GestaoSaida(ExecutarAcoes executarAcoes) {
        this.executarAcoes = executarAcoes;
    }


    @Override
    public Pane gerarTela() {
        BorderPane painel = new BorderPane();
        GridPane painelTop = new GridPane();
        GridPane painelMid = new GridPane();
        GridPane painelBot = new GridPane();

        TextField txtCodigo = new TextField();
        TextField txtDataSaida = new TextField();
        TextField txtHoraSaida = new TextField();
        TextField txtPlaca = new TextField();


        Label saida = new Label("SAIDA");
        Label codigo = new Label("Código:");
        Label dataSaida = new Label("Data da Saida:");
        Label horaSaida = new Label("Hora da Saida:");

        Label placa = new Label("Placa:");

        RadioButton avarias = new RadioButton("Avarias");

        Button btnSair = new Button("Sair");
        Button btnPagamento = new Button("Pagamento");


        painelTop.add(saida,0,0);
        painelTop.add(codigo,1,1);
        painelTop.add(txtCodigo,1,2);
        painelTop.add(dataSaida,2,1);
        painelTop.add(txtDataSaida,2,2);
        painelTop.add(horaSaida,3,1);
        painelTop.add(txtHoraSaida,3,2);

        painelTop.setHgap(10);

        painel.setTop(painelTop);

        painelMid.add(placa,1,2);
        painelMid.add(txtPlaca,2,2);
        painelMid.add(avarias,5,2);

        painelMid.setHgap(5);

        painel.setCenter(painelMid);

        painelBot.add(btnSair,0,0);
        painelBot.add(btnPagamento,3,0);

        painelBot.setHgap(50);

        painel.setBottom(painelBot);

        painelBot.setAlignment(Pos.CENTER);
        Insets insets = new Insets(20);
        BorderPane.setMargin(painelMid,insets);


        StringConverter integerToStringConverter = new IntegerStringConverter();
        StringConverter LocalDateToStringConverter = new LocalDateStringConverter();
        StringConverter LocalTimeToStringConverter = new LocalTimeStringConverter();

        Bindings.bindBidirectional(txtCodigo.textProperty(), saidaControl.codigoProperty(),integerToStringConverter);
        Bindings.bindBidirectional(txtPlaca.textProperty(), saidaControl.placaProperty());
        Bindings.bindBidirectional(txtDataSaida.textProperty(), saidaControl.dataSaidaProperty(), LocalDateToStringConverter);
        Bindings.bindBidirectional(txtHoraSaida.textProperty(), saidaControl.horaSaidaProperty(), LocalTimeToStringConverter);


        btnSair.setOnAction((e)->{
            executarAcoes.executarAcao("Login");
        });

        btnPagamento.setOnAction((e) -> {
            saidaControl.gravarSaida();
            executarAcoes.executarAcao("Pagamento");
        });

        return painel;
    }
}
