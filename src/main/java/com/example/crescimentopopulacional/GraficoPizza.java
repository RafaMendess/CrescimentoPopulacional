package com.example.crescimentopopulacional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class GraficoPizza implements Initializable {
    @FXML protected PieChart graficoPizza;

    private Map<String, Integer> populacao = new HashMap<>();
    private Map<String, Double> percent = new HashMap<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        graficoPizza.setTitle(graficoPizza.getTitle()+" "+Dados.ano);
        populacao.put("Argentina", 45810000);
        populacao.put("Bolívia", 12080000);
        populacao.put("Brasil", 214300000);
        populacao.put("Chile", 19490000);
        populacao.put("Colômbia", 51520000);
        populacao.put("Equador", 17800000);
        populacao.put("Guiana", 804567);
        populacao.put("Guiana Francesa", 294071);
        populacao.put("Paraguai", 6704000);
        populacao.put("Peru", 33720000);
        populacao.put("Suriname", 612985);
        populacao.put("Uruguai", 3426000);
        populacao.put("Venezuela", 28200000);

        percent.put("Argentina", 0.012);
        percent.put("Bolívia", 0.009);
        percent.put("Brasil", 0.005);
        percent.put("Chile", 0.01);
        percent.put("Colômbia", 0.011);
        percent.put("Equador", 0.012);
        percent.put("Guiana", 0.009);
        percent.put("Guiana Francesa", 0.035);
        percent.put("Paraguai", 0.013);
        percent.put("Peru", 0.012);
        percent.put("Suriname", 0.01);
        percent.put("Uruguai", -0.001);
        percent.put("Venezuela", -0.01);

        graficoPizza.setData(calcular());

    }

    private ObservableList<PieChart.Data> calcular(){
        ObservableList<PieChart.Data> dados=FXCollections.observableArrayList();

        for(var pais: populacao.keySet()){
            dados.add(new PieChart.Data(pais,populacao.get(pais)+(populacao.get(pais)*Math.pow(1-percent.get(pais),Dados.ano-2022))));
        }

        return dados;
    }


}
