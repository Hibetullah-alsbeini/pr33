package main;
import gui.guiGetraenk.GetraenkControl;
import gui.guiGetraenk.GetraenkView;
import gui.guiGetraenkEinrichtung.GetraenkEinrichtungControl;
import javafx.application.Application;
import javafx.stage.Stage;





		public class Main extends Application {
			
			@Override
			public void start(Stage primaryStage) {
				new GetraenkControl(primaryStage);
				
				
				Stage fenster = new Stage();
				new GetraenkEinrichtungControl(fenster);
			}	
			
			public static void main(String[] args){
				launch(args);
			}
		}