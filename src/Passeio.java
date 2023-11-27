public class Passeio extends Veiculo implements Calcular{
    private int qtdPassageiros;

    public Passeio(int qtdPassageiros,String placa, String marca, String modelo, String cor, float velocMax, int qtdRodas, Motor motor) {
        super(placa, marca, modelo, cor, velocMax, qtdRodas, motor);
        this.qtdPassageiros = qtdPassageiros;
    }

    public int getQtdPassageiros() {
        return qtdPassageiros;
    }

    public void setQtdPassageiros(int qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }

    @Override
    public float calcVel(float velocMax) {
        return velocMax*1000;
    }

    @Override
    public int calcular() {
        return getPlaca().length()+getMarca().length()+getModelo().length()+getCor().length();
    }
}
