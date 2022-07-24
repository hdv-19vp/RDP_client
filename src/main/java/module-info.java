module group02.rdpclient {
    requires javafx.controls;
    requires javafx.fxml;


    opens group02.rdpclient to javafx.fxml;
    exports group02.rdpclient;
}