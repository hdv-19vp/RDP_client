module group02.rdpclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;
    requires org.apache.commons.io;


    opens group02.rdpclient.controller to javafx.fxml;
    exports group02.rdpclient.controller;
}