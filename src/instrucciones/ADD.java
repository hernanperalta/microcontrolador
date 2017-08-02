package instrucciones;

import microcontroller.Micro;

public class ADD extends OperacionBinaria {

	public ADD(Micro micro) {
		super(micro);
	}

	@Override
	public Integer operar(byte aAcumulator, byte bAcumulator) {
		return aAcumulator + bAcumulator;
	}

}
