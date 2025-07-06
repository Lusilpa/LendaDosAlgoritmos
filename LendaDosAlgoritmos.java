import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

class LendaDosAlgoritmos{

    //Sistema de Pontuação
    public static int SistemaGeralDePontuacao (int pontuacao_geral, boolean acertou_errou){

        if (acertou_errou) {
            pontuacao_geral += 20;
        } else {
            pontuacao_geral -= 20;
        }

        return pontuacao_geral;
    }

    // Sistema de pontuação para cada fase

    public static int SistemaDePontuacaoPorFase (int pontuacao_fase, boolean acertou_errou){
        if (acertou_errou) {
            pontuacao_fase += 20;
        } else {
            pontuacao_fase -= 20;
        }
        return pontuacao_fase;
    }

    public static int ZerarPontuacaoFase (int pontuacao_fase){
            return pontuacao_fase -= pontuacao_fase;
    }

    // Verificando o nivel do jogador

    public static String VerificacaoDeIndicadores (int pontuacao_fase){
        if (pontuacao_fase == 120) {
            return "DOMINIO";
        } else if (pontuacao_fase >= 96) {
            return "EXCELENTE";
        } else if (pontuacao_fase >= 72) {
            return "BOM";
        } else if (pontuacao_fase >= 48) {
            return "MEDIANO";
        } else if (pontuacao_fase >= 24) {
            return "RUIM";
        } else {
            return "PREOCUPANTE";
        }
    }


    // Manual do Jogador

    public static void ManualJogador() {
        System.out.println("--------------------------------");
        System.out.println("         MANUAL DO JOGADOR      ");
        System.out.println("--------------------------------");
        System.out.println("1. Objetivo:");
        System.out.println("   Avaliar e diagnosticar o desempenho matemático de adolescentes do ensino fundamental e médio por meio de desafios.");
        System.out.println();
        System.out.println("2. Pontuação:");
        System.out.println("   • +20 pontos por acerto.");
        System.out.println("   • -20 pontos por erro.");
        System.out.println();
        System.out.println("3. Estrutura do jogo:");
        System.out.println("   • O 'Lenda dos Algoritmos' possui 30 desafios.");
        System.out.println("   • São divididos em 5 fases com níveis crescentes de dificuldade.");
        System.out.println();
        System.out.println("4. Conteúdos abordados:");
        System.out.println("   • Operações básicas: multiplicação e divisão.");
        System.out.println("   • Potenciação e radiciação.");
        System.out.println("   • Estatística: média aritmética.");
        System.out.println("   • Geometria: elementos do quadrado.");
        System.out.println("   • Álgebra: equação do 1º grau.");
        System.out.println();
        System.out.println("   ⚠️ Regra importante para divisão:");
        System.out.println("   • Tentar dividir por zero resultará em penalidade grave!");
        System.out.println();
        System.out.println("5. Diagnóstico de desempenho:");
        System.out.println("   • O diagnóstico final é baseado na pontuação total da fase.");
        System.out.println("   • Os níveis são: PREOCUPANTE, RUIM, MEDIANO, BOM, EXCELENTE e DOMÍNIO.");
        System.out.println();
        System.out.println("🌟 Boa sorte! Mostre que você domina os algoritmos da matemática! 🌟\n");
    }

    // Informativo sobre a pontuacao do usuário

    public static void InformativaUsuario (int fase, String pont_fase, int pontuacao_geral, int pontuacao_fase, int acertos, int erros) {
        System.out.printf("\n\nVOCÊ CHEGOU AO FIM DA FASE %d\n", fase);
        System.out.println("NIVEL: " +  pont_fase);
        System.out.printf("PONTUAÇÃO ATUAL: %d DE %d\n", pontuacao_geral, fase*120);
        System.out.printf("PONTUAÇÃO FASE %d: %d\n", fase, pontuacao_fase);
        System.out.printf("TOTAL DESAFIOS: %d\nTOTAL ACERTOS: %d\nTOTAL ERROS: %d\n\n", acertos + erros, acertos, erros);
    }

