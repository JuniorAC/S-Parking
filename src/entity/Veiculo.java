package entity;

public class Veiculo {
    private String dono;
    private String modelo;
    private String cor;
    private String placa;
    private boolean avarias;

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
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

    public boolean isAvarias() {
        return avarias;
    }

    public void setAvarias(boolean avarias) {
        this.avarias = avarias;
    }
}
