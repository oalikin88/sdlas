<#macro buttons>


<div class="modal fade" id="exampleModalToggle" aria-hidden="true" aria-labelledby="exampleModalToggleLabel" tabindex="-1">
  <div class="modal-dialog modal-dialog-centered modal-xl">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalToggleLabel">Добавить ${name} в журнал</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>


      <div class="modal-body">

       <form method="post" action="${path}">
                    <div class="row mb-3">
                        <label for="number" class="col-sm-2 col-form-label">Учётный номер:</label>
                        <div class="col-sm-10">
                        <input type="hidden" name="name" value="${path}" >
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
                        <label for="employee" class="col-sm-2 col-form-label">Работник:</label>
                        <div class="col-sm-10">
                        <button class="btn btn-primary" data-bs-target="#exampleModalToggle2" data-bs-toggle="modal">Выбрать работника</button>  
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
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Отмена</button>
                                             <button type="submit" class="btn btn-primary">Добавить</button>
                                </form> 

      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="exampleModalToggle2" aria-hidden="true" aria-labelledby="exampleModalToggleLabel2" tabindex="-1">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalToggleLabel2">Modal 2</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        Hide this modal and show the first with the button below.
      </div>

      <div class="modal-footer">
        <button class="btn btn-primary" data-bs-target="#exampleModalToggle" data-bs-toggle="modal">Back to first</button>
      </div>
    </div>
  </div>
</div>


 
<a class="btn btn-primary" data-bs-toggle="modal" href="#exampleModalToggle" role="button">Добавить ${name}</a>




</#macro>