    // Iniciador de cada fase

    public static boolean InciadorDeCadaFase (int ativador){
        if(ativador == 1){
            return true;
        }
        return false;
    }

    // Se acertou ou não

    public static void AcertouOuNao (boolean acertou_errou){
        if (acertou_errou){
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
            System.out.println("\nVOCÊ ACERTOU O DESAFIO\n");
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
        } else {
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
            System.out.println("\nVOCÊ ERROU O DESAFIO\n");
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
        }
    }

    
    // Classe Main. Onde era rodar o jogo

    public static void main(String[] args) {

        boolean BotaoInicio = false;
        int ativador;

        Scanner scanner = new Scanner(System.in);
        Random randium = new Random();

        do {
            System.out.println("===============================");
            System.out.println("      LENDA DOS ALGORITMOS    ");
            System.out.println("===============================\n\n");
            System.out.println("===============================");
            System.out.println(" ESCOLHA UMA DAS OPÇÕES ABAIXO");
            System.out.println(" 1 - JOGAR");
            System.out.println(" 2 - MANUAL");
            System.out.println(" 0 - SAIR");
            System.out.println("===============================\n\n");
            ativador = scanner.nextInt();

            if (ativador == 0) {
                System.out.println("VOCÊ DESATIVOU O GAME");
                return;
            } else if (ativador == 1) {
                BotaoInicio = true;
            } else if (ativador == 2) {
                ManualJogador();
            } else {
                System.out.println("ERRO! TENTE NOVAMENTE");
            }

        } while (!BotaoInicio);

        String nome_usuario;

        scanner.nextLine();
        System.out.println("===============================");
        System.out.println("NOME DO JOGADOR/EQUIPE: ");
        nome_usuario = scanner.nextLine();

        int pontuacao = 0, pontuacao_fase1 = 0;
        int indice_desafio = 0;
        float resposta_jogador;

        System.out.println("\n\n++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("BEM VINDO AO MATH GAME, " + nome_usuario);
        System.out.println("TE DESAFIAMOS A CONQUISTAR A MAIOR PONTUAÇÃO");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++\n\n");

        int erros = 0, acertos = 0;

        while (indice_desafio < 6) {
            if (indice_desafio % 2 == 0) {
                // Multiplicação
                int coeficienteB = randium.nextInt(999) + 1;
                System.out.println("**************************************");
                System.out.printf("|             DESAFIO %d             |\n", indice_desafio + 1);
                System.out.println("**************************************");

                System.out.println("OBJETIVO: TRANSFORME A EXPRESSÃO PARA O INTERVALO {0,1}");
                System.out.printf("    %d * X\n", coeficienteB);
                System.out.print("RESPOSTA: ");
                resposta_jogador = scanner.nextFloat();

                double resultado = coeficienteB * resposta_jogador;

                if (resultado > 0 && resultado < 1) {
                    AcertouOuNao(true);
                    pontuacao = SistemaGeralDePontuacao(pontuacao, true);
                    pontuacao_fase1 = SistemaDePontuacaoPorFase(pontuacao_fase1, true);
                    acertos++;
                } else {
                    AcertouOuNao(false);
                    pontuacao = SistemaGeralDePontuacao(pontuacao, false);
                    pontuacao_fase1 = SistemaDePontuacaoPorFase(pontuacao_fase1, false);
                    erros++;
                }

            } else {
                // Divisão
                int coeficienteB = randium.nextInt(99) + 1;
                System.out.println("**************************************");
                System.out.printf("|             DESAFIO %d             |\n", indice_desafio + 1);
                System.out.println("**************************************");

                System.out.println("OBJETIVO: TRANSFORME A EXPRESSÃO PARA O INTERVALO {0,1}");
                System.out.printf("    %d / X\n", coeficienteB);
                System.out.print("RESPOSTA: ");
                resposta_jogador = scanner.nextFloat();

                if (resposta_jogador == 0) {
                    System.out.println("NÃO HÁ DIVISÃO POR 0. CONSEQUÊNCIA: ATRIBUICÃO DE ZERO PONTOS NESTA FASE");
                    pontuacao = ZerarPontuacaoFase (pontuacao);
                    pontuacao_fase1 = ZerarPontuacaoFase(pontuacao_fase1);
                    break;
                }

                double resultado = coeficienteB / resposta_jogador;

                if (resultado > 0 && resultado < 1) {
                    AcertouOuNao(true);
                    pontuacao = SistemaGeralDePontuacao(pontuacao, true);
                    pontuacao_fase1 = SistemaDePontuacaoPorFase(pontuacao_fase1, true);
                    acertos++;
                } else {
                    AcertouOuNao(false);
                    pontuacao = SistemaGeralDePontuacao(pontuacao, false);
                    pontuacao_fase1 = SistemaDePontuacaoPorFase(pontuacao_fase1, false);
                    erros++;
                }
            }

            indice_desafio++;
        }

        String pont_fase1 = VerificacaoDeIndicadores(pontuacao_fase1);
        InformativaUsuario(1, pont_fase1, pontuacao, pontuacao_fase1, acertos, erros);

        // FASE 2 - GEOMETRIA: PROPRIEDADES DO QUADRADO

        int pontuacao_fase2 = 0;
        erros = 0;
        acertos = 0;
        indice_desafio = 0;
        boolean inicio_fase = false;

        do {
            System.out.println("\n\n++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("BEM VINDO A FASE 2, " + nome_usuario);
            System.out.println("AQUI O BABADO É MAIS FORTE. GEOMETRIA VEM AÍ!");
            System.out.println("DIGITE 1 PARA INICIAR A FASE 2");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++\n\n");

            ativador = scanner.nextInt();
            inicio_fase = InciadorDeCadaFase(ativador);

        } while (!inicio_fase);

        while (indice_desafio < 6) {
            if (indice_desafio % 2 == 0 || indice_desafio % 3 == 1) {
                if (indice_desafio % 2 == 0) {
                    int diagonal = randium.nextInt(99) + 1;
                    System.out.println("**************************************");
                    System.out.printf("|             DESAFIO %d             |\n", indice_desafio + 1);
                    System.out.println("**************************************");

                    System.out.println("OBJETIVO: CALCULE A ÁREA DO QUADRADO COM DIAGONAL:");
                    System.out.printf("   %d√2\n", diagonal);
                    System.out.print("RESPOSTA: ");

                    resposta_jogador = scanner.nextFloat();

                    int area_quadrado = diagonal * diagonal;

                    if ((int) resposta_jogador == area_quadrado) {
                        AcertouOuNao(true);
                        pontuacao = SistemaGeralDePontuacao(pontuacao,true);
                        pontuacao_fase2 = SistemaDePontuacaoPorFase(pontuacao_fase2, true);
                        acertos++;
                    } else {
                        AcertouOuNao(false);
                        pontuacao = SistemaGeralDePontuacao(pontuacao,false);
                        pontuacao_fase2 = SistemaDePontuacaoPorFase(pontuacao_fase2, false);
                        erros++;
                    }
                } else {
                    int[] quadrados_perfeitos = {
                            4, 9, 16, 25, 36, 49, 64, 81, 100, 121,
                            144, 169, 196, 225, 256, 289, 324, 361, 400
                    };
                    int area_quadrado = quadrados_perfeitos[randium.nextInt(quadrados_perfeitos.length)];
                    System.out.println("**************************************");
                    System.out.printf("|             DESAFIO %d             |\n", indice_desafio + 1);
                    System.out.println("**************************************");

                    System.out.println("OBJETIVO: QUAL O VALOR DE X NA EXPRESSÃO X√2, CONSIDERANDO A ÁREA:");
                    System.out.printf("   %d\n", area_quadrado);
                    System.out.print("RESPOSTA: ");

                    resposta_jogador = scanner.nextFloat();
                    int diagonal = (int) Math.sqrt(area_quadrado);

                    if ((int) resposta_jogador == diagonal) {
                        AcertouOuNao(true);
                        pontuacao = SistemaGeralDePontuacao(pontuacao,true);
                        pontuacao_fase2 = SistemaDePontuacaoPorFase(pontuacao_fase2, true);
                        acertos++;
                    } else {
                        AcertouOuNao(false);
                        pontuacao = SistemaGeralDePontuacao(pontuacao,false);
                        pontuacao_fase2 = SistemaDePontuacaoPorFase(pontuacao_fase2, false);
                        erros++;
                    }
                }
            } else {
                int[] quadrados_perfeitos = {
                        4, 9, 16, 25, 36, 49, 64, 81, 100, 121,
                        144, 169, 196, 225, 256, 289, 324, 361, 400
                };
                int area_quadrado = quadrados_perfeitos[randium.nextInt(quadrados_perfeitos.length)];
                System.out.println("**************************************");
                System.out.printf("|             DESAFIO %d             |\n", indice_desafio + 1);
                System.out.println("**************************************");
                System.out.println("OBJETIVO: CALCULE O RAIO DO QUADRADO (LADO / 2)");
                System.out.printf("   ÁREA: %d\n", area_quadrado);
                System.out.print("RESPOSTA: ");
                resposta_jogador = scanner.nextFloat();
                
                int raio = (int) Math.sqrt(area_quadrado) / 2;

                if ((int) resposta_jogador == raio) {
                    AcertouOuNao(true);
                    pontuacao = SistemaGeralDePontuacao(pontuacao, true);
                    pontuacao_fase2 = SistemaDePontuacaoPorFase(pontuacao_fase2, true);
                    acertos++;
                } else {
                    AcertouOuNao(false);
                    pontuacao = SistemaGeralDePontuacao(pontuacao,false);
                    pontuacao_fase2 = SistemaDePontuacaoPorFase(pontuacao_fase2, false);
                    erros++;
                }
            }

            indice_desafio++;
        }

        String pont_fase2 = VerificacaoDeIndicadores(pontuacao_fase2);
        InformativaUsuario (2, pont_fase2, pontuacao, pontuacao_fase2, acertos,erros);

        //Fase 3 - estatística: média aritmética

        int pontuacao_fase3 = 0;
        erros = 0;
        acertos = 0;
        indice_desafio = 0;
        inicio_fase = false;

        do {
            System.out.println("\n\n++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("BEM VINDO A FASE 3, " + nome_usuario);
            System.out.println("SE O BABADO FOI FORTE, AGORA SERÁ BEM PIOR!");
            System.out.println("DIGITE 1 PARA INICIAR A FASE 3");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++\n\n");

            ativador = scanner.nextInt();
            inicio_fase = InciadorDeCadaFase(ativador);
            
        } while (!inicio_fase);

        while(indice_desafio < 6){
            if(indice_desafio % 2 == 0 || indice_desafio / 4 == 1){

                if(indice_desafio % 2 == 0 && indice_desafio != 4){
                    int media = randium.nextInt(1000) + 1;
                    int denominador = randium.nextInt(10) + 1;

                    System.out.println("**************************************");
                    System.out.printf("|             DESAFIO %d             |\n", indice_desafio + 1);
                    System.out.println("**************************************");

                    System.out.println("OBJETIVO: DADA O VALOR DA MÉDIA, QUAL O VALOR DA SOMA DO NUMERADOR: ");
                    System.out.printf("MÉDIA: %d\n", media);
                    System.out.printf("DENOMINADOR: %d\n", denominador);
                    System.out.println("RESPOSTA: ");

                    resposta_jogador = scanner.nextFloat();

                    float soma_numerador = media*denominador;

                    if(soma_numerador == resposta_jogador){
                        AcertouOuNao(true);
                        pontuacao = SistemaGeralDePontuacao(pontuacao, true);
                        pontuacao_fase3 = SistemaDePontuacaoPorFase(pontuacao_fase3, true);
                        acertos++;
                    } else {
                        AcertouOuNao(false);
                        pontuacao = SistemaGeralDePontuacao(pontuacao, false);
                        pontuacao_fase3 = SistemaDePontuacaoPorFase(pontuacao_fase3, false);
                        erros++;
                    }
                } else {
                    float denominador = randium.nextInt(10) + 1;
                    float numerador = randium.nextInt(1000) + 1;

                    System.out.println("**************************************");
                    System.out.printf("|             DESAFIO %d             |\n", indice_desafio + 1);
                    System.out.println("**************************************");

                    System.out.println("OBJETIVO: DADA O VALOR DA MÉDIA, QUAL A QUANTIDADE DE ELEMENTOS?");
                    float media = numerador/denominador;
                    System.out.printf("MÉDIA: %f\n", media);
                    System.out.printf("SOMA: %f\n", numerador);
                    System.out.println("RESPOSTA: ");

                    resposta_jogador = scanner.nextFloat();

                    if(denominador == resposta_jogador){
                        AcertouOuNao(true);
                        pontuacao = SistemaGeralDePontuacao(pontuacao, true);
                        pontuacao_fase3 = SistemaDePontuacaoPorFase(pontuacao_fase3, true);
                        acertos++;
                    } else {
                        AcertouOuNao(false);
                        pontuacao = SistemaGeralDePontuacao(pontuacao, false);
                        pontuacao_fase3 = SistemaDePontuacaoPorFase(pontuacao_fase3, false);
                        erros++;
                    }
                }

            } else {

                int valor1 = randium.nextInt(10) + 1;
                int valor2 = randium.nextInt(10) + 1;
                int valor3 = randium.nextInt(10) + 1;
                int valor4 = randium.nextInt(10) + 1;
                System.out.println("**************************************");
                System.out.printf("|             DESAFIO %d             |\n", indice_desafio + 1);
                System.out.println("**************************************");

                System.out.println("OBJETIVO: VALOR DA MÉDIA");
                System.out.printf("MÉDIA: %d, %d, %d, %d\n", valor1, valor2, valor3, valor4);
                System.out.println("RESPOSTA: ");

                resposta_jogador = scanner.nextFloat();

                float quantidade = 4;
                float media = (valor1 + valor2 + valor3 + valor4) / quantidade;

                if(media == resposta_jogador){
                    AcertouOuNao(true);
                    pontuacao = SistemaGeralDePontuacao(pontuacao, true);
                    pontuacao_fase3 = SistemaDePontuacaoPorFase(pontuacao_fase3, true);
                    acertos++;
                } else {
                    AcertouOuNao(false);
                    pontuacao = SistemaDePontuacaoPorFase(pontuacao_fase3, false);
                    pontuacao_fase3 = SistemaDePontuacaoPorFase(pontuacao_fase3, false);
                    erros++;
                }

            }
            indice_desafio++;
        }

        String pont_fase3 = VerificacaoDeIndicadores(pontuacao_fase3);
        InformativaUsuario (3, pont_fase3, pontuacao, pontuacao_fase3, acertos,erros);

        // FASE 4 - PONTECIAÇÃO E RADICIAÇÃO

        int pontuacao_fase4 = 0;
        erros = 0;
        acertos = 0;
        indice_desafio = 0;
        inicio_fase = false;

        do {
            System.out.println("\n\n++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("BEM VINDO A FASE 4, " + nome_usuario);
            System.out.println("VAMOS VÊ O QUE ONDE O FILHO CHORA E A MÃE NÃO VÊ");
            System.out.println("DIGITE 1 PARA INICIAR A FASE 4");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++\n\n");

            ativador = scanner.nextInt();
            inicio_fase = InciadorDeCadaFase(ativador);
        } while (!inicio_fase);

        while(indice_desafio < 6){
            if(indice_desafio % 2 == 0){
                if(indice_desafio == 0 || indice_desafio == 4){

                    int base_cubica = randium.nextInt(30) + 1;
                    System.out.println("**************************************");
                    System.out.printf("|             DESAFIO %d             |\n", indice_desafio + 1);
                    System.out.println("**************************************");

                    System.out.println("OBJETIVO: ELEVADO AO CUBO:\n");
                    System.out.printf("BASE: %d\n ", base_cubica);

                    System.out.println("RESPOSTA: ");

                    resposta_jogador = scanner.nextFloat();

                    double resposta_cubica = Math.pow(base_cubica, 3);

                    if(resposta_cubica == resposta_jogador){
                        AcertouOuNao(true);
                        pontuacao = SistemaGeralDePontuacao(pontuacao, true);
                        pontuacao_fase4 = SistemaDePontuacaoPorFase(pontuacao_fase4, true);
                        acertos++;
                    } else {
                        AcertouOuNao(false);
                        pontuacao = SistemaGeralDePontuacao(pontuacao, false);
                        pontuacao_fase4 = SistemaDePontuacaoPorFase(pontuacao_fase4, false);
                        erros++;
                    }
                } else {
                    int base_quadrada = randium.nextInt(100) + 1;
                    System.out.println("**************************************");
                    System.out.printf("|             DESAFIO %d             |\n", indice_desafio + 1);
                    System.out.println("**************************************");

                    System.out.println("OBJETIVO: ELEVADO AO QUADRADO:\n");
                    System.out.printf("BASE: %d\n ",base_quadrada);

                    System.out.println("RESPOSTA: ");

                    resposta_jogador = scanner.nextFloat();

                    int resposta_quadrada = (int) Math.pow(base_quadrada, 2);

                    if(resposta_quadrada == resposta_jogador){
                        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
                        System.out.println("\nVOCÊ ACERTOU O DESAFIO\n");
                        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
                        pontuacao += 20;
                        pontuacao_fase4 += 20;
                        acertos++;
                    } else {
                        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
                        System.out.println("\nVOCÊ ERROU O DESAFIO\n");
                        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
                        pontuacao -= 20;
                        pontuacao_fase4 -= 20;
                        erros++;
                    }
                }
            } else {
                if(indice_desafio == 1 || indice_desafio == 5){
                    int[] raizes_cubicas_perfeitas = {
                            8, 27, 64, 125,216,343,512,729,1000,1331,1728,2197,2744,3375,4096,4913,5832,6859,8000
                    };
                    int radicando = raizes_cubicas_perfeitas[randium.nextInt(raizes_cubicas_perfeitas.length)];
                    System.out.println("**************************************");
                    System.out.printf("|             DESAFIO %d             |\n", indice_desafio + 1);
                    System.out.println("**************************************");

                    System.out.println("OBJETIVO: RAIZ CÚBICA:\n");
                    System.out.printf("RADICANDO: %d\n ", radicando);

                    System.out.println("RESPOSTA: ");

                    resposta_jogador = scanner.nextFloat();

                    int raiz_cubica = (int) Math.pow(radicando, 1.0/3.0);

                    if(raiz_cubica == raiz_cubica){
                        AcertouOuNao(true);
                        pontuacao = SistemaGeralDePontuacao(pontuacao, true);
                        pontuacao_fase4 = SistemaDePontuacaoPorFase(pontuacao_fase4, true);
                        acertos++;
                    } else {
                        AcertouOuNao(false);
                        pontuacao = SistemaGeralDePontuacao(pontuacao, false);
                        pontuacao_fase4 = SistemaDePontuacaoPorFase(pontuacao_fase4, false);
                        erros++;
                    }
                } else {
                    int[] quadrados_perfeitos = {
                            4,9,16,25,36,49,64,81,100,121,144,169,196,225,256,289,324,361,400,441,484,529,576,625
                    };
                    int radicando = quadrados_perfeitos[randium.nextInt(quadrados_perfeitos.length)];
                    System.out.println("**************************************");
                    System.out.printf("|             DESAFIO %d             |\n", indice_desafio + 1);
                    System.out.println("**************************************");

                    System.out.println("OBJETIVO: RAIZ QUADRADA:\n");
                    System.out.printf("RADICANDO: %d\n ", radicando);

                    System.out.println("RESPOSTA: ");

                    resposta_jogador = scanner.nextFloat();

                    int raiz_cubica = (int) Math.sqrt(radicando);

                    if(resposta_jogador == raiz_cubica){
                        AcertouOuNao(true);
                        pontuacao = SistemaGeralDePontuacao(pontuacao, true);
                        pontuacao_fase4 = SistemaDePontuacaoPorFase(pontuacao_fase4, true);
                        acertos++;
                    } else {
                        AcertouOuNao(false);
                        pontuacao = SistemaGeralDePontuacao(pontuacao, false);
                        pontuacao_fase4 = SistemaDePontuacaoPorFase(pontuacao_fase4, false);
                        erros++;
                    }
                }
            }

            indice_desafio++;
        }

        String pont_fase4 = VerificacaoDeIndicadores(pontuacao_fase4);
        InformativaUsuario (4, pont_fase4, pontuacao, pontuacao_fase4, acertos,erros);

        // FASE 5 - EQUAÇÃO DO 1º GRAU

        int pontuacao_fase5 = 0;
        erros = 0;
        acertos = 0;
        indice_desafio = 0;
        inicio_fase = false;

        do {
            System.out.println("\n\n++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("BEM VINDO A FASE 5, " + nome_usuario);
            System.out.println("DEVERIA SER DO 2° MAS NÉ, SERÁ EQUAÇÃO DO PRIMEIRO GRAU");
            System.out.println("DIGITE 1 PARA INICIAR A FASE 4");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++\n\n");

            ativador = scanner.nextInt();
            inicio_fase = InciadorDeCadaFase(ativador);
        } while (!inicio_fase);

        while(indice_desafio < 6){
            int coeficienteA = randium.nextInt(100) + 1;
            int coeficienteB = randium.nextInt(20) + 1;

            System.out.println("**************************************");
            System.out.printf("|             DESAFIO %d             |\n", indice_desafio + 1);
            System.out.println("**************************************");

            System.out.println("OBJETIVO: VALOR DE X:\n");
            System.out.printf("EQUAÇÃO: X + %d*(%d)\n", coeficienteB, coeficienteA);

            System.out.println("RESPOSTA: ");

            resposta_jogador = scanner.nextFloat();

            float X = (-1) *  coeficienteA;

            if(X == resposta_jogador){
                AcertouOuNao(true);
                pontuacao = SistemaGeralDePontuacao(pontuacao, true);
                pontuacao_fase5 = SistemaDePontuacaoPorFase(pontuacao_fase5, true);
                acertos++;
            } else {
                AcertouOuNao(false);
                pontuacao = SistemaGeralDePontuacao(pontuacao, false);
                pontuacao_fase5 = SistemaDePontuacaoPorFase(pontuacao_fase5, false);
                erros++;
            }
            indice_desafio++;
        }

        String pont_fase5 = VerificacaoDeIndicadores(pontuacao_fase5);
        InformativaUsuario (5, pont_fase5, pontuacao, pontuacao_fase5, acertos,erros);

        if(pontuacao == 600){
            System.out.println("----------------------------------");
            System.out.println("             LENDÁRIO             ");
            System.out.println("VOCÊ ALCANCOU INCRIVEIS 600 PONTOS");
            System.out.println("----------------------------------");
        }
    }
}