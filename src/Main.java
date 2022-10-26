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
        System.out.println("Qual média vc quer fazer?\nHarmonica(digite HARMONICA) ou Aritmética(digite ARITMETICA)");
        String tipoDeMedia;
        tipoDeMedia = pegarMedia(entrada);
        if (tipoDeMedia.equals("")){
            tipoDeMedia = pegarMedia(entrada);
        }
        while (!tipoDeMedia.equals("HARMONICA")&& !tipoDeMedia.equals("ARITMETICA")){
            System.out.println("Escolha inválida, você apenas pode escolher entre HARMONICA (para calculcar Média Harmonica) e ARITMETICA (para calcular Média Artimética).\nDigite novamente sua escolha: ");
            tipoDeMedia = pegarMedia(entrada);
        }
        if (tipoDeMedia.equals("HARMONICA")){
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
            System.out.printf("\nA média harmonica entre as notas é de: %.2f", mediaHarmonicaFinal);
        }
        else if (tipoDeMedia.equals("ARITMETICA")) {
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
    static String pegarMedia(Scanner input) {
        try {
            return input.nextLine();
        } catch (InputMismatchException | NumberFormatException e) {
            input.nextLine();
            System.out.println("Escolha inválida.\nDigite novamente:");
            return pegarMedia(input);
        } catch (Exception e) {
            input.nextLine();
            System.out.println("Escolha não foi computada por conta de um erro :(");
            return pegarMedia(input);
        }
    }
}