import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Task5 extends Application{

    public static void main (String[] args){
        launch(args);
    }

    @Override public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        primaryStage.setScene(new Scene(root));

        Text text = new Text();
        text.setText("Шаблоном или описанием объекта является класс, а объект представляет экземпляр этого класса. \n" +
                "Вы можете использовать один и тот же класс в качестве проекта для создания множества объектов.\n" +
                "Каждый класс имеет имя, которое используется для определения поведения и атрибутов. \n" +
                "Методы определяют поведение. Метод является коллекцией выражений, сгруппированных вместе вместе \n" +
                "для выполнения действия. Например, методом явлется System.out.println(). Метод можно вызвать любое\n" +
                "количество раз.\n" +
                "Ключевое слово return может быть использовано в методах для возвращения значения.\n" +
                "Класс определяется с помощью ключевого слова сlass и должен состоять из единого слова(FirstProgram):\n"+
                "class Person{}\n" +
                "В данном случае класс называется Person. После названия класса идут фигурные скобки, между которыми\n" +
                "помещается тело класса - то есть его поля и методы. юбой объект может обладать двумя основными\n" +
                "характеристиками: атрибуты - некоторые данные, которые хранит объект, и поведение - действия,\n" +
                "которые может совершать объект. Вы можете определить сколько угодно атрибутов и методов. \n" +
                "Теперь поговорим о модификаторах доступа. Модификаторы доступа — это ключевые слова, которые\n" +
                "регулируют уровень доступа к разным частям кода. \n" +
                "Всего в Java есть четыре модификатора доступа. Перечислим их в порядке от самых строгих до самых\n" +
                " «мягких»:\n" +
                "    private;\n" +
                "    default (package visible);\n" +
                "    protected;\n" +
                "    public. \n" +
                "Private — наиболее строгий модификатор доступа. Он ограничивает видимость данных и методов\n " +
                "пределами одного класса.\n" +
                "Default (package visible) - доступ используется в пакете, где есть какие-то классы-утилиты,\n" +
                "не реализующие функциональность всех остальных классов в этом пакете \n" +
                "Protected - в пределах всех классов, находящихся в том же пакете, что и наш, а также\n" +
                "в пределах всех классов-наследников нашего класса. \n" +
                "Public - доступ может быть получен из любого класса. \n" +
                "Если вы объявляете переменную или метод с ключевым словом static, то они будут принадлежать \n" +
                "классу, а не какому-либо экземпляру. Это значит, что будет существовать только один экземпляр \n" +
                "static, даже если вы создадите множество объектов класса, или не создадите ни одного. Он будет \n" +
                "разделен всеми объектами. Это значит, что обращаться к статическому методу или полю можно \n" +
                "используя имя класса\n" +
                "Java позволяет создавать одни классы внутри других. Такие классы называют вложенными.\n");
        text.setTranslateX(50);
        text.setTranslateY(50);

        Button buttonStart = new Button("Запомнил!");
        buttonStart.setTranslateX(380);
        buttonStart.setTranslateY(600);
        buttonStart.setOnAction(e -> startPuzzle(primaryStage));

        root.getChildren().addAll(text,buttonStart);

    }

    public static void startPuzzle(Stage primaryStage) {
        Puzzle5 pp = new Puzzle5();
        try {
            pp.start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}