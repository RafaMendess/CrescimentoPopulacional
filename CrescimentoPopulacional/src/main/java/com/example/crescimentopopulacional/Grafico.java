package com.example.crescimentopopulacional;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Grafico implements Initializable {

    @FXML
    protected CategoryAxis x;

    @FXML protected NumberAxis y;
    @FXML protected BarChart Grafico;

    private Map<String, Integer> populacao = new HashMap<>();
    private Map<String, Double> percent = new HashMap<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Grafico.setTitle(Grafico.getTitle()+" do "+Dados.pais+ " até "+ Dados.ano);

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

        Map<Integer,Double> dadosgrafico=calcular();

        XYChart.Series set= new XYChart.Series<>();
        for(var ano: dadosgrafico.keySet()){
            set.getData().add(new XYChart.Data(Integer.toString(ano),populacao.get(Dados.pais)+dadosgrafico.get(ano)));
        }
        Grafico.getData().addAll(set);


    }



    private Map<Integer,Double> calcular(){
            Map<Integer,Double> crescimentoPopulacional= new HashMap<>();

            for(int ano=2022;ano<=Dados.ano;ano++){
                Double crescimentoPais=populacao.get(Dados.pais)*Math.pow(1+percent.get(Dados.pais), Dados.ano-ano);
                crescimentoPopulacional.put(ano, crescimentoPais);
            }


            return crescimentoPopulacional;
    }



}
