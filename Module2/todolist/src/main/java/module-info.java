module todo {
    requires javafx.controls;
    requires javafx.fxml;

    opens todo to javafx.fxml;
    exports todo;
}
