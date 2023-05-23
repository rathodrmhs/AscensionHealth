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
public class SpecialtyCareVO {
    private String search;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public SpecialtyCareVO(String search) {
        this.search = search;
    }

    @Override
    public String toString() {
        return "SpecialtyCareVO{" + "search=" + search + '}';
    }
    
}
