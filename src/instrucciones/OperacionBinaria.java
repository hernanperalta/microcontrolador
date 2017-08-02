package instrucciones;

import microcontroller.Micro;

public abstract class OperacionBinaria extends LoadEnA {
	private ResultadoEnByte ultimoResultado;
	
	protected OperacionBinaria(Micro micro) {
		super(micro);
	}
	
	@Override
	public void ejecutar() {
		this.ultimoResultado = new ResultadoEnByte(this.operarAConB());
		
		super.ejecutar();
		
		this.micro.setBAcumulator(this.exceso());
	}

	@Override
	public byte valor() {
		return this.ultimoResultado.valorEnByte();
	}
	
	public Integer operarAConB() {
		return this.operar(this.micro.getAAcumulator(), this.micro.getBAcumulator());
	}
	
	public abstract Integer operar(byte aAcumulator, byte bAcumulator);

	public byte exceso() {
		return this.ultimoResultado.exceso();
	}

}
