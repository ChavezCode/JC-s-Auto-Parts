package com.example.demo.service;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import org.springframework.stereotype.Service;


@Service
public class InventoryValidation{
    public String validateInventory(OutsourcedPart part) {
        int inv = part.getInv();
        int minInv = part.getMinInv();
        int maxInv = part.getMaxInv();


        if (inv == 0) {
            return "Inventory must be greater than zero";
        }
        if (inv < minInv) {
            return "Inventory must be greater than " + minInv;
        }
        if (inv > maxInv) {

            return "Inventory must be less than " + maxInv;
        }
        return "";
    }


    public String validateInventoryIn(InhousePart part) {
        int invInhouse = part.getInv();
        int minInvInhouse = part.getMinInv();
        int maxInvInhouse = part.getMaxInv();

        if (invInhouse == 0) {
            return "Inventory must be greater than zero";
        }
        if (invInhouse < minInvInhouse) {
            return "Inventory must be greater than " + minInvInhouse;
        }
        if (invInhouse > maxInvInhouse) {

            return "Inventory must be less than " + maxInvInhouse;
        }
        return "";
    }

}
