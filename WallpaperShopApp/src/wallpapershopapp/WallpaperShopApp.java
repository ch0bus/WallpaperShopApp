package wallpapershopapp;
import wallpapershopapp.seller.*;

import java.awt.Color;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class WallpaperShopApp extends Application {
    
    DecimalFormat decimalFormat = new DecimalFormat( "#.##" );
    
    ArrayList<Seller> seller = new ArrayList<Seller>();
    int counterOfEmployee;
    int numberOfEmployee;
    String firstNameEmployee;
    String lastNameEmployee;
    String sellerNameFromList;
    String sellerTotalName;
    String workPlaceEmployee;
    String employeePosition;
    String employeeRank;
    LocalDate dateBirthEmployee;
    LocalDate dateOfEmplEmployee;
    String phoneEmployee;
    String addressEmployee;    
    LocalDate dateReceipt;
    int numberReceipt;
    double amountReceipt;
   
    ObservableList<String> nameShop = FXCollections.observableArrayList("001 Minsk", "002 Gomel", "004 Mogilev", "005 Brest");
    //ObservableList<String> nameSeler = FXCollections.observableArrayList("001 Igor", "002 Oksana", "004 Irina", "005 Natalia");
    
    @Override
    public void start(Stage primaryStage) {
    
        primaryStage.setResizable(false);                                       // not fullScreen
        
        GridPane root = new GridPane();	        
                root.setGridLinesVisible(false);                                // show border GridPane
                root.setHgap(10);
                root.setVgap(10);
        
	Scene scene = new Scene(root,650,440);
        
        Button btnShopMenu = new Button("Menu Shop");
        btnShopMenu.setMinWidth(150);
        btnShopMenu.setMinHeight(50);
        Button btnSelerMenu = new Button("Menu Seler");
        btnSelerMenu.setMinWidth(150);
        btnSelerMenu.setMinHeight(50);
        Button btnViewData = new Button("Data View");
        btnViewData.setMinWidth(150);
        btnViewData.setMinHeight(50);
        Button btnCalc = new Button("Calculator");
        btnCalc.setMinWidth(150);
        btnCalc.setMinHeight(50);
        Button btnSetting_bottom = new Button("Setting");
        btnSetting_bottom.setMinWidth(100);
        GridPane.setHalignment(btnSetting_bottom, HPos.CENTER);
        Button btnUpdata_bottom = new Button("Updata");
        btnUpdata_bottom.setMinWidth(100);
        Button btnExit_bottom = new Button("Exit");
        btnExit_bottom.setMinWidth(100);
        
        Label scrLabel = new Label("saefewfwef wefrwefwef we wef wefwe fwe"
                + "\nfwefwefsaefewfwef wefrwefwef we wef wefwe "
                + "\nfwefwefwef saefewfwef wefrwefwef we wef wefwe fwefwefwef "
                + "\nsaefewfwef wefrwefwef we wef wefwe fwefwefwefsaefewfwef "
                + "\nwefrwefwef we wef wefwe fwefwefwef");
        
        Button btnPrev = new Button("prev");
        Button btnNext = new Button("next");
        
        Rectangle rectBaner = new Rectangle(350, 50);
        Rectangle rectBanerOboiColor = new Rectangle(630, 60);
        
        ScrollPane scrPane = new ScrollPane(scrLabel);
        
        Label dateLabelCurent_right = new Label("Curent Date");
        Label dateLabelEdit_right = new Label("Last edit Date");
        Label goalLabel_right = new Label("Amount to Plan");
        Label bestShopLabel_right = new Label("Best Shop");
        
        Label dateLabelCurent_value = new Label("11.10.2020");
        Label dateLabelEdit_value = new Label("04.10.2020");
        Label goalLabel_value = new Label("1025,45");
        Label bestShopLabel_value = new Label("Minsk");
        
        scrPane.setMinWidth(320);
        //scrPane.setPrefSize(0, 0);
        //scrPane.setPrefViewportHeight(100);
        //scrPane.setPrefViewportWidth(100);
        scrPane.setPannable(true);
        
////////////////////////////////////////////////////////////////////////////////
    Menu mnFile = new Menu("File");
    // menu items creation
    MenuItem mif1 = new MenuItem("New Pattern");
    MenuItem mif2 = new MenuItem("Open Pattern");
    MenuItem mif3 = new MenuItem("Save as");
    MenuItem mif4 = new MenuItem("Print to HTML");
    MenuItem mif5 = new MenuItem("Exit\t\t\t\t\tAlt-F4");
    // Adding menu items
    mnFile.getItems().add(mif1);
    mnFile.getItems().add(mif2);
    mnFile.getItems().add(mif3);
    mnFile.getItems().add(mif4);
    mnFile.getItems().add(mif5);
    Menu mnEdit = new Menu("Edit");
    // menu items creation
    MenuItem mie1 = new MenuItem("Undo\t\tCtrl-Z");
    MenuItem mie2 = new MenuItem("Redo\t\tCtrl-Y");
    MenuItem mie3 = new MenuItem("Cut\t\t\tCtrl-X");
    MenuItem mie4 = new MenuItem("Copy\t\tCtrl-C");
    MenuItem mie5 = new MenuItem("Paste\t\tCtrl-V");
    MenuItem mie6 = new MenuItem("Delete\t\tDelete");
    // Adding menu items
    mnEdit.getItems().add(mie1);
    mnEdit.getItems().add(mie2);
    mnEdit.getItems().add(mie3);
    mnEdit.getItems().add(mie4);
    mnEdit.getItems().add(mie5);
    mnEdit.getItems().add(mie6);
    Menu mnView = new Menu("View");
    // menu items creation
    MenuItem miv1 = new MenuItem("Flipkart");
    MenuItem miv2 = new MenuItem("Myntra");
    MenuItem miv3 = new MenuItem("Amazon");
    MenuItem miv4 = new MenuItem("Club factory");
    // Adding menu items
    mnView.getItems().add(miv1);
    mnView.getItems().add(miv2);
    mnView.getItems().add(miv3);
    mnView.getItems().add(miv4);
    Menu mnHelp = new Menu("Help");
    // menu items creation
    MenuItem mih1 = new MenuItem("Online Docs and Support");
    MenuItem mih2 = new MenuItem("Check for Updates");
    MenuItem mih3 = new MenuItem("Start Page");
    MenuItem mih4 = new MenuItem("About");
    // Adding menu items
    mnHelp.getItems().add(mih1);
    mnHelp.getItems().add(mih2);
    mnHelp.getItems().add(mih3);
    mnHelp.getItems().add(mih4);
    // menubar creation
    MenuBar mb = new MenuBar();
    // Adding Menubar
    mb.getMenus().addAll(mnFile, mnEdit, mnView, mnHelp);
////////////////////////////////////////////////////////////////////////////////

btnShopMenu.setOnAction(new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent event) {
                Stage stageShop = new Stage();
                BorderPane root = new BorderPane();  
                Scene scene = new Scene(root,800,500);  
                
                Node rightPane = null;
                Node leftPane = null;
                BorderPane centerPane = getCenterPaneShopMenu_btnShopInfo();
               
                //Menu Top
                MenuBar menubar = new MenuBar();  
                Menu FileMenu = new Menu("File");  
                MenuItem filemenu1=new MenuItem("new");  
                MenuItem filemenu2=new MenuItem("Save");  
                MenuItem filemenu3=new MenuItem("Exit");  
                Menu EditMenu=new Menu("Edit");  
                MenuItem EditMenu1=new MenuItem("Cut");  
                MenuItem EditMenu2=new MenuItem("Copy");  
                MenuItem EditMenu3=new MenuItem("Paste");  
                EditMenu.getItems().addAll(EditMenu1,EditMenu2,EditMenu3);                  
                FileMenu.getItems().addAll(filemenu1,filemenu2,filemenu3);  
                menubar.getMenus().addAll(FileMenu,EditMenu);  
                        
                Button btnClose = new Button("Close");
                btnClose.setMinWidth(150);
                btnClose.setMinHeight(25);
                btnClose.setOnAction(new EventHandler<ActionEvent>() { 
                    public void handle(ActionEvent event) {
                        //System.exit(0);
                        //Platform.exit();
                        stageShop.close();
                    }
                });
                //Menu bottom
                HBox bottomPane = new HBox(btnClose);
                bottomPane.setAlignment(Pos.BASELINE_RIGHT);
                bottomPane.setStyle("-fx-padding: 10;");
                
                root.setTop(menubar);
                root.setCenter(centerPane);
                root.setRight(rightPane);
                root.setLeft(leftPane);
                root.setBottom(bottomPane);
                
                stageShop.setScene(scene);  
                stageShop.show();                
            }
    });
