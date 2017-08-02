package instrucciones;

import microcontroller.Micro;

public abstract class LoadEnA implements Instruccion {
	protected Micro micro;
	
	protected LoadEnA(Micro micro) {
		this.micro = micro;
	}
	
	@Override
	public void ejecutar() {
		this.micro.setAAcumulator(this.valor());
	}

	public abstract byte valor();
	
}
