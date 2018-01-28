/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Andrew
 */
public class CheckerboardFXMLController implements Initializable, Startable {
    
    private Stage stage;
    
    @FXML
    AnchorPane boardPane;
    
    CheckerBoard board;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        boardPane.widthProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
                System.out.println("Width: " + newSceneWidth);
                if(board != null){
                    int numRows = board.getNumRows();
                    int numCols = board.getNumCols();
                    double height = board.getHeight();
                    Color lightColor = board.getLightColor();
                    Color darkColor = board.getDarkColor();
                    refresh(new CheckerBoard(numRows, numCols, (double) newSceneWidth,height, lightColor, darkColor));
                }
            } 
        });
        
        boardPane.heightProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
                System.out.println("Height: " + newSceneHeight);
                if(board != null){
                    int numRows = board.getNumRows();
                    int numCols = board.getNumCols();
                    double width = board.getWidth();
                    Color lightColor = board.getLightColor();
                    Color darkColor = board.getDarkColor();
                    refresh(new CheckerBoard(numRows, numCols, (double) width, (double) newSceneHeight, lightColor, darkColor));
                }
            } 
        });
    }

    public void start(Stage stage){
        this.stage = stage;
        board = new CheckerBoard(8,8,boardPane.getWidth(),boardPane.getHeight());
        refresh(board);
    }
    
    @FXML
    public void handle16Board(ActionEvent event){
        Color lightColor = board.getLightColor();
        Color darkColor = board.getDarkColor();
        board = new CheckerBoard(16,16,boardPane.getWidth(),boardPane.getHeight(), lightColor, darkColor);
        refresh(board);
    }
    
    @FXML
    public void handle10Board(ActionEvent event){
        Color lightColor = board.getLightColor();
        Color darkColor = board.getDarkColor();
        board = new CheckerBoard(10,10,boardPane.getWidth(),boardPane.getHeight(), lightColor, darkColor);
        refresh(board);
    }
    
    @FXML
    public void handle8Board(ActionEvent event){
        Color lightColor = board.getLightColor();
        Color darkColor = board.getDarkColor();
        board = new CheckerBoard(8,8,boardPane.getWidth(),boardPane.getHeight(), lightColor, darkColor);
        refresh(board);
    }
    
    @FXML
    public void handle3Board(ActionEvent event){
        Color lightColor = board.getLightColor();
        Color darkColor = board.getDarkColor();
        board = new CheckerBoard(3,3,boardPane.getWidth(),boardPane.getHeight(), lightColor, darkColor);
        refresh(board);
    }
    
    @FXML
    public void handleDefaultColor(ActionEvent event){
        int numCols = board.getNumCols();
        int numRows = board.getNumRows();
        board = new CheckerBoard(numCols,numRows,boardPane.getWidth(),boardPane.getHeight());
        refresh(board);
    }
    
    @FXML
    public void handleBlueColor(ActionEvent event){
        int numCols = board.getNumCols();
        int numRows = board.getNumRows();
        board = new CheckerBoard(numCols,numRows,boardPane.getWidth(),boardPane.getHeight(), Color.SKYBLUE, Color.DARKBLUE);
        refresh(board);
    }
    
    private void refresh(CheckerBoard board){
        boardPane.getChildren().clear();
        boardPane.getChildren().add(board.build());
        this.board = board;
        System.out.println("in refresh");
        
    }
}
