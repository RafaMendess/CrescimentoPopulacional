package com.example.crescimentopopulacional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
public class Controller {
    @FXML private Parent root;
    @FXML private Scene scene;
    @FXML private Stage stage;
    @FXML protected Button GerarGraficoButton;

    @FXML protected TextField anoTextField;

    @FXML protected Label erroLabel;
    @FXML protected MenuButton menu;
    public void changeScene(String endereco, String titulo, Stage stageAnterior) {
        if (endereco == null)   return;

        try {
            root = FXMLLoader.load(getClass().getResource(endereco));
            scene = new Scene(root);
            stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(scene);
            stage.show();
            stageAnterior.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    protected void handleMenuSelected(ActionEvent event) {
        MenuItem menuItem = (MenuItem) event.getSource();
        String pais= menuItem.getText();
        menu.setText(pais);
        Dados.pais=pais;
    }

    @FXML
    protected void gerarGraficoOnClick(ActionEvent event){
        if(anoTextField.getText().isEmpty()){
            erroLabel.setText("Valor inválido,tente novamente!");
        }
        else if(Integer.parseInt(anoTextField.getText())<2021){
            erroLabel.setText("Valor inválido,tente novamente!");
        }
        else if(Integer.parseInt(anoTextField.getText())>2035){
            erroLabel.setText("Valor muito alto,tente novamente!");
        }
        else{
            Dados.ano=Integer.parseInt(anoTextField.getText());
            if(Dados.pais.equals("Todos")|| Dados.pais.isBlank()){
                changeScene("GraficoPizza.fxml", "Pizza", (Stage) GerarGraficoButton.getScene().getWindow());
            }
            else{
                changeScene("Grafico.fxml", "Grafico de barras", (Stage) GerarGraficoButton.getScene().getWindow());
            }
        }
    }



}