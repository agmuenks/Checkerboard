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
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
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
    private VBox vBox;
    
    @FXML
    private MenuBar menuBar;
    
    private CheckerBoard board;
    private AnchorPane boardPane;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }

    public void start(Stage stage){
        this.stage = stage;
        
        vBox.widthProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
            
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
        
        vBox.heightProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
            
                if(board != null){
                    int numRows = board.getNumRows();
                    int numCols = board.getNumCols();
                    double width = board.getWidth();
                    double menuBarHeight = menuBar.getHeight();
                    Color lightColor = board.getLightColor();
                    Color darkColor = board.getDarkColor();
                    refresh(new CheckerBoard(numRows, numCols, width, (double) newSceneHeight - menuBarHeight, lightColor, darkColor));
                }
            } 
        });
        
        board = new CheckerBoard(8,8,vBox.getWidth(),vBox.getHeight()-menuBar.getHeight());
        refresh(board);
    }
    
    @FXML
    public void handleSixteenBoard(ActionEvent event){
        updateBoardSize(16, 16);
    }
    
    @FXML
    public void handleTenBoard(ActionEvent event){
        updateBoardSize(10, 10);
    }
    
    @FXML
    public void handleEightBoard(ActionEvent event){
        updateBoardSize(8, 8);
    }
    
    @FXML
    public void handleThreeBoard(ActionEvent event){
        updateBoardSize(3, 3);
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
        
        vBox.getChildren().remove(boardPane);
        boardPane = board.build();
        vBox.getChildren().add(boardPane);
        this.board = board;
        
    }
    
    private void updateBoardSize(int numberOfRows, int numberOfColumns){
        Color lightColor = board.getLightColor();
        Color darkColor = board.getDarkColor();
        board = new CheckerBoard(numberOfRows, numberOfColumns, boardPane.getWidth(),boardPane.getHeight(), lightColor, darkColor);
        refresh(board);
    }
}
