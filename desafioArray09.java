import java.util.Arrays;
import java.util.Scanner;


public class desafioArray09{

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe a quantidade de alunos da turma: ");
        int quantidadeAlunos = scanner.nextInt();

        double Notas[] = new double[quantidadeAlunos];

        //adicionando as notas ao vetor
        for (int i = 0; i < Notas.length; i++) {
            System.out.print("Informe a nota do aluno %d: ".formatted(i + 1));
            Notas[i] = scanner.nextDouble();
        }
        
        Arrays.sort(Notas); //ordenando o vetor em ordem crescente

        //calculando maior nota, menor nota e quantidade de vezes que aparecem
        double menorNota = Notas[0];
        double maiorNota = Notas[Notas.length - 1];
        int contMaior = 0;
        int contMenor = 0;

        for (int i = 0; i < Notas.length; i++) {
            if (Notas[i] == menorNota) {
                contMenor++;
            } else if (Notas[i] == maiorNota) {
                contMaior++;
            }
        }

        //media
        double soma = 0;

        for(double n : Notas){
        soma += n;
        }

        double media = soma / Notas.length;

        System.out.print("\033\143"); //limpa tela

        //prints maior nota, menor nota e media da turma
        System.out.println("Menor nota: %.1f (%dx)".formatted(menorNota, contMenor));
        System.out.println("Maior nota: %.2f (%dx)".formatted(maiorNota, contMaior));
        System.out.println("Média da turma: %.1f".formatted(media));

        //histograma das notas
        System.out.println("Histograma notas: ");
        for (int i = 0; i <= 9; i++) {
            double inicio = i; 
            double fim = i + 1;
            int contadorX = 0; //contador para quantas vezes cada nota aparece

            for (int j = 0; j < Notas.length; j++) {
                if (Notas[j] > inicio && Notas[j] <= fim) {
                   contadorX++; 
                }
            }
            
            System.out.print("%.1f ~ %.1f".formatted(inicio, fim)); //imprimindo o intervalo de notas
            //imprimindo os "*" do histograma
            for (int k = 0; k < contadorX; k++) {
                System.out.print(" *");
            }
            System.out.println();
        }
      
      scanner.close();
    }
}