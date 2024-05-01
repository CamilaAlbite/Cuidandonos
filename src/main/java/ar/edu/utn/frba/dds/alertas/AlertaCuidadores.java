package ar.edu.utn.frba.dds.alertas;

import ar.edu.utn.frba.dds.Viaje;

public class AlertaCuidadores implements MedioDeAlerta{

    public void alertar(Viaje viaje, String mensajeDeAlerta){
        viaje.informarCuidadores(mensajeDeAlerta);
    }
}
