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
public class CareerVO {
    private String keyword;
    private String zipcode;
    private String email;

    @Override
    public String toString() {
        return "CareerVO{" + "keyword=" + keyword + ", zipcode=" + zipcode + ", email=" + email + '}';
    }

    public CareerVO(String keyword, String zipcode, String email) {
        this.keyword = keyword;
        this.zipcode = zipcode;
        this.email = email;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
