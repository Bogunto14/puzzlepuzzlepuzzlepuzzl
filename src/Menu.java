
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Menu extends Application{

    public static Boolean[] isLevelOpened = new Boolean[] {true,false,false, false, false};


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
        level1.setTranslateX(50);
        level1.setTranslateY(140);
        level1.setStyle("-fx-border-color: green; -fx-font-size: 40px");
        level1.setOnAction(e -> openLevel1(primaryStage));
        Text text1 = new Text();
        text1.setText("Практики");
        text1.setStyle("-fx-font-size: 50; -fx-font-weight: 700; -fx-fill: white; -fx-stroke: black; -fx-stroke-width: 1");
        text1.setTranslateX(150);
        text1.setTranslateY(200);

        Button level2 = new Button("2");
        level2.setTranslateX(50);
        level2.setTranslateY(240);
        if (isLevelOpened[1]==true) {
            level2.setStyle("-fx-border-color: green; -fx-font-size: 40px");
            level2.setOnAction(e -> openLevel2(primaryStage));
        }
        else {
            level2.setStyle("-fx-border-color: green; -fx-font-size: 40px; -fx-background-color: gray");
        }
        Text text2 = new Text();
        text2.setText("Переменные");
        text2.setStyle("-fx-font-size: 50; -fx-font-weight: 700; -fx-fill: white; -fx-stroke: black; -fx-stroke-width: 1");
        text2.setTranslateX(150);
        text2.setTranslateY(300);

        Button level3 = new Button("3");
        level3.setTranslateX(50);
        level3.setTranslateY(340);
        if (isLevelOpened[2]==true) {

            level3.setStyle("-fx-border-color: green; -fx-font-size: 40px");
            level3.setOnAction(e -> openLevel3(primaryStage));
        }
        else {
            level3.setStyle("-fx-border-color: green; -fx-font-size: 40px; -fx-background-color: gray");
        }
        Text text3 = new Text();
        text3.setText("Циклы");
        text3.setStyle("-fx-font-size: 50; -fx-font-weight: 700; -fx-fill: white; -fx-stroke: black; -fx-stroke-width: 1");
        text3.setTranslateX(150);
        text3.setTranslateY(400);

        Button level4 = new Button("4");
        level4.setTranslateX(50);
        level4.setTranslateY(440);
        if (isLevelOpened[3]==true) {

            level4.setStyle("-fx-border-color: green; -fx-font-size: 40px");
            level4.setOnAction(e -> openLevel4(primaryStage));
        }
        else {
            level4.setStyle("-fx-border-color: green; -fx-font-size: 40px; -fx-background-color: gray");
        }
        Text text4 = new Text();
        text4.setText("Функции");
        text4.setStyle("-fx-font-size: 50; -fx-font-weight: 700; -fx-fill: white; -fx-stroke: black; -fx-stroke-width: 1");
        text4.setTranslateX(150);
        text4.setTranslateY(500);

        Button level5 = new Button("5");
        level5.setTranslateX(50);
        level5.setTranslateY(540);
        if (isLevelOpened[4]==true) {

            level5.setStyle("-fx-border-color: green; -fx-font-size: 40px");
            level5.setOnAction(e -> openLevel5(primaryStage));
        }
        else {
            level5.setStyle("-fx-border-color: green; -fx-font-size: 40px; -fx-background-color: gray");
        }
        Text text5 = new Text();
        text5.setText("Классы");
        text5.setStyle("-fx-font-size: 50; -fx-font-weight: 700; -fx-fill: white; -fx-stroke: black; -fx-stroke-width: 1");
        text5.setTranslateX(150);
        text5.setTranslateY(600);



        root.getChildren().addAll(backgroundBlack, text,bb,level1,level2,level3,level4,level5,text1,text2,text3,text4,text5);
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
    public static void openLevel4(Stage primaryStage) {
        Task4 pp = new Task4();
        try {
            pp.start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void openLevel5(Stage primaryStage) {
        Task5 pp = new Task5();
        try {
            pp.start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

