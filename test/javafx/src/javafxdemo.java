/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thirs
 */
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class javafxdemo extends Application{
    
    Stage window;
    Button confButton, alertButton, switchButton, closeButton, embeddLayout, checkButton, choiceButton, tableButton, tableButton2;
    Scene scene1, scene2, scene3, scene4, scene5, scene6, scene7, scene8;
    public static void main(String[] args){
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Title");
        confButton = new Button("Confirmation Box");
        alertButton = new Button("Alert Box");
        switchButton = new Button("Switch to scene2");
        closeButton = new Button("Close Program");
        embeddLayout = new Button("Emedding Layouts");
        checkButton = new Button("Check Boxes");
        choiceButton = new Button("ChoiceBox");
        tableButton = new Button("TableView");
        tableButton2 = new Button("TableView w/ Add and Delete");
        Label label = new Label("Welcome to scene2");
        
        confButton.setOnAction(e -> {
            boolean result = ConfirmationBox.display("Confirmation", "Yes or No");
            System.out.println(result);
                });
        
        alertButton.setOnAction(e -> AlertBox.display("Alert", "Message"));
        switchButton.setOnAction(e -> window.setScene(scene2));
        
        closeButton.setOnAction(e -> closeProgram());
        embeddLayout.setOnAction(e -> window.setScene(scene3));
        checkButton.setOnAction(e -> window.setScene(scene5));
        choiceButton.setOnAction(e -> window.setScene(scene6));
        
        tableButton2.setOnAction(e -> window.setScene(scene8));
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
                });
        HBox topMenu = new HBox();
        Button buttonA = new Button("File");
        Button buttonB = new Button("Edit");
        Button buttonC = new Button("View");
        
        topMenu.getChildren().addAll(buttonA, buttonB, buttonC);
        
        
        VBox leftMenu = new VBox();
        Button buttonD = new Button("D");
        Button buttonE = new Button("E");
        Button buttonF = new Button("F");
        
        leftMenu.getChildren().addAll(buttonD, buttonE, buttonF);
        
        BorderPane borderPane = new BorderPane();
        
        borderPane.setTop(topMenu);
        borderPane.setLeft(leftMenu);
        
        GridPane grid = new GridPane();
        
        grid.setPadding(new Insets(10, 10, 10, 10));
        
        grid.setVgap(8);
        grid.setHgap(10);
        
        Label nameLabel = new Label("Username");
        Label passLabel = new Label("Password");
        
        GridPane.setConstraints(nameLabel, 0, 0);
        GridPane.setConstraints(passLabel, 0, 1);
        
        TextField nameInput = new TextField();
        TextField passInput = new TextField();
        
        GridPane.setConstraints(nameInput, 1, 0);
        GridPane.setConstraints(passInput, 1, 1);
        
        nameInput.setPromptText("username");
        passInput.setPromptText("password");
        
        Button loginButton = new Button("Log In");
        
        loginButton.setOnAction(e -> {
            
            boolean verified = verifyLogin(nameInput, passInput);
            if(!verified){
                e.consume();
            }else{
                window.setScene(scene1);
            }
                });
        
        GridPane.setConstraints(loginButton, 1, 2);
        
        grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);
        
        CheckBox box1 = new CheckBox("Bacon");
        CheckBox box2 = new CheckBox("Tuna");
        
        box2.setSelected(true);
        
        Button orderButton = new Button("Order Now");
        
        orderButton.setOnAction(e -> {
            String message = "Users order:\n";
            if(box1.isSelected()){
                message = message + "Bacon\n";
            }
            if(box2.isSelected()){
                message = message + "Tuna\n";
            }
            System.out.println(message);
                });
        
        
        ChoiceBox<String> names = new ChoiceBox<>();
        
        names.getItems().add("Employee");
        
        names.getItems().addAll("Student", "Manager", "Customer");
        
        Button choice = new Button("Select");
        
        names.setValue("Student");
        
        choice.setOnAction(e -> System.out.println("Selected: " + names.getValue()));
        
        tableButton.setOnAction(e -> window.setScene(scene7));
        
        TableView<Product> table;
        
        //Name column
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        //Price column
        TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        //Quantity column
        TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        
        table = new TableView<>();
        table.setItems(insertProduct());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);
        
        TextField itemInput = new TextField();
        TextField priceInput = new TextField();
        TextField quantityInput = new TextField();
        
        itemInput.setPromptText("item");
        itemInput.setMinWidth(100);
        priceInput.setPromptText("price");
        quantityInput.setPromptText("quantity");
        
        Button addButton = new Button("ADD");
        Button deleteButton = new Button("REMOVE");
        
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(itemInput, priceInput, quantityInput, addButton, deleteButton);
       
        addButton.setOnAction(e -> {
            Product product = new Product();
            product.setName(itemInput.getText());
            product.setPrice(Double.parseDouble(priceInput.getText()));
            product.setQuantity(Integer.parseInt(quantityInput.getText()));
            
            table.getItems().add(product);
            
            itemInput.clear();
            priceInput.clear();
            quantityInput.clear();
                });
        
        deleteButton.setOnAction(e -> {
            ObservableList<Product> allProducts, productSelected;
            allProducts = table.getItems();
            productSelected = table.getSelectionModel().getSelectedItems();
            
            for(int i = 0; i < allProducts.size(); i++){
                if(allProducts.get(i).getName() == productSelected.get(0).getName() && allProducts.get(i).getPrice() == productSelected.get(0).getPrice() && allProducts.get(i).getQuantity() == productSelected.get(0).getQuantity())
                    allProducts.remove(productSelected.get(0));
            }
            
            //short hand
            //productSelected.forEach(allProducts::remove);
                  
                });
        
        
        StackPane layout1 = new StackPane();
        VBox layout2 = new VBox(20);
        VBox layout3 = new VBox(10);
        VBox layout4 = new VBox(30);
        VBox layout6 = new VBox();
        StackPane layout5 = new StackPane();
        layout3.setPadding(new Insets(10, 10, 10, 10));
        layout4.setPadding(new Insets(20, 10, 10, 10));
        layout1.getChildren().add(label);
        layout2.getChildren().addAll(confButton, alertButton, switchButton, embeddLayout, checkButton, choiceButton, tableButton, tableButton2, closeButton);
        layout2.setAlignment(Pos.CENTER);
        layout3.getChildren().addAll(box1, box2, orderButton);
        layout4.getChildren().addAll(names, choice);
        layout5.getChildren().addAll(table);
        layout6.getChildren().addAll(table, hBox);
        
        scene1 = new Scene(layout2, 300, 500);
        scene2 = new Scene(layout1, 600, 300);
        scene3 = new Scene(borderPane, 600, 300);
        scene4 = new Scene(grid, 300, 200);
        scene5 = new Scene(layout3, 300, 300);
        scene6 = new Scene(layout4, 400, 150);
        scene7 = new Scene(layout5, 400, 400);
        scene8 = new Scene(layout6);
        window.setScene(scene4);
        window.show();
        
    }
    
    private void closeProgram(){
        boolean answer = ConfirmationBox.display("Alert", "Are you sure?");
        if(answer){
            window.close();
        }
    }
    
    private boolean verifyLogin(TextField nameInput, TextField passInput){
        String username = nameInput.getText();
        String pass = passInput.getText();
        if(username.equals("username") && pass.equals("password")){
            return true;
        }
        return false;    
    }
    
    public ObservableList<Product> insertProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        
        products.add(new Product("Apple", 0.99, 100));
        products.add(new Product("Pear", 0.89, 80));
        products.add(new Product("Orange", 0.59, 50));
        products.add(new Product("Grapes", 1.99, 200));
        products.add(new Product("Mango", 2.99, 500));
        
        return products;
    }
    
    
    
    
    
    
}

