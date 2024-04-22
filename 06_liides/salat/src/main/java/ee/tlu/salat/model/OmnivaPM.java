package ee.tlu.salat.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
// Json -> POJO https://json2csharp.com/code-converters/json-to-pojo
public class OmnivaPM {
    @JsonProperty("ZIP")
    private String zIP;
    @JsonProperty("NAME")
    private String nAME;
    @JsonProperty("TYPE")
    private String tYPE;
    @JsonProperty("A0_NAME")
    private String a0_NAME;
    @JsonProperty("A1_NAME")
    private String a1_NAME;
    @JsonProperty("A2_NAME")
    private String a2_NAME;
    @JsonProperty("A3_NAME")
    private String a3_NAME;
    @JsonProperty("A4_NAME")
    private String a4_NAME;
    @JsonProperty("A5_NAME")
    private String a5_NAME;
    @JsonProperty("A6_NAME")
    private String a6_NAME;
    @JsonProperty("A7_NAME")
    private String a7_NAME;
    @JsonProperty("A8_NAME")
    private String a8_NAME;
    @JsonProperty("X_COORDINATE")
    private String x_COORDINATE;
    @JsonProperty("Y_COORDINATE")
    private String y_COORDINATE;
    @JsonProperty("SERVICE_HOURS")
    private String sERVICE_HOURS;
    @JsonProperty("TEMP_SERVICE_HOURS")
    private String tEMP_SERVICE_HOURS;
    @JsonProperty("TEMP_SERVICE_HOURS_UNTIL")
    private String tEMP_SERVICE_HOURS_UNTIL;
    @JsonProperty("TEMP_SERVICE_HOURS_2")
    private String tEMP_SERVICE_HOURS_2;
    @JsonProperty("TEMP_SERVICE_HOURS_2_UNTIL")
    private String tEMP_SERVICE_HOURS_2_UNTIL;
    private String comment_est;
    private String comment_eng;
    private String comment_rus;
    private String comment_lav;
    private String comment_lit;
    @JsonProperty("MODIFIED")
    private Date mODIFIED;



}
