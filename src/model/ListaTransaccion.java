package model;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListaTransaccion {
	public static ObservableList<Transaccion> data = FXCollections.observableArrayList();
	public static ObservableList<Transaccion> dataFiltrada = FXCollections.observableArrayList();
	
	public static double estadoActual () {
		Double total = 0.0;
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getTipo().equals("Gasto")) {
				total-=data.get(i).getTransaccion();
			} else {
				total+=data.get(i).getTransaccion();
			}
		}
		return total;
	}
	
	public static double ingreso(ObservableList<Transaccion> dataUssar) {
		double totalIngreso = 0;
		for (int i = 0; i<dataUssar.size() ; i++) {
			if (dataUssar.get(i).getTipo().equals("Ingreso")) {
				totalIngreso+=dataUssar.get(i).getTransaccion();
			}
		}
		return totalIngreso;
	}
	
	public static double gasto(ObservableList<Transaccion> dataUssar) {
		double totalGasto = 0;
		for (int i = 0; i<dataUssar.size() ; i++) {
			if (dataUssar.get(i).getTipo().equals("Gasto")) {
				totalGasto+=dataUssar.get(i).getTransaccion();
			}
		}
		return totalGasto;
	}
	
	public static double estadoActualFiltrado () {
		Double total = 0.0;
		for (int i = 0; i < dataFiltrada.size(); i++) {
			if (dataFiltrada.get(i).getTipo().equals("Gasto")) {
				total-=dataFiltrada.get(i).getTransaccion();
			} else {
				total+=dataFiltrada.get(i).getTransaccion();
			}
		}
		return total;
	}
	
	public static void filtrarData (LocalDate dateDesde, LocalDate dateHasta) {
		dataFiltrada.clear();
		for (int i = 0; i<data.size(); i++) {
			if (dateDesde==null) {
				if (data.get(i).getFechaTransaccion().isBefore(dateHasta)) {
					dataFiltrada.add(data.get(i));
				}
			} else if (dateHasta==null) {
				if (data.get(i).getFechaTransaccion().isAfter(dateDesde)) {
					dataFiltrada.add(data.get(i));
				}
			} else {
				if (data.get(i).getFechaTransaccion().isAfter(dateDesde) && data.get(i).getFechaTransaccion().isBefore(dateHasta)) {
					dataFiltrada.add(data.get(i));
				}
			}
			
		}
	}
}
