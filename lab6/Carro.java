public class Carro extends Veiculo{
    private int assentos;
    public String hab;

    public Carro(String placa, String modelo, int assentos) {    
        super(placa, modelo);
        this.assentos = assentos;
        this.hab = "B";
    }
    public int getAssentos() {
        return assentos;
    }
    @Override
    public String getHab(){
        return hab;
    }
    @Override
    public double calcularCusto (double distancia){
        return distancia * 0.5;
    }
    public String getDetalhes(){
        return "Carro modelo " + getModelo() + ", placa: "+ getPlaca() + " assentos: " + getAssentos() + ".";
    }
    
}
