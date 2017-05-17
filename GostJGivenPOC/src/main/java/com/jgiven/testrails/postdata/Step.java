package com.jgiven.testrails.postdata;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Step implements Serializable
{

@SerializedName("name")
@Expose
private String name;
@SerializedName("words")
@Expose
private List<Word> words = null;
@SerializedName("status")
@Expose
private String status;
@SerializedName("durationInNanos")
@Expose
private Double durationInNanos;
private final static long serialVersionUID = 6767361334656730713L;

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public List<Word> getWords() {
return words;
}

public void setWords(List<Word> words) {
this.words = words;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public Double getDurationInNanos() {
	return durationInNanos;
}

public void setDurationInNanos(Double durationInNanos) {
	this.durationInNanos = durationInNanos;
}



}
