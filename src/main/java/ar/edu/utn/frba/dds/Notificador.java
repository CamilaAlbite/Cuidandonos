package ar.edu.utn.frba.dds;

import java.util.List;

public class Notificador {
	
	public Notificador() {
		
	}
	
	//TODO Hay que mejorar el envio de mensajes para que sean mas generales. Por ahora se hacen con TipoMensaje
	public void notificar(Cuidador cuidador, TipoMensaje mensaje) {
		cuidador.getNotificaciones().add(mensaje);
	}
	
	public void notificar(Transeunte transeunte, TipoMensaje mensaje) {
		transeunte.getNotificaciones().add(mensaje);
	}
	
	public void notificarSeleccionCuidador(Cuidador cuidador) {
		this.notificar(cuidador, TipoMensaje.SOLICITUD_CUIDADOR);
	}
	
	public void notificarRespuestaAceptadaTranseunte(Transeunte transeunte) {
		this.notificar(transeunte, TipoMensaje.SOLICITUD_ACEPTADA);
	}
	
	public void notificarRespuestaRechazadaTranseunte(Transeunte transeunte) {
		this.notificar(transeunte, TipoMensaje.SOLICITUD_RECHAZADA);
	}
	
	public void notificarInicioViajeCuidador(Cuidador cuidador) {
		this.notificar(cuidador, TipoMensaje.INICIO_DE_VIAJE);
	}
	
	public void notificarMinutosViaje(Cuidador cuidador) {
		this.notificar(cuidador, TipoMensaje.MINUTOS);
	}
	
	public void notificarDistanciaViaje(Cuidador cuidador) {
		this.notificar(cuidador, TipoMensaje.DISTANCIA);
	}
	
	public void notificarViajeSinPeligro(Cuidador cuidador) {
		this.notificar(cuidador, TipoMensaje.SIN_PELIGRO);
	}
	
	public void notificarAlerta(Cuidador cuidador) {
		this.notificar(cuidador, TipoMensaje.ALERTA);
	}
	
	public void notificarInicioViajeGlobalCuidadores(List<Cuidador> lista) {
		for(Cuidador cuidador : lista) {
			this.notificarInicioViajeCuidador(cuidador);
		}
	}
	
	public void notificarMinutosViajeGlobal(List<Cuidador> lista) {
		for(Cuidador cuidador : lista) {
			this.notificarMinutosViaje(cuidador);
		}
	}
	
	public void notificarDistanciaViajeGlobal(List<Cuidador> lista) {
		for(Cuidador cuidador : lista) {
			this.notificarDistanciaViaje(cuidador);
		}
	}
	
	public void notificarFinViajeSinPeligroGlobal(List<Cuidador> lista) {
		for(Cuidador cuidador : lista) {
			this.notificarViajeSinPeligro(cuidador);
		}
	}
	
	public void notificarAlertaGlobal(List<Cuidador> lista) {
		for(Cuidador cuidador : lista) {
			this.notificarAlerta(cuidador);
		}
	}
}
