package ar.edu.utn.frba.dds.alertas;

import ar.edu.utn.frba.dds.*;

public class AlertaCuidadores implements MedioDeAlerta{

	@Override
    public void alertar(Viaje viaje){
		//Alerta a todos los cuidadores
        for(Cuidador cuidador : viaje.getCuidadores()) {
        	this.alertarCuidador(cuidador);
        }
    }
	
	public void alertarCuidador(Cuidador cuidador) {
		Notificador notificador = new Notificador();
		
		notificador.notificarAlerta(cuidador);
	}
}
