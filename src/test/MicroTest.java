package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import exceptions.DivisionPor0Exception;
import instrucciones.*;
import microcontroller.Micro;

public class MicroTest {
	private Micro micro;
	private List<Instruccion> nop3Veces;
	private List<Instruccion> sumar10Con22;
	private List<Instruccion> sumar100Con50;
	private List<Instruccion> dividir2Por0;
	private List<Instruccion> sumar2Con8Con5;
	
	@Before
	public void setUp() throws Exception {
		this.micro = new Micro();
		
		this.nop3Veces = Arrays.asList(new NOP(), new NOP(), new NOP());
		
		this.sumar10Con22 = Arrays.asList(new LODV(this.micro, (byte) 10), 
										  new SWAP(this.micro),
										  new LODV(this.micro, (byte) 22),
										  new ADD(this.micro));
		
		this.sumar100Con50 = Arrays.asList(new LODV(this.micro, (byte) 100), 
										   new SWAP(this.micro),
										   new LODV(this.micro, (byte) 50),
										   new ADD(this.micro));
		
		this.dividir2Por0 = Arrays.asList(new LODV(this.micro, (byte) 0), 
										  new SWAP(this.micro),
										  new LODV(this.micro, (byte) 2),
										  new DIV(this.micro));
		
		this.sumar2Con8Con5 = Arrays.asList(new LODV(this.micro, (byte) 2), 
											new STR(this.micro, 0),
											new LODV(this.micro, (byte) 8),
											new SWAP(this.micro),
											new LODV(this.micro, (byte) 5),
											new ADD(this.micro),
											new SWAP(this.micro),
											new LOD(this.micro, 0),
											new ADD(this.micro));
	}

	@Test
	public void alEjecutarNOPSeAvanzaElPC3Posiciones() {
		this.micro.run(this.nop3Veces);
		
		Assert.assertEquals(3, this.micro.getPC());
	}
	
	@Test
	public void alSumar10Y22ElAcumAQuedaCon32YElBCon0() {
		this.micro.run(this.sumar10Con22);
		
		Assert.assertEquals(32, this.micro.getAAcumulator());
		Assert.assertEquals(0, this.micro.getBAcumulator());
	}
	
	@Test
	public void alSumar100Y50ElAcumAQuedaCon127YElBCon23() {
		this.micro.run(this.sumar100Con50);
		
		Assert.assertEquals(127, this.micro.getAAcumulator());
		Assert.assertEquals(23, this.micro.getBAcumulator());
	}
	
	@Test(expected=DivisionPor0Exception.class)
	public void alDividir2Con0Explota() {
		this.micro.run(this.dividir2Por0);
	}
	
	@Test
	public void alDividir2Con0ExplotaYElPCQuedaEn4() {
		try {
			this.micro.run(this.dividir2Por0);
		} catch (DivisionPor0Exception e) {
			Assert.assertEquals(4, this.micro.getPC());
		}
	}

	@Test
	public void alSumar2Con8Con5ElAcumAQuedaEn15YElBEn0() {
		this.micro.run(this.sumar2Con8Con5);
		
		Assert.assertEquals(15, this.micro.getAAcumulator());
		Assert.assertEquals(0, this.micro.getBAcumulator());
	}
	
}
