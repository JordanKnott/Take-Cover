package net.engine.feedback;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import net.Start;
import net.engine.Engine;
import net.engine.resourceHandlers.MainMenuImageHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class FeedbackSystem {

	private static int score;
	public static MainMenuImageHandler mainMenuHandler = new MainMenuImageHandler();
	public static void runUI(){
		GridPane titlePane = new GridPane();
		BorderPane corePane = new BorderPane();
		GridPane feedPane = new GridPane();
		GridPane submitPane = new GridPane();
		feedPane.setAlignment(Pos.CENTER);
		submitPane.setAlignment(Pos.TOP_CENTER);
		submitPane.setPadding(new Insets(50,50,50,50));
		Label nameL = new Label("First Name: ");
		TextField nameF = new TextField();
		
		Label gradeL = new Label("Grade: ");
		TextField gradeF = new TextField();
		
		Label commentL = new Label("Comments: ");
		TextArea commentF = new TextArea();
	
		Button submit = new Button("Submit");
		submit.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				 String to = "jordan.knott@my.netech.edu";

				    // Sender's email ID needs to be mentioned
				    String from = "TakeCover@gmail.com";

				    // Assuming you are sending email from localhost
				    String host = "localhost";

				    // Get system properties
				    Properties properties = System.getProperties();
				    properties.setProperty("mail.user", "j");
				    properties.setProperty("mail.password", "mypwd");
				    // Setup mail server
				    properties.setProperty("mail.smtp.host", host);

				    // Get the default Session object.
				    Session session = Session.getDefaultInstance(properties);

				    try{
				       // Create a default MimeMessage object.
				       MimeMessage message = new MimeMessage(session);

				       // Set From: header field of the header.
				       message.setFrom(new InternetAddress(from));

				       // Set To: header field of the header.
				       message.addRecipient(Message.RecipientType.TO,
				                                new InternetAddress(to));

				       // Set Subject: header field
				       message.setSubject("Feedback");

				       // Now set the actual message
				       message.setText(nameF.getText() + " : " + gradeF.getText() + " : " + commentF.getText());

				       // Send message
				       Transport.send(message);
				       System.out.println("Sent message successfully....");
				    }catch (MessagingException mex) {
				       mex.printStackTrace();
				    }
					
			}
			
		});
		
		
		feedPane.add(nameL, 0, 0);
		feedPane.add(nameF, 1, 0);
		
		feedPane.add(gradeL, 0, 1);
		feedPane.add(gradeF, 1, 1);
		
		feedPane.add(commentL, 0, 2);
		feedPane.add(commentF, 1, 2);
		submit.setMinSize(150, 90);
		submitPane.add(submit, 0, 0);
	
		submit.setFont(Font.font("Times New Roman", 26));
		GridPane.setHalignment(submit, HPos.CENTER);
		titlePane.add(new ImageView(mainMenuHandler.title), 0, 0);
		titlePane.setAlignment(Pos.CENTER);
		corePane.setTop(titlePane);
		corePane.setCenter(feedPane);
		corePane.setBottom(submitPane);
		score = Engine.score.returnScore();
		Scene scene = new Scene(corePane, Start.sceneStartWidth, Start.sceneStartHeight);
		scene.getStylesheets().add(FeedbackSystem.class.getResource("/net/assets/menu/MainMenu.css").toString());
		Start.primaryStage.setScene(scene);
	}
    // Recipient's email ID needs to be mentioned.
   
}
