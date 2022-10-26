import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bem vindo ao sistema :)");
        System.out.println("Digite a quantidade de números utilizados: ");
        int quantidade = pegarNumero(entrada);
        while (quantidade <= 0) {
            System.out.println("Quantidade inválida.\nDigite novamente um valor para a quantidade: ");
            quantidade = pegarNumero(entrada);
        }
        double soma = 0;
        int i = 0;
        int j = 0;
        double[] array = new double[quantidade];
        for (i = 0; i < array.length; i++) {
            System.out.println("Digite um valor: ");
            double valor = getNumeroDouble(entrada);
            soma += valor;
            array[j] = valor;
            j++;
        }
        System.out.println("Qual média vc quer fazer?\n1= Harmonica e 2= Aritmética");
        int tipoDeMedia = pegarNumero(entrada);
        while (tipoDeMedia != 1 && tipoDeMedia != 2){
            System.out.println("Número de escolha inválido, você apenas pode escolhere entre os números 1(Média Harmonica) e 2(Média Artimética).\nDigite novamente: ");
            tipoDeMedia = pegarNumero(entrada);
        }
        if (tipoDeMedia == 1){
            double mediaHarmonicaMeio = 0;
            for (j = 0; j < array.length; j++) {
                double mediaHarmonicaComeco = (1/array[j]);
                mediaHarmonicaMeio += mediaHarmonicaComeco;
            }
            double mediaHarmonicaFinal = quantidade/mediaHarmonicaMeio;
            System.out.println("A média escolhida foi: HARMONICA");
            System.out.println("As notas digitadas foram: ");
            for (j = 0; j < array.length; j++) {
                System.out.print(" |" + array[j] + "|");}
            System.out.printf("\nA média aritmética entre as notas é de: %.2f", mediaHarmonicaFinal);
        }
        else if (tipoDeMedia == 2) {
            double mediaAritmetica = soma / i;
            System.out.println("A média escolhida foi: ARITMÉTICA");
            System.out.println("As notas digitadas foram: ");
            for (j = 0; j < array.length; j++) {
                System.out.print(" |" + array[j] + "|");}
            System.out.printf("\nA média aritmética entre as notas é de: %.2f", mediaAritmetica);
        }
    }
    static int pegarNumero(Scanner input) {
        try {
            return input.nextInt();
        } catch (InputMismatchException | NumberFormatException e) {
            input.nextLine();
            System.out.println("Valor inválido.\nDigite novamente um valor:");
            return pegarNumero(input);
        } catch (Exception e) {
            input.nextLine();
            System.out.println("Valor não foi computado por conta de um erro :(");
            return pegarNumero(input);
        }
    }

    static double getNumeroDouble(Scanner input) {
        try {
            return input.nextDouble();
        } catch (InputMismatchException | NumberFormatException e) {
            input.nextLine();
            System.out.println("Valor inválido.\nDigite novamente um valor:");
            return getNumeroDouble(input);
        } catch (Exception e) {
            input.nextLine();
            System.out.println("Valor não foi computado por conta de um erro :(");
            return getNumeroDouble(input);
        }
    }
}