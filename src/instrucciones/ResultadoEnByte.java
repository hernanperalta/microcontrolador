package instrucciones;

public class ResultadoEnByte {
	private Integer valorCompleto;
	
	public ResultadoEnByte(Integer valor) {
		this.valorCompleto = valor;
	}
	
	public Integer valorMaximo() {
		return 127;
	}
	
	public Integer valorMinimo() {
		return -127;
	}
	
	public byte valorEnByte() {
		if( this.valorCompleto > 0 )
			return this.maximoValor();
		
		return this.minimoValor();
	}
	
	private byte maximoValor() {
		return (byte) Math.min(this.valorCompleto, this.valorMaximo());
	}
	
	private byte minimoValor() {
		return (byte) Math.max(this.valorCompleto, this.valorMinimo());
	}
	
	private Integer distanciaAlMaximo() {
		return this.valorMaximo() - Math.abs(this.valorCompleto);
	}
	
	public byte exceso() {
		
		if( this.distanciaAlMaximo() > 0 )
			return 0;
		
		return this.excesoCuandoHayOverflow();
		
	}
	
	private byte excesoCuandoHayOverflow() {
		return (byte) (Integer.signum(this.valorCompleto) * Math.abs(this.distanciaAlMaximo()));
	}
	
}
