package ch17.exam20;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    private ListView<Phone> listView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listView.setCellFactory(new Callback<ListView<Phone>, ListCell<Phone>>() {
            @Override
            public ListCell<Phone> call(ListView<Phone> param) { //listview에 phone이라는 객체가 제공될 때 메소드 자동실행 -> 1개당 1번실행 (cell 리턴)-> 10개의 ListCell 생성
                ListCell<Phone> listCell = new ListCell<Phone>() {
                    @Override
                    protected void updateItem(Phone item, boolean empty) { //cell안에 뭐가 들어가는지 정의하는 메소드       
                        super.updateItem(item, empty); //그래픽적인, 이벤트 관련된 코드는 부모 메소드에 있기 때문에 부모 메소드에도 매개값을 넘겨줘야한다.
                        if (empty) {    //가장 처음엔 empty가 true인 상태로 수행되고, 그 이후에 차례로 값을 받아오기 때문에 예외처리를 해야한다.
                            return;
                        }
                        try {
                            //Cell에 들어갈 컨테이너 생성
                            HBox hbox = (HBox) FXMLLoader.load(getClass().getResource("item.fxml"));
                            ImageView phoneImage = (ImageView) hbox.lookup("#image"); //id로 참조할때는 id앞에 #을 붙인다
                            Label phoneName = (Label) hbox.lookup("#name");
                            Label phoneContent = (Label) hbox.lookup("#content");

                            phoneImage.setImage(new Image(getClass().getResource("images/" + item.getImageName()).toString()));
                            phoneName.setText(item.getName());
                            phoneContent.setText(item.getContent());
                            //Cell의 내용으로 설정
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
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Phone>() {
            @Override
            public void changed(ObservableValue<? extends Phone> observable, Phone oldValue, Phone newValue) {
                System.out.println(newValue.getName() + ": " + newValue.getImageName());
            }

        });

        //데이터 세팅
        ObservableList<Phone> value = FXCollections.observableArrayList();
        value.add(new Phone("phone01.png", "갤럭시S1", "삼성스마트폰의 최초 모델입니다."));
        value.add(new Phone("phone02.png", "갤럭시S2", "제가 스무살 때 썼던 모델입니다. 호호"));
        value.add(new Phone("phone03.png", "갤럭시S3", "이건 누가 썼던거지?"));
        listView.setItems(value);
    }

}
