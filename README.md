# Cuidandonos

Integrantes:
* Camila Albite
* Nahuel Fleitas

El diagrama de clases se encuentra en src/resources

Justifiaciones de diseño:
- La dirección la modelamos como una clase aparte para poder separar las responsabilidades
- Le responsabilidad de informar las el estado del Transeunte relacionado con el Viaje en curso es de la clase Viaje ya que es la que tiene la información necesaria para saber que parte del viaje fue completada 
- Definimos una interfaz MediosDeAlerta para que el Transeunte pueda tener una lista de Medios de Alerta y que a la hora alertar sobre su situación todos los medios de alerta deban entender el mismo mensaje
- El notificador lo modelamos como una clase que se encargará de implementar las distintas notificaciones a enviar a los Cuidadores
- Modelamos la clase CalculadoraDeDistancias como una implementacion que se conecta a un adapter (no se encuentra en el diagrama) que va a conectarse con la API 
y asi poder usar sus funcionalidades con elementos de nuestro dominio sin necesidad de acoplar la implementacion de nuestra clase
