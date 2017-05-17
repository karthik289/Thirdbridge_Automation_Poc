package com.jgiven.testrails.postdata;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestResults implements Serializable
{

@SerializedName("className")
@Expose
private String className;
@SerializedName("name")
@Expose
private String name;
@SerializedName("scenarios")
@Expose
private List<Scenario> scenarios = null;/*
@SerializedName("tagMap")
@Expose
private TagMap tagMap;*/
private final static long serialVersionUID = -5758208987699322873L;

public String getClassName() {
return className;
}

public void setClassName(String className) {
this.className = className;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public List<Scenario> getScenarios() {
return scenarios;
}

public void setScenarios(List<Scenario> scenarios) {
this.scenarios = scenarios;
}

@Override
public String toString() {
	return "TestResults [className=" + className + ", name=" + name + ", scenarios=" + scenarios + "]";
}



/*public TagMap getTagMap() {
return tagMap;
}

public void setTagMap(TagMap tagMap) {
this.tagMap = tagMap;
}
*/
}