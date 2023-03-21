package com.micatss.plantsim.files.save;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.micatss.plantsim.files.GameConfiguration;
import com.micatss.plantsim.files.config.ConfigFile;

public class SaveData extends ConfigFile implements GameConfiguration {

	public static final String FILENAME = "savedata";
	
	@Override
	public String getFilename() {
		return FILENAME;
	}

	private static final String ITEMS = "ITEMS";
	
	private List<Saveable> saveables = new LinkedList<Saveable>();
	
	public SaveData() {
		defaultSettings();
	}
	public SaveData(File file) {
		super(file);
	}
	
	@Override
	public void parse() throws ParseException, FileNotFoundException {
		JSONObject json = loadJsonFromFile();
		JSONArray itemsArray = (JSONArray) json.get(ITEMS);
		for(int i=0;i<itemsArray.size();i++) {
			saveables.add(SaveableParser.parse((JSONObject)itemsArray.get(i)));
		}
	}
	
	@Override
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		JSONArray itemsArray = new JSONArray();
		for(Saveable saveable : saveables) {
			itemsArray.add(saveable.toJson());
		}
		json.put(ITEMS, itemsArray);
		return json;
	}
	
	public Collection<Saveable> getSaveables(){
		return saveables;
	}
	
	@Override
	public void defaultSettings() {
		/* no items */
	}
	
}
