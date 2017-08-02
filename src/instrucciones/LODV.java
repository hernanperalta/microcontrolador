package instrucciones;

import microcontroller.Micro;

public class LODV extends LoadEnA {
	byte val;
	
	public LODV(Micro micro, byte val) {
		super(micro);
		this.val = val;
	}

	@Override
	public byte valor() {
		return this.val;
	}

}
