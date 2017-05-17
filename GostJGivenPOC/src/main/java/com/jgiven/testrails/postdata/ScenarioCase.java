package com.jgiven.testrails.postdata;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ScenarioCase implements Serializable
{

@SerializedName("caseNr")
@Expose
private Integer caseNr;
@SerializedName("steps")
@Expose
private List<Step> steps = null;
@SerializedName("explicitArguments")
@Expose
private List<Object> explicitArguments = null;
@SerializedName("derivedArguments")
@Expose
private List<Object> derivedArguments = null;
@SerializedName("success")
@Expose
private Boolean success;
@SerializedName("durationInNanos")
@Expose
private Double durationInNanos;
@SerializedName("errorMessage")
@Expose
private String errorMessage;
@SerializedName("stackTrace")
@Expose
private List<String> stackTrace = null;
private final static long serialVersionUID = 2745925952506240742L;

public Integer getCaseNr() {
return caseNr;
}

public void setCaseNr(Integer caseNr) {
this.caseNr = caseNr;
}

public List<Step> getSteps() {
return steps;
}

public void setSteps(List<Step> steps) {
this.steps = steps;
}

public List<Object> getExplicitArguments() {
return explicitArguments;
}

public void setExplicitArguments(List<Object> explicitArguments) {
this.explicitArguments = explicitArguments;
}

public List<Object> getDerivedArguments() {
return derivedArguments;
}

public void setDerivedArguments(List<Object> derivedArguments) {
this.derivedArguments = derivedArguments;
}

public Boolean getSuccess() {
return success;
}

public void setSuccess(Boolean success) {
this.success = success;
}

public Double getDurationInNanos() {
	return durationInNanos;
}

public void setDurationInNanos(Double durationInNanos) {
	this.durationInNanos = durationInNanos;
}

public String getErrorMessage() {
return errorMessage;
}

public void setErrorMessage(String errorMessage) {
this.errorMessage = errorMessage;
}

public List<String> getStackTrace() {
return stackTrace;
}

public void setStackTrace(List<String> stackTrace) {
this.stackTrace = stackTrace;
}

}