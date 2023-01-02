/**
 * Sample Skeleton for 'FXMLDocument.fxml' Controller Class
 */
package javafxapplication_shenyuan;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.util.*;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import binmethod.*;
import javafx.scene.chart.LineChart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FXMLDocumentController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // fx:id="windowframe"
    private AnchorPane windowframe; // Value injected by FXMLLoader

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="label"
    private Label label; // Value injected by FXMLLoader

    @FXML // fx:id="chart"
    private Pane chart; // Value injected by FXMLLoader

    @FXML // fx:id="linChart"
    private LineChart<?, ?> linChart; // Value injected by FXMLLoader

    @FXML // fx:id="barChart"
    private BarChart<?, ?> barChart; // Value injected by FXMLLoader

    @FXML // fx:id="saveButton"
    private Button saveButton; // Value injected by FXMLLoader

    @FXML // fx:id="openButton"
    private Button openButton; // Value injected by FXMLLoader

    @FXML // fx:id="cleanButton"
    private Button cleanButton; // Value injected by FXMLLoader

    @FXML // fx:id="fitButton"
    private Button fitButton; // Value injected by FXMLLoader

    @FXML // fx:id="statisticPane"
    private AnchorPane statisticPane; // Value injected by FXMLLoader

    @FXML // fx:id="statisticTextArea"
    private TextArea statisticTextArea; // Value injected by FXMLLoader

    @FXML // fx:id="gaussianPane"
    private AnchorPane gaussianPane; // Value injected by FXMLLoader

    @FXML // fx:id="gaussianTextArea"
    private TextArea gaussianTextArea; // Value injected by FXMLLoader

    @FXML // fx:id="comboBox"
    private ComboBox comboBox; // Value injected by FXMLLoader

    private List<Double> inputData;

    @FXML
    void cleanButtonClicked(ActionEvent event) {
        cleanContent();
    }

    @FXML
    void fitButtonClicked(ActionEvent event) {

        StatisticDataFilter.showPDFparameters(gaussianTextArea);
        String binmethodString = (String) comboBox.getValue();
        if (binmethodString == "RiceRule") {
            //cleanContent();
            RiceRuleFormula ricerule = new RiceRuleFormula(IOOperation.getInputData());
            ChartRenderer.drawLineChart(linChart, ricerule);
        }
        if (binmethodString == "SquareRoot") {
            //cleanContent();
            SquareRootChoiceFormula squareroot = new SquareRootChoiceFormula(IOOperation.getInputData());
            ChartRenderer.drawLineChart(linChart, squareroot);
        }
        if (binmethodString == "Sturges") {
            //cleanContent();
            SturgesFormula sturges = new SturgesFormula(IOOperation.getInputData());
            ChartRenderer.drawLineChart(linChart, sturges);
        }

    }

    @FXML
    void openButtonClicked(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("TXT Files", "*.txt"));
        File f = fc.showOpenDialog(null);
        IOOperation.openFile(f);
        StatisticDataFilter.showStatisticData(statisticTextArea);
        String binmethodString = (String) comboBox.getValue();

        if (binmethodString == "RiceRule") {
            //cleanContent();
            RiceRuleFormula ricerule = new RiceRuleFormula(IOOperation.getInputData());
            ChartRenderer.drawBarChart(barChart, ricerule);
        }
        if (binmethodString == "SquareRoot") {
            //cleanContent();
            SquareRootChoiceFormula squareroot = new SquareRootChoiceFormula(IOOperation.getInputData());
            ChartRenderer.drawBarChart(barChart, squareroot);
        }
        if (binmethodString == "Sturges") {
            //cleanContent();
            SturgesFormula sturges = new SturgesFormula(IOOperation.getInputData());
            ChartRenderer.drawBarChart(barChart, sturges);

        }
    }

    @FXML
    void saveButtonClicked(ActionEvent event) throws Exception {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Image");
        File file = fileChooser.showSaveDialog(new Stage());
        IOOperation.SaveToFile(chart, file);
    }

    @FXML
    void setComboBox(ActionEvent event) {

        String binmethodString = (String) comboBox.getValue();
        if (binmethodString == "RiceRule") {
            cleanContent();
            RiceRuleFormula ricerule = new RiceRuleFormula(IOOperation.getInputData());
            ChartRenderer.drawBarChart(barChart, ricerule);
        }

        if (binmethodString == "SquareRoot") {
            cleanContent();
            SquareRootChoiceFormula squareroot = new SquareRootChoiceFormula(IOOperation.getInputData());
            ChartRenderer.drawBarChart(barChart, squareroot);
        }
        if (binmethodString == "Sturges") {
            cleanContent();
            SturgesFormula sturges = new SturgesFormula(IOOperation.getInputData());
            ChartRenderer.drawBarChart(barChart, sturges);
        }

    }

    @FXML
    void cleanContent() {
        barChart.getData().clear();
        linChart.getData().clear();
        gaussianTextArea.clear();

    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert windowframe != null : "fx:id=\"windowframe\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert barChart != null : "fx:id=\"barChart\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert linChart != null : "fx:id=\"linChart\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert openButton != null : "fx:id=\"openButton\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert cleanButton != null : "fx:id=\"cleanButton\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert fitButton != null : "fx:id=\"fitButton\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert statisticPane != null : "fx:id=\"statisticPane\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert statisticTextArea != null : "fx:id=\"statisticTextArea\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert gaussianPane != null : "fx:id=\"gaussianPane\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert gaussianTextArea != null : "fx:id=\"gaussianTextArea\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert comboBox != null : "fx:id=\"comboBox\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert chart != null : "fx:id=\"chart\" was not injected: check your FXML file 'FXMLDocument.fxml'.";

        comboBox.getItems().addAll("RiceRule", "SquareRoot", "Sturges");
        comboBox.getSelectionModel().select("RiceRule");
        barChart.getXAxis().setLabel("Measurement Data /um");
        barChart.getYAxis().setLabel("Frequency");
        linChart.getXAxis().setLabel("Measurement Data /um");
        linChart.getYAxis().setLabel("Frequency");
        barChart.setPrefSize(650, 500);
        barChart.setLegendVisible(false);
        barChart.setLayoutX(0);
        barChart.setLayoutY(0);
        linChart.setPrefSize(650, 500);
        linChart.setLegendVisible(false);
        linChart.setLayoutX(0);
        linChart.setLayoutY(0);

    }
}
