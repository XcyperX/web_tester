<#import "parts/common.ftlh" as c>
<#import "parts/updateStudents.ftlh" as us>

<@c.page>
    <div class="container">
        <button class="btn btn-primary mb-2" type="button" data-toggle="collapse" data-target="#listStudents"
                aria-expanded="false" aria-controls="collapseExample">
            Добавление групп и студентов
        </button>
        <div class="collapse mb-2" id="listStudents">
            <div class="card card-body">
                <div class="container">
                    <form id="createGroup" name="createGroup">
                        <input id="teacher_id" name="teacher_id" value="${teacher}" hidden>
                        <div class="form-group">
                            <label>Добавить группу</label>
                            <input id="name" type="text" name="groupName" class="form-control mb-2"
                                   placeholder="Введите название группы">
                            <input class="btn btn-primary mb-3" type="button" onclick="submitNewGroup()"
                                   value="Добавить группу">
                        </div>
                    </form>
                </div>
                <div class="container">
                    <form id="createStudent" name="createStudent">
                        <div class="form-group">
                            <label>Добавить студента</label>
                            <div class="form-row mb-1">
                                <div class="col">
                                    <label>Имя</label>
                                    <input id="name" type="text" name="name" class="form-control"
                                           placeholder="Введите имя">
                                </div>
                                <div class="col">
                                    <label>Фамилия</label>
                                    <input id="surname" type="text" name="surname" class="form-control"
                                           placeholder="Введите фамилию">
                                </div>
                            </div>
                            <div class="form-group mb-2">
                                <label>Выберите группу</label>
                                <select id="group_id" class="form-control">
                                    <#list groups as group>
                                        <option value="${group.id}">${group.name}</option>
                                    </#list>
                                </select>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6 mb-0">
                                    <input class="btn btn-primary" type="button" onclick="submitNewStudent()"
                                           value="Добавить студента">
                                </div>
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
                    <td>
                        <button type="button" class="btn btn-primary btn-block mb-2" data-toggle="modal"
                                data-target="#updateStudent_${student.id}">
                            Редактировать
                        </button>
                        <!-- Modal -->
                        <div class="modal fade" id="updateStudent_${student.id}" tabindex="-1" role="dialog"
                             aria-labelledby="exampleModalLabel"
                             aria-hidden="true">
                            <div class="modal-dialog modal-lg">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Редактировать
                                            студента: ${student.name} ${student.surname}</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <@us.students student=student groups=groups/>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена
                                        </button>
                                        <button type="button" class="btn btn-primary"
                                                onclick="submitUpdateStudent(${student.id})">Изменить
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </td>
                    <td>
                        <button type="button" class="btn btn-primary" onclick="deleteStudent(${student.id})">Удалить</button>
                    </td>
                </tr>
            </#list>
        </table>
    </div>
</@c.page>