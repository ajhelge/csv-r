module org.openjfx.csv_r {
    requires javafx.controls;
    requires javafx.fxml;
	requires opencsv;

    opens org.openjfx.csv_r to javafx.fxml;
    exports org.openjfx.csv_r;
}
