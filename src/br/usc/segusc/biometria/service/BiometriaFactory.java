package br.usc.segusc.biometria.service;

import br.usc.segusc.biometria.impl.Biometria;

public class BiometriaFactory {
	
	private static BiometriaFactory inst;
	private Biometria bio;
	
	private BiometriaFactory(){
		bio = new Biometria();
	}
	
	public static BiometriaFactory getInstance(){
		if (inst==null)
			inst = new BiometriaFactory();
		return inst;
	}

	public static IBiometriaService getBiometriaServiceImpl(){
		return getInstance().bio;
	}
}
