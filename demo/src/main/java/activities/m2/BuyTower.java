package activities.m2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class BuyTower {
    @FXML
    private Label aMoney;
    @FXML
    private Label bMoney;
    @FXML
    private Label cMoney;
    @FXML
    private Label difficulty;
    @FXML
    private Label money;
    @FXML
    private Label aLeft;
    @FXML
    private Label bLeft;
    @FXML
    private Label cLeft;

    @FXML
    private Label error;



    private Scene scene;
    private Stage stage;
    private Parent root;

    private String name;
    private String spot1;
    private String spot2;
    private String spot3;
    private String spot4;
    private String spot5;
    private String spot6;
    private String spot7;
    private String spot8;
    private String spot9;
    private String spot10;


    public String getSpot1() {
        return this.spot1;
    }

    public String getSpot2() {
        return this.spot2;
    }

    public String getSpot3() {
        return this.spot3;
    }

    public String getSpot4() {
        return this.spot4;
    }

    public String getSpot5() {
        return this.spot5;
    }

    public String getSpot6() {
        return this.spot6;
    }

    public String getSpot7() {
        return this.spot7;
    }

    public String getSpot8() {
        return this.spot8;
    }

    public String getSpot9() {
        return this.spot9;
    }

    public String getSpot10() {
        return this.spot10;
    }

    public String getName() {
        return this.name;
    }



    public void dmDisplay(String todiff, String tomoney,
                          String numSTs, String numMTs, String numLTs) {
        difficulty.setText(todiff);
        money.setText(tomoney);
        aLeft.setText(numSTs);
        bLeft.setText(numMTs);
        cLeft.setText(numLTs);
    }

    public void smldisplay(String todiff) {
        if (todiff.equals("easy")) {
            aMoney.setText("100");
            bMoney.setText("200");
            cMoney.setText("300");
        } else if (todiff.equals("medium")) {
            aMoney.setText("200");
            bMoney.setText("400");
            cMoney.setText("800");
        } else {
            aMoney.setText("500");
            bMoney.setText("1000");
            cMoney.setText("2000");
        }
    }

    public void receiveName(String toName) {
        name = toName;
    }

    public void receiveSpot1(String ss1, String ss2, String ss3, String ss4, String ss5) {
        spot1 = ss1;
        spot2 = ss2;
        spot3 = ss3;
        spot4 = ss4;
        spot5 = ss5;
    }
    public void receiveSpot2(String ss6, String ss7, String ss8, String ss9, String ss10) {
        spot6 = ss6;
        spot7 = ss7;
        spot8 = ss8;
        spot9 = ss9;
        spot10 = ss10;
    }

    public boolean canBuy(int moneyLeft, int aCost) {
        if (moneyLeft >= aCost) {
            return true;
        }
        return false;
    }

    @FXML
    public void onBuyA(javafx.event.ActionEvent event) throws IOException {
        int moneyLeft = Integer.parseInt(money.getText());
        int aCost = Integer.parseInt(aMoney.getText());
        if (canBuy(moneyLeft, aCost)) {
            error.setText("");
            money.setText(String.valueOf(moneyLeft - aCost));
            int toALeft = Integer.parseInt(aLeft.getText());
            toALeft = toALeft + 1;
            aLeft.setText(String.valueOf(toALeft));
        } else {
            error.setText("money not enough");
        }



    }
    @FXML
    public void onBuyB(javafx.event.ActionEvent event) throws IOException {
        int moneyLeft = Integer.parseInt(money.getText());
        int bCost = Integer.parseInt(bMoney.getText());
        if (canBuy(moneyLeft, bCost)) {
            error.setText("");
            money.setText(String.valueOf(moneyLeft - bCost));
            int tobleft = Integer.parseInt(bLeft.getText());
            tobleft = tobleft + 1;
            bLeft.setText(String.valueOf(tobleft));
        } else {
            error.setText("money not enough");
        }
    }
    @FXML
    public void onBuyC(javafx.event.ActionEvent event) throws IOException {
        int moneyLeft = Integer.parseInt(money.getText());
        int cCost = Integer.parseInt(cMoney.getText());
        if (canBuy(moneyLeft, cCost)) {
            error.setText("");
            money.setText(String.valueOf(moneyLeft - cCost));
            int toCLeft = Integer.parseInt(cLeft.getText());
            toCLeft = toCLeft + 1;
            cLeft.setText(String.valueOf(toCLeft));
        } else {
            error.setText("money not enough");
        }
    }

    @FXML
    public void onBack(javafx.event.ActionEvent event) throws IOException {
        String dif = difficulty.getText();
        String mon = money.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FirstScreen.fxml"));
        root = loader.load();
        FirstScreenController controller = loader.getController();
        controller.dnDisplay(dif, name);
        controller.backMhDisplay(dif, mon);
        controller.spotDisplay1(spot1, spot2, spot3, spot4, spot5);
        controller.spotDisplay2(spot6, spot7, spot8, spot9, spot10);
        controller.recordBoughtTower(aLeft.getText(), bLeft.getText(), cLeft.getText());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1080, 720);
        stage.setScene(scene);
        stage.show();
    }
}
