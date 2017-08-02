package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import instrucciones.ResultadoEnByte;

public class ResultadoTest {
	private ResultadoEnByte resultadoMaximo;
	private ResultadoEnByte resultadoMinimo;
	private ResultadoEnByte resultadoNormal;
	
	@Before
	public void setUp() throws Exception {
		
		this.resultadoMaximo = new ResultadoEnByte(254);
		
		this.resultadoMinimo = new ResultadoEnByte(-254);

		this.resultadoNormal = new ResultadoEnByte(32);
		
	}

	@Test
	public void elExcesoDe254Es127() {
		Assert.assertEquals(127, this.resultadoMaximo.exceso());
	}

	@Test
	public void elValorEnByteDe254Es127() {
		Assert.assertEquals(127, this.resultadoMaximo.valorEnByte());
	}
	
	@Test
	public void elExcesoDe254NegativoEs127Negativo() {
		Assert.assertEquals(-127, this.resultadoMinimo.exceso());
	}

	@Test
	public void elValorEnByteDe254NegativoEs127Negativo() {
		Assert.assertEquals(-127, this.resultadoMinimo.valorEnByte());
	}
	
	@Test
	public void elExcesoDe32Es0() {
		Assert.assertEquals(0, this.resultadoNormal.exceso());
	}

	@Test
	public void elValorEnByteDe32Es32() {
		Assert.assertEquals(32, this.resultadoNormal.valorEnByte());
	}
	
}
