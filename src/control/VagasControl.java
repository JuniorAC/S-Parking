package control;

import entity.Funcionario;
import entity.Vaga;
import javafx.beans.property.*;

import java.util.ArrayList;
import java.util.List;

public class VagasControl {

    private List<Vaga> listVagas = new ArrayList<>();

    private IntegerProperty numero = new SimpleIntegerProperty();
    private IntegerProperty piso = new SimpleIntegerProperty();
    private StringProperty tipoVaga = new SimpleStringProperty();
    private BooleanProperty disponibilidade = new SimpleBooleanProperty(true);

    public int getNumero() {
        return numero.get();
    }
    public IntegerProperty numeroProperty() {
        return numero;
    }
    public int getPiso() {
        return piso.get();
    }
    public IntegerProperty pisoProperty() {
        return piso;
    }
    public String getTipovaga() {
        return tipoVaga.get();
    }
    public StringProperty tipovagaProperty() {
        return tipoVaga;
    }
    public boolean isDisponibilidade() {
        return disponibilidade.get();
    }
    public BooleanProperty disponibilidadeProperty() {
        return disponibilidade;
    }

    public void setEntity(Vaga v) {
        if (v != null) {
           numero.set(v.getNumero());
           piso.set(v.getPiso());
           tipoVaga.set(v.getTipoVaga());
           disponibilidade.set(v.isDisponibilidade());
          ;
        }
    }

    public Vaga getEntity() {
        Vaga v = new Vaga();
        v.setNumero(numero.get());
        v.setPiso(piso.get());
        v.setTipoVaga(tipoVaga.get());
        v.setDisponibilidade(disponibilidade.get());
        return v;
    }

    public void adicionarvaga(){
        Vaga v = getEntity();
        listVagas.add(v);
        this.setEntity(new Vaga());
    }
    public void pesquisarVaga(){
        for (Vaga v : listVagas) {
            if (v.getNumero() ==(numero.get())) {
                this.setEntity(v);
            }
        }
    }

    public void alterarVaga(){

        System.out.println("Função ainda não foi implementada");

    }

    public void deletarVaga(){
        System.out.println("Função ainda não foi implementada");
    }

}