////////////////////////////////////////////////////////////////////////////////
/////////////////////////SelerMenu/////////////////////////////////////////////
    btnSelerMenu.setOnAction(new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent event) {
                
                Stage stageSeler = new Stage();
                BorderPane root = new BorderPane();  
                Scene scene = new Scene(root,800,500);  
                
                Node rightPane = null;
                Node leftPane = null;
                BorderPane centerPane = getCenterPaneSelerMenu_btnSelerInfo();
                
                //Menu Top
                MenuBar menubar = new MenuBar();  
                Menu FileMenu = new Menu("File");  
                MenuItem filemenu1=new MenuItem("new");  
                MenuItem filemenu2=new MenuItem("Save");  
                MenuItem filemenu3=new MenuItem("Exit");  
                Menu EditMenu=new Menu("Edit");  
                MenuItem EditMenu1=new MenuItem("Cut");  
                MenuItem EditMenu2=new MenuItem("Copy");  
                MenuItem EditMenu3=new MenuItem("Paste");  
                EditMenu.getItems().addAll(EditMenu1,EditMenu2,EditMenu3);                  
                FileMenu.getItems().addAll(filemenu1,filemenu2,filemenu3);  
                menubar.getMenus().addAll(FileMenu,EditMenu);  
                        
                Button btnClose = new Button("Close");
                btnClose.setMinWidth(150);
                btnClose.setMinHeight(25);
                btnClose.setOnAction(new EventHandler<ActionEvent>() { 
                    public void handle(ActionEvent event) {
                        //System.exit(0);
                        //Platform.exit();
                        stageSeler.close();
                    }
                });
                //Menu bottom
                HBox bottomPane = new HBox(btnClose);
                bottomPane.setAlignment(Pos.BASELINE_RIGHT);
                bottomPane.setStyle("-fx-padding: 10;");
                
                root.setTop(menubar);
                root.setCenter(centerPane);
                root.setRight(rightPane);
                root.setLeft(leftPane);
                root.setBottom(bottomPane);
                
                stageSeler.setScene(scene);  
                stageSeler.show();
            }
    });
//////////////////////////////end SelerMenu////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

//////////////////////////////ViewDataMenu/////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    btnViewData.setOnAction(new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent event) {                
                Stage stageView = new Stage();
            }
    });
//////////////////////////////end ViewDataMenu//////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

//////////////////////////////CalcMenu//////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
        btnCalc.setOnAction(new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent event) {                
                Stage stageCalc = new Stage();
            }
    });
//////////////////////////////end Calc//Menu////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    btnSetting_bottom.setOnAction(new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent event) {                
                Stage stageSetting = new Stage();
            }
    });
    btnUpdata_bottom.setOnAction(new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent event) {                
                Stage stageCalc = new Stage();
            }
    });
    btnExit_bottom.setOnAction(new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Exit");
                alert.setHeaderText("Are You sure want to exit?");
                alert.setContentText("Click \"ok\" to exit the application.");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    // ... user chose OK
                    System.exit(0);
                } else {
                // ... user chose CANCEL or closed the dialog
                }                
            }
    });

    root.add(mb, 0,0,11,1);
    root.add(rectBaner, 3,1, 5,2);
    root.add(scrPane, 3,3, 5,6);
    root.add(btnShopMenu, 1,2, 1,2);
    root.add(btnSelerMenu, 1,4, 1,2);
    root.add(btnViewData, 1,6, 1,2);
    root.add(btnCalc, 1,8, 1,2);
    root.add(dateLabelCurent_right, 9,1);
    root.add(dateLabelCurent_value, 9,2);
    root.add(dateLabelEdit_right, 9,3);
    root.add(dateLabelEdit_value, 9,4);
    root.add(goalLabel_right, 9,5);
    root.add(goalLabel_value, 9,6);
    root.add(bestShopLabel_right, 9,7);
    root.add(bestShopLabel_value, 9,8);
    root.add(rectBanerOboiColor, 1,11, 9,1);
    root.add(btnSetting_bottom, 1,13);
    root.add(btnUpdata_bottom, 3,13);
    root.add(btnPrev, 4,9);
    root.add(btnNext, 5,9);
    root.add(btnExit_bottom, 8,13, 2,1);
       
    primaryStage.setTitle("OboiColorShop");
    primaryStage.setScene(scene);		
    primaryStage.show();
    }
////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        launch(args);
    }
////////////////////////////////////////////////////////////////////////////////
    
////////////////////////////////////////////////////////////////////////////////
///////////////////////////Intro Shop Window////////////////////////////////////
    private GridPane getCenterPaneIntroShopWindow() {
            
            GridPane root=new GridPane();            
            root.setGridLinesVisible(false);
            root.setHgap(10);
            root.setVgap(5);
        
            Label infoAboutSeller_label=new Label("This section will be contain total info about Shops");
            GridPane.setHalignment(infoAboutSeller_label, HPos.CENTER);
        
            root.add(infoAboutSeller_label, 0,0);
            
            return root;
        }
