module group02.rdpclient {
    requires javafx.controls;
    requires javafx.fxml;


    opens group02.rdpclient to javafx.fxml;
    exports group02.rdpclient;
    exports group02.rdpclient.controller;
    opens group02.rdpclient.controller to javafx.fxml;
}