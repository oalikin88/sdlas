<#macro page>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>
${name!"Главное меню"}
</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/selectize.min.js"></script>


<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/selectize.bootstrap5.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
<#include "navbar.ftlh">
<div class="container-fluid">
<#nested>
</div>

<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>
</#macro>
