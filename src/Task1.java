
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Task1 extends Application{

    public static void main (String[] args){
        launch(args);
    }

    @Override public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        primaryStage.setScene(new Scene(root));

        ImageView backgroundBlack = new ImageView(new Image(getClass().getResourceAsStream("images/6.jpg")));

        Text text = new Text();
        text.setText("Это первый урок по переменным в языке Java. Приветствую);\n" +
                "Переменные представляют собой ячейки памяти в которые ты можешь закинуть разные значения в \n" +
                "зависимости от типа переменных. Основыных всего их 5: int - целое число, double -число с плавающей \n" +
                "точкой или дробь, void - это специальный тип данных, пустота, boolean - логический тип, значения true \n" +
                "или false, да или нет, char- символьный тип и String - строка\n");
        text.setTranslateX(200);
        text.setTranslateY(200);

        Button buttonStart = new Button("Запомнил!");
        buttonStart.setTranslateX(380);
        buttonStart.setTranslateY(300);
        buttonStart.setOnAction(e -> startPuzzle(primaryStage));

        root.getChildren().addAll(backgroundBlack,text,buttonStart);

    }

    public static void startPuzzle(Stage primaryStage) {
        puzzlepie pp = new puzzlepie();
        try {
            pp.start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
