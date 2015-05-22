package br.usc.segusc.biometria.exception;

public class BiometriaInvalidaException extends Exception {
	public BiometriaInvalidaException(String msg) {
		super(msg);
	}
	public BiometriaInvalidaException() {
		super("Biometria Inválida!");
	}
}
