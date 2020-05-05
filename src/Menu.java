
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Menu extends Application{

    Boolean[] isLevelOpened = new Boolean[] {true,false,false};


    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));

        ImageView backgroundBlack = new ImageView(new Image(getClass().getResourceAsStream("images/background.jpg")));
        backgroundBlack.setOpacity(0.3);
        backgroundBlack.setFitHeight(800);

        Text text = new Text();
        text.setText("Выберите уровень");
        text.setStyle("-fx-font-size: 50; -fx-font-weight: 700; -fx-fill: white; -fx-stroke: black; -fx-stroke-width: 3");
        text.setTranslateX(50);
        text.setTranslateY(100);

        //костыль
        Button bb = new Button("1");
        bb.setTranslateX(-4000);

        Button level1 = new Button("1");
        level1.setTranslateX(300);
        level1.setTranslateY(280);
        level1.setStyle("-fx-border-color: green; -fx-font-size: 40px");
        level1.setOnAction(e -> openLevel1(primaryStage));

        Button level2 = new Button("2");
        level2.setTranslateX(450);
        level2.setTranslateY(280);
        if (isLevelOpened[1]==true) {
            level2.setStyle("-fx-border-color: green; -fx-font-size: 40px");
            level2.setOnAction(e -> openLevel2(primaryStage));
        }
        else {
            level2.setStyle("-fx-border-color: green; -fx-font-size: 40px; -fx-background-color: gray");
        }
        Button level3 = new Button("3");
        level3.setTranslateX(550);
        level3.setTranslateY(280);
        if (isLevelOpened[2]==true) {

            level3.setStyle("-fx-border-color: green; -fx-font-size: 40px");
            level3.setOnAction(e -> openLevel3(primaryStage));
        }
        else {
            level3.setStyle("-fx-border-color: green; -fx-font-size: 40px; -fx-background-color: gray");
        }

        root.getChildren().addAll(backgroundBlack, text,bb,level1,level2,level3);
    }

    @Override public void start(Stage primaryStage) throws Exception{
        init(primaryStage);
        primaryStage.show();
        primaryStage.setWidth(1000);
        primaryStage.setHeight(800);
    }

    public static void openLevel1(Stage primaryStage) {
        Task1 pp = new Task1();
        try {
            pp.start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void openLevel2(Stage primaryStage) {
        Task2 pp = new Task2();
        try {
            pp.start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void openLevel3(Stage primaryStage) {
        Task3 pp = new Task3();
        try {
            pp.start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

