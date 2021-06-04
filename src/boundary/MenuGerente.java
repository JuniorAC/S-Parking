package boundary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MenuGerente extends Application {

    //Criação dos Buttons
    Button btnVagas = new Button("Vagas");
    Button btnMensalistas = new Button("Mensalistas");
    Button btnEntrada = new Button("Entrada");
    Button btnSaida = new Button("Saída");
    Button btnSair = new Button("Sair");
    Button btnGravar = new Button("Gravar");

    @Override
    public void start(Stage stage) throws Exception {

        Pane painel = new Pane();
        Scene scn = new Scene(painel, 220, 250);

        //Criação Label
        Label lblGerente= new Label("BEM VINDO: GERENTE");

        //Fonte, estilo tamanho maximo
        lblGerente.setFont(new Font("Arial", 13));


        btnVagas.setMinSize(90, 1);
        btnMensalistas.setMinSize(90, 1);
        btnEntrada.setMinSize(90, 1);
        btnSaida.setMinSize(90, 1);
        btnSair.setMinSize(90, 1);
        btnGravar.setMinSize(90, 1);


        //Set local de exibição
        lblGerente.relocate(35,10);

        btnVagas.relocate(60, 40);
        btnMensalistas.relocate(60, 75);
        btnEntrada.relocate(60,110);
        btnSaida.relocate(60,145);
        btnSair.relocate(15, 180);
        btnGravar.relocate(110,180);



        painel.getChildren().addAll(lblGerente,btnVagas,btnMensalistas,btnEntrada,btnSaida,btnSair,btnGravar);


        stage.setScene(scn);
        stage.setTitle("Gerente - Manter Vagas");
        stage.show();

    }
}
