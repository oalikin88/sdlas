<#import "parts/common.ftlh" as c>
<@c.page>

<script>
  $(document).ready(function() {
    $("#employee-select").selectize({
         create: true,
         sortField: 'text',
});
});


 </script>
<div id="wrapper">

<div class="control-group">
<#list employee>
<label for="employee-select">Выбрать работника:</label>
<select id="employee-select" class="form-select" placeholder="Выберите работника" tabindex="-1" style="display: none;">

<#items as employee>
  <option selected></option>
  <option value="${employee}">${employee}</option>
  </#items>

</select>



		
	<#else>

	<p>список пуст</p>

	</#list>
</div>

</div>
</@c.page>
