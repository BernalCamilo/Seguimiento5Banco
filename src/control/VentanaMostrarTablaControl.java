package control;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.Main;
import model.ListaTransaccion;
import model.Transaccion;

public class VentanaMostrarTablaControl implements Initializable{
	@FXML
    private Button butonAplicar;

    @FXML
    private Button buttonEliminar;

    @FXML
    private Button buttonIngresarCambio;

    @FXML
    private DatePicker datePickerDesde;

    @FXML
    private DatePicker datePickerHasta;

    @FXML
    private Label labelBalance;

    @FXML
    private Label labelGasto;

    @FXML
    private Label labelIngreso;

    @FXML
    private Button resetearFecha;

    @FXML
    private TableColumn<Transaccion, Double> tableColumnCantidad;

    @FXML
    private TableColumn<Transaccion, LocalDate> tableColumnFecha;

    @FXML
    private TableColumn<Transaccion, String> tableColumnTipo;

    @FXML
    private TableView<Transaccion> tableContenido;
    
    @FXML
    void abrirNuevaVentana(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/NuevaTransaccion.fxml"));
		loader.setController(new NuevaTransaccionControl());
		Parent parent = (Parent) loader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
		Stage stage2 = (Stage) buttonIngresarCambio.getScene().getWindow();
		stage2.close();
		
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		tableColumnCantidad.setCellValueFactory(new PropertyValueFactory<>("transaccion"));
		tableColumnFecha.setCellValueFactory(new PropertyValueFactory<>("fechaTransaccion"));
		tableColumnTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		
		tableContenido.setItems(ListaTransaccion.data);
		labelBalance.setText(ListaTransaccion.estadoActual()+"");
		labelGasto.setText(ListaTransaccion.gasto(ListaTransaccion.data)+"");
		labelIngreso.setText(ListaTransaccion.ingreso(ListaTransaccion.data)+"");
		
	}
	
	@FXML
    void aplicarFechas(ActionEvent event) {
		String alertaString = "";
		Alert alert = new Alert (Alert.AlertType.INFORMATION);
		alert.setTitle("Error en los parametros de entrada");
		if (datePickerDesde.getValue()==null && datePickerHasta.getValue()==null) {
			alertaString="Ingrese al menos una fecha limite";
			alert.setContentText(alertaString);
			alert.show();
		} else {
			ListaTransaccion.filtrarData(datePickerDesde.getValue(), datePickerHasta.getValue());
			tableColumnCantidad.setCellValueFactory(new PropertyValueFactory<>("transaccion"));
			tableColumnFecha.setCellValueFactory(new PropertyValueFactory<>("fechaTransaccion"));
			tableColumnTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
			
			tableContenido.setItems(ListaTransaccion.dataFiltrada);
			labelBalance.setText(ListaTransaccion.estadoActualFiltrado()+"");
			labelGasto.setText(ListaTransaccion.gasto(ListaTransaccion.dataFiltrada)+"");
			labelIngreso.setText(ListaTransaccion.ingreso(ListaTransaccion.dataFiltrada)+"");
			
		}
    }
	
	@FXML
    void resetearInfoTabla(ActionEvent event) {
		datePickerDesde.setValue(null);
		datePickerHasta.setValue(null);
		tableColumnCantidad.setCellValueFactory(new PropertyValueFactory<>("transaccion"));
		tableColumnFecha.setCellValueFactory(new PropertyValueFactory<>("fechaTransaccion"));
		tableColumnTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		
		tableContenido.setItems(ListaTransaccion.data);
		labelBalance.setText(ListaTransaccion.estadoActual()+"");
    }
	
	@FXML
    void eliminarTransaccion(ActionEvent event) {

    }

}
