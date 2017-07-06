import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.stage.WindowEvent;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressBookGUI {
    private static TextField txtFieldAddress;
    private static TextField txtFieldName;
    private static TextField txtFieldSurname;
    private static TextField txtFieldSearch;
    private static ListView<AddressBook> addressListView;
    private static ArrayList<AddressBook> addressArrList = new ArrayList<AddressBook>();
    private static AddressBook currentlySelectedAddress = null;
    private static List<AddressBook> list = new ArrayList<AddressBook>();
   
    public static void main(String args[]) {
        launchFX();
       
    }

    private static void launchFX() {
        // Initialises JavaFX
        new JFXPanel();
        // Runs initialisation on the JavaFX thread
        Platform.runLater(() -> initialiseGUI());
    }

    private static void initialiseGUI() {
        Stage stage = new Stage();
        stage.setTitle("Address Book v.21");
        stage.setResizable(false);
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1024);
        stage.setHeight(768);
        stage.setOnCloseRequest((WindowEvent we) -> terminate());
        stage.show();

        addressListView =  new ListView<AddressBook>();
        addressListView.setLayoutX(700);
        addressListView.setLayoutY(50);
        rootPane.getChildren().add(addressListView);
        
        addressListView.setOnMouseClicked((MouseEvent me) -> {
            currentlySelectedAddress = addressListView.getSelectionModel().getSelectedItem();
        });
        
        Label label = new Label("Top Data Address Book");
        label.setLayoutX(50);
        label.setLayoutY(50);
        rootPane.getChildren().add(label);

        txtFieldAddress = new TextField();
        txtFieldAddress.setLayoutX(50);
        txtFieldAddress.setLayoutY(100);
        txtFieldAddress.setPrefWidth(400);
        txtFieldAddress.setPromptText("Insert Address");        //Click off the GUI and you can see this
        rootPane.getChildren().add(txtFieldAddress);

        txtFieldName = new TextField();
        txtFieldName.setLayoutX(50);
        txtFieldName.setLayoutY(150);
        txtFieldName.setPrefWidth(400);
        txtFieldName.setPromptText("Enter Name");        //Click off the GUI and you can see this
        rootPane.getChildren().add(txtFieldName);

        txtFieldSurname = new TextField();
        txtFieldSurname.setLayoutX(50);
        txtFieldSurname.setLayoutY(200);
        txtFieldSurname.setPrefWidth(400);
        txtFieldSurname.setPromptText("Enter Surname");        //Click off the GUI and you can see this
        rootPane.getChildren().add(txtFieldSurname);


        txtFieldSearch = new TextField();
        txtFieldSearch.setLayoutX(50);
        txtFieldSearch.setLayoutY(250);
        txtFieldSearch.setPrefWidth(400);
        txtFieldSearch.setPromptText("Enter search text");
        rootPane.getChildren().add(txtFieldSearch);

        // add an event listener that is called whenever the text inside the textfield changess
        txtFieldSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            String searchText = newValue.toLowerCase(); // or txtFieldSearch.getText();

            addressListView.getItems().clear();

            // loop over each university in the array list
            addressArrList.forEach(address -> {
                // if it matches our search criteria, add it to the filtered list
                if(address.toString().toLowerCase().contains(searchText)){
                    addressListView.getItems().add(address);
                }
            });
        });

        Button btnAdd = new Button();
        btnAdd.setText("Add");
        btnAdd.setLayoutX(50);
        btnAdd.setLayoutY(300);
        btnAdd.setOnAction((ActionEvent ae) ->addNewItem());
        rootPane.getChildren().add(btnAdd);
        
        Button btnRemove = new Button();
        btnRemove.setText("Remove");
        btnRemove.setLayoutX(100);
        btnRemove.setLayoutY(300);
        btnRemove.setOnAction((ActionEvent ae) ->removeItem());
        rootPane.getChildren().add(btnRemove);
        
        Button btnClear = new Button();
        btnClear.setText("Clear");
        btnClear.setLayoutX(180);
        btnClear.setLayoutY(300);
        btnClear.setOnAction((ActionEvent ae) ->clearListView());
        rootPane.getChildren().add(btnClear);
    }

    private static void addNewItem() {
        String add = txtFieldAddress.getText();
        String name = txtFieldName.getText();
        String surname = txtFieldSurname.getText();
        addressArrList.add(new AddressBook(add, name, surname));

        addressListView.getItems().clear();             //deletes everything in the ListView

        for(AddressBook address : addressArrList) {         //for every University object in uniArrayList
            addressListView.getItems().add(address);       //put each University object into the ListView
        }
    }
    
    private static void removeItem()
    {
        addressArrList.remove(currentlySelectedAddress);
        addressListView.getItems().remove(currentlySelectedAddress);
   
    }
    
    private static void clearListView()
    {
        addressListView.getItems().clear();
        addressArrList.clear();
        

    }
    
        private static void terminate()
    {
        System.out.println("Later nerd!");
        System.exit(0);
    }
}