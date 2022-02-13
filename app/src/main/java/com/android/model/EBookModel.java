package com.android.model;

public class EBookModel {
    String eBookTitle;
    String eBookPdf;

    public String geteBookTitle() {
        return eBookTitle;
    }

    public void seteBookTitle(String eBookTitle) {
        this.eBookTitle = eBookTitle;
    }

    public String geteBookPdf() {
        return eBookPdf;
    }

    public void seteBookPdf(String eBookPdf) {
        this.eBookPdf = eBookPdf;
    }
}
