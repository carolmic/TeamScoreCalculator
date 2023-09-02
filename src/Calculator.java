import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    Scanner in;
    private FileReader fileReader;
    private ArrayList<Team> teams;

    public Calculator(){
        in = new Scanner(System.in);
        fileReader = new FileReader();
        fileReader.read();
        teams = fileReader.getTeams();
    }

    public void execute() {
        boolean ok;
        int opcao = 0;
        do {
            do {
                ok = true;
                menu();
                try {
                    opcao = in.nextInt();
                } catch (Exception e) {
                    in.nextLine();
                    ok = false;
                    e.printStackTrace();
                    System.out.println("Opção inválida");
                }
            } while(!ok);
            in.nextLine();
            switch (opcao) {
                case 1:
                    createTeam();
                    break;
                case 2:
                    listTeams();
                    break;
                case 3:
                    listTeamsByScore();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
            }
        } while(opcao != 0);
    }

    public void menu() {
        System.out.println("\nBem vindo ao sistema de calculo de nota de equipes");
        System.out.println("-------------------------------------");
        System.out.println("Digite a opção desejada: ");
        System.out.println("[1] Criar equipe");
        System.out.println("[2] Listar equipes");
        System.out.println("[3] Listar equipes por nota");
        System.out.println("[0] Sair");
        System.out.println("-------------------------------------\n");
    }

    public void createTeam() {
        System.out.println("Digite o nome da equipe: ");
        String teamName = in.nextLine();
        System.out.println("Digite a nota de clareza: ");
        int clarity = in.nextInt();
        System.out.println("Digite a nota de diversão: ");
        int fun = in.nextInt();
        System.out.println("Digite a nota de mercado: ");
        int market = in.nextInt();
        Team team = new Team(teamName, clarity, fun, market);
        teams.add(team);
    }

    public void listTeams() {
        if (teams.size() == 0) {
            System.out.println("Nenhuma equipe cadastrada");
            return;
        }
        System.out.println("Equipes cadastradas: ");
        int count = 0;
        for (Team team : teams) {
            count++;
            System.out.println(count + "." + team.getTeamName() + "\n");
        }
    }

    public void listTeamsByScore() {
        if (teams.size() == 0) {
            System.out.println("Nenhuma equipe cadastrada");
            return;
        }
        System.out.println("Equipes cadastradas: ");
        int count = 0;
        for (Team team : teams) {
            count++;
            System.out.printf("%d. %s - %.2f\n", count, team.getTeamName(), team.getScore());
        }
    }
}
