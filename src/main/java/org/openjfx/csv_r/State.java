package org.openjfx.csv_r;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalTime;

class State{
	private final List<String[]> rawData;
	private List<Double[]> data;
	private List<LocalTime> timeStamp;
	private List<String> fields;
	
	
	public State(List<String[]> rawFileData) {
		this.rawData = rawFileData;
		this.data = initData(this.rawData);
		this.timeStamp = initTime(this.rawData);
		this.fields = initFields(rawFileData);
	}
	
	/**
	 * 
	 * @param rawData is CSV input
	 * @return A List of Double Arrays containing just the data of a CSV.
	 */
	private List<Double[]> initData(List<String[]> rawData) {
		List<Double[]> out = new ArrayList<>();
		
		for(int i = 1; i < rawData.size(); i++) {
			Double[] row = new Double[rawData.get(i).length];
			
			for(int j = 1; j < rawData.get(i).length; j++) {
				if(rawData.get(i)[j] == "") {
					row[j] = null;
				}else {
					row[j] = Double.parseDouble(rawData.get(i)[j]);
				}
			}
			out.add(row);
		}
		return out;
	}
	/**
	 * 
	 * @param rawData
	 * @return List of time stamps from CSV input data.
	 */
	private List<LocalTime> initTime(List<String[]> rawData){
		List<LocalTime> out = new ArrayList<>();
		for(int i = 1; i < rawData.size(); i++) {
			String hour = "00:"; // TODO: This line is a quick fix, time input parsing needs to be more robust.
			hour = hour.concat(rawData.get(i)[0]);
			out.add(LocalTime.parse(hour));
		}
		return out;
	}
	/**
	 * 
	 * @param rawData
	 * @return List of fields from the first line of the CSV input data.
	 */
	private List<String> initFields(List<String[]> rawData){
		List<String> out = new ArrayList<>();
		for(String field : rawData.get(0)) {
			out.add(field);
		}
		return out;
	}
	public List<Double[]> getAllData() {
		return this.data;
	}
	
	public List<LocalTime> getAllTimeStamps() {
		return this.timeStamp;
	}
	
	public List<String> getAllFields() {
		return this.fields;
	}

}