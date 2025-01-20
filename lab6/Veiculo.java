public abstract class Veiculo {
    private String placa;
    private String modelo;

    public Veiculo(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
    }
    public String getPlaca() {
        return placa;
    }
    public String getModelo() {
        return modelo;
    }
    public abstract String getDetalhes();
    public abstract String getHab();
    public abstract double calcularCusto(double distancia);
}
