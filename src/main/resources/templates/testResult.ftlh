<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="container">
        <input id="id_owner" type="hidden" name="id_owner" value="${teacher}">
        <label>Выберите группу</label>
        <select id="group_id" class="form-control mb-4">
            <option value="#"></option>
            <#list groups as group>
                <option value="${group.id}">${group.name}</option>
            </#list>
        </select>

        <label>Выберите студента</label>
        <select id="student_id" class="form-control mb-4" disabled>
        </select>

        <a class="btn btn-primary btn-block mb-2" href="/pdf/request">Сформировать отчет</a>

    </div>

    <div class="container">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">Имя</th>
                <th scope="col">Название теста</th>
                <th scope="col">Результат</th>
            </tr>
            </thead>
            <tbody id="studentResult">
                <tr>

                </tr>
        </table>
    </div>
</@c.page>