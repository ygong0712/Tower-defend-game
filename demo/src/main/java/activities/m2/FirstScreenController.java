package activities.m2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.shape.Circle;


public class  FirstScreenController {
    @FXML
    private Label health;
    @FXML
    private Label money;
    @FXML
    private Label name;
    @FXML
    private Label difficulty;
    @FXML
    private Label numOfSmallTower;
    @FXML
    private Label numOfMediumTower;
    @FXML
    private Label numOfLargeTower;
    @FXML
    private ComboBox<String> towerCombos;
    @FXML
    private Label spot1;
    @FXML
    private Label spot2;
    @FXML
    private Label spot3;
    @FXML
    private Label spot4;
    @FXML
    private Label spot5;
    @FXML
    private Label spot6;
    @FXML
    private Label spot7;
    @FXML
    private Label spot8;
    @FXML
    private Label spot9;
    @FXML
    private Label spot10;

    private Scene scene;
    private Stage stage;
    private Parent root;

    private ObservableList<String> comboList = FXCollections.
            observableArrayList("Put Small Tower", "Put Medium Tower", "Put Large Tower");
    public void dnDisplay(String sdiff, String sname) {
        name.setText(sname);
        difficulty.setText(sdiff);
    }

    public void mhDisplay(String sDiff) {
        if (sDiff.equals("easy")) {
            health.setText("1000");
            money.setText("5000");
        } else if (sDiff.equals("medium")) {
            health.setText("500");
            money.setText("3000");
        } else {
            health.setText("100");
            money.setText("1000");
        }
    }

    public void backMhDisplay(String sDiff, String mon) {
        if (sDiff.equals("easy")) {
            health.setText("1000");

        } else if (sDiff.equals("medium")) {
            health.setText("500");

        } else {
            health.setText("100");
        }
        money.setText(mon);
    }

    public void recordBoughtTower(String snum, String mnum, String lnum) {
        Integer sNum = Integer.parseInt(snum);
        Integer mNum = Integer.parseInt(mnum);
        Integer lNum = Integer.parseInt(lnum);
        numOfSmallTower.setText(sNum.toString());
        numOfMediumTower.setText(mNum.toString());
        numOfLargeTower.setText(lNum.toString());
    }



    @FXML
    public void onBuyTower(javafx.event.ActionEvent event) throws IOException {
        String dif = difficulty.getText();
        String mon = money.getText();
        String smallTower = numOfSmallTower.getText();
        String mediumTower = numOfMediumTower.getText();
        String largeTower = numOfLargeTower.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("BuyTower.fxml"));
        root = loader.load();
        BuyTower controller = loader.getController();
        controller.dmDisplay(dif, mon, smallTower, mediumTower, largeTower);
        controller.smldisplay(dif);
        controller.receiveName(name.getText());
        controller.receiveSpot1(spot1.getText(), spot2.getText(),
                spot3.getText(), spot4.getText(), spot5.getText());
        controller.receiveSpot2(spot6.getText(), spot7.getText(),
                spot8.getText(), spot9.getText(), spot10.getText());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1080, 720);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    private void initialize() {
        towerCombos.setValue("Please choose tower to put!");
        towerCombos.setItems(comboList);
    }

    @FXML
    public void spotDisplay1(String ss1, String ss2, String ss3, String ss4, String ss5) {
        spot1.setText(ss1);
        spot2.setText(ss2);
        spot3.setText(ss3);
        spot4.setText(ss4);
        spot5.setText(ss5);
    }
    public void spotDisplay2(String ss6, String ss7, String ss8, String ss9, String ss10) {
        spot6.setText(ss6);
        spot7.setText(ss7);
        spot8.setText(ss8);
        spot9.setText(ss9);
        spot10.setText(ss10);
    }

    public void placeTower(Label spot) {
        if (spot.getText().equals("Place Tower")) {
            if (towerCombos.getValue().equals("Put Small Tower")
                    && !numOfSmallTower.getText().equals("0")) {
                spot.setText("small tower");
                Integer newNum = Integer.parseInt(numOfSmallTower.getText()) - 1;
                numOfSmallTower.setText(newNum.toString());
            } else if (towerCombos.getValue().equals("Put Medium Tower")
                    && !numOfMediumTower.getText().equals("0")) {
                spot.setText("medium tower");
                Integer newNum = Integer.parseInt(numOfMediumTower.getText()) - 1;
                numOfMediumTower.setText(newNum.toString());
            } else if (towerCombos.getValue().equals("Put Large Tower")
                    && !numOfLargeTower.getText().equals("0")) {
                spot.setText("large tower");
                Integer newNum = Integer.parseInt(numOfLargeTower.getText()) - 1;
                numOfLargeTower.setText(newNum.toString());
            }
        }
    }
    @FXML
    public void onClickSpot1(javafx.scene.input.MouseEvent e) {
        placeTower(spot1);
    }
    @FXML
    public void onClickSpot2(javafx.scene.input.MouseEvent e) {
        placeTower(spot2);
    }
    @FXML
    public void onClickSpot3(javafx.scene.input.MouseEvent e) {
        placeTower(spot3);
    }
    @FXML
    public void onClickSpot4(javafx.scene.input.MouseEvent e) {
        placeTower(spot4);
    }
    @FXML
    public void onClickSpot5(javafx.scene.input.MouseEvent e) {
        placeTower(spot5);
    }
    @FXML
    public void onClickSpot6(javafx.scene.input.MouseEvent e) {
        placeTower(spot6);
    }
    @FXML
    public void onClickSpot7(javafx.scene.input.MouseEvent e) {
        placeTower(spot7);
    }
    @FXML
    public void onClickSpot8(javafx.scene.input.MouseEvent e) {
        placeTower(spot8);
    }
    @FXML
    public void onClickSpot9(javafx.scene.input.MouseEvent e) {
        placeTower(spot9);
    }
    @FXML
    public void onClickSpot10(javafx.scene.input.MouseEvent e) {
        placeTower(spot10);
    }


}
