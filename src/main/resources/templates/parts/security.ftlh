<#assign
    known = Session.SPRING_SECURITY_CONTEXT??
    isAdmin = false
    isOwner = false
>

<#if known>
    <#assign
        teacher = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = teacher.getTeacherName()
        role = teacher.getTeacherRole()
        isAdmin = teacher.isAdmin()
    >
<#else>
    <#assign
        name = "unknown"
        role = "unknown"
        isAdmin = false
    >
</#if>

<#if known>
    <#assign
        teacher = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = teacher.getTeacherName()
        role = teacher.getTeacherRole()
        isOwner = teacher.isOwner()
    >
<#else>
    <#assign
        name = "unknown"
        role = "unknown"
        isOwner = false
    >
</#if>
