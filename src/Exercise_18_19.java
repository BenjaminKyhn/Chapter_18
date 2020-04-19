import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Exercise_18_19 extends Application {
    @Override
    public void start(Stage stage) {
        SierpinskyTrianglePane pane = new SierpinskyTrianglePane();

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

        // Pane to hold label, text field, and a button
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(btDown, btUp);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(hBox);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 200, 210);
        stage.setTitle("SierpinskyTriangle");
        stage.setScene(scene);
        stage.show();

        pane.widthProperty().addListener(ov -> pane.paint());
        pane.heightProperty().addListener(ov -> pane.paint());
    }

    // Pane for displaying triangles
    static class SierpinskyTrianglePane extends Pane {
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

        SierpinskyTrianglePane() {
        }

        protected void paint() {
            // Select three points in proportion to the pane size
            Point2D p1 = new Point2D(getWidth() / 2, 10);
            Point2D p2 = new Point2D(10, getHeight() - 10);
            Point2D p3 = new Point2D(getWidth() - 10, getHeight() - 10);

            this.getChildren().clear(); // Clear the pane before redisplay

            displayTriangles(order, p1, p2, p3);
        }

        private void displayTriangles(int order, Point2D p1, Point2D p2, Point2D p3) {
            if (order == 0) {
                // Draw a triangle to connect three points
                Polygon triangle = new Polygon();
                triangle.getPoints().addAll(p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
                triangle.setStroke(Color.BLACK);
                triangle.setFill(Color.WHITE);

                this.getChildren().add(triangle);
            } else {
                // Get the midpoint on each edge in the triangle
                Point2D p12 = p1.midpoint(p2);
                Point2D p23 = p2.midpoint(p3);
                Point2D p31 = p3.midpoint(p1);

                // Recursively display three triangles
                displayTriangles(order - 1, p1, p12, p31);
                displayTriangles(order - 1, p12, p2, p23);
                displayTriangles(order - 1, p31, p23, p3);
            }
        }
    }
}
