import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercise_18_20 extends Application {
    @Override
    public void start(Stage stage) {
        CirclePane pane = new CirclePane();

        Button btDown = new Button("-");
        Button btUp = new Button("+");
        btDown.setOnAction(e -> {
            if (pane.getOrder() > 0) {
                pane.setOrder(pane.getOrder() - 1);
                pane.paint();
            }

        });
        btUp.setOnAction(e -> {
            pane.setOrder(pane.getOrder() + 1);
            pane.paint();
        });

        // Pane to hold label, text field, and two buttons
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(btDown, btUp);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(hBox);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 200, 210);
        stage.setTitle("Circle");
        stage.setScene(scene);
        stage.show();

        pane.widthProperty().addListener(ov -> pane.paint());
        pane.heightProperty().addListener(ov -> pane.paint());
    }

    // Pane for displaying circles
    static class CirclePane extends Pane {
        private int order = 0;

        // Set a new order
        public void setOrder(int order) {
            this.order = order;
            paint();
        }

        // Get current order
        public int getOrder() {
            return order;
        }

        CirclePane() {
        }

        protected void paint() {
            double x = getWidth() / 2;
            double y = getHeight() / 2;

            this.getChildren().clear(); // Clear the pane before redisplay
            displayCircles(order, x, y);
        }

        private void displayCircles(int order, double x, double y) {
          if (order > 0) {
                // Draw a circle from the center point
                Circle circle = new Circle(x, y, (order * 10));
                circle.setStroke(Color.BLACK);
                circle.setFill(Color.TRANSPARENT);

                this.getChildren().add(circle);

                // Recursively display circles
                displayCircles(order - 1, x, y);
            }
        }
    }
}
