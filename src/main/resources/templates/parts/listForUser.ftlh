<#macro list list items>
<div class="container-fluid">
<#list items>

<table class="table caption-top table-striped">
   
  <caption class="text-center"></caption>
  <thead class="table-light">
    <tr class="align-middle text-center">
      <th scope="col">id</th>
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
    <tr class="text-end">
      <th>${item.id}</th>
      <td>${item.number}</td>
      <td>${item.dateRegistration?date?string["dd.MM.yyyy"]}</td>
      <td>${item.type}</td>
      <td>${item.tag}</td>
      <td>${item.manufactureNumber}</td>
      <td>${item.capacity}</td>
      <td>${item.fromPlace}</td>
      <td>${item.pcNumber}</td>     
      <td>${item.user.lastName} ${item.user.firstName[0]}. ${item.user.fathersName[0]}., 
<#if item.signEmployee?c == "false">
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#sign">
 Подписать
</button>
<!-- Modal -->
<div class="modal fade" id="sign" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      <form method="post" action="/myaccount">
       <p>${item.id}</p>
         <input type="hidden" id="sign" name="sign" value="true">
         <input type="hidden" id="Id" name="Id" value="${item.id}">
      Подписать?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Отмена</button>
        <button type="submit" class="btn btn-primary">Да</button>
  </form> 
<#else>
<p style="color:green;">подписано</p>
</#if></td>  
      <td>${item.signToBack?c}</td>
      <td>${item.registrationEndSign}</td>
      <td>${item.comment}</td>     
    </tr>
</#items>
  </tbody>
</table>


<#else>

	<p>В журнале ещё нет записей</p>

	</#list>

</div>


      </div>

    </div>
  </div>
</div>
</div>
</div>

</#macro>