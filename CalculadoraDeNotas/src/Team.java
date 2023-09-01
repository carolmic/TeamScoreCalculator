public class Team {
    private String teamName;
    private int clarity;
    private int fun;
    private int market;
    private double score;
    // private int 

    public Team(String teamName, int clarity, int fun, int market) {
        this.teamName = teamName;
        this.clarity = clarity;
        this.fun = fun;
        this.market = market;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getClarity() {
        return clarity;
    }

    public int getFun() {
        return fun;
    }

    public int getMarket() {
        return market;
    }

    public double getScore() {
        return calculateScore();
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setClarity(int clarity) {
        this.clarity = clarity;
    }

    public void setFun(int fun) {
        this.fun = fun;
    }

    public void setMarket(int market) {
        this.market = market;
    }

    private double calculateScore() {
        score =  (clarity + fun + market) / 3.0;
        return score;
    }

}