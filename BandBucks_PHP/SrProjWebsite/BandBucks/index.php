<html>
<head>
	<link rel="stylesheet" type="text/css" href="bbstyle.css" />
	<style>html{height: 100%;}</style>
	<title>
		Band Bucks
	</title>
</head>

<body>

<div class = "navbar">
	<div class = "title-container">
	<ul class = "nav">
			<li><a href = "index.php"><b>Band Bucks</b></a></li>
			<li><a href="../index.html">Documentation</a></li>
				<form>
				<!-------- v1 ------------>
					<li>Email:</li>
					<li><input type=”text” name=”email” size=20 /></li>
					<li>Password:</li>
					<li><input type="password" name="password" size=20 /></li>
					<li><input type= "button" value="Login" onClick="executeLogin()" ></li>
				<!------- v2 ----
					 <fieldset id="inputs">
 						<input id="username" type="email" name="Email" placeholder="Your email address" required>   
 						<input id="password" type="password" name="Password" placeholder="Password" required>
 					</fieldset>
 					<fieldset id="actions">
 						<input type="submit" id="submit" value="Log in">
 					</fieldset> -->
				</form>
			<!--<li><a href = "cash.php" class = "nav-button">Login</a></li>-->
			<li><a href = "registerUser.php" class = "nav-button"> Register</a></li>

			<?php
			//------Login Button----- 
			//Get email
			$email = null
			//Get password
			$password = null
			//SELECT userID FROM user 
			//WHERE email = user.email && user.password = password 
			
			//IF userID == null
			//then invalid username/pass
			//ELSE 
			//go to band cash page for user
			 ?>

	</ul>
<!-- 		-----------------------------
 -->	
<!-- 	--------------------------------
 -->	</div>
</div>
<br />
<h1 class="welcome">Band Bucks</h1>

<center>		So, you and your friends decided to start a band. Rock On! <br />
		But how will you keep track of the money!? Afterall, a band is a business... <br />
		<br />
		Introducing Band Bucks to account for your every need!<br />
		Cash, equipment, and debt is all taken care of! 
		<br />In the mean time you can jam out rather than waste time asking questions like
		<br />Who owes us money? How much cash are we spending on tour? and How much merchandise is on hand?
		<br />Band Bucks will track it all for you!
	</center>


</ul>  -->

</body>
<footer>
	
</footer>
</html>