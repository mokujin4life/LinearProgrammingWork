package com.mokujin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.commons.math3.linear.*;
import resources.GaussMethod;

import java.util.ArrayList;


public class Controller {


    @FXML
    private TextField perfusionTime;

    @FXML
    private TextField minPerfusion;

    @FXML
    private TextField maxPerfusion;

    @FXML
    private TextField age;


    @FXML
    private TextField clampingTime;

    @FXML
    private TextField minClamping;

    @FXML
    private TextField maxClamping;


    @FXML
    private TextField erythrocytes;

    @FXML
    private TextField minErythrocytes;

    @FXML
    private TextField maxErythrocytes;


    @FXML
    private TextField sodium;

    @FXML
    private TextField minSodium;

    @FXML
    private TextField maxSodium;


    @FXML
    private TextField potassium;

    @FXML
    private TextField minPotassium;

    @FXML
    private TextField maxPotassium;


    @FXML
    private TextField hemoglobin;

    @FXML
    private TextField minHemologlobin;

    @FXML
    private TextField maxHemologlobin;


    @FXML
    private TextField constant;


    @FXML
    private Label clampingTimeLabel;

    @FXML
    private Label perfusionTimeLabel;

    @FXML
    private Label erythrocytesLabel;

    @FXML
    private Label sodiumLabel;

    @FXML
    private Label potassiumLabel;

    static GaussMethod gaussMethod = new GaussMethod();

    @FXML
    private Label hemologlobinLabel;

    @FXML
    private Label ageLabel;

    @FXML
    private Label constantLabel;

    @FXML
    private Button exitButton;

    public void sumUp(ActionEvent actionEvent) {
        double ageK = Double.parseDouble(age.getText().replace(",", "."));
        double perfusionK = Double.parseDouble(perfusionTime.getText().replace(",", "."));
        double clampingK = Double.parseDouble(clampingTime.getText().replace(",", "."));
        double erythrocytesK = Double.parseDouble(erythrocytes.getText().replace(",", "."));
        double sodiumK = Double.parseDouble(sodium.getText().replace(",", "."));
        double potassiumK = Double.parseDouble(potassium.getText().replace(",", "."));
        double hemoglobinK = Double.parseDouble(hemoglobin.getText().replace(",", "."));


        RealMatrix coefficients =
                new Array2DRowRealMatrix(new double[][]{{-0.74, 0.004, -0.008, -0.010, 11.338, 0.153, 1.907},
                        {0, 0, 0, 0, 0, -0.201, -0.029}, {0.011, -0.001, -0.002, -0.002, 5.063, 0.016, -0.020}},
                        false);
        DecompositionSolver solver = new QRDecomposition(coefficients).getSolver();

        RealVector constants = new ArrayRealVector(new double[]{31.484, 58.059, 546.825}, false);
        gaussMethod.setMaxMinX1(50, 20);
        gaussMethod.setMaxMinX2(Integer.parseInt(maxPerfusion.getText()), Integer.parseInt(minPerfusion.getText()));
        gaussMethod.setMaxMinX3(Integer.parseInt(maxClamping.getText()), Integer.parseInt(minClamping.getText()));
        gaussMethod.setMaxMinX4(Integer.parseInt(maxHemologlobin.getText()), Integer.parseInt(minHemologlobin.getText()));
        gaussMethod.setMaxMinX5(Integer.parseInt(maxErythrocytes.getText()), Integer.parseInt(minErythrocytes.getText()));
        gaussMethod.setMaxMinX6(Integer.parseInt(maxSodium.getText()), Integer.parseInt(minSodium.getText()));
        gaussMethod.setMaxMinX7(Integer.parseInt(maxPotassium.getText()), Integer.parseInt(minPotassium.getText()));
        System.out.println("age:" + ageK);
        System.out.println("perf:" + perfusionK);
        System.out.println("clamp:" + clampingK);
        System.out.println("hem:" + hemoglobinK);
        System.out.println("er:" + erythrocytesK);
        System.out.println("na:" + sodiumK);
        System.out.println("k:" + potassiumK);
        ArrayList arrayList = gaussMethod.calculate(ageK, perfusionK, clampingK, hemoglobinK, erythrocytesK, sodiumK, potassiumK);

        int x2 = (Integer) arrayList.get(0);
        int x5 = (Integer) arrayList.get(1);
        int x6 = (Integer) arrayList.get(2);
        int x8 = (Integer) arrayList.get(3);
        int x11 = (Integer) arrayList.get(4);
        int x13 = (Integer) arrayList.get(5);
        int x15 = (Integer) arrayList.get(6);
        double y = ageK * x2 + perfusionK * x5 + clampingK * x6 + hemoglobinK * x8 + erythrocytesK * x11 + sodiumK * x13 + potassiumK * x15 + 91.067;

        perfusionTimeLabel.setText(String.valueOf(x5));
        ageLabel.setText(String.valueOf(x2));
        constantLabel.setText(String.valueOf(91.067 - 20));
        clampingTimeLabel.setText(String.valueOf(x6));
        sodiumLabel.setText(String.valueOf(x13));
        potassiumLabel.setText(String.valueOf(x15));
        erythrocytesLabel.setText(String.valueOf(x11));
        hemologlobinLabel.setText(String.valueOf(x8));
    }

    public void clearAll(ActionEvent actionEvent) {
        perfusionTime.clear();
        maxPerfusion.clear();
        minPerfusion.clear();
        clampingTime.clear();
        minClamping.clear();
        maxClamping.clear();
        erythrocytes.clear();
        minErythrocytes.clear();
        maxErythrocytes.clear();
        sodium.clear();
        maxSodium.clear();
        minSodium.clear();
        potassium.clear();
        minPotassium.clear();
        maxPotassium.clear();
        hemoglobin.clear();
        minHemologlobin.clear();
        maxHemologlobin.clear();
        age.clear();
        constant.clear();
        perfusionTimeLabel.setText("");
        ageLabel.setText("");
        constantLabel.setText("");
        clampingTimeLabel.setText("");
        sodiumLabel.setText("");
        potassiumLabel.setText("");
        erythrocytesLabel.setText("");
        hemologlobinLabel.setText("");
    }

    public void setDefault(ActionEvent actionEvent) {
        age.setText("-0,144");
        constant.setText("91,067");
        perfusionTime.setText("0,019");
        maxPerfusion.setText("400");
        minPerfusion.setText("155");
        clampingTime.setText("0,008");
        minClamping.setText("60");
        maxClamping.setText("242");
        erythrocytes.setText("152,646");
        minErythrocytes.setText("24");
        maxErythrocytes.setText("58");
        sodium.setText("0,159");
        maxSodium.setText("155");
        minSodium.setText("124");
        potassium.setText("2,925");
        minPotassium.setText("249");
        maxPotassium.setText("550");
        hemoglobin.setText("0,056");
        minHemologlobin.setText("70");
        maxHemologlobin.setText("160");
    }

    @FXML
    public void exit(ActionEvent actionEvent) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}
