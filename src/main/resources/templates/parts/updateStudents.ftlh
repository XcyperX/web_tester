<#macro students student groups>
    <div class="row">
        <div class="col-sm">
            <form id="updateStudent" name="updateStudent_${student.id}">
                <input id="student_id" type="text" name="student_id"
                       value="<#if student?has_content>${student.id}</#if>" hidden>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label class="custom-label">Введите имя</label>
                        <input id="name" type="text" name="name" class="form-control"
                               placeholder="Введите имя"
                               value="<#if student?has_content>${student.name}</#if>">
                    </div>
                    <div class="form-group col-md-6">
                        <label class="custom-label">Введите фамилию</label>
                        <input id="surname" type="text" name="surname" class="form-control"
                               placeholder="Введите фамилию"
                               value="<#if student?has_content>${student.surname}</#if>">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col">
                        <label>Выберите группу</label>
                        <select id="group_id" class="form-control" name="group_id">
                            <#list groups as group>
                                <#if student?has_content>
                                    <#if group.id == student.groupId>
                                        <option value="${group.id}" selected>${group.name}</option>
                                    <#else>
                                        <option value="${group.id}">${group.name}</option>
                                    </#if>
                                <#else>
                                    <option value="${group.id}">${group.name}</option>
                                </#if>
                            </#list>
                        </select>
                    </div>
                </div>
            </form>
        </div>
    </div>
</#macro>