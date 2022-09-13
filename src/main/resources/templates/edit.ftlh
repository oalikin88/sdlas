<#import "parts/common.ftlh" as c>


<@c.page>
<div class="col text-center">
<h5 class="mt-3 mb-3" style="font-weight:bold;">Редактирование записи id=${journalStorageDto.id} журнала учёта ${journalStorageDto.type}</h5>
</div>
<div class="container-xl mt-3">

<form method="POST" action="/edit">
                    <div class="row mb-3">
                        <label for="number" class="col-sm-2 col-form-label">Учётный номер:</label>
                        <div class="col-sm-10">
                        
                        <input type="hidden" name="storageType" value="${journalStorageDto.storageType}">
                        <input type="text" class="form-control" name="number" placeholder="Введите учётный номер" value="${journalStorageDto.number}"/>      
                        </div>
                        </div>
                    <div class="row mb-3">
                        <label for="dateRegistration" class="col-sm-2 col-form-label">Дата постановки на учёт:</label>
                        <div class="col-sm-2">
                        <input type="date" id="date" class="col-sm-2 form-control" name="dateRegistration" value="${journalStorageDto.dateRegistration}" /> 
                        </div>
                        </div>
                    <div class="row mb-3">
                        <label for="type" class="col-sm-2 col-form-label">Тип носителя:</label>
                        <div class="col-sm-10">
                        <select class="form-select" name="type" aria-label="Укажите тип носителя">
                          <option selected>${journalStorageDto.type}</option>
                          <#if journalStorageDto.storageType == "CARD">
                          <option value="СНИ">СНИ</option>
                          <#elseif journalStorageDto.storageType == "HDD">
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
                          <option selected>${journalStorageDto.tag}</option>  
                          <option value="Конфиденциально">Конфиденциально</option>   
                          <option value="Ключ">Ключ</option>
                        </select>
                        </div>
                        </div>
                    <div class="row mb-3">
                        <label for="manufactureNumber" class="col-sm-2 col-form-label">Заводской или входящий номер:</label>
                        <div class="col-sm-10">
                        <input type="text" class="form-control" name="manufactureNumber" placeholder="Укажите заводской или входящий номер" value="${journalStorageDto.manufactureNumber}" />
                        </div>
                        </div>
                    <div class="row mb-3">
                  
                        
                        <label for="capacity" class="col-sm-2 col-form-label">Ёмкость носителя(длина ленты):</label>
                        <div class="col-sm-5">
                        <input type="text" class="form-control" name="capacity" placeholder="Укажите ёмкость носителя(длину ленты)" value="${journalStorageDto.capacity}" />

                        </div>
                         <div class="col-sm-5">
                        <select class="form-select" name="measure" aria-label="единица измерения">
                          <option selected>${journalStorageDto.measure}</option>  
                          <option value="Тб">Тб</option>   
                          <option value="Гб">Гб</option>   
                          <option value="Мб">Мб</option>
                          <option value="Кб">Кб</option>
                        </select>
                        
                        </div>
                        <input type="hidden" id="id" name="id" value="${journalStorageDto.id}" >
                        </div>
                    <div class="row mb-3">
                        <label for="fromPlace" class="col-sm-2 col-form-label">Откуда поступил:</label>
                        <div class="col-sm-10">
                        <select class="form-select" name="fromPlace" aria-label="Укажите откуда поступил">
                          <option selected>${journalStorageDto.fromPlace}</option>  
                          <option value="Склад">Склад</option>   
                          <option value="Сбербанк">Сбербанк</option>
                        </select>
                        </div>
                        </div>
                    <div class="row mb-3">
                        <label for="pcNumber" class="col-sm-2 col-form-label">Инвентарный № ПК, в который установлен НЖМД:</label>
                        <div class="col-sm-10">
                        <input type="text" class="form-control" name="pcNumber" placeholder="Укажите инвентарный №" value="${journalStorageDto.pcNumber}" />
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
                    <option selected value="${employeeByCode.code}">${employeeByCode.surname} ${employeeByCode.name} ${employeeByCode.middlename}</option>
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
                        <textarea class="form-control" name="comment" placeholder="Примечание">${journalStorageDto.comment}</textarea>
                        
                        </div>
                        </div>
<div class="row text-start">
<div class="col">
<button type="button" onclick="history.back();" class="btn btn-primary" data-bs-dismiss="modal">Отмена</button>
</div>
<div class="col text-center">
        <a href="/delete/${journalStorageDto.id}" class="btn btn-danger" role="button">Удалить</a>
</div>
<div class="col text-end">
        <button type="submit" class="btn btn-warning">Редактировать</button>
</div>
</div>
</div>
</@c.page>
