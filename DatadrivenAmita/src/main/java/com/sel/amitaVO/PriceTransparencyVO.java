/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sel.amitaVO;

/**
 *
 * @author kohli
 */
public class PriceTransparencyVO {
    private String zip;

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public PriceTransparencyVO(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "PriceTransparencyVO{" + "zip=" + zip + '}';
    }
    
}
