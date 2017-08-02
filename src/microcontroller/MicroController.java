package microcontroller;

import java.util.List;

import instrucciones.Instruccion;

public interface MicroController {
	/*** programacion: carga y ejecuta un conjunto de instrucciones en memoria */
  	public void run(List<Instruccion> program);

  	public byte getAAcumulator();
  	
  	public void setAAcumulator(byte value);
  	
  	public byte getBAcumulator();
  	
  	public void setBAcumulator(byte value);
  	/*** Manejo de program counter */
  	public void advancePC(); // Avanza el program counter una instrucción
  	
  	public byte getPC();
  	
  	public void reset();     // Inicializa el microcontrolador
  	/*** Manejo de dirección de memoria de datos: getter y setter */
  	public byte getData(int addr);
  	
  	public void setData(int addr, byte value);

}
