package control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import main.Main;
import model.ListaTransaccion;
import model.Transaccion;

public class NuevaTransaccionControl implements Initializable{
	
	@FXML
	private Button butonAceptar;
	
	@FXML
	private Button buttonCancelar;
		
	@FXML
	private DatePicker datePickerFecha;
	 
	@FXML
	private ComboBox<String> prueba;

	@FXML
	private TextField textFieldRazon;

	@FXML
	private TextField textFieldTransaccion;
	 
	 @FXML
	 void buttonAceptar(ActionEvent event) throws IOException {
		 boolean alertaBoolean=false;
		 String alertaString = "";
		 Alert alert = new Alert (Alert.AlertType.INFORMATION);
		 alert.setTitle("Error en los parametros de entrada");
		 if (prueba.getValue()==null) {
			 alertaString+="El campo del tipo de transaccion esta vacio"+"\n";
			 alertaBoolean=true;
		 }
		 if (textFieldTransaccion.getText().trim().isEmpty()) {
			 alertaString+="El campo de la transaccion esta vacio"+"\n";
			 alertaBoolean=true;
		 }
		 if (textFieldRazon.getText().trim().isEmpty()) {
			 alertaString+="El campo del motivo esta vacio"+"\n";
			 alertaBoolean=true;
		 }
		 if (datePickerFecha.getValue()==null) {
			 alertaString+="El campo de la fecha esta vacio"+"\n";
			 alertaBoolean=true;
		 }
		 if (alertaBoolean==false) {
			 String pruebaNumero=textFieldTransaccion.getText();
			 ListaTransaccion.data.add(new Transaccion(Double.parseDouble(pruebaNumero), datePickerFecha.getValue(), textFieldRazon.getText(), prueba.getValue()));
			 FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/VentanaMostrarTabla.fxml"));
			 loader.setController(new VentanaMostrarTablaControl());
			 Parent parent = (Parent) loader.load();
			 Stage stage = new Stage();
			 Scene scene = new Scene(parent);
			 stage.setScene(scene);
			 stage.show();
			 Stage stage2 = (Stage) butonAceptar.getScene().getWindow();
			 stage2.close();
		
		 } else {
			 alert.setContentText(alertaString);
			 alert.show();
		 }
	 }
	 
	 

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ObservableList<String> list = FXCollections.observableArrayList();
		list.add("Gasto");
		list.add("Ingreso");
		prueba.setItems(list);
	}

}


