<#import "parts/common.ftlh" as c>
<#import "parts/list.ftlh" as list>
<#import "parts/backbutton.ftlh" as back>
<#global pagename = .current_template_name?keep_before(".") >
<@c.page>


<@list.list journalStorageDto journalStorageDto />

<@back.backbutton />

</@c.page>