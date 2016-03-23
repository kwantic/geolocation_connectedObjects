<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
      html { height: 100% }
      body { height: 100%; margin: 0; padding: 0 }
      #map_canvas { height: 100% }
    </style>
    <script type="text/javascript"
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDSrsjj9UiFV5JY_EAeb_vkmDr-Z0z4HHA&sensor=false">
    </script>
    <script type="text/javascript">
      function initialize() {
        var mapOptions = {
          //center: new google.maps.LatLng(-34.397, 150.644),
          center: new google.maps.LatLng(<c:out value="${ objet.lat }"/>,<c:out value="${ objet.lng }"/>),
          zoom: 8,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        var map = new google.maps.Map(document.getElementById("map_canvas"),
            mapOptions);
      }
    </script>
  </head>
  <body onload="initialize()">
    <div id="map_canvas" style="width:400px; height:300px"></div>
  </body>
</html>