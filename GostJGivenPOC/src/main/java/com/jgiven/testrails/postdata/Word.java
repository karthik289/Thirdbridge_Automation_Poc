package com.jgiven.testrails.postdata;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Word implements Serializable
{

@SerializedName("value")
@Expose
private String value;
@SerializedName("isIntroWord")
@Expose
private Boolean isIntroWord;
@SerializedName("argumentInfo")
@Expose
private ArgumentInfo argumentInfo;
private final static long serialVersionUID = -5773140616371140012L;

public String getValue() {
return value;
}

public void setValue(String value) {
this.value = value;
}

public Boolean getIsIntroWord() {
return isIntroWord;
}

public void setIsIntroWord(Boolean isIntroWord) {
this.isIntroWord = isIntroWord;
}

public ArgumentInfo getArgumentInfo() {
return argumentInfo;
}

public void setArgumentInfo(ArgumentInfo argumentInfo) {
this.argumentInfo = argumentInfo;
}

}