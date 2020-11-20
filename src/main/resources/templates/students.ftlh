<#import "parts/common.ftlh" as c>

<@c.page>
<form id="createGroup" name="createGroup">
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
<label>Список групп</label>
<select id="stock_id" class="form-control mb-4">
    <#list groups as group>
        <option value="/${group.id}">${group.name}</option>
    </#list>
</select>
</@c.page>