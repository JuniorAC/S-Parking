package boundary;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class TelaPrincipal extends Application
        implements EventHandler<ActionEvent>, ExecutarAcoes {


    private TelaStrategy cadastroCliente = new CadastroCliente(this);
    private TelaStrategy cadastroFuncionario = new CadastroFuncionario(this);
    private TelaStrategy gestaoEntrada = new GestaoEntrada(this);
    private TelaStrategy gestaoSaida = new GestaoSaida(this);
    private TelaStrategy gestaoVagas = new GestaoVagas(this);
    private TelaStrategy login = new Login(this);
    private TelaStrategy menuGerente = new MenuGerente(this);
    private TelaStrategy pagamento = new Pagamento(this);


    private BorderPane bp = new BorderPane();
    private MenuItem menuTroca = new MenuItem("Troca Usuário");
    private MenuItem menuSair = new MenuItem("Sair");

    private Map<String,TelaStrategy> mapaTela = new HashMap<>();

    private void gerarMapaTela(){
        mapaTela.put("CadastroCliente",cadastroCliente);
        mapaTela.put("CadastroFuncionario",cadastroFuncionario);
        mapaTela.put("GestaoEntrada",gestaoEntrada);
        mapaTela.put("GestaoSaida",gestaoSaida);
        mapaTela.put("GestaoVagas",gestaoVagas);
        mapaTela.put("Login",login);
        mapaTela.put("MenuGerente",menuGerente);
        mapaTela.put("Pagamento", pagamento);
    }


    @Override
    public void start(Stage stage) throws Exception {

        Scene scn = new Scene(bp,720,320);

        gerarMapaTela();

        MenuBar menuBar = new MenuBar();
        Menu menuArq = new Menu("Arquivo");


        menuBar.getMenus().addAll(menuArq);
        menuArq.getItems().addAll(menuTroca,menuSair);

        FlowPane fp = new FlowPane();
        fp.getChildren().addAll(menuBar);

        menuTroca.setOnAction(this);
        menuSair.setOnAction(this);

        bp.setTop(fp);
        bp.setBottom(new Label("Status"));


        bp.setCenter(login.gerarTela());
        //bp.setAlignment(login.gerarTela(), Pos.CENTER);


        stage.setScene(scn);
        stage.setTitle("S-Parking");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(TelaPrincipal.class, args);
    }

    public void executarAcao(String acao){
        TelaStrategy tela = mapaTela.get(acao);
        if(tela!=null){
            bp.setCenter(tela.gerarTela());
        }
    }

    @Override
    public void handle(ActionEvent event) {
        EventTarget target = event.getTarget();
        if (target instanceof MenuItem){
            if(((MenuItem) target).getText() =="Troca Usuário"){
                bp.setCenter(login.gerarTela());
            }else{
                Platform.exit();
            }
        }
    }
}
