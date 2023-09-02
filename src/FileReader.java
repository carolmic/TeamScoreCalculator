import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileReader {
    private ArrayList<Team> teams;

    public FileReader() {
        teams = new ArrayList<Team>();
    }

    public void read() {
        Path path = Paths.get("src\\Equipes.txt");
        // String line;
        // String[] parts = {""};
        String name;
        int clarity;
        int fun;
        int market;
        try {
            BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset());
            String line = null;

            while ((line = br.readLine()) != null) {
                String[] lines = line.split(";");

                for (int i = 0; i < lines.length; i++) {
                   name = lines[i];
                   i++;
                   clarity = Integer.parseInt(lines[i]);
                   i++;
                   fun = Integer.parseInt(lines[i]);
                   i++;
                   market = Integer.parseInt(lines[i]);
                   Team team = new Team(name, clarity, fun, market);
                   teams.add(team);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }
}