///////////////////////////end Intro Shop Window////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
///////////////////////////Intro Seler Window///////////////////////////////////
    private VBox getCenterPaneIntroSelerWindow() {
           
            VBox root = new VBox();
           
            numberOfEmployee = seller.size();
            String numberOfEmployee_str=("Number of employee: ");
            String numberOfEmployee_decimal = decimalFormat.format(numberOfEmployee);
            Label numberOfEmployee_value = new Label();
            numberOfEmployee_value.setText(numberOfEmployee_str+" "+numberOfEmployee_decimal);
            
            // total number of seller
            root.getChildren().addAll(numberOfEmployee_value);
            
            if(seller.size()!=0){
                for(int j=0; j<seller.size(); j++){
                    Seller sel = seller.get(j);
                    firstNameEmployee = sel.getFirstName();
                    lastNameEmployee = sel.getLastName();
                    String result = ((j+1) +" "+firstNameEmployee+" "+lastNameEmployee );
                    Label name_label = new Label(result);
                    root.getChildren().addAll(name_label);                    
                }
            }            
            return root;
        }
////////////////////////////end Intro Seler Window//////////////////////////////
////////////////////////////////////////////////////////////////////////////////    

////////////////////////////////////////////////////////////////////////////////
///////////////////////Seler Menu///////////////////////////////////////////////    
    private BorderPane getCenterPaneSelerMenu_btnSelerInfo(){
        
        BorderPane CenterPaneSelerMenu = new BorderPane();
        
        //Node topPane = null;
        //Node bottomPane = null;
        //Node rightPane = null;
        Node centerPane =  getCenterPaneIntroSelerWindow();  
        BorderPane.setMargin(centerPane, new Insets(150,0,0,160));
        //Node leftPane = getLeftPaneSelerMenu_btnSelerInfo();
        
        Button btnAddInvoice = new Button("Add Invoice");
        btnAddInvoice.setMinWidth(150);
        btnAddInvoice.setMinHeight(50);
        btnAddInvoice.setOnAction(new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent event) {
                
                GridPane root=new GridPane();
                root.setGridLinesVisible(false);
                BorderPane.setMargin(root, new Insets(10,0,0,10));                
                root.setHgap(10);
                root.setVgap(5);
                
                //Label userLogView_label = new Label("[Add] <Seller> <Date> <#num> <Amount>"
                //        + "\n[Add] <Seller> <Date> <#num> <Amount>"
                //        + "\n[Del] <Seller> <Date> <#num> <Amount>"
                //        + "\n[Add] <Seller> <Date> <#num> <Amount>"
                //        + "\n[Add] <Seller> <Date> <#num> <Amount>");
                Label userLogView_label = new Label();
                ScrollPane spViewUserLog = new ScrollPane();
                spViewUserLog.setMinWidth(350);
                spViewUserLog.setMinHeight(180);
                
                DatePicker dateOfSalesDatePicker =  new DatePicker();
                Locale.setDefault(Locale.GERMANY);  
                dateOfSalesDatePicker.setValue(LocalDate.now());
                dateOfSalesDatePicker.setOnAction(new EventHandler() {
                    public void handle(Event t) {
                        dateReceipt = dateOfSalesDatePicker.getValue();
                    }
                });
        
                Rectangle photoLabel = new Rectangle(130, 150);
                GridPane.setHalignment(photoLabel, HPos.CENTER); 
                Label SelerName_label=new Label("Seler Name");  
                Label dateSales_label=new Label("Date of sale");
                Label invoiceNumber_label=new Label("Invoice Number");
                Label invoiceAmount_label=new Label("Invoice Amount");
        
                //ObservableList<String> nameSeler = FXCollections.observableArrayList( "001 Igor", "002 Oksana", "004 Irina", "005 Natalia");
                ComboBox<String> cbChoiceSelerName=new ComboBox<String>(getSellerList());  
                cbChoiceSelerName.setValue(" Choice seler name ");
                    cbChoiceSelerName.setOnAction(new EventHandler<ActionEvent>(){
                        public void handle(ActionEvent ae){
                            sellerTotalName = cbChoiceSelerName.getValue();
                        }
                    });
                    
                TextField tfInvoiceNumber=new TextField();
                    tfInvoiceNumber.setOnAction(new EventHandler<ActionEvent>(){
                        public void handle(ActionEvent ae){
                            numberReceipt = Integer.parseInt( tfInvoiceNumber.getText() );
                        }
                    });
                
                TextField tfInvoiceAmount=new TextField();
                    tfInvoiceAmount.setOnAction(new EventHandler<ActionEvent>(){
                        public void handle(ActionEvent ae){
                            amountReceipt = Double.parseDouble( tfInvoiceAmount.getText() );
                        }
                    });
                
                Button btnUndoLast=new Button ("Undo Last");   
                GridPane.setHalignment(btnUndoLast, HPos.CENTER); 
                btnUndoLast.setMinWidth(100);
                btnUndoLast.setMinHeight(25);
                
                Button btnAddInvoice=new Button ("Add Invoice");
                GridPane.setHalignment(btnAddInvoice, HPos.CENTER); 
                btnAddInvoice.setMinWidth(150);
                btnAddInvoice.setMinHeight(50);
                btnAddInvoice.setOnAction(new EventHandler<ActionEvent>() { 
                    public void handle(ActionEvent event) {
                        
                        Receipt receipt = new Receipt(dateReceipt, numberReceipt, amountReceipt);
                        
                        Alert alert = new Alert(AlertType.CONFIRMATION);
                        alert.setTitle("Add Receipt");
                        alert.setHeaderText("Name: "+sellerTotalName);
                        alert.setContentText("Date: "+dateReceipt+"\nReceipt: #"+numberReceipt+"\nAmount: "+amountReceipt+" rub.");
                            
                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.get() == ButtonType.OK){
                            userLogView_label.setText("[Add] <"+sellerTotalName+"> <"+dateReceipt+"> <"+numberReceipt+"> <"+amountReceipt+">");
                            spViewUserLog.setContent(userLogView_label);
                        } else {
                            // ... user chose CANCEL or closed the dialog
                            userLogView_label.setText("");
                        }
                    }
                    });
                
                Button btnClean=new Button ("Clean");
                GridPane.setHalignment(btnClean, HPos.CENTER); 
                btnClean.setMinWidth(100);
                btnClean.setMinHeight(25);
            
                root.add(photoLabel, 0,0, 1,6);
                root.add(SelerName_label, 3,0);
                root.add(cbChoiceSelerName, 4,0);
                root.add(dateSales_label,3,1);
                root.add(dateOfSalesDatePicker, 4,1);
                root.add(invoiceNumber_label, 3,2);
                root.add(tfInvoiceNumber, 4,2);
                root.add(invoiceAmount_label, 3,3); 
                root.add(tfInvoiceAmount, 4,3);
                root.add(btnAddInvoice, 3,5, 2,2);
                root.add(spViewUserLog, 0,8, 23,1);
                root.add(btnClean, 0,9, 1,1);
                root.add(btnUndoLast, 1,9, 3,1);
        
                CenterPaneSelerMenu.setCenter(root);
            }
        });
