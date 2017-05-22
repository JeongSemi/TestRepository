package ch17.exam26.test;

import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

class CustomBarChart extends BarChart<String, Number> {

    public CustomBarChart(CategoryAxis xAxis, Axis<Number> yAxis) {
        super(xAxis, yAxis);

        setAnimated(false);
        setLegendVisible(true);
        setTitleSide(Side.TOP);
        setMinHeight(500);
        setMinWidth(1000);
    }

    @Override
    protected void layoutPlotChildren() {
        super.layoutPlotChildren();

        // Each individual Data element has its own bar.
        // TODO add label to each bar.
        for (Series<String, Number> series : getData()) {
            for (Data<String, Number> data : series.getData()) {
                StackPane bar = (StackPane) data.getNode();

                Text text = null;

                for (Node node : bar.getChildren()) {
                    if (node instanceof Label) {
                        text = (Text) node;
                        break;
                    }
                }

                if (text == null) {
                    text = new Text(series.getName());
                    //label.setRotate(90.0);
                    bar.getChildren().add(text);
                } else {
                    text.setText(series.getName());
                }
            }
        }
    }
}
