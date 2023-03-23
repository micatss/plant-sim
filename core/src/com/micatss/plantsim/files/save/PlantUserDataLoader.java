package com.micatss.plantsim.files.save;

import com.micatss.game.files.UserDataLoader;
import com.micatss.game.files.savedata.SaveableParser;

public class PlantUserDataLoader extends UserDataLoader {

	private static final SaveableParser saveableParser = new PlantSaveParser();
	
	public PlantUserDataLoader() {
		super(saveableParser);
	}

}