////////////////////////////////////////////////////////////////////////////////        
        Button btnViewSeler = new Button("View Seler Data");
        btnViewSeler.setMinWidth(150);
        btnViewSeler.setMinHeight(50); 
        btnViewSeler.setOnAction(new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent event) {
                
                GridPane root=new GridPane();
                root.setGridLinesVisible(false);
                BorderPane.setMargin(root, new Insets(10,0,0,10));                
                root.setHgap(10);
                root.setVgap(5);
                
                Label viewDataDiagrem_label = new Label(" [ Here will be view data diagramm ] ");
                ScrollPane spUserDiagram = new ScrollPane(viewDataDiagrem_label);
                spUserDiagram.setMinWidth(350);
                spUserDiagram.setMinHeight(180);
                
                DatePicker checkInDatePicker =  new DatePicker();
                Locale.setDefault(Locale.GERMANY);  
                //checkInDatePicker.setValue(LocalDate.now());
                DatePicker checkOutDatePicker =  new DatePicker();
                Locale.setDefault(Locale.GERMANY);  
                //checkOutDatePicker.setValue(LocalDate.now());
        
                Rectangle photoLabel = new Rectangle(130, 150);
                GridPane.setHalignment(photoLabel, HPos.CENTER); 
        
                Label fromData_label=new Label("from");
                Label toDate_label=new Label("to");
        
                //ObservableList<String> nameSeler = FXCollections.observableArrayList( "All", "001 Igor", "002 Oksana", "004 Irina", "005 Natalia");
                ComboBox<String> cbChoiceSelerName=new ComboBox<String>(getSellerList());  
                cbChoiceSelerName.setValue(" Choice seler name ");
                GridPane.setHalignment(cbChoiceSelerName, HPos.CENTER);
                cbChoiceSelerName.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(ActionEvent ae){
                        sellerNameFromList = cbChoiceSelerName.getValue();
                    }
                });
                        
                
                Button btnViewData=new Button ("View Data");   
                GridPane.setHalignment(btnViewData, HPos.CENTER); 
                btnViewData.setMinWidth(200);
                btnViewData.setMinHeight(50);
                
                Button btnDiscard=new Button ("Discard");
                GridPane.setHalignment(btnDiscard, HPos.CENTER); 
                btnDiscard.setMinWidth(100);
                btnDiscard.setMinHeight(25);
                
                Button btnSelerPrivateInfo=new Button ("Private Info");
                GridPane.setHalignment(btnSelerPrivateInfo, HPos.CENTER); 
                btnSelerPrivateInfo.setMinWidth(100);
                btnSelerPrivateInfo.setMinHeight(25);
                    btnSelerPrivateInfo.setOnAction(new EventHandler<ActionEvent>() { 
                        public void handle(ActionEvent event) {
                            showPrivateInfoSeller(sellerNameFromList);
                        }
                });
        
                CheckBox chekEverybody = new CheckBox("everybody");
                GridPane.setHalignment(chekEverybody, HPos.CENTER);
                chekEverybody.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(ActionEvent ae){
                    
                    }
                });
        
                root.add(photoLabel, 0,0, 1,6);
                root.add(btnSelerPrivateInfo, 4,0);
                root.add(cbChoiceSelerName, 3,0);
                root.add(chekEverybody, 3,1);
                root.add(fromData_label, 3, 2);
                root.add(checkInDatePicker, 3, 3);
                root.add(toDate_label, 4, 2);
                root.add(checkOutDatePicker, 4, 3);
                root.add(btnViewData, 3,5, 2,2);
                root.add(spUserDiagram, 0,8, 14,1);
                root.add(btnDiscard, 0,9);
        
                CenterPaneSelerMenu.setCenter(root);
            }
        });
