package com.pokebros.android.pokemononline.battle;

import com.pokebros.android.pokemononline.Bais;
import com.pokebros.android.pokemononline.Baos;
import com.pokebros.android.pokemononline.DataBaseHelper;
import com.pokebros.android.pokemononline.SerializeBytes;
import com.pokebros.android.pokemononline.poke.BattlePoke;
import com.pokebros.android.pokemononline.poke.Gen;

public class BattleTeam implements SerializeBytes {
	String nick = "";
	String info = "";
	Gen gen = new Gen();
	
	public BattlePoke[] pokes = new BattlePoke[6];
	int[] indexes = new int[6];
	
	public BattleTeam(Bais msg, DataBaseHelper db, Gen gen) {
		for(int i = 0; i < 6; i++) {
			pokes[i] = new BattlePoke(msg, db, gen);
			pokes[i].teamNum = (byte)i;
		}
	}
	
	public void serializeBytes(Baos b) {
		for(int i = 0; i < 6; i++)
			b.putBaos(pokes[i]);
	}
}
