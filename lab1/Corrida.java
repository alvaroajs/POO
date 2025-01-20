public class Corrida {

        
    private String modelo;
    private String fabricante;
    private String nomeMotorista;
    private float motor;
    private float kmInicial;
    private float kmFinal;
    
    public Corrida(String modelo, String fabricante, String nomeMotorista, float motor, float kmInicial, float kmFinal){
        
        this.nomeMotorista = nomeMotorista;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.motor = motor;
        this.kmInicial = kmInicial;
        this.kmFinal = kmFinal;


    }

    public void setNomeMotorista(String nomeMotorista) {
        this.nomeMotorista = nomeMotorista;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    
    public void setMotor(float motor) {
        this.motor = motor;
    }
    
    public void setKmInicial(float kmInicial) {
        this.kmInicial = kmInicial;
    }
    
    public void setKmFinal(float kmFinal) {
        this.kmFinal = kmFinal;
    }  
    public float calcularDistancia (){

        return kmFinal - kmInicial;
    }
}