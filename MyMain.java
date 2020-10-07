package com.internshala.javafxapp;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.Optional;

public class MyMain extends Application {
public static void main(String[] args){
	System.out.println("main");
	launch(args);
}

	@Override
	public void init() throws Exception {
		System.out.println("init");
		super.init();
	}

	@Override

		public void start (Stage primaryStage) throws Exception {
		System.out.println("start");
			FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
			VBox rootNode = loader.load();
            MenuBar menuBar= createMenu();
            rootNode.getChildren().add(0,menuBar);
        Scene scene=new Scene(rootNode,300,300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Convertor Tool");
	primaryStage.setResizable(false);
		primaryStage.show();

		}
		private MenuBar createMenu(){
	//file menu
			Menu fileMenu=new Menu("File");
			MenuItem newMenuItem=new MenuItem("New");
			newMenuItem.setOnAction(actionEvent -> System.out.println("New Menu Item Clicked"));

			SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
			MenuItem quitMenuItem=new MenuItem("Quit");
			quitMenuItem.setOnAction(event->{Platform.exit();
				System.exit(0);});
			fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);
			//helpMenu
			Menu helpMenu=new Menu("Help");
			MenuItem aboutApp=new MenuItem("About");
			aboutApp.setOnAction(actionEvent -> aboutApp());
			helpMenu.getItems().addAll(aboutApp);
			//menu bar
			MenuBar menuBar=new MenuBar();
			menuBar.getMenus().addAll(fileMenu,helpMenu);
			return menuBar;
		}

	private void aboutApp()
	{
		Alert alertDialog=new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My First Desktop App");
		alertDialog.setHeaderText("Learning JavaFX");//subtitle
		alertDialog.setContentText("I am just a begginer and soon will be pro");
		alertDialog.show();
		ButtonType yesBtn=new ButtonType("Yes");
		ButtonType noBtn=new ButtonType("No");
		alertDialog.getButtonTypes().setAll(yesBtn,noBtn);
		Optional<ButtonType> clickedBtn= alertDialog.showAndWait();
		if(clickedBtn.isPresent()&&clickedBtn.get()==yesBtn){
			System.out.println("Yes Button clicked!");
		}else {
				System.out.println("No Button Clicked!");
			}
		}




	@Override
	public void stop() throws Exception {
		System.out.println("stop");
		super.stop();
	}
}
