
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

        ImageView backgroundBlack = new ImageView(new Image(getClass().getResourceAsStream("images/6.jpg")));

        Text text = new Text();
        text.setText("Здравствуйте! Мы рады приветствовать Вас в игре по обучению языку Java!");
        text.setTranslateX(200);
        text.setTranslateY(200);

        Button buttonStart = new Button("Начать");
        buttonStart.setTranslateX(380);
        buttonStart.setTranslateY(400);
        buttonStart.setOnAction(e -> openTask1(primaryStage));

        root.getChildren().addAll(backgroundBlack, text,buttonStart);
    }

    @Override public void start(Stage primaryStage) throws Exception{
        init(primaryStage);
        primaryStage.show();
        primaryStage.setWidth(1000);
        primaryStage.setHeight(800);
    }

    public static void openTask1(Stage primaryStage) {
        Task1 pp = new Task1();
        try {
            pp.start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
