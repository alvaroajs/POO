public class Moto extends Veiculo{

    private int cilindradas;
    public String hab;

    public Moto(String placa, String modelo, int cilindradas) {
        super(placa, modelo);
        this.cilindradas = cilindradas;
        this.hab = "A";

    }
    
    public int getCilindradas() {
        return cilindradas;
    }
    @Override
    public String getHab(){
        return hab;
    }
    
    @Override
    public double calcularCusto(double distancia) {
        return distancia * 0.2;
    }
    public String getDetalhes(){
        return "Moto modelo: " + getModelo() + ", placa: " + getPlaca() + " cilindradas: " + getCilindradas() + ".";
    }
}