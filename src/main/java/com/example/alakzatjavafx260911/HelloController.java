package com.example.alakzatjavafx260911;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.text.Normalizer;
import java.util.Objects;

public class HelloController {
    @FXML
    public RadioButton rb_piros;
    @FXML
    public RadioButton rb_zold;
    @FXML
    public RadioButton rb_kek;
    @FXML
    public RadioButton rb_kor;
    @FXML
    public RadioButton rb_haromszog;
    @FXML
    public RadioButton rb_negyzet;
    @FXML
    public ImageView iv_kep;
    @FXML
    public ListView lv_lista;
    @FXML
    public Label l_kep;

    @FXML
    String szin = "";
    String alakzat = "";

    public void initialize() {

    }

    public void onSzinClick(ActionEvent actionEvent) {
        RadioButton radioButton = (RadioButton) actionEvent.getSource();
        szin = radioButton.getText().toLowerCase();

        String szinNEv = switch (szin) {
            case "piros" -> "red";
            case "kék" -> "blue";
            case "zöld" -> "green";
            default -> null;
        };

        l_kep.setStyle("-fx-background-color:"+szinNEv+";");
    }
    public void onAlakzatClick(ActionEvent actionEvent) {
        RadioButton radioButton = (RadioButton) actionEvent.getSource();
        alakzat = radioButton.getText().toLowerCase();

        String kepNev = switch (alakzat) {
            case "háromszög" -> "haromszog.png";
            case "kör" -> "kor.png";
            case "négyzet" -> "negyzet.png";
            default -> null;
        };

        if (kepNev != null) {
            Image image = new Image("file:icons/icons/"+kepNev);

            iv_kep.setImage(image);
        }
    }

    public void onHozzaad(ActionEvent actionEvent) {

    }

    public void onTorol(ActionEvent actionEvent) {

    }

    public void onMentes(ActionEvent actionEvent) {

    }
}

