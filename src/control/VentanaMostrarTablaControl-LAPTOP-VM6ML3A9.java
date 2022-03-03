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
    private Button buttonIngresarCambio;

    @FXML
    private DatePicker datePickerDesde;

    @FXML
    private DatePicker datePickerHasta;
    
    @FXML
    private Label labelBalance;

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
	}

}
