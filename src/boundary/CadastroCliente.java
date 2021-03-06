package boundary;

import control.ClienteControl;
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

public class CadastroCliente implements TelaStrategy {

    private ExecutarAcoes executarAcoes;

    ClienteControl clienteControl= new ClienteControl();

    public CadastroCliente(ExecutarAcoes executarAcoes) {

        this.executarAcoes = executarAcoes;
    }


    @Override
    public Pane gerarTela() {

        TextField txtNome = new TextField();
        TextField txtCpf = new TextField();
        TextField txtTelefone = new TextField();
        TextField txtEndereco = new TextField();
        TextField txtCodigoCliente = new TextField();

        TextField txtVencimento = new TextField();
        TextField txtTipoMens = new TextField();

        Label cliente = new Label("CLIENTE");
        Label nome = new Label("Nome:");
        Label cpf = new Label("Cpf:");
        Label telefone = new Label("Telefone:");
        Label endereco = new Label("Endereço:");
        Label codCliente = new Label("Código Cliente:");
        Label mensalista = new Label("MENSALISTA");

        Label vencimento = new Label("Data Vencimento:");
        Label tipoMensalidade = new Label("Tipo Mensalidade:");

        RadioButton mensalistaRadio = new RadioButton("Mensalista");

        Button btnSair = new Button("Sair");
        Button btnGravar = new Button("Gravar");
        Button btnConsultar = new Button("Consultar por Código");

        BorderPane painel = new BorderPane();
        GridPane painelTop = new GridPane();
        GridPane painelMid = new GridPane();
        GridPane painelBot = new GridPane();

        painelTop.add(cliente,0,0);
        painelTop.add(nome,1,1);
        painelTop.add(txtNome,2,1);
        painelTop.add(cpf,1,2);
        painelTop.add(txtCpf,2,2);
        painelTop.add(telefone,3,1);
        painelTop.add(txtTelefone,4,1);
        painelTop.add(endereco,3,2);
        painelTop.add(txtEndereco,4,2);
        painelTop.add(codCliente,5,1);
        painelTop.add(txtCodigoCliente,6,1);
        painelTop.add(mensalistaRadio,5,2);

        painelTop.setHgap(10);

        painel.setTop(painelTop);

        painelMid.add(mensalista,0,1);
        painelMid.add(vencimento,1,2);
        painelMid.add(txtVencimento,2,2);
        painelMid.add(tipoMensalidade,3,2);
        painelMid.add(txtTipoMens,4,2);


        painelMid.setHgap(5);

        painel.setCenter(painelMid);

        painelBot.add(btnSair,0,0);
        painelBot.add(btnConsultar,2,0);
        painelBot.add(btnGravar,3,0);

        painelBot.setHgap(50);

        painel.setBottom(painelBot);

        painelBot.setAlignment(Pos.CENTER);
        Insets insets = new Insets(20);
        BorderPane.setMargin(painelMid,insets);


        StringConverter integerToStringConverter = new IntegerStringConverter();
        Bindings.bindBidirectional(txtNome.textProperty(), clienteControl.nomeProperty());
        Bindings.bindBidirectional(txtCpf.textProperty(), clienteControl.cpfProperty(), integerToStringConverter);
        Bindings.bindBidirectional(txtTelefone.textProperty(), clienteControl.telefoneProperty(), integerToStringConverter);
        Bindings.bindBidirectional(txtEndereco.textProperty(), clienteControl.enderecoProperty());
        Bindings.bindBidirectional(txtCodigoCliente.textProperty(), clienteControl.codigoClienteProperty(), integerToStringConverter);

        btnSair.setOnAction((e)->{
            executarAcoes.executarAcao("Login");
        });

        btnConsultar.setOnAction((e)->{
            clienteControl.pesquisar();
        });

        btnGravar.setOnAction((e)->{
            clienteControl.gravar();
        });

        return painel;
    }
}
