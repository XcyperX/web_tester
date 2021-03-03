<#import "parts/common.ftlh" as c>

<@c.page>
<form action="/login" method="post">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label>Логин</label>
            <input type="text" name="username" class="form-control" placeholder="Введите логин">
        </div>
        <div class="form-group col-md-6">
            <label>Пароль</label>
            <input type="password" name="password" class="form-control" placeholder="Введите пароль">
        </div>
    </div>
    <input class="btn btn-primary  mb-4" type="submit" value="Войти">
</form>
</@c.page>

