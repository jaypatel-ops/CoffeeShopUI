import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;

public class CoffeeShop extends Application {

	Button btnSugar;
	Button btnCream;
	Button btnExtraShot;
	Button btnFrenchVanillaSwirl;
	Button btnAlmondMilk;

	Button startOrder;
	Button completeOrder;
	Button deleteOrder;

	Pane root = new Pane();
	TextArea txt;
	VBox vb;
	VBox vb3;
	VBox vb2;

	Coffee order = new BasicCoffee();

	//	ImageView imageV;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//added this function, so that this same code can be repeated at few places without writing the whole code.
	private void handle() {
		startOrder.setDisable(false);
		btnCream.setDisable(true);
		btnSugar.setDisable(true);
		btnAlmondMilk.setDisable(true);
		btnFrenchVanillaSwirl.setDisable(true);
		btnExtraShot.setDisable(true);
		completeOrder.setDisable(true);
		deleteOrder.setDisable(true);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Who want's coffee!!!");

		startOrder = new Button("Start Order");
		completeOrder = new Button("Complete Order");
		deleteOrder = new Button("Delete Order");

		btnCream = new Button("add Cream");
//		btnCream.setStyle("-fx-background-color: rgb(60,60,60)");
		btnSugar = new Button("add Sugar");
//		btnSugar.setStyle("-fx-background-color: rgb(60,60,60)");
		btnExtraShot = new Button("add Extra Shot");
//		btnExtraShot.setStyle("-fx-background-color: rgb(60,60,60)");
		btnFrenchVanillaSwirl = new Button("add French Vanilla Swirl");
//		btnFrenchVanillaSwirl.setStyle("-fx-background-color: rgb(60,60,60)");
		btnAlmondMilk = new Button("add Almond Milk");
//		btnAlmondMilk.setStyle("-fx-background-color: rgb(60,60,60)");


		txt = new TextArea();
//		txt.setStyle("-fx-border-color: red");

		txt.setLayoutX(100);
		txt.setLayoutY(90);
		txt.setPrefSize(300, 350);
		txt.setStyle("-fx-border-width: 10;");
		txt.setStyle("-fx-border-color: black;");

		vb = new VBox(0,txt);
		vb.setLayoutX(210);
		vb.setLayoutY(90);

		vb3 = new VBox(40,btnCream, btnSugar, btnExtraShot, btnFrenchVanillaSwirl, btnAlmondMilk);
		vb3.setLayoutX(610);
		vb3.setLayoutY(100);

		vb2 = new VBox(30, startOrder, completeOrder, deleteOrder);
		vb2.setLayoutX(850);
		vb2.setLayoutY(100);

		Image image = new Image("file:src/main/resources/Coffee.jpg");
		BackgroundSize bgSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true);
		BackgroundImage bgImage = new BackgroundImage(image,
				BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER,
				bgSize);

		Background bgr = new Background(bgImage);
		root.setBackground(bgr);
		root.getChildren().addAll(vb, vb2, vb3);


		Scene scene = new Scene(root, 1000,700);
		primaryStage.setScene(scene);
		primaryStage.show();

		handle();
		startOrder.setOnAction(e -> {

			txt.clear();
			startOrder.setDisable(true);
			btnCream.setDisable(false);
			btnSugar.setDisable(false);
			btnAlmondMilk.setDisable(false);
			btnFrenchVanillaSwirl.setDisable(false);
			btnExtraShot.setDisable(false);
			completeOrder.setDisable(false);
			deleteOrder.setDisable(false);
			txt.appendText("Basic Coffee: $3.99 \n");

			btnCream.setOnAction(action -> {
				this.order = new Cream (order);
				txt.appendText("\n" + " + Cream: $.50" + "\n = $" + order.makeCoffee() + "\n");

			});

			btnSugar.setOnAction(action -> {
				this.order = new Sugar (order);
				txt.appendText("\n" + " + Sugar: $.50"+ "\n = $" + order.makeCoffee() + "\n");

			});

			btnExtraShot.setOnAction(action -> {
				this.order = new ExtraShot (order);
				txt.appendText("\n" +" + Extra Shot: $1.10"+ "\n = $" + order.makeCoffee() + "\n");

			});

			btnFrenchVanillaSwirl.setOnAction(action -> {
				this.order = new FrenchVanillaSwirl (order);
				txt.appendText("\n" +" + French Vanilla Swirl: $.75"+ "\n = $" + order.makeCoffee() + "\n");

			});

			btnAlmondMilk.setOnAction(action -> {
				this.order = new AlmondMilk (order);
				txt.appendText("\n" +" + Almond Milk: $1.0"+ "\n = $" + order.makeCoffee() + "\n");

			});

		});


		completeOrder.setOnAction(e-> {
			handle();
			double cost = order.makeCoffee();
			txt.appendText("\n\n" + "Total: $" + cost + "\n\n" + "Thank You, Visit Again.");

		});

		deleteOrder.setOnAction(e-> {
			handle();
			txt.setText("Sorry! We couldn't satisfy your need, " +
					"\n\nHave a nice day!");
		});

	}

}

