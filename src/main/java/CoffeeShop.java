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
	HBox hb;
	HBox hb2;
	VBox vb;
	VBox vb3;
	VBox vb2;
	ImageView iView;

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
		btnSugar = new Button("add Sugar");
		btnExtraShot = new Button("add ExtraShot");
		btnFrenchVanillaSwirl = new Button("add French Vanilla Swirl");
		btnAlmondMilk = new Button("add AlmondMilk");


		txt = new TextArea();
		txt.setStyle("-fx-border-color: red");

		txt.setLayoutX(100);
		txt.setLayoutY(90);
		txt.setPrefSize(300, 350);
		txt.setStyle("-fx-border-width: 5;");
		txt.setStyle("-fx-border-color: black;");


//		hb = new HBox(0,txt);


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

//		Coffee order = new AlmondMilk(new FrenchVanillaSwirl(new Sugar(new Cream( new ExtraShot(new BasicCoffee())))));

//		double cost = order.makeCoffee();
//		System.out.println("Total: " + cost);

//		btnCream.setOnAction(e-> txt.setText("Total" + cost));
//		btnSugar.setOnAction(e-> txt.setText("Total" + cost));

		double total = 3.99;
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

			Coffee order1 = new Cream (new BasicCoffee());

			btnCream.setOnAction(action -> {
//				Coffee order1 = new Cream (new BasicCoffee());
				double cost = order1.makeCoffee();
				txt.appendText("\n" +"+ cream: $.50");

//				txt.appendText("Total:" + cost);
			});

			btnSugar.setOnAction(action -> {
//				Coffee order2 = new Sugar (new BasicCoffee());
				double cost = order1.makeCoffee();
				txt.appendText("\n" + " + sugar: $.50");

//				txt.appendText("Total:" + cost);
			});

			btnExtraShot.setOnAction(action -> {
//				Coffee order3 = new ExtraShot(new BasicCoffee());
				double cost = order1.makeCoffee();
				txt.appendText("\n" +" + ExtraShot: $1.10");
//				txt.appendText("Total:" + cost);
			});

			btnFrenchVanillaSwirl.setOnAction(action -> {
//				Coffee order4 = new FrenchVanillaSwirl (new BasicCoffee());
				double cost = order1.makeCoffee();
				txt.appendText("\n" +" + French Vanilla Swirl: $.75");
//				txt.appendText("Total:" + cost);

			});

			btnAlmondMilk.setOnAction(action -> {
//				Coffee order5 = new AlmondMilk (new BasicCoffee());
				double cost = order1.makeCoffee();
				txt.appendText("\n" +" + Almond Milk: $1.0");
//				txt.appendText("Total:" + cost);

			});

		});


		completeOrder.setOnAction(e-> {

			handle();
			txt.appendText("\n\n"+ "Total: $ ---" );
		});

		deleteOrder.setOnAction(e-> {

			handle();
			txt.setText("Sorry We couldn't satisfy your need, " +
						"\nHave a nice day!");
		});

	}



}

