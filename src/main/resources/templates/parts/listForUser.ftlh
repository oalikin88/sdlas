<#macro list item items>
<div class="container-fluid">
<#assign index = 0>
<#list items>

<table class="table caption-top table-striped">
   
  <caption class="text-center"></caption>
  <thead class="table-light">
    <tr class="align-middle text-center">
      <th scope="col">№</th>
      <th scope="col">Учётный номер</th>
      <th scope="col">Тип носителя</th>
      <th scope="col">Метка категории носителя</th>
      <th scope="col">Заводской или входящий номер</th>
      <th scope="col">Ёмкость носителя (длина ленты)</th>
      <th scope="col">Инвентарный № ПК, в который установлен НЖМД</th>
      <th scope="col">Расписка работника о получении носителя</th>

    </tr>

  </thead>

  <tbody>
<#items as item>
<#assign index = index+1>
    <tr class="text-end">
      <th>${index}</th>
      <td>${item.number}</td>
      <td>${item.type}</td>
      <td>${item.tag}</td>
      <td>${item.manufactureNumber}</td>
      <td>${item.capacity} ${item.measure}</td>
      <td>${item.pcNumber}</td>     
      <td>${item.employee} 
<#if item.signEmployee?c == "false">
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#sign${index}" style="margin-left:15px;">
 Подписать
</button>
<!-- Modal -->
<div class="modal fade" id="sign${index}" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered text-center">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Подтвердить подпись</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      <form method="post" action="/myaccount">
       <p>Подписать устройство ${item.type} с учётным номером ${item.number}?</p>
         <input type="hidden" name="sign" value="true">
         <input type="hidden" name="id" value="${item.id}">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Отмена</button>
        <button type="submit" class="btn btn-primary">Да</button>
  </form> 
<#else>
<p style="color:green;">подписано</p>
</#if></td>  
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