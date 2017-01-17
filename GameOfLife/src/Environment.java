import java.io.*;
import java.util.Scanner;
import edu.princeton.cs.introcs.StdDraw;


public class Environment {
    private int Rows;
    private int Cols;
    private Cell[][] Field;
    
    public Environment(String filename){
        Scanner ScannerInstance;
        try{
            ScannerInstance = new Scanner(new FileInputStream("C:/" +filename ));
            Rows = ScannerInstance.nextInt();
            Cols = ScannerInstance.nextInt();
            Field = new Cell[Rows][Cols];
            int cellNumber;
            for(int rowCount = 0; rowCount < Rows; rowCount++ ){
                for(int colCount = 0; colCount < Cols; colCount++){
                    cellNumber = ScannerInstance.nextInt();
                    if(cellNumber == 0){
                        Field[rowCount][colCount] = new Cell(false);
                    }
                    else{
                        Field[rowCount][colCount] = new Cell(true);
                    }
                }
            }
            StdDraw.setCanvasSize(20*Rows, 20*Cols);
            StdDraw.setXscale(0, Cols);
            StdDraw.setYscale(0, Rows);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File cannot be found");
            System.exit(0);
        }
    }
    public void runSimulation(){		
        while(true){
            Display();
            StdDraw.show();
            nextGeneration();
        }
    }
    private int NeighborsCount(int row,  int col){
        int Neighbors = 0;
        for(int r = -1; r <= 1; r++){	//checking Rows around
            for(int c = -1; c <= 1; c++){	//checking Cols around
                if((row + r < Rows && row + r >= 0) &&(col + c < Cols && col + c >= 0)){	//check around col preventing off Field
                        if(Field[row + r][col + c].getAlive() == true){
                            Neighbors += 1;
                        }
                }
            }
        }
        if(Field[row][col].getAlive() == true){
            Neighbors = Neighbors - 1;
        }
        return Neighbors;
    }
    private void nextGeneration(){
        Cell[][] Field2 = new Cell[Rows][Cols];
        for(int r = 0; r < Rows; r++){
            for(int c = 0; c < Cols; c++){
                if( Field[r][c].getAlive() == false){ //if cell is empty
                    if(NeighborsCount(r,c) == 3){
                        Field2[r][c] = new Cell(true);
                    }			
                    else{
                        Field2[r][c] = new Cell(false);
                    }
                }
                if(Field[r][c].getAlive() == true){	//if cell is occupied
                    if(NeighborsCount(r,c) > 3){
                        Field2[r][c] = new Cell(false);
                    }
                    else if(NeighborsCount(r,c) < 2){
                        Field2[r][c] = new Cell(false);
                    }
                    else{
                        Field2[r][c] = new Cell(true);
                    }
                }
            }
        }
        Field = Field2;
    }
    private void Display(){
        for(int r = 0; r < Rows; r++){
            for(int c = 0; c < Cols; c++){
                if(Field[r][c].getAlive() == true ){
                    StdDraw.setPenColor(StdDraw.BLUE);
                }
                if(Field[r][c].getAlive() == false){
                    StdDraw.setPenColor(StdDraw.BLACK);
                }
                StdDraw.filledRectangle(c + 1, r + 1, 1, 1);
            }
        }
    }
}
