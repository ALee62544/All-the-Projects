import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.stage.WindowEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;

public class DialogBox
{
    private static TextField txtFieldMessage;
    
    public static void main(String args[])
    {
        launchFX();
        
    }
    
    private static void launchFX()
    {
        new JFXPanel();
        Platform.runLater(() -> initialiseGUI());
    }
    
    private static void initialiseGUI()
    {
        Stage stage = new Stage();
        stage.setTitle("Top 10 Universities");
        stage.setResizable(false);
        Pane rootPane = new Pane();
        stage.setScene(new Scene (rootPane));
        stage.setWidth(1024);
        stage.setHeight(768);
        stage.show();
        stage.setOnCloseRequest((WindowEvent we) -> terminate());
        
        Label label = new Label();
        label.setText("Top 10 Universities");
        label.setLayoutX(100);
        label.setLayoutY(100);
        rootPane.getChildren().add(label);
        
        txtFieldMessage = new TextField();
        txtFieldMessage.setLayoutX(100);
        txtFieldMessage.setLayoutY(150);
        txtFieldMessage.setPrefWidth(200);
        txtFieldMessage.setPromptText("Enter University");
        rootPane.getChildren().add(txtFieldMessage);
        
        txtFieldMessage = new TextField();
        txtFieldMessage.setLayoutX(100);
        txtFieldMessage.setLayoutY(200);
        txtFieldMessage.setPrefWidth(200);
        txtFieldMessage.setPromptText("Enter Ranking");
        rootPane.getChildren().add(txtFieldMessage);
        
        txtFieldMessage = new TextField();
        txtFieldMessage.setLayoutX(100);
        txtFieldMessage.setLayoutY(250);
        txtFieldMessage.setPrefWidth(200);
        txtFieldMessage.setPromptText("Enter country");
        rootPane.getChildren().add(txtFieldMessage);
        
        Button btn = new Button();
        btn.setText("Click Me!");
        btn.setLayoutX(100);
        btn.setLayoutY(300);
        btn.setOnAction((ActionEvent ae) -> printMessage());
        rootPane.getChildren().add(btn);
        
        stage.setOnCloseRequest((WindowEvent we) -> displayCloseDialog(we));
    }
    
    private static void displayCloseDialog(WindowEvent we)
    {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Look a leave message");
        alert.setContentText("Loser, do you really want to quit?");
        
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
            terminate();
        } else {
            we.consume();
        }
    }
    
    private static void printMessage()
    {
        String message = txtFieldMessage.getText();
        System.out.println(message);
    }
    
     private static void terminate()
     {
        System.out.println("bye bye!");
        System.exit(0);
    }
}
