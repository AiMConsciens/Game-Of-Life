public class EnvironmentDriver {
    public static void main(String[] args) throws Exception
    {
    String GameOfLifeFileNameNr;
    GameOfLifeFileNameNr = "GameOfLife4.txt";
    Environment e = new Environment(GameOfLifeFileNameNr);
    e.runSimulation();
    }
}
