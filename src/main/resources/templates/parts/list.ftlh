<#macro list item items>
<div class="container-fluid">
${.template_name?keep_before(".")}
<#assign emp = "" />

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

    <tr class="text-end" >
      <th>${item?index + 1}

</th>
      <td>${item.number}</td>
      <td>${item.dateRegistration}</td>
      <td>${item.type}</td>
      <td>${item.tag}</td>
      <td>${item.manufactureNumber}</td>
      <td>${item.capacity}</td>
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
<#if item.signEmployee?c == "false">
  <div class="modal-dialog modal-xl">
<#else>
<div class="modal-dialog">
</#if>
    <div class="modal-content">
      <div class="modal-header">
<#if item.signEmployee?c == "false">
        <h5 class="modal-title" id="staticBackdropLabel">

Редактировать строку:
<#else>
Редактировать примечание:
</#if>
</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
<#if item.signEmployee?c == "false">
<form method="post" action="/edit">


<div class="row mb-3">
                        <label for="number" class="col-sm-2 col-form-label">Учётный номер:</label>
                        <div class="col-sm-10">
                        <input type="hidden" name="name" value="${path}" >
                        <input type="hidden" name="storageType" value="${storageType}">
                        <input type="text" class="form-control" name="number" placeholder="Введите учётный номер" value="${item.number}" />      
                        </div>
                        </div>
                    <div class="row mb-3">
                        <label for="dateRegistration" class="col-sm-2 col-form-label">Дата постановки на учёт:</label>
                        <div class="col-sm-2">
                        <input type="date" class="col-sm-2 form-control" name="dateRegistration" value="${item.dateRegistration}"/> 
                        </div>
                        </div>
                    <div class="row mb-3">
                        <label for="type" class="col-sm-2 col-form-label">Тип носителя:</label>
                        <div class="col-sm-10">
                        <select class="form-select" name="type" aria-label="Укажите тип носителя">
                          <option selected>${item.type}</option>
                          <#if storageType == "CARD">
                          <option value="СНИ">СНИ</option>
                          <#elseif storageType == "HDD">
                          <option value="НЖМД">НЖМД</option>
                           <#else>
                           <option value="НЖМД(п)">НЖМД(п)</option>
                           <option value="DVD-R">DVD-R</option>
                           <option value="DVD-RW">DVD-RW</option>
                           <option value="CD-R">CD-R</option>
                           <option value="CD-RW">CD-RW</option>
                           <option value="МЛ">МЛ</option>
                           <option value="USB">USB</option>
                           </#if>
                        </select>
                        
                        </div>
                        </div>
                    <div class="row mb-3">
                        <label for="tag" class="col-sm-2 col-form-label">Метка категории носителя:</label>
                        <div class="col-sm-10">
                        <select class="form-select" name="tag" aria-label="Укажите метку категории носителя">
                          <option selected>${item.tag}</option>  
                          <option value="Конфиденциально">Конфиденциально</option>   
                          <option value="Ключ">Ключ</option>
                        </select>
                        </div>
                        </div>
                    <div class="row mb-3">
                        <label for="manufactureNumber" class="col-sm-2 col-form-label">Заводской или входящий номер:</label>
                        <div class="col-sm-10">
                        <input type="text" class="form-control" name="manufactureNumber" placeholder="Укажите заводской или входящий номер" value="${item.manufactureNumber}" />
                        </div>
                        </div>
                    <div class="row mb-3">
                  
                        
                        <label for="capacity" class="col-sm-2 col-form-label">Ёмкость носителя(длина ленты):</label>
                        <div class="col-sm-5">
                        <input type="text" class="form-control" name="capacity" placeholder="Укажите ёмкость носителя(длину ленты)" value="${item.capacity}" />

                        </div>
                         <div class="col-sm-5">
                        <select class="form-select" name="capacity" aria-label="Укажите откуда поступил">

                          <option selected>${item.capacity}</option>  
                          <option value="Тб">Тб</option>   
                          <option value="Гб">Гб</option>   
                          <option value="Мб">Мб</option>
                          <option value="Кб">Кб</option>
                        </select>
                        
                        </div>

                        </div>
                    <div class="row mb-3">
                        <label for="fromPlace" class="col-sm-2 col-form-label">Откуда поступил:</label>
                        <div class="col-sm-10">
                        <select class="form-select" name="fromPlace" aria-label="Укажите откуда поступил">
                          <option selected>${item.fromPlace}</option>  
                          <option value="Склад">Склад</option>   
                          <option value="Сбербанк">Сбербанк</option>
                        </select>
                        </div>
                        </div>
                    <div class="row mb-3">
                        <label for="pcNumber" class="col-sm-2 col-form-label">Инвентарный № ПК, в который установлен НЖМД:</label>
                        <div class="col-sm-10">
                        <input type="text" class="form-control" name="pcNumber" placeholder="Укажите инвентарный №" value="${item.pcNumber}" />
                        </div>
                        </div>
                    
                        <div class="row mb-3">

                       <script>
                          $(document).ready(function() {
                            $("#employee-select2").selectize({
                            create: true,
                            sortField: 'text',
                            });
                        });
                        </script>
                    
   
                        <label for="employee-select2" class="col-sm-2 col-form-label">Выбрать работника:</label>
                   
                     <#list employee >
                     
                       
                         <div class="col-sm-10">
                        <select id="employee-select2" name="employee2" class="selectized2" >
                            <option selected></option>
                        <#items as employee>
                         
                          <option value="${employee.code}">${employee.surname} ${employee.name} ${employee.middlename}</option>
                          </#items>

                        </select>

                                <#else>

                                <p>список пуст</p>

                                </#list>

                        </div>

                        </div>
                      
                        
                    <div class="row mb-3">
                        <label for="comment" class="col-sm-2 col-form-label">Примечание:</label>
                        <div class="col-sm-10">
                        <textarea class="form-control" name="comment" placeholder="Примечание"></textarea>
                        
                        </div>
                        </div>


<#else>
      <form method="post" action="/comment">
                        <input type="hidden" name="id" value="${item.id}">
                        <textarea class="form-control" name="comment" placeholder="Примечание">
<#if item.comment != "null">
${item.comment}
<#else>

   </#if>  
</textarea>
                   
     </#if>                   
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