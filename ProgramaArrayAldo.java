package ProgramaArray;

import java.util.Scanner;

public class ProgramaArrayAldo {
    static Scanner ler = new Scanner(System.in);
    static String pausa; // para simular uma entrada e causar uma pausa
    static boolean existe = false; // sinaliza se o array já foi criado
    static float[] array = null; // declaração do array. A criação do array só ocorre com a opção 1
    static float entrada; // recebe o valor do elemento para inserir ou alterar
    static int inserido = 0; // controlar a quantidade de elementos inseridos
    static int posicao; // Uso na pesquisa. Armazena o índice do elemento pesquisado, se encontrado,
    // senão armazena -1

    public static void main(String[] args) {

        int opcao; // variável para receber a opção do menu
        do {
            System.out.println("\n\n    *** Seletor de Opções ***");
            System.out.println();
            System.out.println("    1 - Criar array");
            System.out.println("    2 - Incluir elemento");
            System.out.println("    3 - Consultar elemento");
            System.out.println("    4 - Alterar elemento");
            System.out.println("    5 - Excluir elemento");
            System.out.println("    6 - Listar array");
            System.out.println("    7 - Classificar");
            System.out.println("    8 - Inicializar array");
            System.out.println("    0 - Fim");
            System.out.println();

            System.out.print("    Digite a opção:");
            opcao = ler.nextInt();

            switch (opcao) {
                case 0:
                    break;
                case 1:
                    criarArray();
                    break;
                case 2:
                    incluirElemento();
                    break;
                case 3:
                    consultaElemento();
                    break;
                case 4:
                    alteraElemento();
                    break;
                case 5:
                    excluiElemento();
                    break;
                case 6:
                    listaArray();
                    break;
                case 7:
                    classificaArray();
                    break;
                case 8:
                    inicializaArray();
                    break;
                default:
                    System.out.println("Opção inválida");
            }

            if (opcao == 0)
                break;
        } while (true);
        mensagem("Fim", "-", false);
        ler.close();
    }


    /* ***********************************************************************************
     *                     SUB ROTINAS (métodos da classe Operacoes)
     ************************************************************************************/


    // ********************************** CRIAÇÃO DO ARRAY *******************************
    public static void criarArray() {
        mensagem("Criar Array", "*", false);
        if (existe) { // Verifica se a variável existe (booleana) armazena true
            mensagem("Array já criado", "-", true);
            return;
        }
        // Entrada da quantidade de elementos que o array deve ter
        System.out.printf("\nQuantidade de elementos: ");
        int nrElementos = ler.nextInt();

        if (nrElementos != 0) {
            array = new float[nrElementos]; // Criação do array
            existe = true; // Sinaliza que o array foi criado
            mensagem("Array criado", "-", true);
        }
    }

    /*
     * Método: pesquisarArray
     * Objetivo: Pesquisar um valor em um array
     * Parametros:
     *   - valor (float): valor a ser pesquisado
     * Retorno: Se encontrar: o índice do array onde o valor pesquisado foi encontrado
     *          Se não encontrar: retorna -1
     */
    public static int pesquisarArray(float valor, float[] dadosArray) {
        int indice = -1; // váriavel local
        for (int i = 0; i < dadosArray.length; i++) {
            if (dadosArray[i] == valor) {
                indice = i;
                break;
            }
        }
        return indice;
    }


    // ********************************** INCLUSÃO DE ELEMENTO NO ARRAY *******************************
    public static void incluirElemento() {
        mensagem("Incluir Array", "*", false);
        if (existe == false) { // Verifica se existe sinaliza que o array ainda não foi criado
            mensagem("Falta criar o Array", "-", true);
            return;
        }
        do {
            if (inserido == array.length) { // se o contador inserido tiver com
                mensagem("Array cheio", "-", true);
                break;
            }
            System.out.printf("\n\nInforme o elemento para inserir ou [0] para cancelar inclusão: ");
            entrada = ler.nextFloat();
            if (entrada == 0) {
                mensagem("Inclusão Cancelada", "-", true);
                break;
            }

            if (pesquisarArray(entrada, array) != -1) {
                mensagem("Dado  já inserido. Inclusão Cancelada", "-", true);
                continue;
            }

            for (int i = 0; i < array.length; i++) {
                if (array[i] == 0) {
                    array[i] = entrada;
                    inserido++;
                    mensagem("Inclusão realizada", "-", true);
                    break;
                }
            }
            break;
        } while (true);
    }

    // ********************************** CONSULTA DE ELEMENTO NO ARRAY *******************************
    public static void consultaElemento() {
        mensagem("Consultar Array", "*", false);
        if (existe == false) { // Verifica se existe sinaliza que o array ainda não foi criado
            mensagem("Falta criar o Array", "-", true);
            return;
        }
        System.out.print("\n\nInforme o elemento para consultar ou [0] para cancelar consulta: ");
        entrada = ler.nextFloat();
        if (entrada == 0) {
            mensagem("Consulta cancelada", "-", true);
            return;
        }

        if (pesquisarArray(entrada, array) != -1) {
            mensagem(String.format("Encontrado %.2f na posição %d", array[posicao], posicao + 1), "-", true);
            // System.out.printf("\n ----->  Encontrado %.2f na posição %d  <-----", array[posicao], posicao + 1);
        } else {
            mensagem("Elemento não encontrado", "-", true);
        }
    }


