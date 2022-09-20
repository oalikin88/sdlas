<#macro list item items>
<div class="container-fluid">

<#assign emp = "" />

<#list items >
 
<table class="table caption-top table-striped">
   
  <caption class="text-center mb-3">${title}</caption>
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

    <tr class="text-end" >
      <th>${item?index + 1}

</th>
      <td>${item.number}</td>
      <td>${item.dateRegistration}</td>
      <td>${item.type}</td>
      <td>${item.tag}</td>
      <td>${item.manufactureNumber}</td>
      <td>${item.capacity} ${item.measure}</td>
      <td>${item.fromPlace}</td>
      <td>${item.pcNumber}</td>     
      <td>${item.employee} 
<#assign emp = item.employee?keep_before(" ")>
        <#if item.signEmployee?c == "false"> <p style="color:red;">ожидается подпись</p>
        <#else>
            <p style="color:green;">подписано</p>
            ${item.dateSignEmployee!""}
        </#if>
      </td>  
      <td>
<#if item.signToBack?c == "false" && item.signEmployee?c == "true">
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#signSecurityWorker${item?index}">
 Подписать
</button>




<!-- Modal -->
<div class="modal fade" id="signSecurityWorker${item?index}" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      <form method="post" action="/sign">
       <p>${item.number}</p>
         <input type="hidden" name="sign" value="true">
         <input type="hidden" name="id" value="${item.id}">
         <input type="hidden" name="path" value="${path}">
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
<#elseif item.signEmployee?c == "false">


<#else>
            ${item.employeeSecurity}
            <p style="color:green;">подписано</p>
            ${item.getBackToSecurityUser!""}
            
</#if>
</td>
      <td>${item.registrationEndSign!""}</td>
      <td>${item.comment!""}
<button type="button" class="btn btn-link" data-bs-toggle="modal" data-bs-target="#editComment${item?index}">
 <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pen" viewBox="0 0 16 16">
  <path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z"/>
</svg>
</button>



<!-- Modal -->
<div class="modal fade" id="editComment${item?index}" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">

<div class="modal-dialog">

    <div class="modal-content">
      <div class="modal-header">

        <h5 class="modal-title" id="staticBackdropLabel">

Редактировать примечание:
</h5><button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button></div>
      <div class="modal-body">

      <form method="post" action="/comment">
                        <input type="hidden" name="id" value="${item.id}">
                        <input type="hidden" name="path" value="${path}">
                        <textarea class="form-control" name="comment" placeholder="Примечание">
<#if item.comment != "null">
${item.comment}
<#else>
   </#if>  
</textarea>                
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