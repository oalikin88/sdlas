<#import "parts/common.ftlh" as c>
<#import "parts/list.ftlh" as list>
<#import "parts/buttons.ftlh" as buttons>


<@c.page>

<@buttons.buttons name path />


<@list.list journalStorageDto journalStorageDto />

</@c.page>
