package ar.edu.utn.frba.dds;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Transeunte {
	private String nombre;
	private String apellido;
	private String direccion;
	private int edad;
	private String sexo;
	private Viaje viajeEnCurso;
	private List<TipoMensaje> notificaciones = new ArrayList<>();
	private boolean notificacionesActivas;
	
	public Transeunte() {
		
	}

    public Transeunte(String nombre, String apellido, String direccion, int edad, String sexo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.edad = edad;
        this.sexo = sexo;
    }

    Viaje irA(String origen, String destino, List<String> paradasIntermedias, List<Cuidador> cuidadores){
        Viaje nuevoViaje = new Viaje(this, origen, destino, paradasIntermedias, cuidadores);
        cuidadores.forEach(c-> c.recibirNuevoTranseunte(nuevoViaje));
        return nuevoViaje;
    }
    void iniciarViaje(Viaje viaje){
        this.viajeEnCurso = viaje;
    }

    public void activarNotificaciones() {
    	notificacionesActivas = true;
    }
    
    public void desactivarNotificaciones() {
    	notificacionesActivas = false;
    }
}
