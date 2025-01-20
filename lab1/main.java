import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        Corrida c = new Corrida(null, null, null, 0, 0, 0);
        
        System.out.println("Digite o nome do motorista: ");
        c.setNomeMotorista(scanner.nextLine());

        System.out.println("Digite o modelo do carro: ");
        c.setModelo(scanner.nextLine());

        System.out.println("Digite o fabricante: ");
        c.setFabricante(scanner.nextLine());

        System.out.println("Digite a motorização: ");
        c.setMotor(Float.parseFloat(scanner.nextLine()));

        System.out.println("Digite o km inicial: ");
        c.setKmInicial(Float.parseFloat(scanner.nextLine()));

        System.out.println("Digite o km final: ");
        c.setKmFinal(Float.parseFloat(scanner.nextLine()));



        scanner.close();
        float distancia = c.calcularDistancia();
        float valor = distancia * 3.75f;
        System.out.println("O veiculo percorreu " + distancia + "km, valor a cobrar: R$: " + valor);
    }
    
}
