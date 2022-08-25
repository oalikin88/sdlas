<#macro list list items>
<div class="container-fluid">
<#list items>
<table class="table caption-top table-striped">
   
  <caption class="text-center">${name}</caption>
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
      <td>${item.signEmployee?c}</td>
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

</#macro>