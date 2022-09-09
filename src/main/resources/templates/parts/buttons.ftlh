<#macro buttons name path>

<div class="mt-3">
  <div class="row">
    <div class="col">
     	<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addStorage">
 Добавить ${name}
</button>
    </div>
    <div class="col">
      <!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#request">
  Отправить запрос на подпись
</button>
    </div>

    <div class="col">
 <div class="modal fade" id="exampleModalToggle" aria-hidden="true" aria-labelledby="exampleModalToggleLabel" tabindex="-1">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalToggleLabel">Modal 1</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form method="post" action="/edit">
        <div class="row mb-3">
        <label for="capacity" class="col-sm-2 col-form-label">Запись:</label>
                <div class="col-sm-10">
                        <select class="form-select" name="type" aria-label="Укажите тип носителя">
                          <option selected>Выбрать запись журнала</option>
                         <#list journalStorageDto as journalStorageDto>
                         <option value="${journalStorageDto.id}">${journalStorageDto.number}; ${journalStorageDto.manufactureNumber}; ${journalStorageDto.employee}</option>
                           <#else>
                                wfewf
                                </#list>
                        </select>
                         
                        </div>
                        </div>
      
      </div>
      <div class="modal-footer">
        <button class="btn btn-primary" data-bs-target="#exampleModalToggle2" data-bs-toggle="modal">Далее</button>

      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="exampleModalToggle2" aria-hidden="true" aria-labelledby="exampleModalToggleLabel2" tabindex="-1">
  <div class="modal-dialog modal-dialog-centered modal-xl">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalToggleLabel2">Modal 2</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">

   <div class="row mb-3">

                        <label for="number" class="col-sm-2 col-form-label">Учётный номер:</label>
                        <div class="col-sm-10">
                        <input type="hidden" name="name" value="${path}" >
                        <input type="hidden" name="storageType" value="${storageType}">
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
                        <select class="form-select" name="type" aria-label="Укажите тип носителя">
                          <option selected>Выбрать тип</option>
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
                          <option selected>Выбрать метку категории носителя</option>  
                          <option value="Конфиденциально">Конфиденциально</option>   
                          <option value="Ключ">Ключ</option>
                        </select>
                        </div>
                        </div>
                    <div class="row mb-3">
                        <label for="manufactureNumber" class="col-sm-2 col-form-label">Заводской или входящий номер:</label>
                        <div class="col-sm-10">
                        <input type="text" class="form-control" name="manufactureNumber" placeholder="Укажите заводской или входящий номер" />
                        </div>
                        </div>
                    <div class="row mb-3">
                  
                        
                        <label for="capacity" class="col-sm-2 col-form-label">Ёмкость носителя(длина ленты):</label>
                        <div class="col-sm-5">
                        <input type="text" class="form-control" name="capacity" placeholder="Укажите ёмкость носителя(длину ленты)" />

                        </div>
                         <div class="col-sm-5">
                        <select class="form-select" name="capacity" aria-label="Укажите откуда поступил">

                          <option selected></option>  
                          <option value="Тб">Тб</option>   
                          <option value="Гб">Гб</option>   
                          <option value="Мб">Мб</option>
                          <option value="Кб">Кб</option>
                        </select>
                        
                        </div>
                        <input type="hidden" id="capacity" name="capacity"  >

                        </div>
                    <div class="row mb-3">
                        <label for="fromPlace" class="col-sm-2 col-form-label">Откуда поступил:</label>
                        <div class="col-sm-10">
                        <select class="form-select" name="fromPlace" aria-label="Укажите откуда поступил">
                          <option selected>Выберите место откуда поступил носитель</option>  
                          <option value="Склад">Склад</option>   
                          <option value="Сбербанк">Сбербанк</option>
                        </select>
                        </div>
                        </div>
                    <div class="row mb-3">
                        <label for="pcNumber" class="col-sm-2 col-form-label">Инвентарный № ПК, в который установлен НЖМД:</label>
                        <div class="col-sm-10">
                        <input type="text" class="form-control" name="pcNumber" placeholder="Укажите инвентарный №" />
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
                   
                     <#list employee>
                     
                       
                         <div class="col-sm-10">
                        <select id="employee-select2" name="employee" class="selectized" placeholder="Выберите работника">

                        <#items as employee>
                          <option selected></option>
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
      </div>
      <div class="modal-footer">
        <button class="btn btn-primary" data-bs-target="#exampleModalToggle" data-bs-toggle="modal">Back to first</button>
</form>
      </div>
    </div>
  </div>
</div>
<a class="btn btn-primary" data-bs-toggle="modal" href="#exampleModalToggle" role="button">Редактировать</a>
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
        <h5 class="modal-title w-100" id="staticBackdropLabel">Добавить ${name} в журнал </h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form method="post" action="${path}">
                    <div class="row mb-3">
                        <label for="number" class="col-sm-2 col-form-label">Учётный номер:</label>
                        <div class="col-sm-10">
                        <input type="hidden" name="name" value="${path}" >
                        <input type="hidden" name="storageType" value="${storageType}">
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
                        <select class="form-select" name="type" aria-label="Укажите тип носителя">
                          <option selected>Выбрать тип</option>
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
                          <option selected>Выбрать метку категории носителя</option>  
                          <option value="Конфиденциально">Конфиденциально</option>   
                          <option value="Ключ">Ключ</option>
                        </select>
                        </div>
                        </div>
                    <div class="row mb-3">
                        <label for="manufactureNumber" class="col-sm-2 col-form-label">Заводской или входящий номер:</label>
                        <div class="col-sm-10">
                        <input type="text" class="form-control" name="manufactureNumber" placeholder="Укажите заводской или входящий номер" />
                        </div>
                        </div>
                    <div class="row mb-3">
                  
                        
                        <label for="capacity" class="col-sm-2 col-form-label">Ёмкость носителя(длина ленты):</label>
                        <div class="col-sm-5">
                        <input type="text" class="form-control" name="capacity" placeholder="Укажите ёмкость носителя(длину ленты)" />

                        </div>
                         <div class="col-sm-5">
                        <select class="form-select" name="capacity" aria-label="Укажите откуда поступил">

                          <option selected></option>  
                          <option value="Тб">Тб</option>   
                          <option value="Гб">Гб</option>   
                          <option value="Мб">Мб</option>
                          <option value="Кб">Кб</option>
                        </select>
                        
                        </div>
                        <input type="hidden" id="capacity" name="capacity"  >

                        </div>
                    <div class="row mb-3">
                        <label for="fromPlace" class="col-sm-2 col-form-label">Откуда поступил:</label>
                        <div class="col-sm-10">
                        <select class="form-select" name="fromPlace" aria-label="Укажите откуда поступил">
                          <option selected>Выберите место откуда поступил носитель</option>  
                          <option value="Склад">Склад</option>   
                          <option value="Сбербанк">Сбербанк</option>
                        </select>
                        </div>
                        </div>
                    <div class="row mb-3">
                        <label for="pcNumber" class="col-sm-2 col-form-label">Инвентарный № ПК, в который установлен НЖМД:</label>
                        <div class="col-sm-10">
                        <input type="text" class="form-control" name="pcNumber" placeholder="Укажите инвентарный №" />
                        </div>
                        </div>
                    
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
                        <select id="employee-select" name="employee" class="selectized" placeholder="Выберите работника">

                        <#items as employee>
                          <option selected></option>
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
                   
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Отмена</button>
        <button type="submit" class="btn btn-success">Добавить</button>
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



</#macro>
