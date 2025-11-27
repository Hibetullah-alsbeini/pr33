package gui.guiGetraenkEinrichtung;



import business.GetraenkModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class GetraenkEinrichtungControl implements Observer 
{


	
		private GetraenkEinrichtungView getraenkEinrichtungView;
		private GetraenkModel getraenkModel;
		
		
		public GetraenkEinrichtungControl(Stage primaryStage){
			getraenkModel = GetraenkModel.getInstance();
			this.getraenkEinrichtungView= new GetraenkEinrichtungView(this, primaryStage,
					getraenkModel);
			
			
	
		
			this.getraenkModel.addObserver(this);
			
		
		}
		@Override
		public void update() {
			getraenkEinrichtungView.zeigeGetraenkeAn();
			
			
			
		}
	}


