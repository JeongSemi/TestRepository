package ch17.exam26;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class RootController implements Initializable {

    private PieChart pieChart;
    @FXML
    private BarChart<String, Integer> barChart;
    private AreaChart<String, Integer> areaChart;
    @FXML
    private AnchorPane anchorPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<PieChart.Data> data1 = FXCollections.observableArrayList();
        data1.add(new PieChart.Data("AWT", 10));
        data1.add(new PieChart.Data("Swing", 30));
        data1.add(new PieChart.Data("SWT", 25));
        data1.add(new PieChart.Data("JavaFX", 35));
        pieChart.setData(data1);

        XYChart.Series<String, Integer> series1 = new XYChart.Series<>();
        series1.setName("남자");
        ObservableList<XYChart.Data<String, Integer>> data2 = FXCollections.observableArrayList();
        data2.add(new XYChart.Data<String, Integer>("2015", 70));
        data2.add(new XYChart.Data<String, Integer>("2016", 30));
        data2.add(new XYChart.Data<String, Integer>("2017", 50));
        data2.add(new XYChart.Data<String, Integer>("2018", 80));
        data2.add(new XYChart.Data<String, Integer>("2019", 20));
        series1.setData(data2);
        barChart.getData().add(series1);
        //areaChart.getData().add(series1); ->데이터는 공유할 수 없다.

        XYChart.Series<String, Integer> series2 = new XYChart.Series<>();
        series2.setName("여자");
        ObservableList<XYChart.Data<String, Integer>> data3 = FXCollections.observableArrayList();
        data3.add(new XYChart.Data<String, Integer>("2015", 10));
        data3.add(new XYChart.Data<String, Integer>("2016", 90));
        data3.add(new XYChart.Data<String, Integer>("2017", 20));
        data3.add(new XYChart.Data<String, Integer>("2018", 70));
        data3.add(new XYChart.Data<String, Integer>("2019", 50));
        series2.setData(data3);
        barChart.getData().add(series2);
        //areaChart.getData().add(series2);

        for (Series< String, Integer> series : barChart.getData()) {
            for (int i = 0; i < series.getData().size(); i++) {
//                StackPane bar = (StackPane) series.getData().get(i).getNode();
                Text text = null;
                
//                for (int j = 0; j < ((Group) bar.getParent()).getChildren().filtered((t) -> {
//                    return t instanceof Text;
//                }).size(); j++) {
//                    Node node = ((Group) bar.getParent()).getChildren().filtered((t) -> {
//                        return t instanceof Text;
//                    }).get(j);
//                    if (i == j) {
//                        text = (Text) node;
//                        break;
//                    }
//
//                }
               
                final Node node = series.getData().get(i).getNode();
                text.setText(series.getData().get(i).getYValue() + "");
                node.parentProperty().addListener(new ChangeListener<Parent>() {
                    @Override
                    public void changed(ObservableValue<? extends Parent> ov, Parent oldParent, Parent parent) {
                        Group parentGroup = (Group) parent;
                        parentGroup.getChildren().add(text);
                    }
                });
                
                
                Group parentGroup = (Group) node.getParent();
                parentGroup.getChildren().add(text);

                node.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
                    @Override
                    public void changed(ObservableValue<? extends Bounds> ov, Bounds oldBounds, Bounds bounds) {
                        text.setLayoutX(
                                Math.round(
                                        bounds.getMinX() + bounds.getWidth() / 2 - text.prefWidth(-1) / 2
                                )
                        );
                        text.setLayoutY(
                                Math.round(
                                        bounds.getMinY() - text.prefHeight(-1) * 0.5
                                )
                        );
                    }
                });
            }
        }

        XYChart.Series<String, Integer> series3 = new XYChart.Series<>();
        series3.setName("평균온도");
        ObservableList<XYChart.Data<String, Integer>> data4 = FXCollections.observableArrayList();
        data4.add(new XYChart.Data<String, Integer>("2015", 13));
        data4.add(new XYChart.Data<String, Integer>("2016", 6));
        data4.add(new XYChart.Data<String, Integer>("2017", 22));
        data4.add(new XYChart.Data<String, Integer>("2018", 19));
        data4.add(new XYChart.Data<String, Integer>("2019", 15));
        series3.setData(data4);
        areaChart.getData().add(series3);

        XYChart.Series<String, Integer> series4 = new XYChart.Series<>();
        series4.setName("평균강수량");
        ObservableList<XYChart.Data<String, Integer>> data5 = FXCollections.observableArrayList();
        data5.add(new XYChart.Data<String, Integer>("2015", 11));
        data5.add(new XYChart.Data<String, Integer>("2016", 28));
        data5.add(new XYChart.Data<String, Integer>("2017", 21));
        data5.add(new XYChart.Data<String, Integer>("2018", 5));
        data5.add(new XYChart.Data<String, Integer>("2019", 19));
        series4.setData(data5);
        areaChart.getData().add(series4);

    }

}
