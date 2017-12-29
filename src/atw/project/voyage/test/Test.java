/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atw.project.voyage.test;

import atw.project.voyage.entities.Voyage;
import atw.project.voyage.services.CrudVoy;
import atw.project.voyage.technique.BConnection;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Monta
 */
public class Test {

    public static void main(String[] args) {

       

        Connection connect = BConnection.getInstance().getConnection();

        CrudVoy tools = new CrudVoy();

        tools.ajouterVoy(new Voyage("tr201X", "tunis", "paris", 0, 0,"11/12/2017",0));
        List<Voyage> myresult = tools.displayAll();
        System.out.println(myresult);
    }

}
