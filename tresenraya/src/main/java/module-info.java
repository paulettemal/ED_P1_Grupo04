module com.mycompany.tresenraya {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.tresenraya to javafx.fxml;
    exports com.mycompany.tresenraya;
}
