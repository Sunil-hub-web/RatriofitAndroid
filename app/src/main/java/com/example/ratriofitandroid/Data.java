package com.example.ratriofitandroid;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class Data {

        @SerializedName("plan")
        @Expose
        private String plan;
        @SerializedName("result")
        @Expose
        private String result;
        @SerializedName("remarks")
        @Expose
        private String remarks;

        public String getPlan() {
            return plan;
        }

        public void setPlan(String plan) {
            this.plan = plan;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

    }
