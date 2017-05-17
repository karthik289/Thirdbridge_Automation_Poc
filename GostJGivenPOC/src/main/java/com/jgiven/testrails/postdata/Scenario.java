package com.jgiven.testrails.postdata;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Scenario implements Serializable
{

@SerializedName("className")
@Expose
private String className;
@SerializedName("testMethodName")
@Expose
private String testMethodName;
@SerializedName("description")
@Expose
private String description;
@SerializedName("tagIds")
@Expose
private List<Object> tagIds = null;
@SerializedName("explicitParameters")
@Expose
private List<Object> explicitParameters = null;
@SerializedName("derivedParameters")
@Expose
private List<Object> derivedParameters = null;
@SerializedName("casesAsTable")
@Expose
private Boolean casesAsTable;
@SerializedName("scenarioCases")
@Expose
private List<ScenarioCase> scenarioCases = null;
@SerializedName("durationInNanos")
@Expose
private Double durationInNanos;
private final static long serialVersionUID = 206817109427599113L;

public String getClassName() {
return className;
}

public void setClassName(String className) {
this.className = className;
}

public String getTestMethodName() {
return testMethodName;
}

public void setTestMethodName(String testMethodName) {
this.testMethodName = testMethodName;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public List<Object> getTagIds() {
return tagIds;
}

public void setTagIds(List<Object> tagIds) {
this.tagIds = tagIds;
}

public List<Object> getExplicitParameters() {
return explicitParameters;
}

public void setExplicitParameters(List<Object> explicitParameters) {
this.explicitParameters = explicitParameters;
}

public List<Object> getDerivedParameters() {
return derivedParameters;
}

public void setDerivedParameters(List<Object> derivedParameters) {
this.derivedParameters = derivedParameters;
}

public Boolean getCasesAsTable() {
return casesAsTable;
}

public void setCasesAsTable(Boolean casesAsTable) {
this.casesAsTable = casesAsTable;
}

public List<ScenarioCase> getScenarioCases() {
return scenarioCases;
}

public void setScenarioCases(List<ScenarioCase> scenarioCases) {
this.scenarioCases = scenarioCases;
}

public Double getDurationInNanos() {
	return durationInNanos;
}

public void setDurationInNanos(Double durationInNanos) {
	this.durationInNanos = durationInNanos;
}


}