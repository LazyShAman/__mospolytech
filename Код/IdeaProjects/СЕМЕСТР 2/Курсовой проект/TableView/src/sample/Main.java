package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        TableView<UserAccount> table = new TableView<>();

        // Create column UserName (Data type of String).
        TableColumn<UserAccount, String> userNameCol //
                = new TableColumn<>("User Name");

        // Create column Email (Data type of String).
        TableColumn<UserAccount, String> emailCol//
                = new TableColumn<>("Email");

        // Create column FullName (Data type of String).
        TableColumn<UserAccount, String> fullNameCol//
                = new TableColumn<>("Full Name");

        // Create 2 sub column for FullName.
        TableColumn<UserAccount, String> firstNameCol//
                = new TableColumn<>("First Name");

        TableColumn<UserAccount, String> lastNameCol //
                = new TableColumn<>("Last Name");

        // Add sub columns to the FullName
        fullNameCol.getColumns().addAll(firstNameCol, lastNameCol);

        // Active Column
        TableColumn<UserAccount, Boolean> activeCol//
                = new TableColumn<>("Active");

        // Defines how to fill data for each cell.
        // Get value from property of UserAccount. .
        userNameCol.setCellValueFactory(new PropertyValueFactory<>("userName"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        activeCol.setCellValueFactory(new PropertyValueFactory<>("active"));

        // Set Sort type for userName column
        userNameCol.setSortType(TableColumn.SortType.DESCENDING);
        lastNameCol.setSortable(false);

        // Display row data
        ObservableList<UserAccount> list = getUserList();
        table.setItems(list);

        table.getColumns().addAll(userNameCol, emailCol, fullNameCol, activeCol);

        StackPane root = new StackPane();
        root.setPadding(new Insets(25));
        root.getChildren().add(table);

        stage.setTitle("TableView (o7planning.org)");

        Scene scene = new Scene(root, 450, 300);
        stage.setScene(scene);
        stage.show();
    }

    // DBConnection
    private ObservableList<UserAccount> getUserList() {

        UserAccount user1 = new UserAccount(1L, "smith", "smith@gmail.com", //
                "Susan", "Smith", true);
        UserAccount user2 = new UserAccount(2L, "mcneil", "mcneil@gmail.com", //
                "Anne", "McNeil", true);
        UserAccount user3 = new UserAccount(3L, "white", "white@gmail.com", //
                "Kenvin", "White", false);

        ObservableList<UserAccount> list = FXCollections.observableArrayList(user1, user2, user3);
        return list;
    }

    public static void main(String[] args) {
        launch(args);
    }
}