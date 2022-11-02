module cecille.paintapp {
  requires javafx.controls;
  requires javafx.fxml;

  opens cecille.paintapp to javafx.fxml;
  exports cecille.paintapp ;
}
