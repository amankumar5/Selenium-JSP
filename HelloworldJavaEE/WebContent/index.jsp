<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello World Java EE</title>
<script type="text/javascript">
var counter = 1;
var limit = 3;
function addInput(divName){
     if (counter == limit)  {
          alert("You have reached the limit of adding " + counter + " inputs");
     }
     else {
          var newdiv = document.createElement('div');
          newdiv.innerHTML = "email " + (counter + 1) + " <input type='text' name='myemails[]'><br>"+ "password" + (counter+1)+": <input type='text' name='myPasswords[]'>";
          document.getElementById(divName).appendChild(newdiv);
          counter++;
     }
}
</script>
</head>
<body>
    
<form action="helloServlet" method="post" >
<div style="text-align: center;background: black;color: white;"><h3>Like Facebook Posts</h3> </div>
<div style="float: center;text-align: center; background: lightgrey;">
    UserId: <input type="text" name="yourName" size="20"><br><br><p></p>
    Password: <input type="password" name="password" size="20" ><br><br><p></p>
    Name of Friend: <input type="text" name="Fname" size="20">
    <div> <p></p></div>
    <input type="submit" value="like all" />
    </div>
</form>
<div style="text-align: center;background: black;color: white;"><h3>Gmail Information</h3> </div>

<form action="emialVerify" method="post">
  <div style="float: center;text-align: center; background: lightgrey;">
          Email : <input type="text" name="myEmail"><br><br>
          Password : <input type="password" name="myPassword"><br><br>
   
     <!--  <input type="button" value="Add" style="width: 50px; float:right; height: 20px;" onClick="addInput('dynamicInput');">-->
   <input type="submit" value="Get Info" />
     </div>
</form>
<form action="wekipidea" method="post" >
<div style="text-align: center;background: black;color: white;"><h3>Open wikipedia</h3> </div>
<div style="float: center;text-align: center; background: lightgrey;">
    Search : <input type="text" name="searchText" size="20"><br><br><p></p>
   
    <input type="submit" value="GO" />
    </div>
</form>
<form action="hackerrank" method="post">
<div style="text-align: center;background: black;color: white;"><h3>Open Hackerrank</h3> </div>
<div style="float: center;text-align: center; background: lightgrey;">
    UserId: <input type="text" name="mail" size="20"><br><br><p></p>
    Password: <input type="password" name="password" size="20" ><br><br><p></p>
    <input type="submit" value="Start Coding" />
    </div>
</form>
</body>
</html>