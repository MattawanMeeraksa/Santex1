/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Administrator
 */
public class MainTest {
    public static void main(String[] args) {
        EditPlan eplan = new EditPlan("bank","nnnn","20");
        System.out.println(eplan.getEditName());
    }
}
