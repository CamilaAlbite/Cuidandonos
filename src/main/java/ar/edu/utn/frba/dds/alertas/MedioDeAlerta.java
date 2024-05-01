package ar.edu.utn.frba.dds.alertas;

import ar.edu.utn.frba.dds.Viaje;

public interface MedioDeAlerta {
    void alertar(Viaje viaje, String mensajeDeAlerta);
}
