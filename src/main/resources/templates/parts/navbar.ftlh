<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #0059a9">
<#assign principal = "041-000-4601" />
  <div class="container-fluid">
   <#if person.orgCode != principal>
     <a class="navbar-brand" href="/myaccount">
    <img src="img/pfr.svg" width="50" alt="ПФР">
     </a>   
        <#else>
    <a class="navbar-brand" href="/main">
    <img src="img/pfr.svg" width="50" alt="ПФР">
 </a>
  </#if>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon">


</span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link text-white" aria-current="page" href="/myaccount">Личный кабинет</a>
        </li>
        <#if person.orgCode != principal>
        
        <#else>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Журналы
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="/ngmd">Журнал учёта НЖМД</a></li>
            <li><a class="dropdown-item" href="/card">Журнал учёта ключевых носителей</a></li>
            <li><a class="dropdown-item" href="/usb">Журнал учёта USB, CD, DVD</a></li>
            <li><a class="dropdown-item" href="/usb">Журнал выдачи парольной документации</a></li>
            <li><a class="dropdown-item" href="/usb">Журнал учёта средств защиты информации от несанкционированного доступа</a></li>
            <li><a class="dropdown-item" href="/usb">Журнал смены парольной документации от эксплуатируемого оборудования</a></li>
            <li><a class="dropdown-item" href="/usb">Журнал учёта опечатывания аппаратных средств</a></li>
            <li><a class="dropdown-item" href="/usb">Журнал учёта ....</a></li>
            <li><a class="dropdown-item" href="/usb">Журнал учёта ....</a></li>
            
          </ul>
        </li>
      
      </ul>
      <form class="d-flex" method="GET" action="/search">
        <input class="form-control me-2" type="search" name="request" placeholder="Поиск" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Поиск</button>
      </form>
    </div>
</#if>
  </div>

</nav>
