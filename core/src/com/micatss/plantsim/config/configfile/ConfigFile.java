package com.micatss.plantsim.config.configfile;

import com.micatss.plantsim.config.GameConfiguration;
import com.micatss.plantsim.util.ProgramLog;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

import javax.security.auth.login.Configuration;

import org.json.simple.parser.JSONParser;

public abstract class ConfigFile implements GameConfiguration {
	public abstract String getFilename();
	public abstract void parse() throws ParseException, FileNotFoundException;
	public abstract JSONObject toJson();
	public String fileContent() {
		return toJson().toString();
	}
	
	protected final File file;
	protected final JSONParser parser = new JSONParser();
	
	protected ConfigFile() {
		this.file = null;
		ProgramLog.info("Not saving ");
		defaultSettings();
	}
	
	protected ConfigFile(File file) {
		this.file = file;
		try {
			parse();
		} catch (Throwable t) {
			defaultSettings();
		}
	}
	
	protected JSONObject loadJsonFromFile() throws FileNotFoundException, ParseException {
		return (JSONObject) parser.parse(loadFileString());
	}
	
	private String loadFileString() throws FileNotFoundException {
		final Scanner scanner = new Scanner(file);
		StringBuilder sb = new StringBuilder();
		while(scanner.hasNextLine()) {
			sb.append(scanner.nextLine());
		}
		return sb.toString();
	}
	
	public void save() {
		try {
			FileWriter writer = new FileWriter(file.getAbsoluteFile());
			writer.write(fileContent());
			writer.close();
		} catch (Throwable t) {
			ProgramLog.error(t.toString());
		}
	}
}
