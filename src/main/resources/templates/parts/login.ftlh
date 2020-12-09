<#macro login>
    <div class="container">
        <div class="row">
            <div class="col-sm">
                <form id="createUser" name="createUser">
                    <div class="form-row">
                        <label>Добавить нового преподавателя</label>
                    </div>
                    <div class="form-row">
                        <label>Почта</label>
                        <input id="email" type="text" name="email" class="form-control" placeholder="Введите почту">
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
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label>Пароль</label>
                            <input id="password" type="text" name="password" class="form-control" placeholder="Введите пароль">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label>Уровень доступа</label>
                            <select id="role" class="form-control">
                                <#list roles?values as role>
                                    <option value="${role}">${role.getNameRole()}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <input class="btn btn-primary  mb-4" type="button" onclick="submitNewUser()" value="Добавить преподавателя">
                </form>
            </div>
        </div>
    </div>
</#macro>

