package control;

import javafx.beans.property.*;

import java.sql.*;

public class PagamentoControl {

        private static final String URL="jdbc:mariadb://localhost:3306/sparking";
        private static final String USER="root";
        private static final String PASSWORD="";
        //VEICULO
        private IntegerProperty dono = new SimpleIntegerProperty();
        private StringProperty modelo = new SimpleStringProperty();
        private StringProperty cor = new SimpleStringProperty();
        private StringProperty placaDigitada = new SimpleStringProperty();
        //ENTRADA
        private IntegerProperty codigoEntrada = new SimpleIntegerProperty();
        private ObjectProperty<Date> dataEntrada = new SimpleObjectProperty<>();
        private ObjectProperty<Time> horaEntrada = new SimpleObjectProperty<>();
        private StringProperty placaEntrada = new SimpleStringProperty();
        //SAIDA
        private IntegerProperty codigoSaida = new SimpleIntegerProperty();
        private ObjectProperty<Date> dataSaida= new SimpleObjectProperty<>();
        private ObjectProperty<Time> horaSaida = new SimpleObjectProperty<>();
        private StringProperty placaSaida = new SimpleStringProperty();


        public void lerVeiculo(){
                try (Connection con = DriverManager.getConnection(URL,USER,PASSWORD)){
                        String sql = "SELECT * FROM veiculo WHERE placa = ?";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setString(1,placaDigitada.get());
                        ResultSet rs = stmt.executeQuery();

                        if (rs.next()) {
                                this.setDono(rs.getInt("cpfdono"));
                                this.setModelo(rs.getString("modelo"));
                                this.setCor(rs.getString("cor"));
                        } else{
                                System.out.println("Placa não localizada");
                        }
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }

        public void lerEntrada(){
                try (Connection con = DriverManager.getConnection(URL,USER,PASSWORD)){
                        String sql = "SELECT * FROM entrada WHERE placaveic = ?";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setString(1,placaDigitada.get());
                        ResultSet rs = stmt.executeQuery();

                        if (rs.next()) {
                                this.setCodigoEntrada(rs.getInt("codigo"));
                                this.setDataEntrada(rs.getDate("dataentrada"));
                                this.setHoraEntrada(rs.getTime("horaentrada"));
                        } else{
                                System.out.println("Entrada não localizada");
                        }
                } catch (SQLException e) {
                        e.printStackTrace();
                }

        }

        public  void lerSaida(){
                try (Connection con = DriverManager.getConnection(URL,USER,PASSWORD)){
                        String sql = "SELECT * FROM saida WHERE placaveic = ?";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setString(1,placaDigitada.get());
                        ResultSet rs = stmt.executeQuery();

                        if (rs.next()) {
                                this.setCodigoSaida(rs.getInt("codigo"));
                                this.setDataSaida(rs.getDate("datasaida"));
                                this.setHoraSaida(rs.getTime("horasaida"));
                        } else{
                                System.out.println("Entrada não localizada");
                        }
                } catch (SQLException e) {
                        e.printStackTrace();
                }

        }

        public void CalcularTotal(){
                //Função não implementada
        }


        public IntegerProperty donoProperty() {
                return dono;
        }

        public void setDono(int dono) {
                this.dono.set(dono);
        }

        public StringProperty modeloProperty() {
                return modelo;
        }

        public void setModelo(String modelo) {
                this.modelo.set(modelo);
        }

        public StringProperty corProperty() {
                return cor;
        }

        public void setCor(String cor) {
                this.cor.set(cor);
        }

        public StringProperty placaDigitadaProperty() {
                return placaDigitada;
        }

        public IntegerProperty codigoEntradaProperty() {
                return codigoEntrada;
        }

        public void setCodigoEntrada(int codigoEntrada) {
                this.codigoEntrada.set(codigoEntrada);
        }

        public ObjectProperty<Date> dataEntradaProperty() {
                return dataEntrada;
        }

        public void setDataEntrada(Date dataEntrada) {
                this.dataEntrada.set(dataEntrada);
        }

        public ObjectProperty<Time> horaEntradaProperty() {
                return horaEntrada;
        }

        public void setHoraEntrada(Time horaEntrada) {
                this.horaEntrada.set(horaEntrada);
        }

        public StringProperty placaEntradaProperty() {
                return placaEntrada;
        }

        public IntegerProperty codigoSaidaProperty() {
                return codigoSaida;
        }

        public void setCodigoSaida(int codigoSaida) {
                this.codigoSaida.set(codigoSaida);
        }

        public ObjectProperty<Date> dataSaidaProperty() {
                return dataSaida;
        }

        public void setDataSaida(Date dataSaida) {
                this.dataSaida.set(dataSaida);
        }

        public ObjectProperty<Time> horaSaidaProperty() {
                return horaSaida;
        }

        public void setHoraSaida(Time horaSaida) {
                this.horaSaida.set(horaSaida);
        }

        public StringProperty placaSaidaProperty() {
                return placaSaida;
        }

}
