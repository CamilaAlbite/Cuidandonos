package ar.edu.utn.frba.dds;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Cuidador {
    private String nombre;
    private String apellido;
    private String direccion;
    private int edad;
    private String sexo;
    private List<Viaje> viajesDeInteresados;
    private List<TipoMensaje> notificaciones;
    private boolean notificacionesActivas;

    public Cuidador(String nombre, String apellido, String direccion, int edad, String sexo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.edad = edad;
        this.sexo = sexo;
        this.viajesDeInteresados = new ArrayList<>();
    }

    public void recibirNuevoTranseunte(Viaje viaje){
        this.viajesDeInteresados.add(viaje);
    }
    public void rechazarCuidado(Viaje viajeARechazar) {
        viajesDeInteresados.remove(viajeARechazar);
       //TODO:informar al transeunte
    }

    //No tenemos criterios de aceptacion, por ahora siempre es true
    public boolean aceptarViaje() {
    	return true;
    }
    
    public void activarNotificaciones() {
    	this.notificacionesActivas = true;
    }
    
    public void desactivarNotificaciones() {
    	this.notificacionesActivas = false;
    }
}
