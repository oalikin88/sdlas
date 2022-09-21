<#import "parts/common.ftlh" as c>
<#import "parts/list.ftlh" as list>
<#import "parts/buttons.ftlh" as buttons>

<@c.page>



<@list.list journalStorageDto journalStorageDto />
<@buttons.buttons name path />
</@c.page>
