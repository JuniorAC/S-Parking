package boundary;

import control.SaidaControl;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

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
        TextField txtDono = new TextField();
        TextField txtModelo = new TextField();
        TextField txtCor = new TextField();

        Label saida = new Label("SAIDA");
        Label dadosVeiculo = new Label("DADOS DO VEICULO");
        Label codigo = new Label("Código:");
        Label dataSaida = new Label("Data da Saida:");
        Label horaSaida = new Label("Hora da Saida:");

        Label placa = new Label("Placa:");
        Label dono = new Label("Dono:");
        Label modelo = new Label("Modelo:");
        Label cor = new Label("Cor:");

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

        painelMid.add(dadosVeiculo,0,1);
        painelMid.add(placa,1,2);
        painelMid.add(txtPlaca,2,2);
        painelMid.add(dono,1,3);
        painelMid.add(txtDono,1,4);
        painelMid.add(modelo,2,3);
        painelMid.add(txtModelo,2,4);
        painelMid.add(cor,3,3);
        painelMid.add(txtCor,3,4);
        painelMid.add(avarias,4,4);

        painelMid.setHgap(5);

        painel.setCenter(painelMid);

        painelBot.add(btnSair,0,0);
        painelBot.add(btnPagamento,3,0);

        painelBot.setHgap(50);

        painel.setBottom(painelBot);

        painelBot.setAlignment(Pos.CENTER);
        Insets insets = new Insets(20);
        BorderPane.setMargin(painelMid,insets);

        //adcionar as bindings

        //estanciar as classes controls

        btnSair.setOnAction((e)->{
            executarAcoes.executarAcao("Login");
        });

        btnPagamento.setOnAction((e) -> {
            saidaControl.pagamento();
        });

        return painel;
    }
}
