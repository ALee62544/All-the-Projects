import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;

public class Workbook1Q2
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
        stage.setTitle("Hello world");
        stage.setResizable(false);
        Pane rootPane = new Pane();
        stage.setScene(new Scene (rootPane));
        stage.setWidth(1024);
        stage.setHeight(768);
        stage.show();
        
        txtFieldMessage = new TextField();
        txtFieldMessage.setLayoutX(400);
        txtFieldMessage.setLayoutY(250);
        txtFieldMessage.setPrefWidth(200);
        txtFieldMessage.setPromptText("Insert message to be printed");
        rootPane.getChildren().add(txtFieldMessage);
        
        Button btn = new Button();
        btn.setText("Click Me!");
        btn.setLayoutX(350);
        btn.setLayoutY(50);
        btn.setOnAction((ActionEvent ae) -> printMessage());
        rootPane.getChildren().add(btn);
        
    }
    
    private static void printMessage()
    {
        String message = txtFieldMessage.getText();
        System.out.println(message);
    }
}
