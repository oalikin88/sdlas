<#import "parts/common.ftlh" as c>
<@c.page>

<div class="mt-3">
  <div class="row">
    <div class="col">
     	<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addStorage">
 Добавить ключевой носитель
</button>
    </div>
    <div class="col">
      <!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#request">
  Отправить запрос на подпись
</button>
    </div>

    <div class="col">
        <!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
  Подпись в обратном приёме
</button>
    </div>

    </div>
  </div>
</div>
    
	
	<div class="mt-3">

<!-- Modal -->
<div class="modal fade" id="addStorage" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered modal-xl">
    <div class="modal-content">
      <div class="modal-header text-center">
        <h5 class="modal-title w-100" id="staticBackdropLabel">Добавление ключевого носителя в журнал</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form method="post" action="/card">
                    <div class="row mb-3">
                        <label for="number" class="col-sm-2 col-form-label">Учётный номер:</label>
                        <div class="col-sm-10">
                        <input type="text" class="form-control" name="number" placeholder="Введите учётный номер" />      
                        </div>
                        </div>
                    <div class="row mb-3">
                        <label for="dateRegistration" class="col-sm-2 col-form-label">Дата постановки на учёт:</label>
                        <div class="col-sm-2">
                        <input type="date" class="col-sm-2 form-control" name="dateRegistration" /> 
                        </div>
                        </div>
                    <div class="row mb-3">
                        <label for="type" class="col-sm-2 col-form-label">Тип носителя:</label>
                        <div class="col-sm-10">
                        <input type="text" class="form-control" name="type" placeholder="Укажите тип носителя" />
                        </div>
                        </div>
                    <div class="row mb-3">
                        <label for="tag" class="col-sm-2 col-form-label">Метка категории носителя:</label>
                        <div class="col-sm-10">
                        <input type="text" class="form-control" name="tag" placeholder="Укажите метку категории носителя" />
                        </div>
                        </div>
                    <div class="row mb-3">
                        <label for="manufactureNumber" class="col-sm-2 col-form-label">Заводской или входящий номер:</label>
                        <div class="col-sm-10">
                        <input type="text" class="form-control" name="manufactureNumber" placeholder="Укажите заводской или входящий номер" />
                        </div>
                        </div>
                    <div class="row mb-3">
                        <label for="type" class="col-sm-2 col-form-label">Ёмкость носителя(длина ленты):</label>
                        <div class="col-sm-10">
                        <input type="text" class="form-control" name="capacity" placeholder="Укажите ёмкость носителя(длину ленты)" />
                        </div>
                        </div>
                    <div class="row mb-3">
                        <label for="fromPlace" class="col-sm-2 col-form-label">Откуда поступил:</label>
                        <div class="col-sm-10">
                        <input type="text" class="form-control" name="fromPlace" placeholder="Укажите откуда поступил" />
                        </div>
                        </div>
                    <div class="row mb-3">
                        <label for="pcNumber" class="col-sm-2 col-form-label">Инвентарный № ПК, в который установлен НЖМД:</label>
                        <div class="col-sm-10">
                        <input type="text" class="form-control" name="pcNumber" placeholder="Укажите инвентарный №" />
                        </div>
                        </div>
                    <div class="row mb-3">
                        <label for="registrationEndSign" class="col-sm-2 col-form-label">Отметка о снятии с учета, номер документа:</label>
                        <div class="col-sm-10">
                        <input type="text" class="form-control" name="registrationEndSign" placeholder="Укажите номер документа" />
                        </div>
                        </div>
                    <div class="row mb-3">
                        <label for="comment" class="col-sm-2 col-form-label">Примечание:</label>
                        <div class="col-sm-10">
                        <textarea class="form-control" name="comment" placeholder="Примечание"></textarea>
                        <input type="hidden" name="name" value="card" />
                        </div>
                        </div>
                   
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Отмена</button>
        <button type="submit" class="btn btn-primary">Добавить</button>
        </form> 
      </div>
    </div>
  </div>
</div> 


</div>
<div class="mt-3">

<!-- Modal -->
<div class="modal fade" id="request" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      Request
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Understood</button>
      </div>
    </div>
  </div>
</div>
</div>
</div>


<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      wefewfewfew  ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Understood</button>
      </div>
    </div>
  </div>
</div>
</div>
</div>


<div class="container-fluid">
<#list card>
<table class="table caption-top table-striped">
   
  <caption class="text-center">Список ключевых носителей</caption>
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
      <th scope="col">Отметка о снятии с учета, номер документа</th>
      <th scope="col">Примечание</th>
    </tr>

  </thead>

  <tbody>
<#items as card>
    <tr class="text-end">

      <th>${card.id}</th>
      <td>${card.number}</td>
      <td>${card.dateRegistration?date?string["dd.MM.yyyy"]}</td>
      <td>${card.type}</td>
      <td>${card.tag}</td>
      <td>${card.manufactureNumber}</td>
      <td>${card.capacity}</td>
      <td>${card.fromPlace}</td>
      <td>${card.pcNumber}</td>
      <td>${card.registrationEndSign}</td>
      <td>${card.comment}</td>     
    </tr>
</#items>
  </tbody>
</table>
		

	<#else>

	<p>В журнале ещё нет записей</p>

	</#list>

</div>
</@c.page>
