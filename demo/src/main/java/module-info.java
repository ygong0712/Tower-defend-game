module activities.m2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;

    opens activities.m2 to javafx.fxml;
    exports activities.m2;
}