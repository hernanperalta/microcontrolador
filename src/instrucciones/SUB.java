package instrucciones;

import microcontroller.Micro;

public class SUB extends OperacionBinaria {

	public SUB(Micro micro) {
		super(micro);
	}

	@Override
	public Integer operar(byte aAcumulator, byte bAcumulator) {
		return aAcumulator - bAcumulator;
	}
	
}
