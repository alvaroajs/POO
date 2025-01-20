public class Viagem {

    private Veiculo veiculo;
    private Motorista motorista;
    private double distancia;

    public Viagem(Veiculo veiculo, Motorista motorista, double distancia) {
        this.veiculo = veiculo;
        this.motorista = motorista;
        this.distancia = distancia;
        this.veiculo.calcularCusto(distancia); // aqui é setado o atributo calcularCusto da classe veiculo
    }
    public String getDetalhes() {
        return "Modelo: " + veiculo.getModelo() + " Motorista: " + motorista.getNome() + " Distância: " + distancia + " Custo R$: " + veiculo.calcularCusto(distancia) + ".";
    }

}