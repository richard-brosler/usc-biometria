package br.usc.segusc.biometria.service;

import br.usc.segusc.biometria.exception.BiometriaInvalidaException;

public interface IBiometriaService {
	public String scanear(int[][] matriz) throws BiometriaInvalidaException;
}
