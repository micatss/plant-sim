package com.micatss.game.files.savedata;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.micatss.game.files.GameConfiguration;
import com.micatss.game.files.config.ConfigFile;

public class SaveData extends ConfigFile implements GameConfiguration {

	public static final String FILENAME = "savedata";
	
	private final SaveableParser saveableParser;
	private static final String SAVED_ITEMS = "SAVED_ITEMS";
	
	private List<Saveable> saveables = new LinkedList<Saveable>();
	
	public SaveData(SaveableParser saveableParser) {
		super();
		this.saveableParser = saveableParser;
	}
	public SaveData(SaveableParser saveableParser, File file) {
		super(file);
		this.saveableParser = saveableParser;
	}
	
	@Override
	public void parse() throws ParseException, FileNotFoundException {
		JSONObject json = loadJsonFromFile();
		JSONArray itemsArray = (JSONArray) json.get(SAVED_ITEMS);
		for(int i=0;i<itemsArray.size();i++) {
			saveables.add(saveableParser.parse((JSONObject)itemsArray.get(i)));
		}
	}
	
	@Override
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		JSONArray itemsArray = new JSONArray();
		for(Saveable saveable : saveables) {
			itemsArray.add(saveable.asSaveableJson());
		}
		json.put(SAVED_ITEMS, itemsArray);
		return json;
	}
	
	public Collection<Saveable> getSaveables(){
		return saveables;
	}
	
	@Override
	public void defaultSettings() {
		/* no items */
	}

	@Override
	public String getFilename() {
		return FILENAME;
	}
	
}
