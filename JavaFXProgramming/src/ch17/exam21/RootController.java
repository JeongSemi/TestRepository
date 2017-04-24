package ch17.exam21;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

public class RootController implements Initializable {

    @FXML
    private ListView<Food> listView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listView.setCellFactory(new Callback<ListView<Food>, ListCell<Food>>() {
            @Override
            public ListCell<Food> call(ListView<Food> param) {
                ListCell<Food> listCell = new ListCell<Food>() {
                    @Override
                    protected void updateItem(Food item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            return;
                        }
                        try {
                            HBox hbox = (HBox) FXMLLoader.load(getClass().getResource("item.fxml")); //item.fxml의 루트 엘리먼트를 가져온다.
                            ImageView foodImage = (ImageView) hbox.lookup("#image"); //루트 엘리먼트(루트태그안)의 내용에서 id가 image인걸 찾아 가져온다.
                            Label foodName = (Label) hbox.lookup("#name");
                            ImageView scoreImage = (ImageView) hbox.lookup("#score");
                            Label foodDescription = (Label) hbox.lookup("#description");

                            foodImage.setImage(new Image(getClass().getResource("images/" + item.getImage()).toString()));
                            foodName.setText(item.getName());
                            scoreImage.setImage(new Image(getClass().getResource("images/star" + item.getScore() + ".png").toString()));
                            foodDescription.setText(item.getDescription());

                            setGraphic(hbox);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                };
                return listCell;
            }
        });

        //선택 속성 감시
//        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Food>() {
//            @Override
//            public void changed(ObservableValue<? extends Food> observable, Food oldValue, Food newValue) {
//                System.out.println(newValue.getName() + " : " + newValue.getScore());
//            }
//        });
        //이벤트 처리
        listView.setOnMouseClicked(e -> {
           Food food = listView.getSelectionModel().getSelectedItem();
           System.out.println(food.getName());
        });

        ObservableList<Food> value = FXCollections.observableArrayList();
        value.add(new Food("food01.png", "삼겹살", 10, "세상에서 제일 맛있음"));
        value.add(new Food("food02.png", "장어양념구이", 7, "넘나 맛있음"));
        value.add(new Food("food03.png", "장어소금구이", 9, "넘나 담백함"));
        value.add(new Food("food04.png", "육회비빔밥", 10, "육회사랑합니다"));
        value.add(new Food("food05.png", "새우볶음밥", 6, "새우좋아함"));
        value.add(new Food("food06.jpg", "떡볶이", 3, "딱히 찾아먹지않음"));
        listView.setItems(value); //listView안에 value(arraylist)의 값들을 차례로 넣는다.
    }

}
