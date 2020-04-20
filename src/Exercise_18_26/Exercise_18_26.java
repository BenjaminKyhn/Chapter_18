package Exercise_18_26;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Exercise_18_26 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        MazeSolverGUI mazeSolverGUI = new MazeSolverGUI(8, 8);

        Scene scene = new Scene(mazeSolverGUI);
        stage.setScene(scene);
        stage.show();
    }
}
