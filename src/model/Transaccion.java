package model;

import java.time.LocalDate;

public class Transaccion {
	private Double transaccion;
	private LocalDate fechaTransaccion;
	private String motivo;
	private String tipo;
	
	public Transaccion(Double transaccion, LocalDate localDate, String motivo, String tipo) {
		this.transaccion = transaccion;
		this.fechaTransaccion = localDate;
		this.motivo = motivo;
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(Double transaccion) {
		this.transaccion = transaccion;
	}

	public LocalDate getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(LocalDate fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
}
