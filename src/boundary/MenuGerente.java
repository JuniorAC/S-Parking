package boundary;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class MenuGerente implements TelaStrategy {

    private ExecutarAcoes executarAcoes;

    public MenuGerente(ExecutarAcoes executarAcoes) {
        this.executarAcoes = executarAcoes;
    }

    @Override
    public Pane gerarTela() {
        Label titulo = new Label("BEM VINDO: GERENTE");

        Button btnVagas = new Button("Vagas");
        Button btnClientes = new Button("Clientes");
        Button btnEntrada = new Button("Entrada");
        Button btnSaida = new Button("Saida");
        Button btnVoltar = new Button("Voltar");

        BorderPane painel = new BorderPane();

        GridPane painelMeio = new GridPane();
        painelMeio.setVgap(25);

        painelMeio.add(btnVagas,1,0);
        painelMeio.add(btnClientes,1,1);
        painelMeio.add(btnEntrada,1,2);
        painelMeio.add(btnSaida,1,3);

        painel.setTop(titulo);
        painel.setBottom(btnVoltar);
        painel.setCenter(painelMeio);
        painel.setAlignment(titulo,Pos.CENTER);
        painelMeio.setAlignment(Pos.CENTER);
        painel.setAlignment(btnVoltar,Pos.CENTER);


        btnEntrada.setOnAction((e)->{
            //chamar tela gestao entradas
            executarAcoes.executarAcao("GestaoEntrada");
        });

        btnSaida.setOnAction((e)->{
            //chamar tela gestao saidas
            executarAcoes.executarAcao("GestaoSaida");
        });

        btnVagas.setOnAction((e)->{
            //chamar tela gestao vagas
            executarAcoes.executarAcao("GestaoVagas");
        });

        btnClientes.setOnAction((e)->{
            //chamar tela gestao mensalistas
            executarAcoes.executarAcao("CadastroCliente");
        });

        btnVoltar.setOnAction((e)->{
            //retornar para tela de login
            executarAcoes.executarAcao("Login");
        });

        return painel;
    }
}
