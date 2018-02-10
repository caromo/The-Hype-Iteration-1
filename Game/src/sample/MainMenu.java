package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

public class MainMenu {
    private Stage mainStage;
    private Scene mainScene, startingScene, characterCreationScene, gameOverScene;
    private Player player;
    public MainMenu(Player player, GraphicsContext gc, Canvas canvas, Stage mainStage, Scene mainScene) {
        this.player = player;
        this.mainStage = mainStage;
        this.mainScene = mainScene;
    }

    public void openMainMenu()
    {
        //Main Menu (first scene)
        GridPane mainMenu = new GridPane();
        mainMenu.setAlignment(Pos.CENTER);
        mainMenu.setVgap(40);
        startingScene = new Scene( mainMenu , 512 , 512);
        mainStage.setScene( startingScene );

        //Set Background Image
        File file = new File(System.getProperty("user.dir") + "\\src\\sample\\sprites\\lava.png");
        Image i = null;
        //System.out.println(System.getProperty("user.dir"));
        try {
            i = new Image(file.toURI().toURL().toString(), mainMenu.getWidth(), mainMenu.getHeight(), false, false);
        } catch (MalformedURLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        BackgroundImage im = new BackgroundImage(i, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(100, 100, false, false, false, true));

        mainMenu.setBackground(new Background(im));

        //Three main menu buttons
        Button newGameButton = new Button("New Game");
        newGameButton.setOnAction(e -> characterCreation());//mainStage.setScene(characterCreationScene));

        Button loadGameButton = new Button("Load Game");
        loadGameButton.setOnAction(e -> mainStage.setScene(mainScene)); // Change to Load() later

        Button exitGameButton = new Button("Exit Game");
        exitGameButton.setOnAction(e -> mainStage.close());

        mainMenu.add( newGameButton, 0,0);
        mainMenu.add( loadGameButton, 0,1);
        mainMenu.add( exitGameButton, 0,2);
    }

    // Generates the character creation menu
    public void characterCreation()
    {
        //Character Creation
        GridPane characterCreation = new GridPane();
        characterCreationScene = new Scene( characterCreation, 512, 512);
        characterCreation.setAlignment(Pos.CENTER);
        characterCreation.setVgap(40);
        characterCreation.setHgap(100);
        characterCreation.setBackground(new Background(new BackgroundFill(Color.ROSYBROWN, CornerRadii.EMPTY, Insets.EMPTY)));

        mainStage.setScene(characterCreationScene);

        // Player name box
        TextField nameInput = new TextField();

        // Labels for character creation
        Label chooseName = new Label("Select a character name");
        chooseName.setFont(Font.font("Verdana",14));
        Label chooseSprite = new Label("Select a character class");
        chooseSprite.setFont(Font.font("Verdana",14));
        Label chooseColor = new Label("Select a character color");
        chooseColor.setFont(Font.font("Verdana",14));

        // Character Creation Choices
        ChoiceBox characterColor = new ChoiceBox(FXCollections.observableArrayList("Blue","Green","Red"));
        characterColor.setValue("Blue"); //Setting a default choice

        ChoiceBox characterSprites = new ChoiceBox(FXCollections.observableArrayList("Sword","Potion 1","Pikachu"));
        characterSprites.setValue("Sword"); //Setting a default choice

        Image characterSprite1 = new Image("file:" + System.getProperty("user.dir") + "\\src\\sample\\sprites\\sword.png");
        Image characterSprite2 = new Image("file:" + System.getProperty("user.dir") + "\\src\\sample\\sprites\\potion.png");
        Image characterSprite3 = new Image("file:" + System.getProperty("user.dir") + "\\src\\sample\\sprites\\pikachu.png");
        ImageView imageView = new ImageView(characterSprite1);

        Image[] spriteChoices = {characterSprite1,characterSprite2,characterSprite3};

        // Sets size of sprite choice
        imageView.setFitHeight(75);
        imageView.setFitWidth(75);

        // Watches for users choice in selection box
        characterSprites.getSelectionModel().selectedIndexProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        //label.setText(spriteChoices[newValue.intValue()]);
                        imageView.setImage(spriteChoices[newValue.intValue()]);
                    }
                }
        );

        // Back Button
        Button characterCreationBackButton = new Button("Back");
        characterCreationBackButton.setOnAction(e -> mainStage.setScene(startingScene));

        // Continue Button
        Button characterCreationContinueButton = new Button("Continue");
        characterCreationContinueButton.setOnAction(e -> {
            //player.setColor(characterClass.getValue()); // to get users choice after he clicks continue
            player.setName(nameInput.getText());
            //newGame(playerName,playerColor);
            System.out.println(player.getName());
            mainStage.setScene(mainScene);
        });

        // Adding buttons and text to characterCreation
        characterCreation.add(chooseName,1,0);
        characterCreation.add(nameInput,1,1);
        characterCreation.add(chooseSprite,1,2);
        characterCreation.add(characterSprites,1,3);
        characterCreation.add(chooseColor,1,4);
        //characterCreation.add(label,2,3);
        characterCreation.add(characterColor,1,5);
        characterCreation.add(characterCreationContinueButton,2,7);
        characterCreation.add(characterCreationBackButton,0,7);
        characterCreation.add(imageView,2,3);
        //characterCreation.getChildren().add(imageView);
    }

    public void openGameMenu() {

        GridPane gameMenu = new GridPane();
        gameMenu.setAlignment(Pos.CENTER);
        gameMenu.setVgap(40);
        Scene gameMenuScene = new Scene( gameMenu , 800 , 800);

        Button continueGameButton = new Button("Continue");
        continueGameButton.setOnAction(e -> mainStage.setScene(mainScene));

        Button saveGameButton = new Button("Save");
        saveGameButton.setOnAction(e -> System.out.println("Save has been pressed")); //SaveGame()

        Button goToMainMenuButton = new Button("Exit to main menu");
        goToMainMenuButton.setOnAction(e -> openMainMenu()); //mainStage.setScene(startingScene));

        Button exitGameButton = new Button("Exit Game");
        exitGameButton.setOnAction(e -> mainStage.close());

        gameMenu.add( continueGameButton, 0,0);
        gameMenu.add( saveGameButton, 0,1);
        gameMenu.add( goToMainMenuButton, 0,2);
        gameMenu.add( exitGameButton, 0,3);

        mainStage.setScene(gameMenuScene);

    }




    // Opens gameOver screen
    public void gameOver()
    {
        GridPane gameOver = new GridPane();
        gameOver.setAlignment(Pos.CENTER);
        gameOver.setVgap(40);
        gameOver.setHgap(100);

        gameOverScene = new Scene( gameOver, 800, 800);

        Text gameOverText = new Text("Game Over");
        gameOverText.setFont(Font.font("Verdana",40));
        gameOverText.setFill(Color.RED);

        Button goToMainMenuButtonFromGameOver = new Button("  Exit  ");
        goToMainMenuButtonFromGameOver.setOnAction(e -> openMainMenu());//mainStage.setScene(startingScene));

        gameOver.add(gameOverText,1,0);
        gameOver.add(goToMainMenuButtonFromGameOver,2,6);
        mainStage.setScene(gameOverScene);
    }



}
