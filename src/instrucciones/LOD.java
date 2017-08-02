package instrucciones;

import microcontroller.Micro;

public class LOD extends LoadEnA {
	private int addr;
	
	public LOD(Micro micro, int address) {
		super(micro);
		this.addr = address;
	}
	
	@Override
	public byte valor() {
		return this.micro.getData(this.addr);
	}

}