////////////////////////////////////////////////////////////////////////////////        
        Button btnAddSeler = new Button("Add new Seler");
        btnAddSeler.setMinWidth(150);
        btnAddSeler.setMinHeight(50);
        btnAddSeler.setOnAction(new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent event) {
                
                DatePicker dateBirthDatePicker =  new DatePicker();
                Locale.setDefault(Locale.GERMANY);  
                dateBirthDatePicker.setOnAction(new EventHandler() {
                    public void handle(Event t) {
                        dateBirthEmployee = dateBirthDatePicker.getValue();
                    }
                });
                
                DatePicker dateEmplDatePicker =  new DatePicker();
                Locale.setDefault(Locale.GERMANY);  
                dateEmplDatePicker.setOnAction(new EventHandler() {
                    public void handle(Event t) {
                        dateOfEmplEmployee = dateEmplDatePicker.getValue();
                    }
                });                
                
                Rectangle photoLabel = new Rectangle(130, 150);
                Label firstName_label=new Label("First Name");  
                Label lastName_label=new Label("Last Name");
                Label workPlace_label=new Label("Work Place");
                Label employeePosition_label=new Label("Employee position");
                Label employeePositionRank_label=new Label("Rank");
                Label dateBirth_label=new Label("Date of Birth");
                Label dateEmpl_label=new Label("Employment date");
                Label phoneNumber_label=new Label("Phone number");
                Label employeeHomeAdress_label=new Label("Home Adress");
        
                TextField tfFirstName=new TextField();  
                    tfFirstName.setOnAction(new EventHandler<ActionEvent>(){
                        public void handle(ActionEvent ae){
                            firstNameEmployee = tfFirstName.getText();
                        }
                    });
                    
                TextField tfLastName=new TextField();
                    tfLastName.setOnAction(new EventHandler<ActionEvent>(){
                        public void handle(ActionEvent ae){
                            lastNameEmployee = tfLastName.getText();
                        }
                    });
                    
                TextField tfEmployeePosition=new TextField();
                    tfEmployeePosition.setOnAction(new EventHandler<ActionEvent>(){
                        public void handle(ActionEvent ae){
                            employeePosition = tfEmployeePosition.getText();
                        }
                    });
                    
                TextField tfEmployeePositionRank=new TextField();
                    tfEmployeePositionRank.setOnAction(new EventHandler<ActionEvent>(){
                        public void handle(ActionEvent ae){
                            employeeRank = tfEmployeePositionRank.getText();
                        }
                    });
                
                TextField tfPhoneNumber=new TextField();
                     tfPhoneNumber.setOnAction(new EventHandler<ActionEvent>(){
                        public void handle(ActionEvent ae){
                            phoneEmployee = tfPhoneNumber.getText();
                        }
                    });
                
                ComboBox<String> cbChoiceSellerName=new ComboBox<String>(getSellerList());  
                cbChoiceSellerName.setValue(" Shop Address");
                    cbChoiceSellerName.setOnAction(new EventHandler<ActionEvent>(){
                        public void handle(ActionEvent ae){
                            workPlaceEmployee = cbChoiceSellerName.getValue();
                        }
                    });
                
                TextArea taHomeAddressSeler = new TextArea();
                taHomeAddressSeler.setPrefColumnCount(30);
                taHomeAddressSeler.setPrefRowCount(3);
                VBox.setVgrow(taHomeAddressSeler, Priority.ALWAYS);
                    addressEmployee = taHomeAddressSeler.getText();
                
                Button btnChangePhoto=new Button ("add photo"); 
                GridPane.setHalignment(btnChangePhoto, HPos.CENTER); 
                btnChangePhoto.setMinWidth(100);
                btnChangePhoto.setMinHeight(25);
                
                Button btnDiscard=new Button ("discard");
                GridPane.setHalignment(btnDiscard, HPos.CENTER); 
                btnDiscard.setMinWidth(200);
                btnDiscard.setMinHeight(25);
                
                Button btnSave=new Button ("save");
                GridPane.setHalignment(btnSave, HPos.CENTER); 
                btnSave.setMinWidth(200);
                btnSave.setMinHeight(50);
                btnSave.setOnAction(new EventHandler<ActionEvent>() { 
                    public void handle(ActionEvent event) {
                        Seller newSeller = new Seller(  
                                firstNameEmployee,
                                lastNameEmployee,
                                workPlaceEmployee,
                                employeePosition,
                                employeeRank,
                                dateBirthEmployee,
                                dateOfEmplEmployee,
                                phoneEmployee,
                                addressEmployee
                        );
                        seller.add(newSeller);
                        counterOfEmployee = newSeller.getCounterOfSeller();
                        firstNameEmployee = newSeller.getFirstName();
                        lastNameEmployee = newSeller.getLastName();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Add successful");
                        alert.setHeaderText(null);
                        alert.setContentText("New Seller was added: \n#"+counterOfEmployee+" "+firstNameEmployee+" "+lastNameEmployee);
                        alert.showAndWait();
                    }
                });
        
                GridPane root=new GridPane();
                root.setGridLinesVisible(false);
                BorderPane.setMargin(root, new Insets(20,0,0,0));
                
                root.setHgap(10);
                root.setVgap(5);
        
                root.add(photoLabel, 0,0, 1,6);
                root.add(btnChangePhoto, 0,6);
                root.add(firstName_label, 2,0);
                root.add(tfFirstName, 3,0);
                root.add(lastName_label, 2,1);
                root.add(tfLastName, 3,1);
                root.add(workPlace_label, 2,2);
                root.add(cbChoiceSellerName, 3,2);
                root.add(employeePosition_label, 2,3); 
                root.add(tfEmployeePosition, 3,3);
                root.add(employeePositionRank_label, 2,4);
                root.add(tfEmployeePositionRank, 3,4);
                root.add(dateBirth_label, 2,5);
                root.add(dateBirthDatePicker, 3,5);
                root.add(dateEmpl_label, 2,6);
                root.add(dateEmplDatePicker, 3,6);
                root.add(phoneNumber_label, 2,7);
                root.add(tfPhoneNumber, 3,7);
                root.add(employeeHomeAdress_label, 2,8);
                root.add(taHomeAddressSeler, 3,8);
                root.add(btnSave, 0,11, 4,1);
                root.add(btnDiscard, 0,13, 4,1);
                
                CenterPaneSelerMenu.setCenter(root);
                
            }
        });        
////////////////////////////////////////////////////////////////////////////////        
        Button btnDelSeler = new Button("Delete Seler");
        btnDelSeler.setMinWidth(150);
        btnDelSeler.setMinHeight(50);
        btnDelSeler.setOnAction(new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent event) {
                
                GridPane root=new GridPane();
                root.setGridLinesVisible(false);
                BorderPane.setMargin(root, new Insets(100,0,0,80));
                
                root.setHgap(10);
                root.setVgap(5);
        
                Label selerForDelete_label=new Label("Selecting a Seller to remove");
                GridPane.setHalignment(selerForDelete_label, HPos.CENTER);
        
                //ObservableList<String> nameSeler = FXCollections.observableArrayList( "All", "001 Igor", "002 Oksana", "004 Irina", "005 Natalia");
                ComboBox<String> cbChoiceSelerName=new ComboBox<String>(getSellerList());  
                cbChoiceSelerName.setValue(" Select seller name ");
                GridPane.setHalignment(cbChoiceSelerName, HPos.CENTER); 
                CheckBox chekEverybody = new CheckBox("everybody");
                GridPane.setHalignment(chekEverybody, HPos.CENTER);
                chekEverybody.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(ActionEvent ae){
                
                    }
                });
        
            Button btnDeleteSeler=new Button ("Delete");   
            GridPane.setHalignment(btnDeleteSeler, HPos.CENTER); 
            btnDeleteSeler.setMinWidth(200);
            btnDeleteSeler.setMinHeight(25);
            btnDeleteSeler.setOnAction(new EventHandler<ActionEvent>(){
                public void handle(ActionEvent ae){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Remove");
                    alert.setHeaderText("Are You sure want move seller data to delete?");
                    alert.setContentText("Click \"ok\" to delete data.");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK){
                        // ... user chose OK
                    } else {
                        // ... user chose CANCEL or closed the dialog
                    }   
                }
            });
            Button btnMoveToArchiveSeler=new Button ("Archive");
            GridPane.setHalignment(btnMoveToArchiveSeler, HPos.CENTER); 
            btnMoveToArchiveSeler.setMinWidth(200);
            btnMoveToArchiveSeler.setMinHeight(25);
            btnMoveToArchiveSeler.setOnAction(new EventHandler<ActionEvent>(){
                public void handle(ActionEvent ae){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Remove");
                    alert.setHeaderText("Are You sure want move seller data to archive?");
                    alert.setContentText("Click \"ok\" to move data to archive.");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK){
                        // ... user chose OK
                    } else {
                        // ... user chose CANCEL or closed the dialog
                    }   
            
                }
            });
        
            root.add(selerForDelete_label, 0,0, 3,1);
            root.add(cbChoiceSelerName, 1,3, 3,1);
            root.add(chekEverybody, 1,5, 3,1);
            root.add(btnDeleteSeler, 2, 8);
            root.add(btnMoveToArchiveSeler, 1, 8);
        
            CenterPaneSelerMenu.setCenter(root);
            
            }
        });
        
        Label spaceLabel_1 = new Label("");
        Label spaceLabel_2 = new Label("");
        Label spaceLabel_3 = new Label("");
        Label spaceLabel_4 = new Label("");
                
        VBox leftPane = new VBox(btnAddInvoice,spaceLabel_1,btnViewSeler,spaceLabel_2,btnAddSeler,spaceLabel_3,btnDelSeler);
        leftPane.setStyle("-fx-padding: 10;");
        
        CenterPaneSelerMenu.setLeft(leftPane);
        CenterPaneSelerMenu.setCenter(centerPane);
        
        return CenterPaneSelerMenu;
    }
