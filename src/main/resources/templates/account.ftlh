<#import "parts/common.ftlh" as c>
<#import "parts/listForUser.ftlh" as l>
<#global pagename = .current_template_name?keep_before(".") >
<@c.page>


<@l.list journalStorageDto journalStorageDto />




</@c.page>
