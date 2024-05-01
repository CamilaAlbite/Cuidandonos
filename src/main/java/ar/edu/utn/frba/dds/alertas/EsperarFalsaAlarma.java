package ar.edu.utn.frba.dds.alertas;

import java.util.Timer;
import java.util.TimerTask;

import ar.edu.utn.frba.dds.*;

public class EsperarFalsaAlarma implements MedioDeAlerta{
	
	private Integer minutosAEsperar;
	private MedioDeAlerta medio;
	
	public EsperarFalsaAlarma(Integer minutos, MedioDeAlerta medioElegido) {
		minutosAEsperar = minutos;
		medio = medioElegido;
	}
	
	@Override
	public void alertar(Viaje viaje) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
            @Override
            public void run() {
            	if(viaje.isViajeEnCurso()) {
                	medio.alertar(viaje);
                }
            }
        }, minutosAEsperar);
	}
}