//////////////////////////////end Seler Menu//////////////////////////////////
////////////////////////////////////////////////////////////////////////////////    

////////////////////////////////////////////////////////////////////////////////
////////////////////////////Shop Menu/////////////////////////////////////////
    private BorderPane getCenterPaneShopMenu_btnShopInfo(){
        
        BorderPane CenterPaneShopMenu = new BorderPane();
        
        //Node topPane = null;
        //Node bottomPane = null;
        //Node rightPane = null;
        Node centerPane = getCenterPaneIntroShopWindow();        
        BorderPane.setMargin(centerPane, new Insets(150,0,0,160));
        //Node leftPane = getLeftPaneSelerMenu_btnSelerInfo();
        
        Button btnAddInvoice = new Button("Add Invoice");
        btnAddInvoice.setMinWidth(150);
        btnAddInvoice.setMinHeight(50);
        btnAddInvoice.setOnAction(new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent event) {
                
                GridPane root=new GridPane();
                root.setGridLinesVisible(false);
                BorderPane.setMargin(root, new Insets(10,0,0,10));                
                root.setHgap(10);
                root.setVgap(5);
        
                DatePicker proceedsDayDatePicker =  new DatePicker();
                Locale.setDefault(Locale.GERMANY);  
                proceedsDayDatePicker.setValue(LocalDate.now());
                
                Rectangle photoLabel = new Rectangle(250, 150);
                GridPane.setHalignment(photoLabel, HPos.CENTER); 
                Label ShopName_label=new Label("Shop Name");  
                Label proceedsDay_label=new Label("Proceeds for day");
                Label proceedsAmount_label=new Label("Proceeds Amount");
                
                Label userLogView_label = new Label("[Add] <Shop> <Date> <Amount>\n[Add] <Shop> <Date> <Amount>\n[Del] <Shop> <Date> <Amount>\n[Add] <Shop> <Date> <Amount>\n[Add] <Shop> <Date> <Amount>");
                ScrollPane spViewUserLog = new ScrollPane(userLogView_label);
                spViewUserLog.setMinWidth(350);
                spViewUserLog.setMinHeight(200);
                
                //ObservableList<String> nameShop = FXCollections.observableArrayList( "001 Minsk", "002 Gomel", "004 Mogilev", "005 Brest");
                ComboBox<String> cbChoiceShopName=new ComboBox<String>(nameShop);  
                cbChoiceShopName.setValue(" Choice shop name ");
                TextField tfProceedsAmount=new TextField();
        
                Button btnUndoLast=new Button ("Undo Last");   
                GridPane.setHalignment(btnUndoLast, HPos.CENTER); 
                btnUndoLast.setMinWidth(100);
                btnUndoLast.setMinHeight(25);
                Button btnAddInvoice=new Button ("Add Invoice");
                GridPane.setHalignment(btnAddInvoice, HPos.CENTER); 
                btnAddInvoice.setMinWidth(150);
                btnAddInvoice.setMinHeight(50);
                Button btnClean=new Button ("Clean");
                GridPane.setHalignment(btnClean, HPos.CENTER); 
                btnClean.setMinWidth(100);
                btnClean.setMinHeight(25);
        
                root.add(photoLabel, 0,0, 3,6);
                root.add(ShopName_label, 3,0);
                root.add(cbChoiceShopName, 4,0);
                root.add(proceedsDay_label, 3,1);
                root.add(proceedsDayDatePicker, 4,1);
                //root.add(invoiceNumber, 0,3);
                //root.add(tfInvoiceNumber, 1,3);
                root.add(proceedsAmount_label, 3,2); 
                root.add(tfProceedsAmount, 4,2);
                root.add(btnAddInvoice, 3,5, 2,1);
                root.add(spViewUserLog, 0,8, 5,1);
                root.add(btnClean, 0,11);
                root.add(btnUndoLast, 1,11);
        
                CenterPaneShopMenu.setCenter(root);
            }
        });
        Button btnViewShop = new Button("View Shop Data");
        btnViewShop.setMinWidth(150);
        btnViewShop.setMinHeight(50);
        btnViewShop.setOnAction(new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent event) {
                
                GridPane root=new GridPane();
                root.setGridLinesVisible(false);    
                BorderPane.setMargin(root, new Insets(10,0,0,10));                
                root.setHgap(10);
                root.setVgap(5);
        
                DatePicker checkInDatePicker =  new DatePicker();
                Locale.setDefault(Locale.GERMANY);
               
                //dateBirthDatePicker.setValue(LocalDate.now());
                DatePicker checkOutDatePicker =  new DatePicker();
                Locale.setDefault(Locale.GERMANY);  
                //dateEmplDatePicker.setValue(LocalDate.now());
                
                Rectangle photoLabel = new Rectangle(250, 150);
                GridPane.setHalignment(photoLabel, HPos.CENTER); 
        
                Label viewDataDiagram_label = new Label("[ Here will be view data diagramm ]");
                ScrollPane spViewDataDiagram = new ScrollPane(viewDataDiagram_label);
                spViewDataDiagram.setMinWidth(350);
                spViewDataDiagram.setMinHeight(180);
                
                Label fromData_label=new Label("from");
                Label toDate_label=new Label("to");
                
                //ObservableList<String> nameSeler = FXCollections.observableArrayList( "All", "001 Igor", "002 Oksana", "004 Irina", "005 Natalia");
                ComboBox<String> cbChoiceShopName=new ComboBox<String>(nameShop);  
                cbChoiceShopName.setValue(" Choice shop name ");
                GridPane.setHalignment(cbChoiceShopName, HPos.CENTER); 
        
                Button btnViewData=new Button ("View Data");   
                GridPane.setHalignment(btnViewData, HPos.CENTER); 
                btnViewData.setMinWidth(150);
                btnViewData.setMinHeight(50);
                Button btnDiscard=new Button ("Discard");
                GridPane.setHalignment(btnDiscard, HPos.CENTER); 
                btnDiscard.setMinWidth(125);
                btnDiscard.setMinHeight(25);
                Button btnShopPrivateInfo=new Button ("Private Info");
                GridPane.setHalignment(btnShopPrivateInfo, HPos.CENTER); 
                btnShopPrivateInfo.setMinWidth(125);
                btnShopPrivateInfo.setMinHeight(25);
        
                CheckBox chekEverybody = new CheckBox("everybody");
                GridPane.setHalignment(chekEverybody, HPos.CENTER);
                chekEverybody.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(ActionEvent ae){
                
                    }
                });
        
                root.add(photoLabel, 0,0, 1,6);
                root.add(btnShopPrivateInfo, 2,0);
                root.add(cbChoiceShopName, 1,0);
                root.add(chekEverybody, 1,1);
                root.add(fromData_label, 1,2);
                root.add(checkInDatePicker, 1,3);
                root.add(toDate_label, 2,2);
                root.add(checkOutDatePicker, 2,3);
                root.add(btnViewData, 1,5, 2,2);
                root.add(spViewDataDiagram, 0,7, 4,1);
                root.add(btnDiscard, 0,8);
                
                CenterPaneShopMenu.setCenter(root);
            }
        });
        Button btnAddShop = new Button("Add new Shop");
        btnAddShop.setMinWidth(150);
        btnAddShop.setMinHeight(50);
        btnAddShop.setOnAction(new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent event) {
                Rectangle photoLabel = new Rectangle(140, 90);
                Label shopName_label=new Label("Shop Name");  
                Label shopManagerName_label=new Label("Manager Name");
                Label dateBirth_label=new Label("Date of Birth");
                Label phoneNumber_label=new Label("Phone number");
                Label shopAdress_label=new Label("Shop Adress");
        
                DatePicker dateBirthDatePicker =  new DatePicker();
                Locale.setDefault(Locale.GERMANY);  
                
                TextField tfShopName=new TextField();  
                TextField tfShopManagerName=new TextField();
                TextField tfPhoneNumber=new TextField();
                TextArea taAdressShop = new TextArea();
                taAdressShop.setPrefColumnCount(30);
                taAdressShop.setPrefRowCount(3);
                VBox.setVgrow(taAdressShop, Priority.ALWAYS);
        
                Button btnChangePhoto=new Button ("add photo"); 
                GridPane.setHalignment(btnChangePhoto, HPos.CENTER); 
                btnChangePhoto.setMinWidth(100);
                btnChangePhoto.setMinHeight(25);
                Button btnDiscard=new Button ("Discard");
                GridPane.setHalignment(btnDiscard, HPos.CENTER); 
                btnDiscard.setMinWidth(200);
                btnDiscard.setMinHeight(25);
                Button btnSave=new Button ("Save");
                GridPane.setHalignment(btnSave, HPos.CENTER); 
                btnSave.setMinWidth(200);
                btnSave.setMinHeight(50);
        
                GridPane root=new GridPane();
                root.setGridLinesVisible(false);    
                BorderPane.setMargin(root, new Insets(30,0,0,0));
                
                root.setHgap(10);
                root.setVgap(5);
        
                //Scene scene = new Scene(root,630,500);  
                root.add(photoLabel, 0,0, 1,4);
                root.add(btnChangePhoto, 0,4);
                root.add(shopName_label, 2,0);
                root.add(tfShopName, 3,0);
                root.add(shopManagerName_label, 2,1);
                root.add(tfShopManagerName, 3,1);
                root.add(dateBirth_label, 2,3); 
                root.add(dateBirthDatePicker, 3,3);
                root.add(phoneNumber_label, 2,4);
                root.add(tfPhoneNumber, 3,4);
                root.add(shopAdress_label, 2,5);
                root.add(taAdressShop, 3,5);
                
                root.add(btnSave, 0,11, 4,1);
                root.add(btnDiscard, 0,13, 4,1);
                
                CenterPaneShopMenu.setCenter(root);
            }
        });        
        Button btnDelShop = new Button("Delete Shop");
        btnDelShop.setMinWidth(150);
        btnDelShop.setMinHeight(50);
        btnDelShop.setOnAction(new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent event) {
                
                GridPane root=new GridPane();
                root.setGridLinesVisible(false);    
                BorderPane.setMargin(root, new Insets(100,0,0,80));
                
                root.setHgap(10);
                root.setVgap(5);
        
                Label selerForDelete_label=new Label("Selecting a Shop to remove");
                GridPane.setHalignment(selerForDelete_label, HPos.CENTER);
        
                //ObservableList<String> nameSeler = FXCollections.observableArrayList( "All", "001 Igor", "002 Oksana", "004 Irina", "005 Natalia");
                ComboBox<String> cbChoiceShopName=new ComboBox<String>(nameShop);  
                cbChoiceShopName.setValue(" Select shop name ");
                GridPane.setHalignment(cbChoiceShopName, HPos.CENTER); 
                CheckBox chekEverybody = new CheckBox("everybody");
                GridPane.setHalignment(chekEverybody, HPos.CENTER);
                chekEverybody.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(ActionEvent ae){
                
                    }
                });
        
            Button btnDeleteSeler=new Button ("Delete");   
            GridPane.setHalignment(btnDeleteSeler, HPos.CENTER); 
            btnDeleteSeler.setMinWidth(200);
            btnDeleteSeler.setMinHeight(25);
            btnDeleteSeler.setOnAction(new EventHandler<ActionEvent>(){
                public void handle(ActionEvent ae){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Remove");
                    alert.setHeaderText("Are You sure want move Shop data to delete?");
                    alert.setContentText("Click \"ok\" to delete data.");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK){
                        // ... user chose OK
                    } else {
                        // ... user chose CANCEL or closed the dialog
                    }   
                }
            });
            Button btnMoveToArchiveSeler=new Button ("Archive");
            GridPane.setHalignment(btnMoveToArchiveSeler, HPos.CENTER); 
            btnMoveToArchiveSeler.setMinWidth(200);
            btnMoveToArchiveSeler.setMinHeight(25);
            btnMoveToArchiveSeler.setOnAction(new EventHandler<ActionEvent>(){
                public void handle(ActionEvent ae){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Remove");
                    alert.setHeaderText("Are You sure want move Shop data to archive?");
                    alert.setContentText("Click \"ok\" to move data to archive.");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK){
                        // ... user chose OK
                    } else {
                        // ... user chose CANCEL or closed the dialog
                    }   
            
                }
            });        
           
            root.add(selerForDelete_label, 0,0, 3,1);
            root.add(cbChoiceShopName, 1,3, 3,1);
            root.add(chekEverybody, 1,5, 3,1);
            root.add(btnDeleteSeler, 2, 8);
            root.add(btnMoveToArchiveSeler, 1, 8);
        
            CenterPaneShopMenu.setCenter(root); 
            }
        });
        
        VBox leftPane = new VBox(btnAddInvoice,btnViewShop,btnAddShop,btnDelShop);
        leftPane.setStyle("-fx-padding: 10;");
        
        CenterPaneShopMenu.setLeft(leftPane);
        CenterPaneShopMenu.setCenter(centerPane);
        
        return CenterPaneShopMenu;
    }
