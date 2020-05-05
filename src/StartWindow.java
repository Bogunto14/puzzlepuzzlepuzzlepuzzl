
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StartWindow extends Application{

    public static void main (String[] args){
        launch(args);
    }

    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));

        ImageView backgroundBlack = new ImageView(new Image(getClass().getResourceAsStream("images/background.jpg")));
        backgroundBlack.setOpacity(0.6);
        backgroundBlack.setFitHeight(800);

        Text text = new Text();
        text.setText("                  Здравствуйте! \n     Мы рады приветствовать Вас\n   в игре по обучению языку Java!");
        text.setStyle("-fx-font-size: 50; -fx-font-weight: 700; -fx-fill: white; -fx-stroke: black; -fx-stroke-width: 3");
        text.setTranslateX(50);
        text.setTranslateY(100);

        Button buttonStart = new Button("Начать");
        buttonStart.setStyle("-fx-border-color: rgb(46,49,20); -fx-font-size: 40px");
        buttonStart.setTranslateX(395);
        buttonStart.setTranslateY(280);
        buttonStart.setOnAction(e -> openTask1(primaryStage));

        ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("images/logo.jpg")));
        logo.setX(387);
        logo.setY(400);
        logo.setFitHeight(320);
        logo.setFitWidth(200);
        root.getChildren().addAll(backgroundBlack, text,buttonStart, logo);
    }

    @Override public void start(Stage primaryStage) throws Exception{
        init(primaryStage);
        primaryStage.show();
        primaryStage.setWidth(1000);
        primaryStage.setHeight(800);
    }

    public static void openTask1(Stage primaryStage) {
        Menu pp = new Menu();
        try {
            pp.start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
