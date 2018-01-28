/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Andrew
 */
public class CheckerBoard {
    private int numRows;
    private int numCols;
    private double boardWidth;
    private double boardHeight;
    private double rectangleWidth;
    private double rectangleHeight;
    private Color lightColor;
    private Color darkColor;
    private AnchorPane board = null;
    
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight){
        this(numRows, numCols, boardWidth, boardHeight, Color.RED, Color.BLACK);
        
    }
    
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor){
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        rectangleWidth = boardWidth/numCols;
        rectangleHeight = boardHeight/numRows;
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    public AnchorPane build(){
        AnchorPane newBoard = new AnchorPane();
        
        for (int row = 0; row < numRows; row++){
            for (int col = 0; col < numCols; col++){
                Rectangle rectangle = new Rectangle(rectangleWidth*row, rectangleHeight*col, rectangleWidth, rectangleHeight);
                if(row%2 == 0){
                    if(col%2 == 0){
                        rectangle.setFill(lightColor);
                    }
                    else{
                        rectangle.setFill(darkColor);
                    }
                }
                else{
                    if(col%2 == 0){
                        rectangle.setFill(darkColor);
                    }
                    else{
                        rectangle.setFill(lightColor);
                    }
                }
                
                newBoard.getChildren().add(rectangle);
            }
        }
        
        this.board = newBoard;
        
        return newBoard;
    }
    
    public AnchorPane getBoard(){
        return this.board;
    }
    
    public int getNumRows(){
        return this.numRows;
    }
    
    public int getNumCols(){
        return this.numCols;
    }
    
    public double getWidth(){
        return this.boardWidth;
    }
    
    public double getHeight(){
        return this.boardHeight;
    }
    
    public Color getLightColor(){
        return this.lightColor;
    }
    
    public Color getDarkColor(){
        return this.darkColor;
    }
    
    public double getRectangleWidth(){
        return this.rectangleWidth;
    }
    
    public double getRectangleHeight(){
        return this.rectangleHeight;
    }
}
