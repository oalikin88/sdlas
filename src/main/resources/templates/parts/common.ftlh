<#macro page>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SDLAS</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<#include "navbar.ftlh">
    <script src="js/bootstrap.bundle.min.js"></script>
<div class="container-fluid">
<#nested>
</div>
<script src="js/popper.min.js"> </script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>
</#macro>
