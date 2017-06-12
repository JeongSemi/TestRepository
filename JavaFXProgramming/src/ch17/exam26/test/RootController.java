package ch17.exam26.test;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

public class RootController implements Initializable {

//    @FXML
//    private BarChart<String, Integer> barChart;
    @FXML
    private AnchorPane anchorPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         CategoryAxis xAxis = new CategoryAxis();
 
       NumberAxis yAxis = new NumberAxis();
        CustomBarChart cbChart = new CustomBarChart(xAxis, yAxis);
        cbChart.setLayoutX(20);
        cbChart.setLayoutY(20);
        cbChart.setPrefWidth(100);
        cbChart.setPrefHeight(50);
        anchorPane.getChildren().add(cbChart);

        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("남자");
        ObservableList<XYChart.Data<String, Number>> data2 = FXCollections.observableArrayList();
        data2.add(new XYChart.Data<String, Number>("2015", 70));
        data2.add(new XYChart.Data<String, Number>("2016", 30));
        data2.add(new XYChart.Data<String, Number>("2017", 50));
        data2.add(new XYChart.Data<String, Number>("2018", 80));
        data2.add(new XYChart.Data<String, Number>("2019", 20));
        series1.setData(data2);
//        barChart.getData().add(series1);
        //areaChart.getData().add(series1); ->데이터는 공유할 수 없다.
        
        cbChart.getData().add(series1);

        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("여자");
        ObservableList<XYChart.Data<String, Number>> data3 = FXCollections.observableArrayList();
        data3.add(new XYChart.Data<String, Number>("2015", 10));
        data3.add(new XYChart.Data<String, Number>("2016", 90));
        data3.add(new XYChart.Data<String, Number>("2017", 20));
        data3.add(new XYChart.Data<String, Number>("2018", 70));
        data3.add(new XYChart.Data<String, Number>("2019", 50));
        series2.setData(data3);
//        barChart.getData().add(series2);
        cbChart.getData().add(series2);

        
        
    }

}
