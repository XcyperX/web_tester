<#import "parts/common.ftlh" as c>

<@c.page>
<div class="container">
    <button class="btn btn-primary mb-2" type="button" data-toggle="collapse" data-target="#listStudents" aria-expanded="false" aria-controls="collapseExample">
        Добавление групп и студентов
    </button>
    <div class="collapse mb-2" id="listStudents">
        <div class="card card-body">
            <div class="container">
                <form id="createGroup" name="createGroup">
                    <input id="teacher_id" name="teacher_id" value="${teacher}" hidden>
                    <div class="form-row">
                        <label>Добавить группу</label>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <input id="name" type="text" name="groupName" class="form-control" placeholder="Введите название группы">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <input class="btn btn-primary mb-4" type="button" onclick="submitNewGroup()" value="Добавить группу">
                        </div>
                    </div>
                </form>
            </div>
            <div class="container">
                <form id="createStudent" name="createStudent">
                    <div class="form-row">
                        <label>Добавить студента</label>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label>Имя</label>
                            <input id="name" type="text" name="name" class="form-control" placeholder="Введите имя">
                        </div>
                        <div class="form-group col-md-6">
                            <label>Фамилия</label>
                            <input id="surname" type="text" name="surname" class="form-control" placeholder="Введите фамилию">
                        </div>
                    </div>
                    <label>Выберите группу</label>
                    <select id="group_id" class="form-control mb-4">
                        <#list groups as group>
                        <option value="${group.id}">${group.name}</option>
                    </#list>
                    </select>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <input class="btn btn-primary mb-4" type="button" onclick="submitNewStudent()" value="Добавить студента">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">Имя</th>
            <th scope="col">Фамилия</th>
            <th scope="col">Группа</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list students as student>
        <tr>
            <td>${student.name}</td>
            <td>${student.surname}</td>
            <td>
                <#list groups as group>
                <#if group.id == student.groupId>
                ${group.name}
                </#if>
                </#list>
            <td><a href="/students/${student.id}">Редактировать</a></td>
        </tr>
    </#list>
    </table>
</div>
</@c.page>