<html>
<head>
	<link rel="stylesheet" type="text/css" href="bbstyle.css" />
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
			<li>Login:</li>
			<li><input type=”text” name=”email” size=20 /></li>
			<li>Password:</li>
			<li><input type="password" name="password" size=20 /></li>
			<li><a href = "profile.php" class = "nav-button">Edit Profile</a></li>
			<li>
				Select Band:
			<select>
 				 <option value="">The Usual Suspects</option>
 				 <option value="">Old Kids</option>
			</select></li>
			<li><a href = "createBand.php" class = "nav-button">Create Band</a></li>
		</ul>

	</div>
</div>
<br />
<br />
<br />
<div class = "app-container">
	<ul class = "app-nav">
		<li><a href = "cash.php">Cash</a></li>
		<li><a href = "equipment.php">Equipment</a></li>
		<li><a href = "debt.php">Debt</a></li>
		<li><a href = "reports.php" class = "active">Reports</a></li>
		<li><a href = "calendar.php">Calendar</a></li>
		<li><a href = "contacts.php">Contacts</a></li>
	</ul>
</div>

		<center>
		<img src="images/attendanceDataMockUp.jpg" class = "top">
		<br />
		<br />
		<img src="images/incomeStatementMockUp.jpg" class = "top" >
		<br />
		<br />
		<img src="images/equipmentMerchMockUp.jpg" class = "top">
		<br />
		<br />
		<img src="images/bandDebtMockUp.jpg" class = "top">
		</center>



<!-- <ul> 
<?php for($i=1;$i<=5;$i++){ ?>
<li>Menu Item <?php echo $i; ?></li> 
<?php } ?>
</ul>  -->

</body>
<footer>
	
</footer>
</html>