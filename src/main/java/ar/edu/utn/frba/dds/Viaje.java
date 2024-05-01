package ar.edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;

public class Viaje {
    Transeunte transeunte;
    String origen;
    String destino;
    List<String> paradasIntermedias;
    List<Cuidador> cuidadores;

    public Viaje(Transeunte transeunte, String origen, String destino, List<String> paradasIntermedias,
                 List<Cuidador> cuidadoresElegidos) {
        this.transeunte = transeunte;
        this.origen = origen;
        this.destino = destino;
        this.paradasIntermedias = paradasIntermedias;
        cuidadoresElegidos.forEach(cuidador -> cuidador.recibirNuevoTranseunte(this));
    }
}
