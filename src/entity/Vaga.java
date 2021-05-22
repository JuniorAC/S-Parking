package entity;

public class Vaga {
    private int numero ;
    private int piso;
    private String tipovaga;
    private boolean disponibilidade;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getTipovaga() {
        return tipovaga;
    }

    public void setTipovaga(String tipovaga) {
        this.tipovaga = tipovaga;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
