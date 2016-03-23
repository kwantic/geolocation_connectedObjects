<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<link type="text/css" rel="stylesheet" href="inc/style.css" />
    <script type="text/javascript"
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDSrsjj9UiFV5JY_EAeb_vkmDr-Z0z4HHA&sensor=false">
    </script>
    <script type="text/javascript">
     <%-- function initialize() {
        var mapOptions = {
          //center: new google.maps.LatLng(-34.397, 150.644),
          center: new google.maps.LatLng(<c:out value="${ objet.lat }"/>,<c:out value="${ objet.lng }"/>),
          zoom: 8,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        var map = new google.maps.Map(document.getElementById("map_canvas"),
            mapOptions);
      } --%>
      function initMap() {
    	  var myLatLng = {lat :<c:out value="${ objet.lat }"/>,lng :<c:out value="${ objet.lng }"/>};

    	  // Create a map object and specify the DOM element for display.
    	  var map = new google.maps.Map(document.getElementById('map'), {
    	    center: myLatLng,
    	    scrollwheel: false,
    	    zoom: 30
    	  });

    	  // Create a marker and set its position.
    	  var marker = new google.maps.Marker({
    	    map: map,
    	    position: myLatLng,
    	    title: 'Hello World!'
    	  });
    	}
    </script>
  </head>
  <body onload="initMap()">
    <div id="map" style="width:400px; height:300px"></div>
  </body>
</html>