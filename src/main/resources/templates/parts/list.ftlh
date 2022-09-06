<#macro list item items>
<div class="container-fluid">
<#assign index = 0>
<#list items >
 
<table class="table caption-top table-striped">
   
  <caption class="text-center">${name}</caption>
  <thead class="table-light">
    <tr class="align-middle text-center">
      <th scope="col">№</th>
      <th scope="col">Учётный номер</th>
      <th scope="col">Дата постановки на учёт</th>
      <th scope="col">Тип носителя</th>
      <th scope="col">Метка категории носителя</th>
      <th scope="col">Заводской или входящий номер</th>
      <th scope="col">Ёмкость носителя (длина ленты)</th>
      <th scope="col">Откуда поступил</th>
      <th scope="col">Инвентарный № ПК, в который установлен НЖМД</th>
      <th scope="col">Расписка работника о получении носителя</th>
      <th scope="col">Расписка в обратном приеме</th>
      <th scope="col">Отметка о снятии с учета, номер документа</th>
      <th scope="col">Примечание</th>
    </tr>

  </thead>

  <tbody>
<#items as item>
<#assign index = index+1>
    <tr class="text-end">
      <th>${index}</th>
      <td>${item.storage.number}</td>
      <td>${item.storage.dateRegistration?date?string["dd.MM.yyyy"]}</td>
      <td>${item.storage.type}</td>
      <td>${item.storage.tag}</td>
      <td>${item.storage.manufactureNumber}</td>
      <td>${item.storage.capacity}</td>
      <td>${item.storage.fromPlace}</td>
      <td>${item.storage.pcNumber}</td>     
      <td>${item.employee.lastName} ${item.employee.firstName[0]}. ${item.employee.fathersName[0]}.,
        <#if item.signEmployee?c == "false"> <p style="color:red;">ожидается подпись</p>
        <#else>
            <p style="color:green;">подписано</p>
            ${item.dateSignEmployee?string["dd.MM.yyyy в HH:mm"]}
        </#if>
      </td>  
      <td>
<#if item.signToBack?c == "false">
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#signSecurityWorker${index}">
 Подписать
</button>


<!-- Modal -->
<div class="modal fade" id="signSecurityWorker${index}" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      <form method="post" action="/sign">
       <p>${item.storage.number}</p>
         <input type="hidden" name="sign" value="true">
         <input type="hidden" name="Id" value="${item.id}">
            <div class="row mb-3">
                        <label for="registrationEndSign" class="col col-form-label">Отметка о снятии с учета, номер документа:</label>
                        <div class="col">
                        <input type="text" class="form-control" name="registrationEndSign" placeholder="Укажите номер документа" />
                        </div>
                        </div>
      Подписать?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Отмена</button>
        <button type="submit" class="btn btn-primary">Да</button>
  </form> 
<#else>
            ${item.securityEmployee.lastName} ${item.securityEmployee.firstName[0]}. ${item.securityEmployee.fathersName[0]}.,
            <p style="color:green;">подписано</p>
            ${item.getBackToSecurityUser?string["dd.MM.yyyy в HH:mm"]}
            
</#if>
</td>
      <td>${item.registrationEndSign!}</td>
      <td>${item.comment}
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#editComment${index}">
 Редактировать
</button>


<!-- Modal -->
<div class="modal fade" id="editComment${index}" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      <form method="post" action="/sign">
       <p>${item.storage.number}</p>
         <input type="hidden" name="sign" value="true">
         <input type="hidden" name="Id" value="${item.id}">
            <div class="row mb-3">
                        <label for="registrationEndSign" class="col col-form-label">Отметка о снятии с учета, номер документа:</label>
                        <div class="col">
                        <input type="text" class="form-control" name="registrationEndSign" placeholder="Укажите номер документа" />
                        </div>
                        </div>
      Подписать?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Отмена</button>
        <button type="submit" class="btn btn-primary">Да</button>
  </form> 

</td>     
    </tr>
</#items>
  </tbody>
</table>
		

	<#else>

	<p>В журнале ещё нет записей</p>

	</#list>

</div>

</#macro>