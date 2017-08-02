package instrucciones;

import microcontroller.Micro;

public class SWAP implements Instruccion {
	private Micro micro;
	
	public SWAP(Micro micro) {
		this.micro = micro;
	}
	
	@Override
	public void ejecutar() {
		byte A = this.micro.getAAcumulator();
		byte B = this.micro.getBAcumulator();

		this.micro.setBAcumulator(A);
		this.micro.setAAcumulator(B);
	}

}
