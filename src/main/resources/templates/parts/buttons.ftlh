<#macro buttons name path>

<script>
 jQuery(function($){
                            $("#number").mask("999.99-999999",{placeholder:""});
                            
                         });
</script>
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
        <form method="post" class="needs-validation" action="${path}" novalidate>
                    <div class="row mb-3">
                        <label for="number" class="col-sm-4 col-form-label">Учётный номер:</label>
                        <div class="col-sm-8">
                        <input type="hidden" name="name" value="${path}" >
                        <input type="hidden" name="storageType" value="${storageType}">
                        <input type="text" id="number" class="col-sm-8 form-control" name="number" placeholder="Введите учётный номер" required />      
                         <div class="invalid-feedback">
                          Вы не ввели учётный номер
                        </div>
                        </div>
                        </div>
                    <div class="row mb-3">
                        <label for="dateRegistration" class="col-sm-4 col-form-label">Дата постановки на учёт:</label>
                        <div class="col-sm-2">
                        <input type="date" class="col-sm-8 form-control" name="dateRegistration" required /> 
                          <div class="invalid-feedback">
                          Вы не указади дату постановки на учёт
                        </div>
                        </div>
                        </div>
                    <div class="row mb-3">
                        <label for="type" class="col-sm-4 col-form-label">Тип носителя:</label>
                        <div class="col-sm-8">
                        <select class="form-select col-sm-8" name="type" aria-label="Укажите тип носителя"   required>
                          <option selected disabled value="">Выбрать тип</option>
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
                       <div class="invalid-feedback">
                          Вы не указали тип носителя
                        </div>

                        </div>
                       
                        </div>
                        
                    <div class="row mb-3">
                        <label for="tag" class="col-sm-4 col-form-label">Метка категории носителя:</label>
                        <div class="col-sm-8">
                        <select class="form-select col-sm-8" name="tag" aria-label="Укажите метку категории носителя" required>
                          <option selected disabled value="">Выбрать метку категории носителя</option>  
                          <option value="Конфиденциально">Конфиденциально</option>   
                          <option value="Ключ">Ключ</option>
                        </select>
                         <div class="invalid-feedback">
                          Вы не указали метку категории носителя
                        </div>

                        </div>
                        </div>
                    <div class="row mb-3">
                        <label for="manufactureNumber" class="col-sm-4 col-form-label">Заводской или входящий номер:</label>
                        <div class="col-sm-8">
                        <input type="text" class="form-control col-sm-8" name="manufactureNumber" placeholder="Укажите заводской или входящий номер" required />
                        <div class="invalid-feedback">
                          Вы не указали заводской или входящий номер
                        </div>
                        </div>
                        </div>
                    <div class="row mb-3">
                  
                        
                        <label for="capacity" class="col-sm-4 col-form-label">Ёмкость носителя(длина ленты):</label>
                        <div class="col-sm-4">
                        <input type="text" class="form-control" name="capacity" placeholder="Укажите ёмкость носителя(длину ленты)" required/>
                        <div class="invalid-feedback">
                          Вы не задали ёмкость носителя
                        </div>
                        </div>
                         <div class="col-sm-4">
                        <select class="form-select" name="measure" aria-label="единица измерения" placeholder="Единица измерения" required>

                          <option selected disabled value="">Единица измерения</option>  
                          <option value="Тб">Тб</option>   
                          <option value="Гб">Гб</option>   
                          <option value="Мб">Мб</option>
                          <option value="Кб">Кб</option>
                        </select>
                         <div class="invalid-feedback">
                          Вы не указали единицу измерения
                        </div>
                        </div>

                        </div>
                    <div class="row mb-3">
                        <label for="fromPlace" class="col-sm-4 col-form-label">Откуда поступил:</label>
                        <div class="col-sm-8">
                        <select class="form-select" name="fromPlace" aria-label="Укажите откуда поступил" required >
                          <option selected disabled value="">Выберите место откуда поступил носитель</option>  
                          <option value="Склад">Склад</option>   
                          <option value="Сбербанк">Сбербанк</option>
                        </select>
                         <div class="invalid-feedback">
                          Вы не указали откуда поступил носитель
                        </div>
                        </div>
                        </div>
                    <div class="row mb-3">
                        <label for="pcNumber" class="col-sm-4 col-form-label">Инвентарный № ПК, в который установлен НЖМД:</label>
                        <div class="col-sm-8">
                        <input type="text" class="form-control" name="pcNumber" placeholder="Укажите инвентарный №" required />
                        <div class="invalid-feedback">
                          Вы не указали инвентарный номер
                        </div>
                        </div>
                        </div>
                    
                        <div class="row mb-3">

                      
                    
   
                        <label for="employee-select" class="col-sm-4 col-form-label">Выбрать работника:</label>
                   
                     <#list employee>
                         <div class="col-sm-8" >
                        <select id="employee-select" name="employee" class="selectized" placeholder="Выберите работника" required>
                          <option selected disabled value="">Выбрать работника</option>
                            <#items as employee>
                          <option value="${employee.code}">${employee.surname} ${employee.name} ${employee.middlename}</option>
                          </#items>

                        </select>
                          <div class="invalid-feedback">
                          Вы не выбрали работника
                        </div>
                     
                                <#else>

                                <p>список пуст</p>

                                </#list>

                      

                        </div>

                        </div>
                    
                        
                    <div class="row mb-3">
                        <label for="comment" class="col-sm-4 col-form-label">Примечание:</label>
                        <div class="col-sm-8">
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

                        <script>

                        

                          $(document).ready(function() {  
                            
                           //var select = document.querySelector("#employee-select");
                           //var attrs = select.attributes;
                           //var reqAttr = document.createAttribute('required');

                           //attrs.setNamedItem(reqAttr);


                            $("#employee-select").selectize({    
                            sortField: 'text',
                            highlight: true
                            });
                            
                        });
                        $(".needs-validation").validate({ 
                             ignore: ':hidden:not([class~=selectized]),:hidden > .selectized, .selectize-control .selectize-input input',
                             rules: {
                                 employee-select: {
                                     required: true
                                     
                                  }
                               }

                          }); 

                  
                          
</script>

</#macro>
