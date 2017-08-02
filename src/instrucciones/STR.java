package instrucciones;

import microcontroller.Micro;

public class STR implements Instruccion {
	private Micro micro;
	private int addr;
	
	public STR(Micro micro, int addr) {
		this.micro = micro;
		this.addr = addr;
	}
	
	@Override
	public void ejecutar() {
		this.micro.setData(this.addr, this.valorDeA());
	}

	private byte valorDeA() {
		return this.micro.getAAcumulator();
	}

}
