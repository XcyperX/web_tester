<#import "parts/common.ftlh" as c>

<@c.page>
<form id="createQuestion" name="createQuestion">
    <div class="form-row">
        <label>Введите вопрос</label>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <input id="name" type="text" name="groupName" class="form-control" placeholder="Введите название теста">
        </div>
    </div>
    <div class="form-row">
        <label>Введите ответы</label>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <input class="btn btn-primary mb-4" type="button" onclick="submitNewTest()" value="Задать вопросы">
        </div>
    </div>
</form>


</@c.page>