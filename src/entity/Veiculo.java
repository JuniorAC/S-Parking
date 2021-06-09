package entity;

public class Veiculo {
    private int dono;
    private String modelo;
    private String cor;
    private String placa;
    private int avarias;

    public int getAvarias() {
        return avarias;
    }

    public void setAvarias(int avarias) {
        this.avarias = avarias;
    }

    public int getDono() {
        return dono;
    }

    public void setDono(int dono) {
        this.dono = dono;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }


}
