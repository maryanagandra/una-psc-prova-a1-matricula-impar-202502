//Maryana Oliveira Gandra 
//RA: 325141141

import java.util.Scanner;

public class MonitoramentoJumentos {

    //Função com retorno (cálculo da taxa de redução)
    public static double calcularTaxaReducao(int populacaoInicial, int populacaoAtual) {
        double taxaReducao = (1 - (double) populacaoAtual / populacaoInicial) * 100;
        return taxaReducao;
    }

    //Requisito 2: Função com retorno booleano ( risco )
    public static boolean estaEmRiscoCritico(double taxaReducao) {
        return taxaReducao >= 90;
    }

    //Requisito 3: Função com retorno ( impacto de abates)
    public static int simularImpactoAbate(int populacaoAtual, int abatesAnuais, int anosSimulados) {
        int populacaoRestante = populacaoAtual - (abatesAnuais * anosSimulados);
        return populacaoRestante;
    }

    //Requisito 4: Função sem retorno ( declaração final)
    public static void exibirDeclaracaoFinal(int populacaoRestante, int anos) {
        System.out.println("\n--- RESULTADO DA SIMULAÇÃO ---");
        System.out.println("População restante após " + anos + " anos: " + populacaoRestante + " jumentos.");

        if (populacaoRestante <= 0) {
            System.out.println(" ALERTA!  A espécie entraria em EXTINÇÃO se esse cenário persistir!");
        } else {
            System.out.println("\nAinda há esperança! Iniciativas de conservação são vitais.");
        }

        System.out.println("\nPrograma de Monitoramento Finalizado.");
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("SALVE OS JUMENTO NORDESTINO - SISTEMA DE MONITORAMENTO ");

        //Dados 
        int populacaoInicial = 1400000;
        int populacaoAtual = 84000;
        int abatesAnuais = 50000;

        System.out.println("População inicial de referência: " + populacaoInicial);
        System.out.println("População atual estimada: " + populacaoAtual);
        System.out.println("Abates anuais (simulados): " + abatesAnuais);

        //Calculo da taxa de redução
        double taxaReducao = calcularTaxaReducao(populacaoInicial, populacaoAtual);
        System.out.printf("\n[Análise Inicial] Taxa de Redução Histórica: %.2f%%\n", taxaReducao);

        //verificando risco
        boolean riscoCritico = estaEmRiscoCritico(taxaReducao);
        if (riscoCritico) {
            System.out.println("[Status] Espécie em Risco CRÍTICO (Redução > 90%)!");
        } else {
            System.out.println("[Status] Espécie em Risco Moderado.");
        }

        
        System.out.print("\nQuantos anos futuros você deseja simular o impacto dos abates (Ex: 1, 3, 5)? ");
        int anosSimulados = scanner.nextInt();

        //abates
        int populacaoRestante = simularImpactoAbate(populacaoAtual, abatesAnuais, anosSimulados);

        
        exibirDeclaracaoFinal(populacaoRestante, anosSimulados);

        scanner.close();
    }
}
