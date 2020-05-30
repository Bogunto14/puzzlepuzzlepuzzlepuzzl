
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Task2 extends Application{

    public static void main (String[] args){
        launch(args);
    }

    @Override public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        primaryStage.setScene(new Scene(root));

        Text text = new Text();
        text.setText("Как правило расчёт результата функции предполагает реализацию некоторой последовательности \n" +
                "вычислений — алгоритма. Для сохранения результатов промежуточных вычислений программисты\n" +
                "придумали переменные. В Java типов переменных 8: \n" +
                "byte (целые числа, 1 байт)\n" +
                "short (целые числа, 2 байта)\n" +
                "int (целые числа, 4 байта)\n" +
                "long (целые числа, 8 байтов)\n" +
                "float (вещественные числа, 4 байта)\n" +
                "double (вещественные числа, 8 байтов)\n" +
                "char (символ Unicode, 2 байта)\n" +
                "boolean (значение истина/ложь, 1 байт)\n" +
                "Чтобы создать переменную необходимо написать ее тип и название, например \"int x;\" \n" +
                "Или можно создать сразу несколько переменных одного типа: \"int x, y, z\"\n" +
                "Также можно сразу назначить ей значение, это будет выглядеть так: \"int x = 0;\"\n" +
                "Имя переменной должно начинаться с буквы (маленькой) и состоять из букв (Unicode) цифр и символа подчеркивания «_». \n" +
                "Технически возможно начать имя переменной также с «$» или «_», однако это запрещено соглашением по оформлению кода \n" +
                "в Java (Java Code Conventions). Кроме того, символ доллара «$», по соглашению, никогда не используется вообще. \n" +
                "В соответствии с соглашением имя переменной должно начинаться именно с маленькой буквы (с заглавной буквы начинаются \n" +
                "имена классов). Пробелы при именовании переменных не допускаются.\n" +
                "Имя переменной не должно быть ключевым или зарезервированным словом языка Java.\n" +
                "Имя переменной чувствительно к регистру. newVariable и newvariable — разные имена.\n" +
                "При выборе имени переменных, следует использовать полные слова вместо загадочных аббревиатур. Это сделает ваш код \n" +
                "более удобным для чтения и понимания. Во многих случаях это также сделает ваш код самодокументируемым.\n" +
                "Если выбранное вами имя переменной состоит только из одного слова — запишите его маленькими буквами. Если оно состоит \n" +
                "из более чем одного слова, то отделяйте каждое последующее слово в имени переменной заглавной буквой. \n" +
                "Например: superCounter, myDomesticAnimal");
        text.setTranslateX(50);
        text.setTranslateY(50);

        Button buttonStart = new Button("Запомнил!");
        buttonStart.setTranslateX(380);
        buttonStart.setTranslateY(600);
        buttonStart.setOnAction(e -> startPuzzle(primaryStage));

        root.getChildren().addAll(text,buttonStart);

    }

    public static void startPuzzle(Stage primaryStage) {
        Puzzle2 pp = new Puzzle2();
        try {
            pp.start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}