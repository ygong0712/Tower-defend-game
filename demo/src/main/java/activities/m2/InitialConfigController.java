package activities.m2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InitialConfigController implements Initializable {
    @FXML
    private TextField playerName;
    @FXML
    private Label inputError;

    @FXML
    private ChoiceBox<String> diff;

    private ObservableList diffi = FXCollections.observableArrayList();
    private String[] difficulties = {"easy", "medium", "hard"};

    private Scene scene;
    private Stage stage;
    private Parent root;

    public TextField getPlayerName() {
        return this.playerName;
    }

    public Label getInputError() {
        return this.inputError;
    }

    public ChoiceBox<String> getDiff() {
        return this.diff;
    }

    public ObservableList getDiffi() {
        return this.diffi;
    }

    public String[] getDifficulties() {
        return difficulties;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        diff.setValue("easy");
        loadData();
    }

    @FXML
    private void loadData() {
        diffi.removeAll();
        for (String string: difficulties) {
            diffi.add(string);
        }
        diff.getItems().addAll(diffi);

    }

    @FXML
    protected boolean validInput(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        return true;
    }


    @FXML
    public void onConfirm(javafx.event.ActionEvent event) throws IOException {
        String pName = playerName.getText();
        String dif = diff.getValue();
        if (!validInput(pName)) {
            inputError.setText("Please enter a valid name");
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FirstScreen.fxml"));
            root = loader.load();
            FirstScreenController controller = loader.getController();
            controller.dnDisplay(dif, pName);
            controller.mhDisplay(dif);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root, 1080, 720);
            stage.setScene(scene);
            stage.show();
        }

    }

}
