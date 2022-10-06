package net.brac.api.rest.test.scapir.get.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionsTermSavingsData {
    @JsonProperty("ProjectCode")
    private String projectCode;

    @JsonProperty("OrgNo")
    private String orgNo;

    @JsonProperty("OrgMemNo")
    private String orgMemNo;

    @JsonProperty("UpdatedAt")
    private String updatedAt;

    @JsonProperty("ProjectCode")
    public String getProjectCode() {
        return projectCode;
    }

    @JsonProperty("ProjectCode")
    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    @JsonProperty("OrgNo")
    public String getOrgNo() {
        return orgNo;
    }

    @JsonProperty("OrgNo")
    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
    }

    @JsonProperty("UpdatedAt")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("UpdatedAt")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
    
}
