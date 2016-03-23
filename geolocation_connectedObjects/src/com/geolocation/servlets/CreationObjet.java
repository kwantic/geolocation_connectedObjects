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
         * Récupération des données saisies, envoyées en tant que paramètres de
         * la requête GET générée à la validation du formulaire
         */
        String nom = request.getParameter( "nomObjet" );
        double lat;
        try {
            /* Récupération du montant */
            lat = Double.parseDouble( request.getParameter( "latObjet" ) );
        } catch ( NumberFormatException e ) {
            /* Initialisation à -1 si le montant n'est pas un nombre correct */
            lat = -999999999;
        }
        double lng;
        try {
            /* Récupération du montant */
            lng = Double.parseDouble( request.getParameter( "lngObjet" ) );
        } catch ( NumberFormatException e ) {
            /* Initialisation à -1 si le montant n'est pas un nombre correct */
            lng = -1;
        }


        String message;
        /*
         * Initialisation du message à afficher : si un des champs obligatoires
         * du formulaire n'est pas renseigné, alors on affiche un message
         * d'erreur, sinon on affiche un message de succès
         */
        if ( nom.trim().isEmpty() || lat == -999999999 || lng == -999999999 ) {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"creerObjet.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un objet.";
        } else {
            message = "Objet créé avec succès !";
        }
        /*
         * Création du bean Client et initialisation avec les données récupérées
         */
        Objet objet = new Objet();
        objet.setNom( nom );
        objet.setLat(lat);
        objet.setLng(lng);


        /* Ajout du bean et du message à l'objet requête */
        request.setAttribute( "objet", objet );
        request.setAttribute( "message", message );

        /* Transmission à la page JSP en charge de l'affichage des données */
        this.getServletContext().getRequestDispatcher( "/map.jsp" ).forward( request, response );
    }
}