public class Caminhao extends Veiculo{
    private double capacidade;
    public String hab;
    
    public Caminhao(String placa, String modelo ,double capacidade) {
        super(placa, modelo);
        this.capacidade = capacidade;
        this.hab = "C";

    }
    
    public double getCapacidade() {
        return capacidade;
    }
    @Override
    public String getHab(){
        return hab;
    }
    @Override
    public double calcularCusto(double distancia) {
        return distancia;
    }
    public String getDetalhes(){
        return "Caminhao modelo: " + getModelo() + ", placa: " + getPlaca() + ", capacidade(ton): " + getCapacidade() + ".";
    }
}