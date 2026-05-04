package org.openjfx.csv_r;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class State{
	
	List<String[]> rawData;
	
	public State(List<String[]> rawFileData) {
		this.rawData = rawFileData;
	}
	
	/**
	 * A method to test if file imported correctly by printing the first entry of each line.
	 */
	public void display() {
		for (String[] strings : rawData) {
			System.out.println(strings[0]);
		}
	}
}