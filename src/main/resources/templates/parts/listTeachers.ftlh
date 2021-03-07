<#import "login.ftlh" as login>

<#macro teachers teachers>
    <div class="container">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">Имя</th>
                <th scope="col">Фамилия</th>
                <th scope="col">Отчество</th>
                <th scope="col">Email</th>
                <th scope="col">Пароль</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <#list teachers as teacher>
                <tr>
                    <td>${teacher.name}</td>
                    <td>${teacher.surname}</td>
                    <td>
                        <#if teacher.secondName?has_content>
                            ${teacher.secondName}
                        <#else>
                            Null
                        </#if>
                    </td>
                    <td>${teacher.email}</td>
                    <td>${teacher.password}</td>
                    <td>
                        <button type="button" class="btn btn-primary btn-block mb-2" data-toggle="modal"
                                data-target="#updateTeacher_${teacher.id}">
                            Изменить
                        </button>
                        <!-- Modal -->
                        <div class="modal fade" id="updateTeacher_${teacher.id}" tabindex="-1" role="dialog"
                             aria-labelledby="exampleModalLabel"
                             aria-hidden="true">
                            <div class="modal-dialog modal-lg">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Изменить:
                                            ${teacher.name} ${teacher.surname}</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <@login.login teacher=teacher/>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена
                                        </button>
                                        <button type="button" class="btn btn-primary"
                                                onclick="submitUpdateTeacher(${teacher.id})">Изменить
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </td>
                    <td>
                        <button type="button" class="btn btn-primary"
                                onclick="deleteTeacher(${teacher.id})">Удалить
                        </button>
                    </td>
                </tr>
            </#list>
        </table>
    </div>
</#macro>