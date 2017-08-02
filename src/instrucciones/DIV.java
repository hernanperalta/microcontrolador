package instrucciones;

import exceptions.DivisionPor0Exception;
import microcontroller.Micro;

public class DIV extends OperacionBinaria {

	public DIV(Micro micro) {
		super(micro);
	}

	@Override
	public Integer operar(byte aAcumulator, byte bAcumulator) {
		if( bAcumulator == 0 )
			throw new DivisionPor0Exception("No se puede dividir por 0");
		
		return aAcumulator / bAcumulator;
	}
	
}
