package com.jgiven.testrails.postdata;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestRailResults {

	@SerializedName("results")
	@Expose
	private List<TestRailResult> results = null;
	private final static long serialVersionUID = 9165406563802137685L;

	public List<TestRailResult> getResults() {
	return results;
	}

	public void setResults(List<TestRailResult> results) {
	this.results = results;
	}
}
