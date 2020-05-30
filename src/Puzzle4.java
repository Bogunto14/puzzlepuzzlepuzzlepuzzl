import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Puzzle4 extends Application {
    private Timeline timeline;
    final List<Piece> pieces = new ArrayList<>();
    boolean buttonsAreActive=true;
    Text q = new Text();
    Text a_1 = new Text();
    Text a_2 = new Text();
    Text a_3 = new Text();
    Text a_4 = new Text();
    Button nextQuestion = new Button("Следующий вопрос");
    Text trueAnswer = new Text();
    Button b_1 = new Button("1");
    Button b_2 = new Button("2");
    Button b_3 = new Button("3");
    Button b_4 = new Button("4");

    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
        primaryStage.setX(primaryStage.getX() + primaryStage.getWidth() / 2 - primaryStage.getWidth() / 2); //dialog.getWidth() = not NaN
        primaryStage.setY(primaryStage.getY() + primaryStage.getHeight() / 2 - primaryStage.getHeight() / 2); //dialog.getHeight() = not NaN
    }

    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));

        Image image = new Image(getClass().getResourceAsStream("images/5.png"));

        int numOfColumns = 4;
        int numOfRows = 4;
        final Desk desk = new Desk(numOfColumns, numOfRows);

        for (int col = 0; col < numOfColumns; col++) {
            for (int row = 0; row < numOfRows; row++) {
                int x = col * Piece.SIZE;
                int y = row * Piece.SIZE;
                final Piece piece = new Piece(image, x, y, row > 0, col > 0,
                        row < numOfRows - 1, col < numOfColumns - 1,
                        desk.getWidth(), desk.getHeight(), true);
                pieces.add(piece);
            }
        }
        desk.getChildren().addAll(pieces);


        Text questionsText = new Text();
        questionsText.setText("Вопросы");
        questionsText.setStyle("-fx-font-size: 30px");
        questionsText.setTranslateX(30);
        questionsText.setTranslateY(730);

        Button shuffleButton = new Button("Картинку запомнил!");
        shuffleButton.setStyle("-fx-font-size: 2em;");
        shuffleButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                shuffleButton.setTranslateX(1000);
                root.getChildren().addAll(q, a_1, a_2, a_3, a_4, b_1, b_2, b_3, b_4, nextQuestion, trueAnswer);
                createQ1(primaryStage,root);

                if (timeline != null) timeline.stop();
                timeline = new Timeline();
                for (final Piece piece : pieces) {
                    piece.setActive();
                    double shuffleX = Math.random() * (desk.getWidth() - Piece.SIZE + 48f) - 24f - piece.getCorrectX();
                    double shuffleY = Math.random() * (desk.getHeight() - Piece.SIZE + 30f) - 15f - piece.getCorrectY();
                    timeline.getKeyFrames().add(
                            new KeyFrame(Duration.seconds(1),
                                    new KeyValue(piece.translateXProperty(), shuffleX),
                                    new KeyValue(piece.translateYProperty(), shuffleY)));
                }
                timeline.playFromStart();
            }
        });
        root.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                int c=0;
                for (int i = 0; i < pieces.size(); i++) {
                    if (pieces.get(i).activeOrNot==false) {
                        c++;
                    }
                }
                if (c==16) {
                    nextQuestion.setOpacity(1);
                    nextQuestion.setText("Следующий раздел");
                    nextQuestion.setOnAction(e -> {
                        createNewWindow(primaryStage);
                    });

                }
            }
        });
        HBox buttonBox = new HBox(8);
        buttonBox.getChildren().addAll(shuffleButton);
        VBox vb = new VBox(10);
        vb.setTranslateX(20);
        vb.setTranslateY(20);
        vb.getChildren().addAll(desk, buttonBox);

        Button buttonMenu = new Button("Выйти в меню");
        buttonMenu.setTranslateX(700);
        buttonMenu.setTranslateY(600);
        buttonMenu.setStyle("-fx-border-color: rgb(46,49,20); -fx-font-size: 20px");
        buttonMenu.setOnAction(e -> {
            Menu pp = new Menu();
            try {
                pp.start(primaryStage);
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        });

        root.getChildren().addAll(vb, buttonMenu);
    }

    private void createQ(Stage primaryStage,Group root, int now, String qStr,
                         String a1Str, String a2Str, String a3Str, String a4Str, int trueAns) {
        buttonsAreActive = true;

        q.setText(qStr);
        q.setStyle("-fx-font-size: 20px");
        q.setTranslateX(50);
        q.setTranslateY(470);

        a_1.setText(a1Str);
        a_1.setStyle("-fx-font-size: 20px");
        a_1.setTranslateX(50);
        a_1.setTranslateY(510);

        a_2.setText(a2Str);
        a_2.setStyle("-fx-font-size: 20px");
        a_2.setTranslateX(50);
        a_2.setTranslateY(550);

        a_3.setText(a3Str);
        a_3.setStyle("-fx-font-size: 20px");
        a_3.setTranslateX(50);
        a_3.setTranslateY(590);

        a_4.setText(a4Str);
        a_4.setStyle("-fx-font-size: 20px");
        a_4.setTranslateX(50);
        a_4.setTranslateY(630);

        nextQuestion.setTranslateY(650);
        nextQuestion.setTranslateX(1500);
        nextQuestion.setStyle("-fx-border-color: rgb(46,49,20); -fx-font-size: 25px");
        nextQuestion.setOnAction(e -> {
            if (now==1) createQ2(primaryStage,root);
            if (now==2) createQ3(primaryStage,root);
            if (now==3) createQ4(primaryStage,root);
            if (now==4) createQ5(primaryStage,root);
            if (now==5) createQ6(primaryStage,root);
            if (now==6) createQ7(primaryStage,root);
            if (now==7) createQ8(primaryStage,root);
            if (now==8) createQ9(primaryStage,root);
            if (now==9) createQ10(primaryStage,root);
            if (now==10) createQ11(primaryStage,root);
            if (now==11) createQ12(primaryStage,root);
            if (now==12) createQ13(primaryStage,root);
            if (now==13) createQ14(primaryStage,root);
            if (now==14) createQ15(primaryStage,root);
            if (now==15) createQ16(primaryStage,root);
            if (now==16) createNewWindow(primaryStage);
        });
        if (now==16) {
            int c=0;
            for (int i = 0; i < pieces.size(); i++) {
                if (pieces.get(i).activeOrNot==false) {
                    c++;
                }
            }
            if (c==16) {
                nextQuestion.setOpacity(1);
                nextQuestion.setText("Следующий раздел");
                nextQuestion.setOnAction(e -> {
                    createNewWindow(primaryStage);
                });

            }
            else {nextQuestion.setOpacity(0);}
        }

        trueAnswer.setText("Неверно! \nПравильный ответ - 1!");
        trueAnswer.setStyle("-fx-font-size: 30px");
        trueAnswer.setTranslateX(600);
        trueAnswer.setTranslateY(550);
        trueAnswer.setOpacity(0);


        b_1.setTranslateX(50);
        b_1.setTranslateY(650);
        b_1.setStyle("-fx-border-color: rgb(46,49,20); -fx-font-size: 20px");
        b_1.setOnAction(e -> {
            if (buttonsAreActive) {
                nextQuestion.setTranslateX(700);
                trueAnswer.setOpacity(1);
                if (trueAns == 1) {
                    trueAnswer.setText("Верно! \nМолодец!");
                    bonus();
                }
                if (trueAns == 2) trueAnswer.setText("Неверно! \nПравильный ответ - 2!");
                if (trueAns == 3) trueAnswer.setText("Неверно! \nПравильный ответ - 3!");
                if (trueAns == 4) trueAnswer.setText("Неверно! \nПравильный ответ - 4!");

                b_1.setStyle("-fx-border-color: rgb(46,49,20); -fx-font-size: 20px; -fx-background-color: gray");
                b_2.setStyle("-fx-border-color: rgb(46,49,20); -fx-font-size: 20px; -fx-background-color: gray");
                b_3.setStyle("-fx-border-color: rgb(46,49,20); -fx-font-size: 20px; -fx-background-color: gray");
                b_4.setStyle("-fx-border-color: rgb(46,49,20); -fx-font-size: 20px; -fx-background-color: gray");
                buttonsAreActive=false;
            }

        });


        b_2.setTranslateX(150);
        b_2.setTranslateY(650);
        b_2.setStyle("-fx-border-color: rgb(46,49,20); -fx-font-size: 20px");
        b_2.setOnAction(e -> {
            if (buttonsAreActive) {
                nextQuestion.setTranslateX(700);
                trueAnswer.setOpacity(1);
                if (trueAns==1) trueAnswer.setText("Неверно! \nПравильный ответ - 1!");
                if (trueAns==2) {
                    trueAnswer.setText("Верно! \nМолодец!");
                    bonus();
                }
                if (trueAns==3) trueAnswer.setText("Неверно! \nПравильный ответ - 3!");
                if (trueAns==4) trueAnswer.setText("Неверно! \nПравильный ответ - 4!");

                b_1.setStyle("-fx-border-color: rgb(46,49,20); -fx-font-size: 20px; -fx-background-color: gray");
                b_2.setStyle("-fx-border-color: rgb(46,49,20); -fx-font-size: 20px; -fx-background-color: gray");
                b_3.setStyle("-fx-border-color: rgb(46,49,20); -fx-font-size: 20px; -fx-background-color: gray");
                b_4.setStyle("-fx-border-color: rgb(46,49,20); -fx-font-size: 20px; -fx-background-color: gray");
                buttonsAreActive=false;
            }
        });


        b_3.setTranslateX(250);
        b_3.setTranslateY(650);
        b_3.setStyle("-fx-border-color: rgb(46,49,20); -fx-font-size: 20px");
        b_3.setOnAction(e -> {
            if (buttonsAreActive) {
                nextQuestion.setTranslateX(700);
                trueAnswer.setOpacity(1);
                if (trueAns == 1) trueAnswer.setText("Неверно! \nПравильный ответ - 1!");
                if (trueAns == 2) trueAnswer.setText("Неверно! \nПравильный ответ - 2!");
                if (trueAns == 3) {
                    trueAnswer.setText("Верно! \nМолодец!");

                    bonus();
                }
                if (trueAns == 4) trueAnswer.setText("Неверно! \nПравильный ответ - 4!");

                b_1.setStyle("-fx-border-color: rgb(46,49,20); -fx-font-size: 20px; -fx-background-color: gray");
                b_2.setStyle("-fx-border-color: rgb(46,49,20); -fx-font-size: 20px; -fx-background-color: gray");
                b_3.setStyle("-fx-border-color: rgb(46,49,20); -fx-font-size: 20px; -fx-background-color: gray");
                b_4.setStyle("-fx-border-color: rgb(46,49,20); -fx-font-size: 20px; -fx-background-color: gray");
                buttonsAreActive=false;
            }
        });


        b_4.setTranslateX(350);
        b_4.setTranslateY(650);
        b_4.setStyle("-fx-border-color: rgb(46,49,20); -fx-font-size: 20px");
        b_4.setOnAction(e -> {
            if (buttonsAreActive) {
                nextQuestion.setTranslateX(700);
                trueAnswer.setOpacity(1);
                if (trueAns == 1) trueAnswer.setText("Неверно! \nПравильный ответ - 1!");
                if (trueAns == 2) trueAnswer.setText("Неверно! \nПравильный ответ - 2!");
                if (trueAns == 3) trueAnswer.setText("Неверно! \nПравильный ответ - 3!");
                if (trueAns == 4) {
                    trueAnswer.setText("Верно! \nМолодец!");
                    bonus();
                }

                b_1.setStyle("-fx-border-color: rgb(46,49,20); -fx-font-size: 20px; -fx-background-color: gray");
                b_2.setStyle("-fx-border-color: rgb(46,49,20); -fx-font-size: 20px; -fx-background-color: gray");
                b_3.setStyle("-fx-border-color: rgb(46,49,20); -fx-font-size: 20px; -fx-background-color: gray");
                b_4.setStyle("-fx-border-color: rgb(46,49,20); -fx-font-size: 20px; -fx-background-color: gray");
                buttonsAreActive = false;
            }
        });

    }

    private void bonus() {
        boolean made=false;
        for (Piece piece : pieces) {
            if (piece.activeOrNot && !made) {
                piece.setTranslateX(0);
                piece.setTranslateY(0);
                piece.activeOrNot = false;
                made = true;
            }
        }
    }

    private void createQ1(Stage primaryStage,Group root) {
        createQ(primaryStage,root, 1, "1. Что определяет класс?",
                "1) значения и атрибуты",
                "2) значения и поведение",
                "3) поведение и атрибуты",
                "4) все ответы неверны ", 3);
    }

    private void createQ2(Stage primaryStage,Group root) {
        createQ(primaryStage,root, 2, "2. Сколько раз можно вызвать метод?",
                "1) один",
                "2) сколько угодно раз",
                "3) два",
                "4) не больше 5", 2);
    }

    private void createQ3(Stage primaryStage,Group root) {
        createQ(primaryStage,root, 3, "3. Ключевое слово void означает, что ...",
                "1) метод не возвращает значение",
                "2) метод возвращает значение",
                "3) метод будет статическим",
                "4) все ответы неверны", 1);
    }

    private void createQ4(Stage primaryStage,Group root) {
        createQ(primaryStage,root, 4, "4. Сколько атрибутов и методов вы можете определить?",
                "1) не больше двух",
                "2) один",
                "3) сколько угодно ",
                "4) все ответы неверны", 3);
    }
    private void createQ5(Stage primaryStage,Group root) {
        createQ(primaryStage,root, 5, "5. В каком варианте класс определен верно?",
                "1) void program(){} ",
                "2) class Program{} ",
                "3) int program",
                "4) String program", 2);
    }

    private void createQ6(Stage primaryStage,Group root) {
        createQ(primaryStage,root, 6, "6. Что является модификатором доступа?",
                "1) public",
                "2) private",
                "3) protected",
                "4) все ответы правильные", 4);
    }

    private void createQ7(Stage primaryStage,Group root) {
        createQ(primaryStage,root, 7, "7. Какой уровень доступа имеет модификатор private?",
                "1) доступ может быть получен только изнутри объявленного класса",
                "2) доступ может быть получен из любого класса ",
                "3) все ответы неверны",
                "4) доступ может быть получен для любого класса в том пакете ", 1);
    }

    private void createQ8(Stage primaryStage,Group root) {
        createQ(primaryStage,root, 8, "8. Какой уровень доступа имеет модификатор public?",
                "1) доступ может быть получен только изнутри объявленного класса",
                "2) доступ может быть получен из любого класса ",
                "3) все ответы неверны",
                "4) доступ может быть получен для любого класса в том пакете ", 2);
    }

    private void createQ9(Stage primaryStage,Group root) {
        createQ(primaryStage,root, 9, "9. Какое ключевое слово используется для возвращения значения?",
                "1) void",
                "2) static",
                "3) return",
                "4) show", 3);
    }

    private void createQ10(Stage primaryStage,Group root) {
        createQ(primaryStage,root, 10, "10. Сколько классов может создать пользователь?",
                "1) один",
                "2) ноль",
                "3) сколько угодно",
                "4) не больше двух", 3);
    }

    private void createQ11(Stage primaryStage,Group root) {
        createQ(primaryStage,root, 11, "11. Можно ли создать класс с названием Red apple",
                "1) да, можно",
                "2) нет, нельзя",
                "3) можно, если класс будет являться статическим",
                "4) зависит от ситуации ", 2);
    }

    private void createQ12(Stage primaryStage,Group root) {
        createQ(primaryStage,root, 12, "12. Можно ли создать класс внутри класса?",
                "1) да",
                "2) нет",
                "3) можно, если класс будет являться статическим",
                "4) можно, но обязательно несколько классов", 1);
    }

    private void createQ13(Stage primaryStage,Group root) {
        createQ(primaryStage,root, 13, "13. Что такое вложенный класс?",
                "1) статический класс,",
                "2) класс, вложенный в пакет",
                "3) класс, созданный внутри другого класса",
                "4) все ответы неверны", 3);
    }

    private void createQ14(Stage primaryStage,Group root) {
        createQ(primaryStage,root, 14, "14. Какое слово пропущено при создании класса: ...Person{}?",
                "1) new",
                "2) double",
                "3) int",
                "4) class", 4);
    }
    private void createQ15(Stage primaryStage,Group root) {
        createQ(primaryStage,root, 15, "15. Какой уровень доступа имеет модификатор protected?",
                "1) доступ может быть получен только изнутри объявленного класса",
                "2) доступ может быть получен из любого класса ",
                "3) все ответы неверны",
                "4) доступ может быть получен для любого класса в том пакете ", 4);
    }

    private void createQ16(Stage primaryStage,Group root) {
        createQ(primaryStage,root, 16, "Какое ключевое слово служит для создания статического класса?",
                "1) void",
                "2) class",
                "3) statistics",
                "4) static", 4);
    }

    private void createNewWindow(Stage primaryStage) {
        Menu pp = new Menu();

        try {
            pp.start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

