module com.example.alakzatjavafx260911 {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens com.example.alakzatjavafx260911 to javafx.fxml;
    exports com.example.alakzatjavafx260911;
}