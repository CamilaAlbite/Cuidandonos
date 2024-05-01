package ar.edu.utn.frba.dds;
import java.util.ArrayList;
import java.util.List;

public class Cuidador {
    String nombre;
    String apellido;
    String direccion;
    int edad;
    String sexo;
    List<Viaje> viajesDeInteresados;

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
    public void aceptarCuidado(Viaje viaje){
        viaje.cuidadores.add(this);
        //TODO:informar al transeunte
    }
    public void serNotificado(TipoMensaje tipo, String mensaje){
        //TODO:ver como implementar las notificaciones
    }

}
