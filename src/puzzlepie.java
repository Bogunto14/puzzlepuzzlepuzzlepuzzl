import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class puzzlepie extends Application {
    private Timeline timeline;

    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));
        //load puzzle image
        Image image = new Image(getClass().getResourceAsStream("images/5.jpg"));
        ImageView backgroundBlack = new ImageView(new Image(getClass().getResourceAsStream("images/6.jpg")));
        int numOfColumns = 4;
        int numOfRows = 4;
        //create desk
        final Desk desk = new Desk(numOfColumns, numOfRows);
        //create puzzle pieces
        final List<Piece> pieces = new ArrayList<>();
        for (int col = 0; col < numOfColumns; col++) {
            for (int row = 0; row < numOfRows; row++) {
                int x = col * Piece.SIZE;
                int y = row * Piece.SIZE;
                final Piece piece = new Piece(image, x, y, row > 0, col > 0,
                        row < numOfRows - 1, col < numOfColumns - 1,
                        desk.getWidth(), desk.getHeight());
                pieces.add(piece);
            }
        }
        desk.getChildren().addAll(pieces);







        /*вопрос первый*/

        Text q1 = new Text();
        q1.setText("Для чего нужны переменные?");
        q1.setStyle("-fx-font-size: 30px");
        q1.setTranslateX(50);
        q1.setTranslateY(470);

        Text a1_1 = new Text();
        a1_1.setText("1 Чтобы были");
        a1_1.setStyle("-fx-font-size: 20px");
        a1_1.setTranslateX(50);
        a1_1.setTranslateY(510);

        Text a1_2 = new Text();
        a1_2.setText("2 Чтобы были");
        a1_2.setStyle("-fx-font-size: 20px");
        a1_2.setTranslateX(50);
        a1_2.setTranslateY(550);

        Text a1_3 = new Text();
        a1_3.setText("3 Чтобы были");
        a1_3.setStyle("-fx-font-size: 20px");
        a1_3.setTranslateX(50);
        a1_3.setTranslateY(590);

        Text a1_4 = new Text();
        a1_4.setText("4 Чтобы были");
        a1_4.setStyle("-fx-font-size: 20px");
        a1_4.setTranslateX(50);
        a1_4.setTranslateY(630);

        Button nextQuestion1 = new Button("Следующий вопрос");
        nextQuestion1.setTranslateX(1500);
        nextQuestion1.setStyle("-fx-border-color: rgb(46,49,20); -fx-font-size: 25px");
        nextQuestion1.setOnAction(e -> {

        });

        Button b1_1 = new Button("1");
        b1_1.setTranslateX(50);
        b1_1.setTranslateY(650);
        b1_1.setStyle("-fx-border-color: rgb(46,49,20); -fx-font-size: 40px");
        b1_1.setOnAction(e -> {
            Text falseAnswer = new Text();
            falseAnswer.setText("Неверно! \n Правильный ответ - 3!");
            falseAnswer.setStyle("-fx-font-size: 30px");
            falseAnswer.setTranslateX(400);
            falseAnswer.setTranslateY(550);

            nextQuestion1.setTranslateX(-1500);
            nextQuestion1.setTranslateX(600);
            nextQuestion1.setTranslateY(650);
            root.getChildren().addAll(nextQuestion1);

            root.getChildren().addAll(falseAnswer);
        });

        Button b1_2 = new Button("2");
        b1_2.setTranslateX(150);
        b1_2.setTranslateY(650);
        b1_2.setStyle("-fx-border-color: rgb(46,49,20); -fx-font-size: 40px");
        b1_2.setOnAction(e -> {
            Text falseAnswer = new Text();
            falseAnswer.setText("Неверно! \n Правильный ответ - 3!");
            falseAnswer.setStyle("-fx-font-size: 30px");
            falseAnswer.setTranslateX(400);
            falseAnswer.setTranslateY(550);

            nextQuestion1.setTranslateX(-1500);
            nextQuestion1.setTranslateX(600);
            nextQuestion1.setTranslateY(650);
            root.getChildren().addAll(nextQuestion1);

            root.getChildren().addAll(falseAnswer);
        });

        Button b1_3 = new Button("3");
        b1_3.setTranslateX(250);
        b1_3.setTranslateY(650);
        b1_3.setStyle("-fx-border-color: rgb(46,49,20); -fx-font-size: 40px");
        b1_3.setOnAction(e -> {
            Text falseAnswer = new Text();
            falseAnswer.setText("Верно! Молодец!");
            falseAnswer.setStyle("-fx-font-size: 30px");
            falseAnswer.setTranslateX(400);
            falseAnswer.setTranslateY(550);

            nextQuestion1.setTranslateX(-1500);
            nextQuestion1.setTranslateX(600);
            nextQuestion1.setTranslateY(650);
            root.getChildren().addAll(nextQuestion1);

            root.getChildren().addAll(falseAnswer);
        });

        Button b1_4 = new Button("4");
        b1_4.setTranslateX(350);
        b1_4.setTranslateY(650);
        b1_4.setStyle("-fx-border-color: rgb(46,49,20); -fx-font-size: 40px");
        b1_4.setOnAction(e -> {
            Text falseAnswer = new Text();
            falseAnswer.setText("Неверно! \n Правильный ответ - 3!");
            falseAnswer.setStyle("-fx-font-size: 30px");
            falseAnswer.setTranslateX(400);
            falseAnswer.setTranslateY(550);

            nextQuestion1.setTranslateX(-1500);
            nextQuestion1.setTranslateX(600);
            nextQuestion1.setTranslateY(650);
            root.getChildren().addAll(nextQuestion1);

            root.getChildren().addAll(falseAnswer);
        });







        //create button box
        Button shuffleButton = new Button("Картинку запомнил!");
        shuffleButton.setStyle("-fx-font-size: 2em;");
        shuffleButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                shuffleButton.setTranslateX(1000);
                root.getChildren().addAll(q1, a1_1, a1_2, a1_3, a1_4, b1_1, b1_2, b1_3, b1_4);

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

        HBox buttonBox = new HBox(8);
        buttonBox.getChildren().addAll(shuffleButton);
        VBox vb = new VBox(10);
        vb.setTranslateX(20);
        vb.setTranslateY(20);
        vb.getChildren().addAll(desk, buttonBox);

        root.getChildren().addAll(vb);

    }


    /*
     * Node that represents the playing area/ desktop where the puzzle pieces sit
     */
    public class Desk extends Pane {
        Desk(int numOfColumns, int numOfRows) {
            setStyle("-fx-background-color: #cccccc; " + "-fx-border-color: #464646; " +
                    "-fx-effect: innershadow( two-pass-box, rgba(0,0,0,0.8), 15,0.0,0,4);");

            setPrefSize(numOfColumns * Piece.SIZE, numOfRows * Piece.SIZE);
            setMaxSize(numOfColumns * Piece.SIZE, numOfRows * Piece.SIZE);
            autosize();
            //create path for lines
            Path grid = new Path();
            grid.setStroke(Color.rgb(70, 70, 70));
            getChildren().add(grid);
            //create vertical lines
            for (int col = 0; col < numOfColumns - 1; col++) {
                grid.getElements().addAll(
                        new MoveTo(Piece.SIZE + Piece.SIZE * col, 5),
                        new LineTo(Piece.SIZE + Piece.SIZE * col, Piece.SIZE * numOfRows - 5)
                );
            }
            //create horizontal lines
            for (int row = 0; row < numOfRows - 1; row++) {
                grid.getElements().addAll(
                        new MoveTo(5, Piece.SIZE + Piece.SIZE * row),
                        new LineTo(Piece.SIZE * numOfRows - 5, Piece.SIZE + Piece.SIZE * row)
                );
            }

        }

        @Override
        protected void layoutChildren() {
        }
    }

    /*
     * Node that represents a puzzle piece
     */
    public static class Piece extends Parent {
        public static final int SIZE = 100;
        private final double correctX;
        private final double correctY;
        private final boolean hasTopTab;
        private final boolean hasLeftTab;
        private final boolean hasBottomTab;
        private final boolean hasRightTab;
        private double startDragX;
        private double startDragY;
        private Shape pieceStroke;
        private Shape pieceClip;
        private ImageView imageView = new ImageView();
        private Point2D dragAnchor;

        public Piece(Image image, final double correctX, final double correctY,
                     boolean topTab, boolean leftTab, boolean bottomTab,
                     boolean rightTab, final double deskWidth, final double deskHeight) {
            this.correctX = correctX;
            this.correctY = correctY;
            this.hasTopTab = topTab;
            this.hasLeftTab = leftTab;
            this.hasBottomTab = bottomTab;
            this.hasRightTab = rightTab;
            //configure clip
            pieceClip = createPiece();
            pieceClip.setFill(Color.WHITE);
            pieceClip.setStroke(null);
            //add a stroke
            pieceStroke = createPiece();
            pieceStroke.setFill(null);
            pieceStroke.setStroke(Color.BLACK);
            //create image view
            imageView.setImage(image);
            imageView.setClip(pieceClip);
            setFocusTraversable(true);
            getChildren().addAll(imageView, pieceStroke);
            //turn on cashing so the jigsaw piece is fasr to draw when dragging
            setCache(true);
            //start in inactive state
            setInactive();
            //add listeners to support dragging
            setOnMousePressed(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent me) {
                    toFront();
                    startDragX = getTranslateX();
                    startDragY = getTranslateY();
                    dragAnchor = new Point2D(me.getSceneX(), me.getSceneY());
                }
            });
            setOnMouseReleased(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent me) {
                    if (getTranslateX() < (10) && getTranslateX() > (-10) &&
                            getTranslateY() < (10) && getTranslateY() > (-10)) {
                        setTranslateX(0);
                        setTranslateY(0);
                        setInactive();
                    }
                }
            });
            setOnMouseDragged(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent me) {
                    double newTranslateX = startDragX + me.getSceneX() - dragAnchor.getX();
                    double newTranslateY = startDragY + me.getSceneY() - dragAnchor.getY();
                    double minTranslateX = -35f - correctX;
                    double maxTranslateX = (deskWidth - Piece.SIZE + 240f);
                    double minTranslateY = -30f - correctY;
                    double maxTranslateY = (deskWidth - Piece.SIZE + 10f) - correctY;
                    if ((newTranslateX > minTranslateX) && (newTranslateX < maxTranslateX) &&
                            (newTranslateY > minTranslateY) && (newTranslateY < maxTranslateY)) {
                        setTranslateX(newTranslateX);
                        setTranslateY(newTranslateY);
                    }
                }
            });
        }

        private Shape createPiece() {
            Shape shape = createPieceRectangle();
            if (hasRightTab) {
                shape = Shape.union(shape, createPieceTab(69.5f, 0f, 10f,
                        17.5f, 50f, -12.5f, 11.5f, 25f,
                        56.25f, -14f, 6.25f, 56.25f,
                        14f, 6.25f));
            }
            if (hasBottomTab) {
                shape = Shape.union(shape, createPieceTab(0f, 69.5f, 17.5f, 10f,
                        -12.5, 50f, 25f, 11f, -14f,
                        56.25f, 6.25f, 14f, 56.25f,
                        6.25f));
            }
            if (hasLeftTab) {
                shape = Shape.subtract(shape, createPieceTab(-31f, 0f, 10f, 17.5f,
                        -50f, -12.5f, 11f, 25f, -43.75f,
                        -14f, 6.25f, -43.75f, 14f, 6.25f));
            }
            if (hasTopTab) {
                shape = Shape.subtract(shape, createPieceTab(0f, -31f, 17.5f, 10f,
                        -12.5, -50f, 25f, 12.5f, -14f,
                        -43.75f, 6.25f, 14f, -43.75f, 6.25f));
            }
            shape.setTranslateX(correctX);
            shape.setTranslateY(correctY);
            shape.setLayoutX(50f);
            shape.setLayoutY(50f);
            return shape;
        }

        private Rectangle createPieceRectangle() {
            Rectangle rec = new Rectangle();
            rec.setX(-50);
            rec.setY(-50);
            rec.setWidth(SIZE);
            rec.setHeight(SIZE);
            return rec;
        }

        private Shape createPieceTab(double eclipseCenterX, double eclipseCenterY, double eclipseRadiusX, double eclipseRadiusY,
                                     double rectangleX, double rectangleY, double rectangleWidth, double rectangleHeight,
                                     double circle1CenterX, double circle1CenterY,
                                     double circe1Radius, double circle2CenterX, double circle2CenterY, double circle2Radius) {
            Ellipse e = new Ellipse(eclipseCenterX, eclipseCenterY, eclipseRadiusX, eclipseRadiusY);
            Rectangle r = new Rectangle(rectangleX, rectangleY, rectangleWidth, rectangleHeight);
            Shape tab = Shape.union(e, r);
            Circle c1 = new Circle(circle1CenterX, circle1CenterY, circe1Radius);
            tab = Shape.subtract(tab, c1);
            Circle c2 = new Circle(circle2CenterX, circle2CenterY, circle2Radius);
            tab = Shape.subtract(tab, c2);
            return tab;
        }

        public void setActive() {
            setDisable(false);
            setEffect(new DropShadow());
            toFront();
        }

        public void setInactive() {
            setEffect(null);
            setDisable(true);
            toBack();
        }

        public double getCorrectX() {
            return correctX;
        }

        public double getCorrectY() {
            return correctY;
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
        primaryStage.setX(primaryStage.getX() + primaryStage.getWidth() / 2 - primaryStage.getWidth() / 2); //dialog.getWidth() = not NaN
        primaryStage.setY(primaryStage.getY() + primaryStage.getHeight() / 2 - primaryStage.getHeight() / 2); //dialog.getHeight() = not NaN
    }

}
