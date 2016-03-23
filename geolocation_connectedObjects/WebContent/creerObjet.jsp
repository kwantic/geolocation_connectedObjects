<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'un objet</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
        <div>
            <form method="get" action="creationObjet">
                <fieldset>
                    <legend>Informations objet</legend>
    
                    <label for="nomClient">Nom <span class="requis">*</span></label>
                    <input type="text" id="nomObjet" name="nomObjet" value="" size="20" maxlength="20" />
                    <br />
                    <label for="latObjet">Lat <span class="requis">*</span></label>
                    <input type="text" id="latObjet" name="latObjet" value="" size="20" maxlength="20" />
                    <br />
     				<label for="lngClient">Lng <span class="requis">*</span></label>
                    <input type="text" id="lngObjet" name="lngObjet" value="" size="20" maxlength="20" />
                    <br />
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>