    // ********************************** ALTERAÇÃO DE ELEMENTO NO ARRAY *******************************
    public static void alteraElemento() {
        mensagem("Alterar Array", "*", false);
        if (existe == false) { // Verifica se existe sinaliza que o array ainda não foi criado
            mensagem("Falta criar o Array", "-", true);
            return;
        }
        System.out.printf("\n\nInforme o elemento para alterar ou [0] para cancelar alteração: ");
        entrada = ler.nextFloat();
        if (entrada == 0) {
            mensagem("Alteração cancelada", "-", true);
            return;
        }

        if (pesquisarArray(entrada, array) != -1) {
            System.out.printf("\n ----->  Encontrado %.2f na posição %d  <-----", array[posicao], posicao + 1);
            do {
                System.out.printf("\n\nInforme o novo valor do elemento [0] para cancelar alteração: ");
                entrada = ler.nextFloat();
                if (entrada == 0) {
                    mensagem("Alteração cancelada", "-", true);
                    break;
                }

                /* Opção para testar se o usuário está informando o mesmo valor que deseja alterar
                 * if (entrada==array[posicao]) {
                 * 	   mensagem("O valor informado é igual ao que deseja alterar", "-", true);
                 * }
                 */

                int posicaoDupla = -1;
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == entrada && i != posicao) {
                        posicaoDupla = i;
                        break;
                    }
                }
                if (posicaoDupla != -1) {
                    mensagem("Dado já inserido. Alteração cancelada", "-", true);
                    continue;
                }

                array[posicao] = entrada;
                mensagem("Alteração realizada", "-", true);
                break;
            } while (true);
        } else {
            mensagem("Elemento não encontrado", "-", true);
        }
    }


    // ********************************** EXCLUSÃO DE ELEMENTO  NO ARRAY *******************************
    public static void excluiElemento() {
        mensagem("Excluir Array", "*", false);
        if (existe == false) { // Verifica se existe sinaliza que o array ainda não foi criado
            mensagem("Falta criar o Array", "-", true);
            return;
        }
        System.out.printf("\n\nInforme o elemento para excluir ou [0] para cancelar exclusao: ");
        entrada = ler.nextFloat();
        if (entrada == 0) {
            mensagem("Exclusão cancelada", "-", true);
            return;
        }

        if (pesquisarArray(entrada, array) != -1) {
            System.out.printf("\n ----->  Encontrado %.2f na posição %d  <-----", array[posicao], posicao + 1);
            array[posicao] = 0;
            inserido--;
            mensagem("Exclusão realizada", "-", true);
        } else {
            mensagem("Elemento não encontrado", "-", true);
        }
    }


    // ********************************** LISTAGEM DOS ELEMENTOS DO ARRAY *******************************
    public static void listaArray() {
        mensagem("Listagem do Array", "*", false);
        if (existe == false) { // Verifica se existe sinaliza que o array ainda não foi criado
            mensagem("Falta criar o Array", "-", true);
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("\nElemento %d = %.2f", i + 1, array[i]);
        }
    }


    // ********************************** CLASSIFICAÇÃO DOS ELEMENTOS DO ARRAY *******************************
    public static void classificaArray() {
        mensagem("Classificar Array", "*", false);
        if (existe == false) { // Verifica se existe sinaliza que o array ainda não foi criado
            mensagem("Falta criar o Array", "-", true);
            return;
        }

        // Classificação - Método Selection Sort
        int menorValor;
        for (int i = 0; i < array.length - 1; i++) {
            menorValor = i;

            for (int j = i + 1; j < array.length; j++) {

                if (array[j] < array[menorValor]) {
                    menorValor = j;
                }
            }
            float temp = array[i];
            array[i] = array[menorValor];
            array[menorValor] = temp;
        }
        mensagem("Classificação realizada", "-", true);
    }


    // ********************************** INICIALIZAÇÃO DOS ELEMENTOS DO ARRAY *******************************
    public static void inicializaArray() {
        mensagem("Inicialização do Array", "*", false);
        if (existe == false) { // Verifica se existe sinaliza que o array ainda não foi criado
            mensagem("Falta criar o Array", "-", true);
            return;
        }
        // inicializa todos os elementos com 0 (zero)
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
        mensagem("Inicialização do realizada", "-", true);
    }


    /* Método: mensagem
     * Objetivo: Mostrar uma mensagem no console
     * Parâmetros:
     * - texto (String): texto a ser impresso
     * - sinal (String): caracter para destacar a mensagem
     * - desejaPausar (booleano): true - provoca pausa
     *                            false - não provoca pausa
     */
    public static void mensagem(String texto, String sinal, boolean desejaPausar) {
        System.out.println("\n");
        // mostra caracteres de destaque do tamanho do texto que é exibido
        // + 16 refere-se a quantidade de caracteres -----> que antecede e precede o texto
        for (int i = 0; i < texto.length() + 16; i++) {
            System.out.print(sinal);
        }
        System.out.printf("\n----->  " + texto + "  <-----\n");

        for (int i = 0; i < texto.length() + 16; i++) {
            System.out.print(sinal);
        }
        System.out.println("");

        if (desejaPausar == true) {
            System.out.printf("\nTecle ENTER para continuar\n");
            ler.nextLine();
            pausa = ler.nextLine();
        }
    }

    // Sub rotinas só para exemplificar. Não forma chamada nestre programa

    public static float calcularINSS(float salario) {
        float valorINSS;
        if (salario < 1000) {
            valorINSS = salario * 0.08f;
        } else if (salario < 2000) {
            valorINSS = salario * 0.12f;
        } else {
            valorINSS = 1000f;
        }
        return valorINSS;
    }

    public static float calcularIR(float salario) {
        float valorIR;
        if (salario < 2500) {
            valorIR = 0f;
        } else if (salario < 5000) {
            valorIR = salario * 0.10f;
        } else if (salario < 8000){
            valorIR = salario * 0.15f;
        } else {
            valorIR = salario * .25f;
        }
        return valorIR;
    }
}