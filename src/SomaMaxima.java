public class SomaMaxima {

    public static int encontrarSomaMaxima(int[] lista) {
        return somaMaxima(lista, 0, lista.length - 1);
    }

    private static int somaMaxima(int[] lista, int inicio, int fim) {
        if (inicio == fim) {
            return lista[inicio];
        }

        int meio = (inicio + fim) / 2;
        int somaEsquerda = somaMaxima(lista, inicio, meio);
        int somaDireita = somaMaxima(lista, meio + 1, fim);
        int somaCruzada = somaMaximaCruzada(lista, inicio, meio, fim);

        return Math.max(Math.max(somaEsquerda, somaDireita), somaCruzada);
    }

    private static int somaMaximaCruzada(int[] lista, int inicio, int meio, int fim) {
        int somaEsquerda = Integer.MIN_VALUE;
        int somaTemp = 0;

        for (int i = meio; i >= inicio; i--) {
            somaTemp += lista[i];
            if (somaTemp > somaEsquerda) {
                somaEsquerda = somaTemp;
            }
        }

        int somaDireita = Integer.MIN_VALUE;
        somaTemp = 0;

        for (int j = meio + 1; j <= fim; j++) {
            somaTemp += lista[j];
            if (somaTemp > somaDireita) {
                somaDireita = somaTemp;
            }
        }

        return somaEsquerda + somaDireita;
    }

    public static void main(String[] args) {
        int[] lista = {1, -3, 2, 1, -1, 3, -2};
        int resultado = encontrarSomaMaxima(lista);
        System.out.println("A soma máxima é: " + resultado);
    }
}
