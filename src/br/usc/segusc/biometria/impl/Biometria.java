package br.usc.segusc.biometria.impl;

import java.util.ArrayList;
import java.util.Random;

import br.usc.segusc.biometria.exception.BiometriaInvalidaException;
import br.usc.segusc.biometria.service.IBiometriaService;
import br.usc.segusc.log.entity.LogLevel;
import br.usc.segusc.log.impl.Log;
import br.usc.segusc.log.services.LogFactory;

public class Biometria implements IBiometriaService {
	private class Biometrias{
		private int [][] biometria;
		private String login;
		public Biometrias(String log, int [][] bio){
			biometria = bio;
			login = log;
		}
	}
	private ArrayList<Biometrias> listaBio;
	private int [][] bioms;
	
	public Biometria() {
		listaBio = new ArrayList<Biometria.Biometrias>();
		bioms = new int[4][4];

		bioms[0][0] = 0; bioms[0][1] = 0; bioms[0][2] = 0; bioms[0][3] = 0;
		bioms[1][0] = 1; bioms[1][1] = 1; bioms[1][2] = 1; bioms[1][3] = 1;
		bioms[2][0] = 0; bioms[2][1] = 0; bioms[2][2] = 0; bioms[2][3] = 0;
		bioms[3][0] = 1; bioms[3][1] = 1; bioms[3][2] = 1; bioms[3][3] = 1;
		
		listaBio.add(new Biometrias("Richard", bioms));
		Random rnd = new Random(System.currentTimeMillis());
		for (int i=0;i<10;i++){
			bioms = new int[4][4];
			for (int j=0;j<4;j++){
				for (int k=0;k<4;k++){
					bioms[j][k]=rnd.nextInt(1);
				}
			}
			listaBio.add(new Biometrias("Richard", bioms));
		}
	}
	@Override
	public String scanear(int[][] matriz) throws BiometriaInvalidaException {
		Boolean valido=true;
		for (Biometrias biometrias : listaBio) {
			for(int i=0;i<4;i++){
				for(int j=0;j<4;j++){
					if (biometrias.biometria[i][j] != matriz[i][j]){
						valido = false;
						break;
					}
				}
				if (!valido) break;
			}
			if (!valido) 
				break;
			else
				return biometrias.login;
		}
		throw new BiometriaInvalidaException();
	}

}
