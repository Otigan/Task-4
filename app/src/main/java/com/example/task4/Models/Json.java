
package com.example.task4.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//Model of Json 2gis response
public class Json {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("result")
    @Expose
    private Result result;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
