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
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#edit">
  Редактировать
</button>
    </div>

   

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
                        <select class="form-select" name="measure" aria-label="единица измерения" placeholder="Единица измерения">

                          <option selected>Единица измерения</option>  
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
<div class="modal fade" id="edit" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Выберите запись в журнале</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">

      <form method="GET" action="/edit">
 
      <select class="form-select" name ="id" aria-label="Default select example">

  <option selected>Выберите запись в журнале</option>
<#list journalStorageDtoFilter as journal>
<option value="${journal.id}">${journal.number}, ${journal.employee}</option>

<#else>
Отсутствуют записи в журнале, которые возможно редактировать  
   </#list>  
</select>

 </div>

      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Отмена</button>
        <button type="submit" class="btn btn-primary">Редактировать</button>
       </form>
      </div>
    </div>
  </div>
</div>
</div>
</div>



</#macro>
