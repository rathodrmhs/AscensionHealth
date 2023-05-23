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
public class DonationVO {
    private String donation;

    @Override
    public String toString() {
        return "DonationVO{" + "donation=" + donation + '}';
    }

    public DonationVO(String donation) {
        this.donation = donation;
    }

    public String getDonation() {
        return donation;
    }

    public void setDonation(String donation) {
        this.donation = donation;
    }
    
}
