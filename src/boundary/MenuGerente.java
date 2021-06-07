package boundary;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MenuGerente extends Application {

    Label titulo = new Label("BEM VINDO: GERENTE");

    Button btnVagas = new Button("Vagas");
    Button btnMensalistas = new Button("Mensalistas");
    Button btnEntrada = new Button("Entrada");
    Button btnSaida = new Button("Saida");
    Button btnVoltar = new Button("Voltar");

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane painel = new BorderPane();
        Scene scn = new Scene(painel, 250,300);

        GridPane painelMeio = new GridPane();
        painelMeio.setVgap(25);

        painelMeio.add(btnVagas,1,0);
        painelMeio.add(btnMensalistas,1,1);
        painelMeio.add(btnEntrada,1,2);
        painelMeio.add(btnSaida,1,3);

        painel.setTop(titulo);
        painel.setBottom(btnVoltar);
        painel.setCenter(painelMeio);
        painel.setAlignment(titulo,Pos.CENTER);
        painelMeio.setAlignment(Pos.CENTER);
        painel.setAlignment(btnVoltar,Pos.CENTER);

        stage.setScene(scn);
        stage.setTitle("Menu Gerente");
        stage.show();

    }
}
