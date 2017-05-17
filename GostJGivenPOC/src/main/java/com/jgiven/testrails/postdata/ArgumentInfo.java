package com.jgiven.testrails.postdata;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArgumentInfo implements Serializable
{

@SerializedName("argumentName")
@Expose
private String argumentName;
@SerializedName("formattedValue")
@Expose
private String formattedValue;
private final static long serialVersionUID = 622230874209390174L;

public String getArgumentName() {
return argumentName;
}

public void setArgumentName(String argumentName) {
this.argumentName = argumentName;
}

public String getFormattedValue() {
return formattedValue;
}

public void setFormattedValue(String formattedValue) {
this.formattedValue = formattedValue;
}

}
