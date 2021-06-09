package control;

import entity.Entrada;
import entity.Vaga;
import javafx.beans.property.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EntradaControl {
    private static final String URL="jdbc:mariadb://localhost:3306/sparking";
    private static final String USER="root";
    private static final String PASSWORD="";

    private List<Entrada> listentrada = new ArrayList<>();

    private IntegerProperty codigo = new SimpleIntegerProperty();
   // private ObjectProperty<LocalDate> dataEntrada = new SimpleObjectProperty<>(localDate.now())


    public void gravar(){


    }
}
