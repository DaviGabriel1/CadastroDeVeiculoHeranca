public class Carga extends Veiculo implements Calcular {
    private int cargaMax;
    private int tara;

    public Carga(int cargaMax, int tara,String placa, String marca, String modelo, String cor, float velocMax, int qtdRodas, Motor motor) {
        super(placa, marca, modelo, cor, velocMax, qtdRodas, motor);
        this.cargaMax = cargaMax;
        this.tara = tara;
    }

    public final int getCargaMax() {
        return cargaMax;
    }

    public final void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    public final int getTara() {
        return tara;
    }

    public final void setTara(int tara) {
        this.tara = tara;
    }

    @Override
    public final float calcVel(float velocMax) {
        return velocMax*100000;
    }

    @Override
    public int calcular() {
        return getCargaMax()+getTara()+getQtdRodas()+getMotor().getQtdPist()+getMotor().getPotencia();
    }
}
