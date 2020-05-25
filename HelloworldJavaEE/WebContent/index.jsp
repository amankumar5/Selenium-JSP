<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello World Java EE</title>
<script type="text/javascript">
var fbUserId="aman";
var fbPassword;
var gmail;
var gPassword;
var hId;
var hPassword;
function loadInput()
{ 
	document.getElementById("fbUserId").value="7075094484";
	document.getElementById("fbPassword").value="k127125n";
	document.getElementById("gmail").value="saichander.gattu543@gmail.com";
	 document.getElementById("gPassword").value="k127125n";
	 document.getElementById("hId").value="amankumargoswami6@gmail.com";
	 document.getElementById("hPassword").value="Akumar@51298";
	}
function changeView()
{
	var x= document.getElementById("register");
	x.style.display= "none";
	var y=document.getElementById("form");
	y.style.display= "block";
	
    fbUserId=document.getElementById("fbUserId").value;
    document.getElementById("fbUserIdf").value=fbUserId;
    
    fbPassword=document.getElementById("fbPassword").value;
    document.getElementById("fbPasswordf").value=fbPassword;
    
    gmail=document.getElementById("gmail").value;
    document.getElementById("gmailf").value=gmail;
    document.getElementById("gmails").value=gmail;
   
    gPassword=document.getElementById("gPassword").value;
    document.getElementById("gPasswordf").value=gPassword;
    document.getElementById("gPasswords").value=gPassword;
    
    hId=document.getElementById("hId").value;
    document.getElementById("hIdf").value=hId;
   
    hPassword=document.getElementById("hPassword").value;
    document.getElementById("hPasswordf").value=hPassword;
    
    
    
	}
	function onRegister(){
		var x= document.getElementById("register");
		x.style.display= "block";
		var y=document.getElementById("form");
		y.style.display= "none";
	}
	function changeSearch(){
		var x=document.getElementById("filter");
		x.style.display="none";
		var y=document.getElementById("search");
		y.style.display="block";
	}
	function changeFilter(){
		var x=document.getElementById("filter");
		x.style.display="block";
		var y=document.getElementById("search");
		y.style.display="none";
	}
</script>
</head>
<body onload="loadInput()">

    <div id="register" style="text-align: center;margin: 200px; background: black; color: white;padding-bottom: 60px; ">
    <div style="width:100%; background: lightgray; text-align:center height:40px;"><h1 style="color:black;"> Registration</h1></div>
    Facebook UserId  : <input type="text" id="fbUserId"><br><br>
    Facebook password  : <input type="text" id="fbPassword"><br><br>
    gmailId  : <input type="text" id="gmail"><br><br>
    Gmail password  : <input type="text" id="gPassword"><br><br>
    Hackerrank ID  : <input type="text" id="hId"><br><br>
    Hackerrank password  : <input type="text" id="hPassword"><br><br>
    <input type="button" value="submit" onclick="changeView()" >
    </div>
    <div id="form" style="display: none;background: whitesmoke;">
    
    <div style="width: 100%;text-align: right">
<input type="button" value="change Inputs" onclick="onRegister()">
</div>
    <div style="display: flex;">
<form action="helloServlet" method="post" style="width:800px; border: solid white;" >
<div style="text-align: center;background: black;color: white;"><h3>Like Facebook Posts</h3> </div>
<div style="float: center;text-align: center; background: lightgrey;">
    UserId: <input type="text" name="yourName" size="20" id="fbUserIdf" readonly><br><br><p></p>
    Password: <input type="password" name="password"id="fbPasswordf" size="20"  readonly><br><br><p></p>
    Name of Friend: <input type="text" name="Fname" size="20">
    <div> <p></p></div>
    <input type="submit" value="like all" />
    </div>
</form>


<form action="emialVerify" method="post" style="width:800px;border:solid white; margin-left: 80px;">
<div style="text-align: center;background: black;color: white;"><h3>Gmail Information</h3> </div>
  <div style="float: center;text-align: center; background: lightgrey;">
          Email : <input type="text" name="myEmail" id="gmailf" readonly><br><br>
          Password : <input type="password" name="myPassword" id="gPasswordf" readonly><br><br>
          <div id="filter" style="display: block" >
          Filter : <select name="filter" id="filter">
           <option value="" disabled selected>Select your option</option>
          <option value="is:starred">starred</option>
          <option value="in:draft">draft</option>
          <option value="in:sent">sent</option>
          <option value="is:important">important</option>
           </select>
           <p style="margin-left: 150px;margin-top:0px;color:blue" onclick="changeSearch()">search</p>
           </div>
           <div style="display:none;" id="search">
           <input type="text" placeholder="serachKey" name="filter" id="searchKey"/>
            <p style="margin-left: 150px;color:blue" onclick="changeFilter()">filter</p>
           </div>
   
     <!--  <input type="button" value="Add" style="width: 50px; float:right; height: 20px;" onClick="addInput('dynamicInput');">-->
   <input type="submit" value="Get Info" />
     </div>
</form>
</div>




<div style="display: flex;">
<form action="wekipidea" method="post" style="width:800px; border: solid white;">
<div style="text-align: center;background: black;color: white;"><h3>Open wikipedia</h3> </div>
<div style="float: center;text-align: center; background: lightgrey;">
    Search : <input type="text" name="searchText" size="20"><br><br><p></p>
   
    <input type="submit" value="GO" />
    </div>
</form>
<form action="hackerrank" method="post" style="width:800px;border:solid white; margin-left: 80px;">
<div style="text-align: center;background: black;color: white;"><h3>Open Hackerrank</h3> </div>
<div style="float: center;text-align: center; background: lightgrey;">
    UserId: <input type="text" name="mail" size="20" id="hIdf" readonly><br><br><p></p>
    Password: <input type="password" name="password"id="hPasswordf" size="20 " readonly><br><br><p></p>
    <input type="submit" value="Start Coding" />
    </div>
</form>
</div>




<form action="emailSender" method="post" style="background: lightgray;">
<div style="text-align: center;background: black;color: white; width:100%;"><h3>Email sender</h3> </div>
<div style="display:flex;">
<div style="float: left;text-align: center; background: lightgrey;width: 49%">
     Email : <input type="text" name="myEmails" id="gmails" readonly><br><br>
          Password : <input type="password" name="myPasswords" id="gPasswords" readonly><br><br>
          To Id : <input placeholder="recievers email id" type="text" name="toId" id="toId"  ><br><br>
   
   
    </div>
    <div style="float:left;width:49%;margin: 10px;">
    <div  style="width:100%;"> <input type="text"style="width: 100%; border-radius: 4px;" placeholder="Subject Of mail" name="subject" id="subject"></div>
    <div style="margin-top:3px;">
    <textarea rows="15" cols="90" name="body" id="body" style="width:100%; height:140px" placeholder="enter the body of mail"></textarea>
    </div>
    </div>
    </div>
    <div style="text-align: right">
     <input type="submit" value="send" />
     </div>
</form>
</div>
</body>
</html>