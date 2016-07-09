import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class App extends Application{
	final private StockGame game = new StockGameImpl();
	final private String playerName = "anonymus";
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("aktienkauf");
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(25,25,25,25));
		gridPane.add(new Label("Name"), 0, 1);
		final TextField textfield1 = new TextField();
		textfield1.setPrefColumnCount(3);
		gridPane.add(textfield1, 1, 1);
		gridPane.add(new Label("Anzahl"), 0, 2);
		final TextField textfield2  = new TextField();
		gridPane.add(textfield2, 1, 2);
		final Label statusLabel = new Label ("");
		gridPane.add(statusLabel, 1, 6);
		HBox hbox = new HBox(10);
		hbox.setAlignment(Pos.BOTTOM_RIGHT);
		Button button = new Button("Kaufen");
		hbox.getChildren().add(button);
		gridPane.add(hbox,1,4);
		button.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent e){
				try {
					game.buyShare(playerName, textfield1.getText(), Integer.valueOf(textfield2.getText()));
				} catch (NumberFormatException e1) {
					statusLabel.setText("Anzahl muss eine Zahl sein");
				} catch (NotEnoghMoneyException e1) {
					statusLabel.setText(e1.getMessage());
				}catch (IllegalArgumentException e1){
					statusLabel.setText(e1.getMessage());
				}
				
			}
		}
				);
		
		
		
		Scene scene = new Scene(gridPane, 280,260);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
	}
}
