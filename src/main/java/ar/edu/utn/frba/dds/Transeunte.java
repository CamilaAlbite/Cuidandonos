package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.alertas.MedioDeAlerta;

import java.util.List;

public class Transeunte {
    String nombre;
    String apellido;
    String direccion;
    int edad;
    String sexo;
    Viaje viajeEnCurso;

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
        viajeEnCurso.cuidadores.forEach(cuidador -> cuidador.serNotificado(TipoMensaje.INICIO_DE_VIAJE,""));
    }
    void registrarArribo(String destinoArribado){
        viajeEnCurso.cuidadores
                .forEach(cuidador -> cuidador.serNotificado(TipoMensaje.ARRIBO,destinoArribado));
    }
    void alertarEstado(MedioDeAlerta medioDeAlerta, String mensajeDeAlerta){
        viajeEnCurso.cuidadores.forEach(cuidador -> cuidador.serNotificado(TipoMensaje.ALERTA, mensajeDeAlerta));
    }

}
