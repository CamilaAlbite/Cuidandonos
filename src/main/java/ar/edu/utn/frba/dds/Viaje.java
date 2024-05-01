package ar.edu.utn.frba.dds;

import java.util.List;

import ar.edu.utn.frba.dds.alertas.MedioDeAlerta;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Viaje {
	private Transeunte transeunte;
	private String origen;
	private String destino;
	private List<String> paradasIntermedias;
	private List<Cuidador> cuidadores;
	private Notificador notificador = new Notificador();
	private List<MedioDeAlerta> mediosDeAlertaElegidos;
	private Integer duracionViajeEstimada;
	private boolean viajeEnCurso;

    public Viaje(Transeunte transeunte, String origen, String destino, List<String> paradasIntermedias,
                 List<Cuidador> cuidadoresElegidos) {
        this.transeunte = transeunte;
        this.origen = origen;
        this.destino = destino;
        this.paradasIntermedias = paradasIntermedias;
        cuidadoresElegidos.forEach(cuidador -> cuidador.recibirNuevoTranseunte(this));
    }
    
    public void nuevoMedioDeAlerta(MedioDeAlerta nuevoMedioDeAlerta) {
    	mediosDeAlertaElegidos.add(nuevoMedioDeAlerta);
    }
    
    public void eliminarMedioDeAlerta(MedioDeAlerta nuevoMedioDeAlerta) {
    	mediosDeAlertaElegidos.remove(nuevoMedioDeAlerta);
    }
    
    public void confirmarCuidadores() {
    	for(Cuidador cuidador : cuidadores) {
    		notificador.notificar(cuidador, TipoMensaje.SOLICITUD_CUIDADOR);
    		if(cuidador.aceptarViaje()) {
    			notificador.notificar(cuidador, TipoMensaje.SOLICITUD_ACEPTADA);
    			cuidadores.add(cuidador);
    		} else {
    			//TODO Rechazaron el viaje
    		}
    	}
    }
    
    public boolean isViajeIniciable() {
    	//Al menos tiene 1 cuidador
    	return !cuidadores.isEmpty();
    }
    
    public void iniciarViaje() {
    	if(this.isViajeIniciable()) {
    		//Inicia el viaje en el transeunte
    		transeunte.iniciarViaje(this);
    		//Notifica a todos los cuidadores que el transeunte inicio el viaje
    		notificador.notificarInicioViajeGlobalCuidadores(cuidadores);
    		notificador.notificarMinutosViajeGlobal(cuidadores);
    		notificador.notificarDistanciaViajeGlobal(cuidadores);
    		
    		transeunte.desactivarNotificaciones();
    	}
    }
    
    //Finaliza viaje sin peligro
    public void finalizarViaje() {
    	transeunte.activarNotificaciones();
    	
    	notificador.notificarFinViajeSinPeligroGlobal(cuidadores);
    }
    
    public void informarAlgoMalo() {
    	if(!mediosDeAlertaElegidos.isEmpty()) {
    		for(MedioDeAlerta medioDeAlerta : mediosDeAlertaElegidos) {
    			medioDeAlerta.alertar(this);
    		}
    	}
    }
}
