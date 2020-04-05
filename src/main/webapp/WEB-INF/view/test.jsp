<%@taglib uri="http://www.springframework.org/tags" prefix="a"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <a:url var="url_jqlib" value="/static/js/jquery-3.4.1.min.js"/>
       <script src="${url_jqlib}"></script>
       <script>
           $(document).ready(function(){
             $("#id_get_time").click(function(){
             $.ajax({
             url:'get_time',
             success: function(data){
             $("#id_time").html(data);
             }
             });
             });
           });
           </script>
       
    </head>
    <body>
        <h1>ajax test page</h1>
        <button id="id_get_time">Get Server Time</button> <br/>
        <p id="id_time"></p>
    </body>
</html>
