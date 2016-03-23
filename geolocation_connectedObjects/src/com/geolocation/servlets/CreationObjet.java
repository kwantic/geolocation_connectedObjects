package com.geolocation.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geolocation.beans.Objet;

public class CreationObjet extends HttpServlet {

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /*
         * R�cup�ration des donn�es saisies, envoy�es en tant que param�tres de
         * la requ�te GET g�n�r�e � la validation du formulaire
         */
        String nom = request.getParameter( "nomObjet" );
        double lat;
        try {
            /* R�cup�ration du montant */
            lat = Double.parseDouble( request.getParameter( "latObjet" ) );
        } catch ( NumberFormatException e ) {
            /* Initialisation � -1 si le montant n'est pas un nombre correct */
            lat = -999999999;
        }
        double lng;
        try {
            /* R�cup�ration du montant */
            lng = Double.parseDouble( request.getParameter( "lngObjet" ) );
        } catch ( NumberFormatException e ) {
            /* Initialisation � -1 si le montant n'est pas un nombre correct */
            lng = -1;
        }


        String message;
        /*
         * Initialisation du message � afficher : si un des champs obligatoires
         * du formulaire n'est pas renseign�, alors on affiche un message
         * d'erreur, sinon on affiche un message de succ�s
         */
        if ( nom.trim().isEmpty() || lat == -999999999 || lng == -999999999 ) {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"creerObjet.jsp\">Cliquez ici</a> pour acc�der au formulaire de cr�ation d'un objet.";
        } else {
            message = "Objet cr�� avec succ�s !";
        }
        /*
         * Cr�ation du bean Client et initialisation avec les donn�es r�cup�r�es
         */
        Objet objet = new Objet();
        objet.setNom( nom );
        objet.setLat(lat);
        objet.setLng(lng);


        /* Ajout du bean et du message � l'objet requ�te */
        request.setAttribute( "objet", objet );
        request.setAttribute( "message", message );

        /* Transmission � la page JSP en charge de l'affichage des donn�es */
        this.getServletContext().getRequestDispatcher( "/map.jsp" ).forward( request, response );
    }
}