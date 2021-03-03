<#import "listStudents.ftlh" as ls>
<#macro login teacher>
    <div class="container">
        <div class="row">
            <div class="col-sm">
                <#if teacher?has_content>
                <form id="updateTeacher_${teacher.id}" name="updateTeacher_${teacher.id}">
                <#else>
                <form id="createUser" name="createUser">
                    </#if>
                    <input id="teacher_id" type="text" name="teacher_id"
                           value="<#if teacher?has_content>${teacher.id}</#if>" hidden>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label>Имя</label>
                            <input id="name" type="text" name="name" class="form-control" placeholder="Введите имя"
                                   value="<#if teacher?has_content>${teacher.name}</#if>">
                        </div>
                        <div class="form-group col-md-6">
                            <label>Фамилия</label>
                            <input id="surname" type="text" name="surname" class="form-control"
                                   placeholder="Введите фамилию"
                                   value="<#if teacher?has_content>${teacher.surname}</#if>">
                        </div>
                    </div>
                    <div class="modal-header pl-0 pb-0 pt-0 mb-2">
                        <h5 class="modal-title" id="exampleModalLabel">Данные для входа</h5>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label class="custom-label">Введите email</label>
                            <input id="email" type="text" name="email" class="form-control"
                                   placeholder="Введите email"
                                   value="<#if teacher?has_content>${teacher.email}</#if>">
                        </div>
                        <div class="form-group col-md-6">
                            <label class="custom-label">Введите пароль</label>
                            <input id="password" type="text" name="password" class="form-control"
                                   placeholder="Введите пароль"
                                   value="<#if teacher?has_content>${teacher.password}</#if>">
                        </div>
                    </div>
                        <div class="form-group">
                            <label>Уровень доступа</label>
                            <select id="role" class="form-control">
                                <#list roles?values as role>
                                    <#if teacher?has_content>
                                        <#if role == teacher.role>
                                            <option value="${role}" selected>${role.getNameRole()}</option>
                                        <#else>
                                            <option value="${role}">${role.getNameRole()}</option>
                                        </#if>
                                    <#else>
                                        <option value="${role}">${role.getNameRole()}</option>
                                    </#if>
                                </#list>
                            </select>
                        </div>
                </form>
            </div>
        </div>
    </div>
</#macro>

