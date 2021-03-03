<#import "login.ftlh" as login>

<#macro students students groups>
    <div class="container">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">Имя</th>
                <th scope="col">Фамилия</th>
                <th scope="col">Группа</th>
            </tr>
            </thead>
            <tbody>
            <#list students as student>
                <tr>
                    <td>${student.name}</td>
                    <td>${student.surname}</td>
                    <td>
                        <#list groups as group>
                            <#if group == student.groupId>
                                ${group.name}
                            <#else>
                                Null
                            </#if>
                        </#list>
                    </td>
                </tr>
            </#list>
        </table>
    </div>
</#macro>