package com.example.alakzatjavafx260911;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.*;
import java.util.ArrayList;

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


    private ObservableList<Alakzat> alakzatLista = FXCollections.observableArrayList();

    public void initialize() {
        lv_lista.setItems(alakzatLista);

        File file = new File("alakzat.dat");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String sor;
            while ((sor = reader.readLine()) != null) {
                if (sor.trim().isEmpty()) continue;

                String[] alakzat = sor.split(";");
                if (alakzat.length == 2) {
                    String szinAdat = alakzat[0].trim();
                    String alakzatAdat = alakzat[1].trim();
                    alakzatLista.add(new Alakzat(szinAdat, alakzatAdat));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        if (!szin.isEmpty() && !alakzat.isEmpty()) {
            alakzatLista.add(new Alakzat(szin, alakzat));
        }
    }

    public void onTorol(ActionEvent actionEvent) {
        Object kivalasztott = lv_lista.getSelectionModel().getSelectedItem();
        if (kivalasztott != null) {
            alakzatLista.remove(kivalasztott);
        }
    }

    public void onMentes(ActionEvent actionEvent) {
        File file = new File("alakzat.dat");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Alakzat elem : alakzatLista) {
                writer.write(elem.getSzin() + ";" + elem.getAlakzat());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

