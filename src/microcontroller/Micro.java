package microcontroller;

import java.util.List;

import instrucciones.Instruccion;

public class Micro implements MicroController {
	private byte aAcumulator;
	private byte bAcumulator;
	private byte pc = 0;
	private int[][] memoriaDeDatos = new int[1024][2];
	
	@Override
	public void run(List<Instruccion> program) {
		if( program.size() > 1023 )
			throw new RuntimeException("El programa no puede tener mas de 1024 comandos");
		
		program.forEach(unaInstruccion -> this.ejecutar(unaInstruccion));
	}

	private void ejecutar(Instruccion unaInstruccion) {		
		this.advancePC();
		unaInstruccion.ejecutar();		
	}

	@Override
	public void advancePC() {
		this.pc++;
	}

	@Override
	public byte getPC() {
		return this.pc;
	}

	@Override
	public void reset() {
		this.pc = 0;
	}
	
	public void validarDireccion(int addr) {
		if( addr > 1023 )
			throw new IllegalArgumentException("La direccion ingresada excede "
					+ "la cantidad de posiciones en la memoria de datos");
		
		if( addr < 0 )
			throw new IllegalArgumentException("La direccion ingresada "
					+ "debe ser mayor o igual a 0");
	}

	@Override
	public byte getData(int addr) {
		this.validarDireccion(addr);
		
		return (byte) this.memoriaDeDatos[addr][1];
	}

	@Override
	public void setData(int addr, byte value) {
		this.validarDireccion(addr);
		
		this.memoriaDeDatos[addr][1] = value;
	}

	@Override
	public byte getAAcumulator() {
		return aAcumulator;
	}

	@Override
	public void setAAcumulator(byte aAcumulator) {
		this.aAcumulator = aAcumulator;
	}

	@Override
	public byte getBAcumulator() {
		return bAcumulator;
	}

	@Override
	public void setBAcumulator(byte bAcumulator) {
		this.bAcumulator = bAcumulator;
	}

}
