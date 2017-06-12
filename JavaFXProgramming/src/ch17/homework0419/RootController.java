package ch17.homework0419;

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
    private ListView<NYCFood> listView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listView.setCellFactory(new Callback<ListView<NYCFood>, ListCell<NYCFood>>() {
            @Override
            public ListCell<NYCFood> call(ListView<NYCFood> param) {
                ListCell<NYCFood> listCell = new ListCell<NYCFood>() {
                    @Override
                    protected void updateItem(NYCFood item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            return;
                        }
                        try {
                            HBox hbox = (HBox) FXMLLoader.load(getClass().getResource("item.fxml")); //item.fxml의 루트 엘리먼트를 가져온다.
                            ImageView foodImage = (ImageView) hbox.lookup("#image"); //루트 엘리먼트(루트태그안)의 내용에서 id가 image인걸 찾아 가져온다.
                            Label foodName = (Label) hbox.lookup("#name");
                            Label foodDescription = (Label) hbox.lookup("#description");

                            foodImage.setImage(new Image(getClass().getResource("images/" + item.getImage()).toString()));
                            foodName.setText(item.getName());
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
//        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<NYCFood>() {
//            @Override
//            public void changed(ObservableValue<? extends NYCFood> observable, NYCFood oldValue, NYCFood newValue) {
//                System.out.println(newValue.getName() + " : " + newValue.getScore());
//            }
//        });
        //이벤트 처리
        listView.setOnMouseClicked(e -> {
            NYCFood food = listView.getSelectionModel().getSelectedItem();
            System.out.println(food.getName());
        });

        ObservableList<NYCFood> value = FXCollections.observableArrayList();
        value.add(new NYCFood("NYCFood1.JPG", "치폴레", "멕시칸 음식"));
        value.add(new NYCFood("NYCFood2.JPG", "할랄가이즈", "길거리 할랄푸드 -> 비프지로(소고기+양고기)"));
        value.add(new NYCFood("NYCFood3.JPG", "머레이베이글", "쪽파 크림치즈/갈릭+드라이토마토 크림치즈"));
        value.add(new NYCFood("NYCFood4.JPG", "에그베네딕트1", "모르칸스타일 브런치"));
        value.add(new NYCFood("NYCFood5.JPG", "에그베네딕트2", "진짜! 정통 브런치"));
        value.add(new NYCFood("NYCFood6.JPG", "사이공마켓", "베트남 음식"));
        value.add(new NYCFood("NYCFood7.JPG", "쉐이크쉑버거", "쉐이크는 별로였당"));
        value.add(new NYCFood("NYCFood8.JPG", "파이브가이즈버거", "쉑쉑보다 맛있었던 햄버거!"));
        value.add(new NYCFood("NYCFood9.JPG", "매그놀리아 바나나푸딩", "한국에도 있지만 뉴욕이 본점. 엄청달다"));
        value.add(new NYCFood("NYCFood10.JPG", "서브웨이", "한국이랑 비교도 안되는 어마어마한 양"));
        
        listView.setItems(value); //listView안에 value(arraylist)의 값들을 차례로 넣는다.
    }

}
