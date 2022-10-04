#import "parts/common.ftlh" as c>
<@c.page>

<div class="col">
     	<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#editUser">
 Редактировать
</button>

<!-- Modal -->
<div class="modal fade" id="editUser" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered modal-xl">
    <div class="modal-content">
      <div class="modal-header text-center">
        <h5 class="modal-title w-100" id="staticBackdropLabel">Редактирование пользователя</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form method="post" action="/users">
                    
<div class="row mb-3">

                       <script>
                          $(document).ready(function() {
                            $("#employee-select").selectize({
                            create: true,
                            sortField: 'text',
                            });
                        });
                        </script>
                    
   
                        <label for="employee-select" class="col-sm-2 col-form-label">Выбрать работника:</label>
                   
                     <#list employee>
                     
                       
                         <div class="col-sm-10">
                        <select id="employee-select" name="employeeFio" class="selectized" placeholder="Выберите работника">
                        
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

      <div class="modal-footer">

        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Отмена</button>
        <button type="submit" class="btn btn-success">Добавить</button>

        </form> 
      </div>
    </div>
  </div>
</div> 
</div>


   


<table class="table caption-top table-striped">
	 <thead class="table-light">
		<tr class="align-middle text-center">
			<th scope="col">Имя</th>
			<th scope="col">Роль</th>
			<th></th>
		</tr>
	</thead>
	<tbody>


		<#list user as user>

		<tr>
			<td>${user.lastName!""} ${user.firstName[0]!""}. ${user.fathersName[0]!""}.</td>
			<td><#list user.roles as role>

${user.role}<#sep>,

</#list>


</td>
			<td><a href="users/${user.id}">Редактировать</a></td>
		</tr>

		</#list>
	</tbody>
</table>
</@c.page>
