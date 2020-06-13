package ProgramaArray;
// AUTORES: JOSÉ MARCOS / NAIANA CORDEIRO
// PROFESSOR: ALDO MOURA
// UNIT - 1º PERÍODO

import java.util.Arrays;
import java.util.Scanner;

public class ProgramaArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] array = null;

        int opcao, tamanhoArray = 0, contador = 0;
        double valor;
        char encerra = ' ';

        boolean infValida = false;


        do {
            System.out.println("\n----------------- MENU ------------------");

            System.out.print("1 - Criar Lista	     ");
            System.out.println(" 2 - Incluir Valor     ");
            System.out.print("3 - Consultar Valor   ");
            System.out.println("4 - Alterar Valor     ");
            System.out.print("5 - Excluir Valor     ");
            System.out.println("6 - Listar Valor      ");
            System.out.print("7 - Classificar Valor ");
            System.out.println("8 - Ordem Inversa ");
            System.out.print("9 - Limpar Lista      ");
            System.out.println("0 - Encerrar          ");
            System.out.println("-----------------------------------------");

            while (true) {
                try {
                    System.out.println("DIGITE A OPÇÃO: ");
                    opcao = sc.nextInt();

                } catch (Exception exception) {
                    System.out.println("\nDIGITE APENAS NÚMEROS!");
                    sc.next();
                    continue;
                }
                break;
            }
            switch (opcao) {

                case 1:
                    System.out.println("\n------------> CRIANDO LISTA <------------");
                    if (infValida) {
                        System.out.println("########################################");
                        System.out.println("#            LISTA JÁ CRIADA           #");
                        System.out.println("########################################");
                        continue;
                    }
                    try {
                        System.out.println("INFORME O TAMANHO DA LISTA: ");
                        tamanhoArray = sc.nextInt();
                    } catch (Exception exception) {
                        sc.next();
                        System.out.println("DIGITE APENAS NÚMEROS!");
                        continue;
                    }

                    System.out.println("########################################");
                    System.out.println("#        LISTA CRIADA COM SUCESSO      #");
                    System.out.println("########################################");


                    if (tamanhoArray == 0) {
                        System.out.println("########################################");
                        System.out.println("#           VALOR NÃO PERMITIDO        #");
                        System.out.println("########################################");
                        break;

                    }

                    if (tamanhoArray != 0) {
                        array = new double[tamanhoArray];
                        infValida = true;
                    }
                    break;

                case 2:

                    System.out.println("\n----------> INCLUSÃO DO VALOR <-----------");

                    if (infValida == false) {
                        System.out.println("########################################");
                        System.out.println("#             LISTA NÃO CRIADA         #");
                        System.out.println("########################################");
                        continue;
                    }
                    do {

                        if (contador == array.length) {
                            System.out.println("########################################");
                            System.out.println("#    LISTA CHEIA / OPÇÃO ALTERAR       #");
                            System.out.println("########################################");
                            break;
                        }
                        try {
                            System.out.printf("\nENTRE COM %dº VALOR: R$ / (0) PARA RETORNAR: ", contador + 1);
                            valor = sc.nextDouble();
                        } catch (Exception exception) {
                            sc.next();
                            System.out.println("DIGITE APENAS NÚMEROS!");
                            continue;
                        }

                        if (valor == 0) {
                            System.out.println("########################################");
                            System.out.println("#           INCLUSÃO CANCELADA         #");
                            System.out.println("########################################");

                            break;
                        }

                        boolean encontrado = false;
                        if (encontrado == false) {
                            for (int i = 0; i < array.length; i++) {
                                if (array[i] == 0) {
                                    array[i] = valor;
                                    contador++;
                                    break;
                                }
                            }
                        }

                        int n = array.length;
                        for (int i = 1; i < n; ++i) {
                            int key = (int) array[i];
                            int j = i - 1;
                            while (j >= 0 && array[j] > key) {
                                array[j + 1] = array[j];
                                j = j - 1;
                            }
                            array[j + 1] = key;
                        }

                        for (int i = 0; i < array.length - 1; i++) {
                            int valorIgual = i;

                            for (int j = i + 1; j < array.length; j++) {
                                if (array[j] == array[valorIgual] && array[j] != 0) {
                                    valorIgual = j;
                                    array[j] = 0;
                                    contador--;
                                    encontrado = true;

                                    System.out.println("########################################");
                                    System.out.println("#    NÃO É PERMITIDO VALOR REPETIDO    #");
                                    System.out.println("########################################");
                                    continue;
                                }
                            }
                        }
                        if (valor != 0 && encontrado != true) {
                            System.out.println("########################################");
                            System.out.println("#      VALOR ADICIONADO COM SUCESSO    #");
                            System.out.println("########################################");
                        }

                    } while (true);
                    break;

                case 3:

                    if (array == null) {
                        System.out.println("########################################");
                        System.out.println("#               LISTA NÃO CRIADA       #");
                        System.out.println("########################################");
                        continue;
                    }
                    System.out.println("\n---> VALORES PARA CONSULTA DE POSIÇÃO <---");

                    for (int i = 0; i < array.length; i++) {
                        System.out.printf("\nValor %.2f", array[i]);
                        continue;
                    }
                    try {
                        System.out.println("\nINFORME VALOR CONSULTA: R$ / (0) PARA RETORNAR: ");
                        valor = sc.nextDouble();
                    } catch (Exception exception) {
                        sc.next();
                        System.out.println("DIGITE APENAS NÚMEROS!");
                        continue;
                    }

                    if (valor == 0) {
                        System.out.println("########################################");
                        System.out.println("#          CONSLTA CANCELADA           #");
                        System.out.println("########################################");

                        continue;
                    }

                    int posicao = -1;
                    for (int i = 0; i < array.length; i++) {
                        if (array[i] == valor) {
                            array[i] = valor;
                            posicao = i;
                            break;
                        }
                    }

                    if (posicao != -1) {
                        System.out.printf("\n-> ENCONTRADO VALOR: R$ %.2f NA POSIÇÃO %d", array[posicao], posicao + 1);
                        System.out.println("\n########################################");
                        System.out.println("#    CONSULTA REALIZADA COM SUCESSO    #");
                        System.out.println("########################################");
                    } else {
                        System.out.println("########################################");
                        System.out.println("#           VALOR NÃO ENCONTRADO!      #");
                        System.out.println("########################################");
                    }
                    break;

                case 4:
                    if (array == null) {
                        System.out.println("########################################");
                        System.out.println("#            LISTA NÃO CRIADA          #");
                        System.out.println("########################################");
                        continue;
                    }

                    System.out.println("\n---> VALORES DISPONÍVEIS PARA ALTERAÇÃO <---");
                    for (int i = 0; i < array.length; i++) {
                        System.out.printf("\nValor %d = %.2f", (i + 1), array[i]);
                        continue;
                    }

                    try {
                        System.out.println("\nINFORME VALOR : R$ / (0) PARA RETORNAR:");
                        valor = sc.nextDouble();
                    } catch (Exception exception) {
                        sc.next();
                        System.out.println("DIGITE APENAS NÚMEROS!");
                        continue;
                    }

                    int existe = -1;
                    for (int i = 0; i <array.length ; i++) {
                        if (array[i] == valor) {
                            array[i] = valor;
                            existe = i;
                            break;
                        }
                    }
                    if (existe == -1){
                        System.out.println("########################################");
                        System.out.println("#         VALOR NÃO ENCONTRADO         #");
                        System.out.println("########################################");
                        break;
                    }



                    int alteracao = -1;
                    for (int i = 0; i < array.length; i++) {
                        if (array[i] == valor) {
                            array[i] = valor;
                            alteracao = i;
                            break;
                        }
                    }

                    try {
                        System.out.println("\nINFORME NOVO VALOR: R$ ");
                        valor = sc.nextDouble();
                    } catch (Exception exception) {
                        sc.next();
                        System.out.println("DIGITE APENAS NÚMEROS!");
                        continue;
                    }


                    for (int i = 0; i < array.length; i++) {
                        if (array[i] == valor) {
                            array[i] = 0;
                        }
                    }

                    int valorRepetido = -1;
                    int posicao1 = -1;
                    for (int i = 0; i < array.length; i++) {
                        if (array[i] == valor && i != posicao1) {
                            valorRepetido = i;
                            break;
                        }
                    }
                    if (valorRepetido != -1) {
                        System.out.println("########################################");
                        System.out.println("#    NÃO É PERMITIDO VALOR REPETIDO    #");
                        System.out.println("########################################");
                        continue;
                    }

                    for (int i = 0; i < array.length; i++) {
                        array[alteracao] = valor;
                        continue;
                    }
                    int n = array.length;
                    for (int i = 1; i < n; ++i) {
                        int key = (int) array[i];
                        int j = i - 1;
                        while (j >= 0 && array[j] > key) {
                            array[j + 1] = array[j];
                            j = j - 1;
                        }
                        array[j + 1] = key;
                    }

                    System.out.println("########################################");
                    System.out.println("#      VALOR ALTERADO COM SUCESSO      #");
                    System.out.println("########################################");
                    break;

                case 5:

                    if (array == null) {
                        System.out.println("########################################");
                        System.out.println("#             LISTA NÃO CRIADA          #");
                        System.out.println("#########################################");
                        continue;
                    }

                    System.out.println("\n---> VALORS DISPONÍVEIS PARA EXCLUSÃO <---");
                    for (int i = 0; i < array.length; i++) {
                        System.out.printf("\nValor %d = %.2f", (i + 1), array[i]);
                        continue;
                    }

                    try {
                        System.out.println("\nINFORME VALOR PARA EXCLUSÃO: R$ / (0) PARA RETORNAR: ");
                        valor = sc.nextDouble();
                    } catch (Exception exception) {
                        sc.next();
                        System.out.println("DIGITE APENAS NÚMEROS!");
                        continue;
                    }

                    if (valor == 0) {
                        System.out.println("########################################");
                        System.out.println("#         EXCLUSÃO CANCELADA           #");
                        System.out.println("########################################");
                        break;
                    }

                    int encontrado = -1;
                    for (int i = 0; i <array.length ; i++) {
                        if (array[i] == valor) {
                            array[i] = valor;
                            encontrado = i;
                            break;
                        }
                    }
                    if (encontrado != -1){
                        System.out.println("########################################");
                        System.out.println("#         VALOR EXCLUIDO COM SUCESSO   #");
                        System.out.println("########################################");
                    }
                    else{
                        System.out.println("########################################");
                        System.out.println("#         VALOR NÃO ENCONTRADO         #");
                        System.out.println("########################################");
                    }

                    for (int i = 0; i < array.length; i++) {
                        if (array[i] == valor) {
                            array[i] = 0;
                        }
                    }
                    //exclusão array colocando o valor zerado no final
                    for (int i = 0; i < array.length - 1; i++) {
                        if (array[i] == 0) {
                            array[i] = array[i+1];
                            array[i+1] = 0;
                        }
                    }
                    break;

                case 6:
                    if (array == null) {
                        System.out.println("########################################");
                        System.out.println("#            LISTA NÃO CRIADA          #");
                        System.out.println("########################################");
                    }

                    System.out.println("\n----------> LISTANDO VALORES <----------");

                    for (int i = 0; i < array.length; i++) {
                        System.out.printf("\nValor %d = %.2f ", (i + 1), array[i]);
                    }
                    break;

                case 7:
                    if (array == null) {
                        System.out.println("########################################");
                        System.out.println("#            LISTA NÃO CRIADA          #");
                        System.out.println("########################################");
                        continue;
                    }

                    Arrays.sort(array);
                    System.out.println("\n----------> ORDENANDO VALORES <----------");
                    for (int i = 0; i < array.length; i++) {
                        System.out.printf("\nValor %d = %.2f ", (i + 1), array[i]);
                    }
                    break;

                case 8:
                    System.out.println("\n----------> ORDENANDO INVERSA <----------");

                    for (int i = 1; i < array.length; i++) {
                        for (int j = 0; j < i; j++) {
                            if (array[i] > array[j]) {
                                int temp = (int) array[i];
                                array[i] = array[j];
                                array[j] = temp;
                                continue;
                            }
                        }
                    }
                    for (int i = 0; i < array.length; i++) {
                        System.out.printf("\nValor %d = %.2f ", (i + 1), array[i]);
                    }
                    break;

                case 9:

                    if (array == null) {
                        System.out.println("########################################");
                        System.out.println("#             LISTA NÃO CRIADA         #");
                        System.out.println("########################################");
                        continue;
                    }
                    System.out.println("\n-------> LIMPAR VALORES DA LISTA <-------");

                    System.out.println("DESEJA LIMPAR LISTA DE VALORES? (S)IM (N)ÃO:");
                    encerra = sc.next().charAt(0);
                    encerra = Character.toUpperCase(encerra);

                    if (encerra == 'S') {
                        array = new double[tamanhoArray];
                        System.out.println("########################################");
                        System.out.println("#            LISTA ZERADA              #");
                        System.out.println("########################################");

                    } else {
                        continue;
                    }

                    break;
                default:
                    break;
            }

            if (opcao == 0) {
                System.out.println("DESEJA ENCERRAR (S)IM (N)ÃO: ");
                encerra = sc.next().charAt(0);
                encerra = Character.toUpperCase(encerra);

                if (encerra == 'S') {
                    System.out.println("########################################");
                    System.out.println("#          PROGRAMA ENCERRADO          #");
                    System.out.println("########################################");
                    break;
                } else {
                    continue;
                }
            }

        } while (true);

    }

}