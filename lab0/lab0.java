import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;
public class lab0 {
    public static void main(String[] args) {
        
        String entrada = "entrada.txt";
        String saida = "saida.txt";
        FileInputStream inFile = null;
        FileOutputStream outFile = null;
        boolean ital = false, neg = false;
        int c;

        try{
            inFile = new FileInputStream(new File(entrada));
            outFile = new FileOutputStream(new File(saida));
            
            while ((c = inFile.read()) != -1) {

                if (c == '_' && ital == false ) { //aqui comparamos se o caracter corresponde a '_' e também se já foi aberto alguma chavea anteriomente

                    outFile.write("<i>".getBytes());
                    ital = true;
                }
                else if (c == '_' && ital == true) { //alem da comparação, o operador binário ital serve para verificar se já fora aberto para assim fechar a chave
                    outFile.write("</i>".getBytes());
                    ital = false;
                }

                else if (c == '*' && neg == false) {
                    outFile.write("<b>".getBytes());
                    neg = true;
                }
                else if (c == '*' && neg == true){
                    outFile.write("</b>".getBytes());
                    neg = false;
                }

                else{ //aqui printamos os caracteres que não queremos alterar
                    outFile.write(c);
                }
                
            }

        }
        catch(IOException e){
            System.err.println("Não foi possível abrir o arquivo");
        }
        System.out.println();
    }
}