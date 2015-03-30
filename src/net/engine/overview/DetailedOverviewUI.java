package net.engine.overview;

import net.Start;
import net.engine.Engine;
import net.engine.introUI.HouseIntroUI;
import net.engine.introUI.RoadIntroUI;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DetailedOverviewUI {

	static Effect tempEffect;
	
	public static void runOverview(){
		
		Stage detailStage = new Stage(StageStyle.DECORATED);
		BorderPane detailCoreGrid = new BorderPane();
		GridPane centerGrid = new GridPane();
		GridPane houseGrid = new GridPane();
		GridPane house2Grid = new GridPane();
		GridPane roadGrid = new GridPane();
		GridPane schoolGrid = new GridPane();
		
		GridPane innerGrid = new GridPane();
		
		Label houseDesc = new Label("Click an item name to why its needed/not needed");
		houseGrid.setAlignment(Pos.CENTER);
		innerGrid.setAlignment(Pos.CENTER);
		GridPane.setValignment(houseDesc, VPos.CENTER);
		houseDesc.setId("detailLabel");
		Label item1 = new Label("Apple - Not Needed"); 
		Label item2 = new Label("Ball - Not Needed");
		Label item3 = new Label("Battery - Needed");
		Label item4 = new Label("Blanket - Needed");
		
		Label item5 = new Label("Food Can - Needed");
		Label item6 = new Label("Flashlight - Needed");
		Label item7 = new Label("Gas Can - Needed");
		Label item8 = new Label("Laptop - Not Needed");
		
		Label item9 = new Label("Phone - Not Needed");
		Label item10 = new Label("Shoes - Needed");
		Label item11 = new Label("WalkieTalkie - Needed");
		Label item12 = new Label("Water - Needed");
		
		
		
		item1.setId("detailLabel");
		item2.setId("detailLabel");
		item3.setId("detailLabel");
		item4.setId("detailLabel");
		
		item5.setId("detailLabel");
		item6.setId("detailLabel");
		item7.setId("detailLabel");
		item8.setId("detailLabel");
		
		item9.setId("detailLabel");
		item10.setId("detailLabel");
		item11.setId("detailLabel");
		item12.setId("detailLabel");
		
		houseGrid.add(houseDesc,0, 0);
		houseGrid.setHgap(10); //horizontal gap in pixels => that's what you are asking for
		houseGrid.setVgap(10); //vertical gap in pixels
		houseGrid.setPadding(new Insets(10, 10, 10, 10));
		innerGrid.setHgap(10); //horizontal gap in pixels => that's what you are asking for
		innerGrid.setVgap(10); //vertical gap in pixels
		innerGrid.setPadding(new Insets(10, 10, 10, 10));
		innerGrid.add(item1,0, 1);
		
		innerGrid.add(item2,1, 1);
		innerGrid.add(item3,2, 1);
		innerGrid.add(item4,3, 1);
		
		innerGrid.add(item5,0, 2);
		innerGrid.add(item6,1, 2);
		innerGrid.add(item7,2, 2);
		innerGrid.add(item8,3, 2);
		
		innerGrid.add(item9,0, 3);
		innerGrid.add(item10,1, 3);
		innerGrid.add(item11,2, 3);
		innerGrid.add(item12,3, 3);
		innerGrid.setHgap(75); //horizontal gap in pixels => that's what you are asking for
		innerGrid.setVgap(75);
		houseGrid.add(innerGrid, 0, 1);
		
		
		
		
		item1.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	
	        	tempEffect = item1.getEffect();
	        	item1.setEffect(Engine.returnEnteredEffect());
	        	
	        }
	    });
		item1.setOnMouseExited(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	item1.setEffect(tempEffect);  
	        }
	    });
		item1.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	Stage stage = new Stage();
	        	GridPane pane = new GridPane();
	        	
	        	//TODO
	        	Label label1 = new Label("Apples are not need as they can rot.");
	        	Label label2 = new Label("You need non-perishable foods, like canned foods.");
	        	Label label3 = new Label("( Click me to close this dialog )");
	        	GridPane.setHalignment(label1, HPos.CENTER);
	        	GridPane.setHalignment(label2, HPos.CENTER);
	        	GridPane.setHalignment(label3, HPos.CENTER);
	        	label1.setId("detailLabel");
	        	label2.setId("detailLabel");
	        	label3.setId("detailLabel");
	        	label3.setOnMouseEntered(new EventHandler<MouseEvent>() {
	    	        public void handle(MouseEvent mouseHandler) {
	    	        	tempEffect = label3.getEffect();
	    	        	label3.setEffect(Engine.returnEnteredEffect());
	    	        }
	    	    });
	        	label3.setOnMouseExited(new EventHandler<MouseEvent>() {
	    	        public void handle(MouseEvent mouseHandler) {
	    	        	label3.setEffect(tempEffect);  
	    	        }
	    	    });
	        	label3.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        		public void handle(MouseEvent mouseHandler) {
	        			stage.close();
	        		}
	        	});
	        	pane.add(label1,0,0);
	        	pane.add(label2,0,1);
	        	pane.add(label3,0,2);
	        	
	        	Scene scene = new Scene(pane);
	    		if(Engine.gridSize < 15){
	    			scene.getStylesheets().add(RoadIntroUI.class.getResource("/net/assets/menu/MainMenuSmall.css").toString());

	    		}else{		
	    			scene.getStylesheets().add(RoadIntroUI.class.getResource("/net/assets/menu/MainMenu.css").toString());
	    		}
	    		
	        	stage.getIcons().add(new Image(getClass().getResource("/net/assets/menu/Emblem.png").toString()));
	        	stage.setScene(scene);
	        	stage.show();
	        }
	    });
		
		item2.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	
	        	tempEffect = item2.getEffect();
	        	item2.setEffect(Engine.returnEnteredEffect());
	        }
	    });
		item2.setOnMouseExited(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	item2.setEffect(tempEffect);  
	        }
	    });
		item2.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	Stage stage = new Stage();
	        	GridPane pane = new GridPane();
	        	
	        	//TODO
	        	Label label1 = new Label("A ball is not needed as it doesn't");
	        	Label label2 = new Label("provide any food or use.");
	        	Label label3 = new Label("( Click me to close this dialog )");
	        	label1.setId("detailLabel");
	        	label2.setId("detailLabel");
	        	label3.setId("detailLabel");
	        	GridPane.setHalignment(label1, HPos.CENTER);
	        	GridPane.setHalignment(label2, HPos.CENTER);
	        	GridPane.setHalignment(label3, HPos.CENTER);
	        	label3.setOnMouseEntered(new EventHandler<MouseEvent>() {
	    	        public void handle(MouseEvent mouseHandler) {
	    	        	tempEffect = label3.getEffect();
	    	        	label3.setEffect(Engine.returnEnteredEffect());
	    	        }
	    	    });
	        	label3.setOnMouseExited(new EventHandler<MouseEvent>() {
	    	        public void handle(MouseEvent mouseHandler) {
	    	        	label3.setEffect(tempEffect);  
	    	        }
	    	    });
	        	label3.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        		public void handle(MouseEvent mouseHandler) {
	        			stage.close();
	        		}
	        	});
	        	pane.add(label1,0,0);
	        	pane.add(label2,0,1);
	        	pane.add(label3,0,2);
	        	
	        	Scene scene = new Scene(pane);
	        	scene.getStylesheets().add(HouseIntroUI.class.getResource("/net/assets/menu/MainMenu.css").toString());
	        	stage.getIcons().add(new Image(getClass().getResource("/net/assets/menu/Emblem.png").toString()));
	        	stage.setScene(scene);
	        	stage.show();
	        }
	    });
		item3.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	tempEffect = item3.getEffect();
	        	item3.setEffect(Engine.returnEnteredEffect());
	        }
	    });
		item3.setOnMouseExited(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	item3.setEffect(tempEffect);  
	        }
	    });
		item3.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	Stage stage = new Stage();
	        	GridPane pane = new GridPane();
	        	
	        	//TODO
	        	Label label1 = new Label("A battery is needed to power any electrical");
	        	Label label2 = new Label("tools, like a flashlight.");
	        	Label label3 = new Label("( Click me to close this dialog )");
	        	GridPane.setHalignment(label1, HPos.CENTER);
	        	GridPane.setHalignment(label2, HPos.CENTER);
	        	GridPane.setHalignment(label3, HPos.CENTER);
	        	label1.setId("detailLabel");
	        	label2.setId("detailLabel");
	        	label3.setId("detailLabel");
	        	label3.setOnMouseEntered(new EventHandler<MouseEvent>() {
	    	        public void handle(MouseEvent mouseHandler) {
	    	        	tempEffect = label3.getEffect();
	    	        	label3.setEffect(Engine.returnEnteredEffect());
	    	        }
	    	    });
	        	label3.setOnMouseExited(new EventHandler<MouseEvent>() {
	    	        public void handle(MouseEvent mouseHandler) {
	    	        	label3.setEffect(tempEffect);  
	    	        }
	    	    });
	        	label3.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        		public void handle(MouseEvent mouseHandler) {
	        			stage.close();
	        		}
	        	});
	        	pane.add(label1,0,0);
	        	pane.add(label2,0,1);
	        	pane.add(label3,0,2);
	        	
	        	Scene scene = new Scene(pane);
	        	scene.getStylesheets().add(HouseIntroUI.class.getResource("/net/assets/menu/MainMenu.css").toString());
	        	stage.getIcons().add(new Image(getClass().getResource("/net/assets/menu/Emblem.png").toString()));
	        	stage.setScene(scene);
	        	stage.show();
	        }
	    });
		
		item4.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	tempEffect = item4.getEffect();
	        	item4.setEffect(Engine.returnEnteredEffect());
	        }
	    });
		item4.setOnMouseExited(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	item4.setEffect(tempEffect);  
	        }
	    });
		item4.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	Stage stage = new Stage();
	        	GridPane pane = new GridPane();
	        	
	        	//TODO
	        	Label label1 = new Label("A blanket is needed to keep you warm in case of");
	        	Label label2 = new Label("chilly nights and as a kind of shield against broken glass.");
	        	Label label3 = new Label("( Click me to close this dialog )");
	        	GridPane.setHalignment(label1, HPos.CENTER);
	        	GridPane.setHalignment(label2, HPos.CENTER);
	        	GridPane.setHalignment(label3, HPos.CENTER);
	        	label1.setId("detailLabel");
	        	label2.setId("detailLabel");
	        	label3.setId("detailLabel");
	        	label3.setOnMouseEntered(new EventHandler<MouseEvent>() {
	    	        public void handle(MouseEvent mouseHandler) {
	    	        	tempEffect = label3.getEffect();
	    	        	label3.setEffect(Engine.returnEnteredEffect());
	    	        }
	    	    });
	        	label3.setOnMouseExited(new EventHandler<MouseEvent>() {
	    	        public void handle(MouseEvent mouseHandler) {
	    	        	label3.setEffect(tempEffect);  
	    	        }
	    	    });
	        	label3.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        		public void handle(MouseEvent mouseHandler) {
	        			stage.close();
	        		}
	        	});
	        	pane.add(label1,0,0);
	        	pane.add(label2,0,1);
	        	pane.add(label3,0,2);
	        	
	        	Scene scene = new Scene(pane);
	        	scene.getStylesheets().add(HouseIntroUI.class.getResource("/net/assets/menu/MainMenu.css").toString());
	        	stage.getIcons().add(new Image(getClass().getResource("/net/assets/menu/Emblem.png").toString()));
	        	stage.setScene(scene);
	        	stage.show();
	        }
	    });
		
		item5.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	tempEffect = item5.getEffect();
	        	item5.setEffect(Engine.returnEnteredEffect());
	        }
	    });
		item5.setOnMouseExited(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	item5.setEffect(tempEffect);  
	        }
	    });
		item5.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	Stage stage = new Stage();
	        	GridPane pane = new GridPane();
	        	
	        	//TODO
	        	Label label1 = new Label("A can of food is needed as it is");
	        	Label label2 = new Label("non-perishable and it provides sustenance.");
	        	Label label3 = new Label("( Click me to close this dialog )");
	        	GridPane.setHalignment(label1, HPos.CENTER);
	        	GridPane.setHalignment(label2, HPos.CENTER);
	        	GridPane.setHalignment(label3, HPos.CENTER);
	        	label1.setId("detailLabel");
	        	label2.setId("detailLabel");
	        	label3.setId("detailLabel");
	        	label3.setOnMouseEntered(new EventHandler<MouseEvent>() {
	    	        public void handle(MouseEvent mouseHandler) {
	    	        	tempEffect = label3.getEffect();
	    	        	label3.setEffect(Engine.returnEnteredEffect());
	    	        }
	    	    });
	        	label3.setOnMouseExited(new EventHandler<MouseEvent>() {
	    	        public void handle(MouseEvent mouseHandler) {
	    	        	label3.setEffect(tempEffect);  
	    	        }
	    	    });
	        	label3.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        		public void handle(MouseEvent mouseHandler) {
	        			stage.close();
	        		}
	        	});
	        	pane.add(label1,0,0);
	        	pane.add(label2,0,1);
	        	pane.add(label3,0,2);
	        	
	        	Scene scene = new Scene(pane);
	        	scene.getStylesheets().add(HouseIntroUI.class.getResource("/net/assets/menu/MainMenu.css").toString());
	        	stage.getIcons().add(new Image(getClass().getResource("/net/assets/menu/Emblem.png").toString()));
	        	stage.setScene(scene);
	        	stage.show();
	        }
	    });
		
		item6.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	tempEffect = item6.getEffect();
	        	item6.setEffect(Engine.returnEnteredEffect());
	        }
	    });
		item6.setOnMouseExited(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	item6.setEffect(tempEffect);  
	        }
	    });
		item6.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	Stage stage = new Stage();
	        	GridPane pane = new GridPane();
	        	
	        	//TODO
	        	Label label1 = new Label("A flashlight is needed in order to light up the dark.");
	        	Label label2 = new Label("When a tornado hits, power lines may be down and the lights will be off.");
	        	Label label3 = new Label("( Click me to close this dialog )");
	        	GridPane.setHalignment(label1, HPos.CENTER);
	        	GridPane.setHalignment(label2, HPos.CENTER);
	        	GridPane.setHalignment(label3, HPos.CENTER);
	        	label1.setId("detailLabel");
	        	label2.setId("detailLabel");
	        	label3.setId("detailLabel");
	        	label3.setOnMouseEntered(new EventHandler<MouseEvent>() {
	    	        public void handle(MouseEvent mouseHandler) {
	    	        	tempEffect = label3.getEffect();
	    	        	label3.setEffect(Engine.returnEnteredEffect());
	    	        }
	    	    });
	        	label3.setOnMouseExited(new EventHandler<MouseEvent>() {
	    	        public void handle(MouseEvent mouseHandler) {
	    	        	label3.setEffect(tempEffect);  
	    	        }
	    	    });
	        	label3.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        		public void handle(MouseEvent mouseHandler) {
	        			stage.close();
	        		}
	        	});
	        	pane.add(label1,0,0);
	        	pane.add(label2,0,1);
	        	pane.add(label3,0,2);
	        	
	        	Scene scene = new Scene(pane);
	        	scene.getStylesheets().add(HouseIntroUI.class.getResource("/net/assets/menu/MainMenu.css").toString());
	        	stage.getIcons().add(new Image(getClass().getResource("/net/assets/menu/Emblem.png").toString()));
	        	stage.setScene(scene);
	        	stage.show();
	        }
	    });
		
		item7.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	tempEffect = item7.getEffect();
	        	item7.setEffect(Engine.returnEnteredEffect());
	        }
	    });
		item7.setOnMouseExited(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	item7.setEffect(tempEffect);  
	        }
	    });
		item7.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	Stage stage = new Stage();
	        	GridPane pane = new GridPane();
	        	
	        	//TODO
	        	Label label1 = new Label("A gas can is needed as you should put it in a safe place and to");
	        	Label label2 = new Label("power a generator you might have in your shelter.");
	        	Label label3 = new Label("( Click me to close this dialog )");
	        	GridPane.setHalignment(label1, HPos.CENTER);
	        	GridPane.setHalignment(label2, HPos.CENTER);
	        	GridPane.setHalignment(label3, HPos.CENTER);
	        	label1.setId("detailLabel");
	        	label2.setId("detailLabel");
	        	label3.setId("detailLabel");
	        	label3.setOnMouseEntered(new EventHandler<MouseEvent>() {
	    	        public void handle(MouseEvent mouseHandler) {
	    	        	tempEffect = label3.getEffect();
	    	        	label3.setEffect(Engine.returnEnteredEffect());
	    	        }
	    	    });
	        	label3.setOnMouseExited(new EventHandler<MouseEvent>() {
	    	        public void handle(MouseEvent mouseHandler) {
	    	        	label3.setEffect(tempEffect);  
	    	        }
	    	    });
	        	label3.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        		public void handle(MouseEvent mouseHandler) {
	        			stage.close();
	        		}
	        	});
	        	pane.add(label1,0,0);
	        	pane.add(label2,0,1);
	        	pane.add(label3,0,2);
	        	
	        	Scene scene = new Scene(pane);
	        	scene.getStylesheets().add(HouseIntroUI.class.getResource("/net/assets/menu/MainMenu.css").toString());
	        	stage.getIcons().add(new Image(getClass().getResource("/net/assets/menu/Emblem.png").toString()));
	        	stage.setScene(scene);
	        	stage.show();
	        }
	    });
		
		item8.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	tempEffect = item8.getEffect();
	        	item8.setEffect(Engine.returnEnteredEffect());
	        }
	    });
		item8.setOnMouseExited(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	item8.setEffect(tempEffect);  
	        }
	    });
		item8.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	Stage stage = new Stage();
	        	GridPane pane = new GridPane();
	        	
	        	//TODO
	        	Label label1 = new Label("A laptop is not needed as it only takes up space");
	        	Label label2 = new Label("that could be used for usefull items like canned food.");
	        	Label label3 = new Label("( Click me to close this dialog )");
	        	GridPane.setHalignment(label1, HPos.CENTER);
	        	GridPane.setHalignment(label2, HPos.CENTER);
	        	GridPane.setHalignment(label3, HPos.CENTER);
	        	label1.setId("detailLabel");
	        	label2.setId("detailLabel");
	        	label3.setId("detailLabel");
	        	label3.setOnMouseEntered(new EventHandler<MouseEvent>() {
	    	        public void handle(MouseEvent mouseHandler) {
	    	        	tempEffect = label3.getEffect();
	    	        	label3.setEffect(Engine.returnEnteredEffect());
	    	        }
	    	    });
	        	label3.setOnMouseExited(new EventHandler<MouseEvent>() {
	    	        public void handle(MouseEvent mouseHandler) {
	    	        	label3.setEffect(tempEffect);  
	    	        }
	    	    });
	        	label3.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        		public void handle(MouseEvent mouseHandler) {
	        			stage.close();
	        		}
	        	});
	        	pane.add(label1,0,0);
	        	pane.add(label2,0,1);
	        	pane.add(label3,0,2);
	        	
	        	Scene scene = new Scene(pane);
	        	scene.getStylesheets().add(HouseIntroUI.class.getResource("/net/assets/menu/MainMenu.css").toString());
	        	stage.getIcons().add(new Image(getClass().getResource("/net/assets/menu/Emblem.png").toString()));
	        	stage.setScene(scene);
	        	stage.show();
	        }
	    });
		
		item9.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	tempEffect = item9.getEffect();
	        	item9.setEffect(Engine.returnEnteredEffect());
	        }
	    });
		item9.setOnMouseExited(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	item9.setEffect(tempEffect);  
	        }
	    });
		item9.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	Stage stage = new Stage();
	        	GridPane pane = new GridPane();
	        	
	        	//TODO
	        	Label label1 = new Label("A phone is not needed as cell towers might be down due");
	        	Label label2 = new Label("to the tornado. Walkie Talkies are a better alternative.");
	        	Label label3 = new Label("( Click me to close this dialog )");
	        	label1.setId("detailLabel");
	        	label2.setId("detailLabel");
	        	label3.setId("detailLabel");
	        	GridPane.setHalignment(label1, HPos.CENTER);
	        	GridPane.setHalignment(label2, HPos.CENTER);
	        	GridPane.setHalignment(label3, HPos.CENTER);
	        	label3.setOnMouseEntered(new EventHandler<MouseEvent>() {
	    	        public void handle(MouseEvent mouseHandler) {
	    	        	tempEffect = label3.getEffect();
	    	        	label3.setEffect(Engine.returnEnteredEffect());
	    	        }
	    	    });
	        	label3.setOnMouseExited(new EventHandler<MouseEvent>() {
	    	        public void handle(MouseEvent mouseHandler) {
	    	        	label3.setEffect(tempEffect);  
	    	        }
	    	    });
	        	label3.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        		public void handle(MouseEvent mouseHandler) {
	        			stage.close();
	        		}
	        	});
	        	pane.add(label1,0,0);
	        	pane.add(label2,0,1);
	        	pane.add(label3,0,2);
	        	
	        	Scene scene = new Scene(pane);
	        	scene.getStylesheets().add(HouseIntroUI.class.getResource("/net/assets/menu/MainMenu.css").toString());
	        	stage.getIcons().add(new Image(getClass().getResource("/net/assets/menu/Emblem.png").toString()));
	        	stage.setScene(scene);
	        	stage.show();
	        }
	    });
		
		item10.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	tempEffect = item10.getEffect();
	        	item10.setEffect(Engine.returnEnteredEffect());
	        }
	    });
		item10.setOnMouseExited(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	item10.setEffect(tempEffect);  
	        }
	    });
		item10.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	Stage stage = new Stage();
	        	GridPane pane = new GridPane();
	        	
	        	//TODO
	        	Label label1 = new Label("Shoes are needed in order to protect your feet");
	        	Label label2 = new Label("from debris and shards of glass on the ground.");
	        	Label label3 = new Label("( Click me to close this dialog )");
	        	GridPane.setHalignment(label1, HPos.CENTER);
	        	GridPane.setHalignment(label2, HPos.CENTER);
	        	GridPane.setHalignment(label3, HPos.CENTER);
	        	label1.setId("detailLabel");
	        	label2.setId("detailLabel");
	        	label3.setId("detailLabel");
	        	label3.setOnMouseEntered(new EventHandler<MouseEvent>() {
	    	        public void handle(MouseEvent mouseHandler) {
	    	        	tempEffect = label3.getEffect();
	    	        	label3.setEffect(Engine.returnEnteredEffect());
	    	        }
	    	    });
	        	label3.setOnMouseExited(new EventHandler<MouseEvent>() {
	    	        public void handle(MouseEvent mouseHandler) {
	    	        	label3.setEffect(tempEffect);  
	    	        }
	    	    });
	        	label3.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        		public void handle(MouseEvent mouseHandler) {
	        			stage.close();
	        		}
	        	});
	        	pane.add(label1,0,0);
	        	pane.add(label2,0,1);
	        	pane.add(label3,0,2);
	        	
	        	Scene scene = new Scene(pane);
	        	scene.getStylesheets().add(HouseIntroUI.class.getResource("/net/assets/menu/MainMenu.css").toString());
	        	stage.getIcons().add(new Image(getClass().getResource("/net/assets/menu/Emblem.png").toString()));
	        	stage.setScene(scene);
	        	stage.show();
	        }
	    });
		
		item11.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	tempEffect = item11.getEffect();
	        	item11.setEffect(Engine.returnEnteredEffect());
	        }
	    });
		item11.setOnMouseExited(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	item11.setEffect(tempEffect);  
	        }
	    });
		item11.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	Stage stage = new Stage();
	        	GridPane pane = new GridPane();
	        	
	        	//TODO
	        	Label label1 = new Label("A walkie talkie is needed as cell towers may be down");
	        	Label label2 = new Label("so walkie talkies are a better alternative form of communication.");
	        	Label label3 = new Label("( Click me to close this dialog )");
	        	GridPane.setHalignment(label1, HPos.CENTER);
	        	GridPane.setHalignment(label2, HPos.CENTER);
	        	GridPane.setHalignment(label3, HPos.CENTER);
	        	label1.setId("detailLabel");
	        	label2.setId("detailLabel");
	        	label3.setId("detailLabel");
	        	label3.setOnMouseEntered(new EventHandler<MouseEvent>() {
	    	        public void handle(MouseEvent mouseHandler) {
	    	        	tempEffect = label3.getEffect();
	    	        	label3.setEffect(Engine.returnEnteredEffect());
	    	        }
	    	    });
	        	label3.setOnMouseExited(new EventHandler<MouseEvent>() {
	    	        public void handle(MouseEvent mouseHandler) {
	    	        	label3.setEffect(tempEffect);  
	    	        }
	    	    });
	        	label3.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        		public void handle(MouseEvent mouseHandler) {
	        			stage.close();
	        		}
	        	});
	        	pane.add(label1,0,0);
	        	pane.add(label2,0,1);
	        	pane.add(label3,0,2);
	        	
	        	Scene scene = new Scene(pane);
	        	scene.getStylesheets().add(HouseIntroUI.class.getResource("/net/assets/menu/MainMenu.css").toString());
	        	stage.getIcons().add(new Image(getClass().getResource("/net/assets/menu/Emblem.png").toString()));
	        	stage.setScene(scene);
	        	stage.show();
	        }
	    });
		
		item12.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	tempEffect = item12.getEffect();
	        	item12.setEffect(Engine.returnEnteredEffect());
	        }
	    });
		item12.setOnMouseExited(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	item12.setEffect(tempEffect);  
	        }
	    });
		item12.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent mouseHandler) {
	        	Stage stage = new Stage();
	        	GridPane pane = new GridPane();
	        	
	        	//TODO
	        	Label label1 = new Label("72 Hours worth of water is needed in order to stay");
	        	Label label2 = new Label("hydrated as long as possible.");
	        	Label label3 = new Label("( Click me to close this dialog )");
	        	GridPane.setHalignment(label1, HPos.CENTER);
	        	GridPane.setHalignment(label2, HPos.CENTER);
	        	GridPane.setHalignment(label3, HPos.CENTER);
	        	label1.setId("detailLabel");
	        	label2.setId("detailLabel");
	        	label3.setId("detailLabel");
	        	label3.setOnMouseEntered(new EventHandler<MouseEvent>() {
	    	        public void handle(MouseEvent mouseHandler) {
	    	        	tempEffect = label3.getEffect();
	    	        	label3.setEffect(Engine.returnEnteredEffect());
	    	        }
	    	    });
	        	label3.setOnMouseExited(new EventHandler<MouseEvent>() {
	    	        public void handle(MouseEvent mouseHandler) {
	    	        	label3.setEffect(tempEffect);  
	    	        }
	    	    });
	        	label3.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        		public void handle(MouseEvent mouseHandler) {
	        			stage.close();
	        		}
	        	});
	        	pane.add(label1,0,0);
	        	pane.add(label2,0,1);
	        	pane.add(label3,0,2);
	        	
	        	Scene scene = new Scene(pane);
	        	scene.getStylesheets().add(HouseIntroUI.class.getResource("/net/assets/menu/MainMenu.css").toString());
	        	stage.getIcons().add(new Image(getClass().getResource("/net/assets/menu/Emblem.png").toString()));
	        	stage.setScene(scene);
	        	stage.show();
	        }
	    });
		
		centerGrid.setAlignment(Pos.CENTER);
		centerGrid.add(houseGrid,0,0);
		centerGrid.add(house2Grid,0,1);
		centerGrid.add(roadGrid,1,0);
		centerGrid.add(schoolGrid,1,1);
		detailCoreGrid.setCenter(centerGrid);
		
		Scene detailScene = new Scene(detailCoreGrid,  Start.sceneStartWidth - (Start.sceneStartWidth * .25) + 200 , Start.sceneStartHeight - (Start.sceneStartHeight * .25));
		detailScene.getStylesheets().add(HouseIntroUI.class.getResource("/net/assets/menu/MainMenu.css").toString());
		detailStage.setScene(detailScene);
		detailStage.getIcons().add(new Image(DetailedOverviewUI.class.getResource("/net/assets/menu/Emblem.png").toString()));
		detailStage.setTitle("Detailed Overview");
		detailStage.show();
		
	}
	
	
}