//////////////////////////////end Shop Menu/////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////    

// for ComboBox
ObservableList<String> getSellerList(){
    String sellerList[] = new String[5];
    for(int j=0; j<seller.size(); j++){
        Seller sel = new Seller();
        sel = seller.get(j);        
        sellerList[j] =sel.getFirstName()+" "+sel.getLastName();
    }    
    ObservableList<String> nameShop = FXCollections.observableArrayList(
            sellerList[0], sellerList[1], sellerList[2], sellerList[3], sellerList[4]);    
    return nameShop;
}

void showPrivateInfoSeller(String name){
    
    int indexSeller=0;
    Seller sel = new Seller();
        for(int j=0; j<seller.size(); j++){
            sel = seller.get(j);
            if(sellerNameFromList.equals(sel.getFirstName()+" "+sel.getLastName())){
                indexSeller = j;
            }
        }
    sel = seller.get(indexSeller);
        
    Stage privateInfoSeller = new Stage();
    privateInfoSeller.setResizable(true);
    
    GridPane gpSellerInfo = new GridPane();
    gpSellerInfo.setHgap(10);
    gpSellerInfo.setVgap(5);		
    gpSellerInfo.setGridLinesVisible(false); 
    
    DatePicker dateBirthDatePicker =  new DatePicker();
    Locale.setDefault(Locale.GERMANY);  
    dateBirthDatePicker.setValue(sel.getDateBirth());
    
    DatePicker dateEmplDatePicker =  new DatePicker();
    Locale.setDefault(Locale.GERMANY);  
    dateEmplDatePicker.setValue(sel.getDateEmplpoee());
                
    Rectangle photoLabel = new Rectangle(130, 150);
    Label firstName_label=new Label("First Name");  
    Label lastName_label=new Label("Last Name");
    Label workPlace_label=new Label("Work Place");
    Label employeePosition_label=new Label("Employee position");
    Label employeePositionRank_label=new Label("Rank");
    Label dateBirth_label=new Label("Date of Birth");
    Label dateEmpl_label=new Label("Employment date");
    Label phoneNumber_label=new Label("Phone number");
    Label employeeHomeAdress_label=new Label("Home Adress");
        
    TextField tfFirstName=new TextField( sel.getFirstName() );  
    TextField tfLastName=new TextField( sel.getLastName() );
    TextField tfEmployeePosition=new TextField( sel.getEmployeePosition() );
    TextField tfEmployeePositionRank=new TextField( sel.getEmployeeRank() );
    TextField tfPhoneNumber=new TextField( sel.getPhoneEmployee() );
                
    ComboBox<String> cbChoiceSellerName=new ComboBox<String>(getSellerList());  
    cbChoiceSellerName.setValue(" Shop Address");
    cbChoiceSellerName.setOnAction(new EventHandler<ActionEvent>(){
        public void handle(ActionEvent ae){
            workPlaceEmployee = cbChoiceSellerName.getValue();
        }
    });
                
    TextArea taHomeAddressSeler = new TextArea( sel.getAddressEmployee() );
                
                Button btnChangePhoto=new Button ("Change"); 
                GridPane.setHalignment(btnChangePhoto, HPos.CENTER); 
                btnChangePhoto.setMinWidth(100);
                btnChangePhoto.setMinHeight(25);
                
                Button btnDiscard=new Button ("Discard");
                GridPane.setHalignment(btnDiscard, HPos.CENTER); 
                btnDiscard.setMinWidth(100);
                btnDiscard.setMinHeight(25);
                btnDiscard.setOnAction(new EventHandler<ActionEvent>() { 
                    public void handle(ActionEvent event) {
            
                   }
                });
                
                Button btnClose=new Button ("Close");
                GridPane.setHalignment(btnClose, HPos.CENTER); 
                btnClose.setMinWidth(100);
                btnClose.setMinHeight(25);
                btnClose.setOnAction(new EventHandler<ActionEvent>() { 
                    public void handle(ActionEvent event) {
                         privateInfoSeller.close();
                    }
                });
                
                Button btnSave=new Button ("Save");
                GridPane.setHalignment(btnSave, HPos.LEFT); 
                btnSave.setMinWidth(200);
                btnSave.setMinHeight(25);
                    btnSave.setOnAction(new EventHandler<ActionEvent>() { 
                        public void handle(ActionEvent event) {
            
                    }
                });
                
                gpSellerInfo.setHgap(10);
                gpSellerInfo.setVgap(5);
        
                gpSellerInfo.add(photoLabel, 1,0, 1,6);
                gpSellerInfo.add(btnChangePhoto, 0,6, 2,1);
                gpSellerInfo.add(firstName_label, 2,0);
                gpSellerInfo.add(tfFirstName, 3,0);
                gpSellerInfo.add(lastName_label, 2,1);
                gpSellerInfo.add(tfLastName, 3,1);
                gpSellerInfo.add(workPlace_label, 2,2);
                gpSellerInfo.add(cbChoiceSellerName, 3,2);
                gpSellerInfo.add(employeePosition_label, 2,3); 
                gpSellerInfo.add(tfEmployeePosition, 3,3);
                gpSellerInfo.add(employeePositionRank_label, 2,4);
                gpSellerInfo.add(tfEmployeePositionRank, 3,4);
                gpSellerInfo.add(dateBirth_label, 2,5);
                gpSellerInfo.add(dateBirthDatePicker, 3,5);
                gpSellerInfo.add(dateEmpl_label, 2,6);
                gpSellerInfo.add(dateEmplDatePicker, 3,6);
                gpSellerInfo.add(phoneNumber_label, 2,7);
                gpSellerInfo.add(tfPhoneNumber, 3,7);
                gpSellerInfo.add(employeeHomeAdress_label, 2,8);
                gpSellerInfo.add(taHomeAddressSeler, 3,8);
                gpSellerInfo.add(btnDiscard, 1,13, 2,1);
                gpSellerInfo.add(btnSave, 3,13);
                gpSellerInfo.add(btnClose, 4,13);
                
    Scene scene = new Scene(gpSellerInfo, 800, 380);
    privateInfoSeller.setTitle("Second Stage");
    privateInfoSeller.setScene(scene);
    
    privateInfoSeller.show();
    
}
     
} // end main class
