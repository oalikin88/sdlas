<#import "parts/common.ftlh" as c>
<#global pagename = .current_template_name?keep_before(".") >
<@c.page>


<div class="container mt-3">
<div class="row">
<div class="col sm-12">

<br>
<br>
<br>
<br>
<div class="content" id="errorblock">
<h2 class="text-center">Что-то пошло не так... </h2>
<br>
<br>
<br>

<p class="text-center">Ошибка: ${exception.getMessage()}</p>
</div>
</div>
</div>
</div>

</@c.page